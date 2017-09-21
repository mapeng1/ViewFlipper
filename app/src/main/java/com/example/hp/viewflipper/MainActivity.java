package com.example.hp.viewflipper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ViewFlipper vf_notice_scroll;
    private ArrayList<MessageBean> infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vf_notice_scroll = (ViewFlipper)findViewById(R.id.vf_notice_scroll);
        infos=new ArrayList<>();
        infos.add(new MessageBean("标题1","10：21"));
        infos.add(new MessageBean("标题2","10：22"));
        infos.add(new MessageBean("标题3","10：23"));
        infos.add(new MessageBean("标题4","10：24"));
        infos.add(new MessageBean("标题5","10：25"));
        infos.add(new MessageBean("标题6","10：26"));
        infos.add(new MessageBean("标题7","10：27"));

        startFlipping(this,vf_notice_scroll,infos);

    }

    public void startFlipping(Context context, ViewFlipper vf, final ArrayList<MessageBean> infos){
        vf.setInAnimation(context, R.anim.notice_in);
        vf.setOutAnimation(context, R.anim.notice_out);
        if(infos!=null&&infos.size()>0) {
            int len = infos.size();
            for (int i = 0; i < len; i++) {
                MessageBean info = infos.get(i);
                View v = ((Activity) context).getLayoutInflater().inflate(R.layout.notice_item, null);
                TextView titleTv = (TextView) v.findViewById(R.id.tv_notice_item_itle);
                titleTv.setText(info.title);
                TextView timeTv = (TextView) v.findViewById(R.id.tv_notice_item_time);
                timeTv.setText(info.time);
                vf.addView(v);
                final int finalI = i;
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,infos.get(finalI).getTitle()+"------"+infos.get(finalI).getTime(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
            vf.startFlipping();
        }
    }
}
