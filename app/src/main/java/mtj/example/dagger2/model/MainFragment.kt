package mtj.example.dagger2.model

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mtj.example.dagger2.Module.SnapdraganModule
import mtj.example.dagger2.componet.*
import mtj.example.kotlinapplication.MyApplication
import mtj.example.kotlinapplication.R

class MainFragment : Fragment() {

    lateinit var fragmentComponet:FragmentComponet
    lateinit var activityComponet: ActivityComponet
    lateinit var applicationComponet: ApplicationComponet
    lateinit var processor: Processor
    lateinit var processor1: Processor
    lateinit var battery: Battery
    lateinit var battery1: Battery

    lateinit var camera1: Camera
    lateinit var camera2: Camera
    lateinit var mobile: Mobile
    lateinit var mobile1: Mobile

    val TAG:String="Application"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        activityComponet = (activity as DaggerActivity).getDaggerActivityComponet()
        battery = activityComponet.getBattery()
        battery1 = activityComponet.getBattery()
        applicationComponet = ((activity as DaggerActivity).application as MyApplication).getAppComponet()
        camera1 = applicationComponet.getCamera()
        camera2 = applicationComponet.getCamera()

        fragmentComponet =applicationComponet.getActivityComponet().getFragmentComponet(SnapdraganModule(4))

        processor = fragmentComponet.getProcesser()
        processor1 = fragmentComponet.getProcesser()
        mobile1 = fragmentComponet.getMobile()
        mobile = fragmentComponet.getMobile()
        Log.d(TAG,"******Activity********}")

        Log.d(TAG,"Fragment ${battery.toString()}")
        Log.d(TAG,"Fragment ${battery1.toString()}")
        Log.d(TAG,"Fragment ${camera1.toString()}")
        Log.d(TAG,"Fragment ${camera2.toString()}")
        Log.d(TAG,"Fragment ${processor.toString()}")
        Log.d(TAG,"Fragment ${processor1.toString()}")

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}