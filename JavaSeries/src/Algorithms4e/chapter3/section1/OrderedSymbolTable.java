package Algorithms4e.chapter3.section1;

public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int k);

    void deleteMin();

    void deleteMax();

    Iterable<Key> keys(Key lo, Key hi);
}
