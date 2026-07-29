package w6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.c3;
import androidx.room.v0;
import androidx.room.w0;
import androidx.room.w2;
import c2.i;
import com.flydigi.data.bean.SupportedGameBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f53941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<SupportedGameBean> f53942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v6.a f53943c = new v6.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v0<SupportedGameBean> f53944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c3 f53945e;

    public class a extends w0<SupportedGameBean> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR REPLACE INTO `supported_game` (`id`,`game_name`,`package_name`,`thumb`,`pattern`,`support_native`) VALUES (?,?,?,?,?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(i iVar, SupportedGameBean supportedGameBean) {
            iVar.s0(1, supportedGameBean.getId());
            if (supportedGameBean.getGameName() == null) {
                iVar.l1(2);
            } else {
                iVar.D(2, supportedGameBean.getGameName());
            }
            if (supportedGameBean.getPackageName() == null) {
                iVar.l1(3);
            } else {
                iVar.D(3, supportedGameBean.getPackageName());
            }
            if (supportedGameBean.getThumb() == null) {
                iVar.l1(4);
            } else {
                iVar.D(4, supportedGameBean.getThumb());
            }
            String strB = f.this.f53943c.b(supportedGameBean.getPattern());
            if (strB == null) {
                iVar.l1(5);
            } else {
                iVar.D(5, strB);
            }
            iVar.s0(6, supportedGameBean.isSupportNative() ? 1L : 0L);
        }
    }

    public class b extends v0<SupportedGameBean> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.v0, androidx.room.c3
        public String d() {
            return "DELETE FROM `supported_game` WHERE `id` = ?";
        }

        @Override // androidx.room.v0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(i stmt, SupportedGameBean value) {
            stmt.s0(1, value.getId());
        }
    }

    public class c extends c3 {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM supported_game";
        }
    }

    public class d implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f53949a;

        public d(final List val$users) {
            this.f53949a = val$users;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            f.this.f53941a.e();
            try {
                f.this.f53942b.h(this.f53949a);
                f.this.f53941a.K();
                return null;
            } finally {
                f.this.f53941a.k();
            }
        }
    }

    public f(RoomDatabase __db) {
        this.f53941a = __db;
        this.f53942b = new a(__db);
        this.f53944d = new b(__db);
        this.f53945e = new c(__db);
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    @Override // w6.e
    public void a() {
        this.f53941a.d();
        i iVarA = this.f53945e.a();
        this.f53941a.e();
        try {
            iVarA.a0();
            this.f53941a.K();
        } finally {
            this.f53941a.k();
            this.f53945e.f(iVarA);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // w6.e
    public SupportedGameBean b(String str) {
        boolean z10 = true;
        w2 w2VarF = w2.f("SELECT * FROM supported_game WHERE package_name = ?", 1);
        if (str == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, str);
        }
        this.f53941a.d();
        SupportedGameBean supportedGameBean = null;
        String string = null;
        Cursor cursorF = b2.c.f(this.f53941a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "id");
            int iE2 = b2.b.e(cursorF, "game_name");
            int iE3 = b2.b.e(cursorF, "package_name");
            int iE4 = b2.b.e(cursorF, "thumb");
            int iE5 = b2.b.e(cursorF, "pattern");
            int iE6 = b2.b.e(cursorF, "support_native");
            if (cursorF.moveToFirst()) {
                SupportedGameBean supportedGameBean2 = new SupportedGameBean();
                supportedGameBean2.setId(cursorF.getLong(iE));
                supportedGameBean2.setGameName(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                supportedGameBean2.setPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                supportedGameBean2.setThumb(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                if (!cursorF.isNull(iE5)) {
                    string = cursorF.getString(iE5);
                }
                supportedGameBean2.setPattern(this.f53943c.a(string));
                if (cursorF.getInt(iE6) == 0) {
                    z10 = false;
                }
                supportedGameBean2.setSupportNative(z10);
                supportedGameBean = supportedGameBean2;
            }
            return supportedGameBean;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // w6.e
    public xi.a c(final List<? extends SupportedGameBean> users) {
        return xi.a.S(new d(users));
    }

    @Override // w6.e
    public void d(final SupportedGameBean... user) {
        this.f53941a.d();
        this.f53941a.e();
        try {
            this.f53944d.j(user);
            this.f53941a.K();
        } finally {
            this.f53941a.k();
        }
    }

    @Override // w6.e
    public void e(final SupportedGameBean... users) {
        this.f53941a.d();
        this.f53941a.e();
        try {
            this.f53942b.j(users);
            this.f53941a.K();
        } finally {
            this.f53941a.k();
        }
    }

    @Override // w6.e
    public void f(final List<? extends SupportedGameBean> users) {
        this.f53941a.d();
        this.f53941a.e();
        try {
            this.f53942b.h(users);
            this.f53941a.K();
        } finally {
            this.f53941a.k();
        }
    }

    @Override // w6.e
    public List<SupportedGameBean> getAll() {
        w2 w2VarF = w2.f("SELECT * FROM supported_game", 0);
        this.f53941a.d();
        Cursor cursorF = b2.c.f(this.f53941a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "id");
            int iE2 = b2.b.e(cursorF, "game_name");
            int iE3 = b2.b.e(cursorF, "package_name");
            int iE4 = b2.b.e(cursorF, "thumb");
            int iE5 = b2.b.e(cursorF, "pattern");
            int iE6 = b2.b.e(cursorF, "support_native");
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                SupportedGameBean supportedGameBean = new SupportedGameBean();
                supportedGameBean.setId(cursorF.getLong(iE));
                supportedGameBean.setGameName(cursorF.isNull(iE2) ? null : cursorF.getString(iE2));
                supportedGameBean.setPackageName(cursorF.isNull(iE3) ? null : cursorF.getString(iE3));
                supportedGameBean.setThumb(cursorF.isNull(iE4) ? null : cursorF.getString(iE4));
                supportedGameBean.setPattern(this.f53943c.a(cursorF.isNull(iE5) ? null : cursorF.getString(iE5)));
                supportedGameBean.setSupportNative(cursorF.getInt(iE6) != 0);
                arrayList.add(supportedGameBean);
            }
            return arrayList;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }
}
