package it;

import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class b implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        for (int i10 = 0; i10 < bArr.length && i10 < bArr2.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = bArr2[i10] & 255;
            if (i11 != i12) {
                return i11 - i12;
            }
        }
        return bArr.length - bArr2.length;
    }
}
