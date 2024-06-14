package ui.ui.actividades

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.proyecto.agendainteligente.R
import com.proyecto.agendainteligente.databinding.FragmentActividadesBinding

class ActividadesFragment : Fragment() {

    private var _binding: FragmentActividadesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val actividadesViewModel =
            ViewModelProvider(this).get(ActividadesViewModel::class.java)

        _binding = FragmentActividadesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        actividadesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it

            val spinnerMaterias = root.findViewById<Spinner>(R.id.spinner_materias)
            val optionsMaterias = arrayOf("Materia 1", "Materia 2", "Materia 3")
            spinnerMaterias.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, optionsMaterias)

        }


        return root


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

