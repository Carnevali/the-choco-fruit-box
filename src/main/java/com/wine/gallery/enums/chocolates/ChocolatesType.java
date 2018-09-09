package com.wine.gallery.enums.chocolates;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@JsonDeserialize(using = ChocolatesType.Deserializer.class )
@JsonFormat(shape = JsonFormat.Shape.OBJECT )
public enum ChocolatesType {
    MILK("Milk", "label-success"),

    DARK("Dark", "label-info"),

    WHITE("White", "label-purple");

    private String value;
    private String label;

    private ChocolatesType(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static class Deserializer extends JsonDeserializer<ChocolatesType> {
        @Override
        public ChocolatesType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
            final JsonNode nodes = parser.getCodec().readTree(parser);
            final String enumName = nodes.get("value").asText();
            return ChocolatesType.valueOf(enumName.toUpperCase());
        }
    }
}