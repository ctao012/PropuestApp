package com.tao.propuestaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.fragment.findNavController
import com.tao.propuestaapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFSubscribe.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonFExit.setOnClickListener {
            showAlertDialog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Salir")
        builder.setMessage("¿Quiere salir de la aplicacio sin sucribirse?")

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setPositiveButton("Si") { dialog, _ ->
            dialog.dismiss()
            // cerrar completamente la aplicación
            finishAffinity(this.requireActivity())
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}