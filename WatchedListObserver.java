package app;

import java.util.List;

public interface WatchedListObserver {

    void update(
            List<UserMediaEntry> entries
    );
}