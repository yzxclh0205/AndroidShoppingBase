package com.shoping.mall.study.retrofit2.my.Converter;

import com.google.gson.Gson;

/**
 * Created by LiCola on  2016/04/17  18:18
 */
public class AvatarConverter extends retrofit2.Converter.Factory  {
    private static final String TAG = "AvatarConverter";

    /**
     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static AvatarConverter create() {
        return create(new Gson());
    }

    /**
     * Create an instance using {@code gson} for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static AvatarConverter create(Gson gson) {
        return new AvatarConverter(gson);
    }

    private final Gson gson;

    private AvatarConverter(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
        // Logger.d();
    }

//    @Override
//    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//        return new AvatarResponseBodyConverter<>(gson,type);
//    }
//
//    @Override
//    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
//        //打包请求体
//        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
//    }

}
