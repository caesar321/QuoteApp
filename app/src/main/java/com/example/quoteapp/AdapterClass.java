package com.example.quoteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    private  List<ModalClassQuote> modalClassQuotes= new ArrayList<>();
    private Context context;

    public AdapterClass(List<ModalClassQuote> modalClassQuotes,Context context) {
        this.modalClassQuotes = modalClassQuotes;
        this.context= context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtQuote.setText(modalClassQuotes.get(position).getText());
        holder.txtAuthor.setText(modalClassQuotes.get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return modalClassQuotes.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtQuote,txtAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAuthor= itemView.findViewById(R.id.txtAuthor);
            txtQuote= itemView.findViewById(R.id.txtQuote);
        }
    }
}
