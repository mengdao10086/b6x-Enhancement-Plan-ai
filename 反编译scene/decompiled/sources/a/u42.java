package a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class u42 extends s42 {
    public static final Integer A(int[] iArr) {
        f92.d(iArr, "$this$minOrNull");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        int iP = p(iArr);
        if (1 <= iP) {
            while (true) {
                int i3 = iArr[i];
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i == iP) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    public static final char B(char[] cArr) {
        f92.d(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T C(T[] tArr) {
        f92.d(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] D(T[] tArr, ea2 ea2Var) {
        f92.d(tArr, "$this$sliceArray");
        f92.d(ea2Var, "indices");
        return ea2Var.isEmpty() ? (T[]) s42.f(tArr, 0, 0) : (T[]) s42.f(tArr, ea2Var.g().intValue(), ea2Var.f().intValue() + 1);
    }

    public static final <T> T[] E(T[] tArr, Comparator<? super T> comparator) {
        f92.d(tArr, "$this$sortedArrayWith");
        f92.d(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        f92.c(tArr2, "java.util.Arrays.copyOf(this, size)");
        s42.g(tArr2, comparator);
        return tArr2;
    }

    public static final <T> List<T> F(T[] tArr, Comparator<? super T> comparator) {
        f92.d(tArr, "$this$sortedWith");
        f92.d(comparator, "comparator");
        return s42.b(E(tArr, comparator));
    }

    public static final int G(int[] iArr) {
        f92.d(iArr, "$this$sum");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final <T, C extends Collection<? super T>> C H(T[] tArr, C c) {
        f92.d(tArr, "$this$toCollection");
        f92.d(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final <T> List<T> I(T[] tArr) {
        f92.d(tArr, "$this$toList");
        int length = tArr.length;
        return length != 0 ? length != 1 ? K(tArr) : x42.b(tArr[0]) : y42.e();
    }

    public static final List<Boolean> J(boolean[] zArr) {
        f92.d(zArr, "$this$toList");
        int length = zArr.length;
        return length != 0 ? length != 1 ? L(zArr) : x42.b(Boolean.valueOf(zArr[0])) : y42.e();
    }

    public static final <T> List<T> K(T[] tArr) {
        f92.d(tArr, "$this$toMutableList");
        return new ArrayList(y42.d(tArr));
    }

    public static final List<Boolean> L(boolean[] zArr) {
        f92.d(zArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final <T> Set<T> M(T[] tArr) {
        f92.d(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return v52.b();
        }
        if (length == 1) {
            return u52.a(tArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(s52.a(tArr.length));
        H(tArr, linkedHashSet);
        return linkedHashSet;
    }

    public static final Iterable<n52<Boolean>> N(boolean[] zArr) {
        f92.d(zArr, "$this$withIndex");
        return new o52(new t42(zArr));
    }

    public static final boolean j(int[] iArr, int i) {
        f92.d(iArr, "$this$contains");
        return s(iArr, i) >= 0;
    }

    public static final <T> boolean k(T[] tArr, T t) {
        f92.d(tArr, "$this$contains");
        return t(tArr, t) >= 0;
    }

    public static final <T> List<T> l(T[] tArr) {
        f92.d(tArr, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        m(tArr, arrayList);
        return arrayList;
    }

    public static final <C extends Collection<? super T>, T> C m(T[] tArr, C c) {
        f92.d(tArr, "$this$filterNotNullTo");
        f92.d(c, "destination");
        for (T t : tArr) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    public static final <T> T n(T[] tArr) {
        f92.d(tArr, "$this$first");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static final ea2 o(boolean[] zArr) {
        f92.d(zArr, "$this$indices");
        return new ea2(0, r(zArr));
    }

    public static final int p(int[] iArr) {
        f92.d(iArr, "$this$lastIndex");
        return iArr.length - 1;
    }

    public static final <T> int q(T[] tArr) {
        f92.d(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    public static final int r(boolean[] zArr) {
        f92.d(zArr, "$this$lastIndex");
        return zArr.length - 1;
    }

    public static final int s(int[] iArr, int i) {
        f92.d(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final <T> int t(T[] tArr, T t) {
        f92.d(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (f92.a(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final int u(boolean[] zArr, boolean z) {
        f92.d(zArr, "$this$indexOf");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final <T, A extends Appendable> A v(T[] tArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82<? super T, ? extends CharSequence> g82Var) throws IOException {
        f92.d(tArr, "$this$joinTo");
        f92.d(a2, "buffer");
        f92.d(charSequence, "separator");
        f92.d(charSequence2, "prefix");
        f92.d(charSequence3, "postfix");
        f92.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
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

    public static final <T> String w(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82<? super T, ? extends CharSequence> g82Var) throws IOException {
        f92.d(tArr, "$this$joinToString");
        f92.d(charSequence, "separator");
        f92.d(charSequence2, "prefix");
        f92.d(charSequence3, "postfix");
        f92.d(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        v(tArr, sb, charSequence, charSequence2, charSequence3, i, charSequence4, g82Var);
        String string = sb.toString();
        f92.c(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String x(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, g82 g82Var, int i2, Object obj) {
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
        return w(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, g82Var);
    }

    public static final int y(int[] iArr) {
        f92.d(iArr, "$this$last");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[p(iArr)];
    }

    public static final <T> T z(T[] tArr) {
        f92.d(tArr, "$this$last");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[q(tArr)];
    }
}
