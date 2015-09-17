package com.example.nodedemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nodedemo.R;
import com.example.nodedemo.data.Person;

public class PersonAdapter extends ArrayAdapter<Person> {

	private ViewHodler hodler;
	private LayoutInflater inflater;

	public PersonAdapter(Context context, int textViewResourceId,
			List<Person> objects) {
		super(context, textViewResourceId, objects);
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		hodler = new ViewHodler();
		Person item = getItem(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.item_list, null);
			hodler.ten = (TextView) convertView.findViewById(R.id.txt_NameView);

			hodler.tuoi = (TextView) convertView.findViewById(R.id.txt_AgeView);
			hodler.diachi = (TextView) convertView.findViewById(R.id.txt_AddressView);

			convertView.setTag(hodler);
		} else {
			hodler = (ViewHodler) convertView.getTag();
		}
		hodler.ten.setText(item.getName());
		hodler.tuoi.setText(item.getAge());
		hodler.diachi.setText(item.getAddress());

		return convertView;
	}

	private class ViewHodler {
		private TextView ten, tuoi, diachi;
		
	}

}

