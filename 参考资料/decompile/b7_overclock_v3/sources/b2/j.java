package b2;

import android.database.Cursor;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9049b;

    public j(String str, String str2) {
        this.f9048a = str;
        this.f9049b = str2;
    }

    public static j a(c2.d dVar, String str) {
        Cursor cursorL0 = dVar.L0("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + "'");
        try {
            return cursorL0.moveToFirst() ? new j(cursorL0.getString(0), cursorL0.getString(1)) : new j(str, null);
        } finally {
            cursorL0.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.f9048a;
        if (str == null ? jVar.f9048a == null : str.equals(jVar.f9048a)) {
            String str2 = this.f9049b;
            if (str2 != null) {
                if (str2.equals(jVar.f9049b)) {
                    return true;
                }
            } else if (jVar.f9049b == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f9048a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f9049b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ViewInfo{name='" + this.f9048a + "', sql='" + this.f9049b + "'}";
    }
}
