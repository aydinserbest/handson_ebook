package github.boniGarcia.testng.ch04.tabs;

public class IteratorTheory {
    /*
    In Java, an Iterator is a tool that allows us to traverse a collection, such as a Set, one element at a time.
    When you create an Iterator for a collection, it points to a position just before the first element in that collection.
    Here's a visual representation of what it looks like:

    [ ] [A] [B] [C] [ ] ...
     ^
    Iterator

    [A] [B] [C] represent elements within the Set.

    The square brackets [ ] represent the bounds of the collection.
    The caret ^ represents the iterator's current position.
    When the Iterator is first created, it's not pointing at any of the elements.
    It's positioned at a special spot that's just before the first element.
    When you call the next() method on the Iterator for the first time,
    it moves from this special starting position to the first element in the collection and returns it:

    [ ] [A] [B] [C] [ ] ...
         ^
      Iterator

      Now the iterator points to [A],
      which is the first element, and that's what is returned with the first call to next().
      If you call next() again, the iterator moves to [B], and so on.

    This behavior ensures that when you start iterating,
    you get the first element first, and you can continue to get each subsequent element in turn.

    The next() method of an Iterator in Java is a bit misleading by its name in this context.
    When you first obtain an iterator from a set and then call next() on it for the first time,
    it actually gives you the first element, not the second.
    The iterator starts before the first element, and each call to next() moves it forward to the next element.
    So, in your code:

    The first call to windowIterator.next() retrieves the first handle in the Set.
    If the set had more elements and you called windowIterator.next() again,
    it would then retrieve the second element, and so on for subsequent elements.


     */
    /*
    in a Set collection, the order of elements is not guaranteed.
    Set is an unordered collection by definition in Java,
    which means it does not maintain the order in which elements are inserted.
    When you use an Iterator to go through a Set, each call to next() returns an element,
    but you cannot predict the order in which you will receive them,
    especially if the Set has been modified between calls to next().

    In the context of Selenium WebDriver, when you call getWindowHandles(),
    it returns a Set of window handles. These handles are unique identifiers for each of the browser's windows or tabs.
    However, the order of these handles in the Set is not related to the order in which the windows or tabs were opened.
    Therefore, when you use an iterator on this Set:

    The first call to next() will give you one of the window handles,
    but you can't be sure if it's the original window or the new tab without further context.
    The second call to next() will give you the next handle in the Set,
    which, again, is not in a guaranteed order.
    This is why in your original code snippet, after retrieving a handle,
    there is a comparison to the currentHandle (the handle of the window
    that was initially focused) to determine which handle is for the new tab.
     */
    /*
    An iterator, in the context of programming, can be thought of as a kind of pointer or cursor
    that moves over the elements of a collection, such as an array, list, or set.
    It is a tool that allows us to step through the elements one by one without needing to know
    how the collection is structured internally.

    You can imagine an iterator as:

    A Tour Guide:
    Just like a tour guide who knows the path and leads you through a series of landmarks,
    an iterator leads you through each element in a collection.
    A Bookmark:
    Consider reading a book and using a bookmark to keep track of where you are.
    Each time you read and move the bookmark,
    you are moving to the next page—similar to how an iterator moves to the next element.
    A Remote Control:
    When you press the 'next' button on a remote control to go to the next channel or track,
    you're using it to iterate through channels or songs.
    A Cursor in a Text Editor:
    Just as a cursor in a text editor moves from one character to the next
    as you press the arrow key, an iterator moves from one element to the next in a collection.
    When naming an iterator in your code, you typically name it based on what it's iterating over.
    For example, if you're iterating over a set of windowHandles,
    you might name your iterator windowIterator. The name should reflect its purpose
    and the context in which you're using it, making your code more readable and understandable.
     */
}
