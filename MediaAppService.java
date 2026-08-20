package app;

public class MediaAppService {

    private MediaCatalog catalog;

    private WatchQueue watchQueue;

    private WatchedList watchedList;

    private RankedDashboard dashboard;

    private PlaylistManager playlistManager;

    public MediaAppService(
            MediaCatalog catalog,
            WatchQueue watchQueue,
            WatchedList watchedList,
            RankedDashboard dashboard,
            PlaylistManager playlistManager) {

        this.catalog = catalog;
        this.watchQueue = watchQueue;
        this.watchedList = watchedList;
        this.dashboard = dashboard;
        this.playlistManager =
                playlistManager;
    }

    public MediaCatalog getCatalog() {
        return catalog;
    }

    public WatchQueue getWatchQueue() {
        return watchQueue;
    }

    public WatchedList getWatchedList() {
        return watchedList;
    }

    public RankedDashboard getDashboard() {
        return dashboard;
    }

    public PlaylistManager getPlaylistManager() {
        return playlistManager;
    }

    public boolean isAlreadyTracked(
            Media media) {

        for (UserMediaEntry entry
                : watchQueue.getEntries()) {

            if (entry.getMedia() == media) {
                return true;
            }
        }

        for (UserMediaEntry entry
                : watchedList.getEntries()) {

            if (entry.getMedia() == media) {
                return true;
            }
        }

        return false;
    }
}