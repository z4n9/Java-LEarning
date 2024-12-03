package DataStructure.LinkedListTheme;

import java.util.Arrays;

public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value){
        if(head == null){
            this.head = new Node(value);
        }
        else{
            Node temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get(int index){
        int current_ind = 0;
        Node temp = head;

        while(temp != null){
            if(current_ind == index){
                return temp.getValue();
            }
            else
                temp = temp.getNext();
                current_ind++;
        }
        throw new IllegalArgumentException();
    }

    public void remove(int index){
        int currind = 0;
        Node temp = head;

        while(temp != null){
            if(currind == index - 1){
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            }
            else
                temp = temp.getNext();
                currind++;
        }
    }

    public String toString(){
        int[] result = new int[size];

        int indx = 0;
        Node temp = head;

        while(temp != null){
            result[indx++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    private static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
