package services.remove_track_from_liked;

import entities.User;

public interface RemoveTrackFromLikedUserDataAccessInterface {
    boolean exists(String username);
    void saveUser(User user);
    User getUser(String username);
}