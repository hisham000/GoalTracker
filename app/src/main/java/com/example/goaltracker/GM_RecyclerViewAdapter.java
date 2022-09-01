package com.example.goaltracker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class GM_RecyclerViewAdapter extends RecyclerView.Adapter<GM_RecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<GoalModel> goalModels;

    public GM_RecyclerViewAdapter(Context context, ArrayList<GoalModel> goalModels){
        this.context = context;
        this.goalModels = goalModels;
    }

    @NonNull
    @Override
    public GM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent,false);
        return new GM_RecyclerViewAdapter.MyViewHolder(view);


        //This is where we inflate the layout(giving a look to our rows)
    }

    @Override
    public void onBindViewHolder(@NonNull GM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(goalModels.get(position).getGoalName());
        holder.tvPb.setText(goalModels.get(position).getProgressPercentage());
        holder.tvDueDate.setText(goalModels.get(position).getDuedate());
        holder.imageView.setImageResource(goalModels.get(position).getimagecolor(goalModels.get(position).getImportance()));

    /*
        assigning values to the views we created in the recycler_view_row layout file
        based on the position of the recycler view
        Change data based on recycler view position for each of our items
        */
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of the items you want displayed
        return goalModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvDueDate, tvPb;
        ProgressBar pbP;


        public MyViewHolder(@NonNull View itemView) {
            //grabbing the views from our recycler view row layout file and assigning them to variables
            super(itemView);

            imageView = itemView.findViewById(R.id.Color_Imp);
            tvName = itemView.findViewById(R.id.GoalName);
            tvDueDate = itemView.findViewById(R.id.DueDate);
            tvPb = itemView.findViewById(R.id.text_view_progress);
            pbP = itemView.findViewById(R.id.progress_bar);


        }
    }

}
