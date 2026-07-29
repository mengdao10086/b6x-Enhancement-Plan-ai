package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;
import kotlin.m1;
import kotlin.q1;
import kotlin.w1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public class l extends k {
    /* JADX WARN: Multi-variable type inference failed */
    @hk.h(name = "contentDeepEquals")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    public static final <T> boolean g(@yt.l T[] tArr, @yt.l T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Object[] objArr = tArr[i10];
            Object[] objArr2 = tArr2[i10];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!g(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.i1) && (objArr2 instanceof kotlin.i1)) {
                    if (!UArraysKt___UArraysKt.V0(((kotlin.i1) objArr).y(), ((kotlin.i1) objArr2).y())) {
                        return false;
                    }
                } else if ((objArr instanceof w1) && (objArr2 instanceof w1)) {
                    if (!UArraysKt___UArraysKt.S0(((w1) objArr).y(), ((w1) objArr2).y())) {
                        return false;
                    }
                } else if ((objArr instanceof m1) && (objArr2 instanceof m1)) {
                    if (!UArraysKt___UArraysKt.T0(((m1) objArr).y(), ((m1) objArr2).y())) {
                        return false;
                    }
                } else if ((objArr instanceof q1) && (objArr2 instanceof q1)) {
                    if (!UArraysKt___UArraysKt.X0(((q1) objArr).y(), ((q1) objArr2).y())) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.f0.g(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @hk.h(name = "contentDeepToString")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <T> String h(@yt.l T[] tArr) {
        if (tArr == null) {
            return com.blankj.utilcode.util.i0.f11859x;
        }
        StringBuilder sb2 = new StringBuilder((qk.v.B(tArr.length, 429496729) * 5) + 2);
        i(tArr, sb2, new ArrayList());
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void i(T[] tArr, StringBuilder sb2, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb2.append("[...]");
            return;
        }
        list.add(tArr);
        sb2.append('[');
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(", ");
            }
            Object[] objArr = tArr[i10];
            if (objArr == 0) {
                sb2.append(com.blankj.utilcode.util.i0.f11859x);
            } else if (objArr instanceof Object[]) {
                i(objArr, sb2, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                kotlin.jvm.internal.f0.o(string, "toString(this)");
                sb2.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                kotlin.jvm.internal.f0.o(string2, "toString(this)");
                sb2.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                kotlin.jvm.internal.f0.o(string3, "toString(this)");
                sb2.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                kotlin.jvm.internal.f0.o(string4, "toString(this)");
                sb2.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                kotlin.jvm.internal.f0.o(string5, "toString(this)");
                sb2.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                kotlin.jvm.internal.f0.o(string6, "toString(this)");
                sb2.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                kotlin.jvm.internal.f0.o(string7, "toString(this)");
                sb2.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                kotlin.jvm.internal.f0.o(string8, "toString(this)");
                sb2.append(string8);
            } else if (objArr instanceof kotlin.i1) {
                sb2.append(UArraysKt___UArraysKt.j1(((kotlin.i1) objArr).y()));
            } else if (objArr instanceof w1) {
                sb2.append(UArraysKt___UArraysKt.n1(((w1) objArr).y()));
            } else if (objArr instanceof m1) {
                sb2.append(UArraysKt___UArraysKt.m1(((m1) objArr).y()));
            } else if (objArr instanceof q1) {
                sb2.append(UArraysKt___UArraysKt.p1(((q1) objArr).y()));
            } else {
                sb2.append(objArr.toString());
            }
        }
        sb2.append(']');
        list.remove(CollectionsKt__CollectionsKt.G(list));
    }

    @yt.k
    public static final <T> List<T> j(@yt.k T[][] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(length);
        for (T[] tArr3 : tArr) {
            x.p0(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lik/a<+TR;>;)TR; */
    @bk.f
    @kotlin.v0(version = "1.3")
    public static final Object k(Object[] objArr, ik.a defaultValue) {
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.o() : objArr;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final boolean l(Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <T, R> Pair<List<T>, List<R>> m(@yt.k Pair<? extends T, ? extends R>[] pairArr) {
        kotlin.jvm.internal.f0.p(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.f());
            arrayList2.add(pair.h());
        }
        return kotlin.d1.a(arrayList, arrayList2);
    }
}
