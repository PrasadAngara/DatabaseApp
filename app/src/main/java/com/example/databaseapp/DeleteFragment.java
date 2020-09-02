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


public class DeleteFragment extends Fragment {

 private EditText ID;;
 private Button button_delete;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_delete, container, false);

        ID=v.findViewById(R.id.contact_id2);
        button_delete=v.findViewById(R.id.button_del);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
deleteContact();
            }
        });
        return v;
    }
    public  void  deleteContact(){
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase db=contactDbHelper.getWritableDatabase();
        int id=Integer.parseInt(ID.getText().toString());
        contactDbHelper.deleteContact(id,db);
        db.close();
        ID.setText("");
        Toast toast=Toast.makeText(getActivity(),"deleted successfully",Toast.LENGTH_LONG);
        toast.show();
    }
}