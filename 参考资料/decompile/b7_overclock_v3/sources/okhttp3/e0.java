package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlin.z1;
import kotlinx.coroutines.q0;
import okio.ByteString;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b \u0010!JB\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\u0082\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0005H&J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lokhttp3/e0;", "Ljava/io/Closeable;", "", i1.a.f31577d5, "Lkotlin/Function1;", "Lokio/l;", "consumer", "", "sizeMapper", "consumeSource", "(Lik/l;Lik/l;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "Lokhttp3/w;", so.d.f50127a, "", "contentLength", "Ljava/io/InputStream;", "byteStream", "source", "", "bytes", "Lokio/ByteString;", "byteString", "Ljava/io/Reader;", "charStream", "", w.b.f53669e, "Lkotlin/z1;", "close", "reader", "Ljava/io/Reader;", "<init>", "()V", "Companion", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class e0 implements Closeable {

    @yt.k
    public static final b Companion = new b(null);

    @yt.l
    private Reader reader;

    @kotlin.d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lokhttp3/e0$a;", "Ljava/io/Reader;", "", "cbuf", "", q0.f38941e, "len", "read", "Lkotlin/z1;", "close", "Lokio/l;", "a", "Lokio/l;", "source", "Ljava/nio/charset/Charset;", "b", "Ljava/nio/charset/Charset;", "charset", "", "c", "Z", "closed", "d", "Ljava/io/Reader;", "delegate", "<init>", "(Lokio/l;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final okio.l f43608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final Charset f43609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f43610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public Reader f43611d;

        public a(@yt.k okio.l source, @yt.k Charset charset) {
            kotlin.jvm.internal.f0.p(source, "source");
            kotlin.jvm.internal.f0.p(charset, "charset");
            this.f43608a = source;
            this.f43609b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            z1 z1Var;
            this.f43610c = true;
            Reader reader = this.f43611d;
            if (reader == null) {
                z1Var = null;
            } else {
                reader.close();
                z1Var = z1.f38230a;
            }
            if (z1Var == null) {
                this.f43608a.close();
            }
        }

        @Override // java.io.Reader
        public int read(@yt.k char[] cbuf, int i10, int i11) throws IOException {
            kotlin.jvm.internal.f0.p(cbuf, "cbuf");
            if (this.f43610c) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f43611d;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f43608a.e2(), rl.f.T(this.f43608a, this.f43609b));
                this.f43611d = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i10, i11);
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0011\u001a\u00020\u0005*\u00020\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0007J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0007J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\"\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000eH\u0007¨\u0006\u001a"}, d2 = {"Lokhttp3/e0$b;", "", "", "Lokhttp3/w;", so.d.f50127a, "Lokhttp3/e0;", "a", "(Ljava/lang/String;Lokhttp3/w;)Lokhttp3/e0;", "", "h", "([BLokhttp3/w;)Lokhttp3/e0;", "Lokio/ByteString;", "g", "(Lokio/ByteString;Lokhttp3/w;)Lokhttp3/e0;", "Lokio/l;", "", "contentLength", "f", "(Lokio/l;Lokhttp3/w;J)Lokhttp3/e0;", "content", "c", "e", "d", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        @kotlin.d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"okhttp3/e0$b$a", "Lokhttp3/e0;", "Lokhttp3/w;", so.d.f50127a, "", "contentLength", "Lokio/l;", "source", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends e0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f43612a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f43613b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ okio.l f43614c;

            public a(w wVar, long j10, okio.l lVar) {
                this.f43612a = wVar;
                this.f43613b = j10;
                this.f43614c = lVar;
            }

            @Override // okhttp3.e0
            public long contentLength() {
                return this.f43613b;
            }

            @Override // okhttp3.e0
            @yt.l
            public w contentType() {
                return this.f43612a;
            }

            @Override // okhttp3.e0
            @yt.k
            public okio.l source() {
                return this.f43614c;
            }
        }

        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ e0 i(b bVar, String str, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return bVar.a(str, wVar);
        }

        public static /* synthetic */ e0 j(b bVar, okio.l lVar, w wVar, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            if ((i10 & 2) != 0) {
                j10 = -1;
            }
            return bVar.f(lVar, wVar, j10);
        }

        public static /* synthetic */ e0 k(b bVar, ByteString byteString, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return bVar.g(byteString, wVar);
        }

        public static /* synthetic */ e0 l(b bVar, byte[] bArr, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return bVar.h(bArr, wVar);
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final e0 a(@yt.k String str, @yt.l w wVar) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            Charset charset = kotlin.text.d.f38161b;
            if (wVar != null) {
                Charset charsetG = w.g(wVar, null, 1, null);
                if (charsetG == null) {
                    wVar = w.f43984e.d(wVar + "; charset=utf-8");
                } else {
                    charset = charsetG;
                }
            }
            okio.j jVarF2 = new okio.j().a1(str, charset);
            return f(jVarF2, wVar, jVarF2.m2());
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @yt.k
        public final e0 b(@yt.l w wVar, long j10, @yt.k okio.l content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return f(content, wVar, j10);
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @yt.k
        public final e0 c(@yt.l w wVar, @yt.k String content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return a(content, wVar);
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @yt.k
        public final e0 d(@yt.l w wVar, @yt.k ByteString content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return g(content, wVar);
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @yt.k
        public final e0 e(@yt.l w wVar, @yt.k byte[] content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return h(content, wVar);
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final e0 f(@yt.k okio.l lVar, @yt.l w wVar, long j10) {
            kotlin.jvm.internal.f0.p(lVar, "<this>");
            return new a(wVar, j10, lVar);
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final e0 g(@yt.k ByteString byteString, @yt.l w wVar) {
            kotlin.jvm.internal.f0.p(byteString, "<this>");
            return f(new okio.j().B1(byteString), wVar, byteString.x0());
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final e0 h(@yt.k byte[] bArr, @yt.l w wVar) {
            kotlin.jvm.internal.f0.p(bArr, "<this>");
            return f(new okio.j().write(bArr), wVar, bArr.length);
        }
    }

    private final Charset charset() {
        w wVarContentType = contentType();
        Charset charsetF = wVarContentType == null ? null : wVarContentType.f(kotlin.text.d.f38161b);
        return charsetF == null ? kotlin.text.d.f38161b : charsetF;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(ik.l<? super okio.l, ? extends T> lVar, ik.l<? super T, Integer> lVar2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(kotlin.jvm.internal.f0.C("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        okio.l lVarSource = source();
        try {
            T tI = lVar.i(lVarSource);
            kotlin.jvm.internal.c0.d(1);
            kotlin.io.b.a(lVarSource, null);
            kotlin.jvm.internal.c0.c(1);
            int iIntValue = lVar2.i(tI).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tI;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } finally {
        }
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final e0 create(@yt.k String str, @yt.l w wVar) {
        return Companion.a(str, wVar);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @yt.k
    public static final e0 create(@yt.l w wVar, long j10, @yt.k okio.l lVar) {
        return Companion.b(wVar, j10, lVar);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @yt.k
    public static final e0 create(@yt.l w wVar, @yt.k String str) {
        return Companion.c(wVar, str);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @yt.k
    public static final e0 create(@yt.l w wVar, @yt.k ByteString byteString) {
        return Companion.d(wVar, byteString);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @t0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @yt.k
    public static final e0 create(@yt.l w wVar, @yt.k byte[] bArr) {
        return Companion.e(wVar, bArr);
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final e0 create(@yt.k ByteString byteString, @yt.l w wVar) {
        return Companion.g(byteString, wVar);
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final e0 create(@yt.k okio.l lVar, @yt.l w wVar, long j10) {
        return Companion.f(lVar, wVar, j10);
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final e0 create(@yt.k byte[] bArr, @yt.l w wVar) {
        return Companion.h(bArr, wVar);
    }

    @yt.k
    public final InputStream byteStream() {
        return source().e2();
    }

    @yt.k
    public final ByteString byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(kotlin.jvm.internal.f0.C("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        okio.l lVarSource = source();
        try {
            ByteString byteStringZ0 = lVarSource.Z0();
            kotlin.io.b.a(lVarSource, null);
            int iX0 = byteStringZ0.x0();
            if (jContentLength == -1 || jContentLength == iX0) {
                return byteStringZ0;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iX0 + ") disagree");
        } finally {
        }
    }

    @yt.k
    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(kotlin.jvm.internal.f0.C("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        okio.l lVarSource = source();
        try {
            byte[] bArrS = lVarSource.S();
            kotlin.io.b.a(lVarSource, null);
            int length = bArrS.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrS;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @yt.k
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        rl.f.o(source());
    }

    public abstract long contentLength();

    @yt.l
    public abstract w contentType();

    @yt.k
    public abstract okio.l source();

    @yt.k
    public final String string() throws IOException {
        okio.l lVarSource = source();
        try {
            String strO0 = lVarSource.O0(rl.f.T(lVarSource, charset()));
            kotlin.io.b.a(lVarSource, null);
            return strO0;
        } finally {
        }
    }
}
