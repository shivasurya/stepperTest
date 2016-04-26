package stepper.ivb.com.sample.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import stepper.ivb.com.sample.R;

/**
 * Created by S.Shivasurya on 1/19/2016 - androidStudio - androidStudio.
 */
public abstract class horizontalStepper extends AppCompatActivity implements View.OnClickListener {

    private Button mPrevious;
    List<Class> mStepperFragmentList = new ArrayList<>();
    List<String> mTitleData= new ArrayList<>();
    List<Integer> mIntegerResource= new ArrayList<>();
    private baseStepper mBaseStepper;
    private int RECOVERCURRENTSTATE = 0;
    private ScrollView mScroll;
    private TextView[] mTitleTextview = new TextView[3];
    private TextView[] mTextTitleView = new TextView[3];
    private TextView mCurrentTextView;
    private Integer mCurrentResource;
    private String mCurrentTitle;
    private Bundle mBundle = new Bundle();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_horizontal_test);

        Button mNext = (Button) findViewById(R.id.next);
        mPrevious = (Button)findViewById(R.id.back);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mScroll = (ScrollView)findViewById(R.id.mobilescroll);

        mTitleTextview[0] = (TextView)findViewById(R.id.first);
        mTitleTextview[1] = (TextView)findViewById(R.id.second);
        mTitleTextview[2] = (TextView)findViewById(R.id.third);

        mTextTitleView[0] = (TextView)findViewById(R.id.firsttext);
        mTextTitleView[1] = (TextView)findViewById(R.id.secondtext);
        mTextTitleView[2] = (TextView)findViewById(R.id.thirdtext);

        initialize();
        mNext.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        if(savedInstanceState!=null) {
            if(savedInstanceState.getSerializable("HSTEPPERBASE")!=null) {
                try {
                    mStepperFragmentList = (List<Class>) savedInstanceState.getSerializable("HSTEPPERBASE");
                    RECOVERCURRENTSTATE = savedInstanceState.getInt("HCURRENT");
                    mBundle = savedInstanceState.getBundle("HBUNDLE");
                }catch(Exception e){
                    //it's  okay we will recover from the init method
                    mStepperFragmentList = init();
                }
            }
            else{
                mStepperFragmentList = init();
            }
        }
        else
        {
            mStepperFragmentList = init();
        }
        mBaseStepper = new baseStepper(mViewPager, mStepperFragmentList, getSupportFragmentManager(),mBundle);
        mBaseStepper.CURRENT_PAGE = RECOVERCURRENTSTATE;
        RECOVERCURRENTSTATE = 0;
        BackButtonConfig();
        updateUI();
    }

    public void addBundle(Bundle bundle){
        mBundle = bundle;
    }

    public void addStepper(String title,Integer resource,Class fragment){
        mTitleData.add(title);
        mIntegerResource.add(resource);
        mStepperFragmentList.add(fragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("HSTEPPERBASE",(Serializable)mStepperFragmentList);
        outState.putInt("HCURRENT",mBaseStepper.CURRENT_PAGE);
        outState.putBundle("HBUNDLE",mBaseStepper.getBundle());
        super.onSaveInstanceState(outState);
    }

    protected void BackButtonConfig(){
        if(mBaseStepper.CURRENT_PAGE==0)
            mPrevious.setVisibility(View.INVISIBLE);
        else
            mPrevious.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next :
                if(checkStepper()) {
                    mTitleTextview[mBaseStepper.CURRENT_PAGE%3].setBackgroundResource(R.drawable.greyish);
                    mBaseStepper.onNextButtonClicked();
                    BackButtonConfig();
                    updateUI();
                }
                break;
            case R.id.back :
                mTitleTextview[mBaseStepper.CURRENT_PAGE%3].setBackgroundResource(R.drawable.greyish);
                mBaseStepper.onBackButtonClicked();
                BackButtonConfig();
                updateUI();
                break;
        }
    }
    public int getCurrentFragmentId(){
        return mBaseStepper.CURRENT_PAGE;
    }

    public boolean checkStepper(){
        if(mBaseStepper.resolveNavigation()){
            return true;
        }
        else if(mBaseStepper.isLastFragment()){
            mBundle = mBaseStepper.getBundle();
            onStepperCompleted(mBundle);
        }

        return false;
    }

    public void updateUI(){
        if(mBaseStepper.CURRENT_PAGE%3==0) {
            mTextTitleView[0].setText(mTitleData.get(mBaseStepper.CURRENT_PAGE));
            mTextTitleView[1].setText(mTitleData.get(mBaseStepper.CURRENT_PAGE+1));
            mTextTitleView[2].setText(mTitleData.get(mBaseStepper.CURRENT_PAGE+2));
        }
            mTitleTextview[mBaseStepper.CURRENT_PAGE%3].setBackgroundResource(R.drawable.circle);
            mScroll.pageScroll(View.FOCUS_UP);
    }
    public abstract void onStepperCompleted(Bundle bundle);
    public List<Class> init(){
        return mStepperFragmentList;
    }
    public abstract void initialize();
}
