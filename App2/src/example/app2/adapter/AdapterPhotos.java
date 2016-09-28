package example.app2.adapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class AdapterPhotos extends BaseAdapter {

	List<Images> images;
	Activity c;
	String s2;
	SharedPreferences pref;
	Editor editor;

	public AdapterPhotos(List<Images> images, Activity context) {
		// TODO Auto-generated constructor stub
		this.images = images;
		this.c = context;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return images.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub

		return images.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ImageView imageView = new ImageView(c);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
		Glide.with(c).load(images.get(position).getMedium()).thumbnail(0.5f)
				.crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
				.into(imageView);
		return imageView;
	}

}
