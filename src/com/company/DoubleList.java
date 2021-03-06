package com.company;

/**
 * This is a doubly linked list file that was provided that has been edited to work with this program.
 *
 * @author ryper
 * @version 1.1
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DoubleList {
    // a Node of the list
    private class Node {
        public Song data;
        public Node next;
        public Node prev;
    }

    // we keep references to the first and last nodes
    private Node head;
    private Node tail;

    // the list starts empty
    public DoubleList() {
        head = null;
        tail = null;
    }

    // add an item to the start of the list
    public void addStart(Song item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        newNode.prev = null;
        if (tail == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    // add an item to the end of the list
    public void addEnd(Song item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.prev = tail;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    // loop through the list forwards
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
            if (temp != null) {
                head = temp.prev;
            }
        }
    }

    public void shuffle() {
        ArrayList<Song> tempList = new ArrayList<Song>();
        Random randint = new Random();
        
        Node current = head;
        while (current != null) {
            tempList.add(current.data);
            current = current.next;
        }

        clear();
        Collections.shuffle(tempList);

        for (Song song : tempList) {
            addEnd(song);
        }
    }

    public void clear() {
        Node current = head;

        while (current != null) {
            remove(current.data);
            current = current.next;
        }
    }

    public void save(String fileName) {
        Node current = head;
            try {
                FileWriter writer = new FileWriter(fileName);
                while (current != null) {
                    writer.write(current.data.getArtist() + "-" + current.data.getTitle() + "\n");
                    current = current.next;
                    //writer.write(System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error! Could not write to file.");
            }
    }

    public void load(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] songInfo = data.split("-");
                String songArtist = songInfo[0];
                String songTitle = songInfo[1];
                addEnd(new Song(songArtist, songTitle));
                songInfo = null;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found. Please enter a valid file.");
        }
    }

    public void count() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("There are " + count + " songs in your playlist.");
    }

    // loop through the list backwards
    public void printBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    // remove an item based on the value
    public void remove(Song item) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(item)) {
                // remove current from list
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
            }

            current = current.next;
        }
    }

    public void removeSong(String artist, String title) {
        Node current = head;
        while (current != null) {
            if (current.data.getArtist().equals(artist) && current.data.getTitle().equals(title)) {
                remove(current.data);
            }

            current = current.next;
        }
    }
}
