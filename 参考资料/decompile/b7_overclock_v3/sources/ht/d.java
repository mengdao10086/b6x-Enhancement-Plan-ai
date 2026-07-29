package ht;

import cs.o;
import gm.c2;
import gm.p2;
import gm.r;
import gm.r0;
import java.net.URI;
import mm.e0;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f31443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public URI f31444b;

    public void a(o oVar) throws CMSException {
        new e(this.f31443a).e(oVar);
    }

    public void b(URI uri) {
        this.f31444b = uri;
    }

    public final void c(boolean z10, r0 r0Var, r rVar, mm.c cVar) {
        this.f31443a = new e0(gm.f.K(z10), r0Var, rVar, cVar);
    }

    public void d(boolean z10, String str, String str2) {
        e(z10, str, str2, null);
    }

    public void e(boolean z10, String str, String str2, mm.c cVar) {
        c(z10, str != null ? new p2(str) : null, str2 != null ? new c2(str2) : null, cVar);
    }
}
