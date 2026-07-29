package u2;

import androidx.annotation.RestrictTo;
import androidx.room.Index;
import androidx.room.j0;
import androidx.room.u0;
import androidx.room.y0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@u0(foreignKeys = {@y0(childColumns = {"work_spec_id"}, entity = r.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {"name", "work_spec_id"})
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @j0(name = "name")
    @n0
    public final String f51824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "work_spec_id")
    @n0
    public final String f51825b;

    public l(@n0 String name, @n0 String workSpecId) {
        this.f51824a = name;
        this.f51825b = workSpecId;
    }
}
