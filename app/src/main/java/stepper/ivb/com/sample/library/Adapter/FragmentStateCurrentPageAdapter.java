package stepper.ivb.com.sample.library.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by S.Shivasurya on 1/20/2016 - androidStudio.
 */
public class FragmentStateCurrentPageAdapter extends FragmentStatePagerAdapter  implements ViewPager.OnPageChangeListener {
    int currentPage = 0;
    List<Class> mStepperFragment;

    private SparseArray<Fragment> mPageReferenceMap = new SparseArray<>();

    public FragmentStateCurrentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return mStepperFragment.size();
    }

    public void setFragments(List<Class> fragments){
        mStepperFragment = fragments;
    }

    @Override
    public final Fragment getItem(int index) {
        if(mPageReferenceMap.get(index)!=null) {
            Log.d("old instance","old instance"+String.valueOf(index));
            return getItemAtIndex(index);
        }
        else
        {
            try {
                Fragment obj = (Fragment) mStepperFragment.get(index).newInstance();
                Log.d("new instance","new instance"+String.valueOf(index));
                mPageReferenceMap.put(index, obj);
                return obj;
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public Fragment getItemAtIndex(int index){
        return mPageReferenceMap.get(index);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        Log.d("delete",String.valueOf(position));
        mPageReferenceMap.remove(position);
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int newPageIndex) {
        currentPage = newPageIndex;
    }

}

