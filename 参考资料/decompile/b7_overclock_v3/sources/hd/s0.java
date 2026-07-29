package hd;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31138a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31139b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31140c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31141d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31142e = 3;

    public static int[] a(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i10 = iIndexOf5 + 2;
        if (i10 < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i10) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    public static String b(StringBuilder sb2, int i10, int i11) {
        int i12;
        int iLastIndexOf;
        if (i10 >= i11) {
            return sb2.toString();
        }
        if (sb2.charAt(i10) == '/') {
            i10++;
        }
        int i13 = i10;
        int i14 = i13;
        while (i13 <= i11) {
            if (i13 == i11) {
                i12 = i13;
            } else if (sb2.charAt(i13) == '/') {
                i12 = i13 + 1;
            } else {
                i13++;
            }
            int i15 = i14 + 1;
            if (i13 == i15 && sb2.charAt(i14) == '.') {
                sb2.delete(i14, i12);
                i11 -= i12 - i14;
            } else {
                if (i13 == i14 + 2 && sb2.charAt(i14) == '.' && sb2.charAt(i15) == '.') {
                    iLastIndexOf = sb2.lastIndexOf(fh.a.f28350w, i14 - 2) + 1;
                    int i16 = iLastIndexOf > i10 ? iLastIndexOf : i10;
                    sb2.delete(i16, i12);
                    i11 -= i12 - i16;
                } else {
                    iLastIndexOf = i13 + 1;
                }
                i14 = iLastIndexOf;
            }
            i13 = i14;
        }
        return sb2.toString();
    }

    public static Uri c(Uri uri, String str) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                Iterator<String> it2 = uri.getQueryParameters(str2).iterator();
                while (it2.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str2, it2.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    public static String d(@g.p0 String str, @g.p0 String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb2.append(str2);
            b(sb2, iArrA[1], iArrA[2]);
            return sb2.toString();
        }
        int[] iArrA2 = a(str);
        if (iArrA[3] == 0) {
            sb2.append((CharSequence) str, 0, iArrA2[3]);
            sb2.append(str2);
            return sb2.toString();
        }
        if (iArrA[2] == 0) {
            sb2.append((CharSequence) str, 0, iArrA2[2]);
            sb2.append(str2);
            return sb2.toString();
        }
        if (iArrA[1] != 0) {
            int i10 = iArrA2[0] + 1;
            sb2.append((CharSequence) str, 0, i10);
            sb2.append(str2);
            return b(sb2, iArrA[1] + i10, i10 + iArrA[2]);
        }
        if (str2.charAt(iArrA[1]) == '/') {
            sb2.append((CharSequence) str, 0, iArrA2[1]);
            sb2.append(str2);
            return b(sb2, iArrA2[1], iArrA2[1] + iArrA[2]);
        }
        if (iArrA2[0] + 2 < iArrA2[1] && iArrA2[1] == iArrA2[2]) {
            sb2.append((CharSequence) str, 0, iArrA2[1]);
            sb2.append(zc.f.f58380j);
            sb2.append(str2);
            return b(sb2, iArrA2[1], iArrA2[1] + iArrA[2] + 1);
        }
        int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
        int i11 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
        sb2.append((CharSequence) str, 0, i11);
        sb2.append(str2);
        return b(sb2, iArrA2[1], i11 + iArrA[2]);
    }

    public static Uri e(@g.p0 String str, @g.p0 String str2) {
        return Uri.parse(d(str, str2));
    }
}
