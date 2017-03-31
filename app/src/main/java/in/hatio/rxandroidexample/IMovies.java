package in.hatio.rxandroidexample;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jenuprasad on 29/03/17.
 */

public interface IMovies {

    String APIKEY = "590ff32998282e125953205640cd20b8";
    @GET("3/discover/movie")
    Observable<BasicResponse> getMovies(@Query("api_key") String api_key);

}
