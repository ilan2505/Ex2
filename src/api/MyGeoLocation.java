package api;

public class MyGeoLocation implements GeoLocation {
    private double x, y, z;

    /** Constructor */
    public MyGeoLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /** Copy GeoLocation Constructor*/
    public MyGeoLocation(GeoLocation location) {
        this.x=location.x();
        this.y= location.y();
        this.z= location.z();
    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public double z() {
        return z;
    }

    @Override
    public double distance(GeoLocation g) {
        return Math.sqrt((Math.pow(x-g.x(),2) + Math.pow(y-g.y(),2) + Math.pow(z-g.z(),2)));
    }
}
