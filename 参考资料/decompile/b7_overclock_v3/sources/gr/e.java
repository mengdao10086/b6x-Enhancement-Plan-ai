package gr;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class e implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ir.e f29943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f29944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ir.i f29945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f29946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f29947e;

    public e(ir.e eVar, ir.i iVar, BigInteger bigInteger) {
        this.f29943a = eVar;
        this.f29945c = iVar.B();
        this.f29946d = bigInteger;
        this.f29947e = BigInteger.valueOf(1L);
        this.f29944b = null;
    }

    public e(ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f29943a = eVar;
        this.f29945c = iVar.B();
        this.f29946d = bigInteger;
        this.f29947e = bigInteger2;
        this.f29944b = null;
    }

    public e(ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f29943a = eVar;
        this.f29945c = iVar.B();
        this.f29946d = bigInteger;
        this.f29947e = bigInteger2;
        this.f29944b = bArr;
    }

    public ir.e a() {
        return this.f29943a;
    }

    public ir.i b() {
        return this.f29945c;
    }

    public BigInteger c() {
        return this.f29947e;
    }

    public BigInteger d() {
        return this.f29946d;
    }

    public byte[] e() {
        return this.f29944b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return a().m(eVar.a()) && b().e(eVar.b());
    }

    public int hashCode() {
        return a().hashCode() ^ b().hashCode();
    }
}
