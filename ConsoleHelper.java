package app;

import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {

    public static Media chooseMedia(
            Scanner scanner,
            MediaCatalog catalog) {

        System.out.print(
                "\nSearch for a movie/show: "
        );

        String search =
                scanner.nextLine();

        List<Media> results =
                catalog.search(search);

        if (results.isEmpty()) {

            System.out.println(
                    "No matching titles found."
            );

            return null;
        }

        System.out.println(
                "\nSearch results:"
        );

        for (int i = 0;
             i < results.size();
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + results.get(i)
            );
        }

        System.out.print(
                "Select title: "
        );

        try {

            int choice =
                    Integer.parseInt(
                            scanner.nextLine()
                    );

            if (choice < 1
                    || choice > results.size()) {

                System.out.println(
                        "Invalid selection."
                );

                return null;
            }

            return results.get(
                    choice - 1
            );

        } catch (
                NumberFormatException e) {

            System.out.println(
                    "Please enter a number."
            );

            return null;
        }
    }

    public static double readRating(
            Scanner scanner) {

        while (true) {

            System.out.print(
                    "Rating from 0-10: "
            );

            try {

                double rating =
                        Double.parseDouble(
                                scanner.nextLine()
                        );

                if (rating >= 0
                        && rating <= 10) {

                    return rating;
                }

            } catch (
                    NumberFormatException e) {
            }

            System.out.println(
                    "Please enter a number between 0 and 10."
            );
        }
    }
}