
// immutable Sets

/**
 * Default implementation of a Set is HashSet, that use hashing function
 * to find out whether something is in the set and to navigate to
 * it very quickly
 */
val vowels = Set('a', 'e', 'i', 'o', 'u')

vowels.contains('a')
vowels.contains('t')

vowels('a')
vowels.apply('a')
//apply same as contains
vowels('t')

vowels + 'y'
vowels + 'e'

val commonLetters = Set('e','t','a','o','i','n','s','r','h')

commonLetters intersect vowels
commonLetters diff vowels
vowels diff commonLetters
commonLetters union vowels

// set can be used like a predicate
//Set[T] extends T => Boolean and has an apply method
"hello to me".count(vowels)

import scala.collection.immutable

// not ordered, but can be sorted
immutable.TreeSet('u', 'o', 'i', 'e', 'a')


// mutable

import scala.collection.mutable

val vowelsMut = mutable.Set('a', 'e', 'i', 'o', 'u')

vowelsMut += 'y'
vowelsMut('y')

vowelsMut -= 'y'
vowelsMut('y')

vowelsMut('y') = true
vowelsMut
vowelsMut('y')

vowelsMut('y') = false
vowelsMut
vowelsMut('y')


