# Problem Domain Description
We have chosen **Music Organization/Streaming Service** as our project domain. Possible use cases include the following.
* sign-up
* login
* search for song
* favourite a song
* create playlist
* add song to playlist
* remove song from playlist
* add friend
* share playlist with friend

# Application Description
Our application will take inspiration from Spotify's UX. It will be a music searching and sharing platform. 

# Spotify API
[General Documentation](https://developer.spotify.com/documentation/web-api)

[Client Credentials Documentation](https://developer.spotify.com/documentation/web-api/tutorials/client-credentials-flow)

Hoppscotch demo call
![Hoppscotch demo call screenshot](https://i.imgur.com/L4ZIbyD.png)

[Search Endpoint Documentation](https://developer.spotify.com/documentation/web-api/reference/search)

Hoppscotch demo call
![Hoppscotch demo call screenshot](https://imgur.com/i4WJwcC.png)

# Example Java Output 


# Technical Problems
* The Spotify API does not provide actual music files, so if we wanted to have a "play song" use case we likely would need to use some sort of [downloader tool](https://github.com/SwapnilSoni1999/spotify-dl) or API
* In order to support the "login", "add friend", and "share playlist with friend" use cases, we will need to be able to sync persistent data with all users, possibly by using a database API 
