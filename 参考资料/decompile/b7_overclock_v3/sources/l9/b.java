package l9;

import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final void a(@k byte[] value) {
        f0.p(value, "value");
        int length = value.length - 2;
        int i10 = 0;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                i10 += value[i11];
                if (i11 == length) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        value[value.length - 1] = (byte) (i10 & 255);
    }
}
