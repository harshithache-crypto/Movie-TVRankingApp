# Project title: Ranked
# Overview: 
Movie and television tracking application that allows users to add movies and TV shows, assign ratings, organize them in a personal watchlist, and receive recommendations based on different ranking strategies. 
# Main purpose: 
Giving users one place to keep track of what they watched and what they may want to watch next. 
# Problem being solved: 
People watch lots of movies and TV shows across several streaming platforms so it is difficult to remember movies they already watched, how much they liked it, what they want to watch next, what movies/shows they rated the highest, etc.
# Intended Users: 
People who regularly watch movies, movie/tv show fans, users who just want to organize, remember, and compare their ratings.



## Sprint 1 - Project Setup
For Sprint 1, I completed the initial setup for the project
### Sprint 1 Checklist
- **Are you in a group?** No. This is an individual project
- **Do you have your GitHub account set up?** Yes
- **Do you have a public repository for your project?** Yes
- **Do you have a Hello World program that compiles and runs?** Yes
- **Where is the entry point to your project?** src/app/Main.java

## Sprint 2 - Project Selection and Initial Code
For Sprint 2, I organized the main concept for my project
### Project Selection
- **Add movies and TV shows they have finished**
- **Rate finished titles from 0-10**
- **Leave optional comments**
- **Rank watched titles based on their ratings**
- **Keep a Want to Watch list**
- **Track TV shows that are currently being watched**
- **Receive recommendations**
- **Create custom movie and TV show playlists**

# Sprint 3 - First Two Design Patterns
For Sprint 3, I implemented first 2 design patterns (factory, state) and created UML diagrams.
### Factory Method
Relevant classes:

- `MediaCreator`
- `MovieCreator`
- `TVShowCreator`
- `Media`
- `Movie`
- `TVShow`

`MovieCreator` creates Movie objects and `TVShowCreator` creates TVShow objects. This keeps the creation of different media types separated into their appropriate creator classes.

### State
Relevant classes/interfaces:

- `MediaState`
- `WantToWatchState`
- `WatchingState`
- `WatchedState`
- `UserMediaEntry`

The states allow media to move through the application as:

`Want to Watch -> Watching -> Watched`

## Sprint 4 - Two Additional Design Patterns

For Sprint 4, I implemented two additional design patterns: observer, state

### Observer
Relevant classes/interfaces:

- `WatchedListObserver`
- `WatchedList`
- `RankingDashboard`

`RankingDashboard` observes `WatchedList`. When the watched list changes, the dashboard receives the updated entries and ranks them from highest to lowest rating.

### Strategy
Relevant classes/interfaces:

- `RecommendationStrategy`
- `GenrePreferenceStrategy`
- `RandomRecommendationStrategy`
- `RecommendationEngine`

`GenrePreferenceStrategy` uses the user's ratings to determine a highly rated genre and attempts to recommend an unwatched title from that genre.

`RandomRecommendationStrategy` provides a random unwatched recommendation.

`RecommendationEngine` can use either strategy without needing to change the recommendation engine itself.

### Created 2 more patterns: composite, command



# Design Patterns

## Factory Method

### Relevant Classes / Interfaces

- `MediaCreator`
- `MovieCreator`
- `TVShowCreator`
- `Media`
- `Movie`
- `TVShow`
- `SampleCatalogLoader`

Factory Method is responsible for creating the Movie and TVShow objects used in the media catalog.

`MediaCreator` defines the creation method while `MovieCreator` and `TVShowCreator` determine which concrete Media object is created.



## State

### Relevant Classes / Interfaces

- `MediaState`
- `WantToWatchState`
- `WatchingState`
- `WatchedState`
- `UserMediaEntry`

State controls the current watching status of a user's media entry.

A title can begin in Want to Watch and then transition based on its type. TV shows can move into Watching, where the user can track their current season, before eventually becoming Watched.



## Observer

### Relevant Classes / Interfaces

- `WatchedListObserver`
- `WatchedList`
- `RankingDashboard`

Observer keeps the ranking dashboard updated when the user's watched list changes.

`RankingDashboard` observes `WatchedList`. When a finished title is added or a rating is updated, the watched list notifies its observers and the dashboard updates its rankings.



## Strategy

### Relevant Classes / Interfaces

- `RecommendationStrategy`
- `GenrePreferenceStrategy`
- `RandomRecommendationStrategy`
- `RecommendationEngine`

Strategy allows the recommendation algorithm to be changed without changing the RecommendationEngine.

The user can receive either a genre-based personalized recommendation or a random unwatched recommendation.



## Composite

### Relevant Classes / Interfaces

- `MediaComponent`
- `Media`
- `Movie`
- `TVShow`
- `MediaPlaylist`
- `PlaylistManager`

Composite is used for the playlist feature.

Individual Media objects and MediaPlaylist objects implement the common `MediaComponent` interface. This allows media items and collections of media to be treated through the same component structure.

Users can create playlists, choose whether they are public or private, and add watched movies and TV shows to them.


## Command

### Relevant Classes / Interfaces

- `Command`
- `MenuInvoker`
- `AddFinishedMediaCommand`
- `AddWantToWatchCommand`
- `ViewWatchQueueCommand`
- `UpdateProgressCommand`
- `ViewDashboardCommand`
- `RecommendationCommand`
- `CreatePlaylistCommand`
- `ViewPlaylistsCommand`

Command is used to implement the application's console menu.

Each menu action is represented by a Command object. `MenuInvoker` stores the commands and executes the appropriate command based on the user's menu selection.

This prevents all of the application's functionality from being placed directly inside `Main.java`.



# Final Functionality

- Search the sample movie and TV show catalog
- Add a finished movie or TV show
- Rate finished media from 0-10
- Leave an optional comment
- View finished titles ranked from highest to lowest
- Add movies and TV shows to Want to Watch
- Move TV shows into Watching
- Track the current season of a TV show
- Move completed media into Watched
- Receive genre-based recommendations
- Receive random recommendations
- Create custom playlists
- Set playlists as public or private
- Add watched media to playlists
- View playlists
- Interact with the application through a console menu
