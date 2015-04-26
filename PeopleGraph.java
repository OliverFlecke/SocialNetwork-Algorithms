import java.io.*;
import java.util.*;

/**
* Graph to represent a group of people
*/
public class PeopleGraph {
	// List of people
	private Person[] people;
	// Store the amount of relationships
	private int V;

	/**
	* Create a new graph from a list of names
	* @param names of the people to the graph
	*/
	public PeopleGraph(String[] names) {
		people = new Person[names.length];

		for (int i = 0; i < names.length; i++) {
			people[i] = new Person(names[i], i);
		}
		V = 0;
	}

	/**
	* @return The amount of people in the graph
	*/
	public int getPeople() {
		return this.people.length;
	}

	/**
	* @return The amount of relationships 
	*/
	public int getRelationships() {
		return this.V;
	}

	/**
	* Add a relationship between two people
	* @param i The index of the first person
	* @param j The index of the second person
	*/
	public void addRelationship(int i, int j) {
		if (!this.people[i].hasFriend(people[j])) {
			this.people[i].addFriend(people[j]);
			this.people[j].addFriend(people[i]);
			V++;
		}
	}
}