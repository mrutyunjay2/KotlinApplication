package mtj.example.dagger2.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Named


class MediaTek @Inject constructor(@Named("clkspeed") var clkSpeed:Int,@Named("core") var core:Int) :
    Processor {
    companion object{
        val TAG:String="Mobile"
    }
    init {
        Log.d(TAG,"MediaTek Run clookSpeed   ${clkSpeed} and core${core} ")
    }
    override fun start() {
       Log.d(TAG,"MediaTek start ${ clkSpeed}")
    }
}