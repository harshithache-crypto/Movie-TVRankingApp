package app;

import java.util.ArrayList;
import java.util.List;

public class WatchedList {

    private List<UserMediaEntry>
            entries;

    private List<WatchedListObserver>
            observers;

    public WatchedList() {

        entries = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(
            WatchedListObserver observer) {

        observers.add(observer);
    }

    public void removeObserver(
            WatchedListObserver observer) {

        observers.remove(observer);
    }

    private void notifyObservers() {

        List<UserMediaEntry> copy =
                new ArrayList<>(entries);

        for (WatchedListObserver observer
                : observers) {

            observer.update(copy);
        }
    }

    public void addEntry(
            UserMediaEntry entry) {

        entries.add(entry);

        notifyObservers();
    }

    public void removeEntry(
            UserMediaEntry entry) {

        entries.remove(entry);

        notifyObservers();
    }

    public void updateRating(
            UserMediaEntry entry,
            double rating) {

        if (entries.contains(entry)) {

            entry.setRating(rating);

            notifyObservers();
        }
    }

    public List<UserMediaEntry>
            getEntries() {

        return new ArrayList<>(entries);
    }

    public boolean isEmpty() {

        return entries.isEmpty();
    }
}