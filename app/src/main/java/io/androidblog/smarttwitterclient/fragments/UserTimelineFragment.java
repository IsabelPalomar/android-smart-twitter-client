package io.androidblog.smarttwitterclient.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.adapters.TweetsRecyclerViewAdapter;
import io.androidblog.smarttwitterclient.models.Tweet;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserTimelineFragment extends Fragment {


    @BindView(R.id.rvTweets)
    RecyclerView rvTweets;

    private ArrayList<Tweet> tweets;

    public UserTimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_timeline, container, false);
        ButterKnife.bind(this, view);

        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvTweets.setHasFixedSize(true);
        rvTweets.setLayoutManager(llm);

        TweetsRecyclerViewAdapter adapter = new TweetsRecyclerViewAdapter(this.getContext(), tweets);
        rvTweets.setAdapter(adapter);

        return view;
    }

    private void initializeData() {
        tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet(1,"Don't judge. Teach. It is a learning process", "Ulises Pulido Pintor", "@ulisespulido", "5m",  "https://pbs.twimg.com/profile_images/789206463021326337/YC1Q1Jo-_bigger.jpg"));
        tweets.add(new Tweet(2,"I've been selected for the Google Developer Experts (GDE) program!", "Corey Leigh Latislaw", "@corey_latislaw", "1d",  "https://pbs.twimg.com/profile_images/677142271708389376/JNfgckjB_bigger.jpg"));
        tweets.add(new Tweet(3,"Nothing like fixing a weird bug to get back to productive mode after vacation/days off ", "Raquel Hernandez", "@raqueldotnyc", "5h",  "https://pbs.twimg.com/profile_images/671003595081297920/Hy9mXLU__bigger.jpg"));
        tweets.add(new Tweet(4,"Share your knowledge with your team! Anything!!! That will open you and your team mates mind", "Pedro Gomez", "@pedro_g_s", "Oct 18",  "https://pbs.twimg.com/profile_images/651846446103314438/VLeJn64N_bigger.jpg"));
        tweets.add(new Tweet(5,"I thought we were good to Go, but it turns out he still needs Clojure.", "Veronica", "@verolopg", "Sep 5",  "https://pbs.twimg.com/profile_images/783664209099763712/4dM4hohr_bigger.jpg"));
    }

}
