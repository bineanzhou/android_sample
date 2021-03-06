package com.jt.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.jt.sample.remote.Binding;
import com.jt.sample.remote.BindingOptions;
import com.jt.sample.remote.RemoteService;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent();
                startIntent.setClass(ScrollingActivity.this, LocalService.class);
                startService(startIntent);
            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent();
                startIntent.putExtra("name", "msg:" + System.currentTimeMillis());
                startIntent.setClass(ScrollingActivity.this, ServiceStartArguments.class);
                startService(startIntent);
            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent();
                startIntent.setClass(ScrollingActivity.this, RemoteService.class);
                startService(startIntent);
            }
        });
        findViewById(R.id.btn_binding).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ScrollingActivity.this, Binding.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}