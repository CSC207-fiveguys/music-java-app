package services.follow_artist;

import services.add_friend.AddFriendInputBoundary;
import services.add_friend.AddFriendInputData;

public class FollowArtistController {
    private final FollowArtistInputBoundary addFriendInteractor;

    public FollowArtistController(FollowArtistInputBoundary addFriendInteractor) {
        this.addFriendInteractor = addFriendInteractor;
    }

    public void execute(String id, String username) {
        FollowArtistInputData followArtistInputData=
            new FollowArtistInputData(id, username);
        this.addFriendInteractor.execute(followArtistInputData);
    }
}
