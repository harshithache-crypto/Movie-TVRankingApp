package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankedDashboard
        implements WatchedListObserver {

    private List<UserMediaEntry>
            rankedEntries;

    public RankedDashboard() {

        rankedEntries =
                new ArrayList<>();
    }

    @Override
    public void update(
            List<UserMediaEntry> entries) {

        rankedEntries =
                new ArrayList<>(entries);

        rankedEntries.sort(
                Comparator.comparingDouble(
                        UserMediaEntry::getRating
                ).reversed()
        );
    }

    public List<UserMediaEntry>
            getRankedEntries() {

        return new ArrayList<>(
                rankedEntries
        );
    }

    public void display() {

        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "         MY RANKINGS"
        );

        System.out.println(
                "=============================="
        );

        if (rankedEntries.isEmpty()) {

            System.out.println(
                    "No finished titles yet."
            );

            return;
        }

        for (int i = 0;
             i < rankedEntries.size();
             i++) {

            UserMediaEntry entry =
                    rankedEntries.get(i);

            System.out.println(
                    "#"
                            + (i + 1)
                            + " "
                            + entry.getMedia()
                                   .getTitle()
                            + " - "
                            + entry.getRating()
                            + "/10"
            );

            if (!entry.getComment()
                      .isBlank()) {

                System.out.println(
                        "   \""
                                + entry.getComment()
                                + "\""
                );
            }
        }
    }
}