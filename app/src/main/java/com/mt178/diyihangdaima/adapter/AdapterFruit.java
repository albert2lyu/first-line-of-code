package com.mt178.diyihangdaima.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.domain.Fruit;

import java.util.List;

/**
 * Created by llh on 2015/3/16.
 */
public class AdapterFruit extends ArrayAdapter<Fruit> {
    private int resourceId;

    public AdapterFruit(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);//获取当前的fruit实例
        View view;
        ViewHoder viewHoder;
        if (convertView == null) {
            viewHoder = new ViewHoder();
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHoder.ivFruit = (ImageView) view.findViewById(R.id.iv_fruit);
            viewHoder.tvFruit = (TextView) view.findViewById(R.id.tv_fruit);
            view.setTag(viewHoder);
        } else {
            view = convertView;
            viewHoder= (ViewHoder) view.getTag();
        }
        viewHoder.ivFruit.setImageResource(fruit.getImageId());
        viewHoder.tvFruit.setText(fruit.getName());

        return view;
    }

    class ViewHoder {
        ImageView ivFruit;
        TextView tvFruit;
    }
}
