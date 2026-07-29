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
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m1
    @j0(name = "work_spec_id")
    @n0
    public final String f51829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "progress")
    @n0
    public final androidx.work.d f51830b;

    public o(@n0 String workSpecId, @n0 androidx.work.d progress) {
        this.f51829a = workSpecId;
        this.f51830b = progress;
    }
}
