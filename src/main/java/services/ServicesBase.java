package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import utils.FileUtil;

public class ServicesBase {
    private static RequestSpecification requestSpec;
    protected static FileUtil fileUtil = new FileUtil();

    public static RequestSpecification getRequestSpec() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(fileUtil.getEnvProperties("base.url"))
                    .setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                    .build();
        }
        return requestSpec;
    }

    public String convertObjectToJson(Object object, ObjectMapper mapper){
        String json = null;
        try{
            // Convert object to JSON string
            json = mapper.writeValueAsString(object);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
