package rl;

import androidx.transition.q;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.umeng.analytics.pro.an;
import hd.u0;
import hk.h;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s0;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;
import kotlin.jvm.internal.w0;
import kotlin.o;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;
import kotlin.z1;
import m0.k;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.r;
import okhttp3.t;
import okio.ByteString;
import okio.i0;
import okio.r0;
import okio.t0;
import qk.m;
import qk.v;
import w.w;
import xf.j;
import xf.k0;

/* JADX INFO: loaded from: classes5.dex */
@h(name = u0.f31160g)
@d0(bv = {}, d1 = {"\u0000\u008c\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a;\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0016\u001a\u00020\u0006*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\b\u001a-\u0010\u0019\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0017\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001f\u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\u001e\u0010 \u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\u001e\u0010!\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a&\u0010#\u001a\u00020\u0018*\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a&\u0010&\u001a\u00020\u0018*\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u0018\u001a\n\u0010'\u001a\u00020\u0018*\u00020\u0006\u001a\n\u0010(\u001a\u00020\b*\u00020\u0006\u001a\u000e\u0010)\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u001a)\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0\f\"\u00020+¢\u0006\u0004\b-\u0010.\u001a\u0012\u00102\u001a\u000200*\u00020/2\u0006\u00101\u001a\u000200\u001a \u00106\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000104\u001a\n\u00107\u001a\u00020\u0018*\u00020$\u001a\u0010\u0010;\u001a\u00020:*\b\u0012\u0004\u0012\u00020908\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020908*\u00020:\u001a\u0012\u0010=\u001a\u00020\b*\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014\u001a\n\u0010@\u001a\u00020?*\u00020>\u001a\u0015\u0010C\u001a\u00020\u0018*\u00020A2\u0006\u0010B\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010E\u001a\u00020\u0018*\u00020D2\u0006\u0010B\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010F\u001a\u00020\u0000*\u00020\u00182\u0006\u0010B\u001a\u00020\u0000H\u0086\u0004\u001a\u0012\u0010I\u001a\u00020\u0004*\u00020G2\u0006\u0010H\u001a\u00020\u0018\u001a\n\u0010J\u001a\u00020\u0018*\u00020/\u001a\u001a\u0010M\u001a\u00020\b*\u00020K2\u0006\u00103\u001a\u00020\u00182\u0006\u0010L\u001a\u000204\u001a\u001a\u0010O\u001a\u00020\b*\u00020K2\u0006\u0010N\u001a\u00020\u00182\u0006\u0010L\u001a\u000204\u001a\n\u0010Q\u001a\u00020\u0006*\u00020P\u001a\u0012\u0010S\u001a\u00020\b*\u00020P2\u0006\u0010R\u001a\u00020/\u001a\u001a\u0010V\u001a\u00020\u00042\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040TH\u0086\bø\u0001\u0000\u001a\"\u0010W\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040TH\u0086\bø\u0001\u0000\u001a\u0012\u0010Z\u001a\u00020\u0018*\u00020X2\u0006\u0010Y\u001a\u00020A\u001a\u0014\u0010[\u001a\u00020\u0018*\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u001a\n\u0010]\u001a\u00020\u0000*\u00020\\\u001a\u0012\u0010_\u001a\u00020\u0000*\u00020\u00062\u0006\u0010^\u001a\u00020\u0000\u001a\u0014\u0010`\u001a\u00020\u0018*\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0018\u001a\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u00102*\b\u0012\u0004\u0012\u00028\u000008\u001a/\u0010c\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u001022\u0012\u0010b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\"\u00028\u0000H\u0007¢\u0006\u0004\bc\u0010d\u001a.\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f\"\u0004\b\u0000\u0010e\"\u0004\b\u0001\u0010J*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f\u001a\n\u0010i\u001a\u00020\u0004*\u00020h\u001a\n\u0010j\u001a\u00020\u0004*\u00020P\u001a\n\u0010l\u001a\u00020\u0004*\u00020k\u001a\u0012\u0010p\u001a\u00020\b*\u00020m2\u0006\u0010o\u001a\u00020n\u001a\n\u0010q\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010r\u001a\u00020\u0006*\u00020\u0018\u001a\r\u0010s\u001a\u00020\u0004*\u00020+H\u0086\b\u001a\r\u0010t\u001a\u00020\u0004*\u00020+H\u0086\b\u001a\r\u0010u\u001a\u00020\u0004*\u00020+H\u0086\b\u001a3\u0010z\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u001022\u0006\u0010v\u001a\u00020+2\f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000w2\u0006\u0010y\u001a\u00020\u0006¢\u0006\u0004\bz\u0010{\u001a'\u0010~\u001a\u00020\u0004\"\u0004\b\u0000\u0010'*\b\u0012\u0004\u0012\u00028\u00000|2\u0006\u0010}\u001a\u00028\u0000H\u0000¢\u0006\u0004\b~\u0010\u007f\u001a\u000e\u0010\u0080\u0001\u001a\u00020\u0004*\u00020+H\u0080\b\u001a\u000e\u0010\u0081\u0001\u001a\u00020\u0004*\u00020+H\u0080\b\u001a'\u0010\u0086\u0001\u001a\u00030\u0085\u0001*\b0\u0082\u0001j\u0003`\u0083\u00012\u0013\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b0\u0082\u0001j\u0003`\u0083\u000108\u001a@\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u00102*\t\u0012\u0004\u0012\u00028\u00000\u0087\u00012\u001a\u0010\u008a\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0088\u0001¢\u0006\u0003\b\u0089\u0001H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008c\u0001"}, d2 = {"", "arrayLength", w.c.R, uh.a.C, "Lkotlin/z1;", "n", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "Y", "", "other", "Ljava/util/Comparator;", "comparator", "L", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", an.aD, "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/u;", "includeDefaultPort", "f0", "value", "", "D", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", SsManifestParser.e.J, "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "F", "H", "l0", "delimiters", "t", "", xc.d.f55070a0, an.aB, i1.a.S4, "k", "O", "format", "", "args", "y", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lokio/l;", "Ljava/nio/charset/Charset;", "default", i1.a.f31577d5, "duration", "Ljava/util/concurrent/TimeUnit;", "unit", k.f40564b, "R", "", "Lxl/a;", "Lokhttp3/t;", "c0", "b0", l.f16298a, "Lokhttp3/r;", "Lokhttp3/r$c;", "g", "", "mask", "d", "", "e", "f", "Lokio/k;", "medium", "p0", i1.a.X4, "Lokio/t0;", "timeUnit", "X", "timeout", "w", "Ljava/net/Socket;", i1.a.R4, "source", "N", "Lkotlin/Function0;", "block", "B", "a0", "Lokio/j;", "b", i1.a.T4, "J", "Lokhttp3/d0;", i1.a.W4, "defaultValue", "j0", k0.f55262g, "h0", "elements", "C", "([Ljava/lang/Object;)Ljava/util/List;", "K", "", "i0", "Ljava/io/Closeable;", "o", "q", "Ljava/net/ServerSocket;", "p", "Lyl/a;", "Ljava/io/File;", m7.a.f40702b, "M", "e0", "d0", "n0", "P", "Q", q.F7, "Ljava/lang/Class;", "fieldType", "fieldName", "U", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "", "element", "c", "(Ljava/util/List;Ljava/lang/Object;)V", j.f55230b, "i", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "o0", "", "Lkotlin/Function1;", "Lkotlin/t;", "predicate", "x", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f48796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final t f48797b = t.f43945b.j(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final e0 f48798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final c0 f48799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final i0 f48800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final TimeZone f48801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final Regex f48802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @hk.e
    public static final boolean f48803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f48804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final String f48805j = "okhttp/4.10.0";

    static {
        byte[] bArr = new byte[0];
        f48796a = bArr;
        f48798c = e0.b.l(e0.Companion, bArr, null, 1, null);
        f48799d = c0.a.r(c0.f43548a, bArr, null, 0, 0, 7, null);
        i0.a aVar = i0.f44070d;
        ByteString.a aVar2 = ByteString.f44029c;
        f48800e = aVar.d(aVar2.i("efbbbf"), aVar2.i("feff"), aVar2.i("fffe"), aVar2.i("0000ffff"), aVar2.i("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        f0.m(timeZone);
        f48801f = timeZone;
        f48802g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f48803h = false;
        String name = a0.class.getName();
        f0.o(name, "OkHttpClient::class.java.name");
        f48804i = StringsKt__StringsKt.j4(StringsKt__StringsKt.d4(name, "okhttp3."), "Client");
    }

    public static final long A(@yt.k okhttp3.d0 d0Var) {
        f0.p(d0Var, "<this>");
        String strD = d0Var.h1().d(HttpHeaders.CONTENT_LENGTH);
        if (strD == null) {
            return -1L;
        }
        return j0(strD, -1L);
    }

    public static final void B(@yt.k ik.a<z1> block) {
        f0.p(block, "block");
        try {
            block.o();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @yt.k
    public static final <T> List<T> C(@yt.k T... elements) {
        f0.p(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt__CollectionsKt.L(Arrays.copyOf(objArr, objArr.length)));
        f0.o(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int D(@yt.k String[] strArr, @yt.k String value, @yt.k Comparator<String> comparator) {
        f0.p(strArr, "<this>");
        f0.p(value, "value");
        f0.p(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], value) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int E(@yt.k String str) {
        f0.p(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (f0.t(cCharAt, 31) <= 0 || f0.t(cCharAt, 127) >= 0) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public static final int F(@yt.k String str, int i10, int i11) {
        f0.p(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int G(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return F(str, i10, i11);
    }

    public static final int H(@yt.k String str, int i10, int i11) {
        f0.p(str, "<this>");
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                int i13 = i12 - 1;
                char cCharAt = str.charAt(i12);
                if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                    return i12 + 1;
                }
                if (i12 == i10) {
                    break;
                }
                i12 = i13;
            }
        }
        return i10;
    }

    public static /* synthetic */ int I(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return H(str, i10, i11);
    }

    public static final int J(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        int length = str.length();
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i10;
            }
            i10 = i11;
        }
        return str.length();
    }

    public static /* synthetic */ int K(String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return J(str, i10);
    }

    @yt.k
    public static final String[] L(@yt.k String[] strArr, @yt.k String[] other, @yt.k Comparator<? super String> comparator) {
        f0.p(strArr, "<this>");
        f0.p(other, "other");
        f0.p(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            int length2 = other.length;
            int i11 = 0;
            while (true) {
                if (i11 < length2) {
                    String str2 = other[i11];
                    i11++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public static final boolean M(@yt.k yl.a aVar, @yt.k File file) throws IOException {
        f0.p(aVar, "<this>");
        f0.p(file, "file");
        r0 r0VarB = aVar.b(file);
        try {
            try {
                aVar.f(file);
                kotlin.io.b.a(r0VarB, null);
                return true;
            } catch (IOException unused) {
                z1 z1Var = z1.f38230a;
                kotlin.io.b.a(r0VarB, null);
                aVar.f(file);
                return false;
            }
        } finally {
        }
    }

    public static final boolean N(@yt.k Socket socket, @yt.k okio.l source) {
        f0.p(socket, "<this>");
        f0.p(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z10 = !source.d0();
                socket.setSoTimeout(soTimeout);
                return z10;
            } catch (Throwable th2) {
                socket.setSoTimeout(soTimeout);
                throw th2;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean O(@yt.k String name) {
        f0.p(name, "name");
        return u.L1(name, "Authorization", true) || u.L1(name, HttpHeaders.COOKIE, true) || u.L1(name, HttpHeaders.PROXY_AUTHORIZATION, true) || u.L1(name, HttpHeaders.SET_COOKIE, true);
    }

    public static final void P(@yt.k Object obj) {
        f0.p(obj, "<this>");
        obj.notify();
    }

    public static final void Q(@yt.k Object obj) {
        f0.p(obj, "<this>");
        obj.notifyAll();
    }

    public static final int R(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if (!('A' <= c10 && c10 < 'G')) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    @yt.k
    public static final String S(@yt.k Socket socket) {
        f0.p(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        f0.o(hostName, "address.hostName");
        return hostName;
    }

    @yt.k
    public static final Charset T(@yt.k okio.l lVar, @yt.k Charset charset) throws IOException {
        f0.p(lVar, "<this>");
        f0.p(charset, "default");
        int iG2 = lVar.g2(f48800e);
        if (iG2 == -1) {
            return charset;
        }
        if (iG2 == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            f0.o(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iG2 == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            f0.o(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iG2 == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            f0.o(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iG2 == 3) {
            return kotlin.text.d.f38160a.b();
        }
        if (iG2 == 4) {
            return kotlin.text.d.f38160a.c();
        }
        throw new AssertionError();
    }

    @yt.l
    public static final <T> T U(@yt.k Object instance, @yt.k Class<T> fieldType, @yt.k String fieldName) throws IllegalAccessException {
        T tCast;
        Object objU;
        f0.p(instance, "instance");
        f0.p(fieldType, "fieldType");
        f0.p(fieldName, "fieldName");
        Class<?> superclass = instance.getClass();
        while (true) {
            tCast = null;
            if (f0.g(superclass, Object.class)) {
                if (f0.g(fieldName, "delegate") || (objU = U(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) U(objU, fieldType, fieldName);
            }
            try {
                Field declaredField = superclass.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                tCast = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                f0.o(superclass, "c.superclass");
            }
        }
        return tCast;
    }

    public static final int V(@yt.k okio.l lVar) throws IOException {
        f0.p(lVar, "<this>");
        return d(lVar.readByte(), 255) | (d(lVar.readByte(), 255) << 16) | (d(lVar.readByte(), 255) << 8);
    }

    public static final int W(@yt.k okio.j jVar, byte b10) throws EOFException {
        f0.p(jVar, "<this>");
        int i10 = 0;
        while (!jVar.d0() && jVar.d1(0L) == b10) {
            i10++;
            jVar.readByte();
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[PHI: r12
  0x005b: PHI (r12v6 boolean) = (r12v5 boolean), (r12v10 boolean) binds: [B:23:0x007e, B:13:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean X(@yt.k okio.t0 r11, int r12, @yt.k java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.f0.p(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.f0.p(r13, r0)
            long r0 = java.lang.System.nanoTime()
            okio.v0 r2 = r11.U()
            boolean r2 = r2.f()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            okio.v0 r2 = r11.U()
            long r5 = r2.d()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            okio.v0 r2 = r11.U()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.e(r12)
            okio.j r12 = new okio.j     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r12.<init>()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.F1(r12, r7)     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.d()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            goto L3e
        L4e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
        L53:
            okio.v0 r11 = r11.U()
            r11.a()
            goto L81
        L5b:
            okio.v0 r11 = r11.U()
            long r0 = r0 + r5
            r11.e(r0)
            goto L81
        L64:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L71
            okio.v0 r11 = r11.U()
            r11.a()
            goto L79
        L71:
            okio.v0 r11 = r11.U()
            long r0 = r0 + r5
            r11.e(r0)
        L79:
            throw r12
        L7a:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L53
        L81:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: rl.f.X(okio.t0, int, java.util.concurrent.TimeUnit):boolean");
    }

    @yt.k
    public static final ThreadFactory Y(@yt.k final String name, final boolean z10) {
        f0.p(name, "name");
        return new ThreadFactory() { // from class: rl.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return f.Z(name, z10, runnable);
            }
        };
    }

    public static final Thread Z(String name, boolean z10, Runnable runnable) {
        f0.p(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z10);
        return thread;
    }

    public static final void a0(@yt.k String name, @yt.k ik.a<z1> block) {
        f0.p(name, "name");
        f0.p(block, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name2 = threadCurrentThread.getName();
        threadCurrentThread.setName(name);
        try {
            block.o();
        } finally {
            kotlin.jvm.internal.c0.d(1);
            threadCurrentThread.setName(name2);
            kotlin.jvm.internal.c0.c(1);
        }
    }

    @yt.k
    public static final List<xl.a> b0(@yt.k t tVar) {
        f0.p(tVar, "<this>");
        m mVarW1 = v.W1(0, tVar.size());
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(mVarW1, 10));
        Iterator<Integer> it2 = mVarW1.iterator();
        while (it2.hasNext()) {
            int iB = ((kotlin.collections.k0) it2).b();
            arrayList.add(new xl.a(tVar.j(iB), tVar.r(iB)));
        }
        return arrayList;
    }

    public static final <E> void c(@yt.k List<E> list, E e10) {
        f0.p(list, "<this>");
        if (list.contains(e10)) {
            return;
        }
        list.add(e10);
    }

    @yt.k
    public static final t c0(@yt.k List<xl.a> list) {
        f0.p(list, "<this>");
        t.a aVar = new t.a();
        for (xl.a aVar2 : list) {
            aVar.g(aVar2.a().O0(), aVar2.b().O0());
        }
        return aVar.i();
    }

    public static final int d(byte b10, int i10) {
        return b10 & i10;
    }

    @yt.k
    public static final String d0(int i10) {
        String hexString = Integer.toHexString(i10);
        f0.o(hexString, "toHexString(this)");
        return hexString;
    }

    public static final int e(short s10, int i10) {
        return s10 & i10;
    }

    @yt.k
    public static final String e0(long j10) {
        String hexString = Long.toHexString(j10);
        f0.o(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long f(int i10, long j10) {
        return ((long) i10) & j10;
    }

    @yt.k
    public static final String f0(@yt.k okhttp3.u uVar, boolean z10) {
        String strF;
        f0.p(uVar, "<this>");
        if (StringsKt__StringsKt.W2(uVar.F(), ":", false, 2, null)) {
            strF = '[' + uVar.F() + ']';
        } else {
            strF = uVar.F();
        }
        if (!z10 && uVar.N() == okhttp3.u.f43948k.g(uVar.X())) {
            return strF;
        }
        return strF + ':' + uVar.N();
    }

    @yt.k
    public static final r.c g(@yt.k final r rVar) {
        f0.p(rVar, "<this>");
        return new r.c() { // from class: rl.e
            @Override // okhttp3.r.c
            public final r create(okhttp3.e eVar) {
                return f.h(rVar, eVar);
            }
        };
    }

    public static /* synthetic */ String g0(okhttp3.u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return f0(uVar, z10);
    }

    public static final r h(r this_asFactory, okhttp3.e it2) {
        f0.p(this_asFactory, "$this_asFactory");
        f0.p(it2, "it");
        return this_asFactory;
    }

    @yt.k
    public static final <T> List<T> h0(@yt.k List<? extends T> list) {
        f0.p(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.T5(list));
        f0.o(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final void i(@yt.k Object obj) {
        f0.p(obj, "<this>");
        if (f48803h && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + obj);
        }
    }

    @yt.k
    public static final <K, V> Map<K, V> i0(@yt.k Map<K, ? extends V> map) {
        f0.p(map, "<this>");
        if (map.isEmpty()) {
            return s0.z();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        f0.o(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final void j(@yt.k Object obj) {
        f0.p(obj, "<this>");
        if (!f48803h || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + obj);
    }

    public static final long j0(@yt.k String str, long j10) {
        f0.p(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final boolean k(@yt.k String str) {
        f0.p(str, "<this>");
        return f48802g.n(str);
    }

    public static final int k0(@yt.l String str, int i10) {
        Long lValueOf;
        if (str == null) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        if (lValueOf == null) {
            return i10;
        }
        long jLongValue = lValueOf.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    public static final boolean l(@yt.k okhttp3.u uVar, @yt.k okhttp3.u other) {
        f0.p(uVar, "<this>");
        f0.p(other, "other");
        return f0.g(uVar.F(), other.F()) && uVar.N() == other.N() && f0.g(uVar.X(), other.X());
    }

    @yt.k
    public static final String l0(@yt.k String str, int i10, int i11) {
        f0.p(str, "<this>");
        int iF = F(str, i10, i11);
        String strSubstring = str.substring(iF, H(str, iF, i11));
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int m(@yt.k String name, long j10, @yt.l TimeUnit timeUnit) {
        f0.p(name, "name");
        boolean z10 = true;
        if (!(j10 >= 0)) {
            throw new IllegalStateException(f0.C(name, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j10);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException(f0.C(name, " too large.").toString());
        }
        if (millis == 0 && j10 > 0) {
            z10 = false;
        }
        if (z10) {
            return (int) millis;
        }
        throw new IllegalArgumentException(f0.C(name, " too small.").toString());
    }

    public static /* synthetic */ String m0(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return l0(str, i10, i11);
    }

    public static final void n(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void n0(@yt.k Object obj) throws InterruptedException {
        f0.p(obj, "<this>");
        obj.wait();
    }

    public static final void o(@yt.k Closeable closeable) {
        f0.p(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    @yt.k
    public static final Throwable o0(@yt.k Exception exc, @yt.k List<? extends Exception> suppressed) throws IllegalAccessException, InvocationTargetException {
        f0.p(exc, "<this>");
        f0.p(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it2 = suppressed.iterator();
        while (it2.hasNext()) {
            o.a(exc, it2.next());
        }
        return exc;
    }

    public static final void p(@yt.k ServerSocket serverSocket) {
        f0.p(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void p0(@yt.k okio.k kVar, int i10) throws IOException {
        f0.p(kVar, "<this>");
        kVar.writeByte((i10 >>> 16) & 255);
        kVar.writeByte((i10 >>> 8) & 255);
        kVar.writeByte(i10 & 255);
    }

    public static final void q(@yt.k Socket socket) {
        f0.p(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!f0.g(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    @yt.k
    public static final String[] r(@yt.k String[] strArr, @yt.k String value) {
        f0.p(strArr, "<this>");
        f0.p(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        f0.o(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[ArraysKt___ArraysKt.Xe(strArr2)] = value;
        return strArr2;
    }

    public static final int s(@yt.k String str, char c10, int i10, int i11) {
        f0.p(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static final int t(@yt.k String str, @yt.k String delimiters, int i10, int i11) {
        f0.p(str, "<this>");
        f0.p(delimiters, "delimiters");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (StringsKt__StringsKt.V2(delimiters, str.charAt(i10), false, 2, null)) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int u(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return s(str, c10, i10, i11);
    }

    public static /* synthetic */ int v(String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return t(str, str2, i10, i11);
    }

    public static final boolean w(@yt.k t0 t0Var, int i10, @yt.k TimeUnit timeUnit) {
        f0.p(t0Var, "<this>");
        f0.p(timeUnit, "timeUnit");
        try {
            return X(t0Var, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @yt.k
    public static final <T> List<T> x(@yt.k Iterable<? extends T> iterable, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(iterable, "<this>");
        f0.p(predicate, "predicate");
        List<T> listE = CollectionsKt__CollectionsKt.E();
        for (T t10 : iterable) {
            if (predicate.i(t10).booleanValue()) {
                if (listE.isEmpty()) {
                    listE = new ArrayList<>();
                }
                w0.g(listE).add(t10);
            }
        }
        return listE;
    }

    @yt.k
    public static final String y(@yt.k String format, @yt.k Object... args) {
        f0.p(format, "format");
        f0.p(args, "args");
        v0 v0Var = v0.f37964a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        f0.o(str, "format(locale, format, *args)");
        return str;
    }

    public static final boolean z(@yt.k String[] strArr, @yt.l String[] strArr2, @yt.k Comparator<? super String> comparator) {
        f0.p(strArr, "<this>");
        f0.p(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                int length = strArr.length;
                int i10 = 0;
                while (i10 < length) {
                    String str = strArr[i10];
                    i10++;
                    Iterator itA = kotlin.jvm.internal.h.a(strArr2);
                    while (itA.hasNext()) {
                        if (comparator.compare(str, (String) itA.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
