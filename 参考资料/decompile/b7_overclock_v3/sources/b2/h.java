package b2;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.room.Index;
import androidx.room.j0;
import com.tencent.open.SocialConstants;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9020e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9021f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9022g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f9024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<b> f9025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final Set<d> f9026d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @j0.b
        public final int f9029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9030d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9031e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f9032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f9033g;

        @Deprecated
        public a(String str, String str2, boolean z10, int i10) {
            this(str, str2, z10, i10, null, 0);
        }

        public static boolean a(@n0 String str) {
            if (str.length() == 0) {
                return false;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
                if (i11 == 0 && cCharAt != '(') {
                    return false;
                }
                if (cCharAt == '(') {
                    i10++;
                } else if (cCharAt == ')' && i10 - 1 == 0 && i11 != str.length() - 1) {
                    return false;
                }
            }
            return i10 == 0;
        }

        public static boolean b(@n0 String str, @p0 String str2) {
            if (str2 == null) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            if (a(str)) {
                return str.substring(1, str.length() - 1).trim().equals(str2);
            }
            return false;
        }

        @j0.b
        public static int c(@p0 String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean d() {
            return this.f9031e > 0;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f9031e != aVar.f9031e || !this.f9027a.equals(aVar.f9027a) || this.f9030d != aVar.f9030d) {
                return false;
            }
            if (this.f9033g == 1 && aVar.f9033g == 2 && (str3 = this.f9032f) != null && !b(str3, aVar.f9032f)) {
                return false;
            }
            if (this.f9033g == 2 && aVar.f9033g == 1 && (str2 = aVar.f9032f) != null && !b(str2, this.f9032f)) {
                return false;
            }
            int i10 = this.f9033g;
            return (i10 == 0 || i10 != aVar.f9033g || ((str = this.f9032f) == null ? aVar.f9032f == null : b(str, aVar.f9032f))) && this.f9029c == aVar.f9029c;
        }

        public int hashCode() {
            return (((((this.f9027a.hashCode() * 31) + this.f9029c) * 31) + (this.f9030d ? 1231 : 1237)) * 31) + this.f9031e;
        }

        public String toString() {
            return "Column{name='" + this.f9027a + "', type='" + this.f9028b + "', affinity='" + this.f9029c + "', notNull=" + this.f9030d + ", primaryKeyPosition=" + this.f9031e + ", defaultValue='" + this.f9032f + "'}";
        }

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            this.f9027a = str;
            this.f9028b = str2;
            this.f9030d = z10;
            this.f9031e = i10;
            this.f9029c = c(str2);
            this.f9032f = str3;
            this.f9033g = i11;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final String f9034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final String f9035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final String f9036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public final List<String> f9037d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @n0
        public final List<String> f9038e;

        public b(@n0 String str, @n0 String str2, @n0 String str3, @n0 List<String> list, @n0 List<String> list2) {
            this.f9034a = str;
            this.f9035b = str2;
            this.f9036c = str3;
            this.f9037d = Collections.unmodifiableList(list);
            this.f9038e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f9034a.equals(bVar.f9034a) && this.f9035b.equals(bVar.f9035b) && this.f9036c.equals(bVar.f9036c) && this.f9037d.equals(bVar.f9037d)) {
                return this.f9038e.equals(bVar.f9038e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f9034a.hashCode() * 31) + this.f9035b.hashCode()) * 31) + this.f9036c.hashCode()) * 31) + this.f9037d.hashCode()) * 31) + this.f9038e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f9034a + "', onDelete='" + this.f9035b + "', onUpdate='" + this.f9036c + "', columnNames=" + this.f9037d + ", referenceColumnNames=" + this.f9038e + '}';
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f9042d;

        public c(int i10, int i11, String str, String str2) {
            this.f9039a = i10;
            this.f9040b = i11;
            this.f9041c = str;
            this.f9042d = str2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@n0 c cVar) {
            int i10 = this.f9039a - cVar.f9039a;
            return i10 == 0 ? this.f9040b - cVar.f9040b : i10;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f9043e = "index_";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f9046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f9047d;

        public d(String str, boolean z10, List<String> list) {
            this(str, z10, list, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f9045b == dVar.f9045b && this.f9046c.equals(dVar.f9046c) && this.f9047d.equals(dVar.f9047d)) {
                return this.f9044a.startsWith(f9043e) ? dVar.f9044a.startsWith(f9043e) : this.f9044a.equals(dVar.f9044a);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f9044a.startsWith(f9043e) ? -1184239155 : this.f9044a.hashCode()) * 31) + (this.f9045b ? 1 : 0)) * 31) + this.f9046c.hashCode()) * 31) + this.f9047d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f9044a + "', unique=" + this.f9045b + ", columns=" + this.f9046c + ", orders=" + this.f9047d + '}';
        }

        public d(String str, boolean z10, List<String> list, List<String> list2) {
            this.f9044a = str;
            this.f9045b = z10;
            this.f9046c = list;
            this.f9047d = (list2 == null || list2.size() == 0) ? Collections.nCopies(list.size(), Index.Order.ASC.name()) : list2;
        }
    }

    public h(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.f9023a = str;
        this.f9024b = Collections.unmodifiableMap(map);
        this.f9025c = Collections.unmodifiableSet(set);
        this.f9026d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static h a(c2.d dVar, String str) {
        return new h(str, b(dVar, str), d(dVar, str), f(dVar, str));
    }

    public static Map<String, a> b(c2.d dVar, String str) {
        Cursor cursorL0 = dVar.L0("PRAGMA table_info(`" + str + "`)");
        HashMap map = new HashMap();
        try {
            if (cursorL0.getColumnCount() > 0) {
                int columnIndex = cursorL0.getColumnIndex("name");
                int columnIndex2 = cursorL0.getColumnIndex("type");
                int columnIndex3 = cursorL0.getColumnIndex("notnull");
                int columnIndex4 = cursorL0.getColumnIndex("pk");
                int columnIndex5 = cursorL0.getColumnIndex("dflt_value");
                while (cursorL0.moveToNext()) {
                    String string = cursorL0.getString(columnIndex);
                    map.put(string, new a(string, cursorL0.getString(columnIndex2), cursorL0.getInt(columnIndex3) != 0, cursorL0.getInt(columnIndex4), cursorL0.getString(columnIndex5), 2));
                }
            }
            return map;
        } finally {
            cursorL0.close();
        }
    }

    public static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(w.h.f53783c);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < count; i10++) {
            cursor.moveToPosition(i10);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Set<b> d(c2.d dVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorL0 = dVar.L0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorL0.getColumnIndex("id");
            int columnIndex2 = cursorL0.getColumnIndex("seq");
            int columnIndex3 = cursorL0.getColumnIndex("table");
            int columnIndex4 = cursorL0.getColumnIndex("on_delete");
            int columnIndex5 = cursorL0.getColumnIndex("on_update");
            List<c> listC = c(cursorL0);
            int count = cursorL0.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                cursorL0.moveToPosition(i10);
                if (cursorL0.getInt(columnIndex2) == 0) {
                    int i11 = cursorL0.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : listC) {
                        if (cVar.f9039a == i11) {
                            arrayList.add(cVar.f9041c);
                            arrayList2.add(cVar.f9042d);
                        }
                    }
                    hashSet.add(new b(cursorL0.getString(columnIndex3), cursorL0.getString(columnIndex4), cursorL0.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            cursorL0.close();
        }
    }

    @p0
    public static d e(c2.d dVar, String str, boolean z10) {
        Cursor cursorL0 = dVar.L0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorL0.getColumnIndex("seqno");
            int columnIndex2 = cursorL0.getColumnIndex("cid");
            int columnIndex3 = cursorL0.getColumnIndex("name");
            int columnIndex4 = cursorL0.getColumnIndex(SocialConstants.PARAM_APP_DESC);
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorL0.moveToNext()) {
                    if (cursorL0.getInt(columnIndex2) >= 0) {
                        int i10 = cursorL0.getInt(columnIndex);
                        String string = cursorL0.getString(columnIndex3);
                        String str2 = cursorL0.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        treeMap.put(Integer.valueOf(i10), string);
                        treeMap2.put(Integer.valueOf(i10), str2);
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                ArrayList arrayList2 = new ArrayList(treeMap2.size());
                arrayList2.addAll(treeMap2.values());
                return new d(str, z10, arrayList, arrayList2);
            }
            return null;
        } finally {
            cursorL0.close();
        }
    }

    @p0
    public static Set<d> f(c2.d dVar, String str) {
        Cursor cursorL0 = dVar.L0("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorL0.getColumnIndex("name");
            int columnIndex2 = cursorL0.getColumnIndex("origin");
            int columnIndex3 = cursorL0.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (cursorL0.moveToNext()) {
                    if ("c".equals(cursorL0.getString(columnIndex2))) {
                        String string = cursorL0.getString(columnIndex);
                        boolean z10 = true;
                        if (cursorL0.getInt(columnIndex3) != 1) {
                            z10 = false;
                        }
                        d dVarE = e(dVar, string, z10);
                        if (dVarE == null) {
                            return null;
                        }
                        hashSet.add(dVarE);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            cursorL0.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.f9023a;
        if (str == null ? hVar.f9023a != null : !str.equals(hVar.f9023a)) {
            return false;
        }
        Map<String, a> map = this.f9024b;
        if (map == null ? hVar.f9024b != null : !map.equals(hVar.f9024b)) {
            return false;
        }
        Set<b> set2 = this.f9025c;
        if (set2 == null ? hVar.f9025c != null : !set2.equals(hVar.f9025c)) {
            return false;
        }
        Set<d> set3 = this.f9026d;
        if (set3 == null || (set = hVar.f9026d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f9023a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f9024b;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f9025c;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f9023a + "', columns=" + this.f9024b + ", foreignKeys=" + this.f9025c + ", indices=" + this.f9026d + '}';
    }

    public h(String str, Map<String, a> map, Set<b> set) {
        this(str, map, set, Collections.emptySet());
    }
}
