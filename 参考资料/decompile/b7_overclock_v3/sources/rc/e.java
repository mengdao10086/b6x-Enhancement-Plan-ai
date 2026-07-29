package rc;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import eb.f;
import g.p0;
import hd.u0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import qc.i;
import qc.j;
import rc.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements qc.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f48534g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f48535h = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<b> f48536a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<j> f48537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityQueue<b> f48538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public b f48539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f48540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f48541f;

    public static final class b extends i implements Comparable<b> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f48542m;

        public b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (m() != bVar.m()) {
                return m() ? 1 : -1;
            }
            long j10 = this.f16962e - bVar.f16962e;
            if (j10 == 0) {
                j10 = this.f48542m - bVar.f48542m;
                if (j10 == 0) {
                    return 0;
                }
            }
            return j10 > 0 ? 1 : -1;
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f.a<c> f48543f;

        public c(f.a<c> aVar) {
            this.f48543f = aVar;
        }

        @Override // eb.f
        public final void p() {
            this.f48543f.a(this);
        }
    }

    public e() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f48536a.add(new b());
        }
        this.f48537b = new ArrayDeque<>();
        for (int i11 = 0; i11 < 2; i11++) {
            this.f48537b.add(new c(new f.a() { // from class: rc.d
                @Override // eb.f.a
                public final void a(eb.f fVar) {
                    this.f48533a.n((e.c) fVar);
                }
            }));
        }
        this.f48538c = new PriorityQueue<>();
    }

    @Override // qc.g
    public void a(long j10) {
        this.f48540e = j10;
    }

    public abstract qc.f e();

    public abstract void f(i iVar);

    @Override // eb.c
    public void flush() {
        this.f48541f = 0L;
        this.f48540e = 0L;
        while (!this.f48538c.isEmpty()) {
            m((b) u0.k(this.f48538c.poll()));
        }
        b bVar = this.f48539d;
        if (bVar != null) {
            m(bVar);
            this.f48539d = null;
        }
    }

    @Override // eb.c
    @p0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public i c() throws SubtitleDecoderException {
        hd.a.i(this.f48539d == null);
        if (this.f48536a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f48536a.pollFirst();
        this.f48539d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // eb.c
    public abstract String getName();

    @Override // eb.c
    @p0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public j b() throws SubtitleDecoderException {
        if (this.f48537b.isEmpty()) {
            return null;
        }
        while (!this.f48538c.isEmpty() && ((b) u0.k(this.f48538c.peek())).f16962e <= this.f48540e) {
            b bVar = (b) u0.k(this.f48538c.poll());
            if (bVar.m()) {
                j jVar = (j) u0.k(this.f48537b.pollFirst());
                jVar.g(4);
                m(bVar);
                return jVar;
            }
            f(bVar);
            if (k()) {
                qc.f fVarE = e();
                j jVar2 = (j) u0.k(this.f48537b.pollFirst());
                jVar2.q(bVar.f16962e, fVarE, Long.MAX_VALUE);
                m(bVar);
                return jVar2;
            }
            m(bVar);
        }
        return null;
    }

    @p0
    public final j i() {
        return this.f48537b.pollFirst();
    }

    public final long j() {
        return this.f48540e;
    }

    public abstract boolean k();

    @Override // eb.c
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void d(i iVar) throws SubtitleDecoderException {
        hd.a.a(iVar == this.f48539d);
        b bVar = (b) iVar;
        if (bVar.l()) {
            m(bVar);
        } else {
            long j10 = this.f48541f;
            this.f48541f = 1 + j10;
            bVar.f48542m = j10;
            this.f48538c.add(bVar);
        }
        this.f48539d = null;
    }

    public final void m(b bVar) {
        bVar.h();
        this.f48536a.add(bVar);
    }

    public void n(j jVar) {
        jVar.h();
        this.f48537b.add(jVar);
    }

    @Override // eb.c
    public void release() {
    }
}
