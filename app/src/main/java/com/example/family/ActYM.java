package com.example.family;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActYM extends Activity implements View.OnClickListener {


    private Button bt;
    private Button bt2;
    private Context mContext;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private AlertDialog.Builder builder2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mContext = this;
        setButton();
    }

    private void setButton() {
        bt = findViewById(R.id.maobutton);
        bt.setOnClickListener(this);
        bt2 = findViewById(R.id.maobutton2);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.maobutton:
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                builder.setIcon(R.mipmap.img22);
                builder.setTitle("你可以自由选择");
                builder.setNegativeButton("不帅", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "谢谢你觉得他非常帅", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("很帅", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "再次谢谢你确认他很帅", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("一般", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "别按了，我知道你觉得他很帅", Toast.LENGTH_SHORT).show();
                    }
                });
                alert = builder.create();
                alert.show();
                break;

            case R.id.maobutton2:
                final String[] menu = new String[]{
                        "古天乐没他帅", "他比古天乐帅得多", "古天乐比他差远了", "没有可比性啊"
                };
                final boolean[] checkItems = new boolean[]{false, false, false, false};
                alert = null;
                builder2 = new AlertDialog.Builder(mContext);
                builder2.setCancelable(true);
                builder2.setIcon(R.mipmap.img22);
                builder2.setTitle("你同样可以自由选择， 哦， 对了这是多选");
                builder2.setMultiChoiceItems(menu, checkItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                checkItems[i] = b;
                            }
                        });

                builder2.setPositiveButton("谢谢你的配合", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "我也这么认为！！！", Toast.LENGTH_SHORT).show();
                    }
                });

                alert = builder2.create();
                alert.show();
                break;
        }

    }
}
