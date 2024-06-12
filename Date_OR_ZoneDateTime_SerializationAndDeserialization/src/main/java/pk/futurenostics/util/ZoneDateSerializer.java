package pk.futurenostics.util;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ZoneDateSerializer extends JsonSerializer<ZonedDateTime> {

	@Override
	public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
	
		gen.writeString(value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
		
	}

}


// Usage Example
//  @JsonSerializer(using = ZoneDateSerializer.class)
// private ZoneDateTime dateOfBirth;
