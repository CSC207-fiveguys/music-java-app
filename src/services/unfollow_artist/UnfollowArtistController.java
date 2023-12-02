package services.unfollow_artist;

public class UnfollowArtistController {

  private final UnfollowArtistInputBoundary unfollowArtistInteractor;

  public UnfollowArtistController(UnfollowArtistInputBoundary unfollowArtistInteractor) {
    this.unfollowArtistInteractor = unfollowArtistInteractor;
  }

  public void execute(String id, String username) {
    // todo 1. make user with "username" unfollow artist with "id"
    UnfollowArtistInputData unfollowArtistInputData =
        new UnfollowArtistInputData(id, username);
    this.unfollowArtistInteractor.execute(unfollowArtistInputData);
  }
}
