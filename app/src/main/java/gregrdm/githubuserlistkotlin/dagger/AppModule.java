package gregrdm.githubuserlistkotlin.dagger;

import android.app.Application;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gregrdm.githubuserlistkotlin.utils.SchedulersImpl;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 */

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    SchedulersImpl provideSchedulers() {
        return new SchedulersImpl(AndroidSchedulers.mainThread(), Schedulers.from(Executors.newFixedThreadPool(2)));
    }

}
