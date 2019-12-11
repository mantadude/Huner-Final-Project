import java.util.ArrayList;
import java.util.Arrays;

/**
 * Network
 */
public class Network {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User josh = new User("josh");
        User arianna = new User("arianna");
        User kathleenb = new User("kathleenb");
        User john = new User("john");
        User carlos = new User("carlos");
        users.add(josh);
        users.add(arianna);
        users.add(kathleenb);
        users.add(john);
        users.add(carlos);

        josh.addConnection(arianna);
        kathleenb.addConnection(john);
        carlos.addConnection(arianna);
        kathleenb.addConnection(josh);
        john.addConnection(arianna);


        User gabe = new User("gabe");
        User mary = new User("mary");
        User joseph = new User("joseph");
        User brendan = new User("brendan");
        User kien = new User("kien");
        User thomas = new User("thomas");
        User joshua = new User("joshua");
        User duy = new User("duy");
        gabe.addConnection(joseph);
        mary.addConnection(kien);
        brendan.addConnection(thomas);
        joshua.addConnection(duy);
        brendan.addConnection(duy);
        brendan.addConnection(gabe);
        // thomas.addConnection(kien);
        gabe.addConnection(john);
        // arianna.addConnection(brendan);

//         System.out.println(gabe.isConnected(mary));
//         System.out.println(arianna.shortestPath(brendan));

        bubbleSort(users);
        quicksort(users);
    }

    public static ArrayList<User> bubbleSort(ArrayList<User> users) {
        ArrayList<User> sorted = (ArrayList<User>)users.clone();
        System.out.println(Arrays.toString(sorted.toArray()));
        for(int j=0; j<sorted.size()-1; j++) {
            for(int i=0; i<sorted.size()-1-j; i++) {
                User first = sorted.get(i);
                User second = sorted.get(i+1);
                if(first.getUsername().compareTo(second.getUsername()) > 0) {
                    sorted.set(i, second);
                    sorted.set(i+1, first);
                }
                System.out.println(Arrays.toString(sorted.toArray()));
            }
            System.out.println("Iteration " + j);
            System.out.println(Arrays.toString(sorted.toArray()));
        }
        for(int i=0; i<sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }
        return sorted;
    }

    public static ArrayList<User> bubbleSort2(ArrayList<User> users) {
        ArrayList<User> sortedUsers = (ArrayList<User>)users.clone();
        System.out.println(Arrays.toString(sortedUsers.toArray()));
        for(int i=0; i<sortedUsers.size()-1; i++) {
            for(int j=0; j<sortedUsers.size()-1-i; j++) {
                User first = sortedUsers.get(j);
                User second = sortedUsers.get(j+1);
                if(first.getUsername().compareTo(second.getUsername()) > 0) {
                    sortedUsers.set(j, second);
                    sortedUsers.set(j+1, first);       
                }
                System.out.println(Arrays.toString(sortedUsers.toArray()));
            }
            System.out.println("Iteration " + i);
            System.out.println(Arrays.toString(sortedUsers.toArray()));
        }
        for(int j=0; j<sortedUsers.size(); j++) {
            System.out.println(sortedUsers.get(j));
        }
        return sortedUsers;
    }

    private static void quicksort(ArrayList<User> sorted, int start, int end) {
        if(end - start < 2) {
            System.out.println("Done");
            return;
        }
        User pivot = sorted.get(start);
        System.out.println("Pivot: " + pivot.getUsername());
        int lastSmaller = end - 1;
        for(int i=end-1; i>start; i--) {
            User item = sorted.get(i);
            System.out.println("Item:" + item.getUsername());
            if(item.getUsername().compareTo(pivot.getUsername()) > 0) {
                sorted.set(i, sorted.get(lastSmaller));
                sorted.set(lastSmaller, item);
                lastSmaller--;
                System.out.println(Arrays.toString(sorted.toArray()));
            }
        }
        sorted.set(start, sorted.get(lastSmaller));
        sorted.set(lastSmaller, pivot);
        System.out.println("Swap pivot");
        System.out.println(Arrays.toString(sorted.toArray()));
        quicksort(sorted, start, lastSmaller);
        quicksort(sorted, lastSmaller+1, end);
    }

    public static ArrayList<User> quicksort(ArrayList<User> users) {
        ArrayList<User> sorted = (ArrayList<User>)users.clone();
        System.out.println(Arrays.toString(sorted.toArray()));
        quicksort(sorted, 0, sorted.size());
        System.out.println(Arrays.toString(sorted.toArray()));
        return sorted;
    }
}
