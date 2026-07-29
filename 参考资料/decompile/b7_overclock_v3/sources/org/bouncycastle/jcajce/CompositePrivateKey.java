package org.bouncycastle.jcajce;

import gm.i;
import gm.j;
import gm.j2;
import in.c;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pn.u;
import zn.b;

/* JADX INFO: loaded from: classes7.dex */
public class CompositePrivateKey implements PrivateKey {
    private final List<PrivateKey> keys;

    public CompositePrivateKey(PrivateKey... privateKeyArr) {
        if (privateKeyArr == null || privateKeyArr.length == 0) {
            throw new IllegalArgumentException("at least one public key must be provided");
        }
        ArrayList arrayList = new ArrayList(privateKeyArr.length);
        for (int i10 = 0; i10 != privateKeyArr.length; i10++) {
            arrayList.add(privateKeyArr[i10]);
        }
        this.keys = Collections.unmodifiableList(arrayList);
    }

    public List<PrivateKey> a() {
        return this.keys;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompositePrivateKey) {
            return this.keys.equals(((CompositePrivateKey) obj).keys);
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "Composite";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        i iVar = new i();
        for (int i10 = 0; i10 != this.keys.size(); i10++) {
            iVar.a(u.z(this.keys.get(i10).getEncoded()));
        }
        try {
            return new u(new b(c.N), new j2(iVar)).v(j.f29713a);
        } catch (IOException e10) {
            throw new IllegalStateException("unable to encode composite key: " + e10.getMessage());
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.keys.hashCode();
    }
}
