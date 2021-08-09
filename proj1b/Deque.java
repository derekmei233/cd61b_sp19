public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public Item removeFirst();
    public Item removeLast();
    public Item get(int pos);
    public Item getRecursive(int pos);
    public int size();

    default public boolean isEmpty() {
        return size() == 0;
    }
}
