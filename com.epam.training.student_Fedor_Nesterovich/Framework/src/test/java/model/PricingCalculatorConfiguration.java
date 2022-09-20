package model;

import java.util.Objects;

public class PricingCalculatorConfiguration {

    private String numberOfInstances;
    private String seriesValueXpath;
    private String machineTypeValueXpath;
    private String gpuTypeValueXpath;
    private String gpuQuantityValueXpath;
    private String localSsdValueXpath;
    private String datacenterLocationValueXpath;
    private String committedUsageValueXpath;

    public PricingCalculatorConfiguration(String numberOfInstances, String seriesValueXpath, String machineTypeValueXpath, String gpuTypeValueXpath, String gpuQuantityValueXpath, String localSsdValueXpath, String datacenterLocationValueXpath, String committedUsageValueXpath) {
        this.numberOfInstances = numberOfInstances;
        this.seriesValueXpath = seriesValueXpath;
        this.machineTypeValueXpath = machineTypeValueXpath;
        this.gpuTypeValueXpath = gpuTypeValueXpath;
        this.gpuQuantityValueXpath = gpuQuantityValueXpath;
        this.localSsdValueXpath = localSsdValueXpath;
        this.datacenterLocationValueXpath = datacenterLocationValueXpath;
        this.committedUsageValueXpath = committedUsageValueXpath;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getSeriesValueXpath() {
        return seriesValueXpath;
    }

    public void setSeriesValueXpath(String seriesValueXpath) {
        this.seriesValueXpath = seriesValueXpath;
    }

    public String getMachineTypeValueXpath() {
        return machineTypeValueXpath;
    }

    public void setMachineTypeValueXpath(String machineTypeValueXpath) {
        this.machineTypeValueXpath = machineTypeValueXpath;
    }

    public String getGpuTypeValueXpath() {
        return gpuTypeValueXpath;
    }

    public void setGpuTypeValueXpath(String gpuTypeValueXpath) {
        this.gpuTypeValueXpath = gpuTypeValueXpath;
    }

    public String getGpuQuantityValueXpath() {
        return gpuQuantityValueXpath;
    }

    public void setGpuQuantityValueXpath(String gpuQuantityValueXpath) {
        this.gpuQuantityValueXpath = gpuQuantityValueXpath;
    }

    public String getLocalSsdValueXpath() {
        return localSsdValueXpath;
    }

    public void setLocalSsdValueXpath(String localSsdValueXpath) {
        this.localSsdValueXpath = localSsdValueXpath;
    }

    public String getDatacenterLocationValueXpath() {
        return datacenterLocationValueXpath;
    }

    public void setDatacenterLocationValueXpath(String datacenterLocationValueXpath) {
        this.datacenterLocationValueXpath = datacenterLocationValueXpath;
    }

    public String getCommittedUsageValueXpath() {
        return committedUsageValueXpath;
    }

    public void setCommittedUsageValueXpath(String committedUsageValueXpath) {
        this.committedUsageValueXpath = committedUsageValueXpath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingCalculatorConfiguration that = (PricingCalculatorConfiguration) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) && Objects.equals(seriesValueXpath, that.seriesValueXpath) && Objects.equals(machineTypeValueXpath, that.machineTypeValueXpath) && Objects.equals(gpuTypeValueXpath, that.gpuTypeValueXpath) && Objects.equals(gpuQuantityValueXpath, that.gpuQuantityValueXpath) && Objects.equals(localSsdValueXpath, that.localSsdValueXpath) && Objects.equals(datacenterLocationValueXpath, that.datacenterLocationValueXpath) && Objects.equals(committedUsageValueXpath, that.committedUsageValueXpath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, seriesValueXpath, machineTypeValueXpath, gpuTypeValueXpath, gpuQuantityValueXpath, localSsdValueXpath, datacenterLocationValueXpath, committedUsageValueXpath);
    }

    @Override
    public String toString() {
        return "PricingCalculatorConfiguration{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", seriesValueXpath='" + seriesValueXpath + '\'' +
                ", machineTypeValueXpath='" + machineTypeValueXpath + '\'' +
                ", gpuTypeValueXpath='" + gpuTypeValueXpath + '\'' +
                ", gpuQuantityValueXpath='" + gpuQuantityValueXpath + '\'' +
                ", localSsdValueXpath='" + localSsdValueXpath + '\'' +
                ", datacenterLocationValueXpath='" + datacenterLocationValueXpath + '\'' +
                ", committedUsageValueXpath='" + committedUsageValueXpath + '\'' +
                '}';
    }
}
