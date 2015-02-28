package com.ivanchou.ucasdemo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivanchou.ucasdemo.ui.base.BaseFragment;
import com.ivanchou.ucasdemo.core.model.EventModel;

/**
 * Created by ivanchou on 1/18/2015.
 */
public class DetailsFragment extends BaseFragment {

    private Activity mActivity;
    private View mDetailsView;
    private View mFragmentContainerView;
    private DetailsCallback mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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
    }

    public interface DetailsCallback{

    }
}
