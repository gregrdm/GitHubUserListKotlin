package gregrdm.githubuserlistkotlin.ui.dagger;

import dagger.Module;
import dagger.Provides;
import gregrdm.githubuserlistkotlin.dagger.utils.ActivityScope;
import gregrdm.githubuserlistkotlin.network.UserQueryApi;
import gregrdm.githubuserlistkotlin.ui.mvp.UserListMVP;
import gregrdm.githubuserlistkotlin.ui.mvp.UserListModel;
import retrofit2.Retrofit;

/**
 *
 */
@Module
public class UserListModule {

    private final UserListMVP.View view;

    public UserListModule(UserListMVP.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    UserListMVP.View provideViewToActivity() {
        return view;
    }

    @Provides
    @ActivityScope
    UserListMVP.Model provideModel(Retrofit retrofit) {
        UserQueryApi userQueryApi = retrofit.create(UserQueryApi.class);
        return new UserListModel(userQueryApi);
    }
}
