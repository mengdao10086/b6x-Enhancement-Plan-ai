package go;

import gm.y;
import mm.t;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cms.CMSException;
import so.w;

/* JADX INFO: loaded from: classes5.dex */
public class i implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29868b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f29869c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29870d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f29871e = om.b.f44268g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om.o f29872a;

    public i(om.o oVar) {
        this.f29872a = oVar;
    }

    public int a() {
        return this.f29872a.y();
    }

    public w b() throws CRMFException {
        try {
            return new w(new mm.n(mm.k.L2, t.A(om.l.x(this.f29872a.z()).y())));
        } catch (CMSException e10) {
            throw new CRMFException("CMS parsing error: " + e10.getMessage(), e10.getCause());
        } catch (Exception e11) {
            throw new CRMFException("CRMF parsing error: " + e11.getMessage(), e11);
        }
    }

    public boolean c() {
        return !om.l.x(this.f29872a.z()).z();
    }

    @Override // go.e
    public y getType() {
        return f29871e;
    }

    @Override // go.e
    public gm.h getValue() {
        return this.f29872a;
    }
}
