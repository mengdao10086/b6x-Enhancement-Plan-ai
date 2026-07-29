package u2;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.c3;
import androidx.room.w0;
import androidx.room.w2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<o> f51832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f51833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c3 f51834d;

    public class a extends w0<o> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i stmt, o value) throws Throwable {
            String str = value.f51829a;
            if (str == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, str);
            }
            byte[] bArrF = androidx.work.d.F(value.f51830b);
            if (bArrF == null) {
                stmt.l1(2);
            } else {
                stmt.E0(2, bArrF);
            }
        }
    }

    public class b extends c3 {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends c3 {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM WorkProgress";
        }
    }

    public q(RoomDatabase __db) {
        this.f51831a = __db;
        this.f51832b = new a(__db);
        this.f51833c = new b(__db);
        this.f51834d = new c(__db);
    }

    @Override // u2.p
    public void a(final String workSpecId) {
        this.f51831a.d();
        c2.i iVarA = this.f51833c.a();
        if (workSpecId == null) {
            iVarA.l1(1);
        } else {
            iVarA.D(1, workSpecId);
        }
        this.f51831a.e();
        try {
            iVarA.a0();
            this.f51831a.K();
        } finally {
            this.f51831a.k();
            this.f51833c.f(iVarA);
        }
    }

    @Override // u2.p
    public void b() {
        this.f51831a.d();
        c2.i iVarA = this.f51834d.a();
        this.f51831a.e();
        try {
            iVarA.a0();
            this.f51831a.K();
        } finally {
            this.f51831a.k();
            this.f51834d.f(iVarA);
        }
    }

    @Override // u2.p
    public void c(final o progress) {
        this.f51831a.d();
        this.f51831a.e();
        try {
            this.f51832b.i(progress);
            this.f51831a.K();
        } finally {
            this.f51831a.k();
        }
    }

    @Override // u2.p
    public androidx.work.d d(final String workSpecId) {
        w2 w2VarF = w2.f("SELECT progress FROM WorkProgress WHERE work_spec_id=?", 1);
        if (workSpecId == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, workSpecId);
        }
        this.f51831a.d();
        Cursor cursorF = b2.c.f(this.f51831a, w2VarF, false, null);
        try {
            return cursorF.moveToFirst() ? androidx.work.d.m(cursorF.getBlob(0)) : null;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.p
    public List<androidx.work.d> e(final List<String> workSpecIds) {
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT progress FROM WorkProgress WHERE work_spec_id IN (");
        int size = workSpecIds.size();
        b2.g.a(sbC, size);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size + 0);
        int i10 = 1;
        for (String str : workSpecIds) {
            if (str == null) {
                w2VarF.l1(i10);
            } else {
                w2VarF.D(i10, str);
            }
            i10++;
        }
        this.f51831a.d();
        Cursor cursorF = b2.c.f(this.f51831a, w2VarF, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                arrayList.add(androidx.work.d.m(cursorF.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }
}
