package com.mt178.diyihangdaima.atys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.mt178.diyihangdaima.tools.BaseActivity;
import com.mt178.diyihangdaima.R;
import com.mt178.diyihangdaima.adapter.AdapterMsg;
import com.mt178.diyihangdaima.domain.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llh on 2015/3/16.
 */
public class AtyChat extends BaseActivity {
    private ListView lvChat;
    private EditText etChat;
    private Button btSend;
    private List<Msg> listMsg=new ArrayList<Msg>();
    private AdapterMsg adapterMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_chat);
        initMsgs();
        adapterMsg=new AdapterMsg(this,R.layout.item_msg,listMsg);

        lvChat= (ListView) findViewById(R.id.lv_chat);
        etChat= (EditText) findViewById(R.id.et_chat);
        btSend= (Button) findViewById(R.id.bt_chat_send);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=etChat.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(Msg.TYPE_SEND,content);
                    listMsg.add(msg);
                    adapterMsg.notifyDataSetChanged();
                    lvChat.setSelection(listMsg.size());
                    etChat.setText("");
                }
            }
        });

        lvChat.setAdapter(adapterMsg);

    }

    private void initMsgs() {
        Msg msg1=new Msg(Msg.TYPE_RECEVED,"你好");
        listMsg.add(msg1);
        Msg msg5=new Msg(Msg.TYPE_RECEVED,"-------------------------");
        listMsg.add(msg5);
        Msg msg2=new Msg(Msg.TYPE_SEND,"干嘛？");
        listMsg.add(msg2);
        Msg msg3=new Msg(Msg.TYPE_RECEVED,"约吗？");
        listMsg.add(msg3);
        Msg msg4=new Msg(Msg.TYPE_SEND,"不约");
        listMsg.add(msg4);

    }
}
