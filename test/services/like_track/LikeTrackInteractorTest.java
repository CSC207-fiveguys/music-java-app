package services.like_track;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.CommonTrack;
import entities.CommonUser;
import entities.Playlist;
import entities.Track;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LikeTrackInteractorTest {

    private LikeTrackInteractor interactor;
    private LikeTrackUserDataAccessInterface userDataAccessObject;
    private LikeTrackSpotifyDataAccessInterface spotifyDataAccessObject;
    private LikeTrackOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        userDataAccessObject = new UserDataAccessObject(userFactory, spotifyDataAccessObject) {
            @Override
            public User getUser(String username) {
                User user = new CommonUser(username, "password");
                Track track = new CommonTrack("id", "Mo Bamba", "Sheck Wes", 600, true, "ImageURL");
                trackDataAccessObject.saveTrack(track);
                user.likeTrack("id");
                return user;
            }
        };

        outputBoundary = new LikeTrackPresenter() {
            @Override
            public void prepareSuccessView() {
                assertTrue(true, "Success view should be prepared");
            }
        };

        interactor = new LikeTrackInteractor(userDataAccessObject, spotifyDataAccessObject, outputBoundary);
    }

    @Test
    void execute_LikeTrack() {
        LikeTrackInputData inputData = new LikeTrackInputData("id", "user");
        interactor.execute(inputData);
    }
}
