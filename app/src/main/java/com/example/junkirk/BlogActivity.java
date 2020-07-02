package com.example.junkirk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {
    private String title = "Mode List";
    private RecyclerView rvHeroes;
    private RecyclerView rvMembers;
    private ArrayList<Members> list = new ArrayList<>();
    private String suggest_url,join_url;
    private String KEY_URL = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_blog);

        rvMembers = findViewById(R.id.rv_members);
        rvMembers.setHasFixedSize(true);

        list.addAll(MembersData.getListData());
//        showRecyclerList();
        showRecyclerCardView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
        }
        setActionBarTitle(title);
    }

    private void showRecyclerList(){
//        Toast.makeText(BlogActivity.this, "Kritik dan Saran", Toast.LENGTH_LONG).show();
        suggest_url = "https://docs.google.com/forms/d/e/1FAIpQLSfMdAPap-51srb9gbVPrzv-V1oFLV4HQNl3QGv3ds3mQ6A3OQ/viewform?usp=sf_link";
        Intent intent = new Intent(BlogActivity.this, WebViewActivity.class);
        intent.putExtra(KEY_URL,suggest_url);
        startActivity(intent);
    }

    private void showRecyclerGrid(){
//        Toast.makeText(BlogActivity.this, "Join Us", Toast.LENGTH_LONG).show();
        join_url = "https://docs.google.com/forms/d/e/1FAIpQLScikuAtRVRsAHX3YL5KbMYftQqBdDYnP2wWzlprX_kiaZQorQ/viewform?usp=sf_link";
        Intent intent = new Intent(BlogActivity.this, WebViewActivity.class);
        intent.putExtra(KEY_URL,join_url);
        startActivity(intent);
    }

    private void showRecyclerCardView(){
        ListMembersAdapter listMembersAdapter = new ListMembersAdapter(list);
        rvMembers.setLayoutManager(new LinearLayoutManager(this));
        CardViewMemberAdapter cardViewMemberAdapter = new CardViewMemberAdapter(list);
        rvMembers.setAdapter(cardViewMemberAdapter);

        listMembersAdapter.setOnItemClickCallback(new ListMembersAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Members data) {
                showSelectedMember(data);
            }
        });
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedMember(Members members){
        Toast.makeText(this, "Kamu memilih " + members.getName(), Toast.LENGTH_SHORT).show();
    }
}
