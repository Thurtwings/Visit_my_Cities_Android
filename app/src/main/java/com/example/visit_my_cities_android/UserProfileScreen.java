package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class UserProfileScreen extends AppCompatActivity
{



    Button feedButton;
    Button listsButton;
    ImageView userPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_screen);

        userPicture = findViewById(R.id.UserPicture);
        feedButton = (Button) findViewById(R.id.UPFeedButton);
        listsButton = (Button) findViewById(R.id.UPListButton);

        feedButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                GoToFeed();
            }
        });

        listsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                GoToLists();
            }
        });

    }

    private void GoToLists()
    {
        Intent nav = new Intent(this, ListsScreen.class);

        startActivity(nav);
    }

    private void GoToFeed()
    {
        Intent nav = new Intent(this, FeedScreen.class);
        startActivity(nav);
    }
}