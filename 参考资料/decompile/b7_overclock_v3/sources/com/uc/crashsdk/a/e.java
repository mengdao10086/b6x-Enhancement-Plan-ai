package com.uc.crashsdk.a;

import v7.a;

/* JADX INFO: loaded from: classes5.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f22949a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f22951c;

    public e(int i10) {
        this.f22950b = i10;
        this.f22951c = null;
    }

    public final boolean a() {
        int i10 = this.f22950b;
        if (i10 == 451 || i10 == 452) {
            return com.uc.crashsdk.e.b(i10, this.f22951c);
        }
        switch (i10) {
            case 351:
            case 352:
            case 353:
            case 354:
                return h.b(i10, this.f22951c);
            default:
                switch (i10) {
                    case 751:
                    case 752:
                    case 753:
                    case com.android.motionelf.tools.a.f11372p /* 754 */:
                    case 755:
                    case 756:
                        return com.uc.crashsdk.f.a(i10, this.f22951c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (f22949a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10 = this.f22950b;
        if (i10 == 10) {
            f.a(i10, this.f22951c);
            return;
        }
        if (i10 == 500) {
            d.a(i10);
            return;
        }
        if (i10 == 700) {
            com.uc.crashsdk.f.b(i10);
            return;
        }
        if (i10 == 800) {
            g.a(i10);
            return;
        }
        if (i10 == 201 || i10 == 202) {
            com.uc.crashsdk.a.a(i10);
            return;
        }
        switch (i10) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                com.uc.crashsdk.b.a(i10);
                return;
            default:
                switch (i10) {
                    case 301:
                    case 302:
                    case 303:
                        h.a(i10, this.f22951c);
                        return;
                    default:
                        switch (i10) {
                            case 401:
                            case 402:
                            case 403:
                                break;
                            default:
                                switch (i10) {
                                    case a.c.D /* 405 */:
                                    case 406:
                                    case a.c.F /* 407 */:
                                    case 408:
                                    case 409:
                                    case 410:
                                    case 411:
                                    case 412:
                                    case 413:
                                    case 414:
                                    case 415:
                                    case 416:
                                        break;
                                    default:
                                        a.d("crashsdk", "Unknown async runnable: " + toString());
                                        if (!f22949a) {
                                            throw new AssertionError();
                                        }
                                        return;
                                }
                                break;
                        }
                        com.uc.crashsdk.e.a(i10, this.f22951c);
                        return;
                }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.f22950b;
    }

    public e(int i10, Object[] objArr) {
        this.f22950b = i10;
        this.f22951c = objArr;
    }
}
