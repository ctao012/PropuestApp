package com.tao.propuestaapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _nameInput = MutableLiveData<String>()
    private val _lastnameInput = MutableLiveData<String>()
    private val _addressInput = MutableLiveData<String>()
    private val _phoneInput = MutableLiveData<String>()

    val nameInput: LiveData<String> get() = _nameInput

    fun setNameInput(input: String) {
        _nameInput.value = input
    }
    val lastnameInput: LiveData<String> get() = _lastnameInput

    fun setLastnameInput(input: String) {
        _lastnameInput.value = input
    }
    val addressInput: LiveData<String> get() = _addressInput

    fun setAddressInput(input: String) {
        _addressInput.value = input
    }
    val phoneInput: LiveData<String> get() = _phoneInput

    fun setPhoneInput(input: String) {
        _phoneInput.value = input
    }
}