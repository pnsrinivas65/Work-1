package task;

import java.util.stream.Collectors;

public class RecordFormatter {

    public String format(Record rec) {
        if (rec instanceof AddressRecord) {
            AddressRecord aRec = (AddressRecord) rec;
            return "address: " + aRec.getCountry() + ", " + aRec.getProvince() + ", " + aRec.getCity() + ", " +
                    aRec.getStreet() + " st., " + aRec.getBuilding() + " b., " + aRec.getApartment() + " apt., " +
                    aRec.getIndex();
        } else if (rec instanceof BirthdayRecord) {
            BirthdayRecord bRec = (BirthdayRecord) rec;
            return "birthday: " + bRec.getYear() + "/" + bRec.getMonth() + "/" + bRec.getDay();
        } else if (rec instanceof FeedbackRecord) {
            FeedbackRecord fRec = (FeedbackRecord) rec;
            return "feedback: " + fRec.getCriterion() + "=" + fRec.getQuality();
        } else if (rec instanceof SkillsRecord) {
            SkillsRecord sRec = (SkillsRecord) rec;
            return "skills: " + sRec.getSkill() + "=" + sRec.getLevel();
        } else if (rec instanceof VisaRecord) {
            VisaRecord vRec = (VisaRecord) rec;
            return "visa: " + vRec.getCountry() + ", from: " + vRec.getFrom() + ", to: " + vRec.getTo();
        } else if (rec instanceof WorkloadRecord) {
            WorkloadRecord wRec = (WorkloadRecord) rec;
            return wRec.getWorkload().entrySet()
                    .stream()
                    .map(e -> e.getKey() + ":" + e.getValue())
                    .collect(Collectors.joining(", ", "workload: ", ""));
        } else return "record no: " + rec.getId();
    }
}
