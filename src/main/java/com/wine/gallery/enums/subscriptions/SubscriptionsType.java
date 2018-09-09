package com.wine.gallery.enums.subscriptions;

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

@JsonDeserialize(using = SubscriptionsType.Deserializer.class )
@JsonFormat(shape = JsonFormat.Shape.OBJECT )
public enum SubscriptionsType {
    SUBSCRIBER("Subscriber", "label-success"),

    SIX_MONTH("SixMonth", "label-info"),

    RANDON("Randon", "label-purple");

    private String value;
    private String label;

    private SubscriptionsType(String value, String label) {
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

    public static class Deserializer extends JsonDeserializer<SubscriptionsType> {
        @Override
        public SubscriptionsType deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
            final JsonNode nodes = parser.getCodec().readTree(parser);
            final String enumName = nodes.get("value").asText();
            return SubscriptionsType.valueOf(enumName.toUpperCase());
        }
    }
}