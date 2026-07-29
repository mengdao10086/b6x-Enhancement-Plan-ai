package ns;

import kotlin.v1;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42674a = 12287;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42675b = 18;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42676c = 262143;

    public static short a(short s10) {
        int i10 = s10 & v1.f38215d;
        return (short) (i10 - (((i10 * 5) >>> 16) * l.f42666c));
    }

    public static short b(int i10) {
        return (short) (((((i10 * f42674a) & f42676c) * l.f42666c) + i10) >>> 18);
    }
}
