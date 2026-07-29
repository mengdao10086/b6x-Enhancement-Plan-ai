package ft;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class b0 {
    public static int a(SecureRandom secureRandom, int i10) {
        int iNextInt;
        int i11;
        if (((-i10) & i10) == i10) {
            return (int) ((((long) i10) * ((long) (secureRandom.nextInt() >>> 1))) >> 31);
        }
        do {
            iNextInt = secureRandom.nextInt() >>> 1;
            i11 = iNextInt % i10;
        } while ((iNextInt - i11) + (i10 - 1) < 0);
        return i11;
    }
}
