package ilgulee.com.livedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityDataGenerator : ViewModel() {

    private lateinit var myRandomNumber: MutableLiveData<String>

    companion object {
        private val TAG: String? = MainActivityDataGenerator::class.java.simpleName
    }

    fun getNumber(): MutableLiveData<String> {
        Log.i(TAG, "Get number")
        if (!::myRandomNumber.isInitialized) {
            myRandomNumber=MutableLiveData()
            this.createNumber()
        }
        return myRandomNumber
    }

    public fun createNumber() {
        Log.i(TAG, "Create new number")
        val random = Random()
        myRandomNumber.value = "Number: " + (random.nextInt(10 - 1) + 1)
    }
}