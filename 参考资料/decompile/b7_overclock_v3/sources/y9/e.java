package y9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class e extends c.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f56549m;

    public e(final boolean bigEndian, final f parser) throws IOException {
        this.f56532a = bigEndian;
        this.f56549m = parser;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f56533b = parser.i(byteBufferAllocate, 16L);
        this.f56534c = parser.k(byteBufferAllocate, 32L);
        this.f56535d = parser.k(byteBufferAllocate, 40L);
        this.f56536e = parser.i(byteBufferAllocate, 54L);
        this.f56537f = parser.i(byteBufferAllocate, 56L);
        this.f56538g = parser.i(byteBufferAllocate, 58L);
        this.f56539h = parser.i(byteBufferAllocate, 60L);
        this.f56540i = parser.i(byteBufferAllocate, 62L);
    }

    @Override // y9.c.b
    public c.a a(final long baseOffset, final int index) throws IOException {
        return new b(this.f56549m, this, baseOffset, index);
    }

    @Override // y9.c.b
    public c.AbstractC0667c b(final long index) throws IOException {
        return new h(this.f56549m, this, index);
    }

    @Override // y9.c.b
    public c.d c(final int index) throws IOException {
        return new j(this.f56549m, this, index);
    }
}
