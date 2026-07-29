package org.bouncycastle.jce;

import gm.f0;
import gm.s;
import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;
import zn.w1;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w1 implements Principal {
    public j(String str) {
        super(str);
    }

    public j(Hashtable hashtable) {
        super(hashtable);
    }

    public j(Vector vector, Hashtable hashtable) {
        super(vector, hashtable);
    }

    public j(Vector vector, Vector vector2) {
        super(vector, vector2);
    }

    public j(xn.d dVar) {
        super((f0) dVar.b());
    }

    public j(w1 w1Var) {
        super((f0) w1Var.b());
    }

    public j(boolean z10, String str) {
        super(z10, str);
    }

    public j(boolean z10, Hashtable hashtable, String str) {
        super(z10, hashtable, str);
    }

    public j(byte[] bArr) throws IOException {
        super(N(new s(bArr)));
    }

    public static f0 N(s sVar) throws IOException {
        try {
            return f0.J(sVar.n());
        } catch (IllegalArgumentException e10) {
            throw new IOException("not an ASN.1 Sequence: " + e10);
        }
    }

    @Override // gm.w, org.bouncycastle.util.g
    public byte[] getEncoded() {
        try {
            return v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new RuntimeException(e10.toString());
        }
    }

    @Override // java.security.Principal
    public String getName() {
        return toString();
    }
}
