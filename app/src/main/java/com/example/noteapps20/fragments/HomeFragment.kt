package com.example.noteapps20.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.example.noteapps20.MainActivity
import com.example.noteapps20.R
import com.example.noteapps20.adapter.NoteAdapter
import com.example.noteapps20.databinding.FragmentHomeBinding
import com.example.noteapps20.model.Note
import com.example.noteapps20.viewmodel.NoteViewModel


class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener, MenuProvider {

    private var homeBinding: FragmentHomeBinding? = null
    private val binding get() = homeBinding!!

    private lateinit var notesViewModel : NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val menuHost : MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        notesViewModel = (activity as MainActivity).noteViewModel

        binding.addNoteFab.setOnClickListener{
            it.findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
        }
    }

    private fun updateUI(note: List<Note>?){
        if(note != null){
            if(note.isEmpty())
            {
                binding.emptyNotesImage.visibility = View.GONE
                binding.homeRecyclerView.visibility = View.VISIBLE
            } else{
                binding.emptyNotesImage.visibility = View.VISIBLE
                binding.homeRecyclerView.visibility = View.GONE
            }
        }
    }


}