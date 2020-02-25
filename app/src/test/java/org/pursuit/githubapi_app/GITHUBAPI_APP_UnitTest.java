package org.pursuit.githubapi_app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pursuit.githubapi_app.data.DataSort;
import org.pursuit.githubapi_app.data.model.Repos;
import org.pursuit.githubapi_app.presenter.repos.RepoAdapter;

import java.util.ArrayList;
import java.util.List;

public class GITHUBAPI_APP_UnitTest {

    private List<Repos> actual;
    private RepoAdapter repoAdapter;

    @Before
    public void setUp() {
        actual = new ArrayList<>();
        repoAdapter = new RepoAdapter(actual);
    }

    @Test
    public void checkListIsSortedByHighestStarCount() {
        Repos repo1 = new Repos(
                "repo1", "https://github.com/repo1", 3);
        Repos repo3 = new Repos(
                "repo3", "https://github.com/repo3", 0);
        Repos repo2 = new Repos(
                "repo2", "https://github.com/repo2", 1);
        actual.add(repo3);
        actual.add(repo1);
        actual.add(repo2);

        List<Repos> expected = new ArrayList<>();
        expected.add(repo1);
        expected.add(repo2);
        expected.add(repo3);
        DataSort.sortByStars(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkListIsSortedByHighestStarCount_WhenReposHaveSameCount() {
        Repos repo1 = new Repos(
                "repo1", "https://github.com/repo1", 0);
        Repos repo3 = new Repos(
                "repo3", "https://github.com/repo3", 0);
        Repos repo2 = new Repos(
                "repo2", "https://github.com/repo2", 2);
        actual.add(repo1);
        actual.add(repo3);
        actual.add(repo2);

        List<Repos> expected = new ArrayList<>();
        expected.add(repo2);
        expected.add(repo1);
        expected.add(repo3);
        DataSort.sortByStars(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetItemCount_LessThan3() {
        Repos repo1 = new Repos(
                "repo1", "https://github.com/repo1", 0);
        Repos repo2 = new Repos(
                "repo2", "https://github.com/repo2", 2);
        actual.add(repo1);
        actual.add(repo2);

        List<Repos> expected = new ArrayList<>();
        expected.add(repo2);
        expected.add(repo1);
        Assert.assertEquals(expected.size(), repoAdapter.getItemCount());
    }

    @Test
    public void checkGetItemCount_MoreThan3() {
        Repos repo1 = new Repos(
                "repo1", "https://github.com/repo1", 0);
        Repos repo3 = new Repos(
                "repo3", "https://github.com/repo3", 0);
        Repos repo2 = new Repos(
                "repo2", "https://github.com/repo2", 2);
        Repos repo4 = new Repos(
                "repo2", "https://github.com/repo2", 2);
        actual.add(repo1);
        actual.add(repo3);
        actual.add(repo2);
        actual.add(repo4);

        List<Repos> expected = new ArrayList<>();
        expected.add(repo2);
        expected.add(repo1);
        expected.add(repo3);
        Assert.assertEquals(expected.size(), repoAdapter.getItemCount());
    }


    @After
    public void breakDown() {
        actual = null;
        repoAdapter = null;
    }
}
