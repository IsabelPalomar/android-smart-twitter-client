package io.androidblog.smarttwitterclient.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.adapters.TimelinePagerAdapter;
import io.androidblog.smarttwitterclient.fragments.ComposeTweetDialogFragment;
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
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nvViewTweets)
    NavigationView nvViewTweets;


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

        setupDrawerContent(nvViewTweets);

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

    private void setupDrawerContent(NavigationView nvViewTweets) {
        nvViewTweets.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.navProfile:
                Intent i = new Intent(this, UserProfileActivity.class);
                startActivity(i);
                break;
        }

        menuItem.setChecked(true);
        ndTweets.closeDrawers();
    }

    @OnClick(R.id.fab)
    public void createTweet() {
        FragmentManager fm = getSupportFragmentManager();
        ComposeTweetDialogFragment editNameDialogFragment = ComposeTweetDialogFragment.newInstance();
        editNameDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
        editNameDialogFragment.show(fm, "");
    }
}
