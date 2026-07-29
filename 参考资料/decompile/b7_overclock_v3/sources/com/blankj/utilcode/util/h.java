package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f11791a;

    public static JSONObject A(@g.n0 String str, JSONObject jSONObject, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.t(str, jSONObject);
    }

    public static <T> T B(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) C(str, creator, o());
    }

    public static <T> T C(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) iVar.u(str, creator);
    }

    public static <T> T D(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, T t10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) E(str, creator, t10, o());
    }

    public static <T> T E(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, T t10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) iVar.v(str, creator, t10);
    }

    public static Object F(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return G(str, o());
    }

    public static Object G(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.w(str);
    }

    public static Object H(@g.n0 String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return I(str, obj, o());
    }

    public static Object I(@g.n0 String str, Object obj, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.x(str, obj);
    }

    public static String J(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return K(str, o());
    }

    public static String K(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.y(str);
    }

    public static String L(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return M(str, str2, o());
    }

    public static String M(@g.n0 String str, String str2, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.z(str, str2);
    }

    public static void N(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Q(str, bitmap, o());
    }

    public static void O(@g.n0 String str, Bitmap bitmap, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        P(str, bitmap, i10, o());
    }

    public static void P(@g.n0 String str, Bitmap bitmap, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.B(str, bitmap, i10);
    }

    public static void Q(@g.n0 String str, Bitmap bitmap, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.A(str, bitmap);
    }

    public static void R(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        U(str, drawable, o());
    }

    public static void S(@g.n0 String str, Drawable drawable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T(str, drawable, i10, o());
    }

    public static void T(@g.n0 String str, Drawable drawable, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.D(str, drawable, i10);
    }

    public static void U(@g.n0 String str, Drawable drawable, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.C(str, drawable);
    }

    public static void V(@g.n0 String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Y(str, parcelable, o());
    }

    public static void W(@g.n0 String str, Parcelable parcelable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        X(str, parcelable, i10, o());
    }

    public static void X(@g.n0 String str, Parcelable parcelable, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.F(str, parcelable, i10);
    }

    public static void Y(@g.n0 String str, Parcelable parcelable, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.E(str, parcelable);
    }

    public static void Z(@g.n0 String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        c0(str, serializable, o());
    }

    public static boolean a() {
        return b(o());
    }

    public static void a0(@g.n0 String str, Serializable serializable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        b0(str, serializable, i10, o());
    }

    public static boolean b(@g.n0 i iVar) {
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.a();
    }

    public static void b0(@g.n0 String str, Serializable serializable, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.H(str, serializable, i10);
    }

    public static Bitmap c(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return f(str, o());
    }

    public static void c0(@g.n0 String str, Serializable serializable, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.G(str, serializable);
    }

    public static Bitmap d(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return e(str, bitmap, o());
    }

    public static void d0(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        g0(str, str2, o());
    }

    public static Bitmap e(@g.n0 String str, Bitmap bitmap, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.c(str, bitmap);
    }

    public static void e0(@g.n0 String str, String str2, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f0(str, str2, i10, o());
    }

    public static Bitmap f(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.b(str);
    }

    public static void f0(@g.n0 String str, String str2, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.J(str, str2, i10);
    }

    public static byte[] g(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(str, o());
    }

    public static void g0(@g.n0 String str, String str2, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.I(str, str2);
    }

    public static byte[] h(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.d(str);
    }

    public static void h0(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        k0(str, jSONArray, o());
    }

    public static byte[] i(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return j(str, bArr, o());
    }

    public static void i0(@g.n0 String str, JSONArray jSONArray, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j0(str, jSONArray, i10, o());
    }

    public static byte[] j(@g.n0 String str, byte[] bArr, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.e(str, bArr);
    }

    public static void j0(@g.n0 String str, JSONArray jSONArray, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.L(str, jSONArray, i10);
    }

    public static int k() {
        return l(o());
    }

    public static void k0(@g.n0 String str, JSONArray jSONArray, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.K(str, jSONArray);
    }

    public static int l(@g.n0 i iVar) {
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.f();
    }

    public static void l0(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        o0(str, jSONObject, o());
    }

    public static long m() {
        return n(o());
    }

    public static void m0(@g.n0 String str, JSONObject jSONObject, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(str, jSONObject, i10, o());
    }

    public static long n(@g.n0 i iVar) {
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.g();
    }

    public static void n0(@g.n0 String str, JSONObject jSONObject, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.N(str, jSONObject, i10);
    }

    public static i o() {
        i iVar = f11791a;
        return iVar != null ? iVar : i.k();
    }

    public static void o0(@g.n0 String str, JSONObject jSONObject, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.M(str, jSONObject);
    }

    public static Drawable p(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return s(str, o());
    }

    public static void p0(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s0(str, bArr, o());
    }

    public static Drawable q(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return r(str, drawable, o());
    }

    public static void q0(@g.n0 String str, byte[] bArr, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        r0(str, bArr, i10, o());
    }

    public static Drawable r(@g.n0 String str, Drawable drawable, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.j(str, drawable);
    }

    public static void r0(@g.n0 String str, byte[] bArr, int i10, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.P(str, bArr, i10);
    }

    public static Drawable s(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.i(str);
    }

    public static void s0(@g.n0 String str, byte[] bArr, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        iVar.O(str, bArr);
    }

    public static JSONArray t(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return u(str, o());
    }

    public static boolean t0(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return u0(str, o());
    }

    public static JSONArray u(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.q(str);
    }

    public static boolean u0(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.T(str);
    }

    public static JSONArray v(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w(str, jSONArray, o());
    }

    public static void v0(i iVar) {
        f11791a = iVar;
    }

    public static JSONArray w(@g.n0 String str, JSONArray jSONArray, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.r(str, jSONArray);
    }

    public static JSONObject x(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return y(str, o());
    }

    public static JSONObject y(@g.n0 String str, @g.n0 i iVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return iVar.s(str);
    }

    public static JSONObject z(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return A(str, jSONObject, o());
    }
}
