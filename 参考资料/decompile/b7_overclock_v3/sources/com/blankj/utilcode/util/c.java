package com.blankj.utilcode.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11703c = "ApiUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Class, C0116c> f11704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Class, Class> f11705b;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface b {
        boolean isMock() default false;
    }

    /* JADX INFO: renamed from: com.blankj.utilcode.util.c$c, reason: collision with other inner class name */
    public static class C0116c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f11706a = new c();
    }

    public static <T extends C0116c> T a(@g.n0 Class<T> cls) {
        Objects.requireNonNull(cls, "Argument 'apiClass' of type Class<T> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) c().b(cls);
    }

    public static c c() {
        return d.f11706a;
    }

    public static void e(Class<? extends C0116c> cls) {
        c().f(cls);
    }

    public static String g() {
        return c().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Result> Result b(Class cls) {
        Result result = (Result) ((C0116c) this.f11704a.get(cls));
        if (result != null) {
            return result;
        }
        synchronized (cls) {
            Result result2 = (Result) ((C0116c) this.f11704a.get(cls));
            if (result2 != null) {
                return result2;
            }
            Class cls2 = this.f11705b.get(cls);
            if (cls2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The <");
                sb2.append(cls);
                sb2.append("> doesn't implement.");
                return null;
            }
            try {
                Result result3 = (Result) ((C0116c) cls2.newInstance());
                this.f11704a.put(cls, (C0116c) result3);
                return result3;
            } catch (Exception unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The <");
                sb3.append(cls2);
                sb3.append("> has no parameterless constructor.");
                return null;
            }
        }
    }

    public final void d() {
    }

    public final void f(Class cls) {
        this.f11705b.put(cls.getSuperclass(), cls);
    }

    public String toString() {
        return "ApiUtils: " + this.f11705b;
    }

    public c() {
        this.f11704a = new ConcurrentHashMap();
        this.f11705b = new HashMap();
        d();
    }
}
