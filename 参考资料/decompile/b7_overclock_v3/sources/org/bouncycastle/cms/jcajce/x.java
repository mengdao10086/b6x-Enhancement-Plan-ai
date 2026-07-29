package org.bouncycastle.cms.jcajce;

import java.io.InputStream;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.bouncycastle.cms.CMSException;
import so.z1;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class x extends y {

    public class a implements cs.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f44646b;

        public a(zn.b bVar, Cipher cipher) {
            this.f44645a = bVar;
            this.f44646b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f44645a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f44646b);
        }
    }

    public x(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // so.c1
    public z1 c(zn.b bVar, zn.b bVar2, c1 c1Var, gm.z zVar, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, this.f44654e.g(h(bVar, bVar2, c1Var, zVar, bArr), bVar2)));
    }
}
