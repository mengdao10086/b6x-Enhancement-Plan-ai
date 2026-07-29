package org.bouncycastle.operator.jcajce;

import cs.o;
import cs.p;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OperatorHelper f45614a = new OperatorHelper(new org.bouncycastle.jcajce.util.c());

    public class a implements p {

        /* JADX INFO: renamed from: org.bouncycastle.operator.jcajce.d$a$a, reason: collision with other inner class name */
        public class C0515a implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zn.b f45616a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f45617b;

            public C0515a(zn.b bVar, b bVar2) {
                this.f45616a = bVar;
                this.f45617b = bVar2;
            }

            @Override // cs.o
            public zn.b a() {
                return this.f45616a;
            }

            @Override // cs.o
            public OutputStream b() {
                return this.f45617b;
            }

            @Override // cs.o
            public byte[] c() {
                return this.f45617b.a();
            }
        }

        public a() {
        }

        @Override // cs.p
        public o a(zn.b bVar) throws OperatorCreationException {
            try {
                return new C0515a(bVar, d.this.new b(d.this.f45614a.f(bVar)));
            } catch (GeneralSecurityException e10) {
                throw new OperatorCreationException("exception on setup: " + e10, e10);
            }
        }
    }

    public class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MessageDigest f45619a;

        public b(MessageDigest messageDigest) {
            this.f45619a = messageDigest;
        }

        public byte[] a() {
            return this.f45619a.digest();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f45619a.update((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f45619a.update(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f45619a.update(bArr, i10, i11);
        }
    }

    public p b() throws OperatorCreationException {
        return new a();
    }

    public d c(org.bouncycastle.jcajce.util.d dVar) {
        this.f45614a = new OperatorHelper(dVar);
        return this;
    }

    public d d(String str) {
        this.f45614a = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public d e(Provider provider) {
        this.f45614a = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }
}
