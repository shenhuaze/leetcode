package com.huaze.shen;

import java.util.*;

/**
 * @author Huaze Shen
 * @date 2020-02-12
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        dict.add(beginWord);
        bfs(endWord, dict, neighbors, distances);
        dfs(paths, path, beginWord, endWord, neighbors, distances);
        return paths;
    }

    // 从endWord开始做bfs
    private void bfs(String endWord,
                     Set<String> dict,
                     Map<String, List<String>> neighbors,
                     Map<String, Integer> distances) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(endWord);
        distances.put(endWord, 0);
        for (String word: dict) {
            neighbors.put(word, new ArrayList<>());
        }
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String nextWord: getNextWords(dict, word)) {
                neighbors.get(word).add(nextWord);
                if (!distances.containsKey(nextWord)) {
                    distances.put(nextWord, distances.get(word) + 1);
                    queue.offer(nextWord);
                }
            }
        }
    }

    private List<String> getNextWords(Set<String> dict, String word) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) {
                    continue;
                }
                String nextWord = word.substring(0, i) + c + word.substring(i + 1);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    private void dfs(List<List<String>> paths,
                     List<String> path,
                     String currentWord,
                     String endWord,
                     Map<String, List<String>> neighbors,
                     Map<String, Integer> distances) {
        path.add(currentWord);
        if (currentWord.equals(endWord)) {
            paths.add(new ArrayList<>(path));
        } else {
            for (String nextWord: neighbors.get(currentWord)) {
                if (distances.containsKey(nextWord) &&
                        distances.get(nextWord) + 1 == distances.get(currentWord)) {
                    dfs(paths, path, nextWord, endWord, neighbors, distances);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        //String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot","dot","dog","lot","log"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(new WordLadderII().findLadders("hit", "cog", wordList));
    }
}
