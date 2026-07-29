package okhttp3;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import okio.ByteString;
import okio.t0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lokhttp3/c0;", "", "Lokhttp3/w;", "b", "", "a", "Lokio/k;", "sink", "Lkotlin/z1;", SsManifestParser.e.J, "", "p", "q", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f43548a = new a(null);

    @kotlin.d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000f\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u0005*\u00020\u00112\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0007J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0007J.\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0011H\u0007¨\u0006\u001c"}, d2 = {"Lokhttp3/c0$a;", "", "", "Lokhttp3/w;", so.d.f50127a, "Lokhttp3/c0;", "b", "(Ljava/lang/String;Lokhttp3/w;)Lokhttp3/c0;", "Lokio/ByteString;", "i", "(Lokio/ByteString;Lokhttp3/w;)Lokhttp3/c0;", "", "", w.c.R, "byteCount", m0.k.f40564b, "([BLokhttp3/w;II)Lokhttp3/c0;", "Ljava/io/File;", "a", "(Ljava/io/File;Lokhttp3/w;)Lokhttp3/c0;", "content", "d", "e", "h", m7.a.f40702b, "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: okhttp3.c0$a$a, reason: collision with other inner class name */
        @kotlin.d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"okhttp3/c0$a$a", "Lokhttp3/c0;", "Lokhttp3/w;", "b", "", "a", "Lokio/k;", "sink", "Lkotlin/z1;", SsManifestParser.e.J, "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0492a extends c0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w f43549b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ File f43550c;

            public C0492a(w wVar, File file) {
                this.f43549b = wVar;
                this.f43550c = file;
            }

            @Override // okhttp3.c0
            public long a() {
                return this.f43550c.length();
            }

            @Override // okhttp3.c0
            @yt.l
            public w b() {
                return this.f43549b;
            }

            @Override // okhttp3.c0
            public void r(@yt.k okio.k sink) throws FileNotFoundException {
                kotlin.jvm.internal.f0.p(sink, "sink");
                t0 t0VarT = okio.f0.t(this.f43550c);
                try {
                    sink.X0(t0VarT);
                    kotlin.io.b.a(t0VarT, null);
                } finally {
                }
            }
        }

        @kotlin.d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"okhttp3/c0$a$b", "Lokhttp3/c0;", "Lokhttp3/w;", "b", "", "a", "Lokio/k;", "sink", "Lkotlin/z1;", SsManifestParser.e.J, "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class b extends c0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w f43551b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ByteString f43552c;

            public b(w wVar, ByteString byteString) {
                this.f43551b = wVar;
                this.f43552c = byteString;
            }

            @Override // okhttp3.c0
            public long a() {
                return this.f43552c.x0();
            }

            @Override // okhttp3.c0
            @yt.l
            public w b() {
                return this.f43551b;
            }

            @Override // okhttp3.c0
            public void r(@yt.k okio.k sink) throws IOException {
                kotlin.jvm.internal.f0.p(sink, "sink");
                sink.B1(this.f43552c);
            }
        }

        @kotlin.d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"okhttp3/c0$a$c", "Lokhttp3/c0;", "Lokhttp3/w;", "b", "", "a", "Lokio/k;", "sink", "Lkotlin/z1;", SsManifestParser.e.J, "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class c extends c0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w f43553b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f43554c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ byte[] f43555d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f43556e;

            public c(w wVar, int i10, byte[] bArr, int i11) {
                this.f43553b = wVar;
                this.f43554c = i10;
                this.f43555d = bArr;
                this.f43556e = i11;
            }

            @Override // okhttp3.c0
            public long a() {
                return this.f43554c;
            }

            @Override // okhttp3.c0
            @yt.l
            public w b() {
                return this.f43553b;
            }

            @Override // okhttp3.c0
            public void r(@yt.k okio.k sink) throws IOException {
                kotlin.jvm.internal.f0.p(sink, "sink");
                sink.write(this.f43555d, this.f43556e, this.f43554c);
            }
        }

        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ c0 n(a aVar, File file, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return aVar.a(file, wVar);
        }

        public static /* synthetic */ c0 o(a aVar, String str, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return aVar.b(str, wVar);
        }

        public static /* synthetic */ c0 p(a aVar, w wVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return aVar.h(wVar, bArr, i10, i11);
        }

        public static /* synthetic */ c0 q(a aVar, ByteString byteString, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return aVar.i(byteString, wVar);
        }

        public static /* synthetic */ c0 r(a aVar, byte[] bArr, w wVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                wVar = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return aVar.m(bArr, wVar, i10, i11);
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final c0 a(@yt.k File file, @yt.l w wVar) {
            kotlin.jvm.internal.f0.p(file, "<this>");
            return new C0492a(wVar, file);
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final c0 b(@yt.k String str, @yt.l w wVar) {
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
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.f0.o(bytes, "this as java.lang.String).getBytes(charset)");
            return m(bytes, wVar, 0, bytes.length);
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @kotlin.t0(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @yt.k
        public final c0 c(@yt.l w wVar, @yt.k File file) {
            kotlin.jvm.internal.f0.p(file, "file");
            return a(file, wVar);
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @yt.k
        public final c0 d(@yt.l w wVar, @yt.k String content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return b(content, wVar);
        }

        @hk.m
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @yt.k
        public final c0 e(@yt.l w wVar, @yt.k ByteString content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return i(content, wVar);
        }

        @hk.i
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @hk.m
        @yt.k
        public final c0 f(@yt.l w wVar, @yt.k byte[] content) {
            kotlin.jvm.internal.f0.p(content, "content");
            return p(this, wVar, content, 0, 0, 12, null);
        }

        @hk.i
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @hk.m
        @yt.k
        public final c0 g(@yt.l w wVar, @yt.k byte[] content, int i10) {
            kotlin.jvm.internal.f0.p(content, "content");
            return p(this, wVar, content, i10, 0, 8, null);
        }

        @hk.i
        @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @hk.m
        @yt.k
        public final c0 h(@yt.l w wVar, @yt.k byte[] content, int i10, int i11) {
            kotlin.jvm.internal.f0.p(content, "content");
            return m(content, wVar, i10, i11);
        }

        @hk.h(name = "create")
        @hk.m
        @yt.k
        public final c0 i(@yt.k ByteString byteString, @yt.l w wVar) {
            kotlin.jvm.internal.f0.p(byteString, "<this>");
            return new b(wVar, byteString);
        }

        @hk.h(name = "create")
        @hk.i
        @hk.m
        @yt.k
        public final c0 j(@yt.k byte[] bArr) {
            kotlin.jvm.internal.f0.p(bArr, "<this>");
            return r(this, bArr, null, 0, 0, 7, null);
        }

        @hk.h(name = "create")
        @hk.i
        @hk.m
        @yt.k
        public final c0 k(@yt.k byte[] bArr, @yt.l w wVar) {
            kotlin.jvm.internal.f0.p(bArr, "<this>");
            return r(this, bArr, wVar, 0, 0, 6, null);
        }

        @hk.h(name = "create")
        @hk.i
        @hk.m
        @yt.k
        public final c0 l(@yt.k byte[] bArr, @yt.l w wVar, int i10) {
            kotlin.jvm.internal.f0.p(bArr, "<this>");
            return r(this, bArr, wVar, i10, 0, 4, null);
        }

        @hk.h(name = "create")
        @hk.i
        @hk.m
        @yt.k
        public final c0 m(@yt.k byte[] bArr, @yt.l w wVar, int i10, int i11) {
            kotlin.jvm.internal.f0.p(bArr, "<this>");
            rl.f.n(bArr.length, i10, i11);
            return new c(wVar, i11, bArr, i10);
        }
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final c0 c(@yt.k File file, @yt.l w wVar) {
        return f43548a.a(file, wVar);
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final c0 d(@yt.k String str, @yt.l w wVar) {
        return f43548a.b(str, wVar);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @kotlin.t0(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @yt.k
    public static final c0 e(@yt.l w wVar, @yt.k File file) {
        return f43548a.c(wVar, file);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @yt.k
    public static final c0 f(@yt.l w wVar, @yt.k String str) {
        return f43548a.d(wVar, str);
    }

    @hk.m
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @yt.k
    public static final c0 g(@yt.l w wVar, @yt.k ByteString byteString) {
        return f43548a.e(wVar, byteString);
    }

    @hk.i
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @hk.m
    @yt.k
    public static final c0 h(@yt.l w wVar, @yt.k byte[] bArr) {
        return f43548a.f(wVar, bArr);
    }

    @hk.i
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @hk.m
    @yt.k
    public static final c0 i(@yt.l w wVar, @yt.k byte[] bArr, int i10) {
        return f43548a.g(wVar, bArr, i10);
    }

    @hk.i
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @kotlin.t0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @hk.m
    @yt.k
    public static final c0 j(@yt.l w wVar, @yt.k byte[] bArr, int i10, int i11) {
        return f43548a.h(wVar, bArr, i10, i11);
    }

    @hk.h(name = "create")
    @hk.m
    @yt.k
    public static final c0 k(@yt.k ByteString byteString, @yt.l w wVar) {
        return f43548a.i(byteString, wVar);
    }

    @hk.h(name = "create")
    @hk.i
    @hk.m
    @yt.k
    public static final c0 l(@yt.k byte[] bArr) {
        return f43548a.j(bArr);
    }

    @hk.h(name = "create")
    @hk.i
    @hk.m
    @yt.k
    public static final c0 m(@yt.k byte[] bArr, @yt.l w wVar) {
        return f43548a.k(bArr, wVar);
    }

    @hk.h(name = "create")
    @hk.i
    @hk.m
    @yt.k
    public static final c0 n(@yt.k byte[] bArr, @yt.l w wVar, int i10) {
        return f43548a.l(bArr, wVar, i10);
    }

    @hk.h(name = "create")
    @hk.i
    @hk.m
    @yt.k
    public static final c0 o(@yt.k byte[] bArr, @yt.l w wVar, int i10, int i11) {
        return f43548a.m(bArr, wVar, i10, i11);
    }

    public long a() throws IOException {
        return -1L;
    }

    @yt.l
    public abstract w b();

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(@yt.k okio.k kVar) throws IOException;
}
