package ProblemSolving.LeetCodeMarchChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day7_HashMapCreation {
    class Pair<K,V> {
        public K key;
        public V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class Bucket {
        private List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<Pair<Integer, Integer>>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.key.equals(key))
                    return pair.value;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                    found = true;
                }
            }
            if (!found)
                bucket.add(new Pair<Integer, Integer>(key, value));
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.key.equals(key)) {
                    bucket.remove(pair);
                    break;
                }
            }
        }
    }

    private int hashKeySpace;
    private List<Bucket> hashTable;

    public Day7_HashMapCreation() {
        this.hashKeySpace = 2069;
        this.hashTable = new ArrayList<Bucket>();
        for (int i = 0; i < hashKeySpace; i++) {
            hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % hashKeySpace;
        this.hashTable.get(hashKey).update(key, value);
    }

    public int get(int key) {
        int hashKey = key % hashKeySpace;
        return this.hashTable.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % hashKeySpace;
        this.hashTable.get(hashKey).remove(key);
    }
}
