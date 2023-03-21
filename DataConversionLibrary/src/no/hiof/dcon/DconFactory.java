package no.hiof.dcon;

public class DconFactory {

    /**
     * Creates a default dcon object which can be used to access dcon methods.
     * @return      a Dcon object.
     */
    public static Dcon create() {

        return new Dcon();
    }


    /**
     * in this method, call the newInstance method of the DconFactory class to
     * create a new instance of the factory.
     * @return return the new Instand Object.
     */
    public static DconFactory createInstance() {
        return null;
    }
}
