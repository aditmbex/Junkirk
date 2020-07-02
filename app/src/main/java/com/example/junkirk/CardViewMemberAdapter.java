package com.example.junkirk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewMemberAdapter extends RecyclerView.Adapter<CardViewMemberAdapter.CardViewViewHolder> {
    private ArrayList<Members> listMember;
    private String KEY_URL = "URL";

    public CardViewMemberAdapter(ArrayList<Members> list) {
        this.listMember = list;
    }

    @NonNull
    @Override
    public CardViewMemberAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_members, viewGroup, false);
        return new CardViewMemberAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewMemberAdapter.CardViewViewHolder holder, int position) {

        Members members = listMember.get(position);
        Glide.with(holder.itemView.getContext())
                .load(members.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(members.getName());
        holder.tvFrom.setText(members.getFrom());
        //holder.tvUrl.setText(members.getUrl());
        final String alamat_url = listMember.get(holder.getAdapterPosition()).getUrl();
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(holder.itemView.getContext(), "Visit " +
                        listMember.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(),WebViewActivity.class);
                intent.putExtra(KEY_URL,alamat_url);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Intent intent = new Intent(Intent.ACTION_SEND);
                 intent.setType("text/plain");
                 intent.putExtra(Intent.EXTRA_TEXT,"Eh ada blog bagus lo... baca yuk "+ alamat_url);
               holder.itemView.getContext().startActivity(Intent.createChooser(intent,"Jangan disimpan sendiri share yuk..."));
//                Toast.makeText(holder.itemView.getContext(), "Rencananya ini tombol share utk " +
//                        listMember.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Aku " + listMember.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMember.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom,tvUrl,tvjudultulisan,tvtanggal;
        Button btnFavorite,btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tvjudulblog);
            tvFrom = itemView.findViewById(R.id.tvpenulis);
            tvUrl = itemView.findViewById(R.id.tv_member_url);
            btnFavorite = itemView.findViewById(R.id.btnvisit);
            btnShare = itemView.findViewById(R.id.btnshare);
            tvjudultulisan= itemView.findViewById(R.id.tvjudultulisan);
            tvtanggal= itemView.findViewById(R.id.tvtanggalterbit);
        }
    }
}
