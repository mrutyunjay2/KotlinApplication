package mtj.example.dagger2.Module

import dagger.Binds
import dagger.Module
import mtj.example.dagger2.model.MediaTek
import mtj.example.dagger2.model.Processor
import mtj.example.dagger2.Scopes.FragmentScope

@Module
abstract class MediaTekModule {

    @FragmentScope
    @Binds
    abstract fun getProcessor(mediaTek: MediaTek): Processor
}