package io.androidblog.smarttwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.androidblog.smarttwitterclient.R;
import io.androidblog.smarttwitterclient.models.Tweet;

public class ComposeTweetDialogFragment extends DialogFragment {

    @BindView(R.id.etTweet)
    EditText etTweet;

    public ComposeTweetDialogFragment() {
    }

    public static ComposeTweetDialogFragment newInstance() {
        ComposeTweetDialogFragment frag = new ComposeTweetDialogFragment();
        return frag;
    }

    // 1. Defines the listener interface with a method passing back data result.
    public interface ComposeTweetDialogFragmentListener {
        void onFinishComposeTweetDialogFragment(Tweet tweet);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_compose_tweet, container);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Show soft keyboard automatically and request focus to field
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        etTweet.requestFocus();

    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
    }

    @Override
    public void onResume() {
        // Get existing layout params for the window
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        // Assign window properties to fill the parent
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        // Call super onResume after sizing
        super.onResume();
    }

    @OnClick(R.id.btnClose)
    public void closeDialog() {
        dismiss();
    }

}
