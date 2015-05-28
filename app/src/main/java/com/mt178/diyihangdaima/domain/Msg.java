package com.mt178.diyihangdaima.domain;

/**
 * Created by llh on 2015/3/16.
 */
public class Msg {
    public static final int TYPE_RECEVED = 0;
    public static final int TYPE_SEND = 1;
    private int type;
    private String content;

    public Msg(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
