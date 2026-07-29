package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class u extends t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Enumeration<T> f37740a;

        public a(Enumeration<T> enumeration) {
            this.f37740a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f37740a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f37740a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @yt.k
    public static final <T> Iterator<T> c0(@yt.k Enumeration<T> enumeration) {
        kotlin.jvm.internal.f0.p(enumeration, "<this>");
        return new a(enumeration);
    }
}
