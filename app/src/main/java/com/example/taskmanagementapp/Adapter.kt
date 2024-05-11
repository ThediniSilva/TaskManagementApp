package com.example.taskmanagementapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(var data: List<taskInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.title) // Assuming title is a TextView
        var Description: TextView = itemView.findViewById(R.id.textView) // Assuming priority is a TextView
        var priority: TextView = itemView.findViewById(R.id.priority) // Assuming priority is a TextView
        var Deadline: TextView = itemView.findViewById(R.id.textView2) // Assuming priority is a TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.taskview, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = data[position]

        // Set the background color based on priority
        when (currentItem.priority.lowercase()) {
            "high" -> holder.itemView.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.itemView.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.itemView.setBackgroundColor(Color.parseColor("#00917C"))
        }


        holder.title.text = data[position].title
        holder.Description.text = data[position].Description
        holder.priority.text = data[position].priority
        holder.Deadline.text = data[position].Deadline
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,UpdateTask::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}


//var title: TextView = itemView.findViewById(R.id.title) // Assuming title is a TextView
//var Description: TextView = itemView.findViewById(R.id.textView) // Assuming priority is a TextView
//var priority: TextView = itemView.findViewById(R.id.priority) // Assuming priority is a TextView
//var Deadline: TextView = itemView.findViewById(R.id.textView2) // Assuming priority is a TextView
//
//
//holder.title.text = data[position].title
//holder.Description.text = data[position].Description
//holder.priority.text = data[position].priority
//holder.Deadline.text = data[position].Deadline