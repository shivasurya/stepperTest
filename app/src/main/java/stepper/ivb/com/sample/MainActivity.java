package stepper.ivb.com.sample;

import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;

import stepper.ivb.com.sample.fragments.FormFragment;
import stepper.ivb.com.sample.fragments.Instruction;
import stepper.ivb.com.sample.fragments.TextFragment;
import stepper.ivb.com.sample.library.simpleMobileStepper;

public class MainActivity extends simpleMobileStepper {

   List<Class> stepperFragmentList = new ArrayList<>();


    @Override
    public List<Class> init() {
        stepperFragmentList.add(TextFragment.class);
        stepperFragmentList.add(FormFragment.class);
        stepperFragmentList.add(Instruction.class);

        return stepperFragmentList;
    }


    @Override
    public void onStepperCompleted() {
        showCompletedDialog();
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
