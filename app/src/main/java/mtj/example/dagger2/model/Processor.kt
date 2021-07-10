package mtj.example.dagger2.model

import android.util.Log
import javax.inject.Inject

interface Processor {

    companion object{
        val TAG:String="Mobile"
    }

    fun start()

}