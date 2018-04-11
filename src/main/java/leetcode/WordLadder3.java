package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 11/16/17
 */
public class WordLadder3 {

    public static void main(String[] args) {

        List<String> list;

        String begin = "hit";
        String end = "cog";
        String[] array = new String[]{"hot","dot","dog","lot","log"};

        list = Arrays.asList(array);

        WordLadder3 ladder2 = new WordLadder3();
        List<List<String>> result = ladder2.findLadders(begin, end, list);

        System.out.println(result.get(0).size());

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        if (result.size()>0) {
            return result.get(0).size();
        } else {
            return 0;
        }

    }

    private List<List<String>> result = new ArrayList<>();
    private Map<String, Set<String>> steps = new HashMap<>(1000);
    private Map<String, Integer> shortestWaySteps = new HashMap<>(1000);

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> newList = new HashSet<>(1000);
        for (String v : wordList) {
            if (!v.equals(beginWord)) {
                newList.add(v);
            }
        }
        shortestWaySteps.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (true) {
            String word = queue.poll();
            if (word == null) {
                break;
            }
            if (word.equals(endWord)) {
                break;
            }

            List<String> nextStep = getNextSteps(word, newList);

            for (String nnWord : nextStep) {
                Integer shortest = shortestWaySteps.get(nnWord);

                boolean flag = false;

                if (shortest == null || shortest == 0) {
                    shortest = shortestWaySteps.get(word) + 1;
                    shortestWaySteps.put(nnWord, shortest);
                    flag = true;
                } else if (shortest == shortestWaySteps.get(word) + 1) {
                    flag = true;
                }

                if (flag) {
                    Set<String> parents = steps.get(nnWord);
                    if (parents == null) {
                        parents = new HashSet<>();
                        steps.put(nnWord, parents);
                    }
                    parents.add(word);
                    queue.add(nnWord);
                }
            }
        }

        LinkedList<String> res = new LinkedList<>();
        HashSet<String> inUse = new HashSet<>();
        generateResult(beginWord, endWord, res, inUse);

        return result;
    }

    private List<String> getNextSteps(String word, Set<String> newList) {
        LinkedList<String> next = new LinkedList<>();
        char[] w = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < w.length; i++) {
                if (w[i] == ch) continue;
                char old = w[i];
                w[i] = ch;
                if (newList.contains(String.valueOf(w))) {
                    next.add(String.valueOf(w));
                }
                w[i] = old;
            }
        }
        return next;
    }

    private void generateResult(String startWord, String endWord, LinkedList<String> res, HashSet<String> inUse) {
        inUse.add(endWord);
        res.addFirst(endWord);

        if (endWord.equals(startWord)) {
            result.add((List<String>) res.clone());
        } else {
            Set<String> from = steps.get(endWord);
            if (from != null) {
                for (String val : from) {
                    if (!inUse.contains(val)) {
                        generateResult(startWord, val, res, inUse);
                    }
                }
            }
        }

        res.removeFirst();
        inUse.remove(endWord);
    }

}
