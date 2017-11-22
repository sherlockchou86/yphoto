package com.yphoto.zhzhi.yphoto.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yphoto.zhzhi.yphoto.R;

import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/24/2017.
 */

public class PhotoRecycleListViewAdapter extends RecyclerView.Adapter<PhotoRecycleListViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<Map<String, Object>> mData;
    private OnPhotoItemClickListener mClickListener;

    // data is passed into the constructor
    public PhotoRecycleListViewAdapter(Context context, List<Map<String, Object>> data) {
        this.mInflater = LayoutInflater.from(context);
        mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_photos, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map<String, Object> record = mData.get(position);
        holder.myView.setImageResource(R.drawable.sign_in_background);   // the first photo
        holder.myTextView.setText(record.get("image_count").toString());   //photo count (max is 9)
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView myView;
        public TextView myTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            myView = (ImageView) itemView.findViewById(R.id.first_photo);
            myTextView =(TextView) itemView.findViewById(R.id.photo_count);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    public void setItemClickListener(OnPhotoItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface OnPhotoItemClickListener {
        void onItemClick(View view, int position);
    }
}
