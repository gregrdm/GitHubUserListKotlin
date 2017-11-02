package gregrdm.githubuserlistkotlin.dagger;

/**
 *
 */

import javax.inject.Singleton;

import dagger.Component;
import gregrdm.githubuserlistkotlin.ui.MainActivity;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
