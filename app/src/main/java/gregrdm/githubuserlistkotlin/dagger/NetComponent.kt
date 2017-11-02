package gregrdm.githubuserlistkotlin.dagger

import javax.inject.Singleton

import dagger.Component
import gregrdm.githubuserlistkotlin.ui.MainActivity

/**
 *
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface NetComponent {
    fun inject(activity: MainActivity)
}
