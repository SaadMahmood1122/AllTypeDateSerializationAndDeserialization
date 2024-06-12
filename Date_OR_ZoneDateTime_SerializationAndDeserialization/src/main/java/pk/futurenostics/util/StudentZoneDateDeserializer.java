package pk.futurenostics.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class StudentZoneDateDeserializer extends JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(p.getValueAsString(), dft);
		
		return date.atStartOfDay(ZoneId.systemDefault());
	}
}


// usage in dto

class Student{
	private String name;
	private String address;
	@JsonDeserialize(using = StudentZoneDateDeserializer.class)
	private ZonedDateTime dateofBirth;
	
}
