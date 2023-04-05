package SpringPlanning;

public class Main {
    public static void main(String[] args) {
        UserStory us1 = new UserStory(1, "User Registration Entity", 8);
        UserStory us2 = new UserStory(2, "User Login Entity", 5);
        Bug bug1 = Bug.createBug(1, "Password Reset not working", 3, us1);
        Bug bug2 = Bug.createBug(2, "Login page layout issue", 2, us2);

        Sprint sprint = new Sprint(20, 5);

        boolean added1 = sprint.addUserStory(us1);
        boolean added2 = sprint.addUserStory(us2);
        boolean added3 = sprint.addBug(bug1);
        boolean added4 = sprint.addBug(bug2);

        UserStory completedUs = new UserStory(3, "Completed User Story", 5);
        completedUs.complete();
        boolean added5 = sprint.addUserStory(completedUs);
        System.out.println("Trying to add a completed user story: " + added5);

        UserStory tooBigUs = new UserStory(4, "Too Big User Story", 20);
        boolean added6 = sprint.addUserStory(tooBigUs);
        System.out.println("Trying to add a user story with too large an estimate: " + added6);

        UserStory us3 = new UserStory(5, "Another User Story", 3);
        UserStory us4 = new UserStory(6, "Yet Another User Story", 2);
        boolean added7 = sprint.addUserStory(us3);
        boolean added8 = sprint.addUserStory(us4);
        boolean added9 = sprint.addBug(Bug.createBug(3, "Another Bug", 1, us3));
        boolean added10 = sprint.addBug(Bug.createBug(4, "Yet Another Bug", 2, us4));
        boolean added11 = sprint.addUserStory(new UserStory(7, "Extra User Story", 1));
        boolean added12 = sprint.addBug(Bug.createBug(5, "Extra Bug", 1, us1));
        System.out.println("Trying to add too many tickets: " + added7 + ", " + added8 + ", " + added9 + ", " + added10 + ", " + added11 + ", " + added12);

        Ticket[] tickets = sprint.getTickets().toArray(new Ticket[0]);
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }

        System.out.println("Total estimate: " + sprint.getTotalEstimate());
    }
}
