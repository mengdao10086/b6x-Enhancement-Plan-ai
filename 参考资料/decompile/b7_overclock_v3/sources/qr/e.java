package qr;

import java.math.BigInteger;
import org.bouncycastle.util.j;

/* JADX INFO: loaded from: classes6.dex */
public class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f47612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f47613b;

    public e(b bVar, f fVar) {
        this.f47612a = bVar;
        this.f47613b = fVar;
    }

    @Override // qr.a
    public int a() {
        return this.f47613b.a();
    }

    @Override // qr.a
    public b b() {
        return this.f47612a;
    }

    @Override // qr.g
    public f c() {
        return this.f47613b;
    }

    @Override // qr.b
    public int d() {
        return this.f47612a.d() * this.f47613b.a();
    }

    @Override // qr.b
    public BigInteger e() {
        return this.f47612a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f47612a.equals(eVar.f47612a) && this.f47613b.equals(eVar.f47613b);
    }

    public int hashCode() {
        return this.f47612a.hashCode() ^ j.e(this.f47613b.hashCode(), 16);
    }
}
