package app;

import java.util.Scanner;

public class Main {

    public static void main(
            String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        MediaCatalog catalog =
                CatalogLoader
                        .createCatalog();

        WatchQueue watchQueue =
                new WatchQueue();

        WatchedList watchedList =
                new WatchedList();

        RankedDashboard dashboard =
                new RankedDashboard();

        PlaylistManager playlistManager =
                new PlaylistManager();

        /*
         * OBSERVER PATTERN
         *
         * RankingDashboard listens to
         * changes in WatchedList.
         */
        watchedList.addObserver(
                dashboard
        );

        MediaAppService app =
                new MediaAppService(
                        catalog,
                        watchQueue,
                        watchedList,
                        dashboard,
                        playlistManager
                );

        /*
         * COMMAND PATTERN
         */
        Menu menu =
                new Menu();

        menu.setCommand(
                1,
                new AddFinishedMediaCommand(
                        scanner,
                        app
                )
        );

        menu.setCommand(
                2,
                new AddWantToWatchCommand(
                        scanner,
                        app
                )
        );

        menu.setCommand(
                3,
                new ViewWatchQueueCommand(
                        watchQueue
                )
        );

        menu.setCommand(
                4,
                new UpdateProgressCommand(
                        scanner,
                        app
                )
        );

        menu.setCommand(
                5,
                new ViewDashboardCommand(
                        dashboard
                )
        );

        menu.setCommand(
                6,
                new RecommendationCommand(
                        scanner,
                        app
                )
        );

        menu.setCommand(
                7,
                new CreatePlaylistCommand(
                        scanner,
                        app
                )
        );

        menu.setCommand(
                8,
                new ViewPlaylistsCommand(
                        playlistManager
                )
        );

        boolean running = true;

        while (running) {

            printMenu();

            System.out.print(
                    "Choose an option: "
            );

            String input =
                    scanner.nextLine();

            try {

                int choice =
                        Integer.parseInt(input);

                if (choice == 0) {

                    running = false;

                    System.out.println(
                            "\nThanks for using ReelRank!"
                    );

                } else {

                    menu.executeCommand(
                            choice
                    );
                }

            } catch (
                    NumberFormatException e) {

                System.out.println(
                        "Please enter a valid menu number."
                );
            }
        }

        scanner.close();
    }

    private static void printMenu() {

        System.out.println(
                "\n----------------------------"
        );

        System.out.println(
                "           Ranked"
        );

        System.out.println(
                "----------------------------"
        );

        System.out.println(
                "1. Add Finished Movie / TV Show"
        );

        System.out.println(
                "2. Add to Want to Watch"
        );

        System.out.println(
                "3. View Want to Watch / Watching"
        );

        System.out.println(
                "4. Update Watching Progress"
        );

        System.out.println(
                "5. View My Ranked Dashboard"
        );

        System.out.println(
                "6. Get Recommendation"
        );

        System.out.println(
                "7. Create Playlist"
        );

        System.out.println(
                "8. View Playlists"
        );

        System.out.println(
                "0. Exit"
        );

        System.out.println(
                "----------------------------"
        );
    }
}