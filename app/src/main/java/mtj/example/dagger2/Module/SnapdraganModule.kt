package mtj.example.dagger2.Module

import dagger.Module
import dagger.Provides
import mtj.example.dagger2.model.Processor
import mtj.example.dagger2.model.SnapDragan

@Module
class SnapdraganModule(private var clkSpeed:Int) {

    @Provides
    fun getProcessor(): Processor {
        return SnapDragan(clkSpeed).also {
            it.start()
        }
    }
}