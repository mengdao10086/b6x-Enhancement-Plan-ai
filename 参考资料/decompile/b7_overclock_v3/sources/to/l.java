package to;

import cs.s;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.k0;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class l extends g {

    public class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f51416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f51417b;

        public a(zn.b bVar, Object obj) {
            this.f51416a = bVar;
            this.f51417b = obj;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f51416a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return this.f51417b instanceof org.bouncycastle.crypto.h ? new gp.a(inputStream, (org.bouncycastle.crypto.h) this.f51417b) : new gp.a(inputStream, (k0) this.f51417b);
        }
    }

    public l(np.c cVar) {
        super(cVar);
    }

    @Override // so.g1
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, p.a(false, g(bVar, bVar2, bArr), bVar2)));
    }
}
