package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity(), Click {

    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = NoteAdapter(this,this)
        recyclerView.adapter = adapter


        viewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

            viewModel.allNotes.observe(this, Observer { list ->

                list?.let {

                    adapter.updateList(it)

                }

            })

    }


    override fun onItemClicked(note: Note) {

        viewModel.deleteNote(note)


    }

    fun submitData(view: View) {

        val noteText = input.text.toString()

        if(noteText.isNotEmpty()){

            viewModel.insertNote(Note(noteText))


        }
    }
}