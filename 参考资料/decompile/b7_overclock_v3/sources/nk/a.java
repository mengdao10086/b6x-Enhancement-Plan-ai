package nk;

import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f42205a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public static final double f42206b = Math.log(2.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public static final double f42207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    public static final double f42208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    public static final double f42209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    public static final double f42210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    public static final double f42211g;

    static {
        double dUlp = Math.ulp(1.0d);
        f42207c = dUlp;
        double dSqrt = Math.sqrt(dUlp);
        f42208d = dSqrt;
        double dSqrt2 = Math.sqrt(dSqrt);
        f42209e = dSqrt2;
        double d10 = 1;
        f42210f = d10 / dSqrt;
        f42211g = d10 / dSqrt2;
    }
}
