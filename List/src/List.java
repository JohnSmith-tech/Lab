public class List {
    public static void main(String[] args) {
        MyList firstList = new MyList();
        for (int i = 0; i < 10; i++) {
            firstList.pushBack(i);
        }
        System.out.print("Start list ");
        firstList.printList();
        System.out.print("Reverse list ");
        firstList.reverseList();
        firstList.printList();

    }
}

