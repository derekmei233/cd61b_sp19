public class ArrayDeque<T> {
    private static int initSize = 8;
    private static int RFactor = 2;
    private static int RRate_reci = 4;
    private int size;
    private T[] arrayT;
    private int begin;
    private int end;
    public ArrayDeque() {
        size = 0;
        arrayT = (T[]) new Object[initSize];
        begin = 0;
        end = size - 1;
    }
    public ArrayDeque(ArrayDeque other) {
        T[] newAD = (T[]) new Object[size * RFactor];
        copyHelper(other, newAD);
        arrayT = newAD;
        size = other.size;
        begin = 0;
        end = size - 1;
    }
    private void copyHelper(ArrayDeque source, T[] arrayT) {
        if (source.begin > source.end ) {
            System.arraycopy(source, source.begin, this, 0, source.arrayT.length - source.begin);
            System.arraycopy(source, 0, this, source.arrayT.length - source.begin,
                    source.size - source.arrayT.length + source.begin);
        } else {
            System.arraycopy(source, 0, this, 0, source.size);
        }
    }
    /** still need attention */
    private void reSize(boolean inc) {
        if (inc) {
            T[] newAD = (T[]) new Object[ size * RFactor];
            copyHelper(this, newAD);
            arrayT = newAD;
            begin = 0;
            end = size;
        } else {
            T[] newAD = (T[]) new Object[ size / RRate_reci];
            copyHelper(this, newAD);
            arrayT = newAD;
            begin = 0;
            end = size;
        }
    }
    public void setNewBegin(boolean inc){
        if (begin == 0){
            if (inc) {
                begin = arrayT.length - 1;
            } else {
                begin = begin - 1;
            }
        } else if (begin == arrayT.length) {
            if (inc) {
                begin -= 1;
            } else {
                begin = 0;
            }
        } else {
            if (inc) {
                begin -= 1;
            } else {
                begin += 1;
            }
        }
    }
    public void addFirst(T x) {
        if (size == arrayT.length) {
            reSize(true);
        }
        setNewBegin(true);
        arrayT[begin] = x;
        size += 1;
    }
    public T removeFirst() {
        T result = arrayT[begin];
        arrayT[begin] = null;
        setNewBegin(false);
        size -= 1;
        if (arrayT.length / RRate_reci > size) {
            reSize(false);
        }
        return result;
    }
    public void addLast(T x) {
        if (size == arrayT.length) {
            reSize(true);
        }
        size += 1;
        end += 1;
        arrayT[end] = x;
    }
    public T removeLast() {
        T result = arrayT[end];
        arrayT[end] = null;
        end -= 1;
        size -= 1;
        return result;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public T get(int pos) {
        if (begin > end) {
            int app_pos = arrayT.length - begin - 1;
            if (pos <= app_pos) {
                pos = begin + pos;
            } else {
                pos = pos - app_pos - 1;
            }
            return arrayT[pos];
        } else {
            pos = pos + begin;
            return arrayT[pos];
        }
    }
    public void printDeque() {
        int pos = 0;
        while (pos < size - 1) {
            System.out.print(get(pos));
            System.out.print(' ');
        }
        System.out.println();
    }
}