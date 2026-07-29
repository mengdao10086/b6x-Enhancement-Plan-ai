package to;

import cs.s;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.k0;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class i extends j {

    public class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f51411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f51412b;

        public a(zn.b bVar, Object obj) {
            this.f51411a = bVar;
            this.f51412b = obj;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f51411a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return this.f51412b instanceof org.bouncycastle.crypto.h ? new gp.a(inputStream, (org.bouncycastle.crypto.h) this.f51412b) : new gp.a(inputStream, (k0) this.f51412b);
        }
    }

    public i(char[] cArr) {
        super(cArr);
    }

    @Override // so.q1
    public z1 e(zn.b bVar, zn.b bVar2, byte[] bArr, byte[] bArr2) throws CMSException {
        return new z1(new a(bVar2, p.a(false, g(bVar, bVar2, bArr, bArr2), bVar2)));
    }
}
