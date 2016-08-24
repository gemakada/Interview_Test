package com.example.giorgos.interview_test;

import android.*;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.DrawableRes;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Giorgos on 20/4/2016.
 */
public class Pedestrian extends AppCompatActivity  {
    private GoogleMap mMap;
    MapView mapview;
    private static final String LOG_TAG = Pedestrian.class.getSimpleName();
    //protected static final String LOG_TAG = null;
    private static View view;
    public int postflag=0;
    public ProgressDialog PD;
    public ProgressDialog PD1;
    public AlertDialog alertDialog;
    public LatLng place;
    public String para1;
    public String para2;
    public boolean flag=false;
    private BottomSheetBehavior bottomSheetBehavior;
    private BottomSheetBehavior card;
    private Button bottomSheetHeading;
    private View cardview;
    private Menu mOptionsMenu;

    //Fragment List=getFragmentManager().findFragmentById(R.id.mapfragment);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()

                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }

        setContentView(R.layout.pedestrian);
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        //setSupportActionBar(myToolbar);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.replace(R.id.mapfragment, new PedestrianMapFragment()).commit();
        PD = new ProgressDialog(Pedestrian.this);
        PD.setTitle("Please Wait..");
        PD.setMessage("Refreshing...");
        PD.setCancelable(false);

        PD1 = new ProgressDialog(Pedestrian.this);
        PD1.setTitle("Please Wait..");
        PD1.setMessage("Loging Out...");
        PD1.setCancelable(false);

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
       // card=BottomSheetBehavior.from(findViewById(R.id.bottomSheetCard));
        bottomSheetHeading = (Button) findViewById(R.id.bottomSheetHeading);

        cardview=(View)findViewById(R.id.bottomSheetCard);
        cardview.setVisibility(View.GONE);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inform the user the button has been clicked
                Log.e(LOG_TAG,"Pressed");
                v.setVisibility(View.GONE);




                PedestrianMapFragment fragment = (PedestrianMapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);
                fragment.RestoreState();
               Intent go=new Intent(getApplicationContext(), SecondAct.class);
                startActivity(go);


            }
        });
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                   // bottomSheetHeading.setText(getString(R.string.text_collapse_me));
                } else {
                   // bottomSheetHeading.setText(getString(R.string.text_expand_me));
                }

                // Check Logs to see how bottom sheets behaves
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.e("Bottom Sheet Behaviour", "STATE_SETTLING");
                        break;
                }
            }

            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });






    }
    public void onRestart() {
        super.onRestart();
        Log.e(LOG_TAG,"Ekane restart");
        MenuItem x;
        ImageView img=(ImageView) findViewById(R.id.card_image);
        img.setImageResource(R.drawable.ic_venue_container);
        x=(MenuItem)mOptionsMenu.findItem(R.id.action_pre);
        x.setVisible(false);
       // PedestrianMapFragment fragment = (PedestrianMapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);
        //fragment

    }

    public void onResume() {
        super.onResume();
        Log.e(LOG_TAG,"Ekane resume");
    }

    public void onDestroy() {
        super.onDestroy();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem x;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mOptionsMenu=menu;
        x=(MenuItem)menu.findItem(R.id.action_pre);
        x.setVisible(false);


        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {                                           //listener menu
        int id = item.getItemId();

        if(id==R.id.action_pre) {
            cardview.setVisibility(View.GONE);
            item.setVisible(false);
            PedestrianMapFragment fragment = (PedestrianMapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);
            fragment.RestoreState();
            ImageView img=(ImageView) findViewById(R.id.card_image);
            img.setImageResource(R.drawable.ic_venue_container);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }














        public void MakeText(String txt) {
            Toast.makeText(getBaseContext(), txt, Toast.LENGTH_SHORT).show();
        }


        public void AppearCard(Venue x ) {
            MyGlobal.name=null;
            MyGlobal.Address=null;
            MyGlobal.Tips=null;
            MyGlobal.URL=null;
            MyGlobal.rating=null;



                MyGlobal.name=x.getName();
                MyGlobal.Address=x.getLocation().getAddress();
                MyGlobal.Tips=x.getTips();
                MyGlobal.rating=x.getRating();
                MyGlobal.URL=x.getLink();




                TextView txt=(TextView)findViewById(R.id.card_title);
                ImageView img=(ImageView) findViewById(R.id.card_image);
                txt.setText(x.getName());
                txt=(TextView)findViewById(R.id.card_text);
                txt.setText(x.getLocation().getAddress());
                txt=(TextView)findViewById(R.id.medium_volume);
                txt.setText(x.getRating());
                txt=(TextView)findViewById(R.id.card_text3);
                txt.setText(x.getCategory());
                if(x.getLink()!=null) {
                    Picasso.with(this)
                            .load(x.getLink())

                            .into(img);
                }

            cardview.setVisibility(View.VISIBLE);
                MenuItem btn;
                btn=(MenuItem)mOptionsMenu.findItem(R.id.action_pre);
                btn.setVisible(true);

        }

    public void setText(String text) {
        TextView txt;
        txt=(TextView)findViewById(R.id.bottomSheetTxt);
        txt.setText(text);


    }









}
