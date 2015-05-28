package com.mt178.diyihangdaima.atys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.mt178.diyihangdaima.tools.BaseActivity;
import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.frag.FragNewsTitle;

/**
 * Created by llh on 2015/3/17.
 */
public class AtyNewsTitle extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_frag);

        FragNewsTitle fraTitle = new FragNewsTitle();
        FragmentManager fragment = getFragmentManager();
        FragmentTransaction transaction = fragment.beginTransaction();
        transaction.replace(R.id.layout_aty_fag, fraTitle);
        transaction.commit();
    }
        public void title(){

        }
}
