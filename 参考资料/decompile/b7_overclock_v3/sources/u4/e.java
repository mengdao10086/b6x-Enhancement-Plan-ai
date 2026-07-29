package u4;

import g.n0;
import java.security.MessageDigest;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements c4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f51935c;

    public e(@n0 Object obj) {
        this.f51935c = m.d(obj);
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(this.f51935c.toString().getBytes(c4.b.f9745b));
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f51935c.equals(((e) obj).f51935c);
        }
        return false;
    }

    @Override // c4.b
    public int hashCode() {
        return this.f51935c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f51935c + '}';
    }
}
