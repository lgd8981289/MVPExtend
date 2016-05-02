package com.sunday.mvpextend.Desc;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunday.mvpextend.R;

import java.util.List;

/**
 * Created by Sunday on 16/4/28.
 */
public class DescFragmentAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<DescFragmentModel> mDataSource;

    public DescFragmentAdapter(Context context,List<DescFragmentModel> mDataSource){
        mInflater = LayoutInflater.from(context);
        this.mDataSource = mDataSource;
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item_fragment_desc,null);
            viewHolder = new ViewHolder();

            viewHolder.mTvItem = (TextView) convertView.findViewById(R.id.tv_item);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.mTvItem.setText(mDataSource.get(position).getTest());

        return convertView;
    }


    private static class ViewHolder{
        TextView mTvItem;
    }
}
