package mtj.example.dagger2.componet

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import mtj.example.dagger2.model.Mobile
import mtj.example.dagger2.Module.MediaTekModule
import mtj.example.dagger2.Module.SnapdraganModule
import mtj.example.dagger2.model.Processor
import mtj.example.dagger2.Scopes.FragmentScope
import javax.inject.Named

@Subcomponent(modules = [SnapdraganModule::class])
@FragmentScope
interface FragmentComponet {

    fun getProcesser(): Processor

    fun getMobile(): Mobile

   /* @Component.Builder
    interface Builder{
        @BindsInstance
        fun setClkSpeed(@Named("clkspeed")  clkSpeed:Int):Builder
        @BindsInstance
        fun setCore(@Named("core")  core:Int):Builder

        fun setApplicationComponet(applicationComponet: ApplicationComponet):Builder
        fun setActivityComponet(activityComponet: ActivityComponet):Builder


        fun build():FragmentComponet

    }*/


}