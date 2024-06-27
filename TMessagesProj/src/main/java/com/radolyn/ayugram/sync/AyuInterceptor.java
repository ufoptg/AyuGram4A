/*
 * This is the source code of AyuGram for Android.
 *
 * We do not and cannot prevent the use of our code,
 * but be respectful and credit the original author.
 *
 * Copyright @Radolyn, 2023
 */

package com.radolyn.ayugram.sync;

import com.radolyn.ayugram.AyuUtils;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AyuInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        var req = chain.request()
                .newBuilder()
                .addHeader("X-APP-PACKAGE", AyuUtils.getPackageName())
                .addHeader("Authorization", AyuSyncConfig.getToken())
                .build();

        return chain.proceed(req);
    }
}
