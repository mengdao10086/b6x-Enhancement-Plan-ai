package a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class i52 extends f52 {
    public static final <T> T A(List<? extends T> list) {
        f92.d(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> T B(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$firstOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T> T C(List<? extends T> list) {
        f92.d(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int D(Iterable<? extends T> iterable, T t) {
        f92.d(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                y42.l();
                throw null;
            }
            if (f92.a(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A E(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82<? super T, ? extends CharSequence> g82Var) throws IOException {
        f92.d(iterable, "$this$joinTo");
        f92.d(a2, "buffer");
        f92.d(charSequence, "separator");
        f92.d(charSequence2, "prefix");
        f92.d(charSequence3, "postfix");
        f92.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            rb2.a(a2, t, g82Var);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ Appendable F(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82 g82Var, int i2, Object obj) throws IOException {
        E(iterable, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) == 0 ? charSequence3 : "", (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : g82Var);
        return appendable;
    }

    public static final <T> String G(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82<? super T, ? extends CharSequence> g82Var) throws IOException {
        f92.d(iterable, "$this$joinToString");
        f92.d(charSequence, "separator");
        f92.d(charSequence2, "prefix");
        f92.d(charSequence3, "postfix");
        f92.d(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        E(iterable, sb, charSequence, charSequence2, charSequence3, i, charSequence4, g82Var);
        String string = sb.toString();
        f92.c(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String H(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82 g82Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            g82Var = null;
        }
        return G(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, g82Var);
    }

    public static final <T> T I(Iterable<? extends T> iterable) {
        T next;
        f92.d(iterable, "$this$last");
        if (iterable instanceof List) {
            return (T) J((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static final <T> T J(List<? extends T> list) {
        f92.d(list, "$this$last");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(y42.g(list));
    }

    public static final <T> T K(List<? extends T> list) {
        f92.d(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T extends Comparable<? super T>> T L(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$maxOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final Double M(Iterable<Double> iterable) {
        f92.d(iterable, "$this$maxOrNull");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Float N(Iterable<Float> iterable) {
        f92.d(iterable, "$this$maxOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <T extends Comparable<? super T>> T O(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$minOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final Float P(Iterable<Float> iterable) {
        f92.d(iterable, "$this$minOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <T> T Q(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) R((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T R(List<? extends T> list) {
        f92.d(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> S(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        f92.d(iterable, "$this$sortedWith");
        f92.d(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listZ = Z(iterable);
            c52.n(listZ, comparator);
            return listZ;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return Y(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        s42.g(array, comparator);
        return s42.b(array);
    }

    public static final int T(Iterable<Integer> iterable) {
        f92.d(iterable, "$this$sum");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static final long U(Iterable<Long> iterable) {
        f92.d(iterable, "$this$sum");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public static final <T> List<T> V(Iterable<? extends T> iterable, int i) {
        f92.d(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return y42.e();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return Y(iterable);
            }
            if (i == 1) {
                return x42.b(z(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return y42.j(arrayList);
    }

    public static final boolean[] W(Collection<Boolean> collection) {
        f92.d(collection, "$this$toBooleanArray");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = it.next().booleanValue();
            i++;
        }
        return zArr;
    }

    public static final <T, C extends Collection<? super T>> C X(Iterable<? extends T> iterable, C c) {
        f92.d(iterable, "$this$toCollection");
        f92.d(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> List<T> Y(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return y42.j(Z(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return y42.e();
        }
        if (size != 1) {
            return a0(collection);
        }
        return x42.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> Z(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return a0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        X(iterable, arrayList);
        return arrayList;
    }

    public static final <T> List<T> a0(Collection<? extends T> collection) {
        f92.d(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T> Set<T> b0(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$toSet");
        if (!(iterable instanceof Collection)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            X(iterable, linkedHashSet);
            return v52.c(linkedHashSet);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return v52.b();
        }
        if (size == 1) {
            return u52.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(s52.a(collection.size()));
        X(iterable, linkedHashSet2);
        return linkedHashSet2;
    }

    public static final <T> Iterable<n52<T>> c0(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$withIndex");
        return new o52(new h52(iterable));
    }

    public static final <T> pa2<T> r(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$asSequence");
        return new g52(iterable);
    }

    public static final double s(Iterable<Double> iterable) {
        f92.d(iterable, "$this$average");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i++;
            if (i < 0) {
                y42.k();
                throw null;
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i);
    }

    public static final double t(Iterable<Float> iterable) {
        f92.d(iterable, "$this$average");
        Iterator<Float> it = iterable.iterator();
        double dFloatValue = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i++;
            if (i < 0) {
                y42.k();
                throw null;
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i);
    }

    public static final double u(Iterable<Integer> iterable) {
        f92.d(iterable, "$this$average");
        Iterator<Integer> it = iterable.iterator();
        double dIntValue = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i++;
            if (i < 0) {
                y42.k();
                throw null;
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i);
    }

    public static final <T> boolean v(Iterable<? extends T> iterable, T t) {
        f92.d(iterable, "$this$contains");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t) : D(iterable, t) >= 0;
    }

    public static final <T> List<T> w(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        f92.d(iterable, "$this$drop");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return Y(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i;
            if (size <= 0) {
                return y42.e();
            }
            if (size == 1) {
                return x42.b(I(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i < size2) {
                        arrayList.add(((List) iterable).get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t : iterable) {
            if (i2 >= i) {
                arrayList.add(t);
            } else {
                i2++;
            }
        }
        return y42.j(arrayList);
    }

    public static final <T> List<T> x(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        y(iterable, arrayList);
        return arrayList;
    }

    public static final <C extends Collection<? super T>, T> C y(Iterable<? extends T> iterable, C c) {
        f92.d(iterable, "$this$filterNotNullTo");
        f92.d(c, "destination");
        for (T t : iterable) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    public static final <T> T z(Iterable<? extends T> iterable) {
        f92.d(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) A((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }
}
