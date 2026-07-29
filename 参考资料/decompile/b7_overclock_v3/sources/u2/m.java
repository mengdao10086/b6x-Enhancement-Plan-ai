package u2;

import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@l0
public interface m {
    @p1("SELECT work_spec_id FROM workname WHERE name=:name")
    List<String> a(String name);

    @e1(onConflict = 5)
    void b(l workName);

    @p1("SELECT name FROM workname WHERE work_spec_id=:workSpecId")
    @n0
    List<String> c(@n0 String workSpecId);
}
