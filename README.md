# Servicenow-Android-Exercise
## Take-home project for Servicenow Android Candidates

### Requirements
- A computer setup for Android development (contact your recruiter if one is not available)

### Objectives:
- Have fun
- Demonstrate knowledge of Android development

#### Exercise Details

- You may use Java or Kotlin, both options are available to you
- You are free to use any third party libraries. For your convenience, we have already added a few commonly used libraries in the [build.gradle](https://code.devsnc.com/terry-schmidt/Servicenow-Android-Exercise/blob/master/app/build.gradle).
- Please use git and commit often with meaningful commit messages, just as you would when working on a team.
- If you make an assumption during this exercise, run with it, but please write it down in a comment so we know the assumption when reviewing the code.
- You should fix any memory leaks, crashes, or bad practices you might find.
- Remember to think about common pitfalls such as how your app handles a configuration change.

You are given a simple project with a basic list of NES (Nintendo Entertainment System) games which uses locally stored data in a class called NESGames.
 
#### Exercise 1:

Replace the ListView with a RecyclerView. Upon tapping a recycler view cell, open a detail activity or fragment and show the longDescription field (in the Game class).

#### Exercise 2:

Use Retrofit or a similar networking library to load the game information from a web resource (https://jsonblob.com/api/jsonBlob/f5bf443c-160d-11ea-ab7b-c5ee597d34d8) instead of using the local data. You may use Gson or another parsing library.
 
- You can continue using the local game cover image files which are already in the drawable directory.
- You can choose to use, or not use Dagger2, RxJava2, or Kotlin Coroutines for threading.

#### Extra Credit: 
- Improve the project in any way you see fit (UX/UI, code structure, etc) and explain your enhancements in comments.

### When you are done

Zip the project and email it back to the recruiter.
