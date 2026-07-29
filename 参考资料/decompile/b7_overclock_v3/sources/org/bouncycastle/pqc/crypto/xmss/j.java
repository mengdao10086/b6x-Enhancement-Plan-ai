package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f45910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f45915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final gm.y f45916g;

    public j(gm.y yVar) {
        Objects.requireNonNull(yVar, "treeDigest == null");
        this.f45916g = yVar;
        org.bouncycastle.crypto.s sVarA = c.a(yVar);
        int iJ = k0.j(sVarA);
        this.f45911b = iJ;
        this.f45912c = 16;
        int iCeil = (int) Math.ceil(((double) (iJ * 8)) / ((double) k0.q(16)));
        this.f45914e = iCeil;
        int iFloor = ((int) Math.floor(k0.q((16 - 1) * iCeil) / k0.q(16))) + 1;
        this.f45915f = iFloor;
        int i10 = iCeil + iFloor;
        this.f45913d = i10;
        i iVarC = i.c(sVarA.b(), iJ, 16, i10);
        this.f45910a = iVarC;
        if (iVarC != null) {
            return;
        }
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + sVarA.b());
    }

    public int a() {
        return this.f45913d;
    }

    public int b() {
        return this.f45914e;
    }

    public int c() {
        return this.f45915f;
    }

    public c0 d() {
        return this.f45910a;
    }

    public gm.y e() {
        return this.f45916g;
    }

    public int f() {
        return this.f45911b;
    }

    public int g() {
        return this.f45912c;
    }
}
