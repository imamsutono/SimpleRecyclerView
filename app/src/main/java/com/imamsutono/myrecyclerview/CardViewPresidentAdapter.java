package com.imamsutono.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by idekreasi on 10/31/17.
 */

public class CardViewPresidentAdapter extends RecyclerView.Adapter<CardViewPresidentAdapter.CardViewHolder> {
    private ArrayList<President>listPresident;
    private Context context;

    public CardViewPresidentAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewTyoe) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        President p = getListPresident().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 350)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());
        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}
