import java.util.*;

/**
* Representation of a graph, used to calculate close relationships between people
*/
public class CloseFriends {
	private Person[] people;
	private int V;

	/**
	* Create a graph to calculate close friends 
	* @param names of the people in the graph
	*/
	public CloseFriends(String[] names) {
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

	/**
	*	@param persons The array of people to check 
	*/
	public boolean IsCloseFriends(int[] persons) {
		for (int i = 0; i < persons.length; i++) {
			for (int j = i + 1; j < persons.length; j++) {
				if (!people[persons[i]].hasFriend(people[persons[j]])) {
					return false;
				}
			}
		}
		return true;
	}
}