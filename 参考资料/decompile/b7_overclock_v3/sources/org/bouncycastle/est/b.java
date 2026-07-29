package org.bouncycastle.est;

import gm.c0;
import gm.y;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wm.b f44780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<y, wm.a> f44781b;

    public b(wm.b bVar) throws ESTException {
        HashMap<y, wm.a> map;
        y yVarX;
        this.f44780a = bVar;
        this.f44781b = new HashMap<>(bVar.size());
        wm.a[] aVarArrX = bVar.x();
        for (int i10 = 0; i10 != aVarArrX.length; i10++) {
            wm.a aVar = aVarArrX[i10];
            if (aVar.A()) {
                map = this.f44781b;
                yVarX = aVar.z();
            } else {
                map = this.f44781b;
                yVarX = aVar.x().x();
            }
            map.put(yVarX, aVar);
        }
    }

    public b(byte[] bArr) throws ESTException {
        this(e(bArr));
    }

    public static wm.b e(byte[] bArr) throws ESTException {
        try {
            return wm.b.z(c0.D(bArr));
        } catch (Exception e10) {
            throw new ESTException("malformed data: " + e10.getMessage(), e10);
        }
    }

    public Collection<y> a() {
        return this.f44781b.keySet();
    }

    public boolean b(y yVar) {
        return this.f44781b.containsKey(yVar);
    }

    public boolean c(y yVar) {
        if (this.f44781b.containsKey(yVar)) {
            return !this.f44781b.get(yVar).A();
        }
        return false;
    }

    public boolean d() {
        return this.f44780a.size() == 0;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f44780a.getEncoded();
    }
}
