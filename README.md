# Problem Domain Description
We have chosen **Music Organization Service** as our project domain.

Use cases include the following:
* sign-up
* login
* create playlist
* delete playlist
* search for track
  * like track
  * add track to playlist
  * unlike track
  * remove track from playlist
* search for artist
  * follow artist (a playlist of their top tracks will be added to your library)
  * unfollow artist
* search for friend
  * add friend (you will be able to view their playlists in your library)
  * remove friend (their playlists will then be removed)

All code follows SOLID design principles and CLEAN architecture (use cases have individual controllers, boundaries, interactors, and presentors)

# Spotify API

We use the following Spotify API endpoints in our project

[/token Credentials Documentation](https://developer.spotify.com/documentation/web-api/tutorials/client-credentials-flow)
* retrieve access token using environment variables SPOTIFY_CLIENT_ID and SPOTIFY_CLIENT_SECRET

[/search Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/search)
* display results from searching (tracks and artists)

[/tracks Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/get-track)
* save track on like/add to play list

[/artists Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/get-an-artist)
* save artist on follow

[/artists/{id}/top-tracks Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/get-an-artists-top-tracks)
* generate "best of" playlist on artist follow

# UI/Views

Signup View (no errors displayed)
![ss](https://i.imgur.com/SUcQ53z.png)

Signup View (username taken error)
![ss](https://i.imgur.com/WTd0GLD.png)

Signup View (password mismatch error)
![ss](https://i.imgur.com/R4N0hsG.png)

Login View (no errors displayed)
![ss](https://i.imgur.com/DMISZBN.png)

Login View (account does not exist error)
![ss](https://i.imgur.com/mlPPBzk.png)

Login View (wrong password error)
![ss](https://i.imgur.com/AP1TqTs.png)

Library View
![ss](https://i.imgur.com/x3ZsvCm.png)

Playlist View (viewing "Liked Tracks")
![ss](https://i.imgur.com/BIrmtg9.png)

Playlist View (viewing "Best of Drake")
![ss](https://i.imgur.com/CUh2kRY.png)

Followed Artist View
![ss](https://i.imgur.com/q7WKIY3.png)

Followed Friends View
![ss](https://i.imgur.com/XN3YYeh.png)

Search View
![ss](https://i.imgur.com/f2IeO6j.png)
