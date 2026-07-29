package u2;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.w0;
import androidx.room.w2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<u> f51899b;

    public class a extends w0<u> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i stmt, u value) {
            String str = value.f51896a;
            if (str == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, str);
            }
            String str2 = value.f51897b;
            if (str2 == null) {
                stmt.l1(2);
            } else {
                stmt.D(2, str2);
            }
        }
    }

    public w(RoomDatabase __db) {
        this.f51898a = __db;
        this.f51899b = new a(__db);
    }

    @Override // u2.v
    public List<String> a(final String id2) {
        w2 w2VarF = w2.f("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51898a.d();
        Cursor cursorF = b2.c.f(this.f51898a, w2VarF, false, null);
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

    @Override // u2.v
    public List<String> b(final String tag) {
        w2 w2VarF = w2.f("SELECT work_spec_id FROM worktag WHERE tag=?", 1);
        if (tag == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, tag);
        }
        this.f51898a.d();
        Cursor cursorF = b2.c.f(this.f51898a, w2VarF, false, null);
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

    @Override // u2.v
    public void c(final u workTag) {
        this.f51898a.d();
        this.f51898a.e();
        try {
            this.f51899b.i(workTag);
            this.f51898a.K();
        } finally {
            this.f51898a.k();
        }
    }
}
