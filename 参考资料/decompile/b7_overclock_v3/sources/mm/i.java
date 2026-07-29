package mm;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class i extends gm.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f41331d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f41332e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f41333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f41334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f41335c;

    public i(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("Sequence wrong size: One of signatureAlgorithm or macAlgorithm must be present");
        }
        this.f41333a = zn.b.z(f0Var.K(0));
        gm.n0 n0VarT = gm.n0.T(f0Var.K(1));
        if (n0VarT.q() == 1) {
            this.f41334b = zn.b.y(n0VarT, false);
            this.f41335c = null;
        } else if (n0VarT.q() == 2) {
            this.f41334b = null;
            this.f41335c = zn.b.y(n0VarT, false);
        } else {
            throw new IllegalArgumentException("Unknown tag found: " + n0VarT.q());
        }
    }

    public i(zn.b bVar, int i10, zn.b bVar2) {
        if (bVar == null || bVar2 == null) {
            throw new NullPointerException("AlgorithmIdentifiers cannot be null");
        }
        this.f41333a = bVar;
        if (i10 == 1) {
            this.f41334b = bVar2;
            this.f41335c = null;
        } else if (i10 == 2) {
            this.f41334b = null;
            this.f41335c = bVar2;
        } else {
            throw new IllegalArgumentException("Unknown type: " + i10);
        }
    }

    public static i y(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(gm.f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f41334b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f41333a);
        zn.b bVar = this.f41334b;
        if (bVar != null) {
            iVar.a(new n2(false, 1, (gm.h) bVar));
        }
        zn.b bVar2 = this.f41335c;
        if (bVar2 != null) {
            iVar.a(new n2(false, 2, (gm.h) bVar2));
        }
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f41333a;
    }

    public zn.b z() {
        return this.f41335c;
    }
}
