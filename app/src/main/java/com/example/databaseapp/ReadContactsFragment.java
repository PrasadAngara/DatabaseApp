package com.example.databaseapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReadContactsFragment extends Fragment {

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_contacts, container, false);
        textView = v.findViewById(R.id.txt_display);
        readContacts();
        return v;
    }

    private void readContacts() {
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase db = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.readContact(db);
        String info = "";
        while (cursor.moveToNext()) {
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContractContact.ContractEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContractContact.ContractEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContractContact.ContractEntry.EMAIL));
            info = info + "\n\n" + "id is : " + id + "\n\n" + "name is :" + name + "\n\n" + "email is " + email;
        }
        textView.setText(info);
    }
}