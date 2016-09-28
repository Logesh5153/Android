package example.app2;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import example.app2.adapter.AdapterAlbum;
import example.app2.adapter.Albums;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ActivityHome extends Activity {

	List<Albums> albums;
	private static final String url = "https://jsonplaceholder.typicode.com/albums";
	private ProgressDialog pDialog;
	AdapterAlbum mAdapter;
	ListView l1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_home);
		l1 = (ListView) findViewById(R.id.listView1);

		albums = new ArrayList<Albums>();
		pDialog = new ProgressDialog(this);
		mAdapter = new AdapterAlbum(albums, ActivityHome.this);
		l1.setAdapter(mAdapter);

		fetchAlbums();

		l1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						ActivityGallery.class);
				i.putExtra("albumid", albums.get(arg2).getId());
				startActivity(i);
			}
		});
	}

	public void fetchAlbums() {
		pDialog.setMessage("Downloading Content...");
		pDialog.show();
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		JsonArrayRequest req = new JsonArrayRequest(url,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.d("Response", response.toString());
						pDialog.hide();

						albums.clear();
						for (int i = 0; i < response.length(); i++) {
							try {
								JSONObject object = response.getJSONObject(i);
								Albums albumObj = new Albums();
								albumObj.setTitle(object.getString("title"));
								albumObj.setUserId(object.getString("userId"));
								albumObj.setId(object.getString("id"));

								albums.add(albumObj);
								mAdapter = new AdapterAlbum(albums,
										ActivityHome.this);
								l1.setAdapter(mAdapter);

							} catch (JSONException e) {
								Log.e("JsonError",
										"Json parsing error: " + e.getMessage());
							}
						}

						mAdapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("REsponse  Error", "Error: " + error.getMessage());
						pDialog.hide();
					}
				});
		queue.add(req);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

}
