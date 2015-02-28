package com.ivanchou.ucasdemo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ivanchou.ucasdemo.R;
import com.ivanchou.ucasdemo.ui.base.BaseFragment;
import com.ivanchou.ucasdemo.core.model.EventModel;
import com.ivanchou.ucasdemo.core.model.UserModel;

/**
 * Created by ivanchou on 1/18/2015.
 */
public class DetailsFragment extends BaseFragment {

    private Activity mActivity;
    private View mDetailsView;
    private View mFragmentContainerView;
    private DetailsCallback mCallback;

    private EventModel mEvent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = new EventModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        mDetailsView = view;
        createTestEvent();
        drawView();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        try {
            mCallback = (DetailsCallback)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("The Activity must implement DetailsCallback!");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    private void drawView(){
        TextView authorNickView = (TextView) mDetailsView.findViewById(R.id.tv_details_author_nick);
        TextView placeAtView = (TextView) mDetailsView.findViewById(R.id.tv_details_place_at);
        TextView startAtView = (TextView) mDetailsView.findViewById(R.id.tv_details_start_at);

        authorNickView.setText(mEvent.author.name);
        placeAtView.setText(mEvent.placeAt);
        startAtView.setText(mEvent.startAt);
    }

    public void getData(){
        drawView();
        TextView authorNickView = (TextView) mDetailsView.findViewById(R.id.tv_details_author_nick);
        TextView placeAtView = (TextView) mDetailsView.findViewById(R.id.tv_details_place_at);
        TextView startAtView = (TextView) mDetailsView.findViewById(R.id.tv_details_start_at);

        authorNickView.invalidate();
        placeAtView.invalidate();
        startAtView.invalidate();
    }

    public void setEvent(EventModel event){
        mEvent = event;
        return;
    }
    /*
        create test event
     */
    private void createTestEvent(){
        mEvent.author = new UserModel();
        mEvent.author.name = "yahu";
        mEvent.author.userId = 123;
        mEvent.startAt = "2014/12/31";
        mEvent.placeAt = "UCAS";
    }

    public interface DetailsCallback{

    }
}
