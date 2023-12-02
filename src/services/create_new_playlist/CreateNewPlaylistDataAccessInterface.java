package services.create_new_playlist;

import entities.User;

public interface CreateNewPlaylistDataAccessInterface {
    User getUser(String username);
}
