package app;

import java.util.Scanner;

public class AddWantToWatchCommand
        implements Command {

    private Scanner scanner;
    private MediaAppService app;

    public AddWantToWatchCommand(
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

        UserMediaEntry entry =
                new UserMediaEntry(
                        media,
                        new WantToWatchState()
                );

        app.getWatchQueue().add(entry);

        System.out.println(
                media.getTitle()
                        + " added to Want to Watch."
        );
    }
}