package it;

import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.ers.ERSException;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs.p f35860a;

    public k(cs.p pVar) {
        this.f35860a = pVar;
    }

    public j a(c cVar) throws ERSException, TSPException {
        return new j(new un.g((un.e) null, (un.f) null, cVar.i()), this.f35860a);
    }
}
