package services.search;

import static org.junit.jupiter.api.Assertions.*;

import entities.Artist;
import entities.CommonArtist;
import entities.CommonTrack;
import entities.CommonUser;
import entities.Track;
import entities.User;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.remove_playlist.RemovePlaylistOutputData;
import services.remove_playlist.RemovePlaylistPresenter;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;

class SearchPresenterTest {

    @Test
    void prepareSuccessView() {
        SearchPresenter searchPresenter = new SearchPresenter(new SearchViewModel("view", new SearchViewState()));
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new CommonTrack("id", "name", "artist", 100, false, "1234.com"));
        ArrayList<Artist> artists = new ArrayList<Artist>();
        artists.add(new CommonArtist("id", "imageURL", "name", 100));
        ArrayList<String> users = new ArrayList<>();
        users.add("user");
        searchPresenter.prepareSuccessView(new SearchOutputData(artists, tracks, users));
        assertTrue(true, "success view presented");
    }
}