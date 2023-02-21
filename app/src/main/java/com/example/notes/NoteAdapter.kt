package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NoteAdapter(private val context:Context, private val listener:Click): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val textView: TextView = itemView.findViewById<TextView>(R.id.text)
        val deleteBottom: ImageView = itemView.findViewById<ImageView>(R.id.deleteBottom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val holder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))

        holder.deleteBottom.setOnClickListener {
            listener.onItemClicked(allNotes[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val current = allNotes[position]

        holder.textView.text = current.text




    }

    override fun getItemCount(): Int {

        return allNotes.size
    }

    fun updateList(list:List<Note>){

        allNotes.clear()
        allNotes.addAll(list)
        notifyDataSetChanged()
    }
}


interface  Click{

    fun onItemClicked(note:Note)
}