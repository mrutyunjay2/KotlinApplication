package mtj.example.dagger2.model

import android.util.Log

//let Assume we not own this class

class Battery  (cobalt: Cobalt, lithium: Lithium){

    companion object{
        val TAG:String="Mobile"
    }
    init {
        Log.d(TAG,"Battery Created")
    }
}