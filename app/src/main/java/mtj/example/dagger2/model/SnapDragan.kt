package mtj.example.dagger2.model

import android.util.Log

class SnapDragan(var clkSpeed:Int) : Processor {
    companion object{
        val TAG:String="Mobile"
    }
    init {
        Log.d(TAG,"Snapdragan Run ")
    }
    override fun start() {
       Log.d(TAG,"Snapdragan start${clkSpeed} ")
    }
}