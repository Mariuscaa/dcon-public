package no.hiof.dcon;

/**
 * DconFactory is a factory class which is used to create Dcon objects.
 */
public class DconFactory {

    /**
     * Creates a default dcon object which can be used to access dcon methods.
     * @return  a Dcon object.
     */
    public static Dcon create() {

        return new Dcon();
    }

    /**
     * in this method, call the newInstance method of the DconFactory class to
     * create a new instance of the factory.
     * @return return the new Instance Object.
     */
    public static DconFactory createInstance() {
        return null;
    } // Not sure what to do with an instance of a DconFactory yet.
}
