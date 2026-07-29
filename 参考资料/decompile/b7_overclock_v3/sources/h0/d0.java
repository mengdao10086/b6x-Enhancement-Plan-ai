package h0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    @g.p0
    public static String a(@g.p0 String str, @g.n0 String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(fh.a.f28350w);
        for (String str2 : strArr) {
            if (e(strArrSplit, str2.split(fh.a.f28350w))) {
                return str2;
            }
        }
        return null;
    }

    @g.p0
    public static String b(@g.p0 String[] strArr, @g.n0 String str) {
        if (strArr == null) {
            return null;
        }
        String[] strArrSplit = str.split(fh.a.f28350w);
        for (String str2 : strArr) {
            if (e(str2.split(fh.a.f28350w), strArrSplit)) {
                return str2;
            }
        }
        return null;
    }

    public static boolean c(@g.p0 String str, @g.n0 String str2) {
        if (str == null) {
            return false;
        }
        return e(str.split(fh.a.f28350w), str2.split(fh.a.f28350w));
    }

    @g.n0
    public static String[] d(@g.p0 String[] strArr, @g.n0 String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(fh.a.f28350w);
        for (String str2 : strArr) {
            if (e(str2.split(fh.a.f28350w), strArrSplit)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean e(@g.n0 String[] strArr, @g.n0 String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }
}
