package a2;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.RoomDatabase;
import androidx.room.h1;
import androidx.room.w2;
import c2.g;
import g.n0;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class a<T> extends PositionalDataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2 f153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoomDatabase f156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h1.c f157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f159g;

    /* JADX INFO: renamed from: a2.a$a, reason: collision with other inner class name */
    public class C0008a extends h1.c {
        public C0008a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.h1.c
        public void b(@n0 Set<String> set) {
            a.this.invalidate();
        }
    }

    public a(@n0 RoomDatabase roomDatabase, @n0 g gVar, boolean z10, @n0 String... strArr) {
        this(roomDatabase, w2.i(gVar), z10, strArr);
    }

    @n0
    public abstract List<T> a(@n0 Cursor cursor);

    public int b() {
        h();
        w2 w2VarF = w2.f(this.f154b, this.f153a.c());
        w2VarF.h(this.f153a);
        Cursor cursorF = this.f156d.F(w2VarF);
        try {
            if (cursorF.moveToFirst()) {
                return cursorF.getInt(0);
            }
            return 0;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    public final w2 c(int i10, int i11) {
        w2 w2VarF = w2.f(this.f155c, this.f153a.c() + 2);
        w2VarF.h(this.f153a);
        w2VarF.s0(w2VarF.c() - 1, i11);
        w2VarF.s0(w2VarF.c(), i10);
        return w2VarF;
    }

    public boolean d() {
        h();
        this.f156d.o().l();
        return super.isInvalid();
    }

    public void e(@n0 PositionalDataSource.LoadInitialParams loadInitialParams, @n0 PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) throws Throwable {
        w2 w2VarC;
        int i10;
        w2 w2Var;
        h();
        List<T> listEmptyList = Collections.emptyList();
        this.f156d.e();
        Cursor cursorF = null;
        try {
            int iB = b();
            if (iB != 0) {
                int iComputeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, iB);
                w2VarC = c(iComputeInitialLoadPosition, computeInitialLoadSize(loadInitialParams, iComputeInitialLoadPosition, iB));
                try {
                    cursorF = this.f156d.F(w2VarC);
                    List<T> listA = a(cursorF);
                    this.f156d.K();
                    w2Var = w2VarC;
                    i10 = iComputeInitialLoadPosition;
                    listEmptyList = listA;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorF != null) {
                        cursorF.close();
                    }
                    this.f156d.k();
                    if (w2VarC != null) {
                        w2VarC.m();
                    }
                    throw th;
                }
            } else {
                i10 = 0;
                w2Var = null;
            }
            if (cursorF != null) {
                cursorF.close();
            }
            this.f156d.k();
            if (w2Var != null) {
                w2Var.m();
            }
            loadInitialCallback.onResult(listEmptyList, i10, iB);
        } catch (Throwable th3) {
            th = th3;
            w2VarC = null;
        }
    }

    @n0
    public List<T> f(int i10, int i11) {
        w2 w2VarC = c(i10, i11);
        if (!this.f158f) {
            Cursor cursorF = this.f156d.F(w2VarC);
            try {
                return a(cursorF);
            } finally {
                cursorF.close();
                w2VarC.m();
            }
        }
        this.f156d.e();
        Cursor cursorF2 = null;
        try {
            cursorF2 = this.f156d.F(w2VarC);
            List<T> listA = a(cursorF2);
            this.f156d.K();
            return listA;
        } finally {
            if (cursorF2 != null) {
                cursorF2.close();
            }
            this.f156d.k();
            w2VarC.m();
        }
    }

    public void g(@n0 PositionalDataSource.LoadRangeParams loadRangeParams, @n0 PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(f(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    public final void h() {
        if (this.f159g.compareAndSet(false, true)) {
            this.f156d.o().b(this.f157e);
        }
    }

    public a(@n0 RoomDatabase roomDatabase, @n0 g gVar, boolean z10, boolean z11, @n0 String... strArr) {
        this(roomDatabase, w2.i(gVar), z10, z11, strArr);
    }

    public a(@n0 RoomDatabase roomDatabase, @n0 w2 w2Var, boolean z10, @n0 String... strArr) {
        this(roomDatabase, w2Var, z10, true, strArr);
    }

    public a(@n0 RoomDatabase roomDatabase, @n0 w2 w2Var, boolean z10, boolean z11, @n0 String... strArr) {
        this.f159g = new AtomicBoolean(false);
        this.f156d = roomDatabase;
        this.f153a = w2Var;
        this.f158f = z10;
        this.f154b = "SELECT COUNT(*) FROM ( " + w2Var.d() + " )";
        this.f155c = "SELECT * FROM ( " + w2Var.d() + " ) LIMIT ? OFFSET ?";
        this.f157e = new C0008a(strArr);
        if (z11) {
            h();
        }
    }
}
