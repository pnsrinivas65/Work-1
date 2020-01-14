package task;

import java.util.Map;

public class WorkloadRecord extends Record {

    private Map<Integer, Double> workload;

    public Map<Integer, Double> getWorkload() {
        return workload;
    }

    public void setWorkload(Map<Integer, Double> workload) {
        this.workload = workload;
    }

}
