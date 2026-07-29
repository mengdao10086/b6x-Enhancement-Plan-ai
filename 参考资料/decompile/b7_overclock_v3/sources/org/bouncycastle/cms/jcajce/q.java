package org.bouncycastle.cms.jcajce;

import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class q extends r {

    public class a implements cs.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f44616b;

        public a(zn.b bVar, Cipher cipher) {
            this.f44615a = bVar;
            this.f44616b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f44615a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f44616b);
        }
    }

    public q(SecretKey secretKey) {
        super(secretKey);
    }

    @Override // so.y0
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, this.f44624e.g(g(bVar, bVar2, bArr), bVar2)));
    }
}
