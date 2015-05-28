package com.mt178.diyihangdaima.atys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.mt178.diyihangdaima.tools.BaseActivity;
import com.mt178.diyihangdaima.R;


public class AtySeconed extends BaseActivity {
    private Button bt_back;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "返回的数据");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aty_seconed);
        bt_back = (Button) findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "返回的数据");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
