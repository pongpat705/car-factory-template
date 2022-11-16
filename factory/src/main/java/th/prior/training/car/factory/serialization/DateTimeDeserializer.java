package th.prior.training.car.factory.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    private static final long serialVersionUID = 804777737972906663L;

    public DateTimeDeserializer() {
        this(null);
    }

    protected DateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        String date = p.getText();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");
        LocalDateTime dateTime = LocalDateTime.parse(date, dft);
        return dateTime;
    }

}
