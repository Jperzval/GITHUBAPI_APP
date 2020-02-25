package org.pursuit.githubapi_app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GITHUBAPI_APP_UnitTest {

    private List<Repos> reposList;

    @Before
    public void setUp() {
        reposList = new ArrayList<>();
    }

    @Test
    public void checkListIsSortedByHighestStarCount() {
        Repos repo1 = new Repos(
                "repo1", "https://github.com/repo1", 3);
        Repos repo3 = new Repos(
                "repo3", "https://github.com/repo3", 0);
        Repos repo2 = new Repos(
                "repo2", "https://github.com/repo2", 1);
        reposList.add(repo3);
        reposList.add(repo1);
        reposList.add(repo2);

        List<Repos> expected = new ArrayList<>();
        expected.add(repo1);
        expected.add(repo2);
        expected.add(repo3);
        DataSort.sortByStars(reposList);
        Assert.assertEquals(expected, reposList);
    }

    @Test
    public void checkListIsSortedByHighestStarCount_WhenReposHaveSameCount() {
        Repos repo1 = new Repos(
                "repo1", "https://github.com/repo1", 0);
        Repos repo3 = new Repos(
                "repo3", "https://github.com/repo3", 0);
        Repos repo2 = new Repos(
                "repo2", "https://github.com/repo2", 2);
        reposList.add(repo1);
        reposList.add(repo3);
        reposList.add(repo2);

        List<Repos> expected = new ArrayList<>();
        expected.add(repo2);
        expected.add(repo1);
        expected.add(repo3);
        DataSort.sortByStars(reposList);
        Assert.assertEquals(expected, reposList);
    }

    @After
    public void breakDown() {
        reposList = null;
    }
}
