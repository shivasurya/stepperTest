package stepper.ivb.com.sample.library;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by S.Shivasurya on 1/19/2016 - androidStudio.
 */
public abstract class stepperFragment extends Fragment {


    public abstract boolean onNextButtonHandler();

    @Override
    public abstract void setArguments(Bundle args);

    public abstract Bundle getArgument();
}
