package so;

import gm.j2;
import java.security.SecureRandom;
import org.bouncycastle.cms.CMSException;
import so.q1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class s1 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f50304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f50305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.y f50306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f50307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f50308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f50309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q1.a f50311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f50312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f50313j;

    public s1(gm.y yVar, char[] cArr) {
        this(yVar, cArr, d(yVar), ((Integer) t1.f50321j.get(yVar)).intValue());
    }

    public s1(gm.y yVar, char[] cArr, int i10, int i11) {
        this.f50304a = cArr;
        this.f50308e = 1;
        this.f50306c = yVar;
        this.f50309f = i10;
        this.f50310g = i11;
        this.f50311h = q1.a.f50290c;
        this.f50313j = 1024;
    }

    public static int d(gm.y yVar) {
        Integer num = (Integer) t1.f50320i.get(yVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("cannot find key size for algorithm: " + yVar);
    }

    @Override // so.w1
    public mm.o0 a(cs.q qVar) throws CMSException {
        byte[] bArr = new byte[this.f50310g];
        if (this.f50307d == null) {
            this.f50307d = new SecureRandom();
        }
        this.f50307d.nextBytes(bArr);
        if (this.f50312i == null) {
            byte[] bArr2 = new byte[20];
            this.f50312i = bArr2;
            this.f50307d.nextBytes(bArr2);
        }
        zn.b bVar = new zn.b(pn.s.X3, new pn.q(this.f50312i, this.f50313j, this.f50311h.f50296b));
        this.f50305b = bVar;
        gm.f2 f2Var = new gm.f2(c(new zn.b(this.f50306c, new gm.f2(bArr)), b(this.f50308e, bVar, this.f50309f), qVar));
        gm.i iVar = new gm.i();
        iVar.a(this.f50306c);
        iVar.a(new gm.f2(bArr));
        return new mm.o0(new mm.l0(this.f50305b, new zn.b(pn.s.f46795c5, new j2(iVar)), f2Var));
    }

    public abstract byte[] b(int i10, zn.b bVar, int i11) throws CMSException;

    public abstract byte[] c(zn.b bVar, byte[] bArr, cs.q qVar) throws CMSException;

    public s1 e(q1.a aVar) {
        this.f50311h = aVar;
        return this;
    }

    public s1 f(int i10) {
        this.f50308e = i10;
        return this;
    }

    public s1 g(byte[] bArr, int i10) {
        this.f50312i = org.bouncycastle.util.a.p(bArr);
        this.f50313j = i10;
        return this;
    }

    public s1 h(SecureRandom secureRandom) {
        this.f50307d = secureRandom;
        return this;
    }
}
