package no.hiof.dcon;

/**
 * A class for a single object in either Json or Xml.
 * Has methods which makes modifying and accessing specific data easier.
 */
public class DconObject {
    private DconObject() {
    }

    /**
     * Factory method which creates an instance of the DconObject class.
     * @return  A DconObject object.
     */
    public static DconObject create(){
        return new DconObject();
    }

    /**
     * Gets the value of a specified property.
     * The name of the property is based on the keyname in Json or the tagname in Xml
     * @param keyTag    The property name which you want to look for. Called key in Json and tag in Xml.
     * @return          The value in the property in the form of a string.
     */
    public String getValue(String keyTag) {
        return null;
    }

    /**
     * Creates a new property in a DconObject instance.
     * @param valueName The name of the new property.
     */
    public void createProperty(String valueName) {
    }

    /**
     * Adds a value to a given key / property. Overwrites any existing value in the object.
     * @param existingKeyName   The name of the key
     * @param newValue          The value you want to put into the key.
     */
    public void add(String existingKeyName, String newValue) {
    }

}
