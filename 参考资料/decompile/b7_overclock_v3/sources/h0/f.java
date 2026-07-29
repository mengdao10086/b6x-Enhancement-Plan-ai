package h0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.os.a;
import g.r0;
import g.v0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f30112a = "android.intent.action.CREATE_REMINDER";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30113b = "android.intent.extra.HTML_TEXT";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30114c = "android.intent.extra.START_PLAYBACK";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f30115d = "android.intent.extra.TIME";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f30116e = "android.intent.category.LEANBACK_LAUNCHER";

    @v0(15)
    public static class a {
        @g.u
        public static Intent a(String str, String str2) {
            return Intent.makeMainSelectorActivity(str, str2);
        }
    }

    @v0(33)
    public static class b {
        @g.u
        public static <T> T[] a(@g.n0 Intent intent, @g.p0 String str, @g.n0 Class<T> cls) {
            return (T[]) intent.getParcelableArrayExtra(str, cls);
        }

        @g.u
        public static <T> ArrayList<T> b(@g.n0 Intent intent, @g.p0 String str, @g.n0 Class<? extends T> cls) {
            return intent.getParcelableArrayListExtra(str, cls);
        }

        @g.u
        public static <T> T c(@g.n0 Intent intent, @g.p0 String str, @g.n0 Class<T> cls) {
            return (T) intent.getParcelableExtra(str, cls);
        }
    }

    @g.n0
    public static Intent a(@g.n0 Context context, @g.n0 String str) {
        if (!h0.a(context.getPackageManager())) {
            throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", str, null));
        }
        Intent data = new Intent(h0.f30121b).setData(Uri.fromParts("package", str, null));
        return i10 >= 30 ? data : data.setPackage((String) androidx.core.util.o.l(h0.b(context.getPackageManager())));
    }

    @g.p0
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static Parcelable[] b(@g.n0 Intent intent, @g.p0 String str, @g.n0 Class<? extends Parcelable> cls) {
        return androidx.core.os.a.l() ? (Parcelable[]) b.a(intent, str, cls) : intent.getParcelableArrayExtra(str);
    }

    @g.p0
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static <T> ArrayList<T> c(@g.n0 Intent intent, @g.p0 String str, @g.n0 Class<? extends T> cls) {
        return androidx.core.os.a.l() ? b.b(intent, str, cls) : intent.getParcelableArrayListExtra(str);
    }

    @g.p0
    @r0(markerClass = {a.b.class})
    public static <T> T d(@g.n0 Intent intent, @g.p0 String str, @g.n0 Class<T> cls) {
        if (androidx.core.os.a.l()) {
            return (T) b.c(intent, str, cls);
        }
        T t10 = (T) intent.getParcelableExtra(str);
        if (cls.isInstance(t10)) {
            return t10;
        }
        return null;
    }

    @g.n0
    public static Intent e(@g.n0 String str, @g.n0 String str2) {
        return a.a(str, str2);
    }
}
