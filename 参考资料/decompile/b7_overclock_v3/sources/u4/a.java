package u4;

import android.content.Context;
import g.n0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c4.b f51928d;

    public a(int i10, c4.b bVar) {
        this.f51927c = i10;
        this.f51928d = bVar;
    }

    @n0
    public static c4.b c(@n0 Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        this.f51928d.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f51927c).array());
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f51927c == aVar.f51927c && this.f51928d.equals(aVar.f51928d);
    }

    @Override // c4.b
    public int hashCode() {
        return o.q(this.f51928d, this.f51927c);
    }
}
