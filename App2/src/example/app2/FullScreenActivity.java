package example.app2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;

public class FullScreenActivity extends Activity {

	String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_screen);
		Intent intent = getIntent();
		url = intent.getExtras().getString("url");

		ImageView imageView = (ImageView) findViewById(R.id.image_preview);

		Glide.with(FullScreenActivity.this).load(url).thumbnail(0.5f)
				.crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
				.into(imageView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.full_screen, menu);
		return true;
	}

}
