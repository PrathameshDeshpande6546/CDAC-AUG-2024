import java.util.*;

public class Assignment07 {

    public static void countWordOccurrences(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void calculateMode(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int mode = array[0];
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        System.out.println("Mode: " + mode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String text = scanner.nextLine();
        countWordOccurrences(text);

        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        calculateMode(array);
    }
}
