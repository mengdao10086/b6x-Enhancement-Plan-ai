package com.blankj.utilcode.util;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public q() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T a(T t10, Type type) {
        try {
            return (T) l1.H(l1.a1(t10), type);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
