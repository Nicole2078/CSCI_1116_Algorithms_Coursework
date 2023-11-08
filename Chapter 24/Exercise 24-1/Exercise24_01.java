/*
Author: Nicole Hackler
Date: 11/06/2023

There was source code given for this assignment Exercise24_1, MyAbstractList, MyArrayList and
the interface MyList. I only made changes and added the methods below in the assignment description.

(Add set operations in MyList) Define the following methods in MyList and implement them
in MyAbstractList:

**Adds the elements in otherList to this list.
*Return true if this list changed as a result of the call
public boolean addAll(MyList<E> otherList);

**Removes all the elements in otherList form this list
*Returns true if this list changed as a result of the call
public boolean removeAll(MyList<E> otherList);

**Retains the elements in this list that are also in otherlist
*Returns true if this list changes as a result of the call
public boolean retainAll(MyList<E> otherList);

Exercise24_01.java is a test program that creates two MyArrayLists, list 1 and list2,
with initial values {"Tom", "George", "Peter", "Jean", "Jane"} and {"Tom", "George",
"Michael", "Michelle", "Daniel"}, then perform the following operations:
1. Invokes list1.addAll(list2), and displays list1 and list2.
2. Recreates list1 and list2 with the same initial values, invokes list1.removeAll(list2),
and displays list1 and list2.
3. Recreates list1 and list2 with the same initial values, invokes list1.retainAll(list2),
and displays list1 and list2.
 */
public class Exercise24_01 {
    public static void main(String[] args) {
        new Exercise24_01();
    }

    public Exercise24_01() {
        String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] name2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};

        MyList<String> list1 = new MyArrayList<String>(name1);
        MyList<String> list2 = new MyArrayList<String>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.addAll(list2);
        System.out.println("After addAll:" + list1 + "\n");

        list1 = new MyArrayList<String>(name1);
        list2 = new MyArrayList<String>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.removeAll(list2);
        System.out.println("After removeAll:" + list1 + "\n");

        list1 = new MyArrayList<String>(name1);
        list2 = new MyArrayList<String>(name2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        list1.retainAll(list2);
        System.out.println("After retainAll:" + list1 + "\n");
    }
}
