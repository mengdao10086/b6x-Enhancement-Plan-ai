package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> implements Iterator<T>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public State f37675a = State.NotReady;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public T f37676b;

    /* JADX INFO: renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0428a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37677a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f37677a = iArr;
        }
    }

    public abstract void a();

    public final void b() {
        this.f37675a = State.Done;
    }

    public final void d(T t10) {
        this.f37676b = t10;
        this.f37675a = State.Ready;
    }

    public final boolean e() {
        this.f37675a = State.Failed;
        a();
        return this.f37675a == State.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.f37675a;
        if (!(state != State.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i10 = C0428a.f37677a[state.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return e();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f37675a = State.NotReady;
        return this.f37676b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
