package w6;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.c3;
import androidx.room.v0;
import androidx.room.w0;
import androidx.room.w2;
import androidx.room.z2;
import c2.i;
import com.flydigi.data.bean.InstalledGameBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import xi.i0;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements w6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f53916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<InstalledGameBean> f53917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0<InstalledGameBean> f53918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v0<InstalledGameBean> f53919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c3 f53920e;

    public class a extends w0<InstalledGameBean> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR REPLACE INTO `installed_game` (`id`,`title`,`local_package_name`,`standard_package_name`,`thumb`,`update_time`,`game_mode`,`support_native`) VALUES (?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(i iVar, InstalledGameBean installedGameBean) {
            iVar.s0(1, installedGameBean.getId());
            if (installedGameBean.getTitle() == null) {
                iVar.l1(2);
            } else {
                iVar.D(2, installedGameBean.getTitle());
            }
            if (installedGameBean.getLocalPackageName() == null) {
                iVar.l1(3);
            } else {
                iVar.D(3, installedGameBean.getLocalPackageName());
            }
            if (installedGameBean.getStandardPackageName() == null) {
                iVar.l1(4);
            } else {
                iVar.D(4, installedGameBean.getStandardPackageName());
            }
            if (installedGameBean.getThumb() == null) {
                iVar.l1(5);
            } else {
                iVar.D(5, installedGameBean.getThumb());
            }
            iVar.s0(6, installedGameBean.getUpdateTime());
            iVar.s0(7, installedGameBean.getGameMode());
            iVar.s0(8, installedGameBean.isSupportNative() ? 1L : 0L);
        }
    }

    /* JADX INFO: renamed from: w6.b$b, reason: collision with other inner class name */
    public class C0634b extends v0<InstalledGameBean> {
        public C0634b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.v0, androidx.room.c3
        public String d() {
            return "DELETE FROM `installed_game` WHERE `local_package_name` = ?";
        }

        @Override // androidx.room.v0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(i stmt, InstalledGameBean value) {
            if (value.getLocalPackageName() == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, value.getLocalPackageName());
            }
        }
    }

    public class c extends v0<InstalledGameBean> {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.v0, androidx.room.c3
        public String d() {
            return "UPDATE OR ABORT `installed_game` SET `id` = ?,`title` = ?,`local_package_name` = ?,`standard_package_name` = ?,`thumb` = ?,`update_time` = ?,`game_mode` = ?,`support_native` = ? WHERE `local_package_name` = ?";
        }

        @Override // androidx.room.v0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(i iVar, InstalledGameBean installedGameBean) {
            iVar.s0(1, installedGameBean.getId());
            if (installedGameBean.getTitle() == null) {
                iVar.l1(2);
            } else {
                iVar.D(2, installedGameBean.getTitle());
            }
            if (installedGameBean.getLocalPackageName() == null) {
                iVar.l1(3);
            } else {
                iVar.D(3, installedGameBean.getLocalPackageName());
            }
            if (installedGameBean.getStandardPackageName() == null) {
                iVar.l1(4);
            } else {
                iVar.D(4, installedGameBean.getStandardPackageName());
            }
            if (installedGameBean.getThumb() == null) {
                iVar.l1(5);
            } else {
                iVar.D(5, installedGameBean.getThumb());
            }
            iVar.s0(6, installedGameBean.getUpdateTime());
            iVar.s0(7, installedGameBean.getGameMode());
            iVar.s0(8, installedGameBean.isSupportNative() ? 1L : 0L);
            if (installedGameBean.getLocalPackageName() == null) {
                iVar.l1(9);
            } else {
                iVar.D(9, installedGameBean.getLocalPackageName());
            }
        }
    }

    public class d extends c3 {
        public d(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM installed_game";
        }
    }

    public class e implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InstalledGameBean[] f53925a;

        public e(final InstalledGameBean[] val$users) {
            this.f53925a = val$users;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            b.this.f53916a.e();
            try {
                b.this.f53919d.j(this.f53925a);
                b.this.f53916a.K();
                return null;
            } finally {
                b.this.f53916a.k();
            }
        }
    }

    public class f implements Callable<InstalledGameBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f53927a;

        public f(final w2 val$_statement) {
            this.f53927a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InstalledGameBean call() throws Exception {
            InstalledGameBean installedGameBean = null;
            String string = null;
            Cursor cursorF = b2.c.f(b.this.f53916a, this.f53927a, false, null);
            try {
                int iE = b2.b.e(cursorF, "id");
                int iE2 = b2.b.e(cursorF, "title");
                int iE3 = b2.b.e(cursorF, "local_package_name");
                int iE4 = b2.b.e(cursorF, "standard_package_name");
                int iE5 = b2.b.e(cursorF, "thumb");
                int iE6 = b2.b.e(cursorF, "update_time");
                int iE7 = b2.b.e(cursorF, "game_mode");
                int iE8 = b2.b.e(cursorF, "support_native");
                if (cursorF.moveToFirst()) {
                    InstalledGameBean installedGameBean2 = new InstalledGameBean();
                    installedGameBean2.setId(cursorF.getLong(iE));
                    installedGameBean2.setTitle(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                    installedGameBean2.setLocalPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                    installedGameBean2.setStandardPackageName(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                    if (!cursorF.isNull(iE5)) {
                        string = cursorF.getString(iE5);
                    }
                    installedGameBean2.setThumb(string);
                    installedGameBean2.setUpdateTime(cursorF.getLong(iE6));
                    installedGameBean2.setGameMode(cursorF.getInt(iE7));
                    installedGameBean2.setSupportNative(cursorF.getInt(iE8) != 0);
                    installedGameBean = installedGameBean2;
                }
                if (installedGameBean != null) {
                    return installedGameBean;
                }
                throw new EmptyResultSetException("Query returned empty result set: " + this.f53927a.d());
            } finally {
                cursorF.close();
            }
        }

        public void finalize() {
            this.f53927a.m();
        }
    }

    public class g implements Callable<List<InstalledGameBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f53929a;

        public g(final w2 val$_statement) {
            this.f53929a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<InstalledGameBean> call() throws Exception {
            Cursor cursorF = b2.c.f(b.this.f53916a, this.f53929a, false, null);
            try {
                int iE = b2.b.e(cursorF, "id");
                int iE2 = b2.b.e(cursorF, "title");
                int iE3 = b2.b.e(cursorF, "local_package_name");
                int iE4 = b2.b.e(cursorF, "standard_package_name");
                int iE5 = b2.b.e(cursorF, "thumb");
                int iE6 = b2.b.e(cursorF, "update_time");
                int iE7 = b2.b.e(cursorF, "game_mode");
                int iE8 = b2.b.e(cursorF, "support_native");
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    InstalledGameBean installedGameBean = new InstalledGameBean();
                    installedGameBean.setId(cursorF.getLong(iE));
                    installedGameBean.setTitle(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                    installedGameBean.setLocalPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                    installedGameBean.setStandardPackageName(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                    installedGameBean.setThumb(cursorF.isNull(iE5) ? null : cursorF.getString(iE5));
                    installedGameBean.setUpdateTime(cursorF.getLong(iE6));
                    installedGameBean.setGameMode(cursorF.getInt(iE7));
                    installedGameBean.setSupportNative(cursorF.getInt(iE8) != 0);
                    arrayList.add(installedGameBean);
                }
                return arrayList;
            } finally {
                cursorF.close();
            }
        }

        public void finalize() {
            this.f53929a.m();
        }
    }

    public b(RoomDatabase __db) {
        this.f53916a = __db;
        this.f53917b = new a(__db);
        this.f53918c = new C0634b(__db);
        this.f53919d = new c(__db);
        this.f53920e = new d(__db);
    }

    public static List<Class<?>> l() {
        return Collections.emptyList();
    }

    @Override // w6.a
    public void a() {
        this.f53916a.d();
        i iVarA = this.f53920e.a();
        this.f53916a.e();
        try {
            iVarA.a0();
            this.f53916a.K();
        } finally {
            this.f53916a.k();
            this.f53920e.f(iVarA);
        }
    }

    @Override // w6.a
    public InstalledGameBean b(String str) {
        w2 w2VarF = w2.f("SELECT * FROM installed_game WHERE local_package_name = ? OR standard_package_name = ?", 2);
        if (str == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, str);
        }
        if (str == null) {
            w2VarF.l1(2);
        } else {
            w2VarF.D(2, str);
        }
        this.f53916a.d();
        InstalledGameBean installedGameBean = null;
        String string = null;
        Cursor cursorF = b2.c.f(this.f53916a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "id");
            int iE2 = b2.b.e(cursorF, "title");
            int iE3 = b2.b.e(cursorF, "local_package_name");
            int iE4 = b2.b.e(cursorF, "standard_package_name");
            int iE5 = b2.b.e(cursorF, "thumb");
            int iE6 = b2.b.e(cursorF, "update_time");
            int iE7 = b2.b.e(cursorF, "game_mode");
            int iE8 = b2.b.e(cursorF, "support_native");
            if (cursorF.moveToFirst()) {
                InstalledGameBean installedGameBean2 = new InstalledGameBean();
                installedGameBean2.setId(cursorF.getLong(iE));
                installedGameBean2.setTitle(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                installedGameBean2.setLocalPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                installedGameBean2.setStandardPackageName(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                if (!cursorF.isNull(iE5)) {
                    string = cursorF.getString(iE5);
                }
                installedGameBean2.setThumb(string);
                installedGameBean2.setUpdateTime(cursorF.getLong(iE6));
                installedGameBean2.setGameMode(cursorF.getInt(iE7));
                installedGameBean2.setSupportNative(cursorF.getInt(iE8) != 0);
                installedGameBean = installedGameBean2;
            }
            return installedGameBean;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // w6.a
    public void c(final InstalledGameBean... users) {
        this.f53916a.d();
        this.f53916a.e();
        try {
            this.f53919d.j(users);
            this.f53916a.K();
        } finally {
            this.f53916a.k();
        }
    }

    @Override // w6.a
    public InstalledGameBean d(String str) {
        w2 w2VarF = w2.f("SELECT * FROM installed_game WHERE local_package_name = ? ", 1);
        if (str == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, str);
        }
        this.f53916a.d();
        InstalledGameBean installedGameBean = null;
        String string = null;
        Cursor cursorF = b2.c.f(this.f53916a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "id");
            int iE2 = b2.b.e(cursorF, "title");
            int iE3 = b2.b.e(cursorF, "local_package_name");
            int iE4 = b2.b.e(cursorF, "standard_package_name");
            int iE5 = b2.b.e(cursorF, "thumb");
            int iE6 = b2.b.e(cursorF, "update_time");
            int iE7 = b2.b.e(cursorF, "game_mode");
            int iE8 = b2.b.e(cursorF, "support_native");
            if (cursorF.moveToFirst()) {
                InstalledGameBean installedGameBean2 = new InstalledGameBean();
                installedGameBean2.setId(cursorF.getLong(iE));
                installedGameBean2.setTitle(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                installedGameBean2.setLocalPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                installedGameBean2.setStandardPackageName(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                if (!cursorF.isNull(iE5)) {
                    string = cursorF.getString(iE5);
                }
                installedGameBean2.setThumb(string);
                installedGameBean2.setUpdateTime(cursorF.getLong(iE6));
                installedGameBean2.setGameMode(cursorF.getInt(iE7));
                installedGameBean2.setSupportNative(cursorF.getInt(iE8) != 0);
                installedGameBean = installedGameBean2;
            }
            return installedGameBean;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // w6.a
    public i0<InstalledGameBean> e(final String packageName) {
        w2 w2VarF = w2.f("SELECT * FROM installed_game WHERE local_package_name = ? ", 1);
        if (packageName == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, packageName);
        }
        return z2.g(new f(w2VarF));
    }

    @Override // w6.a
    public void f(final InstalledGameBean... users) {
        this.f53916a.d();
        this.f53916a.e();
        try {
            this.f53917b.j(users);
            this.f53916a.K();
        } finally {
            this.f53916a.k();
        }
    }

    @Override // w6.a
    public void g(final InstalledGameBean... user) {
        this.f53916a.d();
        this.f53916a.e();
        try {
            this.f53918c.j(user);
            this.f53916a.K();
        } finally {
            this.f53916a.k();
        }
    }

    @Override // w6.a
    public List<InstalledGameBean> getAll() throws Throwable {
        w2 w2Var;
        w2 w2VarF = w2.f("SELECT * FROM installed_game ORDER BY update_time desc", 0);
        this.f53916a.d();
        Cursor cursorF = b2.c.f(this.f53916a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "id");
            int iE2 = b2.b.e(cursorF, "title");
            int iE3 = b2.b.e(cursorF, "local_package_name");
            int iE4 = b2.b.e(cursorF, "standard_package_name");
            int iE5 = b2.b.e(cursorF, "thumb");
            int iE6 = b2.b.e(cursorF, "update_time");
            int iE7 = b2.b.e(cursorF, "game_mode");
            int iE8 = b2.b.e(cursorF, "support_native");
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                InstalledGameBean installedGameBean = new InstalledGameBean();
                w2Var = w2VarF;
                try {
                    installedGameBean.setId(cursorF.getLong(iE));
                    installedGameBean.setTitle(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                    installedGameBean.setLocalPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                    installedGameBean.setStandardPackageName(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                    installedGameBean.setThumb(cursorF.isNull(iE5) ? null : cursorF.getString(iE5));
                    installedGameBean.setUpdateTime(cursorF.getLong(iE6));
                    installedGameBean.setGameMode(cursorF.getInt(iE7));
                    installedGameBean.setSupportNative(cursorF.getInt(iE8) != 0);
                    arrayList.add(installedGameBean);
                    w2VarF = w2Var;
                } catch (Throwable th2) {
                    th = th2;
                    cursorF.close();
                    w2Var.m();
                    throw th;
                }
            }
            cursorF.close();
            w2VarF.m();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // w6.a
    public xi.a h(final InstalledGameBean... users) {
        return xi.a.S(new e(users));
    }

    @Override // w6.a
    public LiveData<List<InstalledGameBean>> i() {
        return this.f53916a.o().f(new String[]{"installed_game"}, false, new g(w2.f("SELECT * FROM installed_game ORDER BY update_time desc", 0)));
    }
}
