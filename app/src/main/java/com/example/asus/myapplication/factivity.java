package com.example.asus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * Created by asus on 2018/5/5.
 */

public class factivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);   //实现跳转；
        Button bn1=findViewById(R.id.bn1);
        Button bn2=findViewById(R.id.bn2);
        Button bn3=findViewById(R.id.bn3);
        Button bn4=findViewById(R.id.bn4);

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo) {
                //实现跳转
                Intent intent =new Intent(factivity.this,shuiping.class);
                startActivity(intent);
            }
        });
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo) {
                //实现跳转
                Intent intent =new Intent(factivity.this,chuizhi.class);
                startActivity(intent);
            }
        });
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo) {
                //实现跳转
                Intent intent =new Intent(factivity.this,kaozuo.class);
                startActivity(intent);
            }
        });

    }
    }

