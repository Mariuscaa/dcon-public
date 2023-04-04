package no.hiof.dcon;

/**
 * DconList is a special list which can be used with either Json or Xml data. It takes a list of objects from a string
 * or a file and transforms them into a list of objects in Java. Each object in the list is a DconObject.
 */
public class DconList {
    private DconList() {

    }
    /**
     * in this method, create a new instance of the List class and assign it to a variable.
     * @return It will return json data.
     */
    public static DconList create() {
        return new DconList();
    }

    /**
     * Adds a new DconObject to the end of the DconList.
     * @param dconObject The object which will be added to the list.
     */
    public void add(DconObject dconObject) {
    }
}
