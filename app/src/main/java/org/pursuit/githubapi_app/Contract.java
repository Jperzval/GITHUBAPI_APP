package org.pursuit.githubapi_app;

import java.util.List;

public interface Contract {

    interface SearchItemsView {
        void showItems(List<Item> itemList);
        void showError();
    }

    interface RepoView {
        void showRepos(List<Repos> repos);
        void showError();
    }

    interface ItemPresenter {
        void getItemCall(String input);
    }

    interface RepoPresenter {
        void getRepos(String organization);
    }
}
