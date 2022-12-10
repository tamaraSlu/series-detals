package com.example.homework2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {
    Context context;
    String data1[],data2[],data3[];
    int images[];

    public ViewAdapter(Context context, String data1[],String data2[],int images[],String data3[])
    {
        this.context=context;
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        this.images=images;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.character_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.characterImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,SecondActivity.class);
//                intent.putExtra("data1",data1[position]);
//                intent.putExtra("data2",data2[position]);
                intent.putExtra("data3",data3[position]);
                intent.putExtra("characterImage",images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,description;
        ImageView characterImage;
        ConstraintLayout mainLayout;
        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.nameText);
            description=itemView.findViewById(R.id.descriptionText);
            characterImage=itemView.findViewById(R.id.characterImage);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
