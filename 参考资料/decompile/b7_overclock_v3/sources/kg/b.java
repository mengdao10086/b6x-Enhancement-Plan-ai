package kg;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f37344a = 5;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {
        public static final byte V3 = 0;
        public static final byte W3 = 1;
        public static final byte X3 = 2;
        public static final byte Y3 = 3;
        public static final byte Z3 = 4;
    }

    public static String a(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "Initialisation" : "Upgrade commit" : "Upgrade in progress" : "Data transfer complete" : "Data validation" : "Data transfer";
    }

    public static int b() {
        return 5;
    }

    public static int c(byte b10) {
        int i10 = 1;
        if (b10 != 1) {
            i10 = 2;
            if (b10 != 2) {
                i10 = 3;
                if (b10 != 3) {
                    i10 = 4;
                    if (b10 != 4) {
                        return 0;
                    }
                }
            }
        }
        return i10;
    }
}
