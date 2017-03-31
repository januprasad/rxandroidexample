package in.hatio.rxandroidexample;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by jenuprasad on 29/03/17.
 */

class MovieListAdapter  extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private List<Movie> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewYear;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            this.textViewYear = (TextView) itemView.findViewById(R.id.textViewYear);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }
    }

    public MovieListAdapter(List<Movie> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())

                .inflate(R.layout.card_view, parent, false);
        context = parent.getContext();

//        view.setOnClickListener(MovieView.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewTitle;
        TextView textViewYear = holder.textViewYear;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getTitle());
        textViewYear.setText(dataSet.get(listPosition).getYear());
        Log.v(MovieView.TAG, dataSet.get(listPosition).getPoster());
        Picasso.with(context).load(MovieRetrofit.IMAGE_SERVER+""+dataSet.get(listPosition).getPoster()).into(imageView);
//        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}