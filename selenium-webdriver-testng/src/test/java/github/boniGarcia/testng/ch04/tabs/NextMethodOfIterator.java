package github.boniGarcia.testng.ch04.tabs;

public class NextMethodOfIterator {
    /*
    The next() method of an Iterator in Java is a bit misleading by its name in this context.
    When you first obtain an iterator from a set and then call next() on it for the first time,
    it actually gives you the first element, not the second. The iterator starts before the first element,
    and each call to next() moves it forward to the next element.
    So, in your code:

    The first call to windowIterator.next() retrieves the first handle in the Set.
    If the set had more elements and you called windowIterator.next() again,
    it would then retrieve the second element,
    and so on for subsequent elements.

    Here's how it works in steps:

    Iterator<String> windowIterator = windowHandles.iterator();
    This line creates an iterator for the windowHandles set. At this point, the iterator is
    positioned before the first element of the set.

    String setHandle = windowIterator.next();
    This line moves the iterator to the first element and returns it.
    So setHandle will now contain the first handle from the set.
    If you only had two windows or tabs open,
    this would be the handle for either the original window or the new tab,
    but we don't know which one until we compare it to currentHandle.

    The if and else logic then determines whether setHandle is the original window's handle
    or the new tab's handle by comparison with currentHandle.
    If it's not the current window's handle, then it must be the new tab's handle, and vice versa.

     */
    /*
    The windowHandles set contains the window handles for all the open browser windows or tabs
    that Selenium WebDriver is aware of.
    When you call windowIterator.next(), it retrieves the next available handle from the windowHandles set.

    In the code you've provided:

    String setHandle = windowIterator.next();
    retrieves the first handle from the set of handles.
    Since Set does not maintain the order of its elements,
    this handle could be the one for the original window or the new tab, we can't be certain just from this line alone.

    The if statement then checks if this handle is different from the current window's handle,
    which is stored in currentHandle. If they are not the same,
    setHandle must be the handle of the new tab, and so it is assigned to newTabHandle.

    The else block is there for when setHandle is the same as currentHandle.
    This means the first handle retrieved by windowIterator.next() was for the current window,
    and so the next handle obtained by calling windowIterator.next() again must be for the new tab.
    Therefore, inside the else block, newTabHandle is assigned the value of this second handle from the iterator.

    So essentially, the code is using the iterator to cycle through the set of window handles
    and identify which one is the new tab by process of elimination. If the first one isn't the new tab,
    by default, the second one must be.
     */
}
