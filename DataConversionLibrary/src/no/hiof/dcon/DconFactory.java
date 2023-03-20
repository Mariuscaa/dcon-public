package no.hiof.dcon;

public class DconFactory {
    /**
     * Creates a default dcon object which can be used to access dcon methods.
     * @return      a Dcon object.
     */
    public static Dcon create() {
        return new Dcon();
    }
}
