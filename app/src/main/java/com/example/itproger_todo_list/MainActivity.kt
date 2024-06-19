package com.example.itproger_todo_list

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addText : TextView = findViewById(R.id.add)
        val button : TextView = findViewById(R.id.button)
        val listView : ListView = findViewById(R.id.list_view)

        val todos : MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = listView.getItemAtPosition(i).toString() //Текст, который надо удалить
            adapter.remove(text) //Удаление
            /*Toast.makeText(this, "Мы удалили: $text", Toast.LENGTH_LONG) //Подсказка, сообщение об удалении*/
        }

        button.setOnClickListener {
            // получение инфы от пользователя / .trim() - удаляет лишние пробелы
            val text = addText.text.toString().trim()
            if (text != "")
                adapter.insert(text, 0)
        }
    }
}