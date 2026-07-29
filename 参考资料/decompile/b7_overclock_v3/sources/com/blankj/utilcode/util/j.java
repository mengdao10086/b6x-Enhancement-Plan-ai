package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f11891a;

    public static JSONObject A(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.o(str);
    }

    public static JSONObject B(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return C(str, jSONObject, q());
    }

    public static JSONObject C(@g.n0 String str, JSONObject jSONObject, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.p(str, jSONObject);
    }

    public static <T> T D(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) E(str, creator, q());
    }

    public static <T> T E(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) kVar.q(str, creator);
    }

    public static <T> T F(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, T t10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) G(str, creator, t10, q());
    }

    public static <T> T G(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, T t10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) kVar.r(str, creator, t10);
    }

    public static Object H(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return I(str, q());
    }

    public static Object I(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.s(str);
    }

    public static Object J(@g.n0 String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return K(str, obj, q());
    }

    public static Object K(@g.n0 String str, Object obj, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.t(str, obj);
    }

    public static String L(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return M(str, q());
    }

    public static String M(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.u(str);
    }

    public static String N(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return O(str, str2, q());
    }

    public static String O(@g.n0 String str, String str2, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.v(str, str2);
    }

    public static void P(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(str, bitmap, q());
    }

    public static void Q(@g.n0 String str, Bitmap bitmap, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        R(str, bitmap, i10, q());
    }

    public static void R(@g.n0 String str, Bitmap bitmap, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.x(str, bitmap, i10);
    }

    public static void S(@g.n0 String str, Bitmap bitmap, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.w(str, bitmap);
    }

    public static void T(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        W(str, drawable, q());
    }

    public static void U(@g.n0 String str, Drawable drawable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        V(str, drawable, i10, q());
    }

    public static void V(@g.n0 String str, Drawable drawable, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.z(str, drawable, i10);
    }

    public static void W(@g.n0 String str, Drawable drawable, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.y(str, drawable);
    }

    public static void X(@g.n0 String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a0(str, parcelable, q());
    }

    public static void Y(@g.n0 String str, Parcelable parcelable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Z(str, parcelable, i10, q());
    }

    public static void Z(@g.n0 String str, Parcelable parcelable, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.B(str, parcelable, i10);
    }

    public static void a() {
        b(q());
    }

    public static void a0(@g.n0 String str, Parcelable parcelable, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.A(str, parcelable);
    }

    public static void b(@g.n0 k kVar) {
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.a();
    }

    public static void b0(@g.n0 String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        e0(str, serializable, q());
    }

    public static Bitmap c(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return f(str, q());
    }

    public static void c0(@g.n0 String str, Serializable serializable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        d0(str, serializable, i10, q());
    }

    public static Bitmap d(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return e(str, bitmap, q());
    }

    public static void d0(@g.n0 String str, Serializable serializable, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.D(str, serializable, i10);
    }

    public static Bitmap e(@g.n0 String str, Bitmap bitmap, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.c(str, bitmap);
    }

    public static void e0(@g.n0 String str, Serializable serializable, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.C(str, serializable);
    }

    public static Bitmap f(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.b(str);
    }

    public static void f0(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i0(str, str2, q());
    }

    public static byte[] g(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(str, q());
    }

    public static void g0(@g.n0 String str, String str2, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h0(str, str2, i10, q());
    }

    public static byte[] h(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.d(str);
    }

    public static void h0(@g.n0 String str, String str2, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.F(str, str2, i10);
    }

    public static byte[] i(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return j(str, bArr, q());
    }

    public static void i0(@g.n0 String str, String str2, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.E(str, str2);
    }

    public static byte[] j(@g.n0 String str, byte[] bArr, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.e(str, bArr);
    }

    public static void j0(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        m0(str, jSONArray, q());
    }

    public static int k() {
        return l(q());
    }

    public static void k0(@g.n0 String str, JSONArray jSONArray, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l0(str, jSONArray, i10, q());
    }

    public static int l(@g.n0 k kVar) {
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.f();
    }

    public static void l0(@g.n0 String str, JSONArray jSONArray, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.H(str, jSONArray, i10);
    }

    public static long m() {
        return n(q());
    }

    public static void m0(@g.n0 String str, JSONArray jSONArray, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.G(str, jSONArray);
    }

    public static long n(@g.n0 k kVar) {
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.g();
    }

    public static void n0(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        q0(str, jSONObject, q());
    }

    public static int o() {
        return p(q());
    }

    public static void o0(@g.n0 String str, JSONObject jSONObject, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        p0(str, jSONObject, i10, q());
    }

    public static int p(@g.n0 k kVar) {
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.h();
    }

    public static void p0(@g.n0 String str, JSONObject jSONObject, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.J(str, jSONObject, i10);
    }

    public static k q() {
        k kVar = f11891a;
        return kVar != null ? kVar : k.k();
    }

    public static void q0(@g.n0 String str, JSONObject jSONObject, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.I(str, jSONObject);
    }

    public static Drawable r(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return u(str, q());
    }

    public static void r0(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        u0(str, bArr, q());
    }

    public static Drawable s(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(str, drawable, q());
    }

    public static void s0(@g.n0 String str, byte[] bArr, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        t0(str, bArr, i10, q());
    }

    public static Drawable t(@g.n0 String str, Drawable drawable, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.j(str, drawable);
    }

    public static void t0(@g.n0 String str, byte[] bArr, int i10, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.L(str, bArr, i10);
    }

    public static Drawable u(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.i(str);
    }

    public static void u0(@g.n0 String str, byte[] bArr, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.K(str, bArr);
    }

    public static JSONArray v(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w(str, q());
    }

    public static void v0(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0(str, q());
    }

    public static JSONArray w(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.m(str);
    }

    public static void w0(@g.n0 String str, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        kVar.M(str);
    }

    public static JSONArray x(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return y(str, jSONArray, q());
    }

    public static void x0(k kVar) {
        f11891a = kVar;
    }

    public static JSONArray y(@g.n0 String str, JSONArray jSONArray, @g.n0 k kVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(kVar, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return kVar.n(str, jSONArray);
    }

    public static JSONObject z(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return A(str, q());
    }
}
