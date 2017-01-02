package org.truetraining.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Component
public class MyCustomModule extends SimpleModule {

    // try KryoSerializator
//    @Override
//    public void setupModule(SetupContext context) {
//
//        SimpleSerializers serializers = new SimpleSerializers();
//        SimpleDeserializers deserializers = new SimpleDeserializers();
//
//        serializers.addSerializer(Question.class, new JsonSerializer<Question>() {
//            @Override
//            public void serialize(Question value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
//                //
//            }
//        });
//        deserializers.addDeserializer(Question.class, new JsonDeserializer<Question>() {
//            @Override
//            public Question deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//                return null;
//            }
//        });
//
//        context.addSerializers(serializers);
//        context.addDeserializers(deserializers);
//    }
}
