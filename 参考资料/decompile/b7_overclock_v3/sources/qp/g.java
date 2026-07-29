package qp;

import java.util.Hashtable;
import org.bouncycastle.crypto.a0;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.j;
import rs.h;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f47594a;

    static {
        Hashtable hashtable = new Hashtable();
        f47594a = hashtable;
        hashtable.put(et.e.f27137f, j.g(128));
        hashtable.put(et.e.f27138g, j.g(192));
        hashtable.put("SHA-256", j.g(256));
        hashtable.put(et.e.f27140i, j.g(256));
        hashtable.put("SHA-512", j.g(256));
        hashtable.put("SHA-512/224", j.g(192));
        hashtable.put(h.f49168c, j.g(256));
    }

    public static int a(s sVar) {
        return ((Integer) f47594a.get(sVar.b())).intValue();
    }

    public static int b(a0 a0Var) {
        String strB = a0Var.b();
        return ((Integer) f47594a.get(strB.substring(0, strB.indexOf(fh.a.f28350w)))).intValue();
    }

    public static byte[] c(s sVar, byte[] bArr, int i10) {
        int i11 = (i10 + 7) / 8;
        byte[] bArr2 = new byte[i11];
        int iH = i11 / sVar.h();
        int iH2 = sVar.h();
        byte[] bArr3 = new byte[iH2];
        int i12 = 1;
        int i13 = 0;
        for (int i14 = 0; i14 <= iH; i14++) {
            sVar.update((byte) i12);
            sVar.update((byte) (i10 >> 24));
            sVar.update((byte) (i10 >> 16));
            sVar.update((byte) (i10 >> 8));
            sVar.update((byte) i10);
            sVar.update(bArr, 0, bArr.length);
            sVar.c(bArr3, 0);
            int i15 = i14 * iH2;
            int i16 = i11 - i15;
            if (i16 > iH2) {
                i16 = iH2;
            }
            System.arraycopy(bArr3, 0, bArr2, i15, i16);
            i12++;
        }
        int i17 = i10 % 8;
        if (i17 != 0) {
            int i18 = 8 - i17;
            int i19 = 0;
            while (i13 != i11) {
                int i20 = bArr2[i13] & 255;
                bArr2[i13] = (byte) ((i19 << (8 - i18)) | (i20 >>> i18));
                i13++;
                i19 = i20;
            }
        }
        return bArr2;
    }

    public static boolean d(byte[] bArr, int i10) {
        return bArr != null && bArr.length > i10;
    }
}
