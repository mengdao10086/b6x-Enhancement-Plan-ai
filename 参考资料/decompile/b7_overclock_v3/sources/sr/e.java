package sr;

import com.blankj.utilcode.util.i0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
public class e implements org.bouncycastle.util.k<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List> f50400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f50401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f50406g;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f50408b;

        public a(String str, String str2) {
            this.f50407a = str;
            this.f50408b = str2;
        }

        public a(a aVar) {
            this.f50407a = aVar.f50407a;
            this.f50408b = aVar.f50408b;
        }
    }

    public e(InputStream inputStream, String str) throws IOException {
        this(o(inputStream), str);
    }

    public e(List<String> list, String str) {
        Map<String, String> mapB;
        this.f50400a = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.f50401b = list;
        String str2 = "";
        for (String str3 : list) {
            if (str3.startsWith(i0.f11861z) || str3.startsWith("\t")) {
                str2 = str2 + str3.trim();
            } else {
                if (str2.length() != 0) {
                    p(str2.substring(0, str2.indexOf(58)).trim(), str2.substring(str2.indexOf(58) + 1).trim());
                }
                str2 = str3;
            }
        }
        if (str2.trim().length() != 0) {
            p(str2.substring(0, str2.indexOf(58)).trim(), str2.substring(str2.indexOf(58) + 1).trim());
        }
        String str4 = l("Content-Type") == null ? "text/plain" : l("Content-Type")[0];
        int iIndexOf = str4.indexOf(59);
        if (iIndexOf < 0) {
            this.f50405f = str4;
            mapB = Collections.EMPTY_MAP;
        } else {
            this.f50405f = str4.substring(0, iIndexOf);
            mapB = b(str4.substring(iIndexOf + 1).trim());
        }
        this.f50406g = mapB;
        this.f50402c = l("Content-Transfer-Encoding") != null ? l("Content-Transfer-Encoding")[0] : str;
        if (this.f50405f.indexOf("multipart") < 0) {
            this.f50403d = null;
            this.f50404e = false;
        } else {
            this.f50404e = true;
            String str5 = this.f50406g.get("boundary");
            this.f50403d = str5.substring(1, str5.length() - 1);
        }
    }

    public static List<String> o(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        f fVar = new f(inputStream);
        while (true) {
            String strA = fVar.a();
            if (strA == null || strA.length() == 0) {
                break;
            }
            arrayList.add(strA);
        }
        return arrayList;
    }

    public boolean a(String str) {
        return this.f50400a.containsKey(str);
    }

    public final Map<String, String> b(String str) {
        String[] strArrSplit = str.split(";");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 = 0; i10 != strArrSplit.length; i10++) {
            String str2 = strArrSplit[i10];
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf < 0) {
                throw new IllegalArgumentException("malformed Content-Type header");
            }
            linkedHashMap.put(str2.substring(0, iIndexOf).trim(), str2.substring(iIndexOf + 1).trim());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public void d(OutputStream outputStream) throws IOException {
        Iterator<String> it2 = this.f50401b.iterator();
        while (it2.hasNext()) {
            outputStream.write(Strings.m(it2.next().toString()));
            outputStream.write(13);
            outputStream.write(10);
        }
    }

    public String e() {
        return this.f50403d;
    }

    public String f() {
        return this.f50402c;
    }

    public String g() {
        return this.f50405f;
    }

    public Map<String, String> i() {
        return this.f50406g;
    }

    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this) {
            zIsEmpty = this.f50400a.isEmpty();
        }
        return zIsEmpty;
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f50400a.keySet().iterator();
    }

    public Iterator<String> j() {
        return this.f50400a.keySet().iterator();
    }

    public String[] l(String str) {
        synchronized (this) {
            List list = this.f50400a.get(str);
            if (list == null) {
                return null;
            }
            String[] strArr = new String[list.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                strArr[i10] = ((a) list.get(i10)).f50408b;
            }
            return strArr;
        }
    }

    public boolean m() {
        return this.f50404e;
    }

    public final void p(String str, String str2) {
        synchronized (this) {
            a aVar = new a(str, str2);
            List arrayList = this.f50400a.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f50400a.put(str, arrayList);
            }
            arrayList.add(aVar);
        }
    }
}
