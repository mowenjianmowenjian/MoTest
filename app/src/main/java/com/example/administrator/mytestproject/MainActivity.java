package com.example.administrator.mytestproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainActivity self;
    private TextView     mMainTopClick;
    private LinearLayout mMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;
        initView();

    }

    private void initView() {

        mMainTopClick = (TextView) findViewById(R.id.main_top_click);
        mMainTopClick.setOnClickListener(this);
        mMainContainer = (LinearLayout) findViewById(R.id.main_container);
        mMainContainer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case   R.id.main_top_click:
              new  ShowDialog(self).show();

            break;
        }
    }
}
