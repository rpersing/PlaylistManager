package com.company;

/**
 * This is a playlist manager program that allows the user to enter artist and song names and save them to a formatted
 * txt file
 *
 * @author ryper
 * @version 1.0
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DoubleList playlist = new DoubleList();

        System.out.println("Welcome to the Playlist Program");
        System.out.println("Commands:\n" +
                "\"add\" to add a new song\n" +
                "\"remove\" to remove a song\n" +
                "\"list\" to show your list of songs\n" +
                "\"play\" to play a song\n" +
                "\"shuffle\" to shuffle the song\n" +
                "\"reverse\" to reverse the order of your list\n" +
                "\"save\" to save your playlist\n" +
                "\"load\" to load a playlist\n" +
                "\"help\" to see the commands again" +
                "\"quit\" to exit the program");

        boolean active = true; // boolean that perpetuates the program
        Scanner commandIn = new Scanner(System.in);

        while (active){
            System.out.println("\nEnter a command: ");
            String command = commandIn.nextLine();

            if (command.equals("add")) {
                System.out.println("Who is the artist of the song?");
                String artist = commandIn.nextLine();
                System.out.println("What is the title of the song?");
                String title = commandIn.nextLine();
                playlist.addEnd(new Song(artist, title));
            }

            if (command.equals("remove")) {
                System.out.println("What artist made the song you'd like to remove?");
                String artistTBR = commandIn.nextLine();
                System.out.println("What is the name of the song you'd like to remove?");
                String songTBR = commandIn.nextLine();
                playlist.removeSong(artistTBR, songTBR);
            }

            if (command.equals("list")) {
                playlist.count();
            }

            if (command.equals("play")) {
                playlist.print();
            }

            if (command.equals("shuffle")) {
                playlist.shuffle();
            }

            if (command.equals("reverse")) {
                playlist.reverse();
            }

            if (command.equals("save")) {
                System.out.println("What file would you like to save to?");
                String fileName = commandIn.nextLine();
                playlist.save(fileName);
            }

            if (command.equals("load")) {
                System.out.println("What file would you like to load?");
                String fileName = commandIn.nextLine();
                playlist.load(fileName);
            }

            if (command.equals("help")) {
                System.out.println("Commands:\n" +
                        "\"add\" to add a new song\n" +
                        "\"remove\" to remove a song\n" +
                        "\"list\" to show your list of songs\n" +
                        "\"play\" to play a song\n" +
                        "\"shuffle\" to shuffle the song\n" +
                        "\"reverse\" to reverse the order of your list\n" +
                        "\"save\" to save your playlist\n" +
                        "\"load\" to load a playlist\n" +
                        "\"help\" to see the commands again" +
                        "\"quit\" to exit the program");
            }

            if (command.equals("quit")) {
                active = false;
            }
        }
    }
}
