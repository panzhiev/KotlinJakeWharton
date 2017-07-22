import com.tim.kotlinjakewharton.model.JakeWhartonReposInfo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface ApiInterface {

    @GET("users/{username}/repos")
    fun listReposJakeWharton(@Path("username") username: String): Observable<List<JakeWhartonReposInfo>>
}
