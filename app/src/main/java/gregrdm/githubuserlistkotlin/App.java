package gregrdm.githubuserlistkotlin;

import android.app.Application;

import gregrdm.githubuserlistkotlin.dagger.AppModule;
import gregrdm.githubuserlistkotlin.dagger.DaggerNetComponent;
import gregrdm.githubuserlistkotlin.dagger.NetComponent;
import gregrdm.githubuserlistkotlin.dagger.NetModule;

/**
 *
 */

public class App extends Application {

    private NetComponent netComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/search/"))
                .build();


    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

}
