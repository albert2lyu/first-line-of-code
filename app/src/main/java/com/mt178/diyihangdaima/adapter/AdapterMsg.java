package com.mt178.diyihangdaima.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.domain.Msg;

import java.util.List;

/**
 * Created by llh on 2015/3/16.
 */
public class AdapterMsg extends ArrayAdapter<Msg> {
    private int resourceId;

    public AdapterMsg(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        View view;
        ViewHoder viewHoder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHoder = new ViewHoder();
            viewHoder.layoutLeft = (LinearLayout) view.findViewById(R.id.layout_left);
            viewHoder.layoutRight = (LinearLayout) view.findViewById(R.id.layout_right);
            viewHoder.tvLeft = (TextView) view.findViewById(R.id.tv_left);
            viewHoder.tvRight = (TextView) view.findViewById(R.id.tv_right);
            view.setTag(viewHoder);

        } else {
            view = convertView;
            viewHoder = (ViewHoder) view.getTag();
        }
        if (msg.getType() == Msg.TYPE_RECEVED) {
            viewHoder.layoutLeft.setVisibility(View.VISIBLE);
            viewHoder.layoutRight.setVisibility(View.GONE);
            viewHoder.tvLeft.setText(msg.getContent());
        } else if(msg.getType()==Msg.TYPE_SEND) {
            viewHoder.layoutRight.setVisibility(View.VISIBLE);
            viewHoder.layoutLeft.setVisibility(View.GONE);
            viewHoder.tvRight.setText(msg.getContent());
        }
        return view;
    }

    class ViewHoder {
        LinearLayout layoutLeft;
        LinearLayout layoutRight;
        TextView tvLeft;
        TextView tvRight;

    }
}
