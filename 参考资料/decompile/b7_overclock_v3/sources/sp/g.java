package sp;

import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.dvcs.DVCSException;
import so.m0;
import zn.a0;
import zn.b0;
import zn.c0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f50370a = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f50371b = new m0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rm.h f50372c;

    public g(rm.h hVar) {
        this.f50372c = hVar;
    }

    public void a(y yVar, boolean z10, gm.h hVar) throws DVCSException {
        try {
            this.f50370a.a(yVar, z10, hVar);
        } catch (IOException e10) {
            throw new DVCSException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public f b(rm.k kVar) throws DVCSException {
        if (!this.f50370a.h()) {
            this.f50372c.f(this.f50370a.e());
        }
        return new f(new mm.n(rm.e.f48855e, new rm.f(this.f50372c.a(), kVar)));
    }

    public void c(b0 b0Var) {
        this.f50372c.b(b0Var);
    }

    public void d(c0 c0Var) {
        this.f50372c.c(c0Var);
    }

    public void e(b0 b0Var) {
        this.f50372c.d(b0Var);
    }

    public void f(c0 c0Var) {
        this.f50372c.e(c0Var);
    }

    public void g(BigInteger bigInteger) {
        this.f50372c.g(bigInteger);
    }

    public void h(b0 b0Var) {
        this.f50372c.j(b0Var);
    }
}
