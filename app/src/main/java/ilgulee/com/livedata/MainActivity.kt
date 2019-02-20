package ilgulee.com.livedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String? = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var model = ViewModelProviders.of(this).get(MainActivityDataGenerator::class.java)
        model.getNumber().observe(this, Observer<String> {
            text_number.text = it
            Log.i(TAG, "Random number is set: " + it)
        })

        button_fetch.setOnClickListener {
            model.createNumber()
        }
    }

}
