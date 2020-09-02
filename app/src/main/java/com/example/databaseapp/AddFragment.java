package com.example.databaseapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFragment extends Fragment {


    private Button button;
    private EditText Id, Name, Email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        Id = v.findViewById(R.id.conyact_id);
        Name = v.findViewById(R.id.Name);
        Email = v.findViewById(R.id.email);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase sqLiteDatabase = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id), name, email, sqLiteDatabase);
                sqLiteDatabase.close();
                Id.setText("");
                Email.setText("");
                Name.setText("");
                Toast toast = Toast.makeText(getActivity(), "saved successfully...", Toast.LENGTH_LONG);
                toast.show();

            }
        });
        return v;
    }

}