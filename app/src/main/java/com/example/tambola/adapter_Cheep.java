package com.example.tambola;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_Cheep extends RecyclerView.Adapter<adapter_Cheep.ViewHolder> {



    ArrayList<String> number,price,tarikh;
    Context context;


    public adapter_Cheep(ArrayList<String> number, ArrayList<String> price, ArrayList<String> tarikh, Context context) {
        this.number = number;
        this.price = price;
        this.tarikh = tarikh;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardViieeww;
        public ViewHolder (CardView v){
            super(v);
            cardViieeww = v;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(context).inflate(R.layout.cardview_cheep, parent , false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CardView cardView = holder.cardViieeww;

        TextView txtnumber=(TextView)cardView.findViewById(R.id.txtnumbersececheep);
        TextView txtprice=(TextView)cardView.findViewById(R.id.txtpricechep);
        TextView txttarikh=(TextView)cardView.findViewById(R.id.txttarikhcheep);

        txtnumber.setText(number.get(position));
        txtprice.setText(price.get(position));
        txttarikh.setText(tarikh.get(position));
    }

    @Override
    public int getItemCount() {
        return number.size();
    }}
