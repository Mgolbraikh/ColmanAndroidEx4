package com.example.owner.mystudentappfrag;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by owner on 14-Dec-16.
 */

public class SaveAlertDialog extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Saving opperation was successful")
                .setTitle("Saving Student")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("TAG","OK pressed");
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
