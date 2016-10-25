package io.androidblog.smarttwitterclient.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.adapters.TimelinePagerAdapter;
import io.androidblog.smarttwitterclient.fragments.MentionsTimelineFragment;
import io.androidblog.smarttwitterclient.fragments.UserTimelineFragment;

public class TimelineActivity extends AppCompatActivity {

    ActionBarDrawerToggle drawerToggle;
    @BindView(R.id.ndTweets)
    DrawerLayout ndTweets;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vpPagerTimeline)
    ViewPager vpPagerTimeline;
    @BindView(R.id.tlTwitter)
    TabLayout tlTwitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        drawerToggle = setupDrawerToggle();
        ndTweets.addDrawerListener(drawerToggle);

        setupViewPager(vpPagerTimeline);
        tlTwitter.setupWithViewPager(vpPagerTimeline);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, ndTweets, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager vpPagerTimeline) {
        TimelinePagerAdapter adapter = new TimelinePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UserTimelineFragment(), "Timeline");
        adapter.addFragment(new MentionsTimelineFragment(), "Mentions");
        vpPagerTimeline.setAdapter(adapter);
    }

    @OnClick(R.id.ndTweets)
    public void onClick() {
    }
}