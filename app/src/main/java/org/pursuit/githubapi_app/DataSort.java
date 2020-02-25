package org.pursuit.githubapi_app;

import java.util.Collections;
import java.util.List;

public class DataSort {

    public static void sortByStars(List<Repos> reposList) {
        Collections.sort(reposList, (o1, o2) -> {
            if (o1.getStarCount() == o2.getStarCount())
                return 0;
            return o1.getStarCount() > o2.getStarCount() ? -1 : 1;
        });
    }
}
