package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final l f37813a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37814b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CharsetDecoder f37815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f37816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final byte[] f37817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final char[] f37818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final ByteBuffer f37819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final CharBuffer f37820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final StringBuilder f37821i;

    static {
        byte[] bArr = new byte[32];
        f37817e = bArr;
        char[] cArr = new char[32];
        f37818f = cArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        f0.o(byteBufferWrap, "wrap(bytes)");
        f37819g = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        f0.o(charBufferWrap, "wrap(chars)");
        f37820h = charBufferWrap;
        f37821i = new StringBuilder();
    }

    public final int a() {
        ByteBuffer byteBuffer = f37819g;
        byteBuffer.compact();
        int iPosition = byteBuffer.position();
        byteBuffer.position(0);
        return iPosition;
    }

    public final int b(boolean z10) throws CharacterCodingException {
        while (true) {
            CharsetDecoder charsetDecoder = f37815c;
            if (charsetDecoder == null) {
                f0.S("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f37819g;
            CharBuffer charBuffer = f37820h;
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, z10);
            f0.o(coderResultDecode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (coderResultDecode.isError()) {
                e();
                coderResultDecode.throwException();
            }
            int iPosition = charBuffer.position();
            if (!coderResultDecode.isOverflow()) {
                return iPosition;
            }
            StringBuilder sb2 = f37821i;
            char[] cArr = f37818f;
            int i10 = iPosition - 1;
            sb2.append(cArr, 0, i10);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i10]);
        }
    }

    public final int c(int i10, int i11) throws CharacterCodingException {
        ByteBuffer byteBuffer = f37819g;
        byteBuffer.limit(i10);
        f37820h.position(i11);
        int iB = b(true);
        CharsetDecoder charsetDecoder = f37815c;
        if (charsetDecoder == null) {
            f0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return iB;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        if (r11 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        r0 = kotlin.io.l.f37818f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        if (r0[r11 - 1] != '\n') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        r11 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
    
        if (r11 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
    
        if (r0[r11 - 1] != '\r') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        r11 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
    
        r0 = kotlin.io.l.f37821i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
    
        if (r0.length() != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009b, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        if (r7 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a6, code lost:
    
        return new java.lang.String(kotlin.io.l.f37818f, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
    
        r0.append(kotlin.io.l.f37818f, 0, r11);
        r11 = r0.toString();
        kotlin.jvm.internal.f0.o(r11, "sb.toString()");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b9, code lost:
    
        if (r0.length() <= 32) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bb, code lost:
    
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00be, code lost:
    
        r0.setLength(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c2, code lost:
    
        return r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022 A[Catch: all -> 0x00c9, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0012, B:7:0x0018, B:11:0x0028, B:13:0x0034, B:22:0x0047, B:36:0x007c, B:38:0x0084, B:40:0x0088, B:42:0x0090, B:43:0x0092, B:48:0x009e, B:51:0x00a7, B:53:0x00bb, B:54:0x00be, B:23:0x004c, B:26:0x0057, B:30:0x005e, B:32:0x006e, B:34:0x0076, B:57:0x00c3, B:9:0x0022), top: B:62:0x0001 }] */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.lang.String d(@yt.k java.io.InputStream r11, @yt.k java.nio.charset.Charset r12) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.l.d(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    public final void e() {
        CharsetDecoder charsetDecoder = f37815c;
        if (charsetDecoder == null) {
            f0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f37819g.position(0);
        f37821i.setLength(0);
    }

    public final void f() {
        StringBuilder sb2 = f37821i;
        sb2.setLength(32);
        sb2.trimToSize();
    }

    public final void g(Charset charset) {
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        f0.o(charsetDecoderNewDecoder, "charset.newDecoder()");
        f37815c = charsetDecoderNewDecoder;
        ByteBuffer byteBuffer = f37819g;
        byteBuffer.clear();
        CharBuffer charBuffer = f37820h;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f37815c;
        if (charsetDecoder == null) {
            f0.S("decoder");
            charsetDecoder = null;
        }
        boolean z10 = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z10 = true;
        }
        f37816d = z10;
        e();
    }
}
