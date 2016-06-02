package ness.tomerbu.edu.recyclerviewdemos;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SongAdapter adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SongAdapter(getLayoutInflater(), this);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_add){
            showAddDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ViewGroup layout = (ViewGroup) findViewById(R.id.layout);
        View v = getLayoutInflater().inflate(R.layout.add_song_layout ,layout, false);
        final EditText etSongName = (EditText) v.findViewById(R.id.etSongTitle);
        final EditText etArtist = (EditText) v.findViewById(R.id.etSongArtist);
        Button btnSave = (Button) v.findViewById(R.id.btnSave);
        builder.setView(v);
        final AlertDialog dialog = builder.create();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Song s = new Song(
                        etSongName.getText().toString(),
                        R.mipmap.ic_launcher,
                        etArtist.getText().toString()
                );

                Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                adapter.addSong(s);
                rv.scrollToPosition(adapter.songs.size() - 1);
            }
        });

        dialog.show();
    }

}
