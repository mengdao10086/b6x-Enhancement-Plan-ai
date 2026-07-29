package bs;

import java.security.Provider;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PasswordException;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f9623a = new org.bouncycastle.jcajce.util.c();

    public class a implements zr.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f9624a;

        /* JADX INFO: renamed from: bs.h$a$a, reason: collision with other inner class name */
        public class C0100a implements zr.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f9626a;

            public C0100a(String str) {
                this.f9626a = str;
            }

            @Override // zr.c
            public byte[] a(byte[] bArr, byte[] bArr2) throws PEMException {
                a aVar = a.this;
                if (aVar.f9624a != null) {
                    return j.a(false, h.this.f9623a, bArr, a.this.f9624a, this.f9626a, bArr2);
                }
                throw new PasswordException("Password is null, but a password is required");
            }
        }

        public a(char[] cArr) {
            this.f9624a = cArr;
        }

        @Override // zr.d
        public zr.c c(String str) {
            return new C0100a(str);
        }
    }

    public zr.d b(char[] cArr) {
        return new a(cArr);
    }

    public h c(String str) {
        this.f9623a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public h d(Provider provider) {
        this.f9623a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
