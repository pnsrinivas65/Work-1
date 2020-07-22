package task;

import org.junit.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RecordFormatterTest {

	private RecordFormatter formatter = new RecordFormatter();

	@Test
	public void formatAddress() {
		AddressRecord aRec = new AddressRecord();
		aRec.setId("1");
		aRec.setCountry("Ukraine");
		aRec.setProvince("Kharkivska");
		aRec.setCity("Kharkiv");
		aRec.setStreet("23 Serpnya");
		aRec.setBuilding("33");
		aRec.setApartment("N/A");
		aRec.setIndex("61000");
		String fmt = formatter.format(aRec);
		assertThat(fmt, is("address: Ukraine, Kharkivska, Kharkiv, 23 Serpnya st., 33 b., N/A apt., 61000"));
	}

	@Test
	public void formatBirthday() {
		BirthdayRecord bRec = new BirthdayRecord();
		bRec.setYear(1989);
		bRec.setMonth(11);
		bRec.setDay(27);
		String fmt = formatter.format(bRec);
		assertThat(fmt, is("birthday: 1989/11/27"));
	}

	@Test
	public void formatVisa() {
		VisaRecord vRec = new VisaRecord();
		vRec.setId("3");
		vRec.setCountry("Ukraine");
		vRec.setFrom(ZonedDateTime.of(2006, 7, 23, 0, 0, 0, 0, ZoneOffset.UTC));
		vRec.setTo(ZonedDateTime.of(2120, 7, 23, 0, 0, 0, 0, ZoneOffset.UTC));
		String fmt = formatter.format(vRec);
		assertThat(fmt, is("visa: Ukraine, from: 2006-07-23T00:00Z, to: 2120-07-23T00:00Z"));
	}

	@Test
	public void formatWorkload() {
		WorkloadRecord wRec = new WorkloadRecord();
		wRec.setId("4");
		Map<Integer, Double> workload = new LinkedHashMap<>();
		workload.put(1, 100d);
		workload.put(2, 90d);
		workload.put(3, 0d);
		wRec.setWorkload(workload);
		String fmt = formatter.format(wRec);
		assertThat(fmt, is("workload: 1:100.0, 2:90.0, 3:0.0"));
	}

	@Test
	public void formatSkills() {
		SkillsRecord sRec = new SkillsRecord();
		sRec.setSkill("Java");
		sRec.setLevel(SkillsRecord.Level.INTERMEDIATE);
		String fmt = formatter.format(sRec);
		assertThat(fmt, is("skills: Java=INTERMEDIATE"));
	}

	@Test
	public void formatFeedback() {
		FeedbackRecord fRec = new FeedbackRecord();
		fRec.setCriterion("Team work");
		fRec.setQuality(FeedbackRecord.Quality.MEETS_EXPECTATION);
		String fmt = formatter.format(fRec);
		assertThat(fmt, is("feedback: Team work=MEETS_EXPECTATION"));
	}
}
