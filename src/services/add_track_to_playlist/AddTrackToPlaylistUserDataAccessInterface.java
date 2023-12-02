package services.add_track_to_playlist;

import entities.User;

public interface AddTrackToPlaylistUserDataAccessInterface {
    boolean exists(String username);
    void saveUser(User user);
    User getUser(String username);
}
