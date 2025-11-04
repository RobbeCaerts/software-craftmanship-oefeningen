package be.ucll.crafsmanship.command.gamecontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command crossCommand = new CrossButtonCommand(receiver);
        Command triangleCommand = new TriangleButtonCommand(receiver);
        Command squareCommand = new SquareButtonCommand(receiver);
        Command circleCommand = new CircleButtonCommand(receiver);

        PS5Controller controller = new PS5Controller();
        controller.setCrossButton(crossCommand);
        controller.setTriangleButton(triangleCommand);
        controller.setSquareButton(squareCommand);
        controller.setCircleButton(circleCommand);

        var defaultMapping = getUserInput(
                "Do you want to use the default button mapping? (Y/n)",
                "Yes"
        );

        if(defaultMapping.toLowerCase().strip().startsWith("n")) {
            var buttonMap = new HashMap<Character, Command> ();

            Map<Character, String> availableOptions = new HashMap<Character, String>();
            availableOptions.put('x',"Cross button");
            availableOptions.put('t', "Triangle button");
            availableOptions.put('c', "Circle button");
            availableOptions.put('s', "Square button");

            var xButtonRemapped = getUserInput(
                    "What button do you want to map the X functionality to? \n(\n" + mapToString(availableOptions) + ")\n",
                    "x"
            );
            var xButton = xButtonRemapped.toLowerCase().strip().toCharArray()[0];
            if(!availableOptions.containsKey(xButton)) {
                xButton = 'x';
            }

            buttonMap.put(xButton, crossCommand);
            availableOptions.remove(xButton);

            var circleButtonRemapped = getUserInput(
                    "What button do you want to map the Circle functionality to? \n(\n" + mapToString(availableOptions) +
                            ")\n",
                    "c"
            );
            var circleButton = circleButtonRemapped.toLowerCase().strip().toCharArray()[0];
            if(!availableOptions.containsKey(circleButton)) {
                circleButton = 'c';
            }

            buttonMap.put(circleButton, circleCommand);
            availableOptions.remove(circleButton);

            var squareButtonRemapped = getUserInput(
                    "What button do you want to map the Square functionality to? \n(\n" + mapToString(availableOptions) +
                            ")\n",
                    "s"
            );
            var squareButton = squareButtonRemapped.toLowerCase().strip().toCharArray()[0];
            if(!availableOptions.containsKey(squareButton)) {
                squareButton = 's';
            }

            buttonMap.put(squareButton, squareCommand);
            availableOptions.remove(squareButton);


            var triangleButton = availableOptions.keySet().stream().toList();
            if(triangleButton.isEmpty()){
                System.out.println("Something went wrong with remapping. Exiting...");
                return;
            }
            buttonMap.put(triangleButton.getFirst(), triangleCommand);

            controller.setCrossButton(buttonMap.get('x'));
            controller.setTriangleButton(buttonMap.get('t'));
            controller.setSquareButton(buttonMap.get('s'));
            controller.setCircleButton(buttonMap.get('c'));

            System.out.println("\n\nbutton mapping complete: mapped buttons: \nx -> " + xButton + "\ns -> " + squareButton + "\nt -> " + triangleButton.getFirst() + "\nc -> " + circleButton + "\n");
        }

        // Simulate button presses
        controller.pressCross();
        controller.pressTriangle();
        controller.pressSquare();
        controller.pressCircle();
    }

    private static String getUserInput(String message, String defaultVal) {
        String input = null;

        System.out.print(message);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }
        if (input == null) {
            return defaultVal;
        }
        return input;
    }

    private static String mapToString(Map<Character, String> map) {
        var string = "";

        for (var key : map.keySet()) {
            string += key + " - " + map.get(key) +"\n";
        }

        return string;
    }
}
