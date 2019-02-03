package com.slobodsky.nick.fragmentwithrecyclerview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;

    List<Contact> mData;

    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Contact> mData) {

        this.mContext = mContext;

        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact, viewGroup,
                false);

        final MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Text Click " + String.valueOf(vHolder.
                                getAdapterPosition()),
                        Toast.LENGTH_SHORT).show();

                TextView dialogName = myDialog.findViewById(R.id.dialog_name);

                TextView dialogPhone = myDialog.findViewById(R.id.dialog_phone);

                ImageView dialogImage = myDialog.findViewById(R.id.dialog_image);

                dialogName.setText(mData.get(vHolder.getAdapterPosition()).getName());

                dialogPhone.setText(mData.get(vHolder.getAdapterPosition()).getPhone());

                dialogImage.setImageResource(mData.get(vHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        myDialog = new Dialog(mContext);

        myDialog.setContentView(R.layout.dialog_contact);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mData.get(i).getName());

        myViewHolder.tv_phone.setText(mData.get(i).getPhone());

        myViewHolder.img.setImageResource(mData.get(i).getImage());

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name;

        TextView tv_phone;

        ImageView img;

        LinearLayout item_contact;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_name = itemView.findViewById(R.id.name_contact);

            tv_phone = itemView.findViewById(R.id.phone_contact);

            img = itemView.findViewById(R.id.img_contact);

            item_contact = itemView.findViewById(R.id.contact_item);
        }
    }
}
