package cc;

import android.net.Uri;
import cc.w;
import cc.y;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import fd.h;
import g.p0;
import hd.g0;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0<M extends y<M>> implements w {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10719k = 131072;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f10720l = 20000000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f10721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.a<M> f10722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<StreamKey> f10723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a.d f10724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Cache f10725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fd.f f10726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final PriorityTaskManager f10727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f10728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<g0<?, ?>> f10729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f10730j;

    public class a extends g0<M, IOException> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.google.android.exoplayer2.upstream.a f10731h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ com.google.android.exoplayer2.upstream.b f10732i;

        public a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
            this.f10731h = aVar;
            this.f10732i = bVar;
        }

        @Override // hd.g0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public M d() throws IOException {
            return (M) com.google.android.exoplayer2.upstream.k.h(this.f10731h, c0.this.f10722b, this.f10732i, 4);
        }
    }

    public static final class b implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w.a f10734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f10737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10738e;

        public b(w.a aVar, long j10, int i10, long j11, int i11) {
            this.f10734a = aVar;
            this.f10735b = j10;
            this.f10736c = i10;
            this.f10737d = j11;
            this.f10738e = i11;
        }

        @Override // fd.h.a
        public void a(long j10, long j11, long j12) {
            long j13 = this.f10737d + j12;
            this.f10737d = j13;
            this.f10734a.a(this.f10735b, j13, b());
        }

        public final float b() {
            long j10 = this.f10735b;
            if (j10 != -1 && j10 != 0) {
                return (this.f10737d * 100.0f) / j10;
            }
            int i10 = this.f10736c;
            if (i10 != 0) {
                return (this.f10738e * 100.0f) / i10;
            }
            return -1.0f;
        }

        public void c() {
            this.f10738e++;
            this.f10734a.a(this.f10735b, this.f10737d, b());
        }
    }

    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.b f10740b;

        public c(long j10, com.google.android.exoplayer2.upstream.b bVar) {
            this.f10739a = j10;
            this.f10740b = bVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return u0.r(this.f10739a, cVar.f10739a);
        }
    }

    public static final class d extends g0<Void, IOException> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final c f10741h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.cache.a f10742i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public final b f10743j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final byte[] f10744k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final fd.h f10745l;

        public d(c cVar, com.google.android.exoplayer2.upstream.cache.a aVar, @p0 b bVar, byte[] bArr) {
            this.f10741h = cVar;
            this.f10742i = aVar;
            this.f10743j = bVar;
            this.f10744k = bArr;
            this.f10745l = new fd.h(aVar, cVar.f10740b, false, bArr, bVar);
        }

        @Override // hd.g0
        public void c() {
            this.f10745l.b();
        }

        @Override // hd.g0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void d() throws IOException {
            this.f10745l.a();
            b bVar = this.f10743j;
            if (bVar == null) {
                return null;
            }
            bVar.c();
            return null;
        }
    }

    public c0(v0 v0Var, k.a<M> aVar, a.d dVar, Executor executor) {
        hd.a.g(v0Var.f57132b);
        this.f10721a = f(v0Var.f57132b.f57183a);
        this.f10722b = aVar;
        this.f10723c = new ArrayList<>(v0Var.f57132b.f57187e);
        this.f10724d = dVar;
        this.f10728h = executor;
        this.f10725e = (Cache) hd.a.g(dVar.h());
        this.f10726f = dVar.i();
        this.f10727g = dVar.j();
        this.f10729i = new ArrayList<>();
    }

    public static boolean d(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        if (bVar.f19092a.equals(bVar2.f19092a)) {
            long j10 = bVar.f19099h;
            if (j10 != -1 && bVar.f19098g + j10 == bVar2.f19098g && u0.c(bVar.f19100i, bVar2.f19100i) && bVar.f19101j == bVar2.f19101j && bVar.f19094c == bVar2.f19094c && bVar.f19096e.equals(bVar2.f19096e)) {
                return true;
            }
        }
        return false;
    }

    public static com.google.android.exoplayer2.upstream.b f(Uri uri) {
        return new b.C0198b().j(uri).c(1).a();
    }

    public static void i(List<c> list, fd.f fVar) {
        HashMap map = new HashMap();
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = list.get(i11);
            String strA = fVar.a(cVar.f10740b);
            Integer num = (Integer) map.get(strA);
            c cVar2 = num == null ? null : list.get(num.intValue());
            if (cVar2 == null || cVar.f10739a > cVar2.f10739a + 20000000 || !d(cVar2.f10740b, cVar.f10740b)) {
                map.put(strA, Integer.valueOf(i10));
                list.set(i10, cVar);
                i10++;
            } else {
                long j10 = cVar.f10740b.f19099h;
                list.set(((Integer) hd.a.g(num)).intValue(), new c(cVar2.f10739a, cVar2.f10740b.f(0L, j10 != -1 ? cVar2.f10740b.f19099h + j10 : -1L)));
            }
        }
        u0.f1(list, i10, list.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x01a6 A[LOOP:1: B:84:0x019e->B:86:0x01a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01bf A[LOOP:2: B:88:0x01bd->B:89:0x01bf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d4  */
    @Override // cc.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@g.p0 cc.w.a r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.c0.a(cc.w$a):void");
    }

    public final <T> void c(g0<T, ?> g0Var) throws InterruptedException {
        synchronized (this.f10729i) {
            if (this.f10730j) {
                throw new InterruptedException();
            }
            this.f10729i.add(g0Var);
        }
    }

    @Override // cc.w
    public void cancel() {
        synchronized (this.f10729i) {
            this.f10730j = true;
            for (int i10 = 0; i10 < this.f10729i.size(); i10++) {
                this.f10729i.get(i10).cancel(true);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:23|37|24|(2:27|(2:29|45)(3:44|31|32))(2:26|46)|30) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r0 = (java.lang.Throwable) hd.a.g(r4.getCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if ((r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if ((r0 instanceof java.io.IOException) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        hd.u0.l1(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        throw ((java.io.IOException) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        r3.a();
        k(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> T e(hd.g0<T, ?> r3, boolean r4) throws java.lang.Throwable {
        /*
            r2 = this;
            if (r4 == 0) goto L20
            r3.run()
            java.lang.Object r3 = r3.get()     // Catch: java.util.concurrent.ExecutionException -> La
            return r3
        La:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()
            java.lang.Object r0 = hd.a.g(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            boolean r1 = r0 instanceof java.io.IOException
            if (r1 != 0) goto L1d
            hd.u0.l1(r4)
            goto L20
        L1d:
            java.io.IOException r0 = (java.io.IOException) r0
            throw r0
        L20:
            boolean r4 = r2.f10730j
            if (r4 != 0) goto L6a
            com.google.android.exoplayer2.util.PriorityTaskManager r4 = r2.f10727g
            if (r4 == 0) goto L2d
            r0 = -1000(0xfffffffffffffc18, float:NaN)
            r4.b(r0)
        L2d:
            r2.c(r3)
            java.util.concurrent.Executor r4 = r2.f10728h
            r4.execute(r3)
            java.lang.Object r4 = r3.get()     // Catch: java.lang.Throwable -> L40 java.util.concurrent.ExecutionException -> L42
            r3.a()
            r2.k(r3)
            return r4
        L40:
            r4 = move-exception
            goto L63
        L42:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = hd.a.g(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L40
            boolean r1 = r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L52
            goto L59
        L52:
            boolean r1 = r0 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L60
            hd.u0.l1(r4)     // Catch: java.lang.Throwable -> L40
        L59:
            r3.a()
            r2.k(r3)
            goto L20
        L60:
            java.io.IOException r0 = (java.io.IOException) r0     // Catch: java.lang.Throwable -> L40
            throw r0     // Catch: java.lang.Throwable -> L40
        L63:
            r3.a()
            r2.k(r3)
            throw r4
        L6a:
            java.lang.InterruptedException r3 = new java.lang.InterruptedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.c0.e(hd.g0, boolean):java.lang.Object");
    }

    public final M g(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) throws InterruptedException, IOException {
        return (M) e(new a(aVar, bVar), z10);
    }

    public abstract List<c> h(com.google.android.exoplayer2.upstream.a aVar, M m10, boolean z10) throws InterruptedException, IOException;

    public final void j(int i10) {
        synchronized (this.f10729i) {
            this.f10729i.remove(i10);
        }
    }

    public final void k(g0<?, ?> g0Var) {
        synchronized (this.f10729i) {
            this.f10729i.remove(g0Var);
        }
    }

    @Override // cc.w
    public final void remove() {
        com.google.android.exoplayer2.upstream.cache.a aVarF = this.f10724d.f();
        try {
            try {
                List<c> listH = h(aVarF, g(aVarF, this.f10721a, true), true);
                for (int i10 = 0; i10 < listH.size(); i10++) {
                    this.f10725e.k(this.f10726f.a(listH.get(i10).f10740b));
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception unused2) {
            }
        } finally {
            this.f10725e.k(this.f10726f.a(this.f10721a));
        }
    }
}
