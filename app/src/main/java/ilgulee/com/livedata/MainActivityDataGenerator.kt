package ilgulee.com.livedata

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityDataGenerator : ViewModel() {
    private lateinit var myRandomNumber: String

    companion object {
        private val TAG: String? = MainActivityDataGenerator::class.java.simpleName
    }

    fun getNumber(): String {
        Log.i(TAG, "Get number")
        if (!::myRandomNumber.isInitialized) {
            this.createNumber()
        }
        return myRandomNumber
    }

    private fun createNumber() {
        Log.i(TAG, "Create new number")
        val random = Random()
        myRandomNumber = "Number: " + (random.nextInt(10 - 1) + 1)

    }
}