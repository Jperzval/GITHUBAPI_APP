package org.pursuit.githubapi_app.presenter;

import org.pursuit.githubapi_app.data.model.Items;
import org.pursuit.githubapi_app.data.model.Repos;

import java.util.List;

public interface Contract {

    interface ItemsView {
        void showItems(List<Items> itemsList);
        void showError();
    }

    interface RepoView {
        void showRepos(List<Repos> repos);
        void showError();
    }

    interface ItemsPresenter {
        void getItemCall(String input);
    }

    interface RepoPresenter {
        void getRepos(String organization);
    }
}
