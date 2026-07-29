package so;

import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public interface q1 extends u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f50288a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f50289b = 1;

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f50290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f50291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f50292e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f50293f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f50294g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final zn.b f50296b;

        static {
            gm.y yVar = pn.s.f46806g4;
            gm.d2 d2Var = gm.d2.f29657b;
            f50290c = new a("HMacSHA1", new zn.b(yVar, d2Var));
            f50291d = new a("HMacSHA224", new zn.b(pn.s.f46809h4, d2Var));
            f50292e = new a("HMacSHA256", new zn.b(pn.s.f46812i4, d2Var));
            f50293f = new a("HMacSHA384", new zn.b(pn.s.f46815j4, d2Var));
            f50294g = new a("HMacSHA512", new zn.b(pn.s.f46818k4, d2Var));
        }

        public a(String str, zn.b bVar) {
            this.f50295a = str;
            this.f50296b = bVar;
        }

        public zn.b a() {
            return this.f50296b;
        }

        public String b() {
            return this.f50295a;
        }
    }

    byte[] b(int i10, zn.b bVar, int i11) throws CMSException;

    int d();

    z1 e(zn.b bVar, zn.b bVar2, byte[] bArr, byte[] bArr2) throws CMSException;

    char[] getPassword();
}
