package com.example.giorgos.interview_test;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class SecondAct extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_view);
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(MyGlobal.name);
        if (MyGlobal.URL!=null) {
            ImageView img=(ImageView) findViewById(R.id.image);
            Picasso.with(this)
                    .load(MyGlobal.URL)

                    .into(img);
        }

        else {

            ImageView img=(ImageView) findViewById(R.id.image);
            img.setImageResource(R.drawable.ic_venue_container);

        }

        if (MyGlobal.rating!=null) {
            TextView txt = (TextView) findViewById(R.id.medium_volume);
            txt.setText(MyGlobal.rating);
        }
        else {
            TextView txt = (TextView) findViewById(R.id.medium_volume);
            txt.setText("-");
        }

        if (MyGlobal.Tips!=null) {
            TextView txt = (TextView) findViewById(R.id.Tips);
            txt.setText(MyGlobal.Tips);
        }

        else {
            TextView txt = (TextView) findViewById(R.id.Tips);
            txt.setText("No tips");
        }

        if (MyGlobal.Address!=null) {
            TextView txt = (TextView) findViewById(R.id.Address);
            txt.setText(MyGlobal.Address);


        }

        else {
            TextView txt = (TextView) findViewById(R.id.Address);
            txt.setText("No Address");

        }




    }

    public void onDestroy(Bundle savedInstanceState) {
        super.onDestroy();
        //unbindDrawables(findViewById(R.id.detail_content));
        System.gc();
    }

}
