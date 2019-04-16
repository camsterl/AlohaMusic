package edu.miracostacollege.cs134.alohamusic;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity {

    private Button ukButton;
    private Button ipButton;
    private Button hulaButton;
    private MediaPlayer ukMediaPlayer;
    private MediaPlayer ipMediaPlayer;
    private VideoView hulaVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukButton = findViewById(R.id.ukuleleButton);
        ipButton = findViewById(R.id.ipuButton);
        hulaButton = findViewById(R.id.hulaButton);

        hulaVideoView = findViewById(R.id.hulaVideoView);

        ukMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipMediaPlayer = MediaPlayer.create(this, R.raw.ipu);
        Resources res = getResources();

        String uriString = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + res.getResourcePackageName(R.raw.hula) + "/" + res.getResourceTypeName(R.raw.hula) + "/" + res.getResourceEntryName(R.raw.hula);
        hulaVideoView.setVideoURI(Uri.parse(uriString));
    }

    public void playMedia(View view)
    {
        switch (view.getId())
        {
            case R.id.ukuleleButton:


                if(ukMediaPlayer.isPlaying())
                {
                    ukMediaPlayer.pause();

                    ipButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    ukButton.setText(R.string.ukulele_button_play_text);
                }
                else {
                    ukMediaPlayer.start();
                    ipButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ukButton.setText(R.string.ukulele_button_pause_text);

                }
                break;

            case R.id.ipuButton:
                if (ipMediaPlayer.isPlaying()) {
                    ipMediaPlayer.pause();
                  
                    ukButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    ipButton.setText(R.string.ipu_button_play_text);

                } else {
                    ukButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ipButton.setText(R.string.ipu_button_pause_text);
                    ipMediaPlayer.start();
                }
                break;

            case R.id.hulaButton:
                if (hulaVideoView.isPlaying()) {
                    hulaVideoView.pause();
                    ukButton.setVisibility(View.VISIBLE);
                    ipButton.setVisibility(View.VISIBLE);
                    hulaButton.setText(R.string.hula_button_watch_text);

                }
                else{
                ipButton.setVisibility(View.INVISIBLE);
                ukButton.setVisibility(View.INVISIBLE);
                hulaButton.setText(R.string.hula_button_pause_text);
                hulaVideoView.start();
            }
                break;
        }
    }
}
