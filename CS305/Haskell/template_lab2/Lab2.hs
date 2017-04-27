
module Lab2
(f
,fForIntegral
,member
,validSet
,setEQ
,unionEQ
,intersection
) where
import Data.List

-------------------------------------------------------------------------------
    -- Warmup
f list k =
    -- a
    if null list
    -- b
    then []
    -- c
    else head list + k : f (tail list) k

-------------------------------------------------------------------------------
    -- Pattern Matching
fForIntegral:: [Int] -> Int -> [Int] --take in an list of ints, and an int, return a list of ints
fForIntegral as a = [b + a | b <- as] --take the list(as) and the int(a), add the int to each element (b) in the list
-------------------------------------------------------------------------------
    -- Set membership
member:: (Eq a) => a -> [a] -> Bool -- take in some type a, some list a, and return a bool
member a [] = False --if the list is empty return false
member a (b:bs) -- element a and head of list bs
 | a == b = True --a and the head of the list are equalvilent, then it is in the list
 | otherwise = member a (bs) --iterate if not found

-----------------------------------------------------------------------------
    -- Valid set
validSet:: (Eq a) => [a] -> Bool --Takes in a list, returns bool
validSet [] = True --empty set
validSet [a] = True
validSet (a:b:as) = if a == b then False else validSet (b:as) --if head is equal to head+1 the set is not valid. traverse until empty

-------------------------------------------------------------------------------
    -- Set eq
setEQ:: (Eq a) => [a] -> [a] -> Bool --take an a list a, another list a, and returns a bool
setEQ  as bs = [a | a <- as, member a bs]  == as && length [a | a <- as, member a bs]  == length as --take the intersection of a and b, if this new list is equal to as, then the two lists are the same
-------------------------------------------------------------------------------
    -- Union
unionEQ:: (Eq a) => [a] -> [a] -> [a] --take in 2 lists and returns a list
unionEQ as bs = nub(as ++ bs) --adds both lists together, removing repeating elements

-------------------------------------------------------------------------------
    -- Intersecton
intersection:: (Eq a) => [a] -> [a] -> [a]
intersection as bs = [a | a <- as, member a bs] --list cs equals all elements of a that are in bs
