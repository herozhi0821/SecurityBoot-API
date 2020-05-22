package net.cnki.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 
 * @author ZhiPengyu
 * @ClassName:    [FastJson2JsonRedisSerializer]
 * @Description:  [自定义序列化]
 * @CreateDate:   [2019年12月20日 下午2:17:00]
 * @param <T>
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super(); this.clazz = clazz;
    }

        @Override
        public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

        @Override
        public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        ParserConfig.getGlobalInstance().addAccept("net.cnki.bean");//反序列化需要将实体类所在包写入，多个包写多次addAccept
        return (T) JSON.parseObject(str, clazz);
    }
}

