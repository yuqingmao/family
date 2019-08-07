package com.example.family;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class HomeMembers extends AppCompatActivity {

    private String[] data = {"香奈儿", "迪奥", "爱马仕", "LV", "劳斯莱斯", "宾利"};

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

//        setContentView(R.layout.activity_home_members);

        //create button
        Button bt1 = new Button(this);
        bt1.setText("我是动态添加按钮第一号");

        //create a LayoutParams, lp1 is serving the view of bt1
        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, -2);
        lp1.addRule(RelativeLayout.CENTER_IN_PARENT);

        //create a inflater
        LayoutInflater inflater = LayoutInflater.from(this);

        //find layout instance from inflater
        View cur = inflater.inflate(R.layout.activity_home_members, null);
        RelativeLayout rly = cur.findViewById(R.id.homes);

//        RelativeLayout rly = findViewById(R.id.homes);
        rly.addView(bt1, lp1);

        setContentView(rly);
        setupLV();
    }

    private void setupLV() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data);
        ListView listview = findViewById(R.id.lv1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cur = data[position];
                Toast.makeText(mContext, cur+" - OK, 不过买不起！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
