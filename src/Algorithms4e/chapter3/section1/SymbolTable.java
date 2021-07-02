package Algorithms4e.chapter3.section1;

public interface SymbolTable<Key, Value> {

    void put(Key key, Value val);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
