package com.blankj.utilcode.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    public interface a<E> {
        void a(int i10, E e10);
    }

    public interface b<E> {
        boolean a(E e10);
    }

    public interface c<E1, E2> {
        E2 a(E1 e12);
    }

    public s() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @SafeVarargs
    public static <E> LinkedList<E> A(E... eArr) {
        LinkedList<E> linkedList = new LinkedList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                linkedList.add(e10);
            }
        }
        return linkedList;
    }

    @SafeVarargs
    public static <E> LinkedList<E> B(E... eArr) {
        LinkedList<E> linkedList = new LinkedList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                if (e10 != null) {
                    linkedList.add(e10);
                }
            }
        }
        return linkedList;
    }

    public static Collection C(Collection collection) {
        return Collections.synchronizedCollection(collection);
    }

    @SafeVarargs
    public static <E> TreeSet<E> D(Comparator<E> comparator, E... eArr) {
        TreeSet<E> treeSet = new TreeSet<>(comparator);
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                treeSet.add(e10);
            }
        }
        return treeSet;
    }

    @SafeVarargs
    public static <E> TreeSet<E> E(Comparator<E> comparator, E... eArr) {
        TreeSet<E> treeSet = new TreeSet<>(comparator);
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                if (e10 != null) {
                    treeSet.add(e10);
                }
            }
        }
        return treeSet;
    }

    public static Collection F(Collection collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @SafeVarargs
    public static <E> List<E> G(E... eArr) {
        return Collections.unmodifiableList(w(eArr));
    }

    @SafeVarargs
    public static <E> List<E> H(E... eArr) {
        return Collections.unmodifiableList(x(eArr));
    }

    public static <E> Collection<E> I(Collection<E> collection, Collection<E> collection2) {
        if (collection == null) {
            return new ArrayList();
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        for (E e10 : collection) {
            if (!collection2.contains(e10)) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> J(Collection<E> collection, Collection<E> collection2) {
        if (collection == null || collection2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (E e10 : collection) {
            if (collection2.contains(e10)) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> K(Collection<E> collection, b<E> bVar) {
        if (collection == null || bVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (E e10 : collection) {
            if (bVar.a(e10)) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> L(Collection<E> collection, b<E> bVar) {
        if (collection == null || bVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (E e10 : collection) {
            if (!bVar.a(e10)) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    public static <T> void M(List<T> list) {
        Collections.shuffle(list);
    }

    public static int N(Object obj) {
        int i10 = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                i10++;
                it2.next();
            }
        } else {
            if (!(obj instanceof Enumeration)) {
                try {
                    return Array.getLength(obj);
                } catch (IllegalArgumentException unused) {
                    throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
                }
            }
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                i10++;
                enumeration.nextElement();
            }
        }
        return i10;
    }

    public static boolean O(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        if (obj instanceof Iterator) {
            return !((Iterator) obj).hasNext();
        }
        if (obj instanceof Enumeration) {
            return !((Enumeration) obj).hasMoreElements();
        }
        try {
            return Array.getLength(obj) == 0;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
        }
    }

    public static Collection P(Collection collection, Collection collection2) {
        if (collection == null) {
            return new ArrayList();
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList(collection);
        Iterator it2 = collection2.iterator();
        while (it2.hasNext()) {
            arrayList.remove(it2.next());
        }
        return arrayList;
    }

    public static String Q(Collection collection) {
        return collection == null ? i0.f11859x : collection.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E1, E2> void R(Collection<E1> collection, c<E1, E2> cVar) {
        if (collection == null || cVar == 0) {
            return;
        }
        if (collection instanceof List) {
            ListIterator listIterator = ((List) collection).listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(cVar.a(listIterator.next()));
            }
        } else {
            Collection<? extends E1> collectionF = f(collection, cVar);
            collection.clear();
            collection.addAll(collectionF);
        }
    }

    public static Collection S(Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return new ArrayList();
        }
        if (collection == null) {
            return new ArrayList(collection2);
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMax = Math.max(p(obj, mapO), p(obj, mapO2));
            for (int i10 = 0; i10 < iMax; i10++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <E> void a(Collection<E> collection, Enumeration<E> enumeration) {
        if (collection == null || enumeration == null) {
            return;
        }
        while (enumeration.hasMoreElements()) {
            collection.add(enumeration.nextElement());
        }
    }

    public static <E> void b(Collection<E> collection, Iterator<E> it2) {
        if (collection == null || it2 == null) {
            return;
        }
        while (it2.hasNext()) {
            collection.add(it2.next());
        }
    }

    public static <E> void c(Collection<E> collection, E[] eArr) {
        if (collection == null || eArr == null || eArr.length == 0) {
            return;
        }
        collection.addAll(Arrays.asList(eArr));
    }

    public static <E> boolean d(Collection<E> collection, E e10) {
        return (collection == null || e10 == null || !collection.add(e10)) ? false : true;
    }

    public static <E> int e(E e10, Collection<E> collection) {
        int i10 = 0;
        if (collection == null) {
            return 0;
        }
        if (collection instanceof Set) {
            return collection.contains(e10) ? 1 : 0;
        }
        if (e10 == null) {
            Iterator<E> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    i10++;
                }
            }
        } else {
            Iterator<E> it3 = collection.iterator();
            while (it3.hasNext()) {
                if (e10.equals(it3.next())) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public static <E1, E2> Collection<E2> f(Collection<E1> collection, c<E1, E2> cVar) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && cVar != null) {
            Iterator<E1> it2 = collection.iterator();
            while (it2.hasNext()) {
                arrayList.add(cVar.a(it2.next()));
            }
        }
        return arrayList;
    }

    public static boolean g(Collection collection, Collection collection2) {
        if (collection != null && collection2 != null) {
            if (collection.size() < collection2.size()) {
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (collection2.contains(it2.next())) {
                        return true;
                    }
                }
            } else {
                Iterator it3 = collection2.iterator();
                while (it3.hasNext()) {
                    if (collection.contains(it3.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static <E> int h(Collection<E> collection, b<E> bVar) {
        int i10 = 0;
        if (collection != null && bVar != null) {
            Iterator<E> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (bVar.a(it2.next())) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public static Collection i(Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return new ArrayList();
        }
        if (collection == null) {
            return new ArrayList(collection2);
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMax = Math.max(p(obj, mapO), p(obj, mapO2)) - Math.min(p(obj, mapO), p(obj, mapO2));
            for (int i10 = 0; i10 < iMax; i10++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <E> boolean j(Collection<E> collection, b<E> bVar) {
        if (collection != null && bVar != null) {
            Iterator<E> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (bVar.a(it2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <E> void k(Collection<E> collection, b<E> bVar) {
        if (collection == null || bVar == null) {
            return;
        }
        Iterator<E> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!bVar.a(it2.next())) {
                it2.remove();
            }
        }
    }

    public static <E> E l(Collection<E> collection, b<E> bVar) {
        if (collection != null && bVar != null) {
            for (E e10 : collection) {
                if (bVar.a(e10)) {
                    return e10;
                }
            }
        }
        return null;
    }

    public static <E> void m(Collection<E> collection, a<E> aVar) {
        if (collection == null || aVar == null) {
            return;
        }
        int i10 = 0;
        Iterator<E> it2 = collection.iterator();
        while (it2.hasNext()) {
            aVar.a(i10, it2.next());
            i10++;
        }
    }

    public static Object n(Object obj, int i10) {
        if (obj == null) {
            return null;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + i10);
        }
        if (obj instanceof Map) {
            return n(((Map) obj).entrySet().iterator(), i10);
        }
        if (obj instanceof List) {
            return ((List) obj).get(i10);
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj)[i10];
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                i10--;
                if (i10 == -1) {
                    return it2.next();
                }
                it2.next();
            }
            throw new IndexOutOfBoundsException("Entry does not exist: " + i10);
        }
        if (obj instanceof Collection) {
            return n(((Collection) obj).iterator(), i10);
        }
        if (!(obj instanceof Enumeration)) {
            try {
                return Array.get(obj, i10);
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
            }
        }
        Enumeration enumeration = (Enumeration) obj;
        while (enumeration.hasMoreElements()) {
            i10--;
            if (i10 == -1) {
                return enumeration.nextElement();
            }
            enumeration.nextElement();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + i10);
    }

    public static Map<Object, Integer> o(Collection collection) {
        HashMap map = new HashMap();
        if (collection == null) {
            return map;
        }
        for (Object obj : collection) {
            Integer num = (Integer) map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
        return map;
    }

    public static int p(Object obj, Map map) {
        Integer num = (Integer) map.get(obj);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static Collection q(Collection collection, Collection collection2) {
        if (collection == null || collection2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMin = Math.min(p(obj, mapO), p(obj, mapO2));
            for (int i10 = 0; i10 < iMin; i10++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static boolean r(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean s(Collection collection, Collection collection2) {
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        if (mapO.size() != mapO2.size()) {
            return false;
        }
        for (Object obj : mapO.keySet()) {
            if (p(obj, mapO) != p(obj, mapO2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean t(Collection collection) {
        return !r(collection);
    }

    public static boolean u(Collection collection, Collection collection2) {
        return collection != null && collection2 != null && collection.size() < collection2.size() && v(collection, collection2);
    }

    public static boolean v(Collection collection, Collection collection2) {
        if (collection == null || collection2 == null) {
            return false;
        }
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        for (Object obj : collection) {
            if (p(obj, mapO) > p(obj, mapO2)) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <E> ArrayList<E> w(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    @SafeVarargs
    public static <E> ArrayList<E> x(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                if (e10 != null) {
                    arrayList.add(e10);
                }
            }
        }
        return arrayList;
    }

    @SafeVarargs
    public static <E> HashSet<E> y(E... eArr) {
        HashSet<E> hashSet = new HashSet<>();
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                hashSet.add(e10);
            }
        }
        return hashSet;
    }

    @SafeVarargs
    public static <E> HashSet<E> z(E... eArr) {
        HashSet<E> hashSet = new HashSet<>();
        if (eArr != null && eArr.length != 0) {
            for (E e10 : eArr) {
                if (e10 != null) {
                    hashSet.add(e10);
                }
            }
        }
        return hashSet;
    }
}
