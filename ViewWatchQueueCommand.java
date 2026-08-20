package app;

public class ViewWatchQueueCommand
        implements Command {

    private WatchQueue queue;

    public ViewWatchQueueCommand(
            WatchQueue queue) {

        this.queue = queue;
    }

    @Override
    public void execute() {

        queue.display();
    }
}