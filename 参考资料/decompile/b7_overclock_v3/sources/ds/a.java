package ds;

import np.n1;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static zn.b a(n1 n1Var) {
        gm.y yVar;
        int length = n1Var.a().length * 8;
        if (length == 128) {
            yVar = kn.d.B;
        } else if (length == 192) {
            yVar = kn.d.J;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("illegal keysize in AES");
            }
            yVar = kn.d.R;
        }
        return new zn.b(yVar);
    }
}
