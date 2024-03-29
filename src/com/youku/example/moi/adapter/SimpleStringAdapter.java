package com.youku.example.moi.adapter;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleStringAdapter extends RecyclerView.Adapter<SimpleStringAdapter.ViewHolder> {

    private int mBackground;

    private ArrayList<String> mValues;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }

    public SimpleStringAdapter(Context context, String[] strings) {
        TypedValue val = new TypedValue();
        if (context.getTheme() != null) {
            context.getTheme().resolveAttribute(
                    android.R.attr.selectableItemBackground, val, true);
        }
        mBackground = val.resourceId;
        mValues = new ArrayList<String>();
        Collections.addAll(mValues, strings);
    }

    public void swap(int pos1, int pos2) {
        String tmp = mValues.get(pos1);
        mValues.set(pos1, mValues.get(pos2));
        mValues.set(pos2, tmp);
        notifyItemRemoved(pos1);
        notifyItemInserted(pos2);
    }

    @Override
    public SimpleStringAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewHolder h = new ViewHolder(new TextView(parent.getContext()));
        h.mTextView.setMinimumHeight(128);
        h.mTextView.setPadding(20, 0, 20, 0);
        h.mTextView.setFocusable(true);
        h.mTextView.setBackgroundResource(mBackground);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 10;
        lp.rightMargin = 5;
        lp.topMargin = 20;
        lp.bottomMargin = 15;
        h.mTextView.setLayoutParams(lp);
        return h;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(position + ":" + mValues.get(position));
        holder.mTextView.setMinHeight((200 + mValues.get(position).length() * 10));
        holder.mTextView.setBackgroundColor(getBackgroundColor(position));
    }

    private int getBackgroundColor(int position) {
        switch (position % 4) {
            case 0: return Color.BLACK;
            case 1: return Color.RED;
            case 2: return Color.GREEN;
            case 3: return Color.BLUE;
        }
        return Color.TRANSPARENT;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
