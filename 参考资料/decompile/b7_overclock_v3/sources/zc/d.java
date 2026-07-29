package zc;

import android.text.TextUtils;
import g.p0;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final int A = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f58342r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f58343s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f58344t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f58345u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f58346v = 3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f58347w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f58348x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f58349y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f58350z = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.l
    public int f58356f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f58358h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f58365o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f58351a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f58352b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f58353c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f58354d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public String f58355e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f58357g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f58359i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f58360j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f58361k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f58362l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f58363m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f58364n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f58366p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f58367q = false;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static int C(int i10, String str, @p0 String str2, int i11) {
        if (str.isEmpty() || i10 == -1) {
            return i10;
        }
        if (str.equals(str2)) {
            return i10 + i11;
        }
        return -1;
    }

    public void A(String str) {
        this.f58354d = str;
    }

    public d B(boolean z10) {
        this.f58361k = z10 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f58359i) {
            return this.f58358h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f58367q;
    }

    public int c() {
        if (this.f58357g) {
            return this.f58356f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @p0
    public String d() {
        return this.f58355e;
    }

    public float e() {
        return this.f58365o;
    }

    public int f() {
        return this.f58364n;
    }

    public int g() {
        return this.f58366p;
    }

    public int h(@p0 String str, @p0 String str2, Set<String> set, @p0 String str3) {
        if (this.f58351a.isEmpty() && this.f58352b.isEmpty() && this.f58353c.isEmpty() && this.f58354d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iC = C(C(C(0, this.f58351a, str, 1073741824), this.f58352b, str2, 2), this.f58354d, str3, 4);
        if (iC == -1 || !set.containsAll(this.f58353c)) {
            return 0;
        }
        return iC + (this.f58353c.size() * 4);
    }

    public int i() {
        int i10 = this.f58362l;
        if (i10 == -1 && this.f58363m == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f58363m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f58359i;
    }

    public boolean k() {
        return this.f58357g;
    }

    public boolean l() {
        return this.f58360j == 1;
    }

    public boolean m() {
        return this.f58361k == 1;
    }

    public d n(int i10) {
        this.f58358h = i10;
        this.f58359i = true;
        return this;
    }

    public d o(boolean z10) {
        this.f58362l = z10 ? 1 : 0;
        return this;
    }

    public d p(boolean z10) {
        this.f58367q = z10;
        return this;
    }

    public d q(int i10) {
        this.f58356f = i10;
        this.f58357g = true;
        return this;
    }

    public d r(@p0 String str) {
        this.f58355e = u0.w1(str);
        return this;
    }

    public d s(float f10) {
        this.f58365o = f10;
        return this;
    }

    public d t(short s10) {
        this.f58364n = s10;
        return this;
    }

    public d u(boolean z10) {
        this.f58363m = z10 ? 1 : 0;
        return this;
    }

    public d v(boolean z10) {
        this.f58360j = z10 ? 1 : 0;
        return this;
    }

    public d w(int i10) {
        this.f58366p = i10;
        return this;
    }

    public void x(String[] strArr) {
        this.f58353c = new HashSet(Arrays.asList(strArr));
    }

    public void y(String str) {
        this.f58351a = str;
    }

    public void z(String str) {
        this.f58352b = str;
    }
}
