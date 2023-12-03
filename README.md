# Problem Domain Description
We have chosen **Music Organization Service** as our project domain.

Use cases include the following.
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
* remove friend

All code follows SOLID design principles and CLEAN architecture (use cases have individual controllers, boundaries, interactors, and presentors)

# Spotify API

[/token Credentials Documentation](https://developer.spotify.com/documentation/web-api/tutorials/client-credentials-flow)
* retrieve accesse token using environment variables SPOTIFY_CLIENT_ID and SPOTIFY_CLIENT_SECRET

[/search Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/search)
* display results from searching (tracks and artists)

[/tracks Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/get-track)
* save track on like/add

[/artists Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/get-an-artist)
* save artist on follow

[/artists/{id}/top-tracks Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/get-an-artists-top-tracks)
* generate "best of" playlist on artist follow

# UI/Views

Signup View (no errors displayed)
![ss](https://imgur.com/SUcQ53z)

Signup View (username taken error)
![ss](https://imgur.com/WTd0GLD)

Signup View (password mismatch error)
![ss](https://imgur.com/R4N0hsG)

Login View (no errors displayed)
![ss](https://imgur.com/DMISZBN)

Login View (account does not exist error)
![ss](https://imgur.com/mlPPBzk)

Login View (wrong password error)
![ss](https://imgur.com/AP1TqTs)

Library View
![ss](https://imgur.com/x3ZsvCm)

Playlist View (viewing "Liked Tracks")
![ss](https://imgur.com/BIrmtg9)

Playlist View (viewing "Best of Drake")
![ss](https://imgur.com/CUh2kRY)

Followed Artist View
![ss](https://imgur.com/q7WKIY3)

Followed Friends View
![ss](https://imgur.com/XN3YYeh)

Search View
![ss](https://imgur.com/f2IeO6j)
