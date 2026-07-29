package fs;

import cs.y;
import ds.l;
import gm.d2;
import org.bouncycastle.operator.OperatorCreationException;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class d implements es.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f28726a;

    public class a implements es.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f28727a;

        public a(zn.b bVar) {
            this.f28727a = bVar;
        }

        @Override // es.d
        public zn.b a() {
            return new zn.b(this.f28727a.x(), d2.f29657b);
        }

        @Override // es.d
        public y b(char[] cArr) throws OperatorCreationException {
            return g.b(this.f28727a.x(), d.this.f28726a.a(this.f28727a), r.y(this.f28727a.A()), cArr);
        }
    }

    public d(l lVar) {
        this.f28726a = lVar;
    }

    @Override // es.e
    public es.d a(zn.b bVar) {
        return new a(bVar);
    }
}
