package services.remove_track_from_playlist;

import entities.User;

public interface RemoveTrackFromPlaylistUserDataAccessInterface {
    boolean exists(String username);
    void saveUser(User user);
    User getUser(String username);
}
