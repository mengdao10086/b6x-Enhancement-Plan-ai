package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.f;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends f<E> {
    public final boolean b(@k E element) {
        f0.p(element, "element");
        return d(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return b((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean d(@k Map.Entry<? extends K, ? extends V> entry);

    public /* bridge */ boolean l(Map.Entry<?, ?> entry) {
        return super.remove(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return l((Map.Entry) obj);
        }
        return false;
    }
}
