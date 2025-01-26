package game.logic.player;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class PlayerNameTest {

    PlayerName playerName = new PlayerName("test");

    @Test
    void testToString() {
        assertEquals("test", playerName.toString());
    }

    @Test
    void testEquals() {
        PlayerName playerName2 = new PlayerName("test");
        assertEquals(playerName, playerName2);
    }

    @Test
    void testHashCode() {
        PlayerName playerName2 = new PlayerName("test");
        assertEquals(playerName.hashCode(), playerName2.hashCode());
    }

    @Test
    void testPlayerNameSerializerWithoutMockito() throws IOException {
        StringWriter writer = new StringWriter();
        JsonGenerator jsonGenerator = new ObjectMapper().getFactory().createGenerator(writer);
        SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();

        new PlayerName.PlayerNameSerializer().serialize(playerName, jsonGenerator, serializerProvider);
        jsonGenerator.flush();

        assertEquals("\"test\"", writer.toString());
    }
}