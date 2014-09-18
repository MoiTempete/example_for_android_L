package com.youku.example.moi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.youku.example.moi.R;

import java.util.ArrayList;

/**
 * Created by MoiTempete.
 */
public class GraphicsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        ListView lv = (ListView) findViewById(R.id.lv_graphics);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getTags());
        lv.setAdapter(adapter);
        //        lv.setElevation(1);

    }

    private ArrayList<String> getTags() {
        ArrayList<String>  strArray = new ArrayList<String> ();
        for (int i = 0; i < 10; i ++) {
            strArray.add("Tag Number " + i);
        }
        return  strArray;
    }
}
