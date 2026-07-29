package okio;

import com.blankj.utilcode.util.ThreadUtils;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.DeprecationLevel;
import okhttp3.internal.connection.RealConnection;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u009d\u0001B\t¢\u0006\u0006\b«\u0001\u0010¬\u0001J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0001H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J$\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J \u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u0007J\u001a\u0010\"\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010$\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J\b\u0010'\u001a\u00020&H\u0016J\u0018\u0010)\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b)\u0010*J\b\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u000fH\u0016J\u0010\u00106\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u00109\u001a\u00020-2\u0006\u00108\u001a\u000207H\u0016J\u0018\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010:\u001a\u00020<H\u0016J\b\u0010>\u001a\u00020\rH\u0016J\u0010\u0010?\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010C\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010A\u001a\u00020@H\u0016J\n\u0010D\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010E\u001a\u00020\rH\u0016J\u0010\u0010G\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0007H\u0016J\b\u0010H\u001a\u00020-H\u0016J\b\u0010J\u001a\u00020IH\u0016J\u0010\u0010K\u001a\u00020I2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010L\u001a\u00020-2\u0006\u0010:\u001a\u00020IH\u0016J\u0010\u0010M\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020IH\u0016J \u0010L\u001a\u00020-2\u0006\u0010:\u001a\u00020I2\u0006\u0010\u001e\u001a\u00020-2\u0006\u0010\b\u001a\u00020-H\u0016J\u0010\u0010L\u001a\u00020-2\u0006\u0010:\u001a\u00020NH\u0016J\u0006\u0010O\u001a\u00020\u000bJ\u0010\u0010P\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u000fH\u0016J \u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020-2\u0006\u0010\b\u001a\u00020-H\u0016J\u0010\u0010U\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\rH\u0016J \u0010X\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\r2\u0006\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020-H\u0016J\u0010\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020-H\u0016J\u0018\u0010[\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\r2\u0006\u0010A\u001a\u00020@H\u0016J(\u0010\\\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\r2\u0006\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020-2\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010]\u001a\u00020IH\u0016J \u0010_\u001a\u00020\u00002\u0006\u0010]\u001a\u00020I2\u0006\u0010\u001e\u001a\u00020-2\u0006\u0010\b\u001a\u00020-H\u0016J\u0010\u0010`\u001a\u00020-2\u0006\u0010]\u001a\u00020NH\u0016J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010]\u001a\u00020aH\u0016J\u0018\u0010c\u001a\u00020\u00002\u0006\u0010]\u001a\u00020a2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010e\u001a\u00020\u00002\u0006\u0010d\u001a\u00020-H\u0016J\u0010\u0010g\u001a\u00020\u00002\u0006\u0010f\u001a\u00020-H\u0016J\u0010\u0010h\u001a\u00020\u00002\u0006\u0010f\u001a\u00020-H\u0016J\u0010\u0010j\u001a\u00020\u00002\u0006\u0010i\u001a\u00020-H\u0016J\u0010\u0010k\u001a\u00020\u00002\u0006\u0010i\u001a\u00020-H\u0016J\u0010\u0010m\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0007H\u0016J\u0010\u0010n\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0007H\u0016J\u0010\u0010o\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0007H\u0016J\u0010\u0010p\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0007H\u0016J\u0017\u0010s\u001a\u00020r2\u0006\u0010q\u001a\u00020-H\u0000¢\u0006\u0004\bs\u0010tJ\u0018\u0010u\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010v\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010w\u001a\u00020\u00072\u0006\u0010d\u001a\u00020&H\u0016J\u0018\u0010y\u001a\u00020\u00072\u0006\u0010d\u001a\u00020&2\u0006\u0010x\u001a\u00020\u0007H\u0016J \u0010{\u001a\u00020\u00072\u0006\u0010d\u001a\u00020&2\u0006\u0010x\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u0007H\u0016J\u0010\u0010}\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020\u0007H\u0016J\u0010\u0010\u007f\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u000fH\u0016J\u0019\u0010\u0080\u0001\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020\u0007H\u0016J\u0019\u0010\u0081\u0001\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u000fH\u0016J*\u0010\u0083\u0001\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u000f2\u0007\u0010\u0082\u0001\u001a\u00020-2\u0006\u0010\b\u001a\u00020-H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0085\u0001\u001a\u00020\tH\u0016J\t\u0010\u0086\u0001\u001a\u00020\u000bH\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0087\u0001H\u0016J\u0007\u0010\u0089\u0001\u001a\u00020\u000fJ\u0007\u0010\u008a\u0001\u001a\u00020\u000fJ\u0007\u0010\u008b\u0001\u001a\u00020\u000fJ\u0007\u0010\u008c\u0001\u001a\u00020\u000fJ\u000f\u0010\u008d\u0001\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000f\u0010\u008e\u0001\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000f\u0010\u008f\u0001\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0092\u0001\u001a\u00020\t2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0096\u0002J\t\u0010\u0093\u0001\u001a\u00020-H\u0016J\t\u0010\u0094\u0001\u001a\u00020\rH\u0016J\u0006\u0010i\u001a\u00020\u0000J\t\u0010\u0095\u0001\u001a\u00020\u0000H\u0016J\u0007\u0010\u0096\u0001\u001a\u00020\u000fJ\u000f\u0010\u0097\u0001\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020-J\u0016\u0010\u009a\u0001\u001a\u00030\u0098\u00012\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0098\u0001H\u0007J\u0016\u0010\u009b\u0001\u001a\u00030\u0098\u00012\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u0098\u0001H\u0007J\u001a\u0010\u009d\u0001\u001a\u00020&2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\b\u009d\u0001\u0010*J\u0012\u0010\u009e\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010 \u0001R1\u0010§\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u00078G@@X\u0086\u000e¢\u0006\u0017\n\u0005\bd\u0010£\u0001\u001a\u0006\b¤\u0001\u0010\u009f\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u0017\u0010ª\u0001\u001a\u00020\u00008VX\u0096\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lokio/j;", "Lokio/l;", "Lokio/k;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/InputStream;", "input", "", "byteCount", "", "forever", "Lkotlin/z1;", "V1", "", "algorithm", "Lokio/ByteString;", "F0", "key", "h1", "e", "Ljava/io/OutputStream;", "a2", "M0", "G0", "d0", "U1", SocialConstants.TYPE_REQUEST, "peek", "e2", "out", w.c.R, m0.k.f40564b, "u", "n", "H2", "C1", "L1", "h", "", "readByte", "pos", m9.h.f40774q, "(J)B", "", "readShort", "", "readInt", "readLong", "E1", m9.h.f40773p, "H1", "n0", "d2", "Z0", "y", "Lokio/i0;", "options", "g2", "sink", "g0", "Lokio/r0;", "J1", "y1", "q", "Ljava/nio/charset/Charset;", "charset", "O0", "A1", xf.k0.f55262g, "n1", "limit", "r0", "U0", "", i1.a.R4, "w1", "read", "readFully", "Ljava/nio/ByteBuffer;", "d", com.google.android.material.timepicker.d.C2, "byteString", "q2", "r2", w.b.f53669e, "J2", "beginIndex", "endIndex", "K2", "codePoint", "L2", "F2", "E2", "source", "t2", "u2", "write", "Lokio/t0;", "X0", "s2", "b", "v2", an.aB, "C2", "D2", "i", "y2", "z2", "v", "A2", "B2", "w2", "x2", "minimumCapacity", "Lokio/p0;", "p2", "(I)Lokio/p0;", "V0", "F1", "b2", "fromIndex", "f0", "toIndex", "h0", "bytes", i1.a.X4, "targetBytes", "j0", "T1", "N0", "bytesOffset", "r1", "flush", "isOpen", "close", "Lokio/v0;", "U", "p1", "j2", m9.h.C, "l2", "i1", m9.h.B, "m1", "", "other", "equals", "hashCode", "toString", "f", "n2", "o2", "Lokio/j$a;", "unsafeCursor", "f2", "u1", "index", "a", "c", "()J", "Lokio/p0;", xc.d.f55085o, "<set-?>", "J", "m2", "i2", "(J)V", "size", "g", "()Lokio/j;", "buffer", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class j implements l, k, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.l
    public p0 f44116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f44117b;

    @kotlin.d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006&"}, d2 = {"Lokio/j$a;", "Ljava/io/Closeable;", "", "d", "", w.c.R, "h", "newSize", "f", "minByteCount", "a", "Lkotlin/z1;", "close", "Lokio/j;", "Lokio/j;", "buffer", "", "b", "Z", "readWrite", "Lokio/p0;", "c", "Lokio/p0;", "()Lokio/p0;", "i", "(Lokio/p0;)V", "segment", "J", "", "e", "[B", "data", "I", xc.d.f55084n0, "g", "end", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        @yt.l
        public j f44118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        public boolean f44119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public p0 f44120c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @hk.e
        @yt.l
        public byte[] f44122e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @hk.e
        public long f44121d = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @hk.e
        public int f44123f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @hk.e
        public int f44124g = -1;

        public final long a(int i10) {
            if (!(i10 > 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("minByteCount <= 0: ", Integer.valueOf(i10)).toString());
            }
            if (!(i10 <= 8192)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("minByteCount > Segment.SIZE: ", Integer.valueOf(i10)).toString());
            }
            j jVar = this.f44118a;
            if (jVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f44119b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long jM2 = jVar.m2();
            p0 p0VarP2 = jVar.p2(i10);
            int i11 = 8192 - p0VarP2.f44176c;
            p0VarP2.f44176c = 8192;
            long j10 = i11;
            jVar.i2(jM2 + j10);
            i(p0VarP2);
            this.f44121d = jM2;
            this.f44122e = p0VarP2.f44174a;
            this.f44123f = 8192 - i11;
            this.f44124g = 8192;
            return j10;
        }

        @yt.l
        public final p0 c() {
            return this.f44120c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f44118a != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f44118a = null;
            i(null);
            this.f44121d = -1L;
            this.f44122e = null;
            this.f44123f = -1;
            this.f44124g = -1;
        }

        public final int d() {
            long j10 = this.f44121d;
            j jVar = this.f44118a;
            kotlin.jvm.internal.f0.m(jVar);
            if (!(j10 != jVar.m2())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j11 = this.f44121d;
            return h(j11 == -1 ? 0L : j11 + ((long) (this.f44124g - this.f44123f)));
        }

        public final long f(long j10) {
            j jVar = this.f44118a;
            if (jVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f44119b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long jM2 = jVar.m2();
            int i10 = 1;
            if (j10 <= jM2) {
                if (!(j10 >= 0)) {
                    throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("newSize < 0: ", Long.valueOf(j10)).toString());
                }
                long j11 = jM2 - j10;
                while (true) {
                    if (j11 <= 0) {
                        break;
                    }
                    p0 p0Var = jVar.f44116a;
                    kotlin.jvm.internal.f0.m(p0Var);
                    p0 p0Var2 = p0Var.f44180g;
                    kotlin.jvm.internal.f0.m(p0Var2);
                    int i11 = p0Var2.f44176c;
                    long j12 = i11 - p0Var2.f44175b;
                    if (j12 > j11) {
                        p0Var2.f44176c = i11 - ((int) j11);
                        break;
                    }
                    jVar.f44116a = p0Var2.b();
                    q0.d(p0Var2);
                    j11 -= j12;
                }
                i(null);
                this.f44121d = j10;
                this.f44122e = null;
                this.f44123f = -1;
                this.f44124g = -1;
            } else if (j10 > jM2) {
                long j13 = j10 - jM2;
                boolean z10 = true;
                while (j13 > 0) {
                    p0 p0VarP2 = jVar.p2(i10);
                    int iMin = (int) Math.min(j13, 8192 - p0VarP2.f44176c);
                    p0VarP2.f44176c += iMin;
                    j13 -= (long) iMin;
                    if (z10) {
                        i(p0VarP2);
                        this.f44121d = jM2;
                        this.f44122e = p0VarP2.f44174a;
                        int i12 = p0VarP2.f44176c;
                        this.f44123f = i12 - iMin;
                        this.f44124g = i12;
                        i10 = 1;
                        z10 = false;
                    } else {
                        i10 = 1;
                    }
                }
            }
            jVar.i2(j10);
            return jM2;
        }

        public final int h(long j10) {
            p0 p0VarC;
            j jVar = this.f44118a;
            if (jVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j10 < -1 || j10 > jVar.m2()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j10 + " > size=" + jVar.m2());
            }
            if (j10 == -1 || j10 == jVar.m2()) {
                i(null);
                this.f44121d = j10;
                this.f44122e = null;
                this.f44123f = -1;
                this.f44124g = -1;
                return -1;
            }
            long j11 = 0;
            long jM2 = jVar.m2();
            p0 p0VarC2 = jVar.f44116a;
            if (c() != null) {
                long j12 = this.f44121d;
                int i10 = this.f44123f;
                p0 p0VarC3 = c();
                kotlin.jvm.internal.f0.m(p0VarC3);
                long j13 = j12 - ((long) (i10 - p0VarC3.f44175b));
                if (j13 > j10) {
                    p0VarC2 = c();
                    jM2 = j13;
                    p0VarC = p0VarC2;
                } else {
                    p0VarC = c();
                    j11 = j13;
                }
            } else {
                p0VarC = p0VarC2;
            }
            if (jM2 - j10 > j10 - j11) {
                while (true) {
                    kotlin.jvm.internal.f0.m(p0VarC);
                    int i11 = p0VarC.f44176c;
                    int i12 = p0VarC.f44175b;
                    if (j10 < ((long) (i11 - i12)) + j11) {
                        break;
                    }
                    j11 += (long) (i11 - i12);
                    p0VarC = p0VarC.f44179f;
                }
            } else {
                while (jM2 > j10) {
                    kotlin.jvm.internal.f0.m(p0VarC2);
                    p0VarC2 = p0VarC2.f44180g;
                    kotlin.jvm.internal.f0.m(p0VarC2);
                    jM2 -= (long) (p0VarC2.f44176c - p0VarC2.f44175b);
                }
                j11 = jM2;
                p0VarC = p0VarC2;
            }
            if (this.f44119b) {
                kotlin.jvm.internal.f0.m(p0VarC);
                if (p0VarC.f44177d) {
                    p0 p0VarF = p0VarC.f();
                    if (jVar.f44116a == p0VarC) {
                        jVar.f44116a = p0VarF;
                    }
                    p0VarC = p0VarC.c(p0VarF);
                    p0 p0Var = p0VarC.f44180g;
                    kotlin.jvm.internal.f0.m(p0Var);
                    p0Var.b();
                }
            }
            i(p0VarC);
            this.f44121d = j10;
            kotlin.jvm.internal.f0.m(p0VarC);
            this.f44122e = p0VarC.f44174a;
            int i13 = p0VarC.f44175b + ((int) (j10 - j11));
            this.f44123f = i13;
            int i14 = p0VarC.f44176c;
            this.f44124g = i14;
            return i14 - i13;
        }

        public final void i(@yt.l p0 p0Var) {
            this.f44120c = p0Var;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"okio/j$c", "Ljava/io/OutputStream;", "", "b", "Lkotlin/z1;", "write", "", "data", w.c.R, "byteCount", "flush", "close", "", "toString", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        @yt.k
        public String toString() {
            return j.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            j.this.writeByte(i10);
        }

        @Override // java.io.OutputStream
        public void write(@yt.k byte[] data, int i10, int i11) {
            kotlin.jvm.internal.f0.p(data, "data");
            j.this.write(data, i10, i11);
        }
    }

    public static /* synthetic */ j I(j jVar, OutputStream outputStream, long j10, long j11, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = jVar.f44117b - j12;
        }
        return jVar.m(outputStream, j12, j11);
    }

    public static /* synthetic */ j I2(j jVar, OutputStream outputStream, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = jVar.f44117b;
        }
        return jVar.H2(outputStream, j10);
    }

    public static /* synthetic */ j L(j jVar, j jVar2, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return jVar.n(jVar2, j10);
    }

    public static /* synthetic */ j P(j jVar, j jVar2, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return jVar.u(jVar2, j10, j11);
    }

    public static /* synthetic */ a h2(j jVar, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = a1.g();
        }
        return jVar.f2(aVar);
    }

    public static /* synthetic */ a z1(j jVar, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = a1.g();
        }
        return jVar.u1(aVar);
    }

    @Override // okio.l
    @yt.k
    public String A1(long j10, @yt.k Charset charset) throws EOFException {
        kotlin.jvm.internal.f0.p(charset, "charset");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (this.f44117b < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        p0 p0Var = this.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44175b;
        if (((long) i10) + j10 > p0Var.f44176c) {
            return new String(w1(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(p0Var.f44174a, i10, i11, charset);
        int i12 = p0Var.f44175b + i11;
        p0Var.f44175b = i12;
        this.f44117b -= j10;
        if (i12 == p0Var.f44176c) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        }
        return str;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: A2, reason: merged with bridge method [inline-methods] */
    public j writeLong(long j10) {
        p0 p0VarP2 = p2(8);
        byte[] bArr = p0VarP2.f44174a;
        int i10 = p0VarP2.f44176c;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j10 >>> 48) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j10 >>> 40) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j10 >>> 32) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((j10 >>> 24) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((j10 >>> 16) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j10 >>> 8) & 255);
        bArr[i17] = (byte) (j10 & 255);
        p0VarP2.f44176c = i17 + 1;
        i2(m2() + 8);
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: B2, reason: merged with bridge method [inline-methods] */
    public j N(long j10) {
        return writeLong(a1.o(j10));
    }

    @yt.k
    public final j C1(@yt.k InputStream input) throws IOException {
        kotlin.jvm.internal.f0.p(input, "input");
        V1(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: C2, reason: merged with bridge method [inline-methods] */
    public j writeShort(int i10) {
        p0 p0VarP2 = p2(2);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        p0VarP2.f44176c = i12 + 1;
        i2(m2() + 2);
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: D2, reason: merged with bridge method [inline-methods] */
    public j D0(int i10) {
        return writeShort(a1.p((short) i10));
    }

    @Override // okio.l
    public short E1() throws EOFException {
        return a1.p(readShort());
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: E2, reason: merged with bridge method [inline-methods] */
    public j S1(@yt.k String string, int i10, int i11, @yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(string, "string");
        kotlin.jvm.internal.f0.p(charset, "charset");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.f0.g(charset, kotlin.text.d.f38161b)) {
            return W0(string, i10, i11);
        }
        String strSubstring = string.substring(i10, i11);
        kotlin.jvm.internal.f0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public final ByteString F0(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        p0 p0Var = this.f44116a;
        if (p0Var != null) {
            byte[] bArr = p0Var.f44174a;
            int i10 = p0Var.f44175b;
            messageDigest.update(bArr, i10, p0Var.f44176c - i10);
            p0 p0Var2 = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var2);
            while (p0Var2 != p0Var) {
                byte[] bArr2 = p0Var2.f44174a;
                int i11 = p0Var2.f44175b;
                messageDigest.update(bArr2, i11, p0Var2.f44176c - i11);
                p0Var2 = p0Var2.f44179f;
                kotlin.jvm.internal.f0.m(p0Var2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.f0.o(bArrDigest, "messageDigest.digest()");
        return new ByteString(bArrDigest);
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (m2() == 0) {
            return -1L;
        }
        if (j10 > m2()) {
            j10 = m2();
        }
        sink.V0(this, j10);
        return j10;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: F2, reason: merged with bridge method [inline-methods] */
    public j a1(@yt.k String string, @yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(string, "string");
        kotlin.jvm.internal.f0.p(charset, "charset");
        return S1(string, 0, string.length(), charset);
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public j E() {
        return this;
    }

    @hk.i
    @yt.k
    public final j G2(@yt.k OutputStream out) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        return I2(this, out, 0L, 2, null);
    }

    @Override // okio.l
    public long H1() throws EOFException {
        return a1.o(readLong());
    }

    @hk.i
    @yt.k
    public final j H2(@yt.k OutputStream out, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        a1.e(this.f44117b, 0L, j10);
        p0 p0Var = this.f44116a;
        while (j10 > 0) {
            kotlin.jvm.internal.f0.m(p0Var);
            int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
            out.write(p0Var.f44174a, p0Var.f44175b, iMin);
            int i10 = p0Var.f44175b + iMin;
            p0Var.f44175b = i10;
            long j11 = iMin;
            this.f44117b -= j11;
            j10 -= j11;
            if (i10 == p0Var.f44176c) {
                p0 p0VarB = p0Var.b();
                this.f44116a = p0VarB;
                q0.d(p0Var);
                p0Var = p0VarB;
            }
        }
        return this;
    }

    @Override // okio.l
    public long J1(@yt.k r0 sink) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        long jM2 = m2();
        if (jM2 > 0) {
            sink.V0(this, jM2);
        }
        return jM2;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: J2, reason: merged with bridge method [inline-methods] */
    public j H0(@yt.k String string) {
        kotlin.jvm.internal.f0.p(string, "string");
        return W0(string, 0, string.length());
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: K2, reason: merged with bridge method [inline-methods] */
    public j W0(@yt.k String string, int i10, int i11) {
        char cCharAt;
        kotlin.jvm.internal.f0.p(string, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        while (i10 < i11) {
            char cCharAt2 = string.charAt(i10);
            if (cCharAt2 < 128) {
                p0 p0VarP2 = p2(1);
                byte[] bArr = p0VarP2.f44174a;
                int i12 = p0VarP2.f44176c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = string.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = p0VarP2.f44176c;
                int i15 = (i12 + i10) - i14;
                p0VarP2.f44176c = i14 + i15;
                i2(m2() + ((long) i15));
            } else {
                if (cCharAt2 < 2048) {
                    p0 p0VarP22 = p2(2);
                    byte[] bArr2 = p0VarP22.f44174a;
                    int i16 = p0VarP22.f44176c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    p0VarP22.f44176c = i16 + 2;
                    i2(m2() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    p0 p0VarP23 = p2(3);
                    byte[] bArr3 = p0VarP23.f44174a;
                    int i17 = p0VarP23.f44176c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    p0VarP23.f44176c = i17 + 3;
                    i2(m2() + 3);
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    if (cCharAt2 <= 56319) {
                        if (56320 <= cCharAt3 && cCharAt3 <= 57343) {
                            int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            p0 p0VarP24 = p2(4);
                            byte[] bArr4 = p0VarP24.f44174a;
                            int i20 = p0VarP24.f44176c;
                            bArr4[i20] = (byte) ((i19 >> 18) | 240);
                            bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                            bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                            bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                            p0VarP24.f44176c = i20 + 4;
                            i2(m2() + 4);
                            i10 += 2;
                        }
                    }
                    writeByte(63);
                    i10 = i18;
                }
                i10++;
            }
        }
        return this;
    }

    @yt.k
    public final j L1(@yt.k InputStream input, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(input, "input");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        V1(input, j10, false);
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: L2, reason: merged with bridge method [inline-methods] */
    public j H(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            p0 p0VarP2 = p2(2);
            byte[] bArr = p0VarP2.f44174a;
            int i11 = p0VarP2.f44176c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            p0VarP2.f44176c = i11 + 2;
            i2(m2() + 2);
        } else {
            boolean z10 = false;
            if (55296 <= i10 && i10 <= 57343) {
                z10 = true;
            }
            if (z10) {
                writeByte(63);
            } else if (i10 < 65536) {
                p0 p0VarP22 = p2(3);
                byte[] bArr2 = p0VarP22.f44174a;
                int i12 = p0VarP22.f44176c;
                bArr2[i12] = (byte) ((i10 >> 12) | 224);
                bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
                p0VarP22.f44176c = i12 + 3;
                i2(m2() + 3);
            } else {
                if (i10 > 1114111) {
                    throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Unexpected code point: 0x", a1.u(i10)));
                }
                p0 p0VarP23 = p2(4);
                byte[] bArr3 = p0VarP23.f44174a;
                int i13 = p0VarP23.f44176c;
                bArr3[i13] = (byte) ((i10 >> 18) | 240);
                bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
                p0VarP23.f44176c = i13 + 4;
                i2(m2() + 4);
            }
        }
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public j l0() {
        return this;
    }

    @Override // okio.l
    public boolean N0(long j10, @yt.k ByteString bytes) {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        return r1(j10, bytes, 0, bytes.x0());
    }

    @Override // okio.l
    @yt.k
    public String O0(@yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(charset, "charset");
        return A1(this.f44117b, charset);
    }

    @Override // okio.l
    @yt.k
    public byte[] S() {
        return w1(m2());
    }

    @Override // okio.l
    public long T1(@yt.k ByteString targetBytes, long j10) {
        int i10;
        int i11;
        kotlin.jvm.internal.f0.p(targetBytes, "targetBytes");
        long jM2 = 0;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("fromIndex < 0: ", Long.valueOf(j10)).toString());
        }
        p0 p0Var = this.f44116a;
        if (p0Var == null) {
            return -1L;
        }
        if (m2() - j10 < j10) {
            jM2 = m2();
            while (jM2 > j10) {
                p0Var = p0Var.f44180g;
                kotlin.jvm.internal.f0.m(p0Var);
                jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            if (targetBytes.x0() == 2) {
                byte bV = targetBytes.v(0);
                byte bV2 = targetBytes.v(1);
                while (jM2 < m2()) {
                    byte[] bArr = p0Var.f44174a;
                    i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                    int i12 = p0Var.f44176c;
                    while (i10 < i12) {
                        byte b10 = bArr[i10];
                        if (b10 == bV || b10 == bV2) {
                            i11 = p0Var.f44175b;
                        } else {
                            i10++;
                        }
                    }
                    jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                    p0Var = p0Var.f44179f;
                    kotlin.jvm.internal.f0.m(p0Var);
                    j10 = jM2;
                }
                return -1L;
            }
            byte[] bArrO = targetBytes.O();
            while (jM2 < m2()) {
                byte[] bArr2 = p0Var.f44174a;
                i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                int i13 = p0Var.f44176c;
                while (i10 < i13) {
                    byte b11 = bArr2[i10];
                    int length = bArrO.length;
                    int i14 = 0;
                    while (i14 < length) {
                        byte b12 = bArrO[i14];
                        i14++;
                        if (b11 == b12) {
                            i11 = p0Var.f44175b;
                        }
                    }
                    i10++;
                }
                jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                kotlin.jvm.internal.f0.m(p0Var);
                j10 = jM2;
            }
            return -1L;
        }
        while (true) {
            long j11 = ((long) (p0Var.f44176c - p0Var.f44175b)) + jM2;
            if (j11 > j10) {
                break;
            }
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
            jM2 = j11;
        }
        if (targetBytes.x0() == 2) {
            byte bV3 = targetBytes.v(0);
            byte bV4 = targetBytes.v(1);
            while (jM2 < m2()) {
                byte[] bArr3 = p0Var.f44174a;
                i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                int i15 = p0Var.f44176c;
                while (i10 < i15) {
                    byte b13 = bArr3[i10];
                    if (b13 == bV3 || b13 == bV4) {
                        i11 = p0Var.f44175b;
                    } else {
                        i10++;
                    }
                }
                jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                kotlin.jvm.internal.f0.m(p0Var);
                j10 = jM2;
            }
            return -1L;
        }
        byte[] bArrO2 = targetBytes.O();
        while (jM2 < m2()) {
            byte[] bArr4 = p0Var.f44174a;
            i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
            int i16 = p0Var.f44176c;
            while (i10 < i16) {
                byte b14 = bArr4[i10];
                int length2 = bArrO2.length;
                int i17 = 0;
                while (i17 < length2) {
                    byte b15 = bArrO2[i17];
                    i17++;
                    if (b14 == b15) {
                        i11 = p0Var.f44175b;
                    }
                }
                i10++;
            }
            jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
            j10 = jM2;
        }
        return -1L;
        return ((long) (i10 - i11)) + jM2;
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return v0.f44220e;
    }

    @Override // okio.l
    public int U0() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (m2() == 0) {
            throw new EOFException();
        }
        byte bD1 = d1(0L);
        boolean z10 = false;
        if ((bD1 & 128) == 0) {
            i10 = bD1 & 127;
            i11 = 1;
            i12 = 0;
        } else if ((bD1 & 224) == 192) {
            i10 = bD1 & 31;
            i11 = 2;
            i12 = 128;
        } else if ((bD1 & 240) == 224) {
            i10 = bD1 & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((bD1 & ThreadUtils.f11619i) != 240) {
                skip(1L);
                return w0.f44231c;
            }
            i10 = bD1 & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (m2() < j10) {
            throw new EOFException("size < " + i11 + ": " + m2() + " (to read code point prefixed 0x" + a1.t(bD1) + ')');
        }
        if (1 < i11) {
            int i13 = 1;
            while (true) {
                int i14 = i13 + 1;
                long j11 = i13;
                byte bD12 = d1(j11);
                if ((bD12 & i1.a.f31667o7) != 128) {
                    skip(j11);
                    return w0.f44231c;
                }
                i10 = (i10 << 6) | (bD12 & w0.f44229a);
                if (i14 >= i11) {
                    break;
                }
                i13 = i14;
            }
        }
        skip(j10);
        if (i10 > 1114111) {
            return w0.f44231c;
        }
        if (55296 <= i10 && i10 <= 57343) {
            z10 = true;
        }
        return (!z10 && i10 >= i12) ? i10 : w0.f44231c;
    }

    @Override // okio.l
    public void U1(long j10) throws EOFException {
        if (this.f44117b < j10) {
            throw new EOFException();
        }
    }

    @Override // okio.l
    public long V(@yt.k ByteString bytes) throws IOException {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        return s(bytes, 0L);
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) {
        p0 p0Var;
        kotlin.jvm.internal.f0.p(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        a1.e(source.m2(), 0L, j10);
        while (j10 > 0) {
            p0 p0Var2 = source.f44116a;
            kotlin.jvm.internal.f0.m(p0Var2);
            int i10 = p0Var2.f44176c;
            kotlin.jvm.internal.f0.m(source.f44116a);
            if (j10 < i10 - r2.f44175b) {
                p0 p0Var3 = this.f44116a;
                if (p0Var3 != null) {
                    kotlin.jvm.internal.f0.m(p0Var3);
                    p0Var = p0Var3.f44180g;
                } else {
                    p0Var = null;
                }
                if (p0Var != null && p0Var.f44178e) {
                    if ((((long) p0Var.f44176c) + j10) - ((long) (p0Var.f44177d ? 0 : p0Var.f44175b)) <= 8192) {
                        p0 p0Var4 = source.f44116a;
                        kotlin.jvm.internal.f0.m(p0Var4);
                        p0Var4.g(p0Var, (int) j10);
                        source.i2(source.m2() - j10);
                        i2(m2() + j10);
                        return;
                    }
                }
                p0 p0Var5 = source.f44116a;
                kotlin.jvm.internal.f0.m(p0Var5);
                source.f44116a = p0Var5.e((int) j10);
            }
            p0 p0Var6 = source.f44116a;
            kotlin.jvm.internal.f0.m(p0Var6);
            long j11 = p0Var6.f44176c - p0Var6.f44175b;
            source.f44116a = p0Var6.b();
            p0 p0Var7 = this.f44116a;
            if (p0Var7 == null) {
                this.f44116a = p0Var6;
                p0Var6.f44180g = p0Var6;
                p0Var6.f44179f = p0Var6;
            } else {
                kotlin.jvm.internal.f0.m(p0Var7);
                p0 p0Var8 = p0Var7.f44180g;
                kotlin.jvm.internal.f0.m(p0Var8);
                p0Var8.c(p0Var6).a();
            }
            source.i2(source.m2() - j11);
            i2(m2() + j11);
            j10 -= j11;
        }
    }

    public final void V1(InputStream inputStream, long j10, boolean z10) throws IOException {
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            p0 p0VarP2 = p2(1);
            int i10 = inputStream.read(p0VarP2.f44174a, p0VarP2.f44176c, (int) Math.min(j10, 8192 - p0VarP2.f44176c));
            if (i10 == -1) {
                if (p0VarP2.f44175b == p0VarP2.f44176c) {
                    this.f44116a = p0VarP2.b();
                    q0.d(p0VarP2);
                }
                if (!z10) {
                    throw new EOFException();
                }
                return;
            }
            p0VarP2.f44176c += i10;
            long j11 = i10;
            this.f44117b += j11;
            j10 -= j11;
        }
    }

    @Override // okio.k
    public long X0(@yt.k t0 source) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        long j10 = 0;
        while (true) {
            long jF1 = source.F1(this, 8192L);
            if (jF1 == -1) {
                return j10;
            }
            j10 += jF1;
        }
    }

    @hk.i
    @yt.k
    public final a Y1() {
        return h2(this, null, 1, null);
    }

    @Override // okio.l
    @yt.k
    public ByteString Z0() {
        return y(m2());
    }

    @hk.h(name = "-deprecated_getByte")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @kotlin.t0(expression = "this[index]", imports = {}))
    public final byte a(long j10) {
        return d1(j10);
    }

    @Override // okio.k
    @yt.k
    public OutputStream a2() {
        return new c();
    }

    @Override // okio.l
    public long b2(byte b10) {
        return h0(b10, 0L, Long.MAX_VALUE);
    }

    @hk.h(name = "-deprecated_size")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "size", imports = {}))
    public final long c() {
        return this.f44117b;
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void d() throws EOFException {
        skip(m2());
    }

    @Override // okio.l
    public boolean d0() {
        return this.f44117b == 0;
    }

    @hk.h(name = "getByte")
    public final byte d1(long j10) {
        a1.e(m2(), j10, 1L);
        p0 p0Var = this.f44116a;
        if (p0Var == null) {
            kotlin.jvm.internal.f0.m(null);
            throw null;
        }
        if (m2() - j10 < j10) {
            long jM2 = m2();
            while (jM2 > j10) {
                p0Var = p0Var.f44180g;
                kotlin.jvm.internal.f0.m(p0Var);
                jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            kotlin.jvm.internal.f0.m(p0Var);
            return p0Var.f44174a[(int) ((((long) p0Var.f44175b) + j10) - jM2)];
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (p0Var.f44176c - p0Var.f44175b)) + j11;
            if (j12 > j10) {
                kotlin.jvm.internal.f0.m(p0Var);
                return p0Var.f44174a[(int) ((((long) p0Var.f44175b) + j10) - j11)];
            }
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
            j11 = j12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098 A[EDGE_INSN: B:43:0x0098->B:37:0x0098 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // okio.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long d2() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.m2()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La2
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.p0 r6 = r15.f44116a
            kotlin.jvm.internal.f0.m(r6)
            byte[] r7 = r6.f44174a
            int r8 = r6.f44175b
            int r9 = r6.f44176c
        L18:
            if (r8 >= r9) goto L84
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L70
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L70
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            okio.j r0 = new okio.j
            r0.<init>()
            okio.j r0 = r0.Y0(r4)
            okio.j r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.y1()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = kotlin.jvm.internal.f0.C(r2, r0)
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L84
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = okio.a1.t(r10)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = kotlin.jvm.internal.f0.C(r2, r1)
            r0.<init>(r1)
            throw r0
        L84:
            if (r8 != r9) goto L90
            okio.p0 r7 = r6.b()
            r15.f44116a = r7
            okio.q0.d(r6)
            goto L92
        L90:
            r6.f44175b = r8
        L92:
            if (r1 != 0) goto L98
            okio.p0 r6 = r15.f44116a
            if (r6 != 0) goto Ld
        L98:
            long r1 = r15.m2()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.i2(r1)
            return r4
        La2:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.j.d2():long");
    }

    @Override // okio.l, okio.k
    @yt.k
    public j e() {
        return this;
    }

    @Override // okio.l
    @yt.k
    public InputStream e2() {
        return new b();
    }

    public boolean equals(@yt.l Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (m2() != jVar.m2()) {
                return false;
            }
            if (m2() != 0) {
                p0 p0Var = this.f44116a;
                kotlin.jvm.internal.f0.m(p0Var);
                p0 p0Var2 = jVar.f44116a;
                kotlin.jvm.internal.f0.m(p0Var2);
                int i10 = p0Var.f44175b;
                int i11 = p0Var2.f44175b;
                long j10 = 0;
                while (j10 < m2()) {
                    long jMin = Math.min(p0Var.f44176c - i10, p0Var2.f44176c - i11);
                    if (0 < jMin) {
                        long j11 = 0;
                        while (true) {
                            j11++;
                            int i12 = i10 + 1;
                            int i13 = i11 + 1;
                            if (p0Var.f44174a[i10] != p0Var2.f44174a[i11]) {
                                return false;
                            }
                            if (j11 >= jMin) {
                                i10 = i12;
                                i11 = i13;
                                break;
                            }
                            i10 = i12;
                            i11 = i13;
                        }
                    }
                    if (i10 == p0Var.f44176c) {
                        p0Var = p0Var.f44179f;
                        kotlin.jvm.internal.f0.m(p0Var);
                        i10 = p0Var.f44175b;
                    }
                    if (i11 == p0Var2.f44176c) {
                        p0Var2 = p0Var2.f44179f;
                        kotlin.jvm.internal.f0.m(p0Var2);
                        i11 = p0Var2.f44175b;
                    }
                    j10 += jMin;
                }
            }
        }
        return true;
    }

    @yt.k
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public j clone() {
        return i();
    }

    @Override // okio.l
    public long f0(byte b10, long j10) {
        return h0(b10, j10, Long.MAX_VALUE);
    }

    @hk.i
    @yt.k
    public final a f2(@yt.k a unsafeCursor) {
        kotlin.jvm.internal.f0.p(unsafeCursor, "unsafeCursor");
        return okio.internal.d.F(this, unsafeCursor);
    }

    @Override // okio.k, okio.r0, java.io.Flushable
    public void flush() {
    }

    @Override // okio.l, okio.k
    @yt.k
    public j g() {
        return this;
    }

    @Override // okio.l
    public void g0(@yt.k j sink, long j10) throws EOFException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (m2() >= j10) {
            sink.V0(this, j10);
        } else {
            sink.V0(this, m2());
            throw new EOFException();
        }
    }

    @Override // okio.l
    public int g2(@yt.k i0 options) throws EOFException {
        kotlin.jvm.internal.f0.p(options, "options");
        int iM0 = okio.internal.d.m0(this, options, false, 2, null);
        if (iM0 == -1) {
            return -1;
        }
        skip(options.l()[iM0].x0());
        return iM0;
    }

    public final long h() {
        long jM2 = m2();
        if (jM2 == 0) {
            return 0L;
        }
        p0 p0Var = this.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        p0 p0Var2 = p0Var.f44180g;
        kotlin.jvm.internal.f0.m(p0Var2);
        int i10 = p0Var2.f44176c;
        if (i10 < 8192 && p0Var2.f44178e) {
            jM2 -= (long) (i10 - p0Var2.f44175b);
        }
        return jM2;
    }

    @Override // okio.l
    public long h0(byte b10, long j10, long j11) {
        p0 p0Var;
        int i10;
        long j12 = j10;
        long jM2 = j11;
        boolean z10 = false;
        long jM22 = 0;
        if (0 <= j12 && j12 <= jM2) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("size=" + m2() + " fromIndex=" + j12 + " toIndex=" + jM2).toString());
        }
        if (jM2 > m2()) {
            jM2 = m2();
        }
        long j13 = jM2;
        if (j12 == j13 || (p0Var = this.f44116a) == null) {
            return -1L;
        }
        if (m2() - j12 < j12) {
            jM22 = m2();
            while (jM22 > j12) {
                p0Var = p0Var.f44180g;
                kotlin.jvm.internal.f0.m(p0Var);
                jM22 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            while (jM22 < j13) {
                byte[] bArr = p0Var.f44174a;
                int iMin = (int) Math.min(p0Var.f44176c, (((long) p0Var.f44175b) + j13) - jM22);
                i10 = (int) ((((long) p0Var.f44175b) + j12) - jM22);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                jM22 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                kotlin.jvm.internal.f0.m(p0Var);
                j12 = jM22;
            }
            return -1L;
        }
        while (true) {
            long j14 = ((long) (p0Var.f44176c - p0Var.f44175b)) + jM22;
            if (j14 > j12) {
                break;
            }
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
            jM22 = j14;
        }
        while (jM22 < j13) {
            byte[] bArr2 = p0Var.f44174a;
            int iMin2 = (int) Math.min(p0Var.f44176c, (((long) p0Var.f44175b) + j13) - jM22);
            i10 = (int) ((((long) p0Var.f44175b) + j12) - jM22);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            jM22 += (long) (p0Var.f44176c - p0Var.f44175b);
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
            j12 = jM22;
        }
        return -1L;
        return ((long) (i10 - p0Var.f44175b)) + jM22;
    }

    public final ByteString h1(String str, ByteString byteString) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.O(), str));
            p0 p0Var = this.f44116a;
            if (p0Var != null) {
                byte[] bArr = p0Var.f44174a;
                int i10 = p0Var.f44175b;
                mac.update(bArr, i10, p0Var.f44176c - i10);
                p0 p0Var2 = p0Var.f44179f;
                kotlin.jvm.internal.f0.m(p0Var2);
                while (p0Var2 != p0Var) {
                    byte[] bArr2 = p0Var2.f44174a;
                    int i11 = p0Var2.f44175b;
                    mac.update(bArr2, i11, p0Var2.f44176c - i11);
                    p0Var2 = p0Var2.f44179f;
                    kotlin.jvm.internal.f0.m(p0Var2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.f0.o(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public int hashCode() {
        p0 p0Var = this.f44116a;
        if (p0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = p0Var.f44176c;
            for (int i12 = p0Var.f44175b; i12 < i11; i12++) {
                i10 = (i10 * 31) + p0Var.f44174a[i12];
            }
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
        } while (p0Var != this.f44116a);
        return i10;
    }

    @yt.k
    public final j i() {
        j jVar = new j();
        if (m2() != 0) {
            p0 p0Var = this.f44116a;
            kotlin.jvm.internal.f0.m(p0Var);
            p0 p0VarD = p0Var.d();
            jVar.f44116a = p0VarD;
            p0VarD.f44180g = p0VarD;
            p0VarD.f44179f = p0VarD;
            for (p0 p0Var2 = p0Var.f44179f; p0Var2 != p0Var; p0Var2 = p0Var2.f44179f) {
                p0 p0Var3 = p0VarD.f44180g;
                kotlin.jvm.internal.f0.m(p0Var3);
                kotlin.jvm.internal.f0.m(p0Var2);
                p0Var3.c(p0Var2.d());
            }
            jVar.i2(m2());
        }
        return jVar;
    }

    @yt.k
    public final ByteString i1(@yt.k ByteString key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return h1(hh.c.f31295a, key);
    }

    public final void i2(long j10) {
        this.f44117b = j10;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.l
    public long j0(@yt.k ByteString targetBytes) {
        kotlin.jvm.internal.f0.p(targetBytes, "targetBytes");
        return T1(targetBytes, 0L);
    }

    @yt.k
    public final ByteString j2() {
        return F0(et.e.f27137f);
    }

    @hk.i
    @yt.k
    public final j k(@yt.k OutputStream out) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        return I(this, out, 0L, 0L, 6, null);
    }

    @Override // okio.l
    @yt.l
    public String k0() throws EOFException {
        long jB2 = b2((byte) 10);
        if (jB2 != -1) {
            return okio.internal.d.j0(this, jB2);
        }
        if (m2() != 0) {
            return q(m2());
        }
        return null;
    }

    @yt.k
    public final ByteString k1(@yt.k ByteString key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return h1("HmacSHA256", key);
    }

    @yt.k
    public final ByteString k2() {
        return F0("SHA-256");
    }

    @hk.i
    @yt.k
    public final j l(@yt.k OutputStream out, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        return I(this, out, j10, 0L, 4, null);
    }

    @yt.k
    public final ByteString l2() {
        return F0("SHA-512");
    }

    @hk.i
    @yt.k
    public final j m(@yt.k OutputStream out, long j10, long j11) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        a1.e(this.f44117b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        p0 p0Var = this.f44116a;
        while (true) {
            kotlin.jvm.internal.f0.m(p0Var);
            int i10 = p0Var.f44176c;
            int i11 = p0Var.f44175b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            p0Var = p0Var.f44179f;
        }
        while (j11 > 0) {
            kotlin.jvm.internal.f0.m(p0Var);
            int i12 = (int) (((long) p0Var.f44175b) + j10);
            int iMin = (int) Math.min(p0Var.f44176c - i12, j11);
            out.write(p0Var.f44174a, i12, iMin);
            j11 -= (long) iMin;
            p0Var = p0Var.f44179f;
            j10 = 0;
        }
        return this;
    }

    @yt.k
    public final ByteString m1(@yt.k ByteString key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return h1("HmacSHA512", key);
    }

    @hk.h(name = "size")
    public final long m2() {
        return this.f44117b;
    }

    @yt.k
    public final j n(@yt.k j out, long j10) {
        kotlin.jvm.internal.f0.p(out, "out");
        return u(out, j10, this.f44117b - j10);
    }

    @Override // okio.l
    public long n0() throws EOFException {
        if (m2() == 0) {
            throw new EOFException();
        }
        long j10 = -7;
        int i10 = 0;
        long j11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        do {
            p0 p0Var = this.f44116a;
            kotlin.jvm.internal.f0.m(p0Var);
            byte[] bArr = p0Var.f44174a;
            int i11 = p0Var.f44175b;
            int i12 = p0Var.f44176c;
            while (i11 < i12) {
                byte b10 = bArr[i11];
                byte b11 = (byte) 48;
                if (b10 >= b11 && b10 <= ((byte) 57)) {
                    int i13 = b11 - b10;
                    if (j11 < okio.internal.d.f44108c || (j11 == okio.internal.d.f44108c && i13 < j10)) {
                        j jVarWriteByte = new j().W1(j11).writeByte(b10);
                        if (!z10) {
                            jVarWriteByte.readByte();
                        }
                        throw new NumberFormatException(kotlin.jvm.internal.f0.C("Number too large: ", jVarWriteByte.y1()));
                    }
                    j11 = (j11 * 10) + ((long) i13);
                } else {
                    if (b10 != ((byte) 45) || i10 != 0) {
                        z11 = true;
                        break;
                    }
                    j10--;
                    z10 = true;
                }
                i11++;
                i10++;
            }
            if (i11 == i12) {
                this.f44116a = p0Var.b();
                q0.d(p0Var);
            } else {
                p0Var.f44175b = i11;
            }
            if (z11) {
                break;
            }
        } while (this.f44116a != null);
        i2(m2() - ((long) i10));
        if (i10 >= (z10 ? 2 : 1)) {
            return z10 ? j11 : -j11;
        }
        if (m2() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((z10 ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + a1.t(d1(0L)));
    }

    @Override // okio.l
    @yt.k
    public String n1() throws EOFException {
        return r0(Long.MAX_VALUE);
    }

    @yt.k
    public final ByteString n2() {
        if (m2() <= 2147483647L) {
            return o2((int) m2());
        }
        throw new IllegalStateException(kotlin.jvm.internal.f0.C("size > Int.MAX_VALUE: ", Long.valueOf(m2())).toString());
    }

    @yt.k
    public final ByteString o2(int i10) {
        if (i10 == 0) {
            return ByteString.f44030d;
        }
        a1.e(m2(), 0L, i10);
        p0 p0Var = this.f44116a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            kotlin.jvm.internal.f0.m(p0Var);
            int i14 = p0Var.f44176c;
            int i15 = p0Var.f44175b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            p0Var = p0Var.f44179f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        p0 p0Var2 = this.f44116a;
        int i16 = 0;
        while (i11 < i10) {
            kotlin.jvm.internal.f0.m(p0Var2);
            bArr[i16] = p0Var2.f44174a;
            i11 += p0Var2.f44176c - p0Var2.f44175b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = p0Var2.f44175b;
            p0Var2.f44177d = true;
            i16++;
            p0Var2 = p0Var2.f44179f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @yt.k
    public final ByteString p1() {
        return F0("MD5");
    }

    @yt.k
    public final p0 p2(int i10) {
        if (!(i10 >= 1 && i10 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        p0 p0Var = this.f44116a;
        if (p0Var != null) {
            kotlin.jvm.internal.f0.m(p0Var);
            p0 p0Var2 = p0Var.f44180g;
            kotlin.jvm.internal.f0.m(p0Var2);
            return (p0Var2.f44176c + i10 > 8192 || !p0Var2.f44178e) ? p0Var2.c(q0.e()) : p0Var2;
        }
        p0 p0VarE = q0.e();
        this.f44116a = p0VarE;
        p0VarE.f44180g = p0VarE;
        p0VarE.f44179f = p0VarE;
        return p0VarE;
    }

    @Override // okio.l
    @yt.k
    public l peek() {
        return f0.e(new l0(this));
    }

    @Override // okio.l
    @yt.k
    public String q(long j10) throws EOFException {
        return A1(j10, kotlin.text.d.f38161b);
    }

    @Override // okio.l
    public int q1() throws EOFException {
        return a1.n(readInt());
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: q2, reason: merged with bridge method [inline-methods] */
    public j B1(@yt.k ByteString byteString) {
        kotlin.jvm.internal.f0.p(byteString, "byteString");
        byteString.Q0(this, 0, byteString.x0());
        return this;
    }

    @Override // okio.l
    @yt.k
    public String r0(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("limit < 0: ", Long.valueOf(j10)).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        byte b10 = (byte) 10;
        long jH0 = h0(b10, 0L, j11);
        if (jH0 != -1) {
            return okio.internal.d.j0(this, jH0);
        }
        if (j11 < m2() && d1(j11 - 1) == ((byte) 13) && d1(j11) == b10) {
            return okio.internal.d.j0(this, j11);
        }
        j jVar = new j();
        u(jVar, 0L, Math.min(32, m2()));
        throw new EOFException("\\n not found: limit=" + Math.min(m2(), j10) + " content=" + jVar.Z0().B() + kotlin.text.y.F);
    }

    @Override // okio.l
    public boolean r1(long j10, @yt.k ByteString bytes, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || m2() - j10 < i11 || bytes.x0() - i10 < i11) {
            return false;
        }
        if (i11 > 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (d1(((long) i12) + j10) != bytes.v(i12 + i10)) {
                    return false;
                }
                if (i13 >= i11) {
                    break;
                }
                i12 = i13;
            }
        }
        return true;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] */
    public j J(@yt.k ByteString byteString, int i10, int i11) {
        kotlin.jvm.internal.f0.p(byteString, "byteString");
        byteString.Q0(this, i10, i11);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@yt.k ByteBuffer sink) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        p0 p0Var = this.f44116a;
        if (p0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), p0Var.f44176c - p0Var.f44175b);
        sink.put(p0Var.f44174a, p0Var.f44175b, iMin);
        int i10 = p0Var.f44175b + iMin;
        p0Var.f44175b = i10;
        this.f44117b -= (long) iMin;
        if (i10 == p0Var.f44176c) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        }
        return iMin;
    }

    @Override // okio.l
    public byte readByte() throws EOFException {
        if (m2() == 0) {
            throw new EOFException();
        }
        p0 p0Var = this.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        int i12 = i10 + 1;
        byte b10 = p0Var.f44174a[i10];
        i2(m2() - 1);
        if (i12 == i11) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i12;
        }
        return b10;
    }

    @Override // okio.l
    public void readFully(@yt.k byte[] sink) throws EOFException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // okio.l
    public int readInt() throws EOFException {
        if (m2() < 4) {
            throw new EOFException();
        }
        p0 p0Var = this.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = p0Var.f44174a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = i16 | (bArr[i15] & 255);
        i2(m2() - 4);
        if (i17 == i11) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i17;
        }
        return i18;
    }

    @Override // okio.l
    public long readLong() throws EOFException {
        if (m2() < 8) {
            throw new EOFException();
        }
        p0 p0Var = this.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        if (i11 - i10 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = p0Var.f44174a;
        int i12 = i10 + 1;
        long j10 = (((long) bArr[i10]) & 255) << 56;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 48);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 40);
        int i15 = i14 + 1;
        long j13 = ((((long) bArr[i14]) & 255) << 32) | j12;
        int i16 = i15 + 1;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 24);
        int i17 = i16 + 1;
        long j15 = j14 | ((((long) bArr[i16]) & 255) << 16);
        int i18 = i17 + 1;
        long j16 = j15 | ((((long) bArr[i17]) & 255) << 8);
        int i19 = i18 + 1;
        long j17 = j16 | (((long) bArr[i18]) & 255);
        i2(m2() - 8);
        if (i19 == i11) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i19;
        }
        return j17;
    }

    @Override // okio.l
    public short readShort() throws EOFException {
        if (m2() < 2) {
            throw new EOFException();
        }
        p0 p0Var = this.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = p0Var.f44174a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        i2(m2() - 2);
        if (i13 == i11) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i13;
        }
        return (short) i14;
    }

    @Override // okio.l
    public boolean request(long j10) {
        return this.f44117b >= j10;
    }

    @Override // okio.l
    public long s(@yt.k ByteString bytes, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        if (!(bytes.x0() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j11 = 0;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("fromIndex < 0: ", Long.valueOf(j10)).toString());
        }
        p0 p0Var = this.f44116a;
        if (p0Var != null) {
            if (m2() - j10 < j10) {
                long jM2 = m2();
                while (jM2 > j10) {
                    p0Var = p0Var.f44180g;
                    kotlin.jvm.internal.f0.m(p0Var);
                    jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
                }
                byte[] bArrO = bytes.O();
                byte b10 = bArrO[0];
                int iX0 = bytes.x0();
                long jM22 = (m2() - ((long) iX0)) + 1;
                p0 p0Var2 = p0Var;
                long j12 = jM2;
                long j13 = j10;
                while (j12 < jM22) {
                    byte[] bArr = p0Var2.f44174a;
                    long j14 = j13;
                    int iMin = (int) Math.min(p0Var2.f44176c, (((long) p0Var2.f44175b) + jM22) - j12);
                    int i10 = (int) ((((long) p0Var2.f44175b) + j14) - j12);
                    if (i10 < iMin) {
                        while (true) {
                            int i11 = i10 + 1;
                            if (bArr[i10] == b10 && okio.internal.d.i0(p0Var2, i11, bArrO, 1, iX0)) {
                                return ((long) (i10 - p0Var2.f44175b)) + j12;
                            }
                            if (i11 >= iMin) {
                                break;
                            }
                            i10 = i11;
                        }
                    }
                    j12 += (long) (p0Var2.f44176c - p0Var2.f44175b);
                    p0Var2 = p0Var2.f44179f;
                    kotlin.jvm.internal.f0.m(p0Var2);
                    j13 = j12;
                }
            } else {
                while (true) {
                    long j15 = ((long) (p0Var.f44176c - p0Var.f44175b)) + j11;
                    if (j15 > j10) {
                        break;
                    }
                    p0Var = p0Var.f44179f;
                    kotlin.jvm.internal.f0.m(p0Var);
                    j11 = j15;
                }
                byte[] bArrO2 = bytes.O();
                byte b11 = bArrO2[0];
                int iX02 = bytes.x0();
                long jM23 = (m2() - ((long) iX02)) + 1;
                long j16 = j11;
                long j17 = j10;
                while (j16 < jM23) {
                    byte[] bArr2 = p0Var.f44174a;
                    long j18 = jM23;
                    int iMin2 = (int) Math.min(p0Var.f44176c, (((long) p0Var.f44175b) + jM23) - j16);
                    int i12 = (int) ((((long) p0Var.f44175b) + j17) - j16);
                    if (i12 < iMin2) {
                        while (true) {
                            int i13 = i12 + 1;
                            if (bArr2[i12] == b11 && okio.internal.d.i0(p0Var, i13, bArrO2, 1, iX02)) {
                                return ((long) (i12 - p0Var.f44175b)) + j16;
                            }
                            if (i13 >= iMin2) {
                                break;
                            }
                            i12 = i13;
                        }
                    }
                    j16 += (long) (p0Var.f44176c - p0Var.f44175b);
                    p0Var = p0Var.f44179f;
                    kotlin.jvm.internal.f0.m(p0Var);
                    j17 = j16;
                    jM23 = j18;
                }
            }
        }
        return -1L;
    }

    @hk.i
    @yt.k
    public final a s1() {
        return z1(this, null, 1, null);
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: s2, reason: merged with bridge method [inline-methods] */
    public j g1(@yt.k t0 source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        while (j10 > 0) {
            long jF1 = source.F1(this, j10);
            if (jF1 == -1) {
                throw new EOFException();
            }
            j10 -= jF1;
        }
        return this;
    }

    @Override // okio.l
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            p0 p0Var = this.f44116a;
            if (p0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
            long j11 = iMin;
            i2(m2() - j11);
            j10 -= j11;
            int i10 = p0Var.f44175b + iMin;
            p0Var.f44175b = i10;
            if (i10 == p0Var.f44176c) {
                this.f44116a = p0Var.b();
                q0.d(p0Var);
            }
        }
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: t2, reason: merged with bridge method [inline-methods] */
    public j write(@yt.k byte[] source) {
        kotlin.jvm.internal.f0.p(source, "source");
        return write(source, 0, source.length);
    }

    @yt.k
    public String toString() {
        return n2().toString();
    }

    @yt.k
    public final j u(@yt.k j out, long j10, long j11) {
        kotlin.jvm.internal.f0.p(out, "out");
        a1.e(m2(), j10, j11);
        if (j11 != 0) {
            out.i2(out.m2() + j11);
            p0 p0Var = this.f44116a;
            while (true) {
                kotlin.jvm.internal.f0.m(p0Var);
                int i10 = p0Var.f44176c;
                int i11 = p0Var.f44175b;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                p0Var = p0Var.f44179f;
            }
            while (j11 > 0) {
                kotlin.jvm.internal.f0.m(p0Var);
                p0 p0VarD = p0Var.d();
                int i12 = p0VarD.f44175b + ((int) j10);
                p0VarD.f44175b = i12;
                p0VarD.f44176c = Math.min(i12 + ((int) j11), p0VarD.f44176c);
                p0 p0Var2 = out.f44116a;
                if (p0Var2 == null) {
                    p0VarD.f44180g = p0VarD;
                    p0VarD.f44179f = p0VarD;
                    out.f44116a = p0VarD;
                } else {
                    kotlin.jvm.internal.f0.m(p0Var2);
                    p0 p0Var3 = p0Var2.f44180g;
                    kotlin.jvm.internal.f0.m(p0Var3);
                    p0Var3.c(p0VarD);
                }
                j11 -= (long) (p0VarD.f44176c - p0VarD.f44175b);
                p0Var = p0Var.f44179f;
                j10 = 0;
            }
        }
        return this;
    }

    @hk.i
    @yt.k
    public final a u1(@yt.k a unsafeCursor) {
        kotlin.jvm.internal.f0.p(unsafeCursor, "unsafeCursor");
        return okio.internal.d.s(this, unsafeCursor);
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: u2, reason: merged with bridge method [inline-methods] */
    public j write(@yt.k byte[] source, int i10, int i11) {
        kotlin.jvm.internal.f0.p(source, "source");
        long j10 = i11;
        a1.e(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            p0 p0VarP2 = p2(1);
            int iMin = Math.min(i12 - i10, 8192 - p0VarP2.f44176c);
            int i13 = i10 + iMin;
            kotlin.collections.m.W0(source, p0VarP2.f44174a, p0VarP2.f44176c, i10, i13);
            p0VarP2.f44176c += iMin;
            i10 = i13;
        }
        i2(m2() + j10);
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: v2, reason: merged with bridge method [inline-methods] */
    public j writeByte(int i10) {
        p0 p0VarP2 = p2(1);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        p0VarP2.f44176c = i11 + 1;
        bArr[i11] = (byte) i10;
        i2(m2() + 1);
        return this;
    }

    @Override // okio.l
    @yt.k
    public byte[] w1(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (m2() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: w2, reason: merged with bridge method [inline-methods] */
    public j W1(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        boolean z10 = false;
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return H0("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 >= 100000000) {
            i10 = j10 < com.google.android.material.slider.c.f20671e ? j10 < RealConnection.f43773w ? j10 < ya.g.f56695j ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        p0 p0VarP2 = p2(i10);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = okio.internal.d.g0()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = (byte) 45;
        }
        p0VarP2.f44176c += i10;
        i2(m2() + ((long) i10));
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: x2, reason: merged with bridge method [inline-methods] */
    public j Y0(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & rr.b.f49130b);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        p0 p0VarP2 = p2(i10);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = okio.internal.d.g0()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        p0VarP2.f44176c += i10;
        i2(m2() + ((long) i10));
        return this;
    }

    @Override // okio.l
    @yt.k
    public ByteString y(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (m2() < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new ByteString(w1(j10));
        }
        ByteString byteStringO2 = o2((int) j10);
        skip(j10);
        return byteStringO2;
    }

    @Override // okio.l
    @yt.k
    public String y1() {
        return A1(this.f44117b, kotlin.text.d.f38161b);
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: y2, reason: merged with bridge method [inline-methods] */
    public j writeInt(int i10) {
        p0 p0VarP2 = p2(4);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        p0VarP2.f44176c = i14 + 1;
        i2(m2() + 4);
        return this;
    }

    @Override // okio.k
    @yt.k
    /* JADX INFO: renamed from: z2, reason: merged with bridge method [inline-methods] */
    public j c0(int i10) {
        return writeInt(a1.n(i10));
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"okio/j$b", "Ljava/io/InputStream;", "", "read", "", "sink", w.c.R, "byteCount", "available", "Lkotlin/z1;", "close", "", "toString", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(j.this.m2(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (j.this.m2() > 0) {
                return j.this.readByte() & 255;
            }
            return -1;
        }

        @yt.k
        public String toString() {
            return j.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@yt.k byte[] sink, int i10, int i11) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            return j.this.read(sink, i10, i11);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@yt.k ByteBuffer source) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            p0 p0VarP2 = p2(1);
            int iMin = Math.min(i10, 8192 - p0VarP2.f44176c);
            source.get(p0VarP2.f44174a, p0VarP2.f44176c, iMin);
            i10 -= iMin;
            p0VarP2.f44176c += iMin;
        }
        this.f44117b += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.l
    public int read(@yt.k byte[] sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.l
    public int read(@yt.k byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        a1.e(sink.length, i10, i11);
        p0 p0Var = this.f44116a;
        if (p0Var == null) {
            return -1;
        }
        int iMin = Math.min(i11, p0Var.f44176c - p0Var.f44175b);
        byte[] bArr = p0Var.f44174a;
        int i12 = p0Var.f44175b;
        kotlin.collections.m.W0(bArr, sink, i10, i12, i12 + iMin);
        p0Var.f44175b += iMin;
        i2(m2() - ((long) iMin));
        if (p0Var.f44175b == p0Var.f44176c) {
            this.f44116a = p0Var.b();
            q0.d(p0Var);
        }
        return iMin;
    }
}
