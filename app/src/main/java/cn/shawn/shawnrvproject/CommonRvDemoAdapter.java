package cn.shawn.shawnrvproject;

import android.graphics.Color;
import android.widget.TextView;

import cn.shawn.view.recyclerview.adapter.CommonAdapter;
import cn.shawn.view.recyclerview.utils.ViewHolder;

/**
 * Created by root on 17-6-22.
 */

public class CommonRvDemoAdapter extends CommonAdapter<String> {

    @Override
    public int getItemLayoutId() {
        return R.layout.layout_item;
    }

    @Override
    public void convert(ViewHolder holder, int position, String info) {
        ((TextView)holder.getView(R.id.tv)).setText("item position"+String.valueOf(position));
        ((TextView)holder.getView(R.id.tv)).setTextColor(Color.WHITE);
    }

}
