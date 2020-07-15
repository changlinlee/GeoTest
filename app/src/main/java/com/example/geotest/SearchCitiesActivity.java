package com.example.geotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchCitiesActivity extends AppCompatActivity {

    String lat, lng, gdsKey;
    EditText editLatLng;
    Button btnSearch;
    ListView listCitiesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_cities);

        editLatLng = (EditText) findViewById(R.id.edit_lat_lng);
        btnSearch = (Button) findViewById(R.id.btn_search);
        listCitiesView = (ListView) findViewById(R.id.list_nearby_cities);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] location = editLatLng.getText().toString().split("\\s+");
                lat = location[0];
                lng = location[1];
            }
        });

        gdsKey = this.getResources().getString(R.string.gds_api);
        System.out.println(gdsKey);
        GDSQuery gdsQuery = new GDSQuery();
        gdsQuery.execute("https://api.geodatasource.com/city?key=" + gdsKey + "&lat=" + lat + "&lon=" + lng + "&format=JSON");
    }

    private class GDSQuery extends AsyncTask<String, Integer, String> {


        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}