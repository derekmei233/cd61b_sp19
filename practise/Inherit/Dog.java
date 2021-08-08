public class Dog implements OurComparable {
    private String name;
    private int size;
    public Dog(String n, int s) {
        name = n;
        size = s;
    }
    public void bark() {
        System.out.print(name + " says: bark");
    }

    /** Return -1 if this dog is less than the dog pointed at by o, and so force */
    @Override
    public int compareTo(Object o) {
        Dog uddaDog = (Dog) o;
        if (this.size < uddaDog.size) {
            return -1;
        } else if (this.size == uddaDog.size) {
            return 0;
        }
        return 1;
    }
}
