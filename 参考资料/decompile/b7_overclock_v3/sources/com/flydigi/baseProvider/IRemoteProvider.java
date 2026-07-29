package com.flydigi.baseProvider;

import android.content.Context;
import android.os.Parcelable;
import com.alibaba.android.arouter.facade.template.IProvider;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface IRemoteProvider extends IProvider {
    void a(Context context);

    void c(Context context, String actionActual);

    void d(Context context, String action, String key, int value);

    void e(Context context, String action, String key, String value);

    void f(Context context, String actionActual, String key, String value);

    void g(Context context, String action, String key, Serializable object);

    void h(Context context, String action, String key, Parcelable object);

    void i(Context context, String action, String key1, float value1, String key2, float value2, String key3, float value3, String key4, float value4, String key5, float value5, String key6, float value6);

    void k(Context context, boolean value);

    void l(Context context, String action);

    void m(Context context, String action, String key, byte[] bytes);

    void n(Context context, String action, String key, boolean value);
}
