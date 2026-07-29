package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class u<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<T, Boolean> f38125b;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38127b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public T f38128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ u<T> f38129d;

        public a(u<T> uVar) {
            this.f38129d = uVar;
            this.f38126a = uVar.f38124a.iterator();
        }

        public final void a() {
            if (this.f38126a.hasNext()) {
                T next = this.f38126a.next();
                if (((Boolean) this.f38129d.f38125b.i(next)).booleanValue()) {
                    this.f38127b = 1;
                    this.f38128c = next;
                    return;
                }
            }
            this.f38127b = 0;
        }

        @yt.k
        public final Iterator<T> b() {
            return this.f38126a;
        }

        @yt.l
        public final T d() {
            return this.f38128c;
        }

        public final int e() {
            return this.f38127b;
        }

        public final void g(@yt.l T t10) {
            this.f38128c = t10;
        }

        public final void h(int i10) {
            this.f38127b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38127b == -1) {
                a();
            }
            return this.f38127b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f38127b == -1) {
                a();
            }
            if (this.f38127b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f38128c;
            this.f38128c = null;
            this.f38127b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(@yt.k m<? extends T> sequence, @yt.k ik.l<? super T, Boolean> predicate) {
        f0.p(sequence, "sequence");
        f0.p(predicate, "predicate");
        this.f38124a = sequence;
        this.f38125b = predicate;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }
}
