package cn.shawn.shawnrvproject;

import cn.shawn.view.recyclerview.adapter.MultiTypeAdapter;
import cn.shawn.view.recyclerview.iinterface.ItemTypeDelegate;
import cn.shawn.view.recyclerview.utils.ViewHolder;

/**
 * Created by root on 17-7-1.
 */

public class RvMultiTypeAdapter extends MultiTypeAdapter<String> {
    @Override
    public void addItemTypeDelegate() {
        mDelegateManager.addDelegate(new ItemTypeDelegate<String>() {
            @Override
            public int getItemLayoutId() {
                return 0;
            }

            @Override
            public boolean isTypeForItem(int position, String s) {
                return false;
            }

            @Override
            public void convert(ViewHolder holder, int position, String info) {

            }
        }).addDelegate(new ItemTypeDelegate<String>() {
            @Override
            public int getItemLayoutId() {
                return 0;
            }

            @Override
            public boolean isTypeForItem(int position, String s) {
                return false;
            }

            @Override
            public void convert(ViewHolder holder, int position, String info) {

            }
        });
    }
}
