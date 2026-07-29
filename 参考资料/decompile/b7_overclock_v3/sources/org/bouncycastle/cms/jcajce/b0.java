package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.bouncycastle.cms.CMSException;
import so.z1;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends e0 {

    public class a implements cs.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f44512b;

        public a(zn.b bVar, Cipher cipher) {
            this.f44511a = bVar;
            this.f44512b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f44511a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f44512b);
        }

        @Override // cs.a
        public OutputStream c() {
            return new b(this.f44512b);
        }

        @Override // cs.a
        public byte[] d() {
            return new byte[0];
        }
    }

    public static class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cipher f44514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f44515b = new byte[1];

        public b(Cipher cipher) {
            this.f44514a = cipher;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            byte[] bArr = this.f44515b;
            bArr[0] = (byte) i10;
            this.f44514a.updateAAD(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f44514a.updateAAD(bArr, i10, i11);
        }
    }

    public b0(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // so.g1
    public z1 a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        return new z1(new a(bVar2, this.f44540e.g(g(bVar, bVar2, bArr), bVar2)));
    }
}
