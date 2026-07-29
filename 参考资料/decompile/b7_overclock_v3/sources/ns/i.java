package ns;

import java.security.SecureRandom;
import org.bouncycastle.crypto.m0;
import org.bouncycastle.crypto.y;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f42649a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final org.bouncycastle.crypto.c f42650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ns.c f42651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f42652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f42653d;

        public b(SecureRandom secureRandom) {
            ns.c cVar = new ns.c();
            this.f42651b = cVar;
            this.f42652c = null;
            this.f42653d = false;
            e eVar = new e();
            eVar.a(new y(secureRandom, 2048));
            org.bouncycastle.crypto.c cVarB = eVar.b();
            this.f42650a = cVarB;
            cVar.b(cVarB.a());
        }

        public i a(byte[] bArr) {
            if (this.f42653d) {
                throw new IllegalStateException("builder already used");
            }
            this.f42653d = true;
            return new i(this.f42651b.a(new h(bArr)), this.f42652c);
        }

        public byte[] b() {
            return ((h) this.f42650a.b()).d();
        }

        public b c(byte[] bArr) {
            this.f42652c = org.bouncycastle.util.a.p(bArr);
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SecureRandom f42654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f42655b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f42656c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f42657d = false;

        public c(SecureRandom secureRandom) {
            this.f42654a = secureRandom;
        }

        public i a() {
            if (this.f42657d) {
                throw new IllegalStateException("builder already used");
            }
            this.f42657d = true;
            return new i(this.f42656c, this.f42655b);
        }

        public byte[] b(byte[] bArr) {
            js.c cVarA = new d(this.f42654a).a(new h(bArr));
            this.f42656c = cVarA.b();
            return ((h) cVarA.a()).d();
        }

        public c c(byte[] bArr) {
            this.f42655b = org.bouncycastle.util.a.p(bArr);
            return this;
        }
    }

    public i(byte[] bArr, byte[] bArr2) {
        j0 j0Var = new j0(256);
        this.f42649a = j0Var;
        j0Var.update(bArr, 0, bArr.length);
        if (bArr2 != null) {
            j0Var.update(bArr2, 0, bArr2.length);
        }
        org.bouncycastle.util.a.d0(bArr, (byte) 0);
    }

    public static void b(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    public byte[] a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.f42649a.f(bArr2, 0, length);
        b(bArr, bArr2);
        org.bouncycastle.util.a.d0(bArr2, (byte) 0);
        return bArr;
    }
}
