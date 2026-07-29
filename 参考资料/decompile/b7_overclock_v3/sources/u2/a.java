package u2;

import androidx.annotation.RestrictTo;
import androidx.room.Index;
import androidx.room.j0;
import androidx.room.u0;
import androidx.room.y0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@u0(foreignKeys = {@y0(childColumns = {"work_spec_id"}, entity = r.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"}), @y0(childColumns = {"prerequisite_id"}, entity = r.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"}), @Index({"prerequisite_id"})}, primaryKeys = {"work_spec_id", "prerequisite_id"})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @j0(name = "work_spec_id")
    @n0
    public final String f51802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "prerequisite_id")
    @n0
    public final String f51803b;

    public a(@n0 String workSpecId, @n0 String prerequisiteId) {
        this.f51802a = workSpecId;
        this.f51803b = prerequisiteId;
    }
}
