package app;

import java.util.Scanner;

public class RecommendationCommand
        implements Command {

    private Scanner scanner;

    private MediaAppService app;

    public RecommendationCommand(
            Scanner scanner,
            MediaAppService app) {

        this.scanner = scanner;
        this.app = app;
    }

    @Override
    public void execute() {

        System.out.println(
                "\n1. Personalized Recommendation"
        );

        System.out.println(
                "2. Surprise Me"
        );

        System.out.print(
                "Choose: "
        );

        String option =
                scanner.nextLine();

        RecommendationEngine engine;

        if (option.equals("1")) {

            engine =
                    new RecommendationEngine(
                            new GenrePreferenceStrategy()
                    );

        } else if (option.equals("2")) {

            engine =
                    new RecommendationEngine(
                            new RandomRecommendationStrategy()
                    );

        } else {

            System.out.println(
                    "Invalid option."
            );

            return;
        }

        Media result =
                engine.recommend(
                        app.getWatchedList()
                           .getEntries(),

                        app.getCatalog()
                           .getAllMedia()
                );

        if (result == null) {

            System.out.println(
                    "Not enough information for a recommendation."
            );

            return;
        }

        System.out.println(
                "\nRecommended for you:"
        );

        System.out.println(result);
    }
}