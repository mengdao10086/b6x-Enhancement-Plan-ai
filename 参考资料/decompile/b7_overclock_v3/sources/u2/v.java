package u2;

import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@l0
public interface v {
    @p1("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=:id")
    List<String> a(String id2);

    @p1("SELECT work_spec_id FROM worktag WHERE tag=:tag")
    List<String> b(String tag);

    @e1(onConflict = 5)
    void c(u workTag);
}
