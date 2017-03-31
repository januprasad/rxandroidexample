package in.hatio.rxandroidexample;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jenuprasad on 30/03/17.
 */

public class MovieController {
    private final MovieView view;

    public MovieController(final MovieView mainActivity) {
        this.view = mainActivity;
    }


    public void getMovies() {
        MovieRetrofit movieRetrofit = new MovieRetrofit();
        IMovies iMovies = movieRetrofit.getiMovies();
        Observable<BasicResponse> movies = iMovies.getMovies(IMovies.APIKEY);

        movies.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BasicResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BasicResponse basicResponse) {
                        view.showMovieList(basicResponse);
                    }
                });
    }
}
