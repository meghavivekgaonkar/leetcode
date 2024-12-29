import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class WordLadder {
    public static int ladderLength(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {
        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> wlRules = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord =
                    word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = wlRules.getOrDefault(
                    newWord,
                    new ArrayList<>()
                );
                transformations.add(word);
                wlRules.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        // Q.add(new AbstractMap.SimpleEntry<>(beginWord, 1));
        queue.add(Map.entry(beginWord, 1));
        

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> node = queue.remove();
            String word = node.getKey();
            int hops = node.getValue();
            for (int i = 0; i < L; i++) {
                // Intermediate words for current word
                String newWord =
                    word.substring(0, i) + '*' + word.substring(i + 1, L);
                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : wlRules.getOrDefault(
                    newWord,
                    new ArrayList<>()
                )) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return hops + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(Map.entry(adjacentWord, hops + 1));
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println("Word Ladder");
        List<String> wordList = Arrays.asList("hot", "dot", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println("Result: " + ladderLength(beginWord, endWord, wordList));
    }
}