package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.LoginData;

public final class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtils() {
    }

    public static List<LoginData> getLoginData(String fileName) {

        try (InputStream inputStream = JsonUtils.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (inputStream == null) {
                throw new RuntimeException("JSON file not found : " + fileName);
            }

            return mapper.readValue(inputStream,
                    new TypeReference<List<LoginData>>() {
                    });

        } catch (IOException e) {
            throw new RuntimeException("Unable to read JSON", e);
        }
    }
}
