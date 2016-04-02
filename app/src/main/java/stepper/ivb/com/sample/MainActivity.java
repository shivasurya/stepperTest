package stepper.ivb.com.sample;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import stepper.ivb.com.sample.fragments.FormFragment;
import stepper.ivb.com.sample.fragments.Instruction;
import stepper.ivb.com.sample.fragments.TextFragment;
import stepper.ivb.com.sample.library.horizontalStepper;

public class MainActivity extends horizontalStepper {

   List<Class> stepperFragmentList = new ArrayList<>();


    @Override
    public void onStepperCompleted(Bundle bundle) {
        showCompletedDialog();
    }

    @Override
    public void initialize() {
        addStepper("Sell",R.drawable.pencil, TextFragment.class);
        addStepper("Buy",R.drawable.alert, FormFragment.class);
        addStepper("Delivery",R.drawable.tick, Instruction.class);
        addStepper("Goods",R.drawable.tick, TextFragment.class);
        addStepper("Address",R.drawable.tick, TextFragment.class);
        addStepper("Feedback",R.drawable.tick, TextFragment.class);
        addStepper("Google",R.drawable.alert, FormFragment.class);
        addStepper("Facebook",R.drawable.tick, Instruction.class);
    }

    protected void showCompletedDialog(){
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(
                MainActivity.this);

        // set title
        alertDialogBuilder.setTitle("Hooray");
        alertDialogBuilder
                .setMessage("We've completed the stepper")
                .setCancelable(true)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                    }
                });

        // create alert dialog
        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
