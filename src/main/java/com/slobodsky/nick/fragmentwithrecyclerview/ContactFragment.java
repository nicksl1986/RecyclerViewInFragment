package com.slobodsky.nick.fragmentwithrecyclerview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {

    RecyclerView recyclerView;

    List<Contact> listContact;


    public ContactFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        recyclerView = v.findViewById(R.id.contact_recyclerview);

        RecyclerViewAdapter recycleAdapter  = new RecyclerViewAdapter(getContext(), listContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(recycleAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();

        listContact.add(new Contact("John Silver", "(054) 5441234",
                R.drawable.profile1));

        listContact.add(new Contact("Ching Chong", "(054) 5451234",
                R.drawable.profile2));

        listContact.add(new Contact("Mabuto Cohen", "(054) 5461243",
                R.drawable.profile3));

        listContact.add(new Contact("John Doe", "(054) 5404321",
                R.drawable.profile4));

        listContact.add(new Contact("Jack O'Brian", "(054) 5419876",
                R.drawable.profile5));

        listContact.add(new Contact("Mark Moykens", "(054) 5422134",
                R.drawable.profile6));

        listContact.add(new Contact("Tony Smith", "(054) 5434312",
                R.drawable.profile7));

        listContact.add(new Contact("Dwight Harris", "(054) 5471002",
                R.drawable.profile8));

        listContact.add(new Contact("Donna Hilton", "(054) 5495768",
                R.drawable.profile9));

        listContact.add(new Contact("Kelsey Bell", "(054) 5441234",
                R.drawable.profile10));
    }
}
