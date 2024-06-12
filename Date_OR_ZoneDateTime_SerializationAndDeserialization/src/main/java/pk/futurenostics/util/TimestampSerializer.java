package pk.futurenostics.util;



import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TimestampSerializer extends JsonSerializer<Timestamp> {

	@Override
	public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if(value != null) {
			gen.writeString(ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault())
					.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
					);
		}
	}
	

}



//  ======Example for====
//  @JsonSerialize(Using = TimestampSerializar.class)
//	private Timestamp createdTime;
//

//@JsonSerialize(Using = TimestampSerializar.class)
//private Timestamp updatedTime;
