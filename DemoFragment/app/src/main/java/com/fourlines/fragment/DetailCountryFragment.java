package com.fourlines.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fourlines.data.Country;
import com.fourlines.demofragment.R;


public class DetailCountryFragment extends Fragment {
    public Country selectedCountry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fg_detail_country, container, false);

        TextView tvName = (TextView) layout.findViewById(R.id.tvName);
        tvName.setText(selectedCountry.name);

        TextView tvDesc = (TextView) layout.findViewById(R.id.tvDesc);
        tvDesc.setText(selectedCountry.desc);

        ImageView imageView = (ImageView) layout.findViewById(R.id.imgPhoto);
        imageView.setImageResource(selectedCountry.resId);

        return layout;
    }
}
