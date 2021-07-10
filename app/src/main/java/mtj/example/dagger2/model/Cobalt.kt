package mtj.example.dagger2.model

import android.util.Log

class Cobalt (){

    companion object{
        val TAG:String="Cobalt"
    }
    init {
        Log.d(TAG,"cobalat Created")
    }

    fun cobalatModified(){
        Log.d(TAG,"cobalat Modified")
    }
}