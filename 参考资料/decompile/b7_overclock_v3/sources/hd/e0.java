package hd;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30981a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30982b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30983c = 2;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static int a(int i10, int i11) {
        for (int i12 = 1; i12 <= 2; i12++) {
            int i13 = (i10 + i12) % 3;
            if (b(i13, i11)) {
                return i13;
            }
        }
        return i10;
    }

    public static boolean b(int i10, int i11) {
        if (i10 != 0) {
            return i10 != 1 ? i10 == 2 && (i11 & 2) != 0 : (i11 & 1) != 0;
        }
        return true;
    }
}
