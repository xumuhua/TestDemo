package com.ivanchou.ucasdemo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ivanchou.ucasdemo.R;
import com.ivanchou.ucasdemo.ui.base.BaseFragment;

/**
 * Created by Origa on 2015/3/1.
 */
public class PosterAlbumFragment extends BaseFragment {

    private View mPosterAlbumView;
    private ImageView mPosterView;

    private Activity mActivity;
    private PosterAlbumCallback mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poster_album,container,false);
        mPosterAlbumView = view;

        mPosterView = (ImageView) mPosterAlbumView.findViewById(R.id.iv_poster_album_poster);

        setListener();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        try {
            mCallback = (PosterAlbumCallback) activity;
        } catch (ClassCastException e){
            throw new ClassCastException("Activity must implement PosterAlbumCallback");
        }
    }

    private void setListener(){
        mPosterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.PosterAlbumQuit();
            }
        });
    }
    public interface PosterAlbumCallback{
        public void PosterAlbumQuit();
    }
}
