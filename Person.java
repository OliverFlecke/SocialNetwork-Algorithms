import java.util.*;

public class Person {
	// This persons friends
	private List<Person> friends;

	// Name of the person
	private String name;
	private int index;

	// State to the depth first algoritm
	private boolean isMarked;
	private int depth;

	/**
	* Create a person with a name and an ID
	* @param name of the person
	* @param index of the person 
	*/
	public Person(String name, int index) {
		this.name = name;
		this.index = index;
		this.isMarked = false;
		this.depth = 0;
		friends = new LinkedList<Person>();
	}

	/**
	* @return The name of this person
	*/
	public String getName() {
		return this.name;
	}

	/**
	* @return This persons id
	*/
	public int getIndex() {
		return this.index;
	}

	/**
	* @return The length of this persons name
	*/
	public int getNameLength() {
		return this.name.length();
	}

	/**
	* This is only used for the friendsshipchain algorithm 
	* @return True, if this person is marked
	*/
	public boolean isMarked() {
		return this.isMarked;
	}

	/**
	* This is only used for the friendsshipchain algorithm 
	* Set the mark of this person to true
	*/
	public void mark() {
		this.isMarked = true;
	}

	/**
	* This is only used for the friendsshipchain algorithm 
	* Set the mark of this person to false
	*/
	public void unmark() {
		this.isMarked = false;
	}

	/**
	* This is only used for the friendsshipchain algorithm 
	* @param The depth of this person
	*/
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	* This is only used for the friendsshipchain algorithm 
	* @return The depth of this person
	*/
	public int getDepth() {
		return this.depth;
	}

	/**
	* @return The list of friends for this person
	*/
	public List<Person> getFriends() {
		return this.friends;
	}

	/**
	* @param friend to add to this persons friend list
	* @return True, if the friend has been added
	*/
	public boolean addFriend(Person friend) {
		if (!hasFriend(friend)) {
			this.friends.add(friend);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	* 	@param friend to check if is friend
	*	@Return True if the person is already friends with the other person
	*/
	public boolean hasFriend(Person friend) {
		for (Person person : this.friends) 
			if (person == friend) 
				return true;
		return false;
	}

	/**
	* @return The amount of friends this person has 
	*/
	public int getDegree() {
		return friends.size();
	}

	@Override 
	public boolean equals(Object o) {
		Person other;
		if (o instanceof Person)
			other = (Person) o;
		else return false;

		if (this.getIndex() == other.getIndex()) 
			return true;
		else 
			return false;
	}
}