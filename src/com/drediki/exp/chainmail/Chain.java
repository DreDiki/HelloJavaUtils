package com.drediki.exp.chainmail;

import java.lang.Comparable;

/**
 * https://github.com/DreDiki/HelloJavaUtils
 * Created by DreDiki on 2016/12/16.
 */
public class Chain<E extends Comparable> {
    private Node<E> head;
    private int length = 0;//// TODO: 2016/12/16 int for temp;

    public Chain() {
        //// TODO: 2016/12/16 EmptyBody ...
    }

    public Node<E> getHead() {
        return head;
    }

    /**
     * @param object
     * @deprecated Useless, just a joke method
     */
    @Deprecated
    public void setHead(E object) {
        if (head == null) {
            head = new Node<>(object);
            length++;
        } else {
            head.setCore(object);
        }
    }

    public void setHead(Node<E> head) {
        this.head = head;
        calculateLength();
    }

    public void add(E object) {
        Node<E> node = new Node<>(object);
        Node<E> last = getLast();
        if (last == null) head = node;
        else last.setNext(node);
        length++;
    }

    public void addToFront(E object) {
        Node<E> node = new Node<>(object);
        if (head == null) head = node;
        else {
            node.setNext(head);
            head = node;
        }
        length++;
    }

    public void clean() {
        head = null;//? Will the full list be gc?
        length = 0;
    }

    public void sort() {
        sort(false);
    }

    public void sort(boolean inverse) {
        Node<E> blabla = head, newHead = null, pointerNew = null, work;
        if (blabla == null || !blabla.hasNext() || sorted(head, inverse)) return;
        while (blabla != null) {
            Node<E> now = blabla;
            work = now;
            while (now != null) {
                if (inverse) {
                    if (work.getCore().compareTo(now.getCore()) < 0) {
                        work = now;
                    }
                } else {
                    if (work.getCore().compareTo(now.getCore()) > 0) {
                        work = now;
                    }
                }
                now = now.getNext();
            }
            blabla = removeFrom(blabla, work);
            if (pointerNew == null) {
                newHead = work;
                pointerNew = work;
            } else {
                pointerNew.setNext(work);
                pointerNew = pointerNew.getNext();
            }
        }
        head = newHead;
    }

    public void merge(Chain<E> another) {
        merge(false, another);
    }

    public void merge(boolean inverseSort, Chain<E> another) {
        if (!(sorted(head, inverseSort) && sorted(another.getHead(), inverseSort))) return;
        Node<E> listNew = null, listHead = null, firstOne = head, anotherOne = another.getHead();
        while (true) {
            if (firstOne == null) {
                listNew.setNext(anotherOne);
                break;
            }
            if (anotherOne == null) {
                listNew.setNext(firstOne);
                break;
            }
            if (inverseSort) {
                if (firstOne.getCore().compareTo(anotherOne.getCore()) > 0) {
                    if (listNew == null) {
                        listNew = firstOne;
                        listHead = firstOne;
                    } else {
                        listNew.setNext(firstOne);
                        listNew = listNew.getNext();
                    }
                    firstOne = firstOne.getNext();
                } else {
                    if (listNew == null) {
                        listNew = anotherOne;
                        listHead = anotherOne;
                    } else {
                        listNew.setNext(anotherOne);
                        listNew = listNew.getNext();
                    }
                    anotherOne = anotherOne.getNext();
                }
            } else {
                if (firstOne.getCore().compareTo(anotherOne.getCore()) < 0) {
                    if (listNew == null) {
                        listNew = firstOne;
                        listHead = firstOne;
                    } else {
                        listNew.setNext(firstOne);
                        listNew = listNew.getNext();
                    }
                    firstOne = firstOne.getNext();
                } else {
                    if (listNew == null) {
                        listNew = anotherOne;
                        listHead = anotherOne;
                    } else {
                        listNew.setNext(anotherOne);
                        listNew = listNew.getNext();
                    }
                    anotherOne = anotherOne.getNext();
                }
            }
        }
        head = listHead;
    }

    public boolean sorted() {
        return sorted(head, false);
    }

    public boolean sorted(Node<E> chainHead) {
        return sorted(chainHead, false);
    }

    public boolean sorted(boolean inverse) {
        return sorted(head, inverse);
    }

    @SuppressWarnings("unchecked")
    public boolean sorted(Node<E> blabla, boolean inverse) {
//        Node<E> blabla = head;
        if (blabla == null) return false;
        else if (!blabla.hasNext()) return true;
        while (blabla.hasNext()) {
            if (inverse) {
                if (blabla.getCore().compareTo(blabla.getNext().getCore()) < 0) {
                    return false;
                }
            } else {
                if (blabla.getCore().compareTo(blabla.getNext().getCore()) > 0) {
                    return false;
                }
            }
            blabla = blabla.getNext();
        }
        return true;
    }

    public void remove(Node<E> node) {
        head = removeFrom(head, node);
        length--;
    }

    public Node<E> removeFrom(Node<E> chain, Node<E> node) {
        Node<E> chainhead, last;
        chainhead = chain;
        if (chain == null || node == null) return chainhead;
        else if (chain.equals(node)) {
            chain = chain.getNext();
            return chain;
        }
        last = chain;
        while (chain != null) {
            if (node.equals(chain)) {
                last.setNext(chain.getNext());
                return chainhead;
            }
            last = chain;
            chain = chain.getNext();
        }
        return chainhead;
    }


    public boolean contains(E object) {
        Node<E> blabla = head;
        if (blabla == null) return false;
        else if (blabla.getCore().equals(object)) return true;
        while (blabla.hasNext()) {
            blabla = blabla.getNext();
            if (blabla.getCore().equals(object)) return true;
        }
        return false;
    }

    public Node<E> getLast() {
        Node<E> blabla = head;
        if (blabla == null) return null;
        while (true) {
            if (blabla.hasNext()) {
                blabla = blabla.getNext();
            } else {
                return blabla;
            }
        }
    }

    public void reverse() {
        reverseFrom(null, head);
    }

    private void reverseFrom(Node<E> first, Node<E> next) {
        if (next.hasNext()) {
            reverseFrom(next, next.getNext());
        } else {
            head = next;
        }
        next.setNext(first);
    }

    public void removeLast() {
        head = removeLast(head);
        length--;
    }

    public Node<E> removeLast(Node<E> chainHead) {
        Node<E> blabla = chainHead;
        Node<E> last = blabla;
        if (blabla == null) return chainHead;
        while (true) {
            if (blabla.hasNext()) {
                last = blabla;
                blabla = blabla.getNext();
            } else {
                last.setNext(null);
                return chainHead;
            }
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            length--;
        }
    }

    public int getLength() {
        return length;
    }

    public int calculateLength() {
        Node<E> blabla = head;
        length = 0;
        if (blabla == null) return length;
        else length++;
        while (blabla.hasNext()) {
            blabla = blabla.getNext();
            length++;
        }
        return length;
    }

    public String printChain() {
        return printChain(head);
    }

    public String printChain(Node<E> chainHead) {
        //// TODO: 2016/12/16 Will this explode?
        Node<E> blabla = chainHead;
        String s;
        if (blabla == null) return null;
        else s = blabla.getCore().toString() + "\t";
        while (blabla.hasNext()) {
            blabla = blabla.getNext();
            s += blabla.getCore().toString() + "\t";
        }
        return s;
    }

    @Override
    public String toString() {
        return "(●'◡'●)" + "@" + Integer.toHexString(hashCode());
    }
}