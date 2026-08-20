package app;

public class ViewPlaylistsCommand
        implements Command {

    private PlaylistManager manager;

    public ViewPlaylistsCommand(
            PlaylistManager manager) {

        this.manager = manager;
    }

    @Override
    public void execute() {

        manager.displayAll();
    }
}