package okhttp3.internal.cache;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import hk.i;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.y;
import kotlin.z1;
import m0.k;
import m9.h;
import okhttp3.internal.cache.DiskLruCache;
import okio.r0;
import okio.t0;
import rl.f;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001e\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0004qr-3B9\b\u0000\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u00104\u001a\u000202\u0012\u0006\u00108\u001a\u000202\u0012\u0006\u0010@\u001a\u00020\u0016\u0012\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bn\u0010oJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u0003J\u000f\u0010\u0012\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\b\u0018\u00010\u0014R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007H\u0086\u0002J \u0010\u0019\u001a\b\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007J\u0006\u0010\u001a\u001a\u00020\u0016J#\u0010\u001d\u001a\u00020\u00032\n\u0010\u001b\u001a\u00060\u0018R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007J\u001b\u0010\"\u001a\u00020\u000b2\n\u0010!\u001a\u00060 R\u00020\u0000H\u0000¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u0003H\u0016J\u0006\u0010%\u001a\u00020\u000bJ\b\u0010&\u001a\u00020\u0003H\u0016J\u0006\u0010'\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0003J\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0014R\u00020\u00000*R\u0017\u00101\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0019R\u001a\u00108\u001a\u0002028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u0010\u0019\u001a\u0004\b6\u00107R*\u0010@\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010.R\u0014\u0010D\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010.R\u0014\u0010F\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010.R\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010;R\u0018\u0010K\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR*\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060 R\u00020\u00000L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010S\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010\u0019R\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010TR\u0016\u0010V\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010TR\u0016\u0010X\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010TR\"\u0010^\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010TR\u0016\u0010b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010TR\u0016\u0010d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010;R\u0014\u0010g\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010fR\u001a\u0010i\u001a\u00020h8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bT\u0010k¨\u0006s"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lkotlin/z1;", h.B, "Lokio/k;", "h1", "", "line", "m1", "i1", "", h.f40774q, k.f40564b, "z1", "key", "h2", "M0", "p1", "()V", "Lokhttp3/internal/cache/DiskLruCache$c;", "P", "", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "I", "V1", "editor", "success", "n", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "s1", "Lokhttp3/internal/cache/DiskLruCache$b;", "entry", "u1", "(Lokhttp3/internal/cache/DiskLruCache$b;)Z", "flush", "isClosed", "close", "f2", "u", "M", "", "Y1", "Ljava/io/File;", "b", "Ljava/io/File;", i1.a.T4, "()Ljava/io/File;", "directory", "", "c", "appVersion", "d", "G0", "()I", "valueCount", "value", "e", "J", "F0", "()J", "L1", "(J)V", "maxSize", "f", "journalFile", "g", "journalFileTmp", "h", "journalFileBackup", "i", "size", j.f55230b, "Lokio/k;", "journalWriter", "Ljava/util/LinkedHashMap;", "k", "Ljava/util/LinkedHashMap;", "b0", "()Ljava/util/LinkedHashMap;", "lruEntries", l.f16298a, "redundantOpCount", "Z", "hasJournalErrors", "civilizedFileSystem", "o", "initialized", "p", i1.a.f31577d5, "()Z", "C1", "(Z)V", "closed", "q", "mostRecentTrimFailed", SsManifestParser.e.J, "mostRecentRebuildFailed", an.aB, "nextSequenceNumber", "okhttp3/internal/cache/DiskLruCache$d", "Lokhttp3/internal/cache/DiskLruCache$d;", "cleanupTask", "Lyl/a;", "fileSystem", "Lyl/a;", "()Lyl/a;", "Lul/d;", "taskRunner", "<init>", "(Lyl/a;Ljava/io/File;IIJLul/d;)V", "v", "a", "Editor", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class DiskLruCache implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final yl.a f43698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final File f43699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f43700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f43702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final File f43703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final File f43704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final File f43705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f43706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public okio.k f43707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public final LinkedHashMap<String, b> f43708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f43709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f43710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f43711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f43712o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f43713p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f43714q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f43715r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f43716s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @yt.k
    public final ul.c f43717t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public final d f43718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @yt.k
    public static final a f43693v = new a(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f43694w = z3.a.f57677o;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f43695x = z3.a.f57678p;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f43696y = z3.a.f57679q;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f43697z = z3.a.f57680r;

    @hk.e
    @yt.k
    public static final String A = "1";

    @hk.e
    public static final long B = -1;

    @hk.e
    @yt.k
    public static final Regex C = new Regex("[a-z0-9_-]{1,120}");

    @hk.e
    @yt.k
    public static final String D = z3.a.f57683u;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f43691k0 = z3.a.f57684v;

    @hk.e
    @yt.k
    public static final String K0 = z3.a.f57685w;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f43692k1 = z3.a.f57686x;

    @d0(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0012\u001a\u00060\rR\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u001e\u0010\u0012\u001a\u00060\rR\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lkotlin/z1;", "c", "()V", "", "index", "Lokio/t0;", "g", "Lokio/r0;", "f", "b", "a", "Lokhttp3/internal/cache/DiskLruCache$b;", "Lokhttp3/internal/cache/DiskLruCache;", "Lokhttp3/internal/cache/DiskLruCache$b;", "d", "()Lokhttp3/internal/cache/DiskLruCache$b;", "entry", "", "[Z", "e", "()[Z", "written", "", "Z", "done", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final b f43719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public final boolean[] f43720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f43721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f43722d;

        public Editor(@yt.k DiskLruCache this$0, b entry) {
            f0.p(this$0, "this$0");
            f0.p(entry, "entry");
            this.f43722d = this$0;
            this.f43719a = entry;
            this.f43720b = entry.g() ? null : new boolean[this$0.G0()];
        }

        public final void a() throws IOException {
            DiskLruCache diskLruCache = this.f43722d;
            synchronized (diskLruCache) {
                if (!(!this.f43721c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (f0.g(d().b(), this)) {
                    diskLruCache.n(this, false);
                }
                this.f43721c = true;
                z1 z1Var = z1.f38230a;
            }
        }

        public final void b() throws IOException {
            DiskLruCache diskLruCache = this.f43722d;
            synchronized (diskLruCache) {
                if (!(!this.f43721c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (f0.g(d().b(), this)) {
                    diskLruCache.n(this, true);
                }
                this.f43721c = true;
                z1 z1Var = z1.f38230a;
            }
        }

        public final void c() throws IOException {
            if (f0.g(this.f43719a.b(), this)) {
                if (this.f43722d.f43711n) {
                    this.f43722d.n(this, false);
                } else {
                    this.f43719a.q(true);
                }
            }
        }

        @yt.k
        public final b d() {
            return this.f43719a;
        }

        @yt.l
        public final boolean[] e() {
            return this.f43720b;
        }

        @yt.k
        public final r0 f(int i10) {
            final DiskLruCache diskLruCache = this.f43722d;
            synchronized (diskLruCache) {
                if (!(!this.f43721c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!f0.g(d().b(), this)) {
                    return okio.f0.c();
                }
                if (!d().g()) {
                    boolean[] zArrE = e();
                    f0.m(zArrE);
                    zArrE[i10] = true;
                }
                try {
                    return new okhttp3.internal.cache.d(diskLruCache.Z().b(d().c().get(i10)), new ik.l<IOException, z1>() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void b(@yt.k IOException it2) {
                            f0.p(it2, "it");
                            DiskLruCache diskLruCache2 = diskLruCache;
                            DiskLruCache.Editor editor = this;
                            synchronized (diskLruCache2) {
                                editor.c();
                                z1 z1Var = z1.f38230a;
                            }
                        }

                        @Override // ik.l
                        public /* bridge */ /* synthetic */ z1 i(IOException iOException) {
                            b(iOException);
                            return z1.f38230a;
                        }
                    });
                } catch (FileNotFoundException unused) {
                    return okio.f0.c();
                }
            }
        }

        @yt.l
        public final t0 g(int i10) {
            DiskLruCache diskLruCache = this.f43722d;
            synchronized (diskLruCache) {
                if (!(!this.f43721c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                t0 t0VarA = null;
                if (!d().g() || !f0.g(d().b(), this) || d().i()) {
                    return null;
                }
                try {
                    t0VarA = diskLruCache.Z().a(d().a().get(i10));
                } catch (FileNotFoundException unused) {
                }
                return t0VarA;
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$a;", "", "", "ANY_SEQUENCE_NUMBER", "J", "", z3.a.f57683u, "Ljava/lang/String;", z3.a.f57684v, "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "Lkotlin/text/Regex;", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", z3.a.f57686x, z3.a.f57685w, "VERSION_1", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @d0(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\bE\u0010FJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0018\u00010\fR\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u001a\u0010\u001a\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u0016\u0010%R \u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b#\u0010%R\"\u0010.\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00102\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R(\u00108\u001a\b\u0018\u000103R\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u00104\u001a\u0004\b\u001c\u00105\"\u0004\b6\u00107R\"\u0010>\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b/\u0010;\"\u0004\b<\u0010=R\"\u0010D\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010@\u001a\u0004\b9\u0010A\"\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$b;", "", "", "", "strings", "Lkotlin/z1;", k.f40564b, "(Ljava/util/List;)V", "Lokio/k;", "writer", an.aB, "(Lokio/k;)V", "Lokhttp3/internal/cache/DiskLruCache$c;", "Lokhttp3/internal/cache/DiskLruCache;", SsManifestParser.e.J, "()Lokhttp3/internal/cache/DiskLruCache$c;", "", j.f55230b, "", "index", "Lokio/t0;", "k", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "key", "", "b", "[J", "e", "()[J", "lengths", "", "Ljava/io/File;", "c", "Ljava/util/List;", "()Ljava/util/List;", "cleanFiles", "dirtyFiles", "", "Z", "g", "()Z", "o", "(Z)V", "readable", "f", "i", "q", "zombie", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", l.f16298a, "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "currentEditor", "h", "I", "()I", "n", "(I)V", "lockingSourceCount", "", "J", "()J", "p", "(J)V", "sequenceNumber", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final String f43723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final long[] f43724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<File> f43725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final List<File> f43726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f43727e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f43728f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.l
        public Editor f43729g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f43730h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f43731i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f43732j;

        @d0(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"okhttp3/internal/cache/DiskLruCache$b$a", "Lokio/u;", "Lkotlin/z1;", "close", "", "b", "Z", "closed", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends okio.u {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f43733b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ t0 f43734c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ DiskLruCache f43735d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f43736e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(t0 t0Var, DiskLruCache diskLruCache, b bVar) {
                super(t0Var);
                this.f43734c = t0Var;
                this.f43735d = diskLruCache;
                this.f43736e = bVar;
            }

            @Override // okio.u, okio.t0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                if (this.f43733b) {
                    return;
                }
                this.f43733b = true;
                DiskLruCache diskLruCache = this.f43735d;
                b bVar = this.f43736e;
                synchronized (diskLruCache) {
                    bVar.n(bVar.f() - 1);
                    if (bVar.f() == 0 && bVar.i()) {
                        diskLruCache.u1(bVar);
                    }
                    z1 z1Var = z1.f38230a;
                }
            }
        }

        public b(@yt.k DiskLruCache this$0, String key) {
            f0.p(this$0, "this$0");
            f0.p(key, "key");
            this.f43732j = this$0;
            this.f43723a = key;
            this.f43724b = new long[this$0.G0()];
            this.f43725c = new ArrayList();
            this.f43726d = new ArrayList();
            StringBuilder sb2 = new StringBuilder(key);
            sb2.append('.');
            int length = sb2.length();
            int iG0 = this$0.G0();
            for (int i10 = 0; i10 < iG0; i10++) {
                sb2.append(i10);
                this.f43725c.add(new File(this.f43732j.W(), sb2.toString()));
                sb2.append(".tmp");
                this.f43726d.add(new File(this.f43732j.W(), sb2.toString()));
                sb2.setLength(length);
            }
        }

        @yt.k
        public final List<File> a() {
            return this.f43725c;
        }

        @yt.l
        public final Editor b() {
            return this.f43729g;
        }

        @yt.k
        public final List<File> c() {
            return this.f43726d;
        }

        @yt.k
        public final String d() {
            return this.f43723a;
        }

        @yt.k
        public final long[] e() {
            return this.f43724b;
        }

        public final int f() {
            return this.f43730h;
        }

        public final boolean g() {
            return this.f43727e;
        }

        public final long h() {
            return this.f43731i;
        }

        public final boolean i() {
            return this.f43728f;
        }

        public final Void j(List<String> list) throws IOException {
            throw new IOException(f0.C("unexpected journal line: ", list));
        }

        public final t0 k(int i10) throws FileNotFoundException {
            t0 t0VarA = this.f43732j.Z().a(this.f43725c.get(i10));
            if (this.f43732j.f43711n) {
                return t0VarA;
            }
            this.f43730h++;
            return new a(t0VarA, this.f43732j, this);
        }

        public final void l(@yt.l Editor editor) {
            this.f43729g = editor;
        }

        public final void m(@yt.k List<String> strings) throws IOException {
            f0.p(strings, "strings");
            if (strings.size() != this.f43732j.G0()) {
                j(strings);
                throw new KotlinNothingValueException();
            }
            int i10 = 0;
            try {
                int size = strings.size();
                while (i10 < size) {
                    int i11 = i10 + 1;
                    this.f43724b[i10] = Long.parseLong(strings.get(i10));
                    i10 = i11;
                }
            } catch (NumberFormatException unused) {
                j(strings);
                throw new KotlinNothingValueException();
            }
        }

        public final void n(int i10) {
            this.f43730h = i10;
        }

        public final void o(boolean z10) {
            this.f43727e = z10;
        }

        public final void p(long j10) {
            this.f43731i = j10;
        }

        public final void q(boolean z10) {
            this.f43728f = z10;
        }

        @yt.l
        public final c r() {
            DiskLruCache diskLruCache = this.f43732j;
            if (f.f48803h && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            }
            if (!this.f43727e) {
                return null;
            }
            if (!this.f43732j.f43711n && (this.f43729g != null || this.f43728f)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.f43724b.clone();
            try {
                int iG0 = this.f43732j.G0();
                for (int i10 = 0; i10 < iG0; i10++) {
                    arrayList.add(k(i10));
                }
                return new c(this.f43732j, this.f43723a, this.f43731i, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f.o((t0) it2.next());
                }
                try {
                    this.f43732j.u1(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void s(@yt.k okio.k writer) throws IOException {
            f0.p(writer, "writer");
            long[] jArr = this.f43724b;
            int length = jArr.length;
            int i10 = 0;
            while (i10 < length) {
                long j10 = jArr[i10];
                i10++;
                writer.writeByte(32).W1(j10);
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$c;", "Ljava/io/Closeable;", "", "f", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "a", "", "index", "Lokio/t0;", "d", "", "c", "Lkotlin/z1;", "close", "Ljava/lang/String;", "key", "b", "J", "sequenceNumber", "", "Ljava/util/List;", "sources", "", "[J", "lengths", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final String f43737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<t0> f43739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final long[] f43740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f43741e;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@yt.k DiskLruCache this$0, String key, @yt.k long j10, @yt.k List<? extends t0> sources, long[] lengths) {
            f0.p(this$0, "this$0");
            f0.p(key, "key");
            f0.p(sources, "sources");
            f0.p(lengths, "lengths");
            this.f43741e = this$0;
            this.f43737a = key;
            this.f43738b = j10;
            this.f43739c = sources;
            this.f43740d = lengths;
        }

        @yt.l
        public final Editor a() throws IOException {
            return this.f43741e.I(this.f43737a, this.f43738b);
        }

        public final long c(int i10) {
            return this.f43740d[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<t0> it2 = this.f43739c.iterator();
            while (it2.hasNext()) {
                f.o(it2.next());
            }
        }

        @yt.k
        public final t0 d(int i10) {
            return this.f43739c.get(i10);
        }

        @yt.k
        public final String f() {
            return this.f43737a;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/cache/DiskLruCache$d", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class d extends ul.a {
        public d(String str) {
            super(str, false, 2, null);
        }

        @Override // ul.a
        public long f() {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!diskLruCache.f43712o || diskLruCache.T()) {
                    return -1L;
                }
                try {
                    diskLruCache.f2();
                } catch (IOException unused) {
                    diskLruCache.f43714q = true;
                }
                try {
                    if (diskLruCache.d1()) {
                        diskLruCache.p1();
                        diskLruCache.f43709l = 0;
                    }
                } catch (IOException unused2) {
                    diskLruCache.f43715r = true;
                    diskLruCache.f43707j = okio.f0.d(okio.f0.c());
                }
                return -1L;
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\r\u0010\u0006\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R*\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012 \n*\b\u0018\u00010\tR\u00020\u00030\tR\u00020\u00030\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"okhttp3/internal/cache/DiskLruCache$e", "", "Lokhttp3/internal/cache/DiskLruCache$c;", "Lokhttp3/internal/cache/DiskLruCache;", "", "hasNext", "a", "Lkotlin/z1;", "remove", "Lokhttp3/internal/cache/DiskLruCache$b;", "kotlin.jvm.PlatformType", "Ljava/util/Iterator;", "delegate", "b", "Lokhttp3/internal/cache/DiskLruCache$c;", "nextSnapshot", "c", "removeSnapshot", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class e implements Iterator<c>, jk.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<b> f43743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public c f43744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public c f43745c;

        public e() {
            Iterator<b> it2 = new ArrayList(DiskLruCache.this.b0().values()).iterator();
            f0.o(it2, "ArrayList(lruEntries.values).iterator()");
            this.f43743a = it2;
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c cVar = this.f43744b;
            this.f43745c = cVar;
            this.f43744b = null;
            f0.m(cVar);
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f43744b != null) {
                return true;
            }
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (diskLruCache.T()) {
                    return false;
                }
                while (this.f43743a.hasNext()) {
                    b next = this.f43743a.next();
                    c cVarR = next == null ? null : next.r();
                    if (cVarR != null) {
                        this.f43744b = cVarR;
                        return true;
                    }
                }
                z1 z1Var = z1.f38230a;
                return false;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            c cVar = this.f43745c;
            if (cVar == null) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            try {
                DiskLruCache.this.s1(cVar.f());
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.f43745c = null;
                throw th2;
            }
            this.f43745c = null;
        }
    }

    public DiskLruCache(@yt.k yl.a fileSystem, @yt.k File directory, int i10, int i11, long j10, @yt.k ul.d taskRunner) {
        f0.p(fileSystem, "fileSystem");
        f0.p(directory, "directory");
        f0.p(taskRunner, "taskRunner");
        this.f43698a = fileSystem;
        this.f43699b = directory;
        this.f43700c = i10;
        this.f43701d = i11;
        this.f43702e = j10;
        this.f43708k = new LinkedHashMap<>(0, 0.75f, true);
        this.f43717t = taskRunner.j();
        this.f43718u = new d(f0.C(f.f48804i, " Cache"));
        if (!(j10 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i11 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.f43703f = new File(directory, f43694w);
        this.f43704g = new File(directory, f43695x);
        this.f43705h = new File(directory, f43696y);
    }

    public static /* synthetic */ Editor L(DiskLruCache diskLruCache, String str, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = B;
        }
        return diskLruCache.I(str, j10);
    }

    public final void C1(boolean z10) {
        this.f43713p = z10;
    }

    public final synchronized long F0() {
        return this.f43702e;
    }

    public final int G0() {
        return this.f43701d;
    }

    @i
    @yt.l
    public final synchronized Editor I(@yt.k String key, long j10) throws IOException {
        f0.p(key, "key");
        M0();
        m();
        h2(key);
        b bVar = this.f43708k.get(key);
        if (j10 != B && (bVar == null || bVar.h() != j10)) {
            return null;
        }
        if ((bVar == null ? null : bVar.b()) != null) {
            return null;
        }
        if (bVar != null && bVar.f() != 0) {
            return null;
        }
        if (!this.f43714q && !this.f43715r) {
            okio.k kVar = this.f43707j;
            f0.m(kVar);
            kVar.H0(f43691k0).writeByte(32).H0(key).writeByte(10);
            kVar.flush();
            if (this.f43710m) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(this, key);
                this.f43708k.put(key, bVar);
            }
            Editor editor = new Editor(this, bVar);
            bVar.l(editor);
            return editor;
        }
        ul.c.p(this.f43717t, this.f43718u, 0L, 2, null);
        return null;
    }

    public final synchronized void L1(long j10) {
        this.f43702e = j10;
        if (this.f43712o) {
            ul.c.p(this.f43717t, this.f43718u, 0L, 2, null);
        }
    }

    public final synchronized void M() throws IOException {
        M0();
        Collection<b> collectionValues = this.f43708k.values();
        f0.o(collectionValues, "lruEntries.values");
        Object[] array = collectionValues.toArray(new b[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        b[] bVarArr = (b[]) array;
        int length = bVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            b entry = bVarArr[i10];
            i10++;
            f0.o(entry, "entry");
            u1(entry);
        }
        this.f43714q = false;
    }

    public final synchronized void M0() throws IOException {
        if (f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.f43712o) {
            return;
        }
        if (this.f43698a.d(this.f43705h)) {
            if (this.f43698a.d(this.f43703f)) {
                this.f43698a.f(this.f43705h);
            } else {
                this.f43698a.e(this.f43705h, this.f43703f);
            }
        }
        this.f43711n = f.M(this.f43698a, this.f43705h);
        if (this.f43698a.d(this.f43703f)) {
            try {
                k1();
                i1();
                this.f43712o = true;
                return;
            } catch (IOException e10) {
                zl.h.f58636a.g().m("DiskLruCache " + this.f43699b + " is corrupt: " + ((Object) e10.getMessage()) + ", removing", 5, e10);
                try {
                    u();
                    this.f43713p = false;
                    p1();
                    this.f43712o = true;
                } catch (Throwable th2) {
                    this.f43713p = false;
                    throw th2;
                }
            }
        }
        p1();
        this.f43712o = true;
    }

    @yt.l
    public final synchronized c P(@yt.k String key) throws IOException {
        f0.p(key, "key");
        M0();
        m();
        h2(key);
        b bVar = this.f43708k.get(key);
        if (bVar == null) {
            return null;
        }
        c cVarR = bVar.r();
        if (cVarR == null) {
            return null;
        }
        this.f43709l++;
        okio.k kVar = this.f43707j;
        f0.m(kVar);
        kVar.H0(f43692k1).writeByte(32).H0(key).writeByte(10);
        if (d1()) {
            ul.c.p(this.f43717t, this.f43718u, 0L, 2, null);
        }
        return cVarR;
    }

    public final boolean T() {
        return this.f43713p;
    }

    public final synchronized long V1() throws IOException {
        M0();
        return this.f43706i;
    }

    @yt.k
    public final File W() {
        return this.f43699b;
    }

    @yt.k
    public final synchronized Iterator<c> Y1() throws IOException {
        M0();
        return new e();
    }

    @yt.k
    public final yl.a Z() {
        return this.f43698a;
    }

    @yt.k
    public final LinkedHashMap<String, b> b0() {
        return this.f43708k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor editorB;
        if (this.f43712o && !this.f43713p) {
            Collection<b> collectionValues = this.f43708k.values();
            f0.o(collectionValues, "lruEntries.values");
            int i10 = 0;
            Object[] array = collectionValues.toArray(new b[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            b[] bVarArr = (b[]) array;
            int length = bVarArr.length;
            while (i10 < length) {
                b bVar = bVarArr[i10];
                i10++;
                if (bVar.b() != null && (editorB = bVar.b()) != null) {
                    editorB.c();
                }
            }
            f2();
            okio.k kVar = this.f43707j;
            f0.m(kVar);
            kVar.close();
            this.f43707j = null;
            this.f43713p = true;
            return;
        }
        this.f43713p = true;
    }

    public final boolean d1() {
        int i10 = this.f43709l;
        return i10 >= 2000 && i10 >= this.f43708k.size();
    }

    public final void f2() throws IOException {
        while (this.f43706i > this.f43702e) {
            if (!z1()) {
                return;
            }
        }
        this.f43714q = false;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f43712o) {
            m();
            f2();
            okio.k kVar = this.f43707j;
            f0.m(kVar);
            kVar.flush();
        }
    }

    public final okio.k h1() throws FileNotFoundException {
        return okio.f0.d(new okhttp3.internal.cache.d(this.f43698a.g(this.f43703f), new ik.l<IOException, z1>() { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            {
                super(1);
            }

            public final void b(@yt.k IOException it2) {
                f0.p(it2, "it");
                DiskLruCache diskLruCache = this.this$0;
                if (!f.f48803h || Thread.holdsLock(diskLruCache)) {
                    this.this$0.f43710m = true;
                    return;
                }
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(IOException iOException) {
                b(iOException);
                return z1.f38230a;
            }
        }));
    }

    public final void h2(String str) {
        if (C.n(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + y.f38188b).toString());
    }

    public final void i1() throws IOException {
        this.f43698a.f(this.f43704g);
        Iterator<b> it2 = this.f43708k.values().iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            f0.o(next, "i.next()");
            b bVar = next;
            int i10 = 0;
            if (bVar.b() == null) {
                int i11 = this.f43701d;
                while (i10 < i11) {
                    this.f43706i += bVar.e()[i10];
                    i10++;
                }
            } else {
                bVar.l(null);
                int i12 = this.f43701d;
                while (i10 < i12) {
                    this.f43698a.f(bVar.a().get(i10));
                    this.f43698a.f(bVar.c().get(i10));
                    i10++;
                }
                it2.remove();
            }
        }
    }

    public final synchronized boolean isClosed() {
        return this.f43713p;
    }

    public final void k1() throws IOException {
        okio.l lVarE = okio.f0.e(this.f43698a.a(this.f43703f));
        try {
            String strN1 = lVarE.n1();
            String strN12 = lVarE.n1();
            String strN13 = lVarE.n1();
            String strN14 = lVarE.n1();
            String strN15 = lVarE.n1();
            if (f0.g(f43697z, strN1) && f0.g(A, strN12) && f0.g(String.valueOf(this.f43700c), strN13) && f0.g(String.valueOf(G0()), strN14)) {
                int i10 = 0;
                if (!(strN15.length() > 0)) {
                    while (true) {
                        try {
                            m1(lVarE.n1());
                            i10++;
                        } catch (EOFException unused) {
                            this.f43709l = i10 - b0().size();
                            if (lVarE.d0()) {
                                this.f43707j = h1();
                            } else {
                                p1();
                            }
                            z1 z1Var = z1.f38230a;
                            kotlin.io.b.a(lVarE, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + strN1 + ", " + strN12 + ", " + strN14 + ", " + strN15 + ']');
        } finally {
        }
    }

    public final synchronized void m() {
        if (!(!this.f43713p)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public final void m1(String str) throws IOException {
        String strSubstring;
        int iR3 = StringsKt__StringsKt.r3(str, zc.f.f58383m, 0, false, 6, null);
        if (iR3 == -1) {
            throw new IOException(f0.C("unexpected journal line: ", str));
        }
        int i10 = iR3 + 1;
        int iR32 = StringsKt__StringsKt.r3(str, zc.f.f58383m, i10, false, 4, null);
        if (iR32 == -1) {
            strSubstring = str.substring(i10);
            f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            String str2 = K0;
            if (iR3 == str2.length() && kotlin.text.u.v2(str, str2, false, 2, null)) {
                this.f43708k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iR32);
            f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        b bVar = this.f43708k.get(strSubstring);
        if (bVar == null) {
            bVar = new b(this, strSubstring);
            this.f43708k.put(strSubstring, bVar);
        }
        if (iR32 != -1) {
            String str3 = D;
            if (iR3 == str3.length() && kotlin.text.u.v2(str, str3, false, 2, null)) {
                String strSubstring2 = str.substring(iR32 + 1);
                f0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
                List<String> listT4 = StringsKt__StringsKt.T4(strSubstring2, new char[]{zc.f.f58383m}, false, 0, 6, null);
                bVar.o(true);
                bVar.l(null);
                bVar.m(listT4);
                return;
            }
        }
        if (iR32 == -1) {
            String str4 = f43691k0;
            if (iR3 == str4.length() && kotlin.text.u.v2(str, str4, false, 2, null)) {
                bVar.l(new Editor(this, bVar));
                return;
            }
        }
        if (iR32 == -1) {
            String str5 = f43692k1;
            if (iR3 == str5.length() && kotlin.text.u.v2(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException(f0.C("unexpected journal line: ", str));
    }

    public final synchronized void n(@yt.k Editor editor, boolean z10) throws IOException {
        f0.p(editor, "editor");
        b bVarD = editor.d();
        if (!f0.g(bVarD.b(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int i10 = 0;
        if (z10 && !bVarD.g()) {
            int i11 = this.f43701d;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                boolean[] zArrE = editor.e();
                f0.m(zArrE);
                if (!zArrE[i12]) {
                    editor.a();
                    throw new IllegalStateException(f0.C("Newly created entry didn't create value for index ", Integer.valueOf(i12)));
                }
                if (!this.f43698a.d(bVarD.c().get(i12))) {
                    editor.a();
                    return;
                }
                i12 = i13;
            }
        }
        int i14 = this.f43701d;
        while (i10 < i14) {
            int i15 = i10 + 1;
            File file = bVarD.c().get(i10);
            if (!z10 || bVarD.i()) {
                this.f43698a.f(file);
            } else if (this.f43698a.d(file)) {
                File file2 = bVarD.a().get(i10);
                this.f43698a.e(file, file2);
                long j10 = bVarD.e()[i10];
                long jH = this.f43698a.h(file2);
                bVarD.e()[i10] = jH;
                this.f43706i = (this.f43706i - j10) + jH;
            }
            i10 = i15;
        }
        bVarD.l(null);
        if (bVarD.i()) {
            u1(bVarD);
            return;
        }
        this.f43709l++;
        okio.k kVar = this.f43707j;
        f0.m(kVar);
        if (bVarD.g() || z10) {
            bVarD.o(true);
            kVar.H0(D).writeByte(32);
            kVar.H0(bVarD.d());
            bVarD.s(kVar);
            kVar.writeByte(10);
            if (z10) {
                long j11 = this.f43716s;
                this.f43716s = 1 + j11;
                bVarD.p(j11);
            }
        } else {
            b0().remove(bVarD.d());
            kVar.H0(K0).writeByte(32);
            kVar.H0(bVarD.d());
            kVar.writeByte(10);
        }
        kVar.flush();
        if (this.f43706i > this.f43702e || d1()) {
            ul.c.p(this.f43717t, this.f43718u, 0L, 2, null);
        }
    }

    public final synchronized void p1() throws IOException {
        okio.k kVar = this.f43707j;
        if (kVar != null) {
            kVar.close();
        }
        okio.k kVarD = okio.f0.d(this.f43698a.b(this.f43704g));
        try {
            kVarD.H0(f43697z).writeByte(10);
            kVarD.H0(A).writeByte(10);
            kVarD.W1(this.f43700c).writeByte(10);
            kVarD.W1(G0()).writeByte(10);
            kVarD.writeByte(10);
            for (b bVar : b0().values()) {
                if (bVar.b() != null) {
                    kVarD.H0(f43691k0).writeByte(32);
                    kVarD.H0(bVar.d());
                    kVarD.writeByte(10);
                } else {
                    kVarD.H0(D).writeByte(32);
                    kVarD.H0(bVar.d());
                    bVar.s(kVarD);
                    kVarD.writeByte(10);
                }
            }
            z1 z1Var = z1.f38230a;
            kotlin.io.b.a(kVarD, null);
            if (this.f43698a.d(this.f43703f)) {
                this.f43698a.e(this.f43703f, this.f43705h);
            }
            this.f43698a.e(this.f43704g, this.f43703f);
            this.f43698a.f(this.f43705h);
            this.f43707j = h1();
            this.f43710m = false;
            this.f43715r = false;
        } finally {
        }
    }

    public final synchronized boolean s1(@yt.k String key) throws IOException {
        f0.p(key, "key");
        M0();
        m();
        h2(key);
        b bVar = this.f43708k.get(key);
        if (bVar == null) {
            return false;
        }
        boolean zU1 = u1(bVar);
        if (zU1 && this.f43706i <= this.f43702e) {
            this.f43714q = false;
        }
        return zU1;
    }

    public final void u() throws IOException {
        close();
        this.f43698a.c(this.f43699b);
    }

    public final boolean u1(@yt.k b entry) throws IOException {
        okio.k kVar;
        f0.p(entry, "entry");
        if (!this.f43711n) {
            if (entry.f() > 0 && (kVar = this.f43707j) != null) {
                kVar.H0(f43691k0);
                kVar.writeByte(32);
                kVar.H0(entry.d());
                kVar.writeByte(10);
                kVar.flush();
            }
            if (entry.f() > 0 || entry.b() != null) {
                entry.q(true);
                return true;
            }
        }
        Editor editorB = entry.b();
        if (editorB != null) {
            editorB.c();
        }
        int i10 = this.f43701d;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f43698a.f(entry.a().get(i11));
            this.f43706i -= entry.e()[i11];
            entry.e()[i11] = 0;
        }
        this.f43709l++;
        okio.k kVar2 = this.f43707j;
        if (kVar2 != null) {
            kVar2.H0(K0);
            kVar2.writeByte(32);
            kVar2.H0(entry.d());
            kVar2.writeByte(10);
        }
        this.f43708k.remove(entry.d());
        if (d1()) {
            ul.c.p(this.f43717t, this.f43718u, 0L, 2, null);
        }
        return true;
    }

    @i
    @yt.l
    public final Editor z(@yt.k String key) throws IOException {
        f0.p(key, "key");
        return L(this, key, 0L, 2, null);
    }

    public final boolean z1() throws IOException {
        for (b toEvict : this.f43708k.values()) {
            if (!toEvict.i()) {
                f0.o(toEvict, "toEvict");
                u1(toEvict);
                return true;
            }
        }
        return false;
    }
}
