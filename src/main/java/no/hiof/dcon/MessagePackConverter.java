package no.hiof.dcon;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.jackson.dataformat.MessagePackFactory;

/**
 * This class is used to perform conversions with MessagePack format.
 */
public class MessagePackConverter {

    private MessagePackConverter() {
        throw new UnsupportedOperationException("MessagePackConverter is a utility class and should not be instantiated.");
    }

    /**
     * Converts the given object to a MessagePack
     *
     * @param object The object to be converted to MessagePack.
     * @param <T>    The generic type of the object to be converted.
     * @return the MessagePack byte array
     * @throws Exception If an I/O error occurs during the conversion process.
     */
    public static <T> byte[] messagePackFromObject(T object) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        byte[] json = mapper.writeValueAsBytes(object);
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        packer.packBinaryHeader(json.length);
        packer.addPayload(json);
        byte[] messagePack = packer.toByteArray();
        packer.close();
        return messagePack;
    }
}
