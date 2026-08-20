package app;

public class WatchedState
        implements MediaState {

    @Override
    public void next(UserMediaEntry entry) {

        System.out.println(
                entry.getMedia().getTitle()
                        + " is already finished."
        );
    }

    @Override
    public String getName() {

        return "Watched";
    }
}