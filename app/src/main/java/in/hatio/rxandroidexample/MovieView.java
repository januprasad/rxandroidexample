package in.hatio.rxandroidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;


public class MovieView extends AppCompatActivity {

    static final String TAG = MovieView.class.getClass().getName();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configLayout();
        rxWayofNetworkCalls();
    }

    private void hideProgress() {
        LinearLayout progressBar = (LinearLayout) findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);
    }


    private void rxWayofNetworkCalls() {
        MovieController movieController = new MovieController(this);
        movieController.getMovies();
    }

    private void configLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }


    public void showMovieList(BasicResponse basicResponse) {
        hideProgress();
        MovieListAdapter mAdapter = new MovieListAdapter(new ArrayList<>(Arrays.asList(basicResponse.getResults())));
        recyclerView.setAdapter(mAdapter);
    }
}
