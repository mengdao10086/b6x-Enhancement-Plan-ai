package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import g.n0;
import g.v0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.k(extension = 30)
    @SuppressLint({"CompileTimeConstant"})
    public static final int f4639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.k(extension = 31)
    @SuppressLint({"CompileTimeConstant"})
    public static final int f4640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.k(extension = 33)
    @SuppressLint({"CompileTimeConstant"})
    public static final int f4641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.k(extension = 1000000)
    @SuppressLint({"CompileTimeConstant"})
    public static final int f4642d;

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    @v0(30)
    public static final class C0040a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f4643a = SdkExtensions.getExtensionVersion(30);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4644b = SdkExtensions.getExtensionVersion(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4645c = SdkExtensions.getExtensionVersion(33);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4646d = SdkExtensions.getExtensionVersion(1000000);
    }

    @RequiresOptIn
    public @interface b {
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f4639a = i10 >= 30 ? C0040a.f4643a : 0;
        f4640b = i10 >= 30 ? C0040a.f4644b : 0;
        f4641c = i10 >= 30 ? C0040a.f4645c : 0;
        f4642d = i10 >= 30 ? C0040a.f4646d : 0;
    }

    @g.k(api = 24)
    @Deprecated
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @g.k(api = 25)
    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @g.k(api = 26)
    @Deprecated
    public static boolean c() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @g.k(api = 27)
    @Deprecated
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @g.k(api = 28)
    @Deprecated
    public static boolean e() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static boolean f(@n0 String str, @n0 String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0;
    }

    @g.k(api = 29)
    @Deprecated
    public static boolean g() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @g.k(api = 30)
    @Deprecated
    public static boolean h() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @g.k(api = 31, codename = i1.a.R4)
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    public static boolean i() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 31 || (i10 >= 30 && f(i1.a.R4, Build.VERSION.CODENAME));
    }

    @b
    @g.k(api = 32, codename = "Sv2")
    @Deprecated
    public static boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 32 || (i10 >= 31 && f("Sv2", Build.VERSION.CODENAME));
    }

    @b
    @g.k(api = 33, codename = "Tiramisu")
    public static boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 33 || (i10 >= 32 && f("Tiramisu", Build.VERSION.CODENAME));
    }

    @b
    @g.k(codename = "UpsideDownCake")
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 33 && f("UpsideDownCake", Build.VERSION.CODENAME);
    }
}
