package com.github.kafka;


import java.util.Arrays;
import java.util.Optional;


public enum KafkaConfiguration {
    ADDBINCAP,
        ETOCUPC;

    private final boolean producer;
    private final boolean consumer;
    //private int priority = 10;

    KafkaConfiguration() {
        this(false, false);
    }

    

    KafkaConfiguration(boolean terminable,
            boolean cancellable) {
        this.producer = terminable;
        this.consumer = cancellable;
    }

    KafkaConfiguration(boolean terminable,
            boolean cancellable,
            int priority) {
        this.producer = terminable;
        this.consumer = cancellable;
    }

    public static KafkaConfiguration find(String jobName) {
        return findOptional(jobName)
                .orElseThrow(() -> new UnknownEnumValueException(KafkaConfiguration.class.getSimpleName(), jobName));
    }

    public static Optional<KafkaConfiguration> findOptional(String jobName) {
        return Optional.ofNullable(findValueOrNull(jobName));
    }

    @SuppressWarnings("squid:S1166")
    public static KafkaConfiguration findValueOrNull(String jobName) {
        for (KafkaConfiguration value : values()) {
            if (jobName.equals(value.name())) {
                return value;
            }
        }

        for (KafkaConfiguration value : values()) {
            if (jobName.startsWith(value.name())) {
                return value;
            }
        }

        return null;
    }

    @SuppressWarnings("squid:S1166")
    public static KafkaConfiguration getInstance(String name) {
        try {
            return valueOf(name);
        } catch (NullPointerException | IllegalArgumentException ignored) {
            return null;
        }
    }

    public static KafkaConfiguration[] listReportJobs() {
        return Arrays.stream(KafkaConfiguration.values())
                .filter(jobName -> jobName.name().startsWith("RPT"))
                .toArray(KafkaConfiguration[]::new);
    }

    public boolean isTerminable() {
        return producer;
    }

    public boolean isCancellable() {
        return consumer;
    }

}
