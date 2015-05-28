package com.mt178.diyihangdaima.frag;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mt178.diyihangdaima.R;

/**
 * Created by llh on 2015/3/17.
 */
public class FragNewsContent extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.aty_news_content, container, false);
        return view;
    }

    public void refresh(String title, String content) {
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout_visible);
        layout.setVisibility(View.VISIBLE);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_news_title);
        TextView tvContent = (TextView) view.findViewById(R.id.tv_news_content);
        tvTitle.setText(title);
        tvContent.setText(content);
    }
}
