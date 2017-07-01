package cn.shawn.shawnrvproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.shawn.view.recyclerview.adapter.CommonAdapter;
import cn.shawn.view.recyclerview.iinterface.OnItemClickListener;
import cn.shawn.view.recyclerview.project.RlRecyclerView;
import cn.shawn.view.recyclerview.utils.ViewHolder;

/**
 * Created by root on 17-6-24.
 */

public class SortActivity extends AppCompatActivity  {

    private Class[] ACTIVITIES ={CommonRvDemoActivity.class};

    private RlRecyclerView mRv;

    private Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < ACTIVITIES.length; i++) {
            data.add(ACTIVITIES[i].getSimpleName());
        }
        mAdapter.showData(data);
    }

    private void initView() {
        mAdapter = new Adapter();
        mRv = (RlRecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
        mRv.setPullRefreshEnable(false);
    }

    class Adapter extends CommonAdapter<String>{

        @Override
        public int getItemLayoutId() {
            return R.layout.layout_item;
        }

        @Override
        public void convert(final ViewHolder holder, final int position, String info) {
            holder.setText(R.id.tv, ACTIVITIES[position].getSimpleName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(SortActivity.this,ACTIVITIES[position]));                }
            });
        }
    }

}
