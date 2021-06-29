package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    Context context;
    List<Tweet> tweets;

    // Pass in contexts and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }


    // For each visible row, inflate the layout
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        // Get the data at position
        Tweet tweet = tweets.get(position);

        // Bind the tweet with view holder
        holder.bind(tweet);

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }







    //Define a View Holder class which will parameterize the RecyclerView.Adapter
    public class ViewHolder extends RecyclerView.ViewHolder{

        // Get references in values from the Tweet item
        ImageView ivProfileImage;
        TextView tvUsername, tvTweet, tvRelativeTime;

        public ViewHolder(@NonNull @NotNull View itemView) {
            // itemView passed in is one item in recyclerview
            super(itemView);

            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvTweet = itemView.findViewById(R.id.tvTweet);
            tvRelativeTime = itemView.findViewById(R.id.tvRelativeTime);
        }

        public void bind(Tweet tweet){
            tvTweet.setText(tweet.getBody());
            tvUsername.setText(tweet.getUser().getUsername());
            tvRelativeTime.setText(tweet.getRelativeTimeAgo());

            Glide.with(context)
                    .load(tweet.getUser().getProfileImageUrl())
                    .placeholder(R.drawable.profile_placeholder)
                    .transform(new RoundedCorners(30))
                    .into(ivProfileImage);
        }
    }

}
