package in.hatio.rxandroidexample;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jenuprasad on 29/03/17.
 */

public class MovieRetrofit {


    static String BASEURL = "https://api.themoviedb.org/";
    static String IMAGE_SERVER = "http://image.tmdb.org/t/p/w185//";
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging).readTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS).build();



    public IMovies iMovies = new Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(httpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IMovies.class);


    public IMovies getiMovies() {
        return iMovies;
    }
}
