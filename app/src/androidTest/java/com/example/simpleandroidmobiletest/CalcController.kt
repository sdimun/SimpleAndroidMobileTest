package com.example.simpleandroidmobiletest

import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.By

class CalcController(private val device: UiDevice) {

    fun performAddition(num1: String, num2: String) {
        clickDigit(num1)
        clickOperator("op_add")  // +
        clickDigit(num2)
        clickEquals()
    }

    fun performSubtraction(num1: String, num2: String) {
        clickDigit(num1)
        clickOperator("op_sub")  // −
        clickDigit(num2)
        clickEquals()
    }

    fun performMultiplication(num1: String, num2: String) {
        clickDigit(num1)
        clickOperator("op_mul")  // ×
        clickDigit(num2)
        clickEquals()
    }

    fun performDivision(num1: String, num2: String) {
        clickDigit(num1)
        clickOperator("op_div")  // ÷
        clickDigit(num2)
        clickEquals()
    }

    fun clearCalc(){
        clickOperator("clr")
    }

    fun getResult(): String {
        return device.findObject(By.res("com.google.android.calculator:id/result_final")).text
    }

    fun getResultForError(): String {
        return device.findObject(By.res("com.google.android.calculator:id/result_preview")).text

    }

    private fun clickDigit(digit: String) {
        digit.forEach {
            device.findObject(By.res("com.google.android.calculator:id/digit_$it")).click()
        }
    }

    private fun clickOperator(opId: String) {
        device.findObject(By.res("com.google.android.calculator:id/$opId")).click()
    }

    private fun clickEquals() {
        device.findObject(By.res("com.google.android.calculator:id/eq")).click()
    }

}


