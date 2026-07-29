package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f38077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final ik.l<T, Boolean> f38078c;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38080b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public T f38081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h<T> f38082d;

        public a(h<T> hVar) {
            this.f38082d = hVar;
            this.f38079a = hVar.f38076a.iterator();
        }

        public final void a() {
            while (this.f38079a.hasNext()) {
                T next = this.f38079a.next();
                if (((Boolean) this.f38082d.f38078c.i(next)).booleanValue() == this.f38082d.f38077b) {
                    this.f38081c = next;
                    this.f38080b = 1;
                    return;
                }
            }
            this.f38080b = 0;
        }

        @yt.k
        public final Iterator<T> b() {
            return this.f38079a;
        }

        @yt.l
        public final T d() {
            return this.f38081c;
        }

        public final int e() {
            return this.f38080b;
        }

        public final void g(@yt.l T t10) {
            this.f38081c = t10;
        }

        public final void h(int i10) {
            this.f38080b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38080b == -1) {
                a();
            }
            return this.f38080b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f38080b == -1) {
                a();
            }
            if (this.f38080b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f38081c;
            this.f38081c = null;
            this.f38080b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@yt.k m<? extends T> sequence, boolean z10, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(sequence, "sequence");
        f0.p(predicate, "predicate");
        this.f38076a = sequence;
        this.f38077b = z10;
        this.f38078c = predicate;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }

    public /* synthetic */ h(m mVar, boolean z10, ik.l lVar, int i10, kotlin.jvm.internal.u uVar) {
        this(mVar, (i10 & 2) != 0 ? true : z10, lVar);
    }
}
