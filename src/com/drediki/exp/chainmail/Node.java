package com.drediki.exp.chainmail;

import java.lang.Comparable;

/**
 * Created by DreDiki on 2016/12/16.
 */
public class Node<E extends Comparable> {

    //    private boolean lane = true;
    private Node<E> next;
    //    private Node before;
    private E core;

    ////TODO 2016-12-16 19:12:33 Support Two Direction
    public Node(E core) {
        this.core = core;
    }

    public E getCore() {
        return core;
    }

    public void setCore(E core) {
        this.core = core;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
