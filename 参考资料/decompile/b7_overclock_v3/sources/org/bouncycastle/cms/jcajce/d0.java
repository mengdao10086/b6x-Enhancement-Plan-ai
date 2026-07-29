package org.bouncycastle.cms.jcajce;

import java.io.InputStream;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class d0 extends e0 {

    public class a implements cs.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f44536b;

        public a(zn.b bVar, Cipher cipher) {
            this.f44535a = bVar;
            this.f44536b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f44535a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f44536b);
        }
    }

    public d0(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // so.g1
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, this.f44540e.g(g(bVar, bVar2, bArr), bVar2)));
    }
}
