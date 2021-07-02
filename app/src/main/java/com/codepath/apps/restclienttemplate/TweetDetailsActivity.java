package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class TweetDetailsActivity extends AppCompatActivity {

    Tweet tweet;

    ImageView ivProfileImage;
    TextView tvName, tvUsername, tvTweet, tvCreatedAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvName = (TextView) findViewById(R.id.tvName);
        tvTweet = (TextView) findViewById(R.id.tvTweet);
        tvCreatedAt = (TextView) findViewById(R.id.tvCreatedAt);

        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra("TWEET"));
        Log.d("TweetDetailsActivity", String.format("Showing details for '%s'", tweet.body));

        tvUsername.setText("@"+tweet.getUser().getUsername());
        tvName.setText(tweet.getUser().getName());
        tvTweet.setText(tweet.getBody());
        tvCreatedAt.setText(tweet.getRelativeTimeAgo());

        Log.i("TweetDetailsActivity", tweet.getBody());

        Glide.with(this)
                .load(tweet.user.getProfileImageUrl())
                .circleCrop()
                .into(ivProfileImage);

    }
}