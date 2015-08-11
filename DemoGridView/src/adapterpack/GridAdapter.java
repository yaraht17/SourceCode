package adapterpack;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends ArrayAdapter<ImageView> {
	Context context;
	int layoutResourceId;
	ArrayList<ImageView> data = new ArrayList<ImageView>();

	public GridAdapter(Context context, int layoutResourceId,
			ArrayList<ImageView> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new RecordHolder();
			holder.txtTitle = (ImageView) row
					.findViewById(com.example.demogridview.R.id.item);

			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}

		return row;

	}

	static class RecordHolder {
		ImageView txtTitle;

	}
}
