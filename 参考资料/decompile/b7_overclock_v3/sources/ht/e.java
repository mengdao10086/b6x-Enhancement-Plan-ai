package ht;

import cs.o;
import gm.j;
import gm.k0;
import java.io.IOException;
import mm.e0;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f31445a;

    public e(e0 e0Var) {
        this.f31445a = e0Var;
    }

    public final String a(k0 k0Var) {
        if (k0Var != null) {
            return k0Var.toString();
        }
        return null;
    }

    public String b() {
        e0 e0Var = this.f31445a;
        if (e0Var != null) {
            return a(e0Var.y());
        }
        return null;
    }

    public String c() {
        e0 e0Var = this.f31445a;
        if (e0Var != null) {
            return a(e0Var.A());
        }
        return null;
    }

    public mm.c d() {
        e0 e0Var = this.f31445a;
        if (e0Var != null) {
            return e0Var.C();
        }
        return null;
    }

    public void e(o oVar) throws CMSException {
        e0 e0Var = this.f31445a;
        if (e0Var == null || !e0Var.D()) {
            return;
        }
        try {
            oVar.b().write(this.f31445a.v(j.f29713a));
        } catch (IOException e10) {
            throw new CMSException("unable to initialise calculator from metaData: " + e10.getMessage(), e10);
        }
    }
}
