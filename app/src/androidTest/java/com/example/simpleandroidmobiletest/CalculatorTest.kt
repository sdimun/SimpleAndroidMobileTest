package com.example.simpleandroidmobiletest



import android.content.ComponentName
import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.UiDevice
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    private lateinit var device: UiDevice
    private lateinit var controller: CalcController
    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
        controller = CalcController(device)
    }

    @Test
    fun calculatorTest() {
        val context = InstrumentationRegistry.getInstrumentation().context

        // launch calc app
        val componentName =
            ComponentName("com.google.android.calculator", "com.android.calculator2.Calculator")
        val intent = Intent()
        intent.component = componentName
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)

        // wait for calc app appears
        device.wait(Until.hasObject(By.pkg("com.google.android.calculator").depth(0)), 5000)

        controller.performMultiplication("7", "3")
        assert(controller.getResult() == "21")

        controller.clearCalc()

        controller.performAddition("7", "3")
        assert(controller.getResult() == "10")

        controller.clearCalc()

        controller.performSubtraction("342", "341")
        assert(controller.getResult() == "1")

        controller.clearCalc()

        controller.performDivision("12", "4")
        assert(controller.getResult() == "3")

        device.executeShellCommand("am force-stop com.google.android.calculator")
    }

    @Test
    fun calculatorErrorTest() {
        val context = InstrumentationRegistry.getInstrumentation().context

        // launch calc app
        val componentName =
            ComponentName("com.google.android.calculator", "com.android.calculator2.Calculator")
        val intent = Intent()
        intent.component = componentName
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)

        // wait for calc app appears
        device.wait(Until.hasObject(By.pkg("com.google.android.calculator").depth(0)), 5000)


        controller.performDivision("7", "0")
        assert(controller.getResultForError() == "Can't divide by 0")
    }

    @After
    fun killApp() {
        device.executeShellCommand("am force-stop com.google.android.calculator")
    }

}
