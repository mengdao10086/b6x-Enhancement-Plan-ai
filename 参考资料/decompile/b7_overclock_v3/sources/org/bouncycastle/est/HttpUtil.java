package org.bouncycastle.est;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.y;

/* JADX INFO: loaded from: classes5.dex */
public class HttpUtil {

    public static class Headers extends HashMap<String, String[]> {
        public final String a(String str) {
            if (containsKey(str)) {
                return str;
            }
            for (String str2 : keySet()) {
                if (str.equalsIgnoreCase(str2)) {
                    return str2;
                }
            }
            return null;
        }

        public void b(String str, String str2) {
            put(str, HttpUtil.a(get(str), str2));
        }

        public final String[] c(String[] strArr) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            return strArr2;
        }

        @Override // java.util.HashMap, java.util.AbstractMap
        public Object clone() {
            Headers headers = new Headers();
            for (Map.Entry<String, String[]> entry : entrySet()) {
                headers.put(entry.getKey(), c(entry.getValue()));
            }
            return headers;
        }

        public void d(String str, String str2) {
            if (containsKey(str)) {
                return;
            }
            m(str, str2);
        }

        public String h(String str) {
            String[] strArrK = k(str);
            if (strArrK == null || strArrK.length <= 0) {
                return null;
            }
            return strArrK[0];
        }

        public String[] k(String str) {
            String strA = a(str);
            if (strA == null) {
                return null;
            }
            return get(strA);
        }

        public final boolean l(String str) {
            return a(str) != null;
        }

        public void m(String str, String str2) {
            put(str, new String[]{str2});
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f44772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f44773b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f44774c = 0;

        public a(String str) {
            this.f44772a = str;
        }

        public Map<String, String> a() {
            HashMap map = new HashMap();
            while (this.f44774c < this.f44772a.length()) {
                g();
                String strB = b();
                if (strB.length() == 0) {
                    throw new IllegalArgumentException("Expecting alpha label.");
                }
                g();
                if (!c('=')) {
                    throw new IllegalArgumentException("Expecting assign: '='");
                }
                g();
                if (!c(y.f38188b)) {
                    throw new IllegalArgumentException("Expecting start quote: '\"'");
                }
                e();
                String strD = d(y.f38188b);
                f(1);
                map.put(strB, strD);
                g();
                if (!c(',')) {
                    break;
                }
                e();
            }
            return map;
        }

        public final String b() {
            char cCharAt = this.f44772a.charAt(this.f44774c);
            while (this.f44774c < this.f44772a.length() && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                int i10 = this.f44774c + 1;
                this.f44774c = i10;
                cCharAt = this.f44772a.charAt(i10);
            }
            String strSubstring = this.f44772a.substring(this.f44773b, this.f44774c);
            this.f44773b = this.f44774c;
            return strSubstring;
        }

        public final boolean c(char c10) {
            if (this.f44774c >= this.f44772a.length() || this.f44772a.charAt(this.f44774c) != c10) {
                return false;
            }
            this.f44774c++;
            return true;
        }

        public final String d(char c10) {
            while (this.f44774c < this.f44772a.length() && this.f44772a.charAt(this.f44774c) != c10) {
                this.f44774c++;
            }
            String strSubstring = this.f44772a.substring(this.f44773b, this.f44774c);
            this.f44773b = this.f44774c;
            return strSubstring;
        }

        public final void e() {
            this.f44773b = this.f44774c;
        }

        public final void f(int i10) {
            int i11 = this.f44774c + i10;
            this.f44774c = i11;
            this.f44773b = i11;
        }

        public final void g() {
            while (this.f44774c < this.f44772a.length() && this.f44772a.charAt(this.f44774c) < '!') {
                this.f44774c++;
            }
            this.f44773b = this.f44774c;
        }
    }

    public static String[] a(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    public static String b(String str, Map<String, String> map) {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(str);
        stringWriter.write(32);
        boolean z10 = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z10) {
                stringWriter.write(44);
            } else {
                z10 = true;
            }
            stringWriter.write(entry.getKey());
            stringWriter.write("=\"");
            stringWriter.write(entry.getValue());
            stringWriter.write(34);
        }
        return stringWriter.toString();
    }

    public static Map<String, String> c(String str, String str2) {
        String strTrim = str2.trim();
        if (strTrim.startsWith(str)) {
            strTrim = strTrim.substring(str.length());
        }
        return new a(strTrim).a();
    }
}
