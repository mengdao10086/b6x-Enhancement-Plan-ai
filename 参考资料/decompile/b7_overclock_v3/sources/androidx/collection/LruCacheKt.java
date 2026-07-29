package androidx.collection;

import ik.p;
import ik.r;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000:\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aø\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000328\b\u0006\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u00052%\b\u0006\u0010\f\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b2d\b\u0006\u0010\u0013\u001a^\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0086\b¨\u0006\u0016"}, d2 = {"", "K", i1.a.X4, "", "maxSize", "Lkotlin/Function2;", "Lkotlin/n0;", "name", "key", "value", "sizeOf", "Lkotlin/Function1;", "create", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "Lkotlin/z1;", "onEntryRemoved", "Landroidx/collection/j;", "a", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    @d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/collection/LruCacheKt$a", "Landroidx/collection/j;", "key", "value", "", "p", "(Ljava/lang/Object;Ljava/lang/Object;)I", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "evicted", "oldValue", "newValue", "Lkotlin/z1;", "c", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "collection-ktx"}, k = 1, mv = {1, 4, 0})
    public static final class a<K, V> extends j<K, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ p f2793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ik.l f2794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ r f2795k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f2796l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p pVar, ik.l lVar, r rVar, int i10, int i11) {
            super(i11);
            this.f2793i = pVar;
            this.f2794j = lVar;
            this.f2795k = rVar;
            this.f2796l = i10;
        }

        @Override // androidx.collection.j
        @yt.l
        public V a(@yt.k K key) {
            f0.q(key, "key");
            return (V) this.f2794j.i(key);
        }

        @Override // androidx.collection.j
        public void c(boolean z10, @yt.k K key, @yt.k V oldValue, @yt.l V v10) {
            f0.q(key, "key");
            f0.q(oldValue, "oldValue");
            this.f2795k.N(Boolean.valueOf(z10), key, oldValue, v10);
        }

        @Override // androidx.collection.j
        public int p(@yt.k K key, @yt.k V value) {
            f0.q(key, "key");
            f0.q(value, "value");
            return ((Number) this.f2793i.r0(key, value)).intValue();
        }
    }

    @yt.k
    public static final <K, V> j<K, V> a(int i10, @yt.k p<? super K, ? super V, Integer> sizeOf, @yt.k ik.l<? super K, ? extends V> create, @yt.k r<? super Boolean, ? super K, ? super V, ? super V, z1> onEntryRemoved) {
        f0.q(sizeOf, "sizeOf");
        f0.q(create, "create");
        f0.q(onEntryRemoved, "onEntryRemoved");
        return new a(sizeOf, create, onEntryRemoved, i10, i10);
    }

    @yt.k
    public static /* synthetic */ j b(int i10, p pVar, ik.l lVar, r rVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = new p<Object, Object, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                public final int b(@yt.k Object obj2, @yt.k Object obj3) {
                    f0.q(obj2, "<anonymous parameter 0>");
                    f0.q(obj3, "<anonymous parameter 1>");
                    return 1;
                }

                @Override // ik.p
                public /* bridge */ /* synthetic */ Integer r0(Object obj2, Object obj3) {
                    return Integer.valueOf(b(obj2, obj3));
                }
            };
        }
        p sizeOf = pVar;
        if ((i11 & 4) != 0) {
            lVar = new ik.l<Object, Object>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // ik.l
                @yt.l
                public final Object i(@yt.k Object it2) {
                    f0.q(it2, "it");
                    return null;
                }
            };
        }
        ik.l create = lVar;
        if ((i11 & 8) != 0) {
            rVar = new r<Boolean, Object, Object, Object, z1>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                @Override // ik.r
                public /* bridge */ /* synthetic */ z1 N(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    b(bool.booleanValue(), obj2, obj3, obj4);
                    return z1.f38230a;
                }

                public final void b(boolean z10, @yt.k Object obj2, @yt.k Object obj3, @yt.l Object obj4) {
                    f0.q(obj2, "<anonymous parameter 1>");
                    f0.q(obj3, "<anonymous parameter 2>");
                }
            };
        }
        r onEntryRemoved = rVar;
        f0.q(sizeOf, "sizeOf");
        f0.q(create, "create");
        f0.q(onEntryRemoved, "onEntryRemoved");
        return new a(sizeOf, create, onEntryRemoved, i10, i10);
    }
}
