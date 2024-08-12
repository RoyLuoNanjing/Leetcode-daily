package leetcode.medium.Q676_ImplementMagicDictionary;

public class Solution {


    class MagicDictionary {
        private TrieNode root;
        public MagicDictionary() {
            root = new TrieNode();
        }

        // Trie节点的定义
        class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    int index = c - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
                }
                node.isEndOfWord = true;
            }
        }

        public boolean search(String searchWord) {
            return searchInTrie(root, searchWord.toCharArray(), 0, 0);

        }

        // 在Trie中进行搜索，允许一次字符替换
        private boolean searchInTrie(TrieNode node, char[] word, int pos, int modified) {
            if (pos == word.length) {
                return modified == 1 && node.isEndOfWord;
            }

            int index = word[pos] - 'a';
            // 直接匹配当前字符
            if (node.children[index] != null) {
                if (searchInTrie(node.children[index], word, pos + 1, modified)) {
                    return true;
                }
            }

            // 尝试替换字符并继续搜索
            if (modified == 0) {  // 只允许一次替换
                for (int i = 0; i < 26; i++) {
                    if (i != index && node.children[i] != null) {
                        if (searchInTrie(node.children[i], word, pos + 1, modified + 1)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }
    /**
     * Comment:
     * 字典树的知识需要补强
     */
}

