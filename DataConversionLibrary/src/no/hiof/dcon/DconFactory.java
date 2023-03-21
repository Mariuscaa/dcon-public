package no.hiof.dcon;

public class DconFactory {
    /**
     * Creates a default dcon object which can be used to access dcon methods.
     * @return      a Dcon object.
     */
    public static Dcon create() {
        return new Dcon();
    }

    public Dcon createDconInstance(){
        /**
         * createDconInstance() is the method that will create the instance of the Dcon class using the DconFactory.create()
         */
        return null;
    }

    public static String getStringFromPreferenceFactory(PreferenceFactory preferenceFactory, String key){
        /**
         * getStringFromPreferenceFactory() is the static method that will retrieve a String value from a
         * PreferenceFactory object using the preferenceFactory.getString() method.
         */
        return value;
    }

    public static DconFactory createInstance() {
        /**
         * in this method, call the newInstance method of the DconFactory class to
         * create a new instance of the factory.
         */
        return DconFactory.newInstance();
    }
}
