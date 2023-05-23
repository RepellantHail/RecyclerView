package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var names: MutableList<String>
    private lateinit var miRecyclerView: RecyclerView
    private lateinit var miAdapter: MyAdapter
    private lateinit var miLayoutManager: RecyclerView.LayoutManager
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        names = getAllNames()
        miRecyclerView = findViewById(R.id.recyclerView)
        miLayoutManager = LinearLayoutManager(this)
        miAdapter = MyAdapter(names, R.layout.recycler_view_item, object :MyAdapter.OnItemClickListener{
            override fun onItemClick(name: String?, position: Int) {
                Toast.makeText(this@MainActivity, name+"-"+position, Toast.LENGTH_LONG).show()
            }
        })
        miRecyclerView.setLayoutManager(miLayoutManager)
        miRecyclerView.setAdapter(miAdapter)
    }

    fun getAllNames():MutableList<String>{
        return object : ArrayList<String>(){
            init{
                add("Alejandro")
                add("Jose")
                add("Barrera")
                add("Ruben")
                add("Antonio")
                add("Ricardo")
                add("Veronica")
                add("Claudia")
                add("Ariadna")
                add("Marcos")
                add("Pablo")
                add("Sofia")
                add("Inés")
                add("Norma")
            }
        }
    }
}