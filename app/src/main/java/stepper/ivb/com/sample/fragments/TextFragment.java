package stepper.ivb.com.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import stepper.ivb.com.sample.R;
import stepper.ivb.com.sample.library.stepperFragment;

/**
 * Created by S.Shivasurya on 1/19/2016 - androidStudio.
 */
public class TextFragment extends stepperFragment {
    Bundle mBundle;
    TextView mTextView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onNextButtonHandler() {
        mTextView.setText("googlenasfnakdvkgad");
        return true;
    }

    @Override
    public void setArguments(Bundle args) {
        mBundle = args;
        Log.d("set","wet");
    }

    @Override
    public Bundle getArgument() {
        Log.d("get","wet");
        return mBundle;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.textfragment, container, false);
        Log.d("oncreate","oncreate");
        mTextView = (TextView)v.findViewById(R.id.asia);
        if(mTextView==null){
            Log.d("oncreate null","oncreate null");
        }
        return v;
    }

}
