package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum QueueName {

    QBATCH(QueueSubSystem.QBATCH, 4),

    NBATCH(QueueSubSystem.QBATCH),
    SATQUE(QueueSubSystem.QBATCH),
    SUNQUE(QueueSubSystem.QBATCH),
    SBATCH(QueueSubSystem.QBATCH),
    CBATCH(QueueSubSystem.QBATCH),
    RPTQUE(QueueSubSystem.QBATCH),
    CTCBATCH(QueueSubSystem.CTCBATCH),
    TRICKLE(QueueSubSystem.QBATCH),
    LBATCH(QueueSubSystem.QBATCH),
    AMS(QueueSubSystem.AMS, 10),
    AMSBATCH(QueueSubSystem.AMS),
    QCTL(QueueSubSystem.QCTL),
    CTCMQ(QueueSubSystem.CTCMQ, 10),
    SNBATCH(QueueSubSystem.CTCBATCH),
    MQTALKQ(QueueSubSystem.QBATCH),
    SAIDS(QueueSubSystem.QBATCH),

    DEFAULT(QueueSubSystem.JQM),
    BLANK(QueueSubSystem.JQM);

    private static final Logger LOG = LoggerFactory.getLogger(QueueName.class);

    private final QueueSubSystem subSystem;
    private final int capacity;
    private static final int DEFAULT_QUEUE_CAPACITY = 1;

    QueueName(QueueSubSystem subSystem, int capacity) {
        this.subSystem = subSystem;
        this.capacity = capacity;
    }

    QueueName(QueueSubSystem subSystem) {
        this(subSystem, DEFAULT_QUEUE_CAPACITY);
    }

    public QueueSubSystem getSubSystem() {
        return subSystem;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getValue() {
        return name();
    }

    /**
     * Indicate, is this queue is queue for some delayed tasks
     * It's can be SATQUE,SUNQUE or NBATCH
     *
     * @return true if this queue is in (SATQUE,SUNQUE,NBATCH)
     */
    public boolean isDelayedQueue() {
        return SATQUE == this || SUNQUE == this || NBATCH == this;
    }

    public static QueueName getByValue(String value) {
        try {
            return valueOf(value);
        } catch (IllegalArgumentException | NullPointerException e) {
            LOG.error("No queue found with name '{}'", value, e);
            return BLANK;
        }
    }
}
