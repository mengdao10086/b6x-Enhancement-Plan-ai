package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<T, Boolean> f38070b;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38072b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public T f38073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f<T> f38074d;

        public a(f<T> fVar) {
            this.f38074d = fVar;
            this.f38071a = fVar.f38069a.iterator();
        }

        public final void a() {
            while (this.f38071a.hasNext()) {
                T next = this.f38071a.next();
                if (!((Boolean) this.f38074d.f38070b.i(next)).booleanValue()) {
                    this.f38073c = next;
                    this.f38072b = 1;
                    return;
                }
            }
            this.f38072b = 0;
        }

        public final int b() {
            return this.f38072b;
        }

        @yt.k
        public final Iterator<T> d() {
            return this.f38071a;
        }

        @yt.l
        public final T e() {
            return this.f38073c;
        }

        public final void g(int i10) {
            this.f38072b = i10;
        }

        public final void h(@yt.l T t10) {
            this.f38073c = t10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38072b == -1) {
                a();
            }
            return this.f38072b == 1 || this.f38071a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f38072b == -1) {
                a();
            }
            if (this.f38072b != 1) {
                return this.f38071a.next();
            }
            T t10 = this.f38073c;
            this.f38073c = null;
            this.f38072b = 0;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@yt.k m<? extends T> sequence, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(sequence, "sequence");
        f0.p(predicate, "predicate");
        this.f38069a = sequence;
        this.f38070b = predicate;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }
}
