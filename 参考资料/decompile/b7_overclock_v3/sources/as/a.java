package as;

import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PasswordException;
import zr.c;
import zr.d;

/* JADX INFO: loaded from: classes6.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f8873a;

    /* JADX INFO: renamed from: as.a$a, reason: collision with other inner class name */
    public class C0091a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8874a;

        public C0091a(String str) {
            this.f8874a = str;
        }

        @Override // zr.c
        public byte[] a(byte[] bArr, byte[] bArr2) throws PEMException {
            if (a.this.f8873a != null) {
                return b.a(false, bArr, a.this.f8873a, this.f8874a, bArr2);
            }
            throw new PasswordException("Password is null, but a password is required");
        }
    }

    public a(char[] cArr) {
        this.f8873a = cArr;
    }

    @Override // zr.d
    public c c(String str) {
        return new C0091a(str);
    }
}
