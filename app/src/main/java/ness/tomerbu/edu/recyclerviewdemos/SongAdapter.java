package ness.tomerbu.edu.recyclerviewdemos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by android on 02/06/2016.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private final Context context;
    //constructor that get's the inflater
    LayoutInflater inflater;
    private final ArrayList<Song> songs;


    public SongAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.songs = getSongs();
        this.context = context;
    }


    public ArrayList<Song> getSongs(){
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            songs.add(new Song("Hello", R.drawable.adele, "Adele"));
            songs.add(new Song("Nothing like you", R.drawable.rihanna, "Rihanna"));
            songs.add(new Song("Etmol Haya Tov", R.drawable.shlomo, "Shlomo Artzi"));
            songs.add(new Song("Itay", R.drawable.keren, "Keren Palas"));
        }
        return songs;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View itemView = inflater.inflate(R.layout.song_layout, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song s = songs.get(position);
        holder.tvSongName.setText(s.title);
        holder.tvArtist.setText(s.artist);
        holder.ivAlbum.setImageResource(s.imageResId);

    }

    @Override
    public int getItemCount() {
        return songs.size();
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Song song = songs.get(position);
                    Toast.makeText(context, song.title, Toast.LENGTH_SHORT).show();

                    Intent detailsIntent = new Intent(context, SongDetailsActivity.class);
                    detailsIntent.putExtra("SongName", song.title);
                    detailsIntent.putExtra("Artist", song.artist);
                    detailsIntent.putExtra("ImageResID", song.imageResId);
                    context.startActivity(detailsIntent);

                }
            });
        }
    }

}

