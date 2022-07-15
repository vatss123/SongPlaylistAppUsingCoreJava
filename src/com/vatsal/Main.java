package com.vatsal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Album album = new Album("Album1","AC/DC");
		
		album.addSong("TNT",4.5);
		album.addSong("Highway", 3.5);
		album.addSong("ThunderStruck", 5.0);
		albums.add(album);
		
		album = new Album("Album2","Eminem");
		
		album.addSong("Ilahi",4.5);
		album.addSong("Not Afraid", 3.5);
		album.addSong("Believer", 4.5);
		albums.add(album);
		
		LinkedList<Song> playlist1 = new LinkedList<>();
		
		albums.get(0).addToPlaylist("TNT",playlist1);
		albums.get(0).addToPlaylist("Highway",playlist1);
		albums.get(1).addToPlaylist("Ilahi",playlist1);
		albums.get(1).addToPlaylist("Believer",playlist1);
		
		play(playlist1);
		
	}
	
	private static void play(LinkedList<Song> playlist) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();
		
		if(playlist.size()==0) {
			System.out.println("This playlist has no song");
		}
		else {
			System.out.println("Now playing " + listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
				
				case 0:
					System.out.println("Playlist complete");
					quit=true;
					break;
				
				case 1:
					if(forward) {
						if(listIterator.hasNext()) {
							listIterator.next();
							}
						forward = true;
					}
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
					}
					else {
						System.out.println("no song available, reached to the end of the list");
						forward=false;
					}
					break;
				case 2:
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward=false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+ listIterator.previous().toString());
					}
					else {
						System.out.println("We are at the first song");
						forward=false;
					}
					break;
				case 3:
					if(forward) {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing "+listIterator.previous().toString());
							forward=false;
						}
						else {
							System.out.println("We are at the start of the list");
						}
					}
					else {
						if(listIterator.hasNext()) {
							System.out.println("Now playing "+listIterator.next().toString());
							forward=true;
						}
						else {
							System.out.println("We have reached to the end of list");
						}
					}
					break;
				case 4:
					printList(playlist);
					break;
				case 5:
					printMenu();
				case 6:
					if(playlist.size() > 0) {
						listIterator.remove();
						if(listIterator.hasNext()) {
							System.out.println("Now playing "+listIterator.next().toString());
							
						}
						else {
							if(listIterator.hasPrevious()) {
								System.out.println("Now playing "+ listIterator.previous().toString());
							}
						}
					}
					break;
			}
		}
	}
	 
	private static void printMenu() {
		System.out.println("Available options");
		System.out.println("press");
		System.out.println("0 - to quit");
		System.out.println("1 - to play next song");
		System.out.println("2 - to play previous song");
		System.out.println("3 - replay the current song");
		System.out.println("4 - list of all songs");
		System.out.println("5 - print all available options");
		System.out.println("6 - delete current song");
	}
	
	private static void printList(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.hasNext());
		}
		System.out.println("------------------");
	}

}
