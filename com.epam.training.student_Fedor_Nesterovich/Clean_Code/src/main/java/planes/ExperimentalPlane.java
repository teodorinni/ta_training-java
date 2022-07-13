package planes;

import specifications.ClassificationLevels;
import specifications.ExperimentalTypes;

public class ExperimentalPlane extends Plane {

    private ExperimentalTypes experimentalType;
    private ClassificationLevels classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalType, ClassificationLevels classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevels getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel (ClassificationLevels classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
