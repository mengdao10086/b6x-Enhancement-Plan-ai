package u2;

import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@l0
public interface j {
    @p1("SELECT DISTINCT work_spec_id FROM SystemIdInfo")
    @n0
    List<String> a();

    @e1(onConflict = 1)
    void b(@n0 i systemIdInfo);

    @p1("SELECT * FROM SystemIdInfo WHERE work_spec_id=:workSpecId")
    @p0
    i c(@n0 String workSpecId);

    @p1("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId")
    void d(@n0 String workSpecId);
}
