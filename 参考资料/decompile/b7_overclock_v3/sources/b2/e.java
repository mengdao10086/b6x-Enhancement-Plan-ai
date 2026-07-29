package b2;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f9015d = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f9017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f9018c;

    public e(String str, Set<String> set, Set<String> set2) {
        this.f9016a = str;
        this.f9017b = set;
        this.f9018c = set2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    @g.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Set<java.lang.String> a(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.e.a(java.lang.String):java.util.Set");
    }

    public static e b(c2.d dVar, String str) {
        return new e(str, c(dVar, str), d(dVar, str));
    }

    public static Set<String> c(c2.d dVar, String str) {
        Cursor cursorL0 = dVar.L0("PRAGMA table_info(`" + str + "`)");
        HashSet hashSet = new HashSet();
        try {
            if (cursorL0.getColumnCount() > 0) {
                int columnIndex = cursorL0.getColumnIndex("name");
                while (cursorL0.moveToNext()) {
                    hashSet.add(cursorL0.getString(columnIndex));
                }
            }
            return hashSet;
        } finally {
            cursorL0.close();
        }
    }

    public static Set<String> d(c2.d dVar, String str) {
        Cursor cursorL0 = dVar.L0("SELECT * FROM sqlite_master WHERE `name` = '" + str + "'");
        try {
            String string = cursorL0.moveToFirst() ? cursorL0.getString(cursorL0.getColumnIndexOrThrow("sql")) : "";
            cursorL0.close();
            return a(string);
        } catch (Throwable th2) {
            cursorL0.close();
            throw th2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f9016a;
        if (str == null ? eVar.f9016a != null : !str.equals(eVar.f9016a)) {
            return false;
        }
        Set<String> set = this.f9017b;
        if (set == null ? eVar.f9017b != null : !set.equals(eVar.f9017b)) {
            return false;
        }
        Set<String> set2 = this.f9018c;
        Set<String> set3 = eVar.f9018c;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    public int hashCode() {
        String str = this.f9016a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Set<String> set = this.f9017b;
        int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
        Set<String> set2 = this.f9018c;
        return iHashCode2 + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.f9016a + "', columns=" + this.f9017b + ", options=" + this.f9018c + '}';
    }

    public e(String str, Set<String> set, String str2) {
        this.f9016a = str;
        this.f9017b = set;
        this.f9018c = a(str2);
    }
}
