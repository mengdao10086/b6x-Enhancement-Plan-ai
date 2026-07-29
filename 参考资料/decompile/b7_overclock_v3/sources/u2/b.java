package u2;

import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@l0
public interface b {
    @p1("SELECT work_spec_id FROM dependency WHERE prerequisite_id=:id")
    List<String> a(String id2);

    @p1("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=:id AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)")
    boolean b(String id2);

    @p1("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=:id")
    boolean c(String id2);

    @e1(onConflict = 5)
    void d(a dependency);

    @p1("SELECT prerequisite_id FROM dependency WHERE work_spec_id=:id")
    List<String> e(String id2);
}
