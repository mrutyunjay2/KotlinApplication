package mtj.example.dagger2.Module

import dagger.Module
import dagger.Provides
import mtj.example.dagger2.model.Camera
import mtj.example.dagger2.Scopes.ApplicationScope
import javax.inject.Named

@Module
class CameraModule {
    @ApplicationScope
    @Provides
    fun getCamera(@Named("mp")  mp:Int)
    : Camera {
        return Camera(mp)
    }


}