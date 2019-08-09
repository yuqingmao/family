package com.example.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class ActC2 extends Activity {
    public int weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        savefile();
    }
    private void savefile(){
        String data = "Maomaoyu love xiaoyu " +
                "";
        FileOutputStream out;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                if (writer != null) writer.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
