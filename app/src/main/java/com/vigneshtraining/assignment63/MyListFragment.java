package com.vigneshtraining.assignment63;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vigneshtraining.assignment63.adapter.ItemAdapter;
import com.vigneshtraining.assignment63.model.ItemObject;

import java.util.ArrayList;



public class MyListFragment extends ListFragment {

    public static String NAME="MyListFragment";

    private ListView listHolder;
    private ItemAdapter adapter;
    private ArrayList<ItemObject> dataArrayList;
    private FragmentListener myListener;
    private Integer[] imagArr={R.drawable.blogger,R.drawable.fb,R.drawable.google,R.drawable.microsoft,R.drawable.yahoo,R.drawable.youtube};
    private String[] titleArr={"Blogger","Facebook","Google","Microsoft","Yahoo","YouTube"};
    private String[] desceArr={"Create a unique and beautiful blog. It's easy and free.","Connect with friends, family and other people you know. Share photos and videos, send messages and get updates.","Popular search engine. Search the whole web or only webpages.","Microsoft Corporation is an American multinational technology company headquartered in Redmond.","The Indian edition of this major portal offers local content such as finance, sports, entertainment, news, as well as community and communication tools.","Enjoy the videos and music you love, upload original content, and share it all with friends, family, and the world on YouTube."};

    public MyListFragment() {
        // Required empty public constructor
    }


    public static MyListFragment newInstance() {
        MyListFragment fragment = new MyListFragment();

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myListener=(FragmentListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataArrayList= new ArrayList<ItemObject>();
        for (int i=0;i<imagArr.length;i++){
            ItemObject itemObj=new ItemObject();
            itemObj.setThumb(imagArr[i]);
            itemObj.setTitle(titleArr[i]);
            itemObj.setDescription(desceArr[i]);
            dataArrayList.add(itemObj);
        }



        adapter=new ItemAdapter(dataArrayList,getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        //listHolder=(ListView) view.findViewById(R.id.listHolder);
        //listHolder.setOnItemClickListener(this);
        //listHolder.setAdapter(adapter);
        setListAdapter(adapter);
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d("onItemClick", "----------------"+position);
        myListener.onItemClicked(dataArrayList.get(position));
        super.onListItemClick(l, v, position, id);
    }


}
