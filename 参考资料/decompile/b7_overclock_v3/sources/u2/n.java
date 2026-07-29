package u2;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.w0;
import androidx.room.w2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<l> f51827b;

    public class a extends w0<l> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i stmt, l value) {
            String str = value.f51824a;
            if (str == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, str);
            }
            String str2 = value.f51825b;
            if (str2 == null) {
                stmt.l1(2);
            } else {
                stmt.D(2, str2);
            }
        }
    }

    public n(RoomDatabase __db) {
        this.f51826a = __db;
        this.f51827b = new a(__db);
    }

    @Override // u2.m
    public List<String> a(final String name) {
        w2 w2VarF = w2.f("SELECT work_spec_id FROM workname WHERE name=?", 1);
        if (name == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, name);
        }
        this.f51826a.d();
        Cursor cursorF = b2.c.f(this.f51826a, w2VarF, false, null);
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

    @Override // u2.m
    public void b(final l workName) {
        this.f51826a.d();
        this.f51826a.e();
        try {
            this.f51827b.i(workName);
            this.f51826a.K();
        } finally {
            this.f51826a.k();
        }
    }

    @Override // u2.m
    public List<String> c(final String workSpecId) {
        w2 w2VarF = w2.f("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (workSpecId == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, workSpecId);
        }
        this.f51826a.d();
        Cursor cursorF = b2.c.f(this.f51826a, w2VarF, false, null);
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
