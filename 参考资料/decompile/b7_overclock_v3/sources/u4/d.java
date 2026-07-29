package u4;

import g.n0;
import g.p0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final String f51932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f51933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51934e;

    public d(@p0 String str, long j10, int i10) {
        this.f51932c = str == null ? "" : str;
        this.f51933d = j10;
        this.f51934e = i10;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f51933d).putInt(this.f51934e).array());
        messageDigest.update(this.f51932c.getBytes(c4.b.f9745b));
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f51933d == dVar.f51933d && this.f51934e == dVar.f51934e && this.f51932c.equals(dVar.f51932c);
    }

    @Override // c4.b
    public int hashCode() {
        int iHashCode = this.f51932c.hashCode() * 31;
        long j10 = this.f51933d;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f51934e;
    }
}
