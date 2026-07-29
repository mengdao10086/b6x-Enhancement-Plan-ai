package com.blankj.utilcode.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11753a = "defaultGson";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11754b = "delegateGson";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11755c = "logUtilsGson";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Gson> f11756d = new ConcurrentHashMap();

    public e0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Gson a() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    public static <T> T b(@g.n0 Gson gson, Reader reader, @g.n0 Class<T> cls) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(reader, (Class) cls);
    }

    public static <T> T c(@g.n0 Gson gson, Reader reader, @g.n0 Type type) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(reader, type);
    }

    public static <T> T d(@g.n0 Gson gson, String str, @g.n0 Class<T> cls) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(str, (Class) cls);
    }

    public static <T> T e(@g.n0 Gson gson, String str, @g.n0 Type type) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) gson.fromJson(str, type);
    }

    public static <T> T f(@g.n0 Reader reader, @g.n0 Class<T> cls) {
        Objects.requireNonNull(reader, "Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) b(k(), reader, cls);
    }

    public static <T> T g(@g.n0 Reader reader, @g.n0 Type type) {
        Objects.requireNonNull(reader, "Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) c(k(), reader, type);
    }

    public static <T> T h(String str, @g.n0 Class<T> cls) {
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) d(k(), str, cls);
    }

    public static <T> T i(String str, @g.n0 Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) e(k(), str, type);
    }

    public static Type j(@g.n0 Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getArray(type).getType();
    }

    public static Gson k() {
        Map<String, Gson> map = f11756d;
        Gson gson = map.get(f11754b);
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get(f11753a);
        if (gson2 != null) {
            return gson2;
        }
        Gson gsonA = a();
        map.put(f11753a, gsonA);
        return gsonA;
    }

    public static Gson l(String str) {
        return f11756d.get(str);
    }

    public static Gson m() {
        Map<String, Gson> map = f11756d;
        Gson gson = map.get(f11755c);
        if (gson != null) {
            return gson;
        }
        Gson gsonCreate = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put(f11755c, gsonCreate);
        return gsonCreate;
    }

    public static Type n(@g.n0 Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static Type o(@g.n0 Type type, @g.n0 Type type2) {
        Objects.requireNonNull(type, "Argument 'keyType' of type Type (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type2, "Argument 'valueType' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(Map.class, type, type2).getType();
    }

    public static Type p(@g.n0 Type type) {
        Objects.requireNonNull(type, "Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(Set.class, type).getType();
    }

    public static Type q(@g.n0 Type type, @g.n0 Type... typeArr) {
        Objects.requireNonNull(type, "Argument 'rawType' of type Type (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(typeArr, "Argument 'typeArguments' of type Type[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    public static void r(String str, Gson gson) {
        if (TextUtils.isEmpty(str) || gson == null) {
            return;
        }
        f11756d.put(str, gson);
    }

    public static void s(Gson gson) {
        if (gson == null) {
            return;
        }
        f11756d.put(f11754b, gson);
    }

    public static String t(@g.n0 Gson gson, Object obj) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return gson.toJson(obj);
    }

    public static String u(@g.n0 Gson gson, Object obj, @g.n0 Type type) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(type, "Argument 'typeOfSrc' of type Type (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return gson.toJson(obj, type);
    }

    public static String v(Object obj) {
        return t(k(), obj);
    }

    public static String w(Object obj, @g.n0 Type type) {
        Objects.requireNonNull(type, "Argument 'typeOfSrc' of type Type (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return u(k(), obj, type);
    }
}
