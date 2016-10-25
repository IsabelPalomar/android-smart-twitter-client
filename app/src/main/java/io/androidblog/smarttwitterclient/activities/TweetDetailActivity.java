package io.androidblog.smarttwitterclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.models.Tweet;

public class TweetDetailActivity extends AppCompatActivity {

    @BindView(R.id.ivUserImg)
    ImageView ivUserImg;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvUserId)
    TextView tvUserId;
    @BindView(R.id.tvBody)
    TextView tvBody;
    @BindView(R.id.tvCreatedAt)
    TextView tvCreatedAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);
        ButterKnife.bind(this);

        setTweetData();
    }

    private void setTweetData() {
        Intent i = getIntent();
        Tweet tweet = (Tweet) i.getSerializableExtra("Tweet");

        if (tweet != null) {
            Glide.with(getApplicationContext()).load(tweet.getProfileImgUrl()).into(ivUserImg);
            tvUserName.setText(tweet.getUsername());
            tvUserId.setText(tweet.getScreenName());
            tvBody.setText(tweet.getBody());
            tvCreatedAt.setText(tweet.getCreatedAt());
        }

    }
}
