package u2;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.w0;
import androidx.room.w2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<u2.a> f51805b;

    public class a extends w0<u2.a> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i stmt, u2.a value) {
            String str = value.f51802a;
            if (str == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, str);
            }
            String str2 = value.f51803b;
            if (str2 == null) {
                stmt.l1(2);
            } else {
                stmt.D(2, str2);
            }
        }
    }

    public c(RoomDatabase __db) {
        this.f51804a = __db;
        this.f51805b = new a(__db);
    }

    @Override // u2.b
    public List<String> a(final String id2) {
        w2 w2VarF = w2.f("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51804a.d();
        Cursor cursorF = b2.c.f(this.f51804a, w2VarF, false, null);
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

    @Override // u2.b
    public boolean b(final String id2) {
        w2 w2VarF = w2.f("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51804a.d();
        boolean z10 = false;
        Cursor cursorF = b2.c.f(this.f51804a, w2VarF, false, null);
        try {
            if (cursorF.moveToFirst()) {
                z10 = cursorF.getInt(0) != 0;
            }
            return z10;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.b
    public boolean c(final String id2) {
        w2 w2VarF = w2.f("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51804a.d();
        boolean z10 = false;
        Cursor cursorF = b2.c.f(this.f51804a, w2VarF, false, null);
        try {
            if (cursorF.moveToFirst()) {
                z10 = cursorF.getInt(0) != 0;
            }
            return z10;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.b
    public void d(final u2.a dependency) {
        this.f51804a.d();
        this.f51804a.e();
        try {
            this.f51805b.i(dependency);
            this.f51804a.K();
        } finally {
            this.f51804a.k();
        }
    }

    @Override // u2.b
    public List<String> e(final String id2) {
        w2 w2VarF = w2.f("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51804a.d();
        Cursor cursorF = b2.c.f(this.f51804a, w2VarF, false, null);
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
}
