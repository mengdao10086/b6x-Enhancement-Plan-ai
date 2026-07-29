package ic;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f32116e = "RepresentationID";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f32117f = "Number";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f32118g = "Bandwidth";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f32119h = "Time";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f32120i = "$$";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f32121j = "%01d";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f32122k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f32123l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f32124m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f32125n = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f32126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f32127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f32128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32129d;

    public m(String[] strArr, int[] iArr, String[] strArr2, int i10) {
        this.f32126a = strArr;
        this.f32127b = iArr;
        this.f32128c = strArr2;
        this.f32129d = i10;
    }

    public static m b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new m(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    public static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String strSubstring;
        strArr[0] = "";
        int length = 0;
        int i10 = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            if (iIndexOf == -1) {
                strArr[i10] = strArr[i10] + str.substring(length);
                length = str.length();
            } else if (iIndexOf != length) {
                strArr[i10] = strArr[i10] + str.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                strArr[i10] = strArr[i10] + "$";
                length += 2;
            } else {
                int i11 = length + 1;
                int iIndexOf2 = str.indexOf("$", i11);
                String strSubstring2 = str.substring(i11, iIndexOf2);
                if (strSubstring2.equals(f32116e)) {
                    iArr[i10] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d") && !strSubstring.endsWith("x")) {
                            strSubstring = strSubstring + "d";
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = f32121j;
                    }
                    strSubstring2.hashCode();
                    switch (strSubstring2) {
                        case "Number":
                            iArr[i10] = 2;
                            break;
                        case "Time":
                            iArr[i10] = 4;
                            break;
                        case "Bandwidth":
                            iArr[i10] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i10] = strSubstring;
                }
                i10++;
                strArr[i10] = "";
                length = iIndexOf2 + 1;
            }
        }
        return i10;
    }

    public String a(String str, long j10, int i10, long j11) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (true) {
            int i12 = this.f32129d;
            if (i11 >= i12) {
                sb2.append(this.f32126a[i12]);
                return sb2.toString();
            }
            sb2.append(this.f32126a[i11]);
            int[] iArr = this.f32127b;
            if (iArr[i11] == 1) {
                sb2.append(str);
            } else if (iArr[i11] == 2) {
                sb2.append(String.format(Locale.US, this.f32128c[i11], Long.valueOf(j10)));
            } else if (iArr[i11] == 3) {
                sb2.append(String.format(Locale.US, this.f32128c[i11], Integer.valueOf(i10)));
            } else if (iArr[i11] == 4) {
                sb2.append(String.format(Locale.US, this.f32128c[i11], Long.valueOf(j11)));
            }
            i11++;
        }
    }
}
