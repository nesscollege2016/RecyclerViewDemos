package ness.tomerbu.edu.recyclerviewdemos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by android on 02/06/2016.
 */
public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    //constructor that get's the inflater
    LayoutInflater inflater;
    public SongAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View itemView = inflater.inflate(R.layout.song_layout, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        holder.tvSongName.setText("SongName " + position);
        holder.tvArtist.setText("Artist " + position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}

//step zero:
//the mission:
//to get a view - > findViewById for the subViews;
class SongViewHolder extends RecyclerView.ViewHolder{

    ImageView ivAlbum;
    TextView tvArtist;
    TextView tvSongName;

    public SongViewHolder(View itemView) {
        super(itemView);
        ivAlbum = (ImageView) itemView.findViewById(R.id.ivAlbum);
        tvArtist = (TextView) itemView.findViewById(R.id.tvArtist);
        tvSongName = (TextView) itemView.findViewById(R.id.tvSongName);

    }
}
