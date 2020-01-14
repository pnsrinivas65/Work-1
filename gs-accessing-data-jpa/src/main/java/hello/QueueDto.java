package hello;


import java.io.Serializable;
import java.util.Comparator;


public class QueueDto implements Serializable {
    public static final Comparator<QueueDto> BY_NAME_ASC = Comparator.comparing(o -> o.name);

    private String name;
    private String subSystem;
    private int capacity;

    public QueueDto() {
        // default
    }

    public QueueDto(QueueName name) {
        this.name = name.name();
        this.subSystem = name.getSubSystem().name();
        this.capacity = name.getCapacity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
