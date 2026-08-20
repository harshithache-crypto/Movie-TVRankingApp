package app;

public class WatchingState
        implements MediaState {

    @Override
    public void next(UserMediaEntry entry) {

        entry.setState(
                new WatchedState()
        );
    }

    @Override
    public String getName() {

        return "Watching";
    }
}