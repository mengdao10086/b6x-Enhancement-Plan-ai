package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import jk.g;
import kotlin.collections.k0;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import qk.v;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f37696a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37697b = -1640531527;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f37698c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37699d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37700e = -1;

    @l
    private kotlin.collections.builders.c<K, V> entriesView;

    @k
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @k
    private K[] keysArray;

    @l
    private kotlin.collections.builders.d<K> keysView;
    private int length;
    private int maxProbeDistance;

    @k
    private int[] presenceArray;
    private int size;

    @l
    private V[] valuesArray;

    @l
    private kotlin.collections.builders.e<V> valuesView;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final int c(int i10) {
            return Integer.highestOneBit(v.u(i10, 1) * 3);
        }

        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }
    }

    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, jk.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@k MapBuilder<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        @k
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            if (a() >= ((MapBuilder) d()).length) {
                throw new NoSuchElementException();
            }
            int iA = a();
            g(iA + 1);
            h(iA);
            c<K, V> cVar = new c<>(d(), b());
            e();
            return cVar;
        }

        public final void k(@k StringBuilder sb2) {
            f0.p(sb2, "sb");
            if (a() >= ((MapBuilder) d()).length) {
                throw new NoSuchElementException();
            }
            int iA = a();
            g(iA + 1);
            h(iA);
            Object obj = ((MapBuilder) d()).keysArray[b()];
            if (f0.g(obj, d())) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = ((MapBuilder) d()).valuesArray;
            f0.m(objArr);
            Object obj2 = objArr[b()];
            if (f0.g(obj2, d())) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            e();
        }

        public final int l() {
            if (a() >= ((MapBuilder) d()).length) {
                throw new NoSuchElementException();
            }
            int iA = a();
            g(iA + 1);
            h(iA);
            Object obj = ((MapBuilder) d()).keysArray[b()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) d()).valuesArray;
            f0.m(objArr);
            Object obj2 = objArr[b()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V>, g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final MapBuilder<K, V> f37701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37702b;

        public c(@k MapBuilder<K, V> map, int i10) {
            f0.p(map, "map");
            this.f37701a = map;
            this.f37702b = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@l Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (f0.g(entry.getKey(), getKey()) && f0.g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.f37701a).keysArray[this.f37702b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.f37701a).valuesArray;
            f0.m(objArr);
            return (V) objArr[this.f37702b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            this.f37701a.p();
            Object[] objArrN = this.f37701a.n();
            int i10 = this.f37702b;
            V v11 = (V) objArrN[i10];
            objArrN[i10] = v10;
            return v11;
        }

        @k
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    @t0({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,694:1\n1#2:695\n*E\n"})
    public static class d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final MapBuilder<K, V> f37703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37705c;

        public d(@k MapBuilder<K, V> map) {
            f0.p(map, "map");
            this.f37703a = map;
            this.f37705c = -1;
            e();
        }

        public final int a() {
            return this.f37704b;
        }

        public final int b() {
            return this.f37705c;
        }

        @k
        public final MapBuilder<K, V> d() {
            return this.f37703a;
        }

        public final void e() {
            while (this.f37704b < ((MapBuilder) this.f37703a).length) {
                int[] iArr = ((MapBuilder) this.f37703a).presenceArray;
                int i10 = this.f37704b;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f37704b = i10 + 1;
                }
            }
        }

        public final void g(int i10) {
            this.f37704b = i10;
        }

        public final void h(int i10) {
            this.f37705c = i10;
        }

        public final boolean hasNext() {
            return this.f37704b < ((MapBuilder) this.f37703a).length;
        }

        public final void remove() {
            if (!(this.f37705c != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f37703a.p();
            this.f37703a.R(this.f37705c);
            this.f37705c = -1;
        }
    }

    public static final class e<K, V> extends d<K, V> implements Iterator<K>, jk.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@k MapBuilder<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() >= ((MapBuilder) d()).length) {
                throw new NoSuchElementException();
            }
            int iA = a();
            g(iA + 1);
            h(iA);
            K k10 = (K) ((MapBuilder) d()).keysArray[b()];
            e();
            return k10;
        }
    }

    public static final class f<K, V> extends d<K, V> implements Iterator<V>, jk.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@k MapBuilder<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() >= ((MapBuilder) d()).length) {
                throw new NoSuchElementException();
            }
            int iA = a();
            g(iA + 1);
            h(iA);
            Object[] objArr = ((MapBuilder) d()).valuesArray;
            f0.m(objArr);
            V v10 = (V) objArr[b()];
            e();
            return v10;
        }
    }

    public MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = f37696a.d(C());
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int A() {
        return this.keysArray.length;
    }

    @k
    public Set<Map.Entry<K, V>> B() {
        kotlin.collections.builders.c<K, V> cVar = this.entriesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c<K, V> cVar2 = new kotlin.collections.builders.c<>(this);
        this.entriesView = cVar2;
        return cVar2;
    }

    public final int C() {
        return this.hashArray.length;
    }

    @k
    public Set<K> D() {
        kotlin.collections.builders.d<K> dVar = this.keysView;
        if (dVar != null) {
            return dVar;
        }
        kotlin.collections.builders.d<K> dVar2 = new kotlin.collections.builders.d<>(this);
        this.keysView = dVar2;
        return dVar2;
    }

    public int E() {
        return this.size;
    }

    @k
    public Collection<V> G() {
        kotlin.collections.builders.e<V> eVar = this.valuesView;
        if (eVar != null) {
            return eVar;
        }
        kotlin.collections.builders.e<V> eVar2 = new kotlin.collections.builders.e<>(this);
        this.valuesView = eVar2;
        return eVar2;
    }

    public final int H(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    public final boolean I() {
        return this.isReadOnly;
    }

    @k
    public final e<K, V> J() {
        return new e<>(this);
    }

    public final boolean K(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        w(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (L(it2.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean L(Map.Entry<? extends K, ? extends V> entry) {
        int iM = m(entry.getKey());
        V[] vArrN = n();
        if (iM >= 0) {
            vArrN[iM] = entry.getValue();
            return true;
        }
        int i10 = (-iM) - 1;
        if (f0.g(entry.getValue(), vArrN[i10])) {
            return false;
        }
        vArrN[i10] = entry.getValue();
        return true;
    }

    public final boolean M(int i10) {
        int iH = H(this.keysArray[i10]);
        int i11 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iH] == 0) {
                iArr[iH] = i10 + 1;
                this.presenceArray[i10] = iH;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            iH = iH == 0 ? C() - 1 : iH - 1;
        }
    }

    public final void N(int i10) {
        if (this.length > size()) {
            q();
        }
        int i11 = 0;
        if (i10 != C()) {
            this.hashArray = new int[i10];
            this.hashShift = f37696a.d(i10);
        } else {
            m.l2(this.hashArray, 0, 0, C());
        }
        while (i11 < this.length) {
            int i12 = i11 + 1;
            if (!M(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    public final boolean O(@k Map.Entry<? extends K, ? extends V> entry) {
        f0.p(entry, "entry");
        p();
        int iY = y(entry.getKey());
        if (iY < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        if (!f0.g(vArr[iY], entry.getValue())) {
            return false;
        }
        R(iY);
        return true;
    }

    public final void P(int i10) {
        int iB = v.B(this.maxProbeDistance * 2, C() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            i10 = i10 == 0 ? C() - 1 : i10 - 1;
            i11++;
            if (i11 > this.maxProbeDistance) {
                this.hashArray[i12] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i13 = iArr[i10];
            if (i13 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i13 < 0) {
                iArr[i12] = -1;
            } else {
                int i14 = i13 - 1;
                if (((H(this.keysArray[i14]) - i10) & (C() - 1)) >= i11) {
                    this.hashArray[i12] = i13;
                    this.presenceArray[i14] = i12;
                }
                iB--;
            }
            i12 = i10;
            i11 = 0;
            iB--;
        } while (iB >= 0);
        this.hashArray[i12] = -1;
    }

    public final int Q(K k10) {
        p();
        int iY = y(k10);
        if (iY < 0) {
            return -1;
        }
        R(iY);
        return iY;
    }

    public final void R(int i10) {
        kotlin.collections.builders.b.f(this.keysArray, i10);
        P(this.presenceArray[i10]);
        this.presenceArray[i10] = -1;
        this.size = size() - 1;
    }

    public final boolean T(V v10) {
        p();
        int iZ = z(v10);
        if (iZ < 0) {
            return false;
        }
        R(iZ);
        return true;
    }

    public final boolean U(int i10) {
        int iA = A();
        int i11 = this.length;
        int i12 = iA - i11;
        int size = i11 - size();
        return i12 < i10 && i12 + size >= i10 && size >= A() / 4;
    }

    @k
    public final f<K, V> W() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        p();
        k0 it2 = new qk.m(0, this.length - 1).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            int[] iArr = this.presenceArray;
            int i10 = iArr[iB];
            if (i10 >= 0) {
                this.hashArray[i10] = 0;
                iArr[iB] = -1;
            }
        }
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return y(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return z(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return B();
    }

    @Override // java.util.Map
    public boolean equals(@l Object obj) {
        return obj == this || ((obj instanceof Map) && u((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @l
    public V get(Object obj) {
        int iY = y(obj);
        if (iY < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        return vArr[iY];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarX = x();
        int iL = 0;
        while (bVarX.hasNext()) {
            iL += bVarX.l();
        }
        return iL;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return D();
    }

    public final int m(K k10) {
        p();
        while (true) {
            int iH = H(k10);
            int iB = v.B(this.maxProbeDistance * 2, C() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.hashArray[iH];
                if (i11 <= 0) {
                    if (this.length < A()) {
                        int i12 = this.length;
                        int i13 = i12 + 1;
                        this.length = i13;
                        this.keysArray[i12] = k10;
                        this.presenceArray[i12] = iH;
                        this.hashArray[iH] = i13;
                        this.size = size() + 1;
                        if (i10 > this.maxProbeDistance) {
                            this.maxProbeDistance = i10;
                        }
                        return i12;
                    }
                    w(1);
                } else {
                    if (f0.g(this.keysArray[i11 - 1], k10)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > iB) {
                        N(C() * 2);
                        break;
                    }
                    iH = iH == 0 ? C() - 1 : iH - 1;
                }
            }
        }
    }

    public final V[] n() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.b.d(A());
        this.valuesArray = vArr2;
        return vArr2;
    }

    @k
    public final Map<K, V> o() {
        p();
        this.isReadOnly = true;
        return this;
    }

    public final void p() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    @l
    public V put(K k10, V v10) {
        p();
        int iM = m(k10);
        V[] vArrN = n();
        if (iM >= 0) {
            vArrN[iM] = v10;
            return null;
        }
        int i10 = (-iM) - 1;
        V v11 = vArrN[i10];
        vArrN[i10] = v10;
        return v11;
    }

    @Override // java.util.Map
    public void putAll(@k Map<? extends K, ? extends V> from) {
        f0.p(from, "from");
        p();
        K(from.entrySet());
    }

    public final void q() {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            if (this.presenceArray[i11] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                i12++;
            }
            i11++;
        }
        kotlin.collections.builders.b.g(this.keysArray, i12, i10);
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    public final boolean r(@k Collection<?> m10) {
        f0.p(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!t((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @l
    public V remove(Object obj) {
        int iQ = Q(obj);
        if (iQ < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        V v10 = vArr[iQ];
        kotlin.collections.builders.b.f(vArr, iQ);
        return v10;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return E();
    }

    public final boolean t(@k Map.Entry<? extends K, ? extends V> entry) {
        f0.p(entry, "entry");
        int iY = y(entry.getKey());
        if (iY < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        f0.m(vArr);
        return f0.g(vArr[iY], entry.getValue());
    }

    @k
    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append(zc.a.f58316d);
        b<K, V> bVarX = x();
        int i10 = 0;
        while (bVarX.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarX.k(sb2);
            i10++;
        }
        sb2.append(zc.a.f58317e);
        String string = sb2.toString();
        f0.o(string, "sb.toString()");
        return string;
    }

    public final boolean u(Map<?, ?> map) {
        return size() == map.size() && r(map.entrySet());
    }

    public final void v(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        if (i10 > A()) {
            int iA = (A() * 3) / 2;
            if (i10 <= iA) {
                i10 = iA;
            }
            this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, i10);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) kotlin.collections.builders.b.e(vArr, i10) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, i10);
            f0.o(iArrCopyOf, "copyOf(this, newSize)");
            this.presenceArray = iArrCopyOf;
            int iC = f37696a.c(i10);
            if (iC > C()) {
                N(iC);
            }
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return G();
    }

    public final void w(int i10) {
        if (U(i10)) {
            N(C());
        } else {
            v(this.length + i10);
        }
    }

    @k
    public final b<K, V> x() {
        return new b<>(this);
    }

    public final int y(K k10) {
        int iH = H(k10);
        int i10 = this.maxProbeDistance;
        while (true) {
            int i11 = this.hashArray[iH];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (f0.g(this.keysArray[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iH = iH == 0 ? C() - 1 : iH - 1;
        }
    }

    public final int z(V v10) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                f0.m(vArr);
                if (f0.g(vArr[i10], v10)) {
                    return i10;
                }
            }
        }
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i10) {
        this(kotlin.collections.builders.b.d(i10), null, new int[i10], new int[f37696a.c(i10)], 2, 0);
    }
}
