package ru.itis.inform;

public class LinkedList implements List {
    private Node first;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            first = newNode;
        }

        count++;
    }

    @Override
    public void remove(int element) {
        Node node = this.first;

        for(int i = 0; i < count - 2; i++) {

            if(i == 0 && node.getValue() == element) {
                first = node.getNext();
                return;
            }

            if(node.getNext().getValue() == element) {

                 if (i == count - 1) {
                    node.setNext(null);
                    return;
                } else {
                    node.setNext(node.getNext().getNext());
                    return;
                }
            }

            node = node.getNext();
        }
        count--;
    }

    public  void showList(){
        Node node1 = this.first;
        for (int i = 0; i < count - 1; i++){
            System.out.println(node1.getValue());
            node1 = node1.getNext();
        }
        System.out.println(node1);
    }
}