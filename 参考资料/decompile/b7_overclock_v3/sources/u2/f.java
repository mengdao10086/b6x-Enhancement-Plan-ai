package u2;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.w0;
import androidx.room.w2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<d> f51810b;

    public class a extends w0<d> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i stmt, d value) {
            String str = value.f51807a;
            if (str == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, str);
            }
            Long l10 = value.f51808b;
            if (l10 == null) {
                stmt.l1(2);
            } else {
                stmt.s0(2, l10.longValue());
            }
        }
    }

    public class b implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f51812a;

        public b(final w2 val$_statement) {
            this.f51812a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() throws Exception {
            Long lValueOf = null;
            Cursor cursorF = b2.c.f(f.this.f51809a, this.f51812a, false, null);
            try {
                if (cursorF.moveToFirst() && !cursorF.isNull(0)) {
                    lValueOf = Long.valueOf(cursorF.getLong(0));
                }
                return lValueOf;
            } finally {
                cursorF.close();
            }
        }

        public void finalize() {
            this.f51812a.m();
        }
    }

    public f(RoomDatabase __db) {
        this.f51809a = __db;
        this.f51810b = new a(__db);
    }

    @Override // u2.e
    public LiveData<Long> a(final String key) {
        w2 w2VarF = w2.f("SELECT long_value FROM Preference where `key`=?", 1);
        if (key == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, key);
        }
        return this.f51809a.o().f(new String[]{"Preference"}, false, new b(w2VarF));
    }

    @Override // u2.e
    public void b(final d preference) {
        this.f51809a.d();
        this.f51809a.e();
        try {
            this.f51810b.i(preference);
            this.f51809a.K();
        } finally {
            this.f51809a.k();
        }
    }

    @Override // u2.e
    public Long c(final String key) {
        w2 w2VarF = w2.f("SELECT long_value FROM Preference where `key`=?", 1);
        if (key == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, key);
        }
        this.f51809a.d();
        Long lValueOf = null;
        Cursor cursorF = b2.c.f(this.f51809a, w2VarF, false, null);
        try {
            if (cursorF.moveToFirst() && !cursorF.isNull(0)) {
                lValueOf = Long.valueOf(cursorF.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }
}
