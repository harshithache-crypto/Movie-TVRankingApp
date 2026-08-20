package app;

public class ViewDashboardCommand
        implements Command {

    private RankedDashboard dashboard;

    public ViewDashboardCommand(
            RankedDashboard dashboard) {

        this.dashboard = dashboard;
    }

    @Override
    public void execute() {

        dashboard.display();
    }
}