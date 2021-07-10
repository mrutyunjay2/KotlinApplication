package mtj.example.dagger2.model

import android.util.Log
import javax.inject.Inject

class Mobile @Inject constructor(val battery: Battery, val processor: Processor, val camera: Camera){
    companion object{
        val TAG:String="asdf"
    }
    init {
        //Log.d(TAG,"Mobile Created mobile ${Mobile} and Battery ${battery}")
    }

    @Inject
    fun getChargerStatus(charger: Charger){
        charger.getChargerStatus(charger)
    }

    fun run(){
        Log.d(TAG,"Mobile Created mobile ${this.toString()} , Battery ${battery.toString()},Processer ${processor.toString()}")
    }

    override fun toString(): String {
        Log.d(TAG,"Mobile(battery=$battery, processor=$processor, camera=$camera)")
        return "Mobile(battery=$battery, processor=$processor, camera=$camera)"
    }

}