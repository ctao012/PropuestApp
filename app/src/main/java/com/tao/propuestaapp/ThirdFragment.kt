package com.tao.propuestaapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tao.propuestaapp.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = sharedViewModel.nameInput.value
        val lastName = sharedViewModel.lastnameInput.value
        val address = sharedViewModel.addressInput.value
        val phone = sharedViewModel.phoneInput.value

        val conditions = "$name $lastName Estamos comprometidos con tu seguridad y tus datos personales. " +
                "En cumplimiento de la Ley de protección de Datos Personales 1581 de 2012 y " +
                "sus decretos reglamentarios.\n" +
                " Por favor indícanos si aceptas que LOIN se ponga en contacto contigo por el correo " +
                "electrónico: $address, por SMS, al teléfono: $phone o por cualquier otro medio electrónico con fines de marketing, " +
                "publicidad y estudios de opinión del Grupo LOIN. Asimismo, nos autorizas a enviarte " +
                "información de interés y aceptas que los datos de contacto recopilados sean analizados y " +
                "utilizados en proyectos posteriores."

        binding.textviewConditions.text = conditions

        binding.buttonTBack.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }
        binding.buttonTEnd.setOnClickListener {
            showAlertDialog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Subscripción exitosa")
        builder.setMessage("Gracias por suscribirse.")

        builder.setPositiveButton("Cerrar") { dialog, _ ->
            dialog.dismiss()
            // cerrar completamente la aplicación
            finishAffinity(this.requireActivity())
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}