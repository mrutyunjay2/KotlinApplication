package mtj.example.kotlinapplication

import android.app.Application
import android.util.Log
import mtj.example.dagger2.componet.ApplicationComponet
import mtj.example.dagger2.componet.DaggerApplicationComponet
import mtj.example.dagger2.model.Camera


class MyApplication : Application() {
    lateinit var applicationComponet: ApplicationComponet
    lateinit var camera1: Camera
    lateinit var camera2: Camera
    val TAG:String="Application"
    override fun onCreate() {
        super.onCreate()
        applicationComponet = DaggerApplicationComponet.builder().setMegapixel(68).build()
        camera1 = applicationComponet.getCamera()
        camera2 = applicationComponet.getCamera()

        Log.d(TAG,"******Application********}")

        Log.d(TAG,"Application ${camera1.toString()}")
        Log.d(TAG,"Application ${camera2.toString()}")


    }

    fun getAppComponet():ApplicationComponet{
        return applicationComponet
    }

}