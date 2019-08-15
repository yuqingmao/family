package com.example.family;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class ActC2 extends AppCompatActivity implements View.OnClickListener {

  private Button bt1;
  private TextView responseText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fifth);
    bt1 = findViewById(R.id.fifthbutton1);
    bt1.setOnClickListener(this);
    responseText = findViewById(R.id.fifthtext1);

    savefile();
    webviewPlay();
  }

  private void webviewPlay() {
    WebView wb1 = findViewById(R.id.wv1);
    wb1.getSettings().setJavaScriptEnabled(true);
    wb1.setWebViewClient(new WebViewClient());
    wb1.loadUrl("http://www.google.com");
  }

  private void savefile() {
    String data = "Maomaoyu love xiaoyu " +
        "";
    FileOutputStream out;
    BufferedWriter writer = null;
    try {
      out = openFileOutput("data", Context.MODE_PRIVATE);
      writer = new BufferedWriter(new OutputStreamWriter(out));
      writer.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void onClick(View view) {
    if (view.getId() == R.id.fifthbutton1) {
      sendRequestWithHttpURLConnection();
    }
  }

  private void sendRequestWithHttpURLConnection() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
          URL url = new URL("http://www.google.com");
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
          connection.setConnectTimeout(8000);
          connection.setReadTimeout(8000);
          InputStream in = connection.getInputStream();
          reader = new BufferedReader(new InputStreamReader(in));
          StringBuilder response = new StringBuilder();
          String line;
          while ((line = reader.readLine()) != null) {
            response.append(line);
          }
          showResponse(response.toString());
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (reader != null) {
            try {
              reader.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
          if (connection != null) {
            connection.disconnect();
          }
        }
      }
    }).start();
  }

  private void showResponse(final String response) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        responseText.setText(response);
      }
    });
  }
}
