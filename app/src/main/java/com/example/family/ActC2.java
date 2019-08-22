package com.example.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
<<<<<<< HEAD

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
=======
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
  private Button bt2;
  private Button bt3;
  private TextView responseText;
>>>>>>> 14e019b81e8b85496dbcd63be03792b4d1e014f7

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fifth);
    bt1 = findViewById(R.id.fifthbutton1);
    bt2 = findViewById(R.id.fifthbutton2);
    bt3 = findViewById(R.id.fifthbutton3);
    bt1.setOnClickListener(this);
    bt2.setOnClickListener(this);
    bt3.setOnClickListener(this);
    responseText = findViewById(R.id.fifthtext1);

<<<<<<< HEAD
public class ActC2 extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        mContext = this;
        bt1 = findViewById(R.id.button2);
        bt1.setOnClickListener(this);
=======
    savefile();
    webviewPlay();
  }

  private void webviewPlay() {
    WebView wb1 = findViewById(R.id.wv1);
    wb1.getSettings().setJavaScriptEnabled(true);
    wb1.setWebViewClient(new WebViewClient());
    wb1.loadUrl("http://www.google.com");
  }
>>>>>>> 14e019b81e8b85496dbcd63be03792b4d1e014f7

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

<<<<<<< HEAD
    @Override
    public void onClick(View view) {
        new Thread() {
            @Override
            public void run() {
                try {
                    acceptServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    private void acceptServer() throws IOException {
        //1.创建客户端Socket，指定服务器地址和端口
        Socket socket = new Socket("192.168.1.9", 12345);
        //2.获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
        //获取客户端的IP地址
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        pw.write("客户端：~" + ip + "~ 接入服务器！！");
        pw.flush();
        socket.shutdownOutput();//关闭输出流
        socket.close();
    }

    private void webviewPlay() {
        WebView wb1 = findViewById(R.id.wv1);
        wb1.getSettings().setJavaScriptEnabled(true);
        wb1.setWebViewClient(new WebViewClient());
        wb1.loadUrl("http://www.google.com");
=======
  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.fifthbutton1:
        sendRequestWithHttpURLConnection();
        break;
      case R.id.fifthbutton2:
        Intent startintent = new Intent(this, MyService1.class);
        startService(startintent);
        break;
      case R.id.fifthbutton3:
        Intent stopintent = new Intent(this, MyService1.class);
        stopService(stopintent);
        break;
      default:
        break;
>>>>>>> 14e019b81e8b85496dbcd63be03792b4d1e014f7
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
