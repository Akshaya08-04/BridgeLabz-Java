package json.practiceproblems;

import com.fasterxml.jackson.databind.*;
import com.networknt.schema.*;

import java.io.InputStream;
import java.util.Set;

public class EmailSchemaValidation {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream schemaStream = EmailSchemaValidation.class
                .getClassLoader()
                .getResourceAsStream("schema.json");

        JsonSchema schema = JsonSchemaFactory.getInstance()
                .getSchema(schemaStream);

        JsonNode data = mapper.readTree("{\"email\":\"akshaya@gmail.com\"}");

        Set<ValidationMessage> errors = schema.validate(data);

        System.out.println(errors.isEmpty() ? "Valid Email" : errors);
    }
}
