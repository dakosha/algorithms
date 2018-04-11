package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dauren Mussa
 * @since 2/22/18
 */
public class WordBreak2 {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        WordBreak2 wordBreak2 = new WordBreak2();

        System.out.println(wordBreak2.wordBreak(s, dictionary));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        //Building TRIE
        TrieNode trie = new TrieNode();
        for (String word : wordDict) {
            trie.insertWord(word);
        }

        split(s.substring(1), s.substring(0, 1), result, trie, "");

        return result;
    }

    public void split(String s, String current, List<String> result, TrieNode trie, String builtString) {
        TrieNode word = trie.findWord(current, true);
        if (word != null) {
            if (s.length() == 0) {
                result.add(builtString.length()==0 ? current : builtString + " " + current);
            } else {
                //Continue
                split(s.substring(1), current + s.substring(0, 1), result, trie, builtString);
                //New Word
                split(s.substring(1), s.substring(0, 1), result, trie, builtString.length() == 0 ? current : builtString + " " + current);
            }
        } else {
            TrieNode prefix = trie.findPrefix(current);
            if (prefix != null && s.length() > 0) {
                split(s.substring(1), current + s.substring(0, 1), result, trie, builtString);
            }
        }
    }

    public static class TrieNode {

        private Character character;
        private Map<Character, TrieNode> children = new TreeMap<>();
        private TrieNode parent;
        private boolean isEnd = false;

        public TrieNode(Character character) {
            this.character = character;
        }

        public TrieNode(TrieNode parent) {
            this.parent = parent;
        }

        public TrieNode(TrieNode parent, Character character) {
            this.parent = parent;
            this.character = character;
        }

        public TrieNode() {
        }

        public void insertWord(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }

            TrieNode child = this.children.get(word.charAt(0));
            if (child == null) {
                child = new TrieNode(this, word.charAt(0));
                children.put(word.charAt(0), child);
            }

            if (word.length() == 1) {
                child.isEnd = true;
            } else {
                child.insertWord(word.substring(1));
            }
        }

        public TrieNode findWord(String word, Boolean isFinalWord) {
            if (word == null || word.isEmpty()) {
                return null;
            } else {
                TrieNode child = this.children.get(word.charAt(0));
                if (child == null) {
                    return null;
                } else {
                    if (word.length() == 1) {
                        if (isFinalWord == true && child.isEnd) {
                            return child;
                        } else if (isFinalWord == false) {
                            return child;
                        } else {
                            return null;
                        }
                    } else {
                        return child.findWord(word.substring(1), isFinalWord);
                    }
                }
            }
        }

        private void findWords(TrieNode node, List<String> list, String s) {
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                if (entry.getValue().isEnd) {
                    list.add(s + entry.getValue().character);
                }
                findWords(entry.getValue(), list, s + entry.getValue().character);
            }
        }

        public TrieNode findPrefix(String prefix) {
            TrieNode node = this.findWord(prefix, false);
            return node;
        }

        public List<String> findWordsWithPrefix(String prefix) {
            TrieNode node = this.findWord(prefix, false);

            List<String> list = new LinkedList<>();
            findWords(node, list, prefix);

            return list;
        }

    }

}
