package stepper.ivb.com.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stepper.ivb.com.sample.R;
import stepper.ivb.com.sample.library.stepperFragment;

/**
 * Created by S.Shivasurya on 1/19/2016 - androidStudio.
 */
public class TextFragment extends stepperFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onNextButtonHandler() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.textfragment, container, false);
    }

}
