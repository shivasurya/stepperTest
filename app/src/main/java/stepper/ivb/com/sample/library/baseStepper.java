package stepper.ivb.com.sample.library;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.List;

import stepper.ivb.com.sample.library.Adapter.CacheFragmentStatePagerAdapter;

public class baseStepper {


    private ViewPager mViewPager;
    private CacheFragmentStatePagerAdapter fragmentAdapter;
    public int CURRENT_PAGE = 0;
    public int TOTAL_PAGE = 0;
    private Bundle mBundle;

    public baseStepper(ViewPager viewPager, List<Class> mStepperFragment, FragmentManager fm, Bundle bundle) {

        mViewPager = viewPager;
        mBundle = bundle;

        fragmentAdapter = new CacheFragmentStatePagerAdapter(fm);
        fragmentAdapter.setFragments(mStepperFragment);

        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(CURRENT_PAGE);

        stepperFragment current = (stepperFragment) fragmentAdapter.getItem(CURRENT_PAGE);
        current.setArguments(mBundle);
        fragmentAdapter.setBundle(mBundle);
        TOTAL_PAGE = mStepperFragment.size();
    }

    protected void onNextButtonClicked(){
        CURRENT_PAGE = mViewPager.getCurrentItem();
        if(resolveNavigation()) {
            stepperFragment current = (stepperFragment) fragmentAdapter.getItemAt(CURRENT_PAGE);
            if (current != null && current.onNextButtonHandler()) {
                for (String key : mBundle.keySet())
                {
                    Log.d("Bundle Debug", key + " = \"" + mBundle.get(key) + "\"");
                }
                CURRENT_PAGE = CURRENT_PAGE + 1;
                mViewPager.setCurrentItem(CURRENT_PAGE);
                current = (stepperFragment) fragmentAdapter.getItemAt(CURRENT_PAGE);
                if(mBundle==null){ Log.d("null","null"); }
                if (current != null && mBundle!=null) {
                    current.setArguments(mBundle);
                    fragmentAdapter.setBundle(mBundle);
                    Log.d("setting","bundle");
                }
            }
        }
    }

    public Bundle getBundle(){
        return mBundle;
    }
    public void setBundle(Bundle bundle){
        mBundle =  bundle;
    }

    protected boolean isLastFragment(){
        CURRENT_PAGE = mViewPager.getCurrentItem();
        stepperFragment current = (stepperFragment) fragmentAdapter.getItemAt(CURRENT_PAGE);
        if (current != null && current.onNextButtonHandler()) {
            return true;
        }
        return false;
    }
    protected boolean resolveNavigation(){
        return CURRENT_PAGE != (TOTAL_PAGE - 1);
    }

    protected void onBackButtonClicked(){
       // mViewPager.setCurrentItem(CURRENT_PAGE);
        stepperFragment current = (stepperFragment) fragmentAdapter.getItemAt(CURRENT_PAGE);
        if (current != null) {

            for (String key : mBundle.keySet())
            {
                Log.d("Bundle Debug", key + " = \"" + mBundle.get(key) + "\"");
            } CURRENT_PAGE = CURRENT_PAGE - 1;
            mViewPager.setCurrentItem(CURRENT_PAGE);
            current = (stepperFragment) fragmentAdapter.getItemAt(CURRENT_PAGE);
            if(mBundle==null){ Log.d("null","null"); }
            if (current != null && mBundle!=null) {
                current.setArguments(mBundle);
                fragmentAdapter.setBundle(mBundle);
                Log.d("setting","bundle");
            }
        }
    }



}
