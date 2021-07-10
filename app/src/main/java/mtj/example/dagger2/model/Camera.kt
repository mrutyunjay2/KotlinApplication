package mtj.example.dagger2.model

import android.util.Log

//let Assume we not own this class

class Camera (val megaPixel:Int){
    companion object{
        val TAG:String="Camera"
    }
    init {
        Log.d(TAG,"Camera Created with mp ${megaPixel}")
    }
}