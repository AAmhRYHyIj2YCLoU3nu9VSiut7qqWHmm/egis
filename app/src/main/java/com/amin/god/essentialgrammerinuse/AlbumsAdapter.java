package com.amin.god.essentialgrammerinuse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;
    private MyViewHolder myViewHolderInterface;

    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);
        myViewHolderInterface = new MyViewHolder(itemView);
        return myViewHolderInterface;
    }

    public MyViewHolder getMyViewHolderInterface() {
        return myViewHolderInterface;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getName());

        // loading album cover using Glide library
//        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.title.setTextColor(Color.rgb(123, 123, 0));
        holder.title.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, " holder.itemView king in the north", Toast.LENGTH_SHORT).show();
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, " holder.title.king in the north", Toast.LENGTH_SHORT).show();


            }
        });
//
//        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, Unitctivity.class);
//                intent.putExtra("name", album.getName());
//                mContext.startActivity(intent);
//            }
//        });
//        holder.thumbnail.setOnLongClickListener(new View.OnLongClickListener() {
//
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(mContext, "onLongClick", Toast.LENGTH_SHORT).show();
//
//                return false;
//            }
//        });
//
//        holder.delteitem.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                albumList.remove(position);
//                AlbumsAdapter.this.notifyDataSetChanged();
//                Toast.makeText(mContext, "deleted "+album.getName(), Toast.LENGTH_SHORT ).show();
//            }
//        });


        holder.count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, " holder.count. king in the north", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View parentView;
        public TextView title, count;
//        public ImageView thumbnail, delteitem;
//        public ImageView  delteitem;

        public MyViewHolder(View view) {
            super(view);
            parentView = view;
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
//            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
//            delteitem = (ImageView) view.findViewById(R.id.deleteItem);
        }
    }


}
