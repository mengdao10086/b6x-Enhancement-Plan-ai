package ds;

import np.n1;

/* JADX INFO: loaded from: classes6.dex */
public class w {
    public static zn.b a(n1 n1Var) {
        gm.y yVar;
        int length = n1Var.a().length * 8;
        if (length == 128) {
            yVar = mn.a.f41446d;
        } else if (length == 192) {
            yVar = mn.a.f41447e;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("illegal keysize in Camellia");
            }
            yVar = mn.a.f41448f;
        }
        return new zn.b(yVar);
    }
}
