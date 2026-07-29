package u2;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.c3;
import androidx.room.w0;
import androidx.room.w2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<i> f51820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f51821c;

    public class a extends w0<i> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i stmt, i value) {
            String str = value.f51817a;
            if (str == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, str);
            }
            stmt.s0(2, value.f51818b);
        }
    }

    public class b extends c3 {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public k(RoomDatabase __db) {
        this.f51819a = __db;
        this.f51820b = new a(__db);
        this.f51821c = new b(__db);
    }

    @Override // u2.j
    public List<String> a() {
        w2 w2VarF = w2.f("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f51819a.d();
        Cursor cursorF = b2.c.f(this.f51819a, w2VarF, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                arrayList.add(cursorF.getString(0));
            }
            return arrayList;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.j
    public void b(final i systemIdInfo) {
        this.f51819a.d();
        this.f51819a.e();
        try {
            this.f51820b.i(systemIdInfo);
            this.f51819a.K();
        } finally {
            this.f51819a.k();
        }
    }

    @Override // u2.j
    public i c(final String workSpecId) {
        w2 w2VarF = w2.f("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (workSpecId == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, workSpecId);
        }
        this.f51819a.d();
        Cursor cursorF = b2.c.f(this.f51819a, w2VarF, false, null);
        try {
            return cursorF.moveToFirst() ? new i(cursorF.getString(b2.b.e(cursorF, "work_spec_id")), cursorF.getInt(b2.b.e(cursorF, "system_id"))) : null;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.j
    public void d(final String workSpecId) {
        this.f51819a.d();
        c2.i iVarA = this.f51821c.a();
        if (workSpecId == null) {
            iVarA.l1(1);
        } else {
            iVarA.D(1, workSpecId);
        }
        this.f51819a.e();
        try {
            iVarA.a0();
            this.f51819a.K();
        } finally {
            this.f51819a.k();
            this.f51821c.f(iVarA);
        }
    }
}
