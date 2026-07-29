package pp;

/* JADX INFO: loaded from: classes5.dex */
public class f {
    public static byte[] a(d dVar, int i10) {
        byte[] bArr = new byte[i10];
        if (i10 * 8 <= dVar.c()) {
            System.arraycopy(dVar.a(), 0, bArr, 0, i10);
        } else {
            int iC = dVar.c() / 8;
            for (int i11 = 0; i11 < i10; i11 += iC) {
                byte[] bArrA = dVar.a();
                int i12 = i10 - i11;
                if (bArrA.length <= i12) {
                    System.arraycopy(bArrA, 0, bArr, i11, bArrA.length);
                } else {
                    System.arraycopy(bArrA, 0, bArr, i11, i12);
                }
            }
        }
        return bArr;
    }
}
