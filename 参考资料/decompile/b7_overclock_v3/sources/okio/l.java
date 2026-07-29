package okio;

import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\b\u0010\u0017\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH&J\b\u0010 \u001a\u00020\u001fH&J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001fH&J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001fH&J \u0010#\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011H&J\u0018\u0010&\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020'H&J\b\u0010*\u001a\u00020)H&J\u0010\u0010+\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0007H&J\n\u0010,\u001a\u0004\u0018\u00010)H&J\b\u0010-\u001a\u00020)H&J\u0010\u0010/\u001a\u00020)2\u0006\u0010.\u001a\u00020\u0007H&J\b\u00100\u001a\u00020\u0011H&J\u0010\u00103\u001a\u00020)2\u0006\u00102\u001a\u000201H&J\u0018\u00104\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00102\u001a\u000201H&J\u0010\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\fH&J\u0018\u00108\u001a\u00020\u00072\u0006\u00105\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0007H&J \u0010:\u001a\u00020\u00072\u0006\u00105\u001a\u00020\f2\u0006\u00107\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H&J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0019H&J\u0018\u0010=\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0007H&J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0019H&J\u0018\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0007H&J\u0018\u0010A\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0019H&J(\u0010C\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011H&J\b\u0010D\u001a\u00020\u0000H&J\b\u0010F\u001a\u00020EH&R\u0014\u0010I\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010Hø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006JÀ\u0006\u0001"}, d2 = {"Lokio/l;", "Lokio/t0;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/j;", "e", "", "d0", "", "byteCount", "Lkotlin/z1;", "U1", SocialConstants.TYPE_REQUEST, "", "readByte", "", "readShort", "E1", "", "readInt", m9.h.f40773p, "readLong", "H1", "n0", "d2", com.google.android.material.timepicker.d.C2, "Lokio/ByteString;", "Z0", "y", "Lokio/i0;", "options", "g2", "", i1.a.R4, "w1", "sink", "read", "readFully", w.c.R, "g0", "Lokio/r0;", "J1", "", "y1", "q", xf.k0.f55262g, "n1", "limit", "r0", "U0", "Ljava/nio/charset/Charset;", "charset", "O0", "A1", "b", "b2", "fromIndex", "f0", "toIndex", "h0", "bytes", i1.a.X4, an.aB, "targetBytes", "j0", "T1", "N0", "bytesOffset", "r1", "peek", "Ljava/io/InputStream;", "e2", "g", "()Lokio/j;", "buffer", "okio"}, k = 1, mv = {1, 5, 1})
public interface l extends t0, ReadableByteChannel {
    @yt.k
    String A1(long j10, @yt.k Charset charset) throws IOException;

    short E1() throws IOException;

    long H1() throws IOException;

    long J1(@yt.k r0 r0Var) throws IOException;

    boolean N0(long j10, @yt.k ByteString byteString) throws IOException;

    @yt.k
    String O0(@yt.k Charset charset) throws IOException;

    @yt.k
    byte[] S() throws IOException;

    long T1(@yt.k ByteString byteString, long j10) throws IOException;

    int U0() throws IOException;

    void U1(long j10) throws IOException;

    long V(@yt.k ByteString byteString) throws IOException;

    @yt.k
    ByteString Z0() throws IOException;

    long b2(byte b10) throws IOException;

    boolean d0() throws IOException;

    long d2() throws IOException;

    @kotlin.k(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @kotlin.t0(expression = "buffer", imports = {}))
    @yt.k
    j e();

    @yt.k
    InputStream e2();

    long f0(byte b10, long j10) throws IOException;

    @yt.k
    j g();

    void g0(@yt.k j jVar, long j10) throws IOException;

    int g2(@yt.k i0 i0Var) throws IOException;

    long h0(byte b10, long j10, long j11) throws IOException;

    long j0(@yt.k ByteString byteString) throws IOException;

    @yt.l
    String k0() throws IOException;

    long n0() throws IOException;

    @yt.k
    String n1() throws IOException;

    @yt.k
    l peek();

    @yt.k
    String q(long j10) throws IOException;

    int q1() throws IOException;

    @yt.k
    String r0(long j10) throws IOException;

    boolean r1(long j10, @yt.k ByteString byteString, int i10, int i11) throws IOException;

    int read(@yt.k byte[] bArr) throws IOException;

    int read(@yt.k byte[] bArr, int i10, int i11) throws IOException;

    byte readByte() throws IOException;

    void readFully(@yt.k byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j10) throws IOException;

    long s(@yt.k ByteString byteString, long j10) throws IOException;

    void skip(long j10) throws IOException;

    @yt.k
    byte[] w1(long j10) throws IOException;

    @yt.k
    ByteString y(long j10) throws IOException;

    @yt.k
    String y1() throws IOException;
}
