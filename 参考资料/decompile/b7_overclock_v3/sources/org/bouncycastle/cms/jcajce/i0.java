package org.bouncycastle.cms.jcajce;

import java.io.InputStream;
import javax.crypto.Cipher;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends j0 {

    public class a implements cs.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f44569b;

        public a(zn.b bVar, Cipher cipher) {
            this.f44568a = bVar;
            this.f44569b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f44568a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f44569b);
        }
    }

    public i0(char[] cArr) {
        super(cArr);
    }

    @Override // so.q1
    public z1 e(zn.b bVar, zn.b bVar2, byte[] bArr, byte[] bArr2) throws CMSException {
        return new z1(new a(bVar2, this.f44578d.g(g(bVar, bVar2, bArr, bArr2), bVar2)));
    }
}
