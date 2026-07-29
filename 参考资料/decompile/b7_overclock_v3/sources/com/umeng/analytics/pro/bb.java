package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class bb {
    public static ba a(Class<? extends ba> cls, int i10) {
        try {
            return (ba) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
