package com.tyrannodrake.app.dota2wallpapers;

import android.app.WallpaperManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class SingleWallActivity extends AppCompatActivity {

    int[] covers = new int[]{
            R.drawable.wall1,
            R.drawable.wall2,
            R.drawable.wall3,
            R.drawable.wall4,
            R.drawable.wall5,
            R.drawable.wall6,
            R.drawable.wall7,
            R.drawable.wall8,
            R.drawable.wall9,
            R.drawable.wall10,
            R.drawable.wall11};
    public ImageView singleWallView;
    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_wall);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        singleWallView = (ImageView) findViewById(R.id.singleWallView);
        Glide.with(this).load(covers[Integer.parseInt(getIntent().getStringExtra("id"))]).into(singleWallView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyTask().execute(Integer.parseInt(getIntent().getStringExtra("id")));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    class MyTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setResource(covers[params[0]]);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "Task Completed.";
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(),"Wallpaper set",Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected void onProgressUpdate(Integer... values) {

        }
    }
}

