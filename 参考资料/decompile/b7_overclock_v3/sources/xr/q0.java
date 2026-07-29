package xr;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class q0 extends gm.f2 {
    public q0(gm.h hVar) throws IOException {
        super(hVar);
    }

    public q0(byte[] bArr) {
        super(bArr);
    }

    public static q0 N(Object obj) {
        if (obj instanceof q0) {
            return (q0) obj;
        }
        if (obj != null) {
            return new q0(gm.z.I(obj).J());
        }
        return null;
    }
}
