package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42566f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42567g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f42569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f42570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SecureRandom f42572e;

    public y(int i10, int i11, int i12, SecureRandom secureRandom) {
        this(i10, i11, i12, secureRandom, -1);
    }

    public y(int i10, int i11, int i12, SecureRandom secureRandom, int i13) {
        this.f42568a = i10;
        this.f42569b = i11;
        this.f42571d = i12;
        this.f42570c = i13;
        this.f42572e = secureRandom;
    }

    public int a() {
        return this.f42571d;
    }

    public int b() {
        return this.f42568a;
    }

    public int c() {
        return this.f42569b;
    }

    public SecureRandom d() {
        return this.f42572e;
    }

    public int e() {
        return this.f42570c;
    }
}
