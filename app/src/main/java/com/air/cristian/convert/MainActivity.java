package com.air.cristian.convert;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.air.cristian.convert.adapters.EmailAdapter;
import com.air.cristian.convert.dialogs.EmailDialog;
import com.air.cristian.convert.models.Email;
import com.air.cristian.convert.models.EmailDBHelper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout swipeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        swipe();

        Email email = new Email("email1@email.com", "name1");

        List<Email> items = new ArrayList<>();
        items.add(email);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        adapter = new EmailAdapter(items);
        recycler.setAdapter(adapter);

    }


    public void addEmail(View view){
        DialogFragment dialog = new EmailDialog();
        dialog.show(getSupportFragmentManager(), "Add Email");
    }

    public void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(5);
    }


    public void setRecycler(){
        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
    }


    public void swipe(){
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                swipeLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
