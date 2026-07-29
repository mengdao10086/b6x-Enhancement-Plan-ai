package xr;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class y1 extends gm.f2 {
    public y1(gm.h hVar) throws IOException {
        super(hVar);
    }

    public y1(byte[] bArr) {
        super(bArr);
    }

    public static y1 N(Object obj) {
        return obj instanceof y1 ? (y1) obj : new y1(gm.z.I(obj).J());
    }
}
