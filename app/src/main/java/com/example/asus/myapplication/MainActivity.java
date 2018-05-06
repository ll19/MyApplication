package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =findViewById(R.id.button);
        Button button2 =findViewById(R.id.button2);
        Button button3 =findViewById(R.id.button3);
        Button button4 =findViewById(R.id.button4);
        Button button7 =findViewById(R.id.button7);
        //给button设置监听器；
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo) {
                //实现跳转
                Intent intent =new Intent(MainActivity.this,factivity.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo1) {
                //实现跳转
                Intent intent =new Intent(MainActivity.this,seactivity.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo2) {
                //实现跳转
                Intent intent =new Intent(MainActivity.this,tactivity.class);
                startActivity(intent);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo3) {
                //实现跳转
                Intent intent =new Intent(MainActivity.this,foactivity.class);
                startActivity(intent);

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argo4) {
                //实现跳转
                Intent intent =new Intent(MainActivity.this,wactivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}