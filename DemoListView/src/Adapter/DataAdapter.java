package Adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demolistview.R;

import data.Data;

public class DataAdapter extends ArrayAdapter<Data> {

	private ViewHodler hodler;
	private LayoutInflater inflater;

	public DataAdapter(Context context, int textViewResourceId,
			List<Data> objects) {
		super(context, textViewResourceId, objects);
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		hodler = new ViewHodler();
		Data item = getItem(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.item, null);
			hodler.acc = (TextView) convertView.findViewById(R.id.txt_acc);

			hodler.pass = (TextView) convertView.findViewById(R.id.txt_pass);
			convertView.setTag(hodler);
		} else {
			hodler = (ViewHodler) convertView.getTag();
		}
		hodler.acc.setText(item.getAcc());
		hodler.pass.setText(item.getPass());

		return convertView;
	}

	private class ViewHodler {
		private TextView acc, pass;

	}

}
