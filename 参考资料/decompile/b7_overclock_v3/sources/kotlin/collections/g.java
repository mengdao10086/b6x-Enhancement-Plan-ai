package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.v0(version = "1.1")
public abstract class g<E> extends AbstractCollection<E> implements Set<E>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f37713a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final boolean a(@yt.k Set<?> c10, @yt.k Set<?> other) {
            kotlin.jvm.internal.f0.p(c10, "c");
            kotlin.jvm.internal.f0.p(other, "other");
            if (c10.size() != other.size()) {
                return false;
            }
            return c10.containsAll(other);
        }

        public final int b(@yt.k Collection<?> c10) {
            kotlin.jvm.internal.f0.p(c10, "c");
            Iterator<?> it2 = c10.iterator();
            int iHashCode = 0;
            while (it2.hasNext()) {
                Object next = it2.next();
                iHashCode += next != null ? next.hashCode() : 0;
            }
            return iHashCode;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@yt.l Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return f37713a.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return f37713a.b(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
