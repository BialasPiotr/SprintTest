package SpringPlanning;

import java.util.*;

public class UserStory extends Ticket {
    private final List<UserStory> dependencies;

    public UserStory(int id, String name, int estimate) {
        super(id, name, estimate);
        this.dependencies = new ArrayList<>();
    }

    public void addDependency(UserStory dependency) {
        dependencies.add(dependency);
    }

    public List<UserStory> getDependencies() {
        return new ArrayList<>(dependencies);
    }

    @Override
    public void complete() {
        boolean allDependenciesCompleted = dependencies.stream()
                .allMatch(UserStory::isCompleted);
        if (allDependenciesCompleted) {
            super.complete();
        }
    }

    @Override
    public String toString() {
        return String.format("[US %d] %s", getId(), getName());
    }
}
