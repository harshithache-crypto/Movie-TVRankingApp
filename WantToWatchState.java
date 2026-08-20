package app;

public class WantToWatchState
        implements MediaState {

    @Override
    public void next(UserMediaEntry entry) {

        if (entry.getMedia() instanceof TVShow) {

            entry.setState(
                    new WatchingState()
            );

        } else {

            entry.setState(
                    new WatchedState()
            );
        }
    }

    @Override
    public String getName() {

        return "Want to Watch";
    }
}