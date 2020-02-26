package org.pursuit.githubapi_app.presenter;

import org.pursuit.githubapi_app.data.model.Items;
import org.pursuit.githubapi_app.data.model.Repos;

import java.util.List;

/**
 * Created for MVP architecture. View interfaces will be implemented by Activities and
 * Presenter interfaces will be implemented for Presenter classes.
 */
public interface Contract {

    interface ItemsView {
        void showItems(List<Items> itemsList);
        void showError1();
        void showError2();
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
