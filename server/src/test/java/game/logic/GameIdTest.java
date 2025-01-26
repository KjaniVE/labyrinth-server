package game.logic;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class GameIdTest {

    @Test
    void testGameIdsFromTheSameStringAreEqual() {
        GameId id1 = new GameId("test");
        GameId id2 = new GameId("test");
        assertEquals(id1, id2);
    }

    @Test
    void testHashCode() {
        GameId id1 = new GameId("test");
        GameId id2 = new GameId("test");
        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void testGameIdSerializerWithoutMockito() throws IOException {
        GameId gameId = new GameId("test");
        StringWriter writer = new StringWriter();
        JsonGenerator jsonGenerator = new ObjectMapper().getFactory().createGenerator(writer);
        SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();

        new GameId.GameIdSerializer().serialize(gameId, jsonGenerator, serializerProvider);
        jsonGenerator.flush();

        assertEquals("\"test\"", writer.toString());
    }
}

