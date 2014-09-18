package com.youku.example.moi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.youku.example.moi.Cheeses;
import com.youku.example.moi.R;
import com.youku.example.moi.adapter.SimpleStringAdapter;

/**
 * Created by MoiTempete.
 */
public class RecyclerViewActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);

        initHorizaontal();
    }

    private void initHorizaontal() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_horizontal);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        String[] dataset = new String[100];
        for (int i = 0; i < dataset.length; i++){
            dataset[i] = "item" + i;
        }
        recyclerView.setAdapter(new SimpleStringAdapter(this, Cheeses.sCheeseStrings) {
            @Override
            public SimpleStringAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                    int viewType) {
                final SimpleStringAdapter.ViewHolder vh = super
                        .onCreateViewHolder(parent, viewType);
                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final int pos = vh.getPosition();
                        if (pos + 1 < getItemCount()) {
                            swap(pos, pos + 1);
                        }
                    }
                });
                return vh;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
