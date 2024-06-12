package pk.futurenostics.util;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ZoneDateTimeToDateSerializer extends JsonSerializer<ZonedDateTime>{

	@Override
	public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if(value != null) {
			gen.writeString(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(value));
		}
		
	}
	
	

}

// usage exp
// @JsonSerialize(using = ZoneDateTimeToDateSerializer.class)
// private ZonedDateTime myDate;

// OR

//public ZoneDateTime getMyDate() {
//	if(myDate != null) {
//		return myDate.toInstant().atZone(ZoneId.systemDefault());
//	}
//	return null;
//}
