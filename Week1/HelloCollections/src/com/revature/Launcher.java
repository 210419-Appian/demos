package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//import java.util.*; This would import ALL of the Collections Framework/API
//this is MEMORY INTENSIVE so if you wanted only one or two classes, just import them specifically

import com.revature.models.Pokemon; //Import our Pokemon class so we can instantiate and use

//Collections are like Arrays in that they are objects that hold things
//but specifically, they hold references to other objects

//unlike Arrays, collections can change size DYNAMICALLY
//there are MANY flavors of Collections, we'll touch on some below

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("================================================(Lists)");
		
		//ArrayList is a very common implementation of the List Interface
		List<Pokemon> myPokemon = new ArrayList<>(); //empty ArrayList
		
		//.add method can add elements to your collection
		myPokemon.add(new Pokemon("Pikachu", "Electric"));
		myPokemon.add(new Pokemon("Squirtle", "Water"));
		myPokemon.add(new Pokemon("Ditto", "Normal"));
		myPokemon.add(new Pokemon("Mudkip", "Water/Ground"));
		myPokemon.add(new Pokemon("Turtwig", "Grass"));
		myPokemon.add(new Pokemon("Ditto", "Normal"));
		
		
		//We can simply print out the contents of the list
		System.out.println(myPokemon);
		
		//and we can use an enhanced for loop to iterate over the entire data structure
		for(Pokemon p : myPokemon) {
			System.out.println(p.name + " is " + p.type + " type.");
		}
		
		//exploring some other List methods
		
		myPokemon.add(3, new Pokemon("Eevee", "Normal")); //we can add elements at specific indexes
		
		System.out.println("The Pokemon at index 3 is: " + myPokemon.get(3));
		// .get(index) is how we specify a certain index in a List
		// Note: Eevee is at index 3, but because of zero-indexing, it's technically the 4th element
		
		System.out.println("The amount of Pokemon in my party is: " + myPokemon.size());
		// .size() is how we can get the number of elements in our List
		// .size() counts the 0th index
		
		
		//creating two new Pokemon objects to experiment with
		Pokemon pikachu = new Pokemon("Pikachu", "Electric");
		Pokemon mewtwo = new Pokemon("Mewtwo", "Psychic");
		
		//.contains() checks if a certain element is in the List
		System.out.println(myPokemon.contains(pikachu)); //will print true
		System.out.println(myPokemon.contains(mewtwo));  //will print false
		
		System.out.println(myPokemon.contains(pikachu.name));
		//this will return false, the ArrayList doesn't contain the String "Pikachu" independently
		
		//using a lambda to make some Pokemon "fight"
		//forEach will loop through our entire Collection and perform an action FOR EACH element
		myPokemon.forEach(pokemon -> System.out.println(pokemon.name + " Attacked!"));
		
		//.remove will remove a specific element OR an element at a specific index
		myPokemon.remove(pikachu); //godbye pikachu :(
		myPokemon.remove(4); //goodbye turtwig :(
		
		System.out.println("Two Pokemon have fainted");
		
		//another forEach to show who remains
		myPokemon.forEach(pokemon -> System.out.println(pokemon.name + " Remains..."));
		
		System.out.println("==========================================================(Sets)");
		
		
		Set<Pokemon> myPokemonSet = new HashSet<>(); 
		
		//I'm gonna elaborate on how sets differ from Lists
		
		myPokemonSet.add(new Pokemon("Pikachu", "Electric"));
		myPokemonSet.add(new Pokemon("Squirtle", "Water"));
		myPokemonSet.add(new Pokemon("Ditto", "Normal"));
		myPokemonSet.add(new Pokemon("Ditto", "Normal"));
		myPokemonSet.add(new Pokemon("Mudkip", "Water/Ground"));
		myPokemonSet.add(new Pokemon("Turtwig", "Grass"));
		
		System.out.println(myPokemonSet); 
		//notice how the duplicate value doesn't get recorded!
		//also notice how there's no particular order
		
		//myPokemonSet.get(5);
		//.get() doesn't exists with Sets, there's no index to "get"!
		
		System.out.println(myPokemonSet.contains(pikachu));
		
		System.out.println("==========================================================(Maps)");
		
		Map<Integer, Pokemon> trainers = new TreeMap<>();
		//maps only take objects!! So we need Integer.
		
		trainers.put(1, new Pokemon("Rattatta", "Normal"));
		trainers.put(2, mewtwo);
		trainers.put(3, myPokemon.get(3));
		//we insert ints here, which get autoboxed into the Integer wrapper class.
		
		System.out.println(trainers); 
		//notice the default order given to the TreeMap!
		//Because TreeMaps niche are that they have ordered keys :)
		
		System.out.println("=======================================================(Comparable/Comparator)");
		
		//Let's sort our ArrayList alphabetically by names (thx to the compare method)
		
		//using the .sort method, providing an ArrayList and a Comparator as arguments
		Collections.sort(myPokemon, new ComparePokeName());
		
		for(Pokemon p : myPokemon) {
			System.out.println(p);
		}
		
		//reverse the alphabetical order that was to the ArrayList
		Collections.reverse(myPokemon);
		
		System.out.println("-----Now we've reversed the order------");
		
		for(Pokemon p : myPokemon) {
			System.out.println(p);
		}
		
	}
	
}
