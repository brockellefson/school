
module Lab2
(f) where
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
fForIntegral l a = [x + a| x <- l] --take the list(l) and the int(a), add the int to each element (x) in the list
-------------------------------------------------------------------------------
    -- Set membership
member:: Eq a => a -> [a] -> Bool --for anything in the EQ typeclass, take an an a, a list of the same typeclass, and return a bool
member a [] = False --if the list is empty return false
member a (b:l)
 | a == b = True --a and the head of the list are equalvilent
 | otherwise = member a (l) --repeat with augmented list

-------------------------------------------------------------------------------
    -- Valid set
--validSet:: Eq a => [a] -> Bool
--validSet a
--validSet b = head a
--validSet c = last a
--validSet l = [b..c]
--validSet (a:as) (l:ls)
--  | a == l = True
--  | otherwise = False


-------------------------------------------------------------------------------
    -- Set eq
setEQ:: [Int] -> [Int] -> Bool --takes in 2 lists
setEQ a b = sort a == sort b --sorts them, them

setEQ1::Eq a => [a] -> [a] -> Bool
setEQ1  a b = sort a == sort b --sorts them, them

-------------------------------------------------------------------------------
    -- Union


-------------------------------------------------------------------------------
    -- Intersecton
