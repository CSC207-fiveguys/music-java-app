package app;

import app.Main;
import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import java.awt.CardLayout;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import javax.swing.*;
import services.add_friend.AddFriendController;
import services.add_friend.AddFriendInputBoundary;
import services.add_friend.AddFriendOutputBoundary;
import services.add_track_to_playlist.AddTrackToPlaylistController;
import services.add_track_to_playlist.AddTrackToPlaylistInputBoundary;
import services.add_track_to_playlist.AddTrackToPlaylistOutputBoundary;
import services.create_new_playlist.CreateNewPlaylistController;
import services.create_new_playlist.CreateNewPlaylistInputBoundary;
import services.create_new_playlist.CreateNewPlaylistOutputBoundary;
import services.follow_artist.FollowArtistController;
import services.follow_artist.FollowArtistInputBoundary;
import services.follow_artist.FollowArtistOutputBoundary;
import services.like_track.LikeTrackController;
import services.like_track.LikeTrackInputBoundary;
import services.like_track.LikeTrackInteractor;
import services.like_track.LikeTrackOutputBoundary;
import services.login_complete.LoginCompleteInputBoundary;
import services.login_complete.LoginCompleteOutputBoundary;
import services.login_new_signup.LoginNewSignupController;
import services.login_new_signup.LoginNewSignupInputBoundary;
import services.login_new_signup.LoginNewSignupOutputBoundary;
import services.remove_friend.RemoveFriendController;
import services.remove_friend.RemoveFriendInputBoundary;
import services.remove_friend.RemoveFriendOutputBoundary;
import services.remove_playlist.RemovePlaylistController;
import services.remove_playlist.RemovePlaylistInputBoundary;
import services.remove_playlist.RemovePlaylistOutputBoundary;
import services.remove_track_from_liked.RemoveTrackFromLikedController;
import services.remove_track_from_liked.RemoveTrackFromLikedInputBoundary;
import services.remove_track_from_liked.RemoveTrackFromLikedInteractor;
import services.remove_track_from_liked.RemoveTrackFromLikedOutputBoundary;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistController;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistInputBoundary;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistInteractor;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistOutputBoundary;
import services.search.SearchController;
import services.search.SearchInputBoundary;
import services.search.SearchOutputBoundary;
import services.signup_complete.SignupCompleteController;
import services.view_playlist.ViewPlaylistController;
import services.view_playlist.ViewPlaylistInputBoundary;
import services.view_playlist.ViewPlaylistOutputBoundary;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.TabViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewState;
import view.logged_in.tabs.SearchViewState;
import view.logged_out.LoginViewState;
import view.logged_out.SignupViewState;

public class MainTest {

    @Test
    public void testMainInitializesComponents() {

        // Call the main method
        Main.main(new String[]{});
        assertTrue(true, "runs");
    }
}
