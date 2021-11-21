package com.example.demo.serialization;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class JsonDateDeserializer extends JsonDeserializer<LocalDate>
{
    // ISO 8601
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException
    {
        try
        {
        	Date dat=dateFormat.parse(jsonParser.getText());
            return dat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
 
        } catch (java.text.ParseException e) {
			// 
        	throw new JsonParseException("Could not parse date", jsonParser.getCurrentLocation(), e);
		}
    }
}