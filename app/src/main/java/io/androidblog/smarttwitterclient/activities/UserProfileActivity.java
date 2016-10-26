package io.androidblog.smarttwitterclient.activities;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.adapters.TweetsRecyclerViewAdapter;
import io.androidblog.smarttwitterclient.models.Tweet;
import io.androidblog.smarttwitterclient.models.User;
import io.androidblog.smarttwitterclient.utils.AppBarStateChangeListener;

public class UserProfileActivity extends AppCompatActivity {

    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvUserId)
    TextView tvUserId;
    @BindView(R.id.tvTagline)
    TextView tvTagline;
    @BindView(R.id.tvFollowing)
    TextView tvFollowing;
    @BindView(R.id.tvFollowers)
    TextView tvFollowers;
    @BindView(R.id.rvTweets)
    RecyclerView rvTweets;
    @BindView(R.id.ivProfileImg)
    ImageView ivProfileImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;

    private ArrayList<Tweet> tweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUserInformation();
        initializeData();
        hideProfileImageAndTitleOnCollapse();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvTweets.setHasFixedSize(true);
        rvTweets.setLayoutManager(llm);

        TweetsRecyclerViewAdapter adapter = new TweetsRecyclerViewAdapter(this, tweets);
        rvTweets.setAdapter(adapter);

    }

    private void hideProfileImageAndTitleOnCollapse() {
        appBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state.name().equals("COLLAPSED")) {
                    ivProfileImg.animate().alpha(0.0f);
                    ivProfileImg.setVisibility(View.GONE);


                } else if (state.name().equals("EXPANDED")) {
                    ivProfileImg.animate().alpha(1.0f);
                    ivProfileImg.setVisibility(View.VISIBLE);
                }
            }
        });

        toolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        appBar.setExpanded(true);
    }

    private void setUserInformation() {
        User user = new User(1, "Isabel Palomar", "@isabelpalomar", "https://pbs.twimg.com/profile_images/744717614816059392/BbVuLvej_400x400.jpg", "https://pbs.twimg.com/profile_banners/119169398/1446413739/1500x500", "699", "2270", "Daydreamer, nightthinker! #androidDev n.n @techWomenC Co-Founder");

        Glide.with(this).load(user.getProfileBannerUrl()).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    appBar.setBackground(drawable);
                }
            }
        });

        Glide.with(getApplicationContext()).load(user.getProfileImageUrl()).into(ivProfileImg);
        tvUserName.setText(user.getScreenName());
        tvUserId.setText(user.getUserId());
        tvFollowing.setText(user.getFollowing());
        tvFollowers.setText(user.getFollowers());
        tvFollowers.setText(user.getFollowers());
        tvTagline.setText(user.getDescription());

        toolbarLayout.setTitle(user.getScreenName());
    }

    private void initializeData() {
        tweets = new ArrayList<>();
        tweets.add(new Tweet(1, "Don't judge. Teach. It is a learning process", "Ulises Pulido Pintor", "@ulisespulido", "5m", "https://pbs.twimg.com/profile_images/789206463021326337/YC1Q1Jo-_bigger.jpg"));
        tweets.add(new Tweet(2, "I've been selected for the Google Developer Experts (GDE) program!", "Corey Leigh Latislaw", "@corey_latislaw", "1d", "https://pbs.twimg.com/profile_images/677142271708389376/JNfgckjB_bigger.jpg"));
        tweets.add(new Tweet(3, "Nothing like fixing a weird bug to get back to productive mode after vacation/days off ", "Raquel Hernandez", "@raqueldotnyc", "5h", "https://pbs.twimg.com/profile_images/671003595081297920/Hy9mXLU__bigger.jpg"));
        tweets.add(new Tweet(4, "Share your knowledge with your team! Anything!!! That will open you and your team mates mind", "Pedro Gomez", "@pedro_g_s", "Oct 18", "https://pbs.twimg.com/profile_images/651846446103314438/VLeJn64N_bigger.jpg"));
        tweets.add(new Tweet(5, "I thought we were good to Go, but it turns out he still needs Clojure.", "Veronica", "@verolopg", "Sep 5", "https://pbs.twimg.com/profile_images/783664209099763712/4dM4hohr_bigger.jpg"));
    }

}
