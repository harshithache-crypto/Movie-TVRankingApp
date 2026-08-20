package app;

import java.util.ArrayList;
import java.util.List;

public class WatchQueue {

    private List<UserMediaEntry> entries;

    public WatchQueue() {

        entries = new ArrayList<>();
    }

    public void add(
            UserMediaEntry entry) {

        entries.add(entry);
    }

    public void remove(
            UserMediaEntry entry) {

        entries.remove(entry);
    }

    public List<UserMediaEntry>
            getEntries() {

        return new ArrayList<>(entries);
    }

    public void display() {

        System.out.println(
                "\n--- WANT TO WATCH / WATCHING ---"
        );

        if (entries.isEmpty()) {

            System.out.println(
                    "No titles here yet."
            );

            return;
        }

        for (int i = 0;
             i < entries.size();
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + entries.get(i)
            );
        }
    }
}