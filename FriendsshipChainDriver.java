import java.io.*;
import java.util.*;

public class FriendsshipChainDriver {
	private FriendsshipChain graph;

	public static void main(String[] args) throws IOException {
		// System.out.println("Hello world");
		new FriendsshipChainDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String names = in.readLine();
		String[] namesList = names.split("\\s+");

		graph = new FriendsshipChain(namesList);

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
		
		if (current.equals("tvenner")) {
			int personID = Integer.parseInt(st.nextToken());
			int depth = Integer.parseInt(st.nextToken());

			List<String> people = this.graph.getFriendsshipChain(personID, depth);
			for (String person : people) {
				System.out.print(person + " ");
			}
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