package pk.futurenostics.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerializer extends StdSerializer<String> {

	protected CustomDateSerializer(Class<String> t) {
		super(t);
	
	}

	@Override
	public void serialize(String date, JsonGenerator gen, SerializerProvider provider) throws IOException {
		DateFormat orgDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date  orgDate = orgDateFormat.parse(date);
			DateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");
			dateFormate.setTimeZone(TimeZone.getTimeZone("UTC"));
		} catch (ParseException e) {
			// TODO: handle exception
		}
		
	}

}


