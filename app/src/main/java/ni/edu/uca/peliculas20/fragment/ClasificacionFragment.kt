package ni.edu.uca.peliculas20.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas20.R
import ni.edu.uca.peliculas20.adapter.ClasificacionAdapter
import ni.edu.uca.peliculas20.dao.ClasificacionDao
import ni.edu.uca.peliculas20.database.MainDataBase
import ni.edu.uca.peliculas20.databinding.FragmentClasificacionBinding

class ClasificacionFragment : Fragment() {

    lateinit var binding: FragmentClasificacionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentClasificacionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: ClasificacionDao = db.clasificacionDao()
        CoroutineScope(Dispatchers.Main).launch {
            val list = dao.getAll()
            binding.rvClasificacion.layoutManager = LinearLayoutManager(context)
            binding.rvClasificacion.adapter = ClasificacionAdapter(list)
        }

        binding.btnAddClasificacion.setOnClickListener{
            findNavController().navigate(R.id.action_clasificacionFragment_to_agregarClasificacionFragment)
        }
    }

}