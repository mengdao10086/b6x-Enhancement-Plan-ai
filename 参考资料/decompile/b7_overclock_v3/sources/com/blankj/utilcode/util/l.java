package com.blankj.utilcode.util;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f11918a;

    public static void a() {
        b(i());
    }

    public static void b(@g.n0 m mVar) {
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        mVar.a();
    }

    public static <T> T c(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) d(str, i());
    }

    public static <T> T d(@g.n0 String str, @g.n0 m mVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) mVar.b(str);
    }

    public static <T> T e(@g.n0 String str, T t10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) f(str, t10, i());
    }

    public static <T> T f(@g.n0 String str, T t10, @g.n0 m mVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) mVar.c(str, t10);
    }

    public static int g() {
        return h(i());
    }

    public static int h(@g.n0 m mVar) {
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return mVar.d();
    }

    public static m i() {
        m mVar = f11918a;
        return mVar != null ? mVar : m.e();
    }

    public static void j(@g.n0 String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        m(str, obj, i());
    }

    public static void k(@g.n0 String str, Object obj, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l(str, obj, i10, i());
    }

    public static void l(@g.n0 String str, Object obj, int i10, @g.n0 m mVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        mVar.i(str, obj, i10);
    }

    public static void m(@g.n0 String str, Object obj, @g.n0 m mVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        mVar.h(str, obj);
    }

    public static Object n(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return o(str, i());
    }

    public static Object o(@g.n0 String str, @g.n0 m mVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return mVar.j(str);
    }

    public static void p(m mVar) {
        f11918a = mVar;
    }
}
