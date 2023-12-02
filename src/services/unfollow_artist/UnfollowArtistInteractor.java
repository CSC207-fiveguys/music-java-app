package services.unfollow_artist;

import entities.Artist;
import entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnfollowArtistInteractor implements UnfollowArtistInputBoundary {

  final UnfollowArtistDataAccessInterface artistDataAccessObject;
  final UnfollowArtistUserDataAccessInterface userDataAccessObject;
  final UnfollowArtistOutputBoundary unfollowArtistPresenter;

  public UnfollowArtistInteractor(UnfollowArtistDataAccessInterface artistDataAccessObject,
      UnfollowArtistUserDataAccessInterface userDataAccessObject,
      UnfollowArtistOutputBoundary unfollowArtistPresenter) {
    this.artistDataAccessObject = artistDataAccessObject;
    this.userDataAccessObject = userDataAccessObject;
    this.unfollowArtistPresenter = unfollowArtistPresenter;
  }

  @Override
  public void execute(UnfollowArtistInputData unfollowArtistInputData) {
    User user = userDataAccessObject.getUser(unfollowArtistInputData.username);
    user.unfollowArtist(unfollowArtistInputData.id);
    ArrayList<Map<String, String>> artists = new ArrayList<>();
    for (String followArtist : user.getFollowedArtists()) {
      Artist followedArtist = artistDataAccessObject.getArtist(followArtist);
      Map<String, String> artistMap = new HashMap<>();
      artistMap.put("name", followedArtist.getName());
      artistMap.put("followers", followedArtist.getNumFollowers() + "");
      artistMap.put("iconPath", followedArtist.getImageUrl());
      artistMap.put("id", followedArtist.getID());
      artists.add(artistMap);
    }
    UnfollowArtistOutputData unfollowArtistOutputData =
        new UnfollowArtistOutputData(artists);
    unfollowArtistPresenter.prepareSuccessView(unfollowArtistOutputData);
  }
}