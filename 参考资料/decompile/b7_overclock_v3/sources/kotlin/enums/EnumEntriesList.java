package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.b;
import kotlin.jvm.internal.f0;
import kotlin.q;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.8")
@q
final class EnumEntriesList<T extends Enum<T>> extends b<T> implements a<T>, Serializable {

    @l
    private volatile T[] _entries;

    @k
    private final ik.a<T[]> entriesProvider;

    public EnumEntriesList(@k ik.a<T[]> entriesProvider) {
        f0.p(entriesProvider, "entriesProvider");
        this.entriesProvider = entriesProvider;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(l());
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int a() {
        return l().length;
    }

    public boolean b(@k T element) {
        f0.p(element, "element");
        return ((Enum) ArraysKt___ArraysKt.qf(l(), element.ordinal())) == element;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return b((Enum) obj);
        }
        return false;
    }

    @Override // kotlin.collections.b, java.util.List
    @k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public T get(int i10) {
        Enum[] enumArrL = l();
        b.f37685a.b(i10, enumArrL.length);
        return (T) enumArrL[i10];
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return m((Enum) obj);
        }
        return -1;
    }

    public final T[] l() {
        T[] tArr = this._entries;
        if (tArr != null) {
            return tArr;
        }
        T[] tArrO = this.entriesProvider.o();
        this._entries = tArrO;
        return tArrO;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return o((Enum) obj);
        }
        return -1;
    }

    public int m(@k T element) {
        f0.p(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) ArraysKt___ArraysKt.qf(l(), iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int o(@k T element) {
        f0.p(element, "element");
        return indexOf(element);
    }
}
