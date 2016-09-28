package example.app2;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import example.app2.adapter.AdapterPhotos;
import example.app2.adapter.Images;

public class ActivityGallery extends Activity {

	private static final String url = "https://jsonplaceholder.typicode.com/photos";
	private ArrayList<Images> images;
	private ProgressDialog pDialog;
	private AdapterPhotos mAdapter;
	GridView l1;
	String sAlbumId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_thumbnail);

		l1 = (GridView) findViewById(R.id.grid_view);
		Intent intent = getIntent();
		sAlbumId = intent.getExtras().getString("albumid");

		pDialog = new ProgressDialog(this);
		images = new ArrayList<Images>();
		mAdapter = new AdapterPhotos(images, ActivityGallery.this);
		l1.setAdapter(mAdapter);

		fetchImages();

		l1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Intent i = new Intent(getApplicationContext(),
						FullScreenActivity.class);
				i.putExtra("url", images.get(arg2).getLarge());
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void fetchImages() {

		pDialog.setMessage("Downloading Content...");
		pDialog.show();
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

		JsonArrayRequest req = new JsonArrayRequest(url + "?albumId="
				+ sAlbumId, new Response.Listener<JSONArray>() {
			@Override
			public void onResponse(JSONArray response) {
				Log.d("Response", response.toString());
				pDialog.hide();

				images.clear();
				for (int i = 0; i < response.length(); i++) {
					try {
						JSONObject object = response.getJSONObject(i);
						Images image = new Images();
						image.setTitle(object.getString("title"));
						image.setMedium(object.getString("thumbnailUrl"));
						image.setLarge(object.getString("url"));
						image.setId(object.getInt("id"));

						images.add(image);

						mAdapter = new AdapterPhotos(images, ActivityGallery.this);
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
}
