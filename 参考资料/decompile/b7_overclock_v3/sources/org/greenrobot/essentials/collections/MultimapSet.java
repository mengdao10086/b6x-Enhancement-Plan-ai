package org.greenrobot.essentials.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes6.dex */
public class MultimapSet<K, V> extends qt.a<K, V, Set<V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SetType f46185b;

    public enum SetType {
        REGULAR,
        THREAD_SAFE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46186a;

        static {
            int[] iArr = new int[SetType.values().length];
            f46186a = iArr;
            try {
                iArr[SetType.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46186a[SetType.THREAD_SAFE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MultimapSet(Map<K, Set<V>> map, SetType setType) {
        super(map);
        this.f46185b = setType;
    }

    public static <K, V> MultimapSet<K, V> o() {
        return p(SetType.REGULAR);
    }

    public static <K, V> MultimapSet<K, V> p(SetType setType) {
        return new MultimapSet<>(new HashMap(), setType);
    }

    @Override // qt.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Set<V> e() {
        int i10 = a.f46186a[this.f46185b.ordinal()];
        if (i10 == 1) {
            return new HashSet();
        }
        if (i10 == 2) {
            return new CopyOnWriteArraySet();
        }
        throw new IllegalStateException("Unknown set type: " + this.f46185b);
    }
}
