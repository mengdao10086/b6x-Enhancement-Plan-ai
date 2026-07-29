package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.c2;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,583:1\n467#1,51:586\n467#1,51:637\n37#2,2:584\n26#3:688\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n462#1:586,51\n464#1:637,51\n47#1:584,2\n562#1:688\n*E\n"})
@kotlin.v0(version = "1.4")
@c2(markerClass = {kotlin.q.class})
public final class i<E> extends d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f37718d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final Object[] f37719e = new Object[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37720f = 2147483639;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f37721g = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public Object[] f37723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f37724c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final int a(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            return i12 - 2147483639 > 0 ? i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i12;
        }
    }

    public i(int i10) {
        Object[] objArr;
        if (i10 == 0) {
            objArr = f37719e;
        } else {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i10);
            }
            objArr = new Object[i10];
        }
        this.f37723b = objArr;
    }

    @yt.l
    public final E A() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @yt.k
    public final Object[] B() {
        return toArray();
    }

    @yt.k
    public final <T> T[] C(@yt.k T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) toArray(array);
    }

    @Override // kotlin.collections.d
    public int a() {
        return this.f37724c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@yt.k Collection<? extends E> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        o(size() + elements.size());
        d(y(this.f37722a + size()), elements);
        return true;
    }

    public final void addFirst(E e10) {
        o(size() + 1);
        int iM = m(this.f37722a);
        this.f37722a = iM;
        this.f37723b[iM] = e10;
        this.f37724c = size() + 1;
    }

    public final void addLast(E e10) {
        o(size() + 1);
        this.f37723b[y(this.f37722a + size())] = e10;
        this.f37724c = size() + 1;
    }

    @Override // kotlin.collections.d
    public E b(int i10) {
        b.f37685a.b(i10, size());
        if (i10 == CollectionsKt__CollectionsKt.G(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int iY = y(this.f37722a + i10);
        E e10 = (E) this.f37723b[iY];
        if (i10 < (size() >> 1)) {
            int i11 = this.f37722a;
            if (iY >= i11) {
                Object[] objArr = this.f37723b;
                m.c1(objArr, objArr, i11 + 1, i11, iY);
            } else {
                Object[] objArr2 = this.f37723b;
                m.c1(objArr2, objArr2, 1, 0, iY);
                Object[] objArr3 = this.f37723b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f37722a;
                m.c1(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f37723b;
            int i13 = this.f37722a;
            objArr4[i13] = null;
            this.f37722a = r(i13);
        } else {
            int iY2 = y(this.f37722a + CollectionsKt__CollectionsKt.G(this));
            if (iY <= iY2) {
                Object[] objArr5 = this.f37723b;
                m.c1(objArr5, objArr5, iY, iY + 1, iY2 + 1);
            } else {
                Object[] objArr6 = this.f37723b;
                m.c1(objArr6, objArr6, iY, iY + 1, objArr6.length);
                Object[] objArr7 = this.f37723b;
                objArr7[objArr7.length - 1] = objArr7[0];
                m.c1(objArr7, objArr7, 0, 1, iY2 + 1);
            }
            this.f37723b[iY2] = null;
        }
        this.f37724c = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iY = y(this.f37722a + size());
        int i10 = this.f37722a;
        if (i10 < iY) {
            m.n2(this.f37723b, null, i10, iY);
        } else if (!isEmpty()) {
            Object[] objArr = this.f37723b;
            m.n2(objArr, null, this.f37722a, objArr.length);
            m.n2(this.f37723b, null, 0, iY);
        }
        this.f37722a = 0;
        this.f37724c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it2 = collection.iterator();
        int length = this.f37723b.length;
        while (i10 < length && it2.hasNext()) {
            this.f37723b[i10] = it2.next();
            i10++;
        }
        int i11 = this.f37722a;
        for (int i12 = 0; i12 < i11 && it2.hasNext(); i12++) {
            this.f37723b[i12] = it2.next();
        }
        this.f37724c = size() + collection.size();
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f37723b[this.f37722a];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        b.f37685a.b(i10, size());
        return (E) this.f37723b[y(this.f37722a + i10)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int iY = y(this.f37722a + size());
        int length = this.f37722a;
        if (length < iY) {
            while (length < iY) {
                if (kotlin.jvm.internal.f0.g(obj, this.f37723b[length])) {
                    i10 = this.f37722a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iY) {
            return -1;
        }
        int length2 = this.f37723b.length;
        while (true) {
            if (length >= length2) {
                for (int i11 = 0; i11 < iY; i11++) {
                    if (kotlin.jvm.internal.f0.g(obj, this.f37723b[i11])) {
                        length = i11 + this.f37723b.length;
                        i10 = this.f37722a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.f0.g(obj, this.f37723b[length])) {
                i10 = this.f37722a;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void l(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f37723b;
        m.c1(objArr2, objArr, 0, this.f37722a, objArr2.length);
        Object[] objArr3 = this.f37723b;
        int length = objArr3.length;
        int i11 = this.f37722a;
        m.c1(objArr3, objArr, length - i11, 0, i11);
        this.f37722a = 0;
        this.f37723b = objArr;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f37723b[y(this.f37722a + CollectionsKt__CollectionsKt.G(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iXe;
        int i10;
        int iY = y(this.f37722a + size());
        int i11 = this.f37722a;
        if (i11 < iY) {
            iXe = iY - 1;
            if (i11 <= iXe) {
                while (!kotlin.jvm.internal.f0.g(obj, this.f37723b[iXe])) {
                    if (iXe != i11) {
                        iXe--;
                    }
                }
                i10 = this.f37722a;
                return iXe - i10;
            }
            return -1;
        }
        if (i11 > iY) {
            int i12 = iY - 1;
            while (true) {
                if (-1 >= i12) {
                    iXe = ArraysKt___ArraysKt.Xe(this.f37723b);
                    int i13 = this.f37722a;
                    if (i13 <= iXe) {
                        while (!kotlin.jvm.internal.f0.g(obj, this.f37723b[iXe])) {
                            if (iXe != i13) {
                                iXe--;
                            }
                        }
                        i10 = this.f37722a;
                    }
                } else {
                    if (kotlin.jvm.internal.f0.g(obj, this.f37723b[i12])) {
                        iXe = i12 + this.f37723b.length;
                        i10 = this.f37722a;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    public final int m(int i10) {
        return i10 == 0 ? ArraysKt___ArraysKt.Xe(this.f37723b) : i10 - 1;
    }

    public final void o(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f37723b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f37719e) {
            this.f37723b = new Object[qk.v.u(i10, 10)];
        } else {
            l(f37718d.a(objArr.length, i10));
        }
    }

    public final boolean p(ik.l<? super E, Boolean> lVar) {
        int iY;
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f37723b.length == 0)) {
                int iY2 = y(this.f37722a + size());
                int i10 = this.f37722a;
                if (i10 < iY2) {
                    iY = i10;
                    while (i10 < iY2) {
                        Object obj = this.f37723b[i10];
                        if (lVar.i(obj).booleanValue()) {
                            this.f37723b[iY] = obj;
                            iY++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    m.n2(this.f37723b, null, iY, iY2);
                } else {
                    int length = this.f37723b.length;
                    int i11 = i10;
                    boolean z11 = false;
                    while (i10 < length) {
                        Object[] objArr = this.f37723b;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (lVar.i(obj2).booleanValue()) {
                            this.f37723b[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iY = y(i11);
                    for (int i12 = 0; i12 < iY2; i12++) {
                        Object[] objArr2 = this.f37723b;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (lVar.i(obj3).booleanValue()) {
                            this.f37723b[iY] = obj3;
                            iY = r(iY);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f37724c = x(iY - this.f37722a);
                }
            }
        }
        return z10;
    }

    @yt.l
    public final E q() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f37723b[this.f37722a];
    }

    public final int r(int i10) {
        if (i10 == ArraysKt___ArraysKt.Xe(this.f37723b)) {
            return 0;
        }
        return i10 + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@yt.k Collection<? extends Object> elements) {
        int iY;
        kotlin.jvm.internal.f0.p(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f37723b.length == 0)) {
                int iY2 = y(this.f37722a + size());
                int i10 = this.f37722a;
                if (i10 < iY2) {
                    iY = i10;
                    while (i10 < iY2) {
                        Object obj = this.f37723b[i10];
                        if (!elements.contains(obj)) {
                            this.f37723b[iY] = obj;
                            iY++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    m.n2(this.f37723b, null, iY, iY2);
                } else {
                    int length = this.f37723b.length;
                    int i11 = i10;
                    boolean z11 = false;
                    while (i10 < length) {
                        Object[] objArr = this.f37723b;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (!elements.contains(obj2)) {
                            this.f37723b[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iY = y(i11);
                    for (int i12 = 0; i12 < iY2; i12++) {
                        Object[] objArr2 = this.f37723b;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (!elements.contains(obj3)) {
                            this.f37723b[iY] = obj3;
                            iY = r(iY);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f37724c = x(iY - this.f37722a);
                }
            }
        }
        return z10;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f37723b;
        int i10 = this.f37722a;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f37722a = r(i10);
        this.f37724c = size() - 1;
        return e10;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iY = y(this.f37722a + CollectionsKt__CollectionsKt.G(this));
        Object[] objArr = this.f37723b;
        E e10 = (E) objArr[iY];
        objArr[iY] = null;
        this.f37724c = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@yt.k Collection<? extends Object> elements) {
        int iY;
        kotlin.jvm.internal.f0.p(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f37723b.length == 0)) {
                int iY2 = y(this.f37722a + size());
                int i10 = this.f37722a;
                if (i10 < iY2) {
                    iY = i10;
                    while (i10 < iY2) {
                        Object obj = this.f37723b[i10];
                        if (elements.contains(obj)) {
                            this.f37723b[iY] = obj;
                            iY++;
                        } else {
                            z10 = true;
                        }
                        i10++;
                    }
                    m.n2(this.f37723b, null, iY, iY2);
                } else {
                    int length = this.f37723b.length;
                    int i11 = i10;
                    boolean z11 = false;
                    while (i10 < length) {
                        Object[] objArr = this.f37723b;
                        Object obj2 = objArr[i10];
                        objArr[i10] = null;
                        if (elements.contains(obj2)) {
                            this.f37723b[i11] = obj2;
                            i11++;
                        } else {
                            z11 = true;
                        }
                        i10++;
                    }
                    iY = y(i11);
                    for (int i12 = 0; i12 < iY2; i12++) {
                        Object[] objArr2 = this.f37723b;
                        Object obj3 = objArr2[i12];
                        objArr2[i12] = null;
                        if (elements.contains(obj3)) {
                            this.f37723b[iY] = obj3;
                            iY = r(iY);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f37724c = x(iY - this.f37722a);
                }
            }
        }
        return z10;
    }

    @Override // kotlin.collections.d, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        b.f37685a.b(i10, size());
        int iY = y(this.f37722a + i10);
        Object[] objArr = this.f37723b;
        E e11 = (E) objArr[iY];
        objArr[iY] = e10;
        return e11;
    }

    @bk.f
    public final E t(int i10) {
        return (E) this.f37723b[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @yt.k
    public <T> T[] toArray(@yt.k T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) k.a(array, size());
        }
        int iY = y(this.f37722a + size());
        int i10 = this.f37722a;
        if (i10 < iY) {
            m.l1(this.f37723b, array, 0, i10, iY, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f37723b;
            m.c1(objArr, array, 0, this.f37722a, objArr.length);
            Object[] objArr2 = this.f37723b;
            m.c1(objArr2, array, objArr2.length - this.f37722a, 0, iY);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @bk.f
    public final int u(int i10) {
        return y(this.f37722a + i10);
    }

    public final void v(@yt.k ik.p<? super Integer, ? super Object[], z1> structure) {
        int i10;
        kotlin.jvm.internal.f0.p(structure, "structure");
        structure.r0(Integer.valueOf((isEmpty() || (i10 = this.f37722a) < y(this.f37722a + size())) ? this.f37722a : i10 - this.f37723b.length), toArray());
    }

    @yt.l
    public final E w() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f37723b[y(this.f37722a + CollectionsKt__CollectionsKt.G(this))];
    }

    public final int x(int i10) {
        return i10 < 0 ? i10 + this.f37723b.length : i10;
    }

    public final int y(int i10) {
        Object[] objArr = this.f37723b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @yt.l
    public final E z() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // kotlin.collections.d, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        b.f37685a.c(i10, size());
        if (i10 == size()) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        o(size() + 1);
        int iY = y(this.f37722a + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int iM = m(iY);
            int iM2 = m(this.f37722a);
            int i11 = this.f37722a;
            if (iM >= i11) {
                Object[] objArr = this.f37723b;
                objArr[iM2] = objArr[i11];
                m.c1(objArr, objArr, i11, i11 + 1, iM + 1);
            } else {
                Object[] objArr2 = this.f37723b;
                m.c1(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                Object[] objArr3 = this.f37723b;
                objArr3[objArr3.length - 1] = objArr3[0];
                m.c1(objArr3, objArr3, 0, 1, iM + 1);
            }
            this.f37723b[iM] = e10;
            this.f37722a = iM2;
        } else {
            int iY2 = y(this.f37722a + size());
            if (iY < iY2) {
                Object[] objArr4 = this.f37723b;
                m.c1(objArr4, objArr4, iY + 1, iY, iY2);
            } else {
                Object[] objArr5 = this.f37723b;
                m.c1(objArr5, objArr5, 1, 0, iY2);
                Object[] objArr6 = this.f37723b;
                objArr6[0] = objArr6[objArr6.length - 1];
                m.c1(objArr6, objArr6, iY + 1, iY, objArr6.length - 1);
            }
            this.f37723b[iY] = e10;
        }
        this.f37724c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @yt.k Collection<? extends E> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        b.f37685a.c(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        o(size() + elements.size());
        int iY = y(this.f37722a + size());
        int iY2 = y(this.f37722a + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f37722a;
            int length = i11 - size;
            if (iY2 < i11) {
                Object[] objArr = this.f37723b;
                m.c1(objArr, objArr, length, i11, objArr.length);
                if (size >= iY2) {
                    Object[] objArr2 = this.f37723b;
                    m.c1(objArr2, objArr2, objArr2.length - size, 0, iY2);
                } else {
                    Object[] objArr3 = this.f37723b;
                    m.c1(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f37723b;
                    m.c1(objArr4, objArr4, 0, size, iY2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f37723b;
                m.c1(objArr5, objArr5, length, i11, iY2);
            } else {
                Object[] objArr6 = this.f37723b;
                length += objArr6.length;
                int i12 = iY2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    m.c1(objArr6, objArr6, length, i11, iY2);
                } else {
                    m.c1(objArr6, objArr6, length, i11, i11 + length2);
                    Object[] objArr7 = this.f37723b;
                    m.c1(objArr7, objArr7, 0, this.f37722a + length2, iY2);
                }
            }
            this.f37722a = length;
            d(x(iY2 - size), elements);
        } else {
            int i13 = iY2 + size;
            if (iY2 < iY) {
                int i14 = size + iY;
                Object[] objArr8 = this.f37723b;
                if (i14 <= objArr8.length) {
                    m.c1(objArr8, objArr8, i13, iY2, iY);
                } else if (i13 >= objArr8.length) {
                    m.c1(objArr8, objArr8, i13 - objArr8.length, iY2, iY);
                } else {
                    int length3 = iY - (i14 - objArr8.length);
                    m.c1(objArr8, objArr8, 0, length3, iY);
                    Object[] objArr9 = this.f37723b;
                    m.c1(objArr9, objArr9, i13, iY2, length3);
                }
            } else {
                Object[] objArr10 = this.f37723b;
                m.c1(objArr10, objArr10, size, 0, iY);
                Object[] objArr11 = this.f37723b;
                if (i13 >= objArr11.length) {
                    m.c1(objArr11, objArr11, i13 - objArr11.length, iY2, objArr11.length);
                } else {
                    m.c1(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f37723b;
                    m.c1(objArr12, objArr12, i13, iY2, objArr12.length - size);
                }
            }
            d(iY2, elements);
        }
        return true;
    }

    public i() {
        this.f37723b = f37719e;
    }

    public i(@yt.k Collection<? extends E> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.f37723b = array;
        this.f37724c = array.length;
        if (array.length == 0) {
            this.f37723b = f37719e;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @yt.k
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
