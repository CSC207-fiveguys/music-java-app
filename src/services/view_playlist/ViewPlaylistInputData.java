package services.view_playlist;

public class ViewPlaylistInputData {

    public final String playlistName;
    public final String username;
    public final Boolean isShowingLikedTracks;

    public ViewPlaylistInputData(String playlistName, String username, Boolean isShowingLikedTracks) {
        this.playlistName = playlistName;
        this.username = username;
        this.isShowingLikedTracks = isShowingLikedTracks;
    }

}
