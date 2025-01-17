package pk.futurenostics.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateStandardSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if(value != null) {
			SimpleDateFormat dateFormate = new SimpleDateFormat("MM/dd/yyy");
			gen.writeString(dateFormate.format(value));
		}
		
	}

}
