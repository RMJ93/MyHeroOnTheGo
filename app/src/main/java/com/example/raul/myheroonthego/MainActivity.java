package com.example.raul.myheroonthego;

import android.app.Activity;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        SearchAllStory sas = new SearchAllStory();
        sas.execute();
    }

    class SearchAllStory extends AsyncTask<String, Integer, ArrayList<AllStories>> {

        @Override
        protected ArrayList<AllStories> doInBackground(String... params) {

            executeGetAllStory getallstory = new executeGetAllStory();
            ArrayList<AllStories> stories = getallstory.GetAllStory();
            return stories;
        }

        @Override
        protected void onPostExecute(ArrayList<AllStories> allStories) {
            ArrayAdapter<AllStories> storyAdapter = new ArrayAdapter<AllStories>(MainActivity.this, android.R.layout.simple_list_item_1, allStories);
            setProgressBarIndeterminateVisibility(false);
            setContentView(R.layout.activity_main);
            registerClickCallback();
            populateListView(storyAdapter);
        }
        @Override
        protected void onPreExecute() {
            setProgressBarIndeterminateVisibility(true);
        }

    }

    private void populateListView(ArrayAdapter<AllStories> a) {
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(a);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message ="Which is string: " + textView.getText().toString();
                String tosplit = textView.getText().toString();
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                if (textView.getText().toString().contains("~")) {
                    String[] parts = tosplit.split("~");
                    String tag = parts[0];
                    if (tag.contains(":")) {
                        String[] xparts = tag.split(":");
                        String tag2 = xparts[1];
                        Toast.makeText(MainActivity.this, tag2.trim(), Toast.LENGTH_LONG).show();
                    }
                    else {

                    }
                }
                else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}