package zr;

import cs.d0;
import gm.d2;
import gm.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.io.pem.PemGenerationException;
import pn.s;
import pn.u;

/* JADX INFO: loaded from: classes6.dex */
public class k implements lt.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f59692c = kn.d.f37625y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f59693d = kn.d.G;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f59694e = kn.d.O;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f59695f = s.Z3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y f59696g = s.f46814i6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f59697h = s.f46817j6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y f59698i = s.f46820k6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f59699j = s.f46823l6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y f59700k = s.f46826m6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y f59701l = s.f46829n6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final zn.b f59702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final zn.b f59703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final zn.b f59704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final zn.b f59705p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final zn.b f59706q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final zn.b f59707r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final zn.b f59708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final zn.b f59709t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final zn.b f59710u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final zn.b f59711v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f59712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f59713b;

    static {
        y yVar = s.f46806g4;
        d2 d2Var = d2.f29657b;
        f59702m = new zn.b(yVar, d2Var);
        f59703n = new zn.b(s.f46809h4, d2Var);
        f59704o = new zn.b(s.f46812i4, d2Var);
        f59705p = new zn.b(s.f46815j4, d2Var);
        f59706q = new zn.b(s.f46818k4, d2Var);
        f59707r = new zn.b(qm.a.f47453c, d2Var);
        f59708s = new zn.b(kn.d.f37615o, d2Var);
        f59709t = new zn.b(kn.d.f37616p, d2Var);
        f59710u = new zn.b(kn.d.f37617q, d2Var);
        f59711v = new zn.b(kn.d.f37618r, d2Var);
    }

    public k(u uVar, d0 d0Var) {
        this.f59712a = uVar;
        this.f59713b = d0Var;
    }

    public final lt.b a(u uVar, d0 d0Var) throws PemGenerationException {
        try {
            byte[] encoded = uVar.getEncoded();
            if (d0Var == null) {
                return new lt.b(i.f59674t, encoded);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStreamB = d0Var.b(byteArrayOutputStream);
            outputStreamB.write(uVar.getEncoded());
            outputStreamB.close();
            return new lt.b(i.f59673s, new pn.j(d0Var.a(), byteArrayOutputStream.toByteArray()).getEncoded());
        } catch (IOException e10) {
            throw new PemGenerationException("unable to process encoded key data: " + e10.getMessage(), e10);
        }
    }

    @Override // lt.c
    public lt.b generate() throws PemGenerationException {
        d0 d0Var = this.f59713b;
        return d0Var != null ? a(this.f59712a, d0Var) : a(this.f59712a, null);
    }
}
