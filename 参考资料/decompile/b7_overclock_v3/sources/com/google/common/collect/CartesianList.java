package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    private final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    public CartesianList(ImmutableList<List<E>> immutableList) {
        this.axes = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = IntMath.checkedMultiply(iArr[size + 1], immutableList.get(size).size());
            }
            this.axesSizeProduct = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    public static <E> List<List<E>> create(List<? extends List<? extends E>> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        Iterator<? extends List<? extends E>> it2 = list.iterator();
        while (it2.hasNext()) {
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) it2.next());
            if (immutableListCopyOf.isEmpty()) {
                return ImmutableList.of();
            }
            builder.add(immutableListCopyOf);
        }
        return new CartesianList(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAxisIndexForProductIndex(int i10, int i11) {
        return (i10 / this.axesSizeProduct[i11 + 1]) % this.axes.get(i11).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.axes.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i10 = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iIndexOf = this.axes.get(iNextIndex).indexOf(listIterator.next());
            if (iIndexOf == -1) {
                return -1;
            }
            i10 += iIndexOf * this.axesSizeProduct[iNextIndex + 1];
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.axesSizeProduct[0];
    }

    @Override // java.util.AbstractList, java.util.List
    public ImmutableList<E> get(final int i10) {
        Preconditions.checkElementIndex(i10, size());
        return new ImmutableList<E>() { // from class: com.google.common.collect.CartesianList.1
            @Override // java.util.List
            public E get(int i11) {
                Preconditions.checkElementIndex(i11, size());
                return (E) ((List) CartesianList.this.axes.get(i11)).get(CartesianList.this.getAxisIndexForProductIndex(i10, i11));
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return CartesianList.this.axes.size();
            }
        };
    }
}
