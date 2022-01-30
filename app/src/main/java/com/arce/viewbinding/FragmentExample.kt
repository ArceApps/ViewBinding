package com.arce.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arce.viewbinding.databinding.FragmentExampleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentExample.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentExample : Fragment() {

    private var _binding: FragmentExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonHelloFragment.setOnClickListener{
            myToast().show()
        }
    }

    private fun myToast(): Toast{
        return Toast.makeText(activity, getString(R.string.text_hello_button_fragment), Toast.LENGTH_LONG)
    }
}