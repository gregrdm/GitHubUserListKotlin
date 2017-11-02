package gregrdm.githubuserlistkotlin.network

import gregrdm.githubuserlistkotlin.network.model.UserItemContainer
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import rx.Observable

/**
 *
 */

interface UserQueryApi {

    @GET("users")
    @Headers("Authorization: Bearer 4ef5c63a8a147df75a084ab81a4274795aa245e9")
    fun getUsers(@Query("q") userName: String): Observable<UserItemContainer>
}