package app;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private Map<Integer, Command>
            commands;

    public Menu() {

        commands = new HashMap<>();
    }

    public void setCommand(
            int number,
            Command command) {

        commands.put(
                number,
                command
        );
    }

    public void executeCommand(
            int number) {

        Command command =
                commands.get(number);

        if (command == null) {

            System.out.println(
                    "Invalid menu option."
            );

            return;
        }

        command.execute();
    }
}