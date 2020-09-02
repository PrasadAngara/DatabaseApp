package com.example.databaseapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateFragment extends Fragment {


private EditText ID,NAME,EMAIL;
private Button button_update;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_update, container, false);
       ID=v.findViewById(R.id.conyact_id1);
       NAME=v.findViewById(R.id.Name1);
       EMAIL=v.findViewById(R.id.email1);
       button_update=v.findViewById(R.id.button_del);
       button_update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
updateContact();
           }
       });

        return v;
    }private  void updateContact(){
        int id=Integer.parseInt(ID.getText().toString());
        String name=NAME.getText().toString();
        String email=EMAIL.getText().toString();

        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase db=contactDbHelper.getWritableDatabase();
        contactDbHelper.updateContact(id,name,email,db);
        db.close();
        Toast toast=Toast.makeText(getActivity(),"updated succesfully...",Toast.LENGTH_LONG);
        toast.show();
        ID.setText("");
        NAME.setText("");
        EMAIL.setText("");
    }

}