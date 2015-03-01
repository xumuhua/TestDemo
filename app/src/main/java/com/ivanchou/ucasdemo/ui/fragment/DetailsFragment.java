package com.ivanchou.ucasdemo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

    public static final int POSTER_ON_CLICK = 0;
    public static final int MAP_ON_CLICK = 1;

    private EventModel mEvent;
    private TextView mAuthorNickView;
    private TextView mPlaceAtView;
    private TextView mStartAtView;
    private TextView mTitleView;
    private Button mMapButton;
    private ImageView mPosterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = new EventModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        mDetailsView = view;

        mAuthorNickView = (TextView) mDetailsView.findViewById(R.id.tv_details_author_nick);
        mPlaceAtView = (TextView) mDetailsView.findViewById(R.id.tv_details_place_at);
        mStartAtView = (TextView) mDetailsView.findViewById(R.id.tv_details_start_at);
        mTitleView = (TextView) mDetailsView.findViewById(R.id.tv_details_title);
        mMapButton = (Button) mDetailsView.findViewById(R.id.bt_details_map);
        mPosterView = (ImageView) mDetailsView.findViewById(R.id.iv_details_poster_view);

        setListener();
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
        mAuthorNickView.setText(mEvent.author.name);
        mPlaceAtView.setText(mEvent.placeAt);
        mStartAtView.setText(mEvent.startAt);
        mTitleView.setText(mEvent.title);
    }

    public void getData(){
        drawView();

        mAuthorNickView.invalidate();
        mPlaceAtView.invalidate();
        mStartAtView.invalidate();
        mTitleView.invalidate();
    }

    public void setEvent(EventModel event){
        mEvent = event;
        return;
    }

    private void setListener()
    {

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTestEvent();
                getData();
            }
        });

        mPosterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onDetailsFragmentClick(POSTER_ON_CLICK);
            }
        });
    }
    /*
        create test event
     */
    private void createTestEvent(){
        mEvent.author = new UserModel();
        mEvent.author.name = String.format("name%d",(int)(Math.random() * 100));
        mEvent.author.userId = (int)(Math.random() * 100);
        mEvent.startAt = String.format("start%d",(int)(Math.random() * 100));
        mEvent.placeAt = String.format("place%d",(int)(Math.random() * 100));
        mEvent.title = String.format("title%d",(int)(Math.random() * 100));
    }
    /*End Test*/
    public interface DetailsCallback{
       public void onDetailsFragmentClick(int viewID);
    }
}
