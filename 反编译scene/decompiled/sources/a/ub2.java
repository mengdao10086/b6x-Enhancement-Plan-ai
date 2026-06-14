package a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ub2 extends rb2 {
    public static final g82<String, String> b(String str) {
        return str.length() == 0 ? sb2.f7382a : new tb2(str);
    }

    public static final String c(String str, String str2, String str3) throws IOException {
        int i;
        String strF;
        f92.d(str, "$this$replaceIndentByMargin");
        f92.d(str2, "newIndent");
        f92.d(str3, "marginPrefix");
        if (!(!bc2.p(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listV = ec2.V(str);
        int length = str.length() + (str2.length() * listV.size());
        g82<String, String> g82VarB = b(str2);
        int iG = y42.g(listV);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listV) {
            int i3 = i2 + 1;
            String strSubstring = null;
            if (i2 < 0) {
                y42.l();
                throw null;
            }
            String str4 = (String) obj;
            if ((i2 != 0 && i2 != iG) || !bc2.p(str4)) {
                int length2 = str4.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!za2.c(str4.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (bc2.w(str4, str3, i, false, 4, null)) {
                        int length3 = i5 + str3.length();
                        if (str4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        strSubstring = str4.substring(length3);
                        f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                strSubstring = (strSubstring == null || (strF = g82VarB.f(strSubstring)) == null) ? str4 : strF;
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder(length);
        i52.F(arrayList, sb, "\n", null, null, 0, null, null, 124, null);
        String string = sb.toString();
        f92.c(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String d(String str, String str2) {
        f92.d(str, "$this$trimMargin");
        f92.d(str2, "marginPrefix");
        return c(str, "", str2);
    }

    public static /* synthetic */ String e(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return d(str, str2);
    }
}
