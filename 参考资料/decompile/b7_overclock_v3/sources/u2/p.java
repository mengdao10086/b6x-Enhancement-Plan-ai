package u2;

import androidx.annotation.RestrictTo;
import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@l0
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface p {
    @p1("DELETE from WorkProgress where work_spec_id=:workSpecId")
    void a(@n0 String workSpecId);

    @p1("DELETE FROM WorkProgress")
    void b();

    @e1(onConflict = 1)
    void c(@n0 o progress);

    @p1("SELECT progress FROM WorkProgress WHERE work_spec_id=:workSpecId")
    @p0
    androidx.work.d d(@n0 String workSpecId);

    @p1("SELECT progress FROM WorkProgress WHERE work_spec_id IN (:workSpecIds)")
    @n0
    List<androidx.work.d> e(@n0 List<String> workSpecIds);
}
