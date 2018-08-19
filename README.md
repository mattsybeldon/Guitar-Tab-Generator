# Guitar-Tab-Generator
This is a project to develop a web app that will receive input (start with HTML input, maybe more sources after), and figure out the "best" way of generating the guitar tablature.

## Motivation

As a guitar player, this sort of app might be useful if you're noodling around with your guitar and stumble upon something interesting. Guitarists are notorious for not being formally trained in music, so there's a sizable crowd that could use it in tab format.

## Usage

I'm still developing it.

Will fill this out once things develop.

## History
8/19 - Changing focus a little bit to be a web app in the interest of time/effort

1/28 - Ended up not using the tree structure in favor of enumerating valid combinations and picking the best one based on minimizing the maximum horizontal jump in hand position. Basic sequencing for blocks of notes is complete. Next step is to develop onset and pitch detection. Once that's done, we need to migrate over to Android Studio.

1/27 - Working on the engine to return fret candidates based on input notes. Currently using strings to specify input. Next step is to build and traverse a tree based off of the candidate notes.
