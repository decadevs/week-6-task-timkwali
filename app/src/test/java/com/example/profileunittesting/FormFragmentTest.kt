package com.example.profileunittesting

import android.view.View
import android.widget.EditText
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FormFragmentTest {
    //EMPTY STRING IS PASSED FOR PHONE NUMBER
    @Test
    fun validatePhone_noNumber_returnTrue() {
        val value = "   "
        val name = "Phone Number"
        val checkEmpty: Boolean = FormFragment().checkIfEmpty(value, name)
        assertEquals(true, checkEmpty)
    }

    //NUMBER DOESN'T START WITH 0 OR 2
    @Test
    fun validatePhone_not0or2_returnFalse() {
        val value = "89938439493"
        val name = "Phone Number"
        val validatePhone: Boolean = FormFragment().validatePhone(value)
        assertEquals(false, validatePhone)
    }

    //NUMBERS NOT EQUAL TO 11 DIGITS
    @Test
    fun validatePhone_not11Digits_returnFalse() {
        val value = "0803843993"
        val name = "Phone Number"
        val validatePhone: Boolean = FormFragment().validatePhone(value)
        assertEquals(false, validatePhone)
    }

    //NUMBERS NOT EQUAL TO 13 DIGITS
    @Test
    fun validatePhone_not13Digits_returnFalse() {
        val value = "234384399387"
        val name = "Phone Number"
        val validatePhone: Boolean = FormFragment().validatePhone(value)
        assertEquals(false, validatePhone)
    }

    //NUMBER STARTS WITH 0 AND IS 11 DIGITS
    @Test
    fun validatePhone_valid11DigitNumber_returnTrue() {
        val value = "08056372837"
        val name = "Phone Number"
        val validatePhone: Boolean = FormFragment().validatePhone(value)
        assertEquals(true, validatePhone)
    }

    //NUMBER STARTS WITH 2 AND IS 13 DIGITS
    @Test
    fun validatePhone_valid13DigitNumber_returnTrue() {
        val value = "2348078234567"
        val name = "Phone Number"
        val validatePhone: Boolean = FormFragment().validatePhone(value)
        assertEquals(true, validatePhone)
    }
}