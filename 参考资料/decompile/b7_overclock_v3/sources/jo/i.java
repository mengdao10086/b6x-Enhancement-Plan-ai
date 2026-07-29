package jo;

import org.bouncycastle.cert.dane.DANEException;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f36538a;

    public i(e eVar) {
        this.f36538a = eVar;
    }

    public h a(String str) throws DANEException {
        return new h(this.f36538a.a(str).a());
    }
}
