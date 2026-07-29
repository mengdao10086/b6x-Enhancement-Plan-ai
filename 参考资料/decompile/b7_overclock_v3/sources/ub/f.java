package ub;

import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements b {
    @Override // ub.b
    @p0
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = (ByteBuffer) hd.a.g(dVar.f16960c);
        hd.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (dVar.l()) {
            return null;
        }
        return b(dVar, byteBuffer);
    }

    @p0
    public abstract Metadata b(d dVar, ByteBuffer byteBuffer);
}
