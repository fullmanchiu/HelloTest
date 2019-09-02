package cn.colafans.hellotest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.colafans.hellotest.R;
import cn.colafans.hellotest.adapter.RvAdapter;
import cn.colafans.hellotest.entity.RvItem;

public class RvSampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RvAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<RvItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_sample);
        list = new ArrayList<>();
        list.add(new RvItem("aaaaa"));
        list.add(new RvItem("bbbbb"));
        recyclerView = findViewById(R.id.rv);
        mAdapter = new RvAdapter(list);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //设置布局管理器
        recyclerView.setLayoutManager(mLayoutManager);
        //设置adapter
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(RvSampleActivity.this, "點擊了" + (position ), Toast.LENGTH_SHORT).show();
                mAdapter.setCurrentPosition(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
