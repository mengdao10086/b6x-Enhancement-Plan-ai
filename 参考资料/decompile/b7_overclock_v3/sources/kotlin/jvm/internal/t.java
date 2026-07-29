package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "CollectionToArray")
@t0({"SMAP\nCollectionToArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,82:1\n57#1,22:83\n57#1,22:105\n26#2:127\n*S KotlinDebug\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n19#1:83,22\n31#1:105,22\n14#1:127\n*E\n"})
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final Object[] f37953a = new Object[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37954b = 2147483645;

    @hk.h(name = "toArray")
    @yt.k
    public static final Object[] a(@yt.k Collection<?> collection) {
        f0.p(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it2 = collection.iterator();
            if (it2.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    objArrCopyOf[i10] = it2.next();
                    if (i11 >= objArrCopyOf.length) {
                        if (!it2.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i12 = ((i11 * 3) + 1) >>> 1;
                        if (i12 <= i11) {
                            if (i11 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i12 = f37954b;
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i12);
                        f0.o(objArrCopyOf, "copyOf(result, newSize)");
                    } else if (!it2.hasNext()) {
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i11);
                        f0.o(objArrCopyOf2, "copyOf(result, size)");
                        return objArrCopyOf2;
                    }
                    i10 = i11;
                }
            }
        }
        return f37953a;
    }

    @hk.h(name = "toArray")
    @yt.k
    public static final Object[] b(@yt.k Collection<?> collection, @yt.l Object[] objArr) {
        Object[] objArrCopyOf;
        f0.p(collection, "collection");
        Objects.requireNonNull(objArr);
        int size = collection.size();
        int i10 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> it2 = collection.iterator();
        if (!it2.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArrCopyOf = objArr;
        } else {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            f0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf = (Object[]) objNewInstance;
        }
        while (true) {
            int i11 = i10 + 1;
            objArrCopyOf[i10] = it2.next();
            if (i11 >= objArrCopyOf.length) {
                if (!it2.hasNext()) {
                    return objArrCopyOf;
                }
                int i12 = ((i11 * 3) + 1) >>> 1;
                if (i12 <= i11) {
                    if (i11 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i12 = f37954b;
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i12);
                f0.o(objArrCopyOf, "copyOf(result, newSize)");
            } else if (!it2.hasNext()) {
                if (objArrCopyOf == objArr) {
                    objArr[i11] = null;
                    return objArr;
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i11);
                f0.o(objArrCopyOf2, "copyOf(result, size)");
                return objArrCopyOf2;
            }
            i10 = i11;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static final Object[] c(Collection<?> collection, ik.a<Object[]> aVar, ik.l<? super Integer, Object[]> lVar, ik.p<? super Object[], ? super Integer, Object[]> pVar) {
        int size = collection.size();
        if (size == 0) {
            return aVar.o();
        }
        Iterator<?> it2 = collection.iterator();
        if (!it2.hasNext()) {
            return aVar.o();
        }
        Object[] objArrI = lVar.i(Integer.valueOf(size));
        int i10 = 0;
        ?? CopyOf = objArrI;
        while (true) {
            int i11 = i10 + 1;
            CopyOf[i10] = it2.next();
            if (i11 >= CopyOf.length) {
                if (!it2.hasNext()) {
                    return CopyOf;
                }
                int i12 = ((i11 * 3) + 1) >>> 1;
                if (i12 <= i11) {
                    if (i11 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i12 = f37954b;
                }
                CopyOf = Arrays.copyOf((Object[]) CopyOf, i12);
                f0.o(CopyOf, "copyOf(result, newSize)");
            } else if (!it2.hasNext()) {
                return pVar.r0(CopyOf, Integer.valueOf(i11));
            }
            i10 = i11;
            CopyOf = CopyOf;
        }
    }
}
