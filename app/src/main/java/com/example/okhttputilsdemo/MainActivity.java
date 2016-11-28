package com.example.okhttputilsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        new Thread(new Runnable() {

            @Override
            public void run() {
                OkHttp.getAsync("http://lib.suning.com/app/redbaby/80000_5.0.0-476.json", new OkHttp.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {
                        System.out.print(request.body().toString()+"***********");
                    }

                    @Override
                    public void requestSuccess(final String result) throws Exception {
                        System.out.print(result+"99999999999");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(result);
                            }
                        });
                    }
                });


            }
        }).run();


    }
}
