package h4;

import g.i1;
import g.n0;
import g.p0;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class m<A, B> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30479b = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4.j<b<A>, B> f30480a;

    public class a extends v4.j<b<A>, B> {
        public a(long j10) {
            super(j10);
        }

        @Override // v4.j
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void n(@n0 b<A> bVar, @p0 B b10) {
            bVar.c();
        }
    }

    @i1
    public static final class b<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Queue<b<?>> f30482d = v4.o.f(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f30484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public A f30485c;

        public static <A> b<A> a(A a10, int i10, int i11) {
            b<A> bVar;
            Queue<b<?>> queue = f30482d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a10, i10, i11);
            return bVar;
        }

        public final void b(A a10, int i10, int i11) {
            this.f30485c = a10;
            this.f30484b = i10;
            this.f30483a = i11;
        }

        public void c() {
            Queue<b<?>> queue = f30482d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f30484b == bVar.f30484b && this.f30483a == bVar.f30483a && this.f30485c.equals(bVar.f30485c);
        }

        public int hashCode() {
            return (((this.f30483a * 31) + this.f30484b) * 31) + this.f30485c.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public void a() {
        this.f30480a.c();
    }

    @p0
    public B b(A a10, int i10, int i11) {
        b<A> bVarA = b.a(a10, i10, i11);
        B bK = this.f30480a.k(bVarA);
        bVarA.c();
        return bK;
    }

    public void c(A a10, int i10, int i11, B b10) {
        this.f30480a.o(b.a(a10, i10, i11), b10);
    }

    public m(long j10) {
        this.f30480a = new a(j10);
    }
}
