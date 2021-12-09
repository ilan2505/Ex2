import api.GeoLocation;

public class MyLoc implements GeoLocation {
    double x;
    double y;
    double z;
    public MyLoc(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        return 0;
    }
}
