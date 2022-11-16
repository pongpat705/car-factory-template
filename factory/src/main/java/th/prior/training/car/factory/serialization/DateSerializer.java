package th.prior.training.car.factory.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;

public class DateSerializer extends StdSerializer<LocalDate> {
    private static final long serialVersionUID = -4217554393942640626L;

    public DateSerializer() {
        this(null);
    }

    protected DateSerializer(Class<LocalDate> vc) {
        super(vc);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());
    }
}