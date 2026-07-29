package es;

import gm.h0;
import gm.l2;
import gm.u1;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c1 f27115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f27116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f27117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f27118d;

    public c(c cVar) {
        this.f27117c = new ArrayList();
        this.f27118d = false;
        this.f27115a = cVar.f27115a;
        this.f27116b = cVar.f27116b;
        this.f27118d = cVar.f27118d;
        this.f27117c = new ArrayList(cVar.f27117c);
    }

    public c(xn.d dVar, c1 c1Var) {
        this.f27117c = new ArrayList();
        this.f27118d = false;
        this.f27116b = dVar;
        this.f27115a = c1Var;
    }

    public c a(y yVar, gm.h hVar) {
        this.f27117c.add(new pn.a(yVar, new l2(hVar)));
        return this;
    }

    public c b(y yVar, gm.h[] hVarArr) {
        this.f27117c.add(new pn.a(yVar, new l2(hVarArr)));
        return this;
    }

    public b c(cs.f fVar) {
        pn.f fVar2;
        if (this.f27117c.isEmpty()) {
            fVar2 = this.f27118d ? new pn.f(this.f27116b, this.f27115a, (h0) null) : new pn.f(this.f27116b, this.f27115a, new l2());
        } else {
            gm.i iVar = new gm.i();
            Iterator it2 = this.f27117c.iterator();
            while (it2.hasNext()) {
                iVar.a(pn.a.A(it2.next()));
            }
            fVar2 = new pn.f(this.f27116b, this.f27115a, new l2(iVar));
        }
        try {
            OutputStream outputStreamB = fVar.b();
            outputStreamB.write(fVar2.v(gm.j.f29713a));
            outputStreamB.close();
            return new b(new pn.e(fVar2, fVar.a(), new u1(fVar.getSignature())));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certification request signature");
        }
    }

    public c d(y yVar, gm.h hVar) {
        Iterator it2 = this.f27117c.iterator();
        while (it2.hasNext()) {
            if (((pn.a) it2.next()).x().C(yVar)) {
                throw new IllegalStateException("Attribute " + yVar.toString() + " is already set");
            }
        }
        a(yVar, hVar);
        return this;
    }

    public c e(y yVar, gm.h[] hVarArr) {
        Iterator it2 = this.f27117c.iterator();
        while (it2.hasNext()) {
            if (((pn.a) it2.next()).x().C(yVar)) {
                throw new IllegalStateException("Attribute " + yVar.toString() + " is already set");
            }
        }
        b(yVar, hVarArr);
        return this;
    }

    public c f(boolean z10) {
        this.f27118d = z10;
        return this;
    }
}
