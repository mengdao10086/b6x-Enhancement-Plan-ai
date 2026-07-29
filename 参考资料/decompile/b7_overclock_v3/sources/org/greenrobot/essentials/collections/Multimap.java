package org.greenrobot.essentials.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Multimap<K, V> extends qt.a<K, V, List<V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListType f46183b;

    public enum ListType {
        REGULAR,
        THREAD_SAFE,
        LINKED
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46184a;

        static {
            int[] iArr = new int[ListType.values().length];
            f46184a = iArr;
            try {
                iArr[ListType.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46184a[ListType.THREAD_SAFE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46184a[ListType.LINKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Multimap(Map<K, List<V>> map, ListType listType) {
        super(map);
        this.f46183b = listType;
        if (listType == null) {
            throw new IllegalArgumentException("List type may not be null");
        }
    }

    public static <K, V> Multimap<K, V> o() {
        return p(ListType.REGULAR);
    }

    public static <K, V> Multimap<K, V> p(ListType listType) {
        return new Multimap<>(new HashMap(), listType);
    }

    @Override // qt.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public List<V> e() {
        int i10 = a.f46184a[this.f46183b.ordinal()];
        if (i10 == 1) {
            return new ArrayList();
        }
        if (i10 == 2) {
            return new CopyOnWriteArrayList();
        }
        if (i10 == 3) {
            return new LinkedList();
        }
        throw new IllegalStateException("Unknown list type: " + this.f46183b);
    }
}
