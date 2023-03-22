package no.hiof.dcon;

/**
 * DconMap is a custom map strcuture which is specialized towards handling Xml and Json.
 */
public class DconMap {
    private DconMap() {
    }

    /**
     * Creates a new Dconmap through a factory method.
     * @return A DconMap instance.
     */
    public DconMap create(){
        return new DconMap();
    }
}
