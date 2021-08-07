public class ArrayDequeTest {
    public static void TestConstructer() {
        System.out.println("start Constructer test");
        ArrayDeque<String> ADD = new ArrayDeque<>();
        System.out.println("finished Default Constructer");
    }
    private static ArrayDeque creatTestArray(int size, boolean inc) {
        ArrayDeque<String> TAD = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            String j = String.valueOf(i);
            if (inc) {
                TAD.addLast(j);
            } else {
                TAD.addFirst(j);
            }
        }
        return TAD;
    }
    public static void TestcopyConstructer() {
        System.out.println("start copy constructer");
        ArrayDeque<String> source = creatTestArray(17, false);
        ArrayDeque<String> dest = new ArrayDeque<>(source);
        System.out.println("finished copy constructer");
    }
    public static void TestaddFirst() {
        creatTestArray(17, false);
    }
    public static void TestaddLast() {
        creatTestArray( 17, true);
    }
    public static void TestremoveFirst() {
        ArrayDeque<String> test = creatTestArray(21, false);
        int times = 21;
        while (times !=  -1) {
            test.removeFirst();
            times -= 1;
        }
    }
    public static void TestremoveLast() {
        ArrayDeque<String> test = creatTestArray(21, false);
        int times = 21;
        while (times !=  -1) {
            test.removeLast();
            times -= 1;
        }
    }
    public static void Testget() {
        ArrayDeque<String> test = creatTestArray(21, false);
        int times = 20;
        String result;
        while (times !=  -1) {
            result = test.get(times);
            times -= 1;
            System.out.print(result);
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
        TestConstructer();
        TestaddFirst();
        TestaddLast();
        TestcopyConstructer();
        TestremoveLast();
        Testget();
    }
}
