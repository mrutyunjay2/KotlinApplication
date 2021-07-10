package mtj.example.RXJavaConcept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.disposables.Disposable
import mtj.example.kotlinapplication.R

class RXBindingActivity : AppCompatActivity() {

    lateinit var disposable: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxbinding)



    }
}