package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4877a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4878b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4879c = 10;

    @g.v0(16)
    public static class a {
        @g.u
        public static void a(@g.n0 Window window, boolean z10) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    @g.v0(28)
    public static class b {
        @g.u
        public static <T> T a(Window window, int i10) {
            return (T) window.requireViewById(i10);
        }
    }

    @g.v0(30)
    public static class c {
        @g.u
        public static void a(@g.n0 Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    @g.n0
    public static l1 a(@g.n0 Window window, @g.n0 View view) {
        return new l1(window, view);
    }

    @g.n0
    public static <T extends View> T b(@g.n0 Window window, @g.d0 int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) b.a(window, i10);
        }
        T t10 = (T) window.findViewById(i10);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void c(@g.n0 Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(window, z10);
        } else {
            a.a(window, z10);
        }
    }
}
