package com.fourlines.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fourlines.demofragment.R;
import com.fourlines.data.Country;

import java.util.ArrayList;


public class ListCountryFragment extends Fragment {
    private ListView listCountry;
    private ArrayList arrayCountry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fg_list_country, container, false);

        listCountry = (ListView) layout.findViewById(R.id.listCountry);
        listCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Chuyen sang màn hình detail
                DetailCountryFragment detailCountryFragment = new DetailCountryFragment();
                detailCountryFragment.selectedCountry = (Country) arrayCountry.get(i);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.add(R.id.mainLayout, detailCountryFragment);
                ft.replace(R.id.mainLayout, detailCountryFragment);
                ft.commit();
            }
        });

        initDataDemo();

        return layout;
    }

    private void initDataDemo() {
        arrayCountry = new ArrayList();

        Country country = new Country();
        country.name = "Vietnam";
        country.desc = "Vietnam đất nước con người";
        country.resId = R.id.icon;
        arrayCountry.add(country);

        Country country1 = new Country();
        country1.name = "Laos";
        country1.desc = "Vienchan";
        country1.resId = R.id.icon;
        arrayCountry.add(country1);

        Country country2 = new Country();
        country2.name = "Campuchia";
        country2.desc = "aaaaaaaa";
        country2.resId = R.id.icon;
        arrayCountry.add(country2);

        Country country3 = new Country();
        country3.name = "United States";
        country3.desc = "Lien bang my";
        country3.resId = R.id.icon;
        arrayCountry.add(country3);

        listCountry.setAdapter(new CountryAdapter());

    }

    private class CountryAdapter extends BaseAdapter {
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_country, null);
            }

            Country country = (Country) arrayCountry.get(i);

            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            tvName.setText(country.name);
            TextView tvDesc = (TextView) view.findViewById(R.id.tvDesc);
            tvDesc.setText(country.desc);

            return view;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public int getCount() {
            return arrayCountry.size();
        }
    }
}
