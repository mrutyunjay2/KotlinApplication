package mtj.example.dagger2.componet

import dagger.BindsInstance
import dagger.Component
import mtj.example.dagger2.model.Camera
import mtj.example.dagger2.Module.CameraModule
import mtj.example.dagger2.Scopes.ApplicationScope
import javax.inject.Named


@Component(modules = [CameraModule::class])
@ApplicationScope
interface ApplicationComponet {

    fun getCamera(): Camera
    fun getActivityComponet():ActivityComponet

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun setMegapixel(@Named("mp") mp:Int):Builder
        fun build():ApplicationComponet

    }


}