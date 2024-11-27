/*
# Design a command shell, which takes input and executes it.
# The shell should not execute commands on a blocklist. 
# The CLI should recognize control words, e.g. "show past" upon which it prints the last 10 executed commands 
or "search «string>" upon which it prints all the last executed 
# Write the code so that it is logical and maintainable with tests
# Example: # > ping 10.10.10.10 # 
# > reboot # DENIED 
# > show past 
# reboot 
# ping 10.10.10.10
 # > search ping # ping 10.10.10.10f

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Console {
    static List<String> commands = new ArrayList<>();

    public static String execute(String command) {

        String[] splitC = command.split(" ");
        String output = "";
        if (splitC[0].equals("ping")) {
            output += splitC[0] + " " + splitC[1];
        }
        if (splitC[0].equals("reboot")) {
            output += "DENIED";
        }
        if (splitC[0].equals("show") && splitC[1].equals("past")) {
            int n = 10;
            if (commands.size() < 10) {
                n = commands.size();
            }
            List<String> res = new ArrayList<>();
            for (int i = commands.size() - 1; i >= commands.size() - n; i--) {
                res.add(commands.get(i));
            }
            Collections.sort(res, Collections.reverseOrder());
            String arr[] = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = res.get(i);
            }
            output += Arrays.toString(arr);
            commands.add(command);
        }

        if (splitC[0].equals("search")) {
            List<String> subList = new ArrayList<>();
            String keyword = splitC[1];
            for (String string : commands) {
                if (string.contains(keyword)) {
                    subList.add(string);
                }

            }
            output = Arrays.toString(subList.toArray());

        }
        return output;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(">");
            String input = sc.nextLine();
            if (input.equals(null)) {
                input = sc.nextLine();
            }
            System.out.print(execute(input));
        }

    }

}
