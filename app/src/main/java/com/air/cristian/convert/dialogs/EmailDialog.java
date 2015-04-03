package com.air.cristian.convert.dialogs;

import com.air.cristian.convert.R;
import com.air.cristian.convert.models.Email;
import com.air.cristian.convert.models.EmailDBHelper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class EmailDialog extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final View view = inflater.inflate(R.layout.dialog_email, null);

        builder.setMessage(getString(R.string.add_email))
                .setView(view)
                .setPositiveButton(getString(R.string.add_email), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EmailDBHelper email_db;
                        EditText email = (EditText) view.findViewById(R.id.editText_email);
                        EditText name = (EditText) view.findViewById(R.id.editText_name);

                        email_db = new EmailDBHelper(getActivity().getApplicationContext());
                        SQLiteDatabase db = email_db.getWritableDatabase();

                        ContentValues values = new ContentValues();
                        values.put("email", email.getText().toString());
                        values.put("name", name.getText().toString());

                        long newRowId = db.insert("email", "pk", values);

                        Toast toast = Toast.makeText(getActivity().getApplicationContext(), String.valueOf(newRowId), Toast.LENGTH_SHORT);
                        toast.show();

                    }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EmailDialog.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }
}
