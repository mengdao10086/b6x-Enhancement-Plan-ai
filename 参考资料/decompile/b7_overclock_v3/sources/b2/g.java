package b2;

import androidx.annotation.RestrictTo;
import g.p0;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f9019a = new String[0];

    public static void a(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("?");
            if (i11 < i10 - 1) {
                sb2.append(ag.c.f654g);
            }
        }
    }

    @p0
    public static String b(@p0 List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(Integer.toString(list.get(i10).intValue()));
            if (i10 < size - 1) {
                sb2.append(ag.c.f654g);
            }
        }
        return sb2.toString();
    }

    public static StringBuilder c() {
        return new StringBuilder();
    }

    @p0
    public static List<Integer> d(@p0 String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ag.c.f654g);
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException unused) {
            }
        }
        return arrayList;
    }
}
