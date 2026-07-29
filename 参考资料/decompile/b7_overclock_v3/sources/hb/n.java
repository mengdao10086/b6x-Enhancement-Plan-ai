package hb;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static int a(l lVar, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int iM = lVar.m(bArr, i10 + i12, i11 - i12);
            if (iM == -1) {
                break;
            }
            i12 += iM;
        }
        return i12;
    }
}
