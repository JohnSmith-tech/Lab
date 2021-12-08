import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        String[] line;
        try {
            Scanner scanner = new Scanner(new FileReader("C://Users//79139//IdeaProjects//gitprojects//MyLab//Lab//TextFiles//text.txt"));
            Map<String, Integer> map = new HashMap<>();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().split("[, ?.']+");
                for (String str : line) {
                    if (!map.containsKey(str)) {
                        map.put(str, 1);
                    } else {
                        map.put(str, map.get(str) + 1);
                    }
                }
            }
            System.out.println(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
