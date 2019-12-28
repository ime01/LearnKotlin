package com.flowz.learnkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ArticleActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    EditText name, topic, weblink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

         FirebaseUtil.openFbReference("articles");
         mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
         mDatabaseReference = FirebaseUtil.mDatabaseReference;

//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mDatabaseReference = mFirebaseDatabase.getReference().child("articles");

        name = findViewById(R.id.enterName);
        topic = findViewById(R.id.topic);
        weblink = findViewById(R.id.link);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.article_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_artice:
                saveArticle();
                clean();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clean() {
        name.setText("");
        topic.setText("");
        weblink.setText("");
        topic.requestFocus();

    }

    private void saveArticle() {
        String writersName = name.getText().toString();
        String writersTopic = topic.getText().toString();
        String writersLink = weblink.getText().toString();

        ArticleModel article = new ArticleModel( writersName, writersTopic, writersLink,  "" );
        mDatabaseReference.push().setValue(article);

    }
}
