# chess
Chess engine in progress

Has 3 main parts:

# Game representation:

Coord, Move, and Piece objects all determine where and what type of piece sits on the Chess Board. each piece can return a list of possible legal moves. All standard chess rules are currently being implemented. Currently missing: en passant, promotion, castling, drawing rules (insufficient material, 50 moves, repeated moves).

# Immediate Position Evaluator (IPE):

This evaluates the position by giving the board a number depending on several parameters:

       MATERIAL:
           Pawn: 1
           Isolated Pawn: 0.8

           Knight: 3
           Bishop: 3 (with 2 of them)
           Bishop: 2.8 (individual)
           Rook: 5
           Queen: 9

           King: 40 (check mate)

       POSSIBLE MOVES:

             Each move: 0.05

       OTHER:

          King being castled: 0.2
          Passed pawns: every pawn past all enemy pawns is 1.5
          
The IPE does not take into account future possible moves (hence the "immediate"). This will be the area in which most of the customization can be done. For example adding in more weight to possible moves would give the engine a more risky style of play

# True Position Evaluator (TPE):

This will evaluate the position while taking into account possible future moves both by yourself and opponent. It does this by making every single legal move, then making single legal move for opposite colour, and repeating this proccess a few times. Because one Legal Move set currently takes approximately 20 ms to evaluate, and each board has approximately 50 legal moves, anything past 4 iterations would take too long (50 ^ 4 * 0.02 = 2500 ~= 40 minutes). This means trimming should be done to the move list, in which moves that would be considered too bad (sacking queen) wouldn't even be considered. In addition for the second last iteration only the best move according to IPE could be considered making N iterations effectively N - 1.

Another way to speed this up could be to implement Dynamic Programming. It is highly possible that two different sets of moves would result in the same board. This means that we could skip an entire 20 ms for that one move by instead doing a lookup. Storing the boards however would be a lot of memory usage for large amounts of boards however that could be a solution.

Even if these things are not implemented, 4 iterations is definitely enough to make an okay playing chess engine.

# Stuff to do:

Implement FEN support: 
  FEN support would be very useful for testing the engine and analyzing real games. It also wouldn't be too difficult to implement.

GUI

Opening Move Database:
  the opening would be a place where a human who's played a decent amount of games would easily be able to overtake a chess engine this   poorly written positionally. Most modern openings have been analyzed very closesly by many very strong players and engines. This means   that people that have memorized these moves would essentially be playing as good as the strongest engines for the first few moves. 
  An opening move database would be able to equalize this somewhat.
  
  Also an endgame database would be huge with minimal advantages and would be very complicated, but possible to implement.
