package services.create_new_playlist;

public interface CreateNewPlaylistOutputBoundary {
    void prepareSuccessView(CreateNewPlaylistOutputData outputData);

    void prepareFailView(String error);

}
