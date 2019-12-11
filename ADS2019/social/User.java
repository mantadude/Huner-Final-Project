import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * User
 */
public class User {

    private ArrayList<User> connections = new ArrayList<>();
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String toString() {
        return getUsername();
    }

    public void addConnection(User user) {
        connections.add(user);
        user.connections.add(this);
    }
    
    private boolean isConnected(User user, HashSet<User> visited) {
        System.out.println("Checking " + this.getUsername());
        visited.add(this);
        if(this.getUsername().equals(user.getUsername())) {
            System.out.println("I'm " + user.getUsername() + "!");
            return true;
        }
        System.out.println("Connections: " + Arrays.toString(connections.toArray()));
        for(int i=0; i<this.connections.size(); i++) {
            if(!visited.contains(this.connections.get(i))) {
                if(this.connections.get(i).isConnected(user, visited)) {
                    System.out.println(
                        "I'm connected to " + this.connections.get(i).getUsername()
                    );
                    return true;
                }
            }
        }
        System.out.println(this.getUsername() + " is a loser");
        return false;
    }

    public boolean isConnected(User user) {
        return isConnected(user, new HashSet<User>());
    }

    public ArrayList<User> shortestPath(User user) {
    // public void shortestPath(User user) {
        LinkedList<User> queue = new LinkedList<>();
        HashMap<User, User> visited = new HashMap<>();
        queue.add(this);
        visited.put(this, this);
        while(!queue.isEmpty()) {
            System.out.println("Queue: " + Arrays.toString(queue.toArray()));
            User head = queue.pop();
            System.out.println("Head is " + head);
            System.out.println(Arrays.toString(head.connections.toArray()));
            for(int i=0; i<head.connections.size(); i++) {
                User friend = head.connections.get(i);
                System.out.println("Checking " + friend);
                if(!visited.containsKey(friend)) {
                    visited.put(friend, head);
                    if(friend.equals(user)) {
                        System.out.println("Found " + friend);
                        ArrayList<User> path = new ArrayList<>();
                        User nextOnPath = friend;
                        while(!nextOnPath.equals(this)) {
                            path.add(nextOnPath);
                            nextOnPath = visited.get(nextOnPath);
                            System.out.println(nextOnPath);
                        }
                        path.add(this);
                        return path;
                    } else {
                        System.out.println("Add " + friend + " to queue");
                        queue.add(friend);
                    }
                }
            }
        }
        return new ArrayList<User>();
    }
}