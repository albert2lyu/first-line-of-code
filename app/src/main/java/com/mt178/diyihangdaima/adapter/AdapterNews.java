package com.mt178.diyihangdaima.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.domain.News;

import java.util.List;

/**
 * Created by llh on 2015/3/17.
 */
public class AdapterNews extends ArrayAdapter<News> {
    private int resourceId;

    public AdapterNews(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news=getItem(position);
        View view;
        ViewHoder viewHoder;
        if (convertView == null) {
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
             viewHoder=new ViewHoder();
            viewHoder.tvNewsTitle= (TextView) view.findViewById(R.id.tv_news_title);
            view.setTag(viewHoder);
        } else {
            view=convertView;
            viewHoder= (ViewHoder) view.getTag();
        }
        viewHoder.tvNewsTitle.setText(news.getTitle());
        return view;
    }
    class ViewHoder
    {
        TextView tvNewsTitle;
    }
}
