package com.mt178.diyihangdaima.atys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mt178.diyihangdaima.tools.BaseActivity;
import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.adapter.AdapterFruit;
import com.mt178.diyihangdaima.domain.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llh on 2015/3/16.
 */
public class AtyFruit extends BaseActivity {
    private ListView lvFruit;
    private List<Fruit> fruitList=new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_list);
        lvFruit= (ListView) findViewById(R.id.lv_fruit);
        initFruit();
        AdapterFruit adapterFruit=new AdapterFruit(this,R.layout.item_fruit,fruitList);
        lvFruit.setAdapter(adapterFruit);
        lvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Fruit fruit=   fruitList.get(position);
                Toast.makeText(AtyFruit.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruit() {
        Fruit apple=new Fruit("apple",R.drawable.apple);
        fruitList.add(apple);
        Fruit banana=new Fruit("banana",R.drawable.banana);
        fruitList.add(banana);
        Fruit orange=new Fruit("orange",R.drawable.orange);
        fruitList.add(orange);
    }
}
