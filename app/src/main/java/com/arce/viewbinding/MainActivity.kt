package com.arce.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.arce.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val list = listOf("Java", "XML", "JSON", "Kotlin", "JavaScript", "CSS", "HTML")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFragment.setOnClickListener{
            openFragment()
        }
        binding.buttonRecyclerView.setOnClickListener{
            showRecyclerView()
        }
    }

    // Another way to pass viewbinding in a method "= with(binding"
    private fun showRecyclerView() = with(binding){
        fragmentContainer.visibility = View.GONE
        listRecyclerView.visibility = View.VISIBLE

        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = MyAdapter(list)
        listRecyclerView.adapter = adapter
    }

    private fun openFragment() {
        binding.fragmentContainer.visibility = View.VISIBLE
        binding.listRecyclerView.visibility = View.GONE

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, FragmentExample())
        fragmentTransaction.commit()
    }
}