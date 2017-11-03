package gregrdm.githubuserlistkotlin.ui.dagger;

import dagger.Component;
import gregrdm.githubuserlistkotlin.dagger.NetComponent;
import gregrdm.githubuserlistkotlin.dagger.utils.ActivityScope;
import gregrdm.githubuserlistkotlin.ui.UserListActivity;

/**
 *
 */
@ActivityScope
@Component(modules = UserListModule.class, dependencies = NetComponent.class)
public interface UserListComponent {
    void inject(UserListActivity userListActivity);
}
