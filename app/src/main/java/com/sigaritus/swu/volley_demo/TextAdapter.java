package com.sigaritus.swu.volley_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/5/22.
 */
public class TextAdapter extends BaseAdapter {

    private Context tcontext;
    private List<ListContent> list;
    private RelativeLayout layout;
    public TextAdapter(List<ListContent> list, Context tcontext) {
        this.list = list;
        this.tcontext = tcontext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListContent listContent = list.get(position);
        LayoutInflater inflater = LayoutInflater.from(tcontext);
        if (listContent.getFlag()==Constant.SENDER){
            layout = (RelativeLayout)inflater.inflate(R.layout.send_item_layout,null);
        }
        if (listContent.getFlag()==Constant.RECEiVER){
            layout = (RelativeLayout)inflater.inflate(R.layout.receive_item_layout,null);
        }

        TextView textView = (TextView)layout.findViewById(R.id.text);
        textView.setText(listContent.getContent());

        return layout;


    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
