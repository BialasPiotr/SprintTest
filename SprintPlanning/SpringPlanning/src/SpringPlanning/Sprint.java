package SpringPlanning;

import java.util.*;

public class Sprint {
    private final int timeCapacity;
    private final int ticketsLimit;
    private final List<Ticket> tickets;

    public Sprint(int timeCapacity, int ticketsLimit) {
        this.timeCapacity = timeCapacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new ArrayList<>();
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || !isUserStoryDependenciesAccepted(userStory)) {
            return false;
        }
        if (getTotalEstimate() + userStory.getEstimate() > timeCapacity || tickets.size() >= ticketsLimit) {
            return false;
        }
        tickets.add(userStory);
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted()) {
            return false;
        }
        if (getTotalEstimate() + bugReport.getEstimate() > timeCapacity || tickets.size() >= ticketsLimit) {
            return false;
        }
        tickets.add(bugReport);
        return true;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    public int getTotalEstimate() {
        int totalEstimate = 0;
        for (Ticket ticket : tickets) {
            totalEstimate += ticket.getEstimate();
        }
        return totalEstimate;
    }

    private boolean isUserStoryDependenciesAccepted(UserStory userStory) {
        for (UserStory dependency : userStory.getDependencies()) {
            if (!tickets.contains(dependency) || !dependency.isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
