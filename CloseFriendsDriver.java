import java.io.*;
import java.util.*;

public class CloseFriendsDriver {
	private CloseFriends graph;

	public static void main(String[] args) throws IOException {
		// System.out.println("Hello world");
		new CloseFriendsDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String names = in.readLine();
		String[] namesList = names.split("\\s+");

		graph = new CloseFriends(namesList);

		// Read in the relationships
		StringTokenizer st = new StringTokenizer(in.readLine());
		String current = st.nextToken();

		// While there is int as input, we will add the relationships
		while (tryParseInt(current)) {
			this.graph.addRelationship(Integer.parseInt(current), 
				Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(in.readLine());
			current = st.nextToken();
		}

		if (current.equals("taetvenskab")) {
            int[] people = new int[st.countTokens()];
            for ( int i = 0; i < people.length; i++) {
                people[i] = Integer.parseInt(st.nextToken());
            }

			if (graph.IsCloseFriends(people))
				System.out.println("ja");
			else 
				System.out.println("nej");
		}
	}

	private boolean tryParseInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}