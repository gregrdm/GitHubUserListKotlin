package gregrdm.githubuserlistkotlin.dagger;

/**
 *
 */

import javax.inject.Singleton;

import dagger.Component;
import gregrdm.githubuserlistkotlin.utils.SchedulersImpl;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit provideRetrofit();
    SchedulersImpl provideSchedulers();
}
