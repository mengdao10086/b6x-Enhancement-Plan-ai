package okio;

import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&J \u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000fH&J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&J \u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH&J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bH&J\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH&J(\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\bH&J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\bH&J\u0010\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\bH&J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\bH&J\u0010\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0010H&J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0010H&J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0010H&J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0010H&J\b\u0010-\u001a\u00020,H&J\b\u0010.\u001a\u00020\u0000H&J\b\u0010/\u001a\u00020\u0000H&J\b\u00101\u001a\u000200H&R\u0014\u00104\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Lokio/k;", "Lokio/r0;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/j;", "e", "Lokio/ByteString;", "byteString", "B1", "", w.c.R, "byteCount", "J", "", "source", "write", "Lokio/t0;", "", "X0", m9.h.A, "", w.b.f53669e, "H0", "beginIndex", "endIndex", "W0", "codePoint", "H", "Ljava/nio/charset/Charset;", "charset", "a1", "S1", "b", "writeByte", an.aB, "writeShort", "D0", "i", "writeInt", "c0", "v", "writeLong", "N", "W1", "Y0", "Lkotlin/z1;", "flush", i1.a.S4, "l0", "Ljava/io/OutputStream;", "a2", "g", "()Lokio/j;", "buffer", "okio"}, k = 1, mv = {1, 5, 1})
public interface k extends r0, WritableByteChannel {
    @yt.k
    k B1(@yt.k ByteString byteString) throws IOException;

    @yt.k
    k D0(int i10) throws IOException;

    @yt.k
    k E() throws IOException;

    @yt.k
    k H(int i10) throws IOException;

    @yt.k
    k H0(@yt.k String str) throws IOException;

    @yt.k
    k J(@yt.k ByteString byteString, int i10, int i11) throws IOException;

    @yt.k
    k N(long j10) throws IOException;

    @yt.k
    k S1(@yt.k String str, int i10, int i11, @yt.k Charset charset) throws IOException;

    @yt.k
    k W0(@yt.k String str, int i10, int i11) throws IOException;

    @yt.k
    k W1(long j10) throws IOException;

    long X0(@yt.k t0 t0Var) throws IOException;

    @yt.k
    k Y0(long j10) throws IOException;

    @yt.k
    k a1(@yt.k String str, @yt.k Charset charset) throws IOException;

    @yt.k
    OutputStream a2();

    @yt.k
    k c0(int i10) throws IOException;

    @kotlin.k(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @kotlin.t0(expression = "buffer", imports = {}))
    @yt.k
    j e();

    @Override // okio.r0, java.io.Flushable
    void flush() throws IOException;

    @yt.k
    j g();

    @yt.k
    k g1(@yt.k t0 t0Var, long j10) throws IOException;

    @yt.k
    k l0() throws IOException;

    @yt.k
    k write(@yt.k byte[] bArr) throws IOException;

    @yt.k
    k write(@yt.k byte[] bArr, int i10, int i11) throws IOException;

    @yt.k
    k writeByte(int i10) throws IOException;

    @yt.k
    k writeInt(int i10) throws IOException;

    @yt.k
    k writeLong(long j10) throws IOException;

    @yt.k
    k writeShort(int i10) throws IOException;
}
