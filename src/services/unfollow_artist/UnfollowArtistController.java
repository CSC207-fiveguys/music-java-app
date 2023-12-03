package services.unfollow_artist;

public class UnfollowArtistController {

  private final UnfollowArtistInputBoundary unfollowArtistInteractor;

  public UnfollowArtistController(UnfollowArtistInputBoundary unfollowArtistInteractor) {
    this.unfollowArtistInteractor = unfollowArtistInteractor;
  }

  public void execute(String id, String username) {
    UnfollowArtistInputData unfollowArtistInputData =
        new UnfollowArtistInputData(id, username);
    this.unfollowArtistInteractor.execute(unfollowArtistInputData);
  }
}
