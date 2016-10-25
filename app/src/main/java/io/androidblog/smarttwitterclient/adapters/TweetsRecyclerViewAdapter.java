package io.androidblog.smarttwitterclient.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.models.Tweet;

public class TweetsRecyclerViewAdapter extends RecyclerView.Adapter<TweetsRecyclerViewAdapter.ViewHolder> {

    private List<Tweet> tweets;
    private Context context;


    public TweetsRecyclerViewAdapter(Context context, ArrayList<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    private Context getContext() {
        return context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);

        Glide.with(getContext()).load(tweet.getProfileImgUrl()).into(holder.ivUserImg);
        holder.tvUserName.setText(tweet.getUsername());
        holder.tvUserId.setText(tweet.getScreenName());
        holder.tvBody.setText(tweet.getBody());
        holder.tvCreatedAt.setText(tweet.getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivUserImg)
        ImageView ivUserImg;
        @BindView(R.id.tvUserName)
        TextView tvUserName;
        @BindView(R.id.tvUserId)
        TextView tvUserId;
        @BindView(R.id.tvCreatedAt)
        TextView tvCreatedAt;
        @BindView(R.id.tvBody)
        TextView tvBody;
        @BindView(R.id.ivTweetImg)
        ImageView ivTweetImg;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
