package eb;

import eb.f;
import g.p0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class h extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f.a<h> f26809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public ByteBuffer f26810e;

    public h(f.a<h> aVar) {
        this.f26809d = aVar;
    }

    @Override // eb.a
    public void h() {
        super.h();
        ByteBuffer byteBuffer = this.f26810e;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // eb.f
    public void p() {
        this.f26809d.a(this);
    }

    public ByteBuffer q(long j10, int i10) {
        this.f26793b = j10;
        ByteBuffer byteBuffer = this.f26810e;
        if (byteBuffer == null || byteBuffer.capacity() < i10) {
            this.f26810e = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        }
        this.f26810e.position(0);
        this.f26810e.limit(i10);
        return this.f26810e;
    }
}
