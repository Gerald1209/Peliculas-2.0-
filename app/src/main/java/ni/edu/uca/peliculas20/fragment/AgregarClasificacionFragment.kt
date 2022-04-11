package ni.edu.uca.peliculas20.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas20.R
import ni.edu.uca.peliculas20.dao.ClasificacionDao
import ni.edu.uca.peliculas20.database.MainDataBase
import ni.edu.uca.peliculas20.databinding.FragmentAgregarClasificacionBinding
import ni.edu.uca.peliculas20.entities.ClasificacionEntity

class AgregarClasificacionFragment : Fragment() {

    lateinit var binding: FragmentAgregarClasificacionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentAgregarClasificacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: ClasificacionDao = db.clasificacionDao()

        with(binding){
            btnGuardarClasif.setOnClickListener{
                val cl = ClasificacionEntity(
                    0,
                    itemAbreviacion.text.toString(),
                    true,
                    itemDescripcion.text.toString()
                )
                CoroutineScope(Dispatchers.Main).launch {
                    dao.insert(cl)
                }

                findNavController().navigate(R.id.action_agregarClasificacionFragment_to_clasificacionFragment)
            }
        }

    }

}