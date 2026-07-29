package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.bouncycastle.cms.CMSException;
import so.h1;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class u extends v {

    public class a implements cs.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f44631b;

        public a(zn.b bVar, Cipher cipher) {
            this.f44630a = bVar;
            this.f44631b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f44630a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f44631b);
        }
    }

    public u(PrivateKey privateKey, h1 h1Var) throws IOException {
        super(privateKey, v.h(h1Var));
    }

    @Override // so.g1
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, this.f44637f.g(g(bVar, bVar2, bArr), bVar2)));
    }
}
