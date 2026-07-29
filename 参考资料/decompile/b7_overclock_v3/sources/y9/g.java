package y9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class g extends c.AbstractC0667c {
    public g(final f parser, final c.b header, final long index) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(header.f56532a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j10 = header.f56534c + (index * ((long) header.f56536e));
        this.f56543a = parser.m(byteBufferAllocate, j10);
        this.f56544b = parser.m(byteBufferAllocate, 4 + j10);
        this.f56545c = parser.m(byteBufferAllocate, 8 + j10);
        this.f56546d = parser.m(byteBufferAllocate, j10 + 20);
    }
}
