package so;

import gm.l2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class i extends l {

    public class a implements cs.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cs.o f50188a;

        public a(cs.o oVar) {
            this.f50188a = oVar;
        }

        @Override // cs.p
        public cs.o a(zn.b bVar) throws OperatorCreationException {
            return this.f50188a;
        }
    }

    public h g(r0 r0Var, cs.y yVar) throws CMSException {
        return h(r0Var, yVar, null);
    }

    public h h(r0 r0Var, cs.y yVar, cs.o oVar) throws CMSException {
        mm.f fVar;
        gm.i iVar = new gm.i();
        Iterator it2 = this.f50056a.iterator();
        while (it2.hasNext()) {
            iVar.a(((w1) it2.next()).a(yVar.getKey()));
        }
        if (oVar != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                kt.e eVar = new kt.e(oVar.b(), byteArrayOutputStream);
                r0Var.d(eVar);
                eVar.close();
                gm.e1 e1Var = new gm.e1(byteArrayOutputStream.toByteArray());
                Map mapUnmodifiableMap = Collections.unmodifiableMap(d(r0Var.a(), oVar.a(), yVar.a(), oVar.c()));
                if (this.f50213y == null) {
                    this.f50213y = new u0();
                }
                l2 l2Var = new l2(this.f50213y.a(mapUnmodifiableMap).h());
                try {
                    OutputStream outputStreamB = yVar.b();
                    outputStreamB.write(l2Var.v(gm.j.f29713a));
                    outputStreamB.close();
                    fVar = new mm.f(this.f50058c, new l2(iVar), yVar.a(), oVar.a(), new mm.n(r0Var.a(), e1Var), l2Var, new gm.f2(yVar.d()), this.f50214z != null ? new gm.l1(this.f50214z.a(mapUnmodifiableMap).h()) : null);
                } catch (IOException e10) {
                    throw new CMSException("unable to perform MAC calculation: " + e10.getMessage(), e10);
                }
            } catch (IOException e11) {
                throw new CMSException("unable to perform digest calculation: " + e11.getMessage(), e11);
            }
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                kt.e eVar2 = new kt.e(byteArrayOutputStream2, yVar.b());
                r0Var.d(eVar2);
                eVar2.close();
                fVar = new mm.f(this.f50058c, new l2(iVar), yVar.a(), null, new mm.n(r0Var.a(), new gm.e1(byteArrayOutputStream2.toByteArray())), null, new gm.f2(yVar.d()), this.f50214z != null ? new gm.l1(this.f50214z.a(Collections.EMPTY_MAP).h()) : null);
            } catch (IOException e12) {
                throw new CMSException("unable to perform MAC calculation: " + e12.getMessage(), e12);
            }
        }
        return new h(new mm.n(mm.k.P2, fVar), new a(oVar));
    }
}
