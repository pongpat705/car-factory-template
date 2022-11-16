package th.prior.training.car.factory.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeDeserializer extends StdDeserializer<LocalTime> {
    /**
     *
     */
    private static final long serialVersionUID = 7664287524730457513L;

    public TimeDeserializer() {
        this(null);
    }

    protected TimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();
        DateTimeFormatter dft = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime dateTime = LocalTime.parse(date, dft);
        return dateTime;
    }
}
