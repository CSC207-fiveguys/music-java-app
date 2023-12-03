package services.follow_artist;

import entities.Artist;
import entities.Playlist;
import entities.PlaylistFactory;
import entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FollowArtistInteractor implements FollowArtistInputBoundary {

  final FollowArtistSpotifyDataAccessInterface spotifyDataAccessObject;
  final FollowArtistDataAccessInterface artistDataAccessObject;
  final FollowArtistUserDataAccessInterface userDataAccessObject;
  final FollowArtistOutputBoundary followArtistPresenter;

  public FollowArtistInteractor(FollowArtistSpotifyDataAccessInterface spotifyDataAccessObject,
      FollowArtistDataAccessInterface userDataAccessObject,
      FollowArtistUserDataAccessInterface userDataAccessObject1,
      FollowArtistOutputBoundary followArtistPresenter) {
    this.spotifyDataAccessObject = spotifyDataAccessObject;
    this.artistDataAccessObject = userDataAccessObject;
    this.userDataAccessObject = userDataAccessObject1;
    this.followArtistPresenter = followArtistPresenter;
  }


  @Override
  public void execute(FollowArtistInputData followArtistInputData) {
    User user = userDataAccessObject.getUser(followArtistInputData.username);
    user.followArtist(followArtistInputData.id);
    // todo 2. add playlist to "usernames" library with songs from the artist
    ArrayList<String> topTracks = spotifyDataAccessObject.getTopTracks(followArtistInputData.id);
    PlaylistFactory playlistFactory = new PlaylistFactory();
    Playlist playlist = playlistFactory.create(
        "Best of " + spotifyDataAccessObject.getArtistID(followArtistInputData.id).getName(),
        user,
        topTracks);
    user.addPlaylist(playlist);
    // prepare the output data
    ArrayList<Map<String, String>> artists = new ArrayList<>();
    for (String followArtist : user.getFollowedArtists()) {
      Artist followedArtist = spotifyDataAccessObject.getArtistID(followArtist);
      Map<String, String> artistMap = new HashMap<>();
      artistMap.put("name", followedArtist.getName());
      artistMap.put("followers", followedArtist.getNumFollowers() + "");
      artistMap.put("iconPath", followedArtist.getImageUrl());
      artistMap.put("id", followedArtist.getID());
      artists.add(artistMap);
    }
    ArrayList<Map<String, String>> playlists = new ArrayList<Map<String, String>>();
    for (Playlist playlistUser : user.getPlaylists()) {

      // Structure the output data
      Map<String, String> playlistAdded = new HashMap<>();
      playlistAdded.put("title", playlistUser.getName());
      playlistAdded.put("owner", playlistUser.getOwner().getUsername());
      playlists.add(playlistAdded);
    }

    FollowArtistOutputData followArtistOutputData = new FollowArtistOutputData(artists, playlists);
    followArtistPresenter.prepareSuccessView(followArtistOutputData);

  }

}
