package com.mt178.diyihangdaima.frag;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.adapter.AdapterNews;
import com.mt178.diyihangdaima.atys.AtyNewsContent;
import com.mt178.diyihangdaima.domain.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llh on 2015/3/17.
 */
public class FragNewsTitle extends Fragment {
    private View view;
    private AdapterNews adapterNews;
    private List listNewsTitle;
    private ListView lvTitle;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listNewsTitle= new ArrayList<News>();
        listNewsTitle = getList();
        adapterNews = new AdapterNews(getActivity(), R.layout.item_news, listNewsTitle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = LayoutInflater.from(getActivity()).inflate(R.layout.flag_news_list, container, false);
        lvTitle = (ListView) view.findViewById(R.id.lv_news_title);
        lvTitle.setAdapter(adapterNews);
        lvTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news= (News) listNewsTitle.get(position);
                Log.d("FragNewsTitle",news.getTitle());
                AtyNewsContent.actionStart(getActivity(),news.getTitle(),news.getContent());
            }
        });
        return view;
    }

    public List<News> getList() {
        List listNewsTitle = new ArrayList<News>();
        News new1 = new News("今天是晴天", "常德多云转雨");
        News new2 = new News("好开心", "今天中了500万");
        News new3 = new News("买了6plus", "今天中了500万");

        listNewsTitle.add(new1);
        listNewsTitle.add(new2);
        listNewsTitle.add(new3);
        return listNewsTitle;
    }

}
