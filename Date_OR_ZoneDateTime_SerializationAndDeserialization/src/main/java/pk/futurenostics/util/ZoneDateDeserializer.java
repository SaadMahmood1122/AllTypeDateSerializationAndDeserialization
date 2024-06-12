package pk.futurenostics.util;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ZoneDateDeserializer extends JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		
		return ZonedDateTime.parse(p.getValueAsString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	}

}


// =======Usage Example========
//  @JsonDeserialize(using = ZoneDateDeserializer.class)
//  private ZonedDateTime dateOfMerage;
//
