package androidx.room;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import c2.e;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class v2 extends e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public n0 f7529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final a f7530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final String f7531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final String f7532f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7533a;

        public a(int i10) {
            this.f7533a = i10;
        }

        public abstract void a(c2.d dVar);

        public abstract void b(c2.d dVar);

        public abstract void c(c2.d dVar);

        public abstract void d(c2.d dVar);

        public void e(c2.d dVar) {
        }

        public void f(c2.d dVar) {
        }

        @g.n0
        public b g(@g.n0 c2.d dVar) {
            h(dVar);
            return new b(true, null);
        }

        @Deprecated
        public void h(c2.d dVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public final String f7535b;

        public b(boolean z10, @g.p0 String str) {
            this.f7534a = z10;
            this.f7535b = str;
        }
    }

    public v2(@g.n0 n0 n0Var, @g.n0 a aVar, @g.n0 String str, @g.n0 String str2) {
        super(aVar.f7533a);
        this.f7529c = n0Var;
        this.f7530d = aVar;
        this.f7531e = str;
        this.f7532f = str2;
    }

    public static boolean j(c2.d dVar) {
        Cursor cursorL0 = dVar.L0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (cursorL0.moveToFirst()) {
                if (cursorL0.getInt(0) == 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            cursorL0.close();
        }
    }

    public static boolean k(c2.d dVar) {
        Cursor cursorL0 = dVar.L0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z10 = false;
            if (cursorL0.moveToFirst()) {
                if (cursorL0.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            cursorL0.close();
        }
    }

    @Override // c2.e.a
    public void b(c2.d dVar) {
        super.b(dVar);
    }

    @Override // c2.e.a
    public void d(c2.d dVar) {
        boolean zJ = j(dVar);
        this.f7530d.a(dVar);
        if (!zJ) {
            b bVarG = this.f7530d.g(dVar);
            if (!bVarG.f7534a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarG.f7535b);
            }
        }
        l(dVar);
        this.f7530d.c(dVar);
    }

    @Override // c2.e.a
    public void e(c2.d dVar, int i10, int i11) {
        g(dVar, i10, i11);
    }

    @Override // c2.e.a
    public void f(c2.d dVar) {
        super.f(dVar);
        h(dVar);
        this.f7530d.d(dVar);
        this.f7529c = null;
    }

    @Override // c2.e.a
    public void g(c2.d dVar, int i10, int i11) {
        boolean z10;
        List<z1.c> listD;
        n0 n0Var = this.f7529c;
        if (n0Var == null || (listD = n0Var.f7483d.d(i10, i11)) == null) {
            z10 = false;
        } else {
            this.f7530d.f(dVar);
            Iterator<z1.c> it2 = listD.iterator();
            while (it2.hasNext()) {
                it2.next().a(dVar);
            }
            b bVarG = this.f7530d.g(dVar);
            if (!bVarG.f7534a) {
                throw new IllegalStateException("Migration didn't properly handle: " + bVarG.f7535b);
            }
            this.f7530d.e(dVar);
            l(dVar);
            z10 = true;
        }
        if (z10) {
            return;
        }
        n0 n0Var2 = this.f7529c;
        if (n0Var2 != null && !n0Var2.a(i10, i11)) {
            this.f7530d.b(dVar);
            this.f7530d.a(dVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public final void h(c2.d dVar) {
        if (!k(dVar)) {
            b bVarG = this.f7530d.g(dVar);
            if (bVarG.f7534a) {
                this.f7530d.e(dVar);
                l(dVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarG.f7535b);
            }
        }
        Cursor cursorJ1 = dVar.j1(new c2.a(u2.f7526g));
        try {
            String string = cursorJ1.moveToFirst() ? cursorJ1.getString(0) : null;
            cursorJ1.close();
            if (!this.f7531e.equals(string) && !this.f7532f.equals(string)) {
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (Throwable th2) {
            cursorJ1.close();
            throw th2;
        }
    }

    public final void i(c2.d dVar) {
        dVar.C(u2.f7525f);
    }

    public final void l(c2.d dVar) {
        i(dVar);
        dVar.C(u2.a(this.f7531e));
    }

    public v2(@g.n0 n0 n0Var, @g.n0 a aVar, @g.n0 String str) {
        this(n0Var, aVar, "", str);
    }
}
