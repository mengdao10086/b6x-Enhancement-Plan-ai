package u2;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.e1;
import androidx.room.e3;
import androidx.room.l0;
import androidx.room.p1;
import androidx.work.WorkInfo;
import g.n0;
import java.util.List;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@l0
@SuppressLint({"UnknownNullness"})
public interface s {
    @p1("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=:id)")
    List<androidx.work.d> A(String id2);

    @p1("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=:id")
    int B(String id2);

    @p1("UPDATE workspec SET period_start_time=:periodStartTime WHERE id=:id")
    void C(String id2, long periodStartTime);

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    @e3
    List<r.c> D(String name);

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (:ids)")
    @e3
    List<r.c> E(List<String> ids);

    @p1("SELECT * FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT :maxLimit")
    List<r> F(int maxLimit);

    @p1("SELECT id FROM workspec")
    List<String> G();

    @p1("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)")
    int H();

    @p1("DELETE FROM workspec WHERE id=:id")
    void a(String id2);

    @p1("UPDATE workspec SET state=:state WHERE id IN (:ids)")
    int b(WorkInfo.State state, String... ids);

    @p1("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))")
    void c();

    @p1("UPDATE workspec SET schedule_requested_at=:startTime WHERE id=:id")
    int d(@n0 String id2, long startTime);

    @p1("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    List<r.b> e(String name);

    @p1("SELECT * FROM workspec WHERE period_start_time >= :startingAt AND state IN (2, 3, 5) ORDER BY period_start_time DESC")
    List<r> f(long startingAt);

    @p1("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(:schedulerLimit-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))")
    List<r> g(int schedulerLimit);

    @e1(onConflict = 5)
    void h(r workSpec);

    @p1("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1")
    List<r> i();

    @p1("SELECT * FROM workspec WHERE id IN (:ids)")
    r[] j(List<String> ids);

    @p1("UPDATE workspec SET output=:output WHERE id=:id")
    void k(String id2, androidx.work.d output);

    @p1("SELECT id FROM workspec")
    @e3
    LiveData<List<String>> l();

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    @e3
    LiveData<List<r.c>> m(String name);

    @p1("SELECT * FROM workspec WHERE state=1")
    List<r> n();

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=:tag)")
    @e3
    LiveData<List<r.c>> o(String tag);

    @p1("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)")
    List<String> p();

    @p1("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1")
    boolean q();

    @p1("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    List<String> r(@n0 String name);

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id=:id")
    @e3
    r.c s(String id2);

    @p1("SELECT state FROM workspec WHERE id=:id")
    WorkInfo.State t(String id2);

    @p1("SELECT * FROM workspec WHERE id=:id")
    r u(String id2);

    @p1("UPDATE workspec SET run_attempt_count=0 WHERE id=:id")
    int v(String id2);

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=:tag)")
    @e3
    List<r.c> w(String tag);

    @p1("SELECT schedule_requested_at FROM workspec WHERE id=:id")
    LiveData<Long> x(@n0 String id2);

    @p1("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (:ids)")
    @e3
    LiveData<List<r.c>> y(List<String> ids);

    @p1("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=:tag)")
    List<String> z(@n0 String tag);
}
