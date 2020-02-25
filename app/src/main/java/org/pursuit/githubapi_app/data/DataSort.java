package org.pursuit.githubapi_app.data;

import org.pursuit.githubapi_app.data.model.Repos;

import java.util.Collections;
import java.util.List;

/**
 * Created to sort list in descending order
 */
public class DataSort {

    public static void sortByStars(List<Repos> reposList) {
        Collections.sort(reposList, (o1, o2) -> {
            if (o1.getStarCount() == o2.getStarCount())
                return 0;
            return o1.getStarCount() > o2.getStarCount() ? -1 : 1;
        });
    }
}
