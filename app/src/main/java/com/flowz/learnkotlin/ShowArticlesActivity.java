package com.flowz.learnkotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ShowArticlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_articles);

        RecyclerView rvArticles = findViewById(R.id.rv_articles);
        final ArticleAdapter adapter = new ArticleAdapter();
        rvArticles.setAdapter(adapter);

        LinearLayoutManager articlelayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvArticles.setLayoutManager(articlelayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.insert_article:
                Intent intent = new Intent(this, ArticleActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
