package stepper.ivb.com.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stepper.ivb.com.sample.R;
import stepper.ivb.com.sample.library.stepperFragment;

/**
 * Created by S.Shivasurya on 1/19/2016 - androidStudio.
 */
public class FormFragment extends stepperFragment {

    Bundle mBundle;

    public FormFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.formfragment, container, false);
    }


    @Override
    public boolean onNextButtonHandler() {
        return true;
    }

    @Override
    public void setArguments(Bundle args) {
        Log.d("setting","wetting");
        mBundle =  args;
        mBundle.putString("hello","google");
    }

    @Override
    public Bundle getArgument() {
        return mBundle;
    }


}
