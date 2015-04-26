	import java.util.*;

public class FriendsshipChain {
	private Person[] people;
	private int V;

	public FriendsshipChain(String[] names) {
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
	* Get all the friends from a person within a certain depth
	* @param startID ID of the person to start from
	* @param depth to search to
	* @return A list of names of the people found
	*/
	public List<String> getFriendsshipChain(int startID, int depth) {
		List<String> friends = new ArrayList<String>();
		LinkedList<Person> queue = new LinkedList<Person>();

		// Resets every person
		for (Person person : people) {
			person.unmark();
			person.setDepth(0);
		}

		// Add the start person to the list\
		people[startID].mark();
		queue.add(people[startID]);
		friends.add(people[startID].getName());

		// While there is still people in the queue, keep searching
		while (!queue.isEmpty()) {
			Person current = queue.poll();

			// If the depth of the current person is larger than what we are searching for, break
			if (current.getDepth() >= depth) break;

			// Get the current persons friends, mark and queue each
			for (Person friend : current.getFriends()) {
				if (!friend.isMarked()) {
					friends.add(friend.getName());
					friend.mark();
					friend.setDepth(current.getDepth() + 1);
					queue.add(friend);
				}
			}
		}

		return friends;
	}
}