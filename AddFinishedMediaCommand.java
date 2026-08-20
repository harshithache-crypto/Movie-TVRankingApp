package app;

import java.util.Scanner;

public class AddFinishedMediaCommand
        implements Command {

    private Scanner scanner;
    private MediaAppService app;

    public AddFinishedMediaCommand(
            Scanner scanner,
            MediaAppService app) {

        this.scanner = scanner;
        this.app = app;
    }

    @Override
    public void execute() {

        Media media =
                ConsoleHelper.chooseMedia(
                        scanner,
                        app.getCatalog()
                );

        if (media == null) {
            return;
        }

        if (app.isAlreadyTracked(media)) {

            System.out.println(
                    "This title is already in your library."
            );

            return;
        }

        double rating =
                ConsoleHelper.readRating(
                        scanner
                );

        System.out.print(
                "Comment (optional): "
        );

        String comment =
                scanner.nextLine();

        UserMediaEntry entry =
                new UserMediaEntry(
                        media,
                        new WatchedState()
                );

        entry.setRating(rating);
        entry.setComment(comment);

        app.getWatchedList()
           .addEntry(entry);

        System.out.println(
                media.getTitle()
                        + " added to your watched list."
        );
    }
}