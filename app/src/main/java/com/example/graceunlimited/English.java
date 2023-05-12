package com.example.graceunlimited;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class English extends Fragment implements View.OnClickListener {
    ListView listView;
    CustomAdapter customAdapter;
    String song1 ="The Lord is my shepherd I’LL not want<br>" +
            "He makes me lie in pastures green<br>" +
            "He leads me by the still still waters<br>" +
            "His goodness restores my soul<br>" +
            "<br>" +
            "Chorus<br>" +
            "And I will trust in you alone<br>" +
            "And I will trust in you alone<br>" +
            "For your endless mercy follows me<br>" +
            "Your goodness will lead me home<br>" +
            "<br>" +
            "He guides my ways in righteousness <br>" +
            "He anoints my head with oil<br>" +
            "My cup it overflows with joy<br>" +
            "I feast on his pure delight<br>" +
            "<br>" +
            "Yeah though I walk the darkest path<br>" +
            "I will not fear the evil one<br>" +
            "For you are with me and your rod and staff<br>" +
            "Are the comfort I need to know<br>" +
            "<br>";
    String song2 = "Open up the ancient gates<br>" +
            "And let the king of Glory in<br>" +
            "Open up the ancient doors<br>" +
            "And let the king of Glory in<br><br>" +
            "Who is the king of Glory<br>" +
            "Who is the king of Glory<br>" +
            "Jesus Yahweh<br>" +
            "He is the king of Glory<br>" +
            "<br>" +
            "So let the king of Glory in<br>" +
            "So let the king of Glory in<br>";

    String[] names = {"1. The Lord is my shepherd","2. Open up the ancient gates"};
    String[] desc ={song1,song2};
    List<ItemsModel> listItems = new ArrayList<>();
    SavePref savePref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //for changing theme
        savePref = new SavePref(getContext());
        if(savePref.loadNightModeState()){
            getActivity().setTheme(R.style.darkTheme);
        }
        else getActivity().setTheme(R.style.AppTheme);
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english, container, false);
        listView = view.findViewById(R.id.listview);
        for(int i = 0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],desc[i]);
            listItems.add(itemsModel);
        }
        customAdapter = new CustomAdapter(listItems,this);
        listView.setAdapter(customAdapter);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search_view){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelsList;
        private List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter( List<ItemsModel> itemsModelsList, English context) {
            this.itemsModelsList = itemsModelsList;
            this.itemsModelListFiltered = itemsModelsList;

        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_item,null);
            TextView itemName = view.findViewById(R.id.itemName);
//            TextView itemDisc = view.findViewById(R.id.itemDesc);


            itemName.setText(itemsModelListFiltered.get(position).getName());
//            itemDisc.setText(itemsModelListFiltered.get(position).getDesc());

            //onclick listener
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), itemViewActivity.class).putExtra("item",itemsModelListFiltered.get(position));
                    startActivity(intent);
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter(){

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if(constraint == null || constraint.length() == 0){
                        filterResults.count = itemsModelsList.size();
                        filterResults.values = itemsModelsList;
                    }else{
                        String searchStr = constraint.toString().toLowerCase();
                        List<ItemsModel> resultData = new ArrayList<>();

                        for(ItemsModel itemsModel:itemsModelsList){
                            if(itemsModel.getName().toString().toLowerCase().contains(searchStr) ){
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltered = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();

                }
            };
            return filter;
        }
    }
}