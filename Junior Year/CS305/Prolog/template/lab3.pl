% Question 1

connected(1,2).
connected(3,4).
connected(5,6).
connected(7,8).
connected(9,10).
connected(12,13).
connected(13,14).
connected(15,16).
connected(17,18).
connected(19,20).
connected(4,1).
connected(6,3).
connected(4,7).
connected(6,11).
connected(14,9).
connected(11,15).
connected(16,12).
connected(14,17).
connected(16,19).


path(A,B):- connected(A,B). %if A is connected to B, true
path(A,B):-
  connected(A,C),
  path(C,B). %if A is connected to C and C is connected to B then A,B must be true

% Question 2
byCar(auckland,hamilton).
byCar(hamilton,raglan).
byCar(valmont,saarbruecken).
byCar(valmont,metz).

byTrain(metz,frankfurt).
byTrain(saarbruecken,frankfurt).
byTrain(metz,paris).
byTrain(saarbruecken,paris).

byPlane(frankfurt,bangkok).
byPlane(frankfurt,singapore).
byPlane(paris,losAngeles).
byPlane(bangkok,auckland).
byPlane(singapore,auckland).
byPlane(losAngeles,auckland).


travel(A,B):- byCar(A,B); byTrain(A,B); byPlane(A,B). %Question 1 reformatted
travel(A,B):-
  (byCar(A,C);
  byTrain(A,C);
  byPlane(A,C)),
travel(C,B).


% Question 3
travel(A,B,C):- travel(A,B), travel(B,C). %if A connectes to B and B connectes to C then A connectes to C

% Extra Credit
leaf(1).
leaf(2).
leaf(3).
leaf(4).
leaf(5).

tree(A,B,C):- C = (A,B). %Tree(C) = A and B

swap(leaf(A),leaf(A)).
swap(tree(B,C),tree(D,E)) :- swap(B,E), swap(C,D). %switch the first element with the last element and the 2nd element with the 3rd element
