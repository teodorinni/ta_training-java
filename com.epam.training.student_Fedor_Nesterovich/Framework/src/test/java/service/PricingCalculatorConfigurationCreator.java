package service;

import model.PricingCalculatorConfiguration;

public class PricingCalculatorConfigurationCreator {

    private static final String NUMBER_OF_INSTANCES = "number.of.instances";
    private static final String SERIES_VALUE_XPATH = "series.value.xpath";
    private static final String MACHINE_TYPE_VALUE_XPATH = "machine.type.value.xpath";
    private static final String GPU_TYPE_VALUE_XPATH = "gpu.type.value.xpath";
    private static final String GPU_QUANTITY_VALUE_XPATH = "gpu.quantity.value.xpath";
    private static final String LOCAL_SSD_VALUE_XPATH = "local.ssd.value.xpath";
    private static final String DATACENTER_LOCATION_VALUE_XPATH = "datacenter.location.value.xpath";
    private static final String COMMITTED_USAGE_VALUE_XPATH = "committed.usage.value.xpath";

    public static PricingCalculatorConfiguration getCalculatorConfiguration() {
        return new PricingCalculatorConfiguration(
                TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(SERIES_VALUE_XPATH),
                TestDataReader.getTestData(MACHINE_TYPE_VALUE_XPATH),
                TestDataReader.getTestData(GPU_TYPE_VALUE_XPATH),
                TestDataReader.getTestData(GPU_QUANTITY_VALUE_XPATH),
                TestDataReader.getTestData(LOCAL_SSD_VALUE_XPATH),
                TestDataReader.getTestData(DATACENTER_LOCATION_VALUE_XPATH),
                TestDataReader.getTestData(COMMITTED_USAGE_VALUE_XPATH)
        );
    }
}
