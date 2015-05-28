package com.mt178.diyihangdaima.atys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mt178.diyihangdaima.tools.BaseActivity;
import com.mt178.diyihangdaima.R;

/**
 * Created by llh on 2015/3/17.
 */
public class AtyNewsContent extends BaseActivity {
    private TextView tvTitle;
    private TextView tvContent;
    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, AtyNewsContent.class);
        intent.putExtra("newsTitle", newsTitle);
        intent.putExtra("newsContent", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_news_content);
        String title = getIntent().getStringExtra("newsTitle");
        String content = getIntent().getStringExtra("newsContent");

        tvTitle= (TextView) findViewById(R.id.tv_news_title);
        tvContent= (TextView) findViewById(R.id.tv_news_content);

        tvTitle.setText(title);
        tvContent.setText(content);
    }
}
