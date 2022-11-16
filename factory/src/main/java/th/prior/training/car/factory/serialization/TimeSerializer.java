package th.prior.training.car.factory.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalTime;

public class TimeSerializer extends StdSerializer<LocalTime> {
    private static final long serialVersionUID = -4217554393942640626L;

    public TimeSerializer() {
        this(null);
    }

    protected TimeSerializer(Class<LocalTime> vc) {
        super(vc);
    }

    @Override
    public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());
    }
}