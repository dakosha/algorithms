package luxoft;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// REVIEW
public abstract class Digest {

    private final Map<DataHolder, byte[]> cache = Collections.synchronizedMap(new HashMap<>());

    public byte[] digest(DataHolder input) {
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (input.crcCode) {
                result = doDigest(input.data);
                cache.put(input, result);
            }
        }
        return result;
    }

    protected abstract byte[] doDigest(byte[] input);

    static class DataHolder {
        final byte[] data;
        final String crcCode;

        public DataHolder(String crcCode, byte[] data) {
            this.data = data;
            this.crcCode = crcCode.intern();//we amy use our implementation
        }

        @Override
        public int hashCode() {
            return crcCode.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return ((String) obj).equals(crcCode);
        }
    }
}
