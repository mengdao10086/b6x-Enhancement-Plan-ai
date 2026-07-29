package j3;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append("    at ");
            sb2.append(stackTraceElement.toString());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public static String b(String str) {
        return (!str.contains("|") || str.endsWith("|")) ? str : str.substring(0, str.indexOf("|"));
    }

    public static String c(String str) {
        return (!str.contains("|") || str.startsWith("|")) ? str : str.substring(str.indexOf("|") + 1);
    }

    public static boolean d(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static Map<String, String> e(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        do {
            int iIndexOf = encodedQuery.indexOf(38, i10);
            if (iIndexOf == -1) {
                iIndexOf = encodedQuery.length();
            }
            int iIndexOf2 = encodedQuery.indexOf(61, i10);
            if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            String strSubstring = encodedQuery.substring(i10, iIndexOf2);
            if (!TextUtils.isEmpty(strSubstring)) {
                linkedHashMap.put(Uri.decode(strSubstring), Uri.decode(iIndexOf2 == iIndexOf ? "" : encodedQuery.substring(iIndexOf2 + 1, iIndexOf)));
            }
            i10 = iIndexOf + 1;
        } while (i10 < encodedQuery.length());
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
