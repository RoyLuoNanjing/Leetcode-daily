package leetcode.medium.Q146_LRUCache;

import java.util.LinkedHashMap;

public class Solution_DoublyLinkedList {

    class LRUCache {
        int cap;
        LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)){
                return -1;
            }

            //将key变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)){
                //修改key的值
                cache.put(key,value);
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap){
                //链表头部就是最久未使用的key
                int oldestKey = cache.keySet().iterator().next();
                //iterator()：这会返回集合的迭代器，迭代器用于遍历集合中的元素。
                //next()：这会返回迭代器的下一个元素。在这种情况下，因为它是第一次调用 next()，所以它会返回集合中的第一个元素。
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, value);
        }



        private void makeRecently(int key){
            int val = cache.get(key);
            //删除key，重新插入到队尾
            cache.remove(key);
            cache.put(key,val);
        }
    }
    /**
     * COMMENTS:
     * 自己第一次写肯定写不出来
     * 但是思路还是比较好懂的
     * 需要掌握双向链表的一些api
     */

}
