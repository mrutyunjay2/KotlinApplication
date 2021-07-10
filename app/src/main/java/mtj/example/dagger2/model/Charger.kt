package mtj.example.dagger2.model

import android.util.Log
import javax.inject.Inject

class Charger @Inject constructor(){

    companion object{
        val TAG:String="Mobile"
    }
    init {
        Log.d(TAG,"Charger Created")
    }

    fun getChargerStatus(charger: Charger){
    Log.d(TAG,"setCharger: ${charger}")
    }
}