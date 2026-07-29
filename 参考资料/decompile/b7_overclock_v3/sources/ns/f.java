package ns;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.util.e;
import org.bouncycastle.crypto.y;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.b f42642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecureRandom f42643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42644c = false;

    public static class a extends f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public org.bouncycastle.crypto.c f42645d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f42646e;

        public a(zn.b bVar, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(bVar, bArr, bArr2, secureRandom);
            this.f42646e = new c();
            e eVar = new e();
            eVar.a(new y(secureRandom, 2048));
            org.bouncycastle.crypto.c cVarB = eVar.b();
            this.f42645d = cVarB;
            this.f42646e.b(cVarB.a());
        }

        public org.bouncycastle.crypto.util.e e(byte[] bArr) {
            if (this.f42644c) {
                throw new IllegalStateException("builder already used");
            }
            this.f42644c = true;
            this.f42642a.b(this.f42646e.a(f.d(bArr)));
            return this.f42642a.a();
        }

        public byte[] f() {
            return f.c((h) this.f42645d.b());
        }

        public f g(byte[] bArr) {
            this.f42642a.c(bArr);
            return this;
        }
    }

    public static class b extends f {
        public b(zn.b bVar, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(bVar, bArr, bArr2, secureRandom);
        }

        public org.bouncycastle.crypto.util.e e() {
            if (this.f42644c) {
                throw new IllegalStateException("builder already used");
            }
            this.f42644c = true;
            return this.f42642a.a();
        }

        public byte[] f(byte[] bArr) {
            js.c cVarA = new d(this.f42643b).a(f.d(bArr));
            this.f42642a.b(cVarA.b());
            return f.c((h) cVarA.a());
        }

        public f g(byte[] bArr) {
            this.f42642a.c(bArr);
            return this;
        }
    }

    public f(zn.b bVar, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.f42642a = new e.b(bVar, bArr, bArr2);
        this.f42643b = secureRandom;
    }

    public static byte[] c(h hVar) {
        try {
            return new c1(new zn.b(is.g.f35795v), hVar.d()).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public static h d(byte[] bArr) {
        return new h(c1.A(bArr).C().L());
    }
}
