package stepper.ivb.com.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import stepper.ivb.com.sample.R;
import stepper.ivb.com.sample.library.stepperFragment;

/**
 * Created by S.Shivasurya on 1/20/2016 - androidStudio.
 */
public class Instruction extends stepperFragment {
    @Override
    public boolean onNextButtonHandler() {
        Log.d("hello","last step");
        Toast.makeText(getContext(),"it works!!",Toast.LENGTH_LONG).show();
        return true;
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.instruction, container, false);
    }


}
