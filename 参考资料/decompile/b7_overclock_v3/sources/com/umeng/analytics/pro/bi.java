package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class bi implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends aw>, Map<? extends bd, bi>> f23360d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f23362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bj f23363c;

    public bi(String str, byte b10, bj bjVar) {
        this.f23361a = str;
        this.f23362b = b10;
        this.f23363c = bjVar;
    }

    public static void a(Class<? extends aw> cls, Map<? extends bd, bi> map) {
        f23360d.put(cls, map);
    }

    public static Map<? extends bd, bi> a(Class<? extends aw> cls) {
        if (!f23360d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e10.getMessage());
            } catch (InstantiationException e11) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e11.getMessage());
            }
        }
        return f23360d.get(cls);
    }
}
