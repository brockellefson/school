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


path(A,B):- connected(A,B).
path(A,B):-
  connected(A,C),
  path(C,B).

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


travel(A,B):- byCar(A,B); byTrain(A,B); byPlane(A,B).
travel(A,B):-
  (byCar(A,C);
  byTrain(A,C);
  byPlane(A,C)),
travel(C,B).


% Question 3
travel(A,B,C):- travel(A,B), travel(B,C).

% Extra Credit
leaf(1).
leaf(2).
leaf(3).
leaf(4).
leaf(5).

tree(A,B,Tree):- Tree = (A,B).

swap(Tree,MTree):- rev(Tree, MTree).

rev(L,R):-  accRev(L,[],R).

accRev([H|T],A,R):-  accRev(T,[H|A],R).
accRev([],A,A).
