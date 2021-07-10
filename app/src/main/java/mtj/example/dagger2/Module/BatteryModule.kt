package mtj.example.dagger2.Module

import dagger.Module
import dagger.Provides
import mtj.example.dagger2.model.Battery
import mtj.example.dagger2.model.Cobalt
import mtj.example.dagger2.model.Lithium
import mtj.example.dagger2.Scopes.ActivityScope

@Module
class BatteryModule {

    @Provides
    fun getCobalt(): Cobalt {
        return Cobalt().also {
            it.cobalatModified()
        }
    }
    @Provides
    fun getLithium(): Lithium {
        return Lithium()
    }

    @ActivityScope
    @Provides
    fun getBattery(cobalt: Cobalt, lithium: Lithium): Battery {
        return  Battery(cobalt,lithium)
    }

}