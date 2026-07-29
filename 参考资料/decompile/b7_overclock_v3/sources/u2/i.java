package u2;

import androidx.annotation.RestrictTo;
import androidx.room.j0;
import androidx.room.m1;
import androidx.room.u0;
import androidx.room.y0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@u0(foreignKeys = {@y0(childColumns = {"work_spec_id"}, entity = r.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m1
    @j0(name = "work_spec_id")
    @n0
    public final String f51817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "system_id")
    public final int f51818b;

    public i(@n0 String workSpecId, int systemId) {
        this.f51817a = workSpecId;
        this.f51818b = systemId;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof i)) {
            return false;
        }
        i iVar = (i) o10;
        if (this.f51818b != iVar.f51818b) {
            return false;
        }
        return this.f51817a.equals(iVar.f51817a);
    }

    public int hashCode() {
        return (this.f51817a.hashCode() * 31) + this.f51818b;
    }
}
