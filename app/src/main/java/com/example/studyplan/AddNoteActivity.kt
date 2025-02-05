package com.example.studyplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.studyplan.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

      db = NoteDatabaseHelper(this)

      binding.saveButton.setOnClickListener{
          val date = binding.dateEditText.text.toString()
          val title = binding.titleEditText.text.toString()
          val content = binding.contentEditText.text.toString()
          val note = Note(0,date, title, content)
          db.insertNote(note)
          finish()
          Toast.makeText(this, "Study Plan Saved", Toast.LENGTH_SHORT).show()

      }
    }
}