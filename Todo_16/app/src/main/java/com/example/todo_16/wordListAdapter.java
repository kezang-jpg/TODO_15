package com.example.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class wordListAdapter extends RecyclerView.Adapter<wordListAdapter.WordViewHolder> {
    private final LinkedList<String>mWordList;
    private LayoutInflater mInflater;

    public wordListAdapter(Context context, LinkedList<String> mWordList) {
        this.mWordList = mWordList;
        mInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public wordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=mInflater.inflate(R.layout.activity_wordlist_item,parent,false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent=mWordList.get(position);
        holder.wordItemView.setTextContent(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }





    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final Text wordItemView;
        final wordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, wordListAdapter mAdapter){
            super(itemView);
            wordItemView=itemView.findViewById(R.id.word);
            this.mAdapter=mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition=getLayoutPosition();
            String element=mWordList.get(mPosition);
            mWordList.set(mPosition,"Clicked!"+element);
            mAdapter.notifyDataSetChanged();

        }
    }
}
