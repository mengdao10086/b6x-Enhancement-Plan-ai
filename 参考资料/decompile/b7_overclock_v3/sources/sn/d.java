package sn;

import gm.c0;
import gm.f0;
import gm.h;
import gm.i;
import gm.j2;
import gm.w;
import gm.y;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f50023c = s.S4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f50024d = s.T4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f50025e = s.U4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f50026f = new y("1.3.14.3.2.7");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y f50027g = s.Z3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f50028h = s.f46788a4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y f50029i = kn.d.f37625y;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f50030j = kn.d.G;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y f50031k = kn.d.O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f50032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f50033b;

    public d(f0 f0Var) {
        this.f50032a = (y) f0Var.K(0);
        if (f0Var.size() > 1) {
            this.f50033b = (c0) f0Var.K(1);
        }
    }

    public d(y yVar, h hVar) {
        this.f50032a = yVar;
        this.f50033b = hVar;
    }

    public static d y(Object obj) {
        if (obj == null || (obj instanceof d)) {
            return (d) obj;
        }
        if (obj instanceof f0) {
            return new d((f0) obj);
        }
        throw new IllegalArgumentException("Invalid SMIMECapability");
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f50032a);
        h hVar = this.f50033b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public y x() {
        return this.f50032a;
    }

    public h z() {
        return this.f50033b;
    }
}
