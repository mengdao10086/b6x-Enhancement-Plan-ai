package y9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y9.c;

/* JADX INFO: loaded from: classes3.dex */
public class i extends c.d {
    public i(final f parser, final c.b header, final int index) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(header.f56532a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f56547a = parser.m(byteBufferAllocate, header.f56535d + ((long) (index * header.f56538g)) + 28);
    }
}
