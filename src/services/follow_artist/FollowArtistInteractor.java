package services.follow_artist;

import entities.Artist;
import entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FollowArtistInteractor implements FollowArtistInputBoundary {
  final FollowArtistDataAccessInterface artistDataAccessObject;
  final FollowArtistUserDataAccessInterface userDataAccessObject;
  final FollowArtistOutputBoundary followArtistPresenter;

  public FollowArtistInteractor(FollowArtistDataAccessInterface userDataAccessObject,
      FollowArtistUserDataAccessInterface userDataAccessObject1,
      FollowArtistOutputBoundary followArtistPresenter) {
    this.artistDataAccessObject = userDataAccessObject;
    this.userDataAccessObject = userDataAccessObject1;
    this.followArtistPresenter = followArtistPresenter;
  }


  @Override
  public void execute(FollowArtistInputData followArtistInputData) {
    // todo 1. make user with "username" follow artist with "id"
    User user = userDataAccessObject.getUser(followArtistInputData.username);
    user.followArtist(followArtistInputData.id);
    // prepare the output data
    ArrayList<Map<String, String>> artists = new ArrayList<>();
    for (String followArtist: user.getFollowedArtists()){
      Artist followedArtist = artistDataAccessObject.getArtist(followArtist);
      Map<String, String> artistMap = new HashMap<>();
      artistMap.put("name", followedArtist.getName());
      artistMap.put("followers", followedArtist.getNumFollowers() + "");
      artistMap.put("iconPath", followedArtist.getImageUrl());
      artistMap.put("id", followedArtist.getID());
      artists.add(artistMap);
    }
    FollowArtistOutputData followArtistOutputData = new FollowArtistOutputData(artists);
    followArtistPresenter.prepareSuccessView(followArtistOutputData);
    // todo 2. add playlist to "usernames" library with songs from the artist
    // todo 2.i check for duplicate playlist name issues ???

  }

}
