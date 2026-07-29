package androidx.collection;

import ik.p;
import java.util.Iterator;
import kotlin.collections.k0;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n\u001a0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002\u001a0\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a6\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b\u001a/\u0010\u0013\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aQ\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0015H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\"\u0010 \u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {i1.a.f31577d5, "Landroidx/collection/m;", "", "key", "", "a", "value", "Lkotlin/z1;", xf.j.f55230b, "(Landroidx/collection/m;ILjava/lang/Object;)V", "other", "h", "defaultValue", "c", "(Landroidx/collection/m;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "d", "(Landroidx/collection/m;ILik/a;)Ljava/lang/Object;", "f", "i", "(Landroidx/collection/m;ILjava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/n0;", "name", "action", "b", "Lkotlin/collections/k0;", "g", "", "k", "e", "(Landroidx/collection/m;)I", "size", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class n {

    @d0(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"androidx/collection/n$a", "Lkotlin/collections/k0;", "", "hasNext", "", "b", "a", "I", "d", "()I", "e", "(I)V", "index", "collection-ktx"}, k = 1, mv = {1, 4, 0})
    public static final class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f2878b;

        public a(m<T> mVar) {
            this.f2878b = mVar;
        }

        @Override // kotlin.collections.k0
        public int b() {
            m mVar = this.f2878b;
            int i10 = this.f2877a;
            this.f2877a = i10 + 1;
            return mVar.m(i10);
        }

        public final int d() {
            return this.f2877a;
        }

        public final void e(int i10) {
            this.f2877a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2877a < this.f2878b.x();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d0(bv = {}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0018\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"androidx/collection/n$b", "", "", "hasNext", "kotlin.jvm.PlatformType", "next", "()Ljava/lang/Object;", "", "a", "I", "()I", "b", "(I)V", "index", "collection-ktx"}, k = 1, mv = {1, 4, 0})
    public static final class b<T> implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f2880b;

        public b(m<T> mVar) {
            this.f2880b = mVar;
        }

        public final int a() {
            return this.f2879a;
        }

        public final void b(int i10) {
            this.f2879a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2879a < this.f2880b.x();
        }

        @Override // java.util.Iterator
        public T next() {
            m mVar = this.f2880b;
            int i10 = this.f2879a;
            this.f2879a = i10 + 1;
            return (T) mVar.y(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final <T> boolean a(@yt.k m<T> receiver$0, int i10) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.d(i10);
    }

    public static final <T> void b(@yt.k m<T> receiver$0, @yt.k p<? super Integer, ? super T, z1> action) {
        f0.q(receiver$0, "receiver$0");
        f0.q(action, "action");
        int iX = receiver$0.x();
        for (int i10 = 0; i10 < iX; i10++) {
            action.r0(Integer.valueOf(receiver$0.m(i10)), receiver$0.y(i10));
        }
    }

    public static final <T> T c(@yt.k m<T> receiver$0, int i10, T t10) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.i(i10, t10);
    }

    public static final <T> T d(@yt.k m<T> receiver$0, int i10, @yt.k ik.a<? extends T> defaultValue) {
        f0.q(receiver$0, "receiver$0");
        f0.q(defaultValue, "defaultValue");
        T tH = receiver$0.h(i10);
        return tH != null ? tH : defaultValue.o();
    }

    public static final <T> int e(@yt.k m<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.x();
    }

    public static final <T> boolean f(@yt.k m<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return !receiver$0.l();
    }

    @yt.k
    public static final <T> k0 g(@yt.k m<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return new a(receiver$0);
    }

    @yt.k
    public static final <T> m<T> h(@yt.k m<T> receiver$0, @yt.k m<T> other) {
        f0.q(receiver$0, "receiver$0");
        f0.q(other, "other");
        m<T> mVar = new m<>(receiver$0.x() + other.x());
        mVar.o(receiver$0);
        mVar.o(other);
        return mVar;
    }

    @kotlin.k(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean i(@yt.k m<T> receiver$0, int i10, T t10) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.r(i10, t10);
    }

    public static final <T> void j(@yt.k m<T> receiver$0, int i10, T t10) {
        f0.q(receiver$0, "receiver$0");
        receiver$0.n(i10, t10);
    }

    @yt.k
    public static final <T> Iterator<T> k(@yt.k m<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return new b(receiver$0);
    }
}
