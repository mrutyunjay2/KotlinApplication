package mtj.example.dagger2.componet

import dagger.Component
import dagger.Subcomponent
import mtj.example.dagger2.model.Battery
import mtj.example.dagger2.Module.BatteryModule
import mtj.example.dagger2.Module.SnapdraganModule
import mtj.example.dagger2.Scopes.ActivityScope


@Subcomponent(modules = [BatteryModule::class])
@ActivityScope
interface ActivityComponet {

    fun getFragmentComponet(snapdraganModule: SnapdraganModule):FragmentComponet

    fun getBattery(): Battery
}