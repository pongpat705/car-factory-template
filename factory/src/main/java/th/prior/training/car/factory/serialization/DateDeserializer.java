package th.prior.training.car.factory.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDeserializer extends StdDeserializer<LocalDate> {
    /**
     *
     */
    private static final long serialVersionUID = 7664287524730457513L;

    public DateDeserializer() {
        this(null);
    }

    protected DateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();
        DateTimeFormatter dft = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate dateTime = LocalDate.parse(date, dft);
        return dateTime;
    }
}
