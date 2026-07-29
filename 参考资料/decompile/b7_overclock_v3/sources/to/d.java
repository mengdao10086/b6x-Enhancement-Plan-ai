package to;

import cs.s;
import ds.u;
import java.io.InputStream;
import np.n1;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.k0;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class d extends e {

    public class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f51406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f51407b;

        public a(zn.b bVar, Object obj) {
            this.f51406a = bVar;
            this.f51407b = obj;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f51406a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return this.f51407b instanceof org.bouncycastle.crypto.h ? new gp.a(inputStream, (org.bouncycastle.crypto.h) this.f51407b) : new gp.a(inputStream, (k0) this.f51407b);
        }
    }

    public d(u uVar) {
        super(uVar);
    }

    @Override // so.y0
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, p.a(false, (n1) g(bVar, bVar2, bArr), bVar2)));
    }
}
