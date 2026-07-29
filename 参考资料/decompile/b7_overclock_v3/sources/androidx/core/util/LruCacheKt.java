package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    @t0({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$4\n*L\n1#1,54:1\n*E\n"})
    public static final class a<K, V> extends LruCache<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.p<K, V, Integer> f4703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<K, V> f4704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ik.r<Boolean, K, V, V, z1> f4705c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(int i10, ik.p<? super K, ? super V, Integer> pVar, ik.l<? super K, ? extends V> lVar, ik.r<? super Boolean, ? super K, ? super V, ? super V, z1> rVar) {
            super(i10);
            this.f4703a = pVar;
            this.f4704b = lVar;
            this.f4705c = rVar;
        }

        @Override // android.util.LruCache
        @yt.l
        public V create(@yt.k K key) {
            kotlin.jvm.internal.f0.p(key, "key");
            return this.f4704b.i(key);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z10, @yt.k K key, @yt.k V oldValue, @yt.l V v10) {
            kotlin.jvm.internal.f0.p(key, "key");
            kotlin.jvm.internal.f0.p(oldValue, "oldValue");
            this.f4705c.N(Boolean.valueOf(z10), key, oldValue, v10);
        }

        @Override // android.util.LruCache
        public int sizeOf(@yt.k K key, @yt.k V value) {
            kotlin.jvm.internal.f0.p(key, "key");
            kotlin.jvm.internal.f0.p(value, "value");
            return this.f4703a.r0(key, value).intValue();
        }
    }

    @yt.k
    public static final <K, V> LruCache<K, V> a(int i10, @yt.k ik.p<? super K, ? super V, Integer> sizeOf, @yt.k ik.l<? super K, ? extends V> create, @yt.k ik.r<? super Boolean, ? super K, ? super V, ? super V, z1> onEntryRemoved) {
        kotlin.jvm.internal.f0.p(sizeOf, "sizeOf");
        kotlin.jvm.internal.f0.p(create, "create");
        kotlin.jvm.internal.f0.p(onEntryRemoved, "onEntryRemoved");
        return new a(i10, sizeOf, create, onEntryRemoved);
    }

    public static /* synthetic */ LruCache b(int i10, ik.p sizeOf, ik.l create, ik.r onEntryRemoved, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            sizeOf = new ik.p<Object, Object, Integer>() { // from class: androidx.core.util.LruCacheKt$lruCache$1
                @Override // ik.p
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Integer r0(@yt.k Object obj2, @yt.k Object obj3) {
                    kotlin.jvm.internal.f0.p(obj2, "<anonymous parameter 0>");
                    kotlin.jvm.internal.f0.p(obj3, "<anonymous parameter 1>");
                    return 1;
                }
            };
        }
        if ((i11 & 4) != 0) {
            create = new ik.l<Object, Object>() { // from class: androidx.core.util.LruCacheKt$lruCache$2
                @Override // ik.l
                @yt.l
                public final Object i(@yt.k Object it2) {
                    kotlin.jvm.internal.f0.p(it2, "it");
                    return null;
                }
            };
        }
        if ((i11 & 8) != 0) {
            onEntryRemoved = new ik.r<Boolean, Object, Object, Object, z1>() { // from class: androidx.core.util.LruCacheKt$lruCache$3
                @Override // ik.r
                public /* bridge */ /* synthetic */ z1 N(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    b(bool.booleanValue(), obj2, obj3, obj4);
                    return z1.f38230a;
                }

                public final void b(boolean z10, @yt.k Object obj2, @yt.k Object obj3, @yt.l Object obj4) {
                    kotlin.jvm.internal.f0.p(obj2, "<anonymous parameter 1>");
                    kotlin.jvm.internal.f0.p(obj3, "<anonymous parameter 2>");
                }
            };
        }
        kotlin.jvm.internal.f0.p(sizeOf, "sizeOf");
        kotlin.jvm.internal.f0.p(create, "create");
        kotlin.jvm.internal.f0.p(onEntryRemoved, "onEntryRemoved");
        return new a(i10, sizeOf, create, onEntryRemoved);
    }
}
