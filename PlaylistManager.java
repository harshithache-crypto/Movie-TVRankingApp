package app;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {

    private List<MediaPlaylist>
            playlists;

    public PlaylistManager() {

        playlists =
                new ArrayList<>();
    }

    public void addPlaylist(
            MediaPlaylist playlist) {

        playlists.add(playlist);
    }

    public List<MediaPlaylist>
            getPlaylists() {

        return new ArrayList<>(
                playlists
        );
    }

    public void displayAll() {

        if (playlists.isEmpty()) {

            System.out.println(
                    "\nYou have no playlists."
            );

            return;
        }

        for (MediaPlaylist playlist
                : playlists) {

            playlist.displayComponent();
        }
    }
}