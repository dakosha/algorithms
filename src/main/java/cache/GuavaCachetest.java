package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

public class GuavaCachetest {

    public static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .build(
                    CacheLoader.from(GuavaCachetest::loadValue)
            );

    public static String loadValue(String name) {
        return "Dauren Mussa";
    }

    public static void main(String[] args) throws ExecutionException {
        System.out.println(cache.get("dakosha"));
    }

}
