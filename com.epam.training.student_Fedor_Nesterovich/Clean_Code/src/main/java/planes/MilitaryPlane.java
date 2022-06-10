package planes;

import specifications.MilitaryPlaneTypes;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryPlaneTypes militaryPlaneType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneTypes planePurpose) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryPlaneType = planePurpose;
    }

    public MilitaryPlaneTypes getPlanePurpose() {
        return militaryPlaneType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", militaryPlaneType=" + militaryPlaneType +
                '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MilitaryPlane)) return false;
        if (!super.equals(object)) return false;
        MilitaryPlane plane = (MilitaryPlane) object;
        return militaryPlaneType == plane.militaryPlaneType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryPlaneType);
    }
}
