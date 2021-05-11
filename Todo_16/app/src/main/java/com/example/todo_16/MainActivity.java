package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecycleView;
    private final LinkedList<String>mWordList=new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<20;i++){
            mWordList.addLast("Word"+i);
        }
        mRecycleView=findViewById(R.id.recycleview);
        wordListAdapter mAdapter=new wordListAdapter(this,mWordList);
        mRecycleView.setAdapter(mAdapter);
        LinearLayoutManager obj=new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(obj);

        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordlistSize=mWordList.size();
                mWordList.addLast("+Word+"+wordlistSize);
                mRecycleView.getAdapter().notifyItemInserted(wordlistSize);
                mRecycleView.smoothScrollToPosition(wordlistSize);
            }
        });


    }
}