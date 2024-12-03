package DataStructure.LinkedListTheme;

public class LinkedListParody {
    public static void main(String[] args) {
        //that the same thing as array list
        //difference just in way to interact elements
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(5);
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(2));
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
    }
}
