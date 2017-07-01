package cn.shawn.shawnrvproject;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import cn.shawn.view.recyclerview.iinterface.OnItemClickListener;
import cn.shawn.view.recyclerview.iinterface.OnNetworkRefreshListener;
import cn.shawn.view.recyclerview.iinterface.OnRefreshLoadListener;
import cn.shawn.view.recyclerview.project.RlRecyclerView;
import cn.shawn.view.recyclerview.utils.NetworkUtils;


public class CommonRvDemoActivity extends AppCompatActivity implements OnItemClickListener, OnNetworkRefreshListener, OnRefreshLoadListener {
    public static final String TAG  = CommonRvDemoActivity.class.getSimpleName();
    private RlRecyclerView mRv;
    private CommonRvDemoAdapter mAdapter;
    private Handler mHandler = new Handler();
    private int mLoadCounts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private boolean checkNetworkState(){
        mRv.checkNetworkState();
        return NetworkUtils.isAvailable(this);
    }

    private void initData() {
        //每次网络访问前判断下网络
        if(!checkNetworkState()){
            mRv.stopRefresh();
            return;
        }
        //模拟网络访问
        mRv.setLoadMoreEnable(true);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.showData(DataUtil.generateData(10,5));
                mRv.stopRefresh();
            }
        },1000);
    }

    private void initView() {
        mAdapter = new CommonRvDemoAdapter();
        mAdapter.setOnItemClickListener(this);
        mRv = (RlRecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
        mRv.setOnNetworkRefreshListener(this);
        mRv.setRefreshLoadListener(this);
    }


    @Override
    public void onItemClick(int tag, int position, Object message) {

    }

    @Override
    public void onNetRefreshClick() {
        initData();
    }

    @Override
    public void onRefreshing() {
        mLoadCounts = 0;
        initData();
    }

    @Override
    public void onLoadingMore() {
        if(!checkNetworkState()){
            mRv.stopLoadingMore();
            return;
        }
        //模拟网络访问
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mLoadCounts == 2){
                    mRv.stopLoadingMore();
                    mRv.showNoMoreView("我是有底线的~");
                    return;
                }
                mLoadCounts++;
                mAdapter.appendData(DataUtil.generateData(2,2));
                mRv.stopLoadingMore();
            }
        },1500);
    }
}
