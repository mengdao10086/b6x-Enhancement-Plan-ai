package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6935c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6936d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6937e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6938f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6939g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6940h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6941i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6942j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6943k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6944l = 32;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6945m = 64;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6946n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6947o = 256;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6948p = 512;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6949q = 1024;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6950r = 12;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6951s = 4096;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f6952t = 8192;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f6953u = 16384;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6954v = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6956b = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6957a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6961e;

        public void a(int i10) {
            this.f6957a = i10 | this.f6957a;
        }

        public boolean b() {
            int i10 = this.f6957a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f6960d, this.f6958b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f6957a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f6960d, this.f6959c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f6957a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f6961e, this.f6958b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f6957a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f6961e, this.f6959c) << 12)) != 0;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void d() {
            this.f6957a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f6958b = i10;
            this.f6959c = i11;
            this.f6960d = i12;
            this.f6961e = i13;
        }
    }

    public interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public g0(b bVar) {
        this.f6955a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int iC = this.f6955a.c();
        int iD = this.f6955a.d();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View viewA = this.f6955a.a(i10);
            this.f6956b.e(iC, iD, this.f6955a.b(viewA), this.f6955a.e(viewA));
            if (i12 != 0) {
                this.f6956b.d();
                this.f6956b.a(i12);
                if (this.f6956b.b()) {
                    return viewA;
                }
            }
            if (i13 != 0) {
                this.f6956b.d();
                this.f6956b.a(i13);
                if (this.f6956b.b()) {
                    view = viewA;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean b(View view, int i10) {
        this.f6956b.e(this.f6955a.c(), this.f6955a.d(), this.f6955a.b(view), this.f6955a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f6956b.d();
        this.f6956b.a(i10);
        return this.f6956b.b();
    }
}
