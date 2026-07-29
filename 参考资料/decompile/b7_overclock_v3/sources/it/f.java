package it;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<zn.b, byte[]> f35855a = new HashMap();

    @Override // it.g
    public byte[] a(cs.o oVar) {
        zn.b bVarA = oVar.a();
        if (this.f35855a.containsKey(bVarA)) {
            return this.f35855a.get(bVarA);
        }
        byte[] bArrB = b(oVar);
        this.f35855a.put(bVarA, bArrB);
        return bArrB;
    }

    public abstract byte[] b(cs.o oVar);
}
