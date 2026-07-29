package tp;

import gm.j;
import gm.s1;
import java.io.OutputStream;
import org.bouncycastle.eac.EACException;
import sm.d;
import sm.e;
import sm.f;
import sm.k;
import sm.l;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f51563g = {0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f51564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f51565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f51566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f51567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f51568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f51569f;

    public a(f fVar, l lVar, e eVar, d dVar, k kVar, k kVar2) {
        this.f51569f = fVar;
        this.f51564a = lVar;
        this.f51568e = eVar;
        this.f51565b = dVar;
        this.f51566c = kVar;
        this.f51567d = kVar2;
    }

    public b a(vp.b bVar) throws EACException {
        try {
            sm.c cVarB = b();
            OutputStream outputStreamB = bVar.b();
            outputStreamB.write(cVarB.v(j.f29713a));
            outputStreamB.close();
            return new b(new sm.a(cVarB, bVar.getSignature()));
        } catch (Exception e10) {
            throw new EACException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public final sm.c b() {
        return new sm.c(new s1(41, f51563g), this.f51569f, this.f51564a, this.f51568e, this.f51565b, this.f51566c, this.f51567d);
    }
}
