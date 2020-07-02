package com.example.junkirk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMembersAdapter extends RecyclerView.Adapter<ListMembersAdapter.ListViewHolder> {
    private ArrayList<Members> listmember;
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    ListMembersAdapter(ArrayList<Members> list) {
        this.listmember = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_members, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Members members = listmember.get(position);

        Glide.with(holder.itemView.getContext())
                .load(members.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(members.getName());
        holder.tvFrom.setText(members.getFrom());
        holder.tvUrl.setText(members.getUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onItemClickCallback.onItemClicked(listmember.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listmember.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom,tvUrl,tvjudultulisan,tvtanggal;
        Button visit,share;

        ListViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tvjudulblog);
            tvFrom = itemView.findViewById(R.id.tvpenulis);
//            tvUrl =  itemView.findViewById(R.id.tv_member_url);
            tvjudultulisan= itemView.findViewById(R.id.tvjudultulisan);
            tvtanggal= itemView.findViewById(R.id.tvtanggalterbit);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Members data);
    }
}
