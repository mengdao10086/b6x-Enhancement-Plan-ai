package com.umeng.analytics.pro;

/* JADX INFO: loaded from: classes5.dex */
public class av extends bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23328a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23329b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f23330c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f23331d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f23332e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f23333f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f23334g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f23335h = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ca f23336j = new ca("TApplicationException");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final bq f23337k = new bq("message", (byte) 11, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final bq f23338l = new bq("type", (byte) 8, 2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f23339m = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23340i;

    public av() {
        this.f23340i = 0;
    }

    public int a() {
        return this.f23340i;
    }

    public void b(bv bvVar) throws bc {
        bvVar.a(f23336j);
        if (getMessage() != null) {
            bvVar.a(f23337k);
            bvVar.a(getMessage());
            bvVar.c();
        }
        bvVar.a(f23338l);
        bvVar.a(this.f23340i);
        bvVar.c();
        bvVar.d();
        bvVar.b();
    }

    public static av a(bv bvVar) throws bc {
        bvVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bq bqVarL = bvVar.l();
            byte b10 = bqVarL.f23422b;
            if (b10 == 0) {
                bvVar.k();
                return new av(iW, strZ);
            }
            short s10 = bqVarL.f23423c;
            if (s10 != 1) {
                if (s10 != 2) {
                    by.a(bvVar, b10);
                } else if (b10 == 8) {
                    iW = bvVar.w();
                } else {
                    by.a(bvVar, b10);
                }
            } else if (b10 == 11) {
                strZ = bvVar.z();
            } else {
                by.a(bvVar, b10);
            }
            bvVar.m();
        }
    }

    public av(int i10) {
        this.f23340i = i10;
    }

    public av(int i10, String str) {
        super(str);
        this.f23340i = i10;
    }

    public av(String str) {
        super(str);
        this.f23340i = 0;
    }
}
