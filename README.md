# minesweeper
Sebastian Manfria

RESTful API
* https://minesweeper-sebastian-manfria.herokuapp.com/minesweeper/swagger-ui.html
* https://github.com/smanfria/minesweeper

API client
* https://github.com/smanfria/minesweeper-client
I do not have any experience with Golang, but I tried to use it to learn something new.

## The Game
Develop the classic game of [Minesweeper](https://en.wikipedia.org/wiki/Minesweeper_(video_game))

## What to build
* Design and implement  a documented RESTful API for the game (think of a mobile app for your API) **DONE**
* Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API **DONE**
* When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat) **DONE**
* Ability to 'flag' a cell with a question mark or red flag **DONE**
* Detect when game is over **DONE**
* Persistence **DONE In Memory map. It could be used an embedded MongoDB but for the challenge propose I think is the same result.**
* Time tracking **DONE**
* Ability to start a new game and preserve/resume the old ones **DONE**
* Ability to select the game parameters: number of rows, columns, and mines **DONE**
* Ability to support multiple users/accounts