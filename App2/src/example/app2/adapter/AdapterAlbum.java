package example.app2.adapter;

import java.util.List;

import example.app2.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterAlbum extends BaseAdapter {

	List<Albums> albums;
	Activity c;
	String s2;
	SharedPreferences pref;
	Editor editor;

	public AdapterAlbum(List<Albums> albums, Activity context) {
		this.albums = albums;
		this.c = context;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return albums.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub

		return albums.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater l = (LayoutInflater) c
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = l.inflate(R.layout.album_content, null);
		TextView tTitle = (TextView) convertView.findViewById(R.id.Title);
		TextView tAlbumId = (TextView) convertView.findViewById(R.id.albumid);
		TextView tUserId = (TextView) convertView.findViewById(R.id.userid);
		
		tTitle.setText(albums.get(position).getTitle());
		tAlbumId.setText("ID : "+albums.get(position).getId());
		tUserId.setText("Album ID : "+albums.get(position).getUserId());
		

		return convertView;
	}

}
