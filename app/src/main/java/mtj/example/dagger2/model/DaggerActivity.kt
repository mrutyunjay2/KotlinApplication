package mtj.example.dagger2.model


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import mtj.example.dagger2.componet.ActivityComponet
import mtj.example.dagger2.componet.ApplicationComponet
import mtj.example.kotlinapplication.MyApplication
import mtj.example.kotlinapplication.R

class DaggerActivity : AppCompatActivity() {

    lateinit var activityComponet: ActivityComponet
    lateinit var applicationComponet: ApplicationComponet
    lateinit var battery: Battery
    lateinit var battery1: Battery

    lateinit var camera1: Camera
    lateinit var camera2: Camera
    val TAG:String="Application"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        replace(MainFragment())

        applicationComponet = (application as MyApplication).getAppComponet()
        camera1 = applicationComponet.getCamera()
        camera2 = applicationComponet.getCamera()

        activityComponet = applicationComponet.getActivityComponet()
            battery = activityComponet.getBattery()
        battery1 = activityComponet.getBattery()
        Log.d(TAG,"******Activity********}")

        Log.d(TAG,"Activity ${battery.toString()}")
        Log.d(TAG,"Activity ${battery1.toString()}")
        Log.d(TAG,"Activity ${camera1.toString()}")
        Log.d(TAG,"Activity ${camera2.toString()}")
    }

    fun getDaggerActivityComponet():ActivityComponet{
        return activityComponet
    }

    fun replace(fragment:Fragment){

        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.apply {
            replace(R.id.frameLayout,fragment).commit()
        }

    }
}