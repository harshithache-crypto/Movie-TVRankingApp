package app;

import java.util.ArrayList;
import java.util.List;

public class MediaPlaylist
        implements MediaComponent {

    private String name;
    private boolean isPublic;

    private List<MediaComponent>
            items;

    public MediaPlaylist(
            String name,
            boolean isPublic) {

        this.name = name;
        this.isPublic = isPublic;

        items = new ArrayList<>();
    }

    public void add(
            MediaComponent item) {

        items.add(item);
    }

    public void remove(
            MediaComponent item) {

        items.remove(item);
    }

    public String getName() {

        return name;
    }

    public boolean isPublic() {

        return isPublic;
    }

    public void setPublic(
            boolean isPublic) {

        this.isPublic =
                isPublic;
    }

    public List<MediaComponent>
            getItems() {

        return new ArrayList<>(items);
    }

    @Override
    public void displayComponent() {

        System.out.println(
                "\n--- PLAYLIST: "
                        + name
                        + " ---"
        );

        System.out.println(
                "Visibility: "
                        + (isPublic
                        ? "Public"
                        : "Private")
        );

        if (items.isEmpty()) {

            System.out.println(
                    "No titles yet."
            );

            return;
        }

        for (int i = 0;
             i < items.size();
             i++) {

            System.out.print(
                    (i + 1) + ". "
            );

            items.get(i)
                 .displayComponent();
        }
    }

    @Override
    public String getComponentName() {

        return name;
    }
}