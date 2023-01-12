package com.keltron.tudoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.keltron.tudoapp.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tudoAdapter: TudoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.fabAddItem.setOnClickListener() {
            showInputAlert()
        }
        // type of layout
        binding.taskRecyclerView.layoutManager = LinearLayoutManager(this)
        tudoAdapter = TudoAdapter(mutableListOf())
        binding.taskRecyclerView.adapter = tudoAdapter
    }

    private fun showInputAlert() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Enter Your Task")
        val layout = FrameLayout(this)
        layout.setPadding(45, 15, 45, 15)

        val editText = EditText(this)
        editText.hint = "Enter a Task"
        editText.maxLines = 1

        layout.addView(editText)

        alert.setView(layout)

        alert.setPositiveButton("SAVE") { _, _ ->

            val task = editText.text.toString()
            if (task.isNotEmpty()) {
                saveTask(task)
            }
        }
        alert.setNegativeButton("CANCEl") { _, _ ->

        }
    }

    private fun saveTask(task: String) {
        val tudo = Tudo(task,false,UUID.randomUUID().toString())
        tudoAdapter.addTudo(tudo)


    }

}

