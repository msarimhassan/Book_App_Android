package com.example.bookapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    Context context;
    List<String> namelist;
    List<Integer> imagelist;

    public RecyclerViewAdapter(Context context, List<String> namelist, List<Integer> imagelist) {
        this.context = context;
        this.namelist = namelist;
        this.imagelist = imagelist;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.info, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       String namedata=namelist.get(position);
       int imagedata=imagelist.get(position);
       TextView book_name=holder.itemView.findViewById(R.id.book_name);
       ImageView image_name=holder.itemView.findViewById(R.id.image_name);
       book_name.setText(namedata);
       image_name.setImageResource(imagedata);

    }



    @Override
    public int getItemCount() {
        return namelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView book_name;
        ImageView image_name;
        int position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            book_name= itemView.findViewById(R.id.book_name);
            image_name=itemView.findViewById(R.id.image_name);

        }

        @Override
        public void onClick(View v) {

            int position= this.getAbsoluteAdapterPosition();
            Log.d("newresult","Clicked"+position);
            Toast.makeText(context,"The position is"+String.valueOf(position),Toast.LENGTH_SHORT).show();

            String bookname=namelist.get(position);
            int bookimage=imagelist.get(position);

            Intent intent= new Intent(context,DisplayContent.class);
            intent.putExtra("BOOK_NAME",bookname);
            intent.putExtra("BOOK_IMAGE",bookimage);

           context.startActivity(intent);



        }
    }

}
