
1. Iterate through the list and print out the information of the media by using toString() method. Observe
what happens and explain in detail. 
    Answer: Result has different kinds of information for different types of media because the parent class (Media) overrides the toString() method from the Object class, the children classes (CompactDisc, DigitalVideoDisc, and Book) override the toString() method (getDetails() method in my instance) from the class Media to match their data.


2. If the passing object is not an instance of Media, what happens?
    Answer: The override equals(Object o) function will now immediately return false.


3. Suppose we are taking this Comparable interface approach.

    3.1. What class should implement the Comparable interface?
        Answer: The Media class. In order for a Media instance to compare itself to other Media instances.


    3.2. In those classes, how should you implement the compareTo()method be to reflect the ordering that we want?
        Answer: First, we look to see if the first field's comparison yields 0. If not, we revert to the previous comparison. Otherwise, we return the second field's comparison result. For instance, if this.getTitle is true (). If compareTo(that.getTitle()) returns 0, the cost comparison result is returned.

    3.3. Can we have two ordering rules of the item (by title then cost and by cost then title) if we use this Comparable interface approach?
        Answer: No. There is no way to create two ordering rules at the same time since we can only override compareTo() once.

    3.4.  Suppose the DVDs has a different ordering rule from the other media types, that is by title, then decreasing length, then cost. How would you modify your code to allow this?
        Answer: Modifying the compare() function of the two classes MediaComparatorByCostTitle and MediaComparatorByTitleCost is one approach to achieve this. If the supplied instances are DigitalVideoDisc instances, the method should check them. If true, the DVD ordering rule will be used. Otherwise, it will use the Media's standard ordering rules.