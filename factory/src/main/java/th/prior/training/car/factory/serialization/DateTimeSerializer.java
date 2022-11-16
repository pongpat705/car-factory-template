package th.prior.training.car.factory.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeSerializer extends StdSerializer<LocalDateTime> {

    private static final long serialVersionUID = 8765121227807666405L;

    public DateTimeSerializer() {
        this(null);
    }

    protected DateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        DateTimeFormatter dft = DateTimeFormatter.ISO_DATE_TIME;
        gen.writeString(value.truncatedTo(ChronoUnit.SECONDS).format(dft));
    }

}
