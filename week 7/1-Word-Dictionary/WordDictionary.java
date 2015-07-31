package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WordDictionary {
	private ArrayList<String>[] words;
	private int CAPACITY=64;
	private int numberOfWords;
	
	public static void main(String[] args) throws IOException {
		WordDictionary d = new WordDictionary();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		while(n>0){
			StringTokenizer s = new StringTokenizer(br.readLine());
			d.command(s.nextToken(),s.nextToken());
			n--;
		}
		
	}
	
	public WordDictionary(){
		words = new ArrayList[CAPACITY];
		numberOfWords=0;
		for(int i=0; i<CAPACITY; i++){
			words[i] = new ArrayList<String>();
		}
	}
	
	private int hash(String s){
		int sum=7;
		for(int i=0; i<s.length(); i++){
			sum+=sum*13+s.charAt(i);
		}
		return Math.abs(sum)%CAPACITY;
	}
	
	private void insert(String word){
		if(numberOfWords+10>CAPACITY){
			increaseCapacity();
		}
		int key=hash(word);
		if(!contains(word)){
			words[key].add(word);
			numberOfWords++;
		}
		
	}
	
	private boolean contains(String word){
		int key = hash(word);
		if(words[key]!=null){
			for(int i=0; i<words[key].size(); i++){
				if(words[key].get(i).equals(word)){
					return true;
				}
			}
		}
		return false;
	}
	
	private void increaseCapacity(){
		int oldLength = words.length;
		CAPACITY = words.length+words.length/2;
		words = Arrays.copyOf(words, CAPACITY);
		for(int i=oldLength; i<CAPACITY; i++){
			words[i] = new ArrayList<String>();
		}
	}
	
	public void print(){
		for(int i=0; i<CAPACITY; i++){
			if(!words[i].isEmpty()){
				for(String el:words[i]){
					System.out.print(el+", ");
				}
				System.out.println();
			}
		}
	}
	public void command(String cmd, String word){
		if(cmd.equals("insert")){
			insert(word);
		}else if(cmd.equals("contains")){
			System.out.println(contains(word));
		}else{
			throw new IllegalArgumentException();
		}
	}
	
}
