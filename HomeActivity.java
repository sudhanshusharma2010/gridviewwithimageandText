package com.ramanjali.costumes;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    GridView gridView;


    int[] imageId = {
            R.mipmap.animal, R.mipmap.sea_animal, R.mipmap.insect,R.mipmap.bird,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Resources res = getResources();
        final String[] category = res.getStringArray(R.array.category);

        // Create adapter to set value for grid view

        HomeActivityAdapter homeActivityAdapter = new HomeActivityAdapter(this,category,imageId);
        gridView=(GridView)findViewById(R.id.gridview);
        gridView.setAdapter(homeActivityAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(HomeActivity.this, "GridView Item: " + category[+i], Toast.LENGTH_LONG).show();
            }
        });
    }
}
