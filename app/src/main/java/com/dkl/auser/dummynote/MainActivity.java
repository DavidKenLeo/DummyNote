package com.dkl.auser.dummynote;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


        ListView listView;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            listView = (ListView) findViewById(R.id.listView);
            listView.setEmptyView(findViewById(R.id.empty));
            setAdapter();
        }

//    private String[] note_array = {
//            "Activities",
//            "Services",
//            "Content Providers",
//            "Broadcast Receiver"
//    };
//
//    private DB mDbHelper;
//
//    private void setAdapter() {
//        mDbHelper = new DB(this);
//        mDbHelper.open();
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, note_array);
//        listView.setAdapter(adapter);
//    }

        private DB mDbHelper;
        private Cursor mNotesCursor;

    private void setAdapter() {
        mDbHelper = new DB(this);
        mDbHelper.open();
        mNotesCursor = mDbHelper.getAll();
        startManagingCursor(mNotesCursor);
        String[] from = new String[]{"note"};
        int[] to = new int[]{android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, mNotesCursor, from, to);
        listView.setAdapter(adapter);
    }
}