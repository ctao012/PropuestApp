package com.tao.propuestaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tao.propuestaapp.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = sharedViewModel.nameInput.value
        val lastName = sharedViewModel.lastnameInput.value
        val address = sharedViewModel.addressInput.value
        val phone = sharedViewModel.phoneInput.value

        binding.buttonSBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.buttonSNext.setOnClickListener {

            var userInput = binding.editTextName.text.toString()
            sharedViewModel.setNameInput(userInput)
            userInput = binding.editTextLastname.text.toString()
            sharedViewModel.setLastnameInput(userInput)
            userInput = binding.editTextTextEmailAddress.text.toString()
            sharedViewModel.setAddressInput(userInput)
            userInput = binding.editTextPhone.text.toString()
            sharedViewModel.setPhoneInput(userInput)

            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}