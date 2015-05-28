package com.mt178.diyihangdaima.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by llh on 2015/4/21.
 */
@Table(name = "Items")
public class Item extends Model {
    @Column(name = "name")
    public String name;
    @Column(name = "id")
    public int id;

  public  Item() {
    }
    Item(String name,int id){
        this.name=name;
        this.id=id;
    }
}
