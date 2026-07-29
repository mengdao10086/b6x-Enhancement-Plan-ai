package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.blankj.utilcode.util.a1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.l0;
import com.google.gson.Gson;
import f0.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l1 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LinkedHashMap<String, String> f11928b = new LinkedHashMap<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LinkedHashMap<String, String> f11929c = new LinkedHashMap<>();

        public a(String str) {
            this.f11927a = str;
        }

        public void a(String str, String str2) {
            d(this.f11928b, str, str2);
        }

        public void b(String str, String str2) {
            d(this.f11929c, str, str2);
        }

        public void c(Map<String, String> map) {
            e(this.f11929c, map);
        }

        public final void d(Map<String, String> map, String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            int length = 19 - str.length();
            if (length > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        public final void e(Map<String, String> map, Map<String, String> map2) {
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                d(map, entry.getKey(), entry.getValue());
            }
        }

        public String f() {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : this.f11929c.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append(": ");
                sb2.append(entry.getValue());
                sb2.append("\n");
            }
            return sb2.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = "************* " + this.f11927a + " Head ****************\n";
            sb2.append(str);
            for (Map.Entry<String, String> entry : this.f11928b.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append(": ");
                sb2.append(entry.getValue());
                sb2.append("\n");
            }
            sb2.append("Rom Info           : ");
            sb2.append(t0.c());
            sb2.append("\n");
            sb2.append("Device Manufacturer: ");
            sb2.append(Build.MANUFACTURER);
            sb2.append("\n");
            sb2.append("Device Model       : ");
            sb2.append(Build.MODEL);
            sb2.append("\n");
            sb2.append("Android Version    : ");
            sb2.append(Build.VERSION.RELEASE);
            sb2.append("\n");
            sb2.append("Android SDK        : ");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append("\n");
            sb2.append("App VersionName    : ");
            sb2.append(d.C());
            sb2.append("\n");
            sb2.append("App VersionCode    : ");
            sb2.append(d.A());
            sb2.append("\n");
            sb2.append(f());
            sb2.append(str);
            sb2.append("\n");
            return sb2.toString();
        }
    }

    public static boolean A(CharSequence charSequence, CharSequence charSequence2) {
        return d1.a(charSequence, charSequence2);
    }

    public static boolean A0() {
        return t0.x();
    }

    public static a1.b B(String str, boolean z10) {
        return a1.a(str, z10);
    }

    public static boolean B0(String str) {
        return y0.f(str);
    }

    public static Uri C(File file) {
        return i1.b(file);
    }

    public static boolean C0(String str) {
        return d1.h(str);
    }

    public static void D() {
        com.blankj.utilcode.util.a.i();
    }

    public static boolean D0(@g.n0 View view, long j10) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w.c(view, j10);
    }

    public static void E(Activity activity) {
        KeyboardUtils.f(activity);
    }

    public static byte[] E0(JSONArray jSONArray) {
        return u.K(jSONArray);
    }

    public static String F(String str, Object... objArr) {
        return d1.c(str, objArr);
    }

    public static byte[] F0(JSONObject jSONObject) {
        return u.L(jSONObject);
    }

    public static String G(String str) {
        return g0.a(str);
    }

    public static View G0(@g.i0 int i10) {
        return n1.c(i10);
    }

    public static <T> T H(String str, Type type) {
        return (T) e0.i(str, type);
    }

    public static String H0(long j10, int i10) {
        return f1.O0(j10, i10);
    }

    public static Activity I(Context context) {
        return com.blankj.utilcode.util.a.x(context);
    }

    public static void I0(File file) {
        b0.J0(file);
    }

    public static List<Activity> J() {
        return k1.f11899g.k();
    }

    public static byte[] J0(Parcelable parcelable) {
        return u.S(parcelable);
    }

    public static int K() {
        return x0.b();
    }

    public static void K0() {
        L0(b.k());
    }

    public static Application L() {
        return k1.f11899g.o();
    }

    public static void L0(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.d0().execute(runnable);
        }
    }

    @g.y0("android.permission.CALL_PHONE")
    public static Intent M(String str) {
        return f0.a(str);
    }

    public static int M0(float f10) {
        return b1.g(f10);
    }

    public static String N() {
        return q0.b();
    }

    public static int N0(float f10) {
        return b1.h(f10);
    }

    public static Intent O(String str) {
        return f0.h(str);
    }

    public static byte[] O0(File file) {
        return a0.a(file);
    }

    public static File P(String str) {
        return b0.C(str);
    }

    public static void P0() {
        d.Y();
    }

    public static String Q() {
        return q0.f();
    }

    public static void Q0(Activity activity) {
        k1.f11899g.u(activity);
    }

    public static long R(String str) {
        return b0.W(str);
    }

    public static void R0(Activity activity, j1.a aVar) {
        k1.f11899g.v(activity, aVar);
    }

    public static long S(String str) {
        return b0.X(str);
    }

    public static void S0(j1.a aVar) {
        k1.f11899g.w(aVar);
    }

    public static String T(Throwable th2) {
        return e1.a(th2);
    }

    public static void T0(j1.d dVar) {
        k1.f11899g.y(dVar);
    }

    public static Gson U() {
        return e0.m();
    }

    public static void U0(Runnable runnable) {
        ThreadUtils.s0(runnable);
    }

    public static Intent V(Uri uri) {
        return f0.i(uri);
    }

    public static void V0(Runnable runnable, long j10) {
        ThreadUtils.t0(runnable, j10);
    }

    public static Intent W(File file) {
        return f0.j(file);
    }

    public static byte[] W0(Serializable serializable) {
        return u.V(serializable);
    }

    public static Intent X(String str, boolean z10) {
        return f0.n(str, z10);
    }

    public static int X0(float f10) {
        return b1.i(f10);
    }

    public static Intent Y(String str) {
        return f0.o(str);
    }

    public static void Y0() {
        com.blankj.utilcode.util.a.C1();
    }

    public static String Z(String str) {
        return com.blankj.utilcode.util.a.I(str);
    }

    public static byte[] Z0(String str) {
        return u.X(str);
    }

    public static void a(Activity activity, j1.a aVar) {
        k1.f11899g.d(activity, aVar);
    }

    public static int a0() {
        return f.i();
    }

    public static String a1(Object obj) {
        return e0.v(obj);
    }

    public static void b(j1.a aVar) {
        k1.f11899g.e(aVar);
    }

    public static Notification b0(l0.a aVar, j1.b<v.n> bVar) {
        return l0.e(aVar, bVar);
    }

    public static void b1() {
        ToastUtils.l();
    }

    public static void c(j1.d dVar) {
        k1.f11899g.g(dVar);
    }

    public static Intent c0(String str, String str2) {
        return f0.p(str, str2);
    }

    public static void c1(CharSequence charSequence) {
        ToastUtils.V(charSequence);
    }

    public static byte[] d(byte[] bArr) {
        return y.b(bArr);
    }

    public static w0 d0() {
        return w0.k("Utils");
    }

    public static void d1(Application application) {
        k1.f11899g.B(application);
    }

    public static byte[] e(byte[] bArr) {
        return y.d(bArr);
    }

    public static int e0() {
        return f.k();
    }

    public static File e1(Uri uri) {
        return i1.g(uri);
    }

    public static byte[] f(Bitmap bitmap) {
        return ImageUtils.o(bitmap);
    }

    public static String f0(@g.c1 int i10) {
        return d1.d(i10);
    }

    public static Bitmap f1(View view) {
        return ImageUtils.e1(view);
    }

    public static byte[] g(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10) {
        return ImageUtils.p(bitmap, compressFormat, i10);
    }

    public static String g0(@g.c1 int i10, Object... objArr) {
        return d1.e(i10, objArr);
    }

    public static boolean g1(File file, byte[] bArr) {
        return a0.v(file, bArr, true);
    }

    public static Drawable h(Bitmap bitmap) {
        return ImageUtils.q(bitmap);
    }

    public static Activity h0() {
        return k1.f11899g.p();
    }

    public static boolean h1(String str, InputStream inputStream) {
        return a0.P(str, inputStream);
    }

    public static String i(long j10) {
        return u.e(j10);
    }

    public static Intent i0(String str) {
        return f0.E(str);
    }

    public static boolean i1(String str, String str2, boolean z10) {
        return a0.W(str, str2, z10);
    }

    public static Bitmap j(byte[] bArr) {
        return ImageUtils.r(bArr);
    }

    public static byte[] j0(byte[] bArr, String str) {
        return z.r0(bArr, str);
    }

    public static Drawable k(byte[] bArr) {
        return ImageUtils.s(bArr);
    }

    public static byte[] k0(String str) {
        return u.C(str);
    }

    public static String l(byte[] bArr) {
        return u.l(bArr);
    }

    public static void l0(Application application) {
        k1.f11899g.q(application);
    }

    public static JSONArray m(byte[] bArr) {
        return u.o(bArr);
    }

    public static ByteArrayOutputStream m0(InputStream inputStream) {
        return u.E(inputStream);
    }

    public static JSONObject n(byte[] bArr) {
        return u.p(bArr);
    }

    public static byte[] n0(InputStream inputStream) {
        return u.F(inputStream);
    }

    public static Object o(byte[] bArr) {
        return u.q(bArr);
    }

    public static List<String> o0(InputStream inputStream, String str) {
        return u.H(inputStream, str);
    }

    public static <T> T p(byte[] bArr, Parcelable.Creator<T> creator) {
        return (T) u.s(bArr, creator);
    }

    public static boolean p0(Activity activity) {
        return com.blankj.utilcode.util.a.R(activity);
    }

    public static String q(byte[] bArr) {
        return u.t(bArr);
    }

    public static boolean q0() {
        return d.J();
    }

    public static boolean r(File file) {
        return b0.i(file);
    }

    public static boolean r0() {
        return k1.f11899g.r();
    }

    public static boolean s(File file) {
        return b0.k(file);
    }

    public static boolean s0(String str) {
        return d.N(str);
    }

    public static boolean t(File file) {
        return b0.m(file);
    }

    public static boolean t0(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return d.P(str);
    }

    public static boolean u(File file) {
        return b0.q(file);
    }

    public static boolean u0(File file) {
        return b0.g0(file);
    }

    public static <T> j1.f<T> v(j1.f<T> fVar) {
        ThreadUtils.d0().execute(fVar);
        return fVar;
    }

    public static boolean v0(String... strArr) {
        return PermissionUtils.z(strArr);
    }

    public static int w(float f10) {
        return b1.b(f10);
    }

    @g.v0(api = 23)
    public static boolean w0() {
        return PermissionUtils.A();
    }

    public static Bitmap x(Drawable drawable) {
        return ImageUtils.K(drawable);
    }

    public static boolean x0(Intent intent) {
        return f0.F(intent);
    }

    public static byte[] y(Drawable drawable) {
        return ImageUtils.L(drawable);
    }

    public static boolean y0() {
        return q0.g();
    }

    public static byte[] z(Drawable drawable, Bitmap.CompressFormat compressFormat, int i10) {
        return ImageUtils.M(drawable, compressFormat, i10);
    }

    public static boolean z0() {
        return u0.h();
    }
}
