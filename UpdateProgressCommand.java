package app;

import java.util.List;
import java.util.Scanner;

public class UpdateProgressCommand
        implements Command {

    private Scanner scanner;
    private MediaAppService app;

    public UpdateProgressCommand(
            Scanner scanner,
            MediaAppService app) {

        this.scanner = scanner;
        this.app = app;
    }

    @Override
    public void execute() {

        List<UserMediaEntry> entries =
                app.getWatchQueue()
                   .getEntries();

        if (entries.isEmpty()) {

            System.out.println(
                    "There is nothing in your watch queue."
            );

            return;
        }

        app.getWatchQueue().display();

        System.out.print(
                "Choose title: "
        );

        int choice;

        try {

            choice =
                    Integer.parseInt(
                            scanner.nextLine()
                    );

        } catch (
                NumberFormatException e) {

            System.out.println(
                    "Invalid choice."
            );

            return;
        }

        if (choice < 1
                || choice > entries.size()) {

            System.out.println(
                    "Invalid choice."
            );

            return;
        }

        UserMediaEntry entry =
                entries.get(choice - 1);

        if (entry.getState()
                instanceof WantToWatchState) {

            entry.advanceStatus();

            if (entry.getState()
                    instanceof WatchingState) {

                entry.setCurrentSeason(1);

                System.out.println(
                        entry.getMedia()
                             .getTitle()
                                + " is now Watching."
                );

            } else {

                finishEntry(entry);
            }

            return;
        }

        if (entry.getState()
                instanceof WatchingState) {

            System.out.println(
                    "\n1. Update current season"
            );

            System.out.println(
                    "2. Mark show finished"
            );

            System.out.print(
                    "Choose: "
            );

            String option =
                    scanner.nextLine();

            if (option.equals("1")) {

                System.out.print(
                        "What season are you on? "
                );

                try {

                    int season =
                            Integer.parseInt(
                                    scanner.nextLine()
                            );

                    entry.setCurrentSeason(
                            season
                    );

                    System.out.println(
                            "Progress updated."
                    );

                } catch (
                        IllegalArgumentException e) {

                    System.out.println(
                            e.getMessage()
                    );
                }

            } else if (option.equals("2")) {

                entry.advanceStatus();

                finishEntry(entry);

            } else {

                System.out.println(
                        "Invalid option."
                );
            }
        }
    }

    private void finishEntry(
            UserMediaEntry entry) {

        double rating =
                ConsoleHelper.readRating(
                        scanner
                );

        System.out.print(
                "Comment (optional): "
        );

        String comment =
                scanner.nextLine();

        entry.setRating(rating);
        entry.setComment(comment);

        app.getWatchQueue()
           .remove(entry);

        app.getWatchedList()
           .addEntry(entry);

        System.out.println(
                entry.getMedia()
                     .getTitle()
                        + " moved to Watched."
        );
    }
}