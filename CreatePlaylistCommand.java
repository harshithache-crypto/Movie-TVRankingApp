package app;

import java.util.List;
import java.util.Scanner;

public class CreatePlaylistCommand
        implements Command {

    private Scanner scanner;
    private MediaAppService app;

    public CreatePlaylistCommand(
            Scanner scanner,
            MediaAppService app) {

        this.scanner = scanner;
        this.app = app;
    }

    @Override
    public void execute() {

        System.out.print(
                "\nPlaylist name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "Public playlist? (y/n): "
        );

        boolean isPublic =
                scanner.nextLine()
                       .equalsIgnoreCase("y");

        MediaPlaylist playlist =
                new MediaPlaylist(
                        name,
                        isPublic
                );

        List<UserMediaEntry> watched =
                app.getWatchedList()
                   .getEntries();

        if (watched.isEmpty()) {

            System.out.println(
                    "You do not have any watched titles yet."
            );

            app.getPlaylistManager()
               .addPlaylist(playlist);

            return;
        }

        boolean adding = true;

        while (adding) {

            System.out.println(
                    "\nChoose a title to add:"
            );

            for (int i = 0;
                 i < watched.size();
                 i++) {

                System.out.println(
                        (i + 1)
                                + ". "
                                + watched.get(i)
                                         .getMedia()
                                         .getTitle()
                );
            }

            System.out.println(
                    "0. Finish Playlist"
            );

            System.out.print(
                    "Choose: "
            );

            try {

                int choice =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

                if (choice == 0) {

                    adding = false;

                } else if (choice >= 1
                        && choice <= watched.size()) {

                    playlist.add(
                            watched.get(choice - 1)
                                   .getMedia()
                    );

                    System.out.println(
                            "Title added."
                    );

                } else {

                    System.out.println(
                            "Invalid selection."
                    );
                }

            } catch (
                    NumberFormatException e) {

                System.out.println(
                        "Please enter a number."
                );
            }
        }

        app.getPlaylistManager()
           .addPlaylist(playlist);

        System.out.println(
                "Playlist created."
        );
    }
}