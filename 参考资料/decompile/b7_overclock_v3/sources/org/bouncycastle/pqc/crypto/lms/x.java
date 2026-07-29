package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class x implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f45798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f45799b;

    public x(w wVar, v vVar) {
        this.f45798a = wVar;
        this.f45799b = vVar;
    }

    public v a() {
        return this.f45799b;
    }

    public w b() {
        return this.f45798a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        w wVar = this.f45798a;
        if (wVar == null ? xVar.f45798a != null : !wVar.equals(xVar.f45798a)) {
            return false;
        }
        v vVar = this.f45799b;
        v vVar2 = xVar.f45799b;
        return vVar != null ? vVar.equals(vVar2) : vVar2 == null;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return a.i().d(this.f45798a.getEncoded()).d(this.f45799b.getEncoded()).b();
    }

    public int hashCode() {
        w wVar = this.f45798a;
        int iHashCode = (wVar != null ? wVar.hashCode() : 0) * 31;
        v vVar = this.f45799b;
        return iHashCode + (vVar != null ? vVar.hashCode() : 0);
    }
}
