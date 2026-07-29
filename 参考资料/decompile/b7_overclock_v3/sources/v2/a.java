package v2;

import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.o;
import g.j1;
import g.n0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.c f52555a = new l2.c();

    /* JADX INFO: renamed from: v2.a$a, reason: collision with other inner class name */
    public class C0612a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UUID f52557c;

        public C0612a(final l2.i val$workManagerImpl, final UUID val$id) {
            this.f52556b = val$workManagerImpl;
            this.f52557c = val$id;
        }

        @Override // v2.a
        @j1
        public void i() {
            WorkDatabase workDatabaseM = this.f52556b.M();
            workDatabaseM.e();
            try {
                a(this.f52556b, this.f52557c.toString());
                workDatabaseM.K();
                workDatabaseM.k();
                h(this.f52556b);
            } catch (Throwable th2) {
                workDatabaseM.k();
                throw th2;
            }
        }
    }

    public class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f52559c;

        public b(final l2.i val$workManagerImpl, final String val$tag) {
            this.f52558b = val$workManagerImpl;
            this.f52559c = val$tag;
        }

        @Override // v2.a
        @j1
        public void i() {
            WorkDatabase workDatabaseM = this.f52558b.M();
            workDatabaseM.e();
            try {
                Iterator<String> it2 = workDatabaseM.W().z(this.f52559c).iterator();
                while (it2.hasNext()) {
                    a(this.f52558b, it2.next());
                }
                workDatabaseM.K();
                workDatabaseM.k();
                h(this.f52558b);
            } catch (Throwable th2) {
                workDatabaseM.k();
                throw th2;
            }
        }
    }

    public class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f52561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f52562d;

        public c(final l2.i val$workManagerImpl, final String val$name, final boolean val$allowReschedule) {
            this.f52560b = val$workManagerImpl;
            this.f52561c = val$name;
            this.f52562d = val$allowReschedule;
        }

        @Override // v2.a
        @j1
        public void i() {
            WorkDatabase workDatabaseM = this.f52560b.M();
            workDatabaseM.e();
            try {
                Iterator<String> it2 = workDatabaseM.W().r(this.f52561c).iterator();
                while (it2.hasNext()) {
                    a(this.f52560b, it2.next());
                }
                workDatabaseM.K();
                workDatabaseM.k();
                if (this.f52562d) {
                    h(this.f52560b);
                }
            } catch (Throwable th2) {
                workDatabaseM.k();
                throw th2;
            }
        }
    }

    public class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52563b;

        public d(final l2.i val$workManagerImpl) {
            this.f52563b = val$workManagerImpl;
        }

        @Override // v2.a
        @j1
        public void i() {
            WorkDatabase workDatabaseM = this.f52563b.M();
            workDatabaseM.e();
            try {
                Iterator<String> it2 = workDatabaseM.W().p().iterator();
                while (it2.hasNext()) {
                    a(this.f52563b, it2.next());
                }
                new f(this.f52563b.M()).e(System.currentTimeMillis());
                workDatabaseM.K();
            } finally {
                workDatabaseM.k();
            }
        }
    }

    public static a b(@n0 final l2.i workManagerImpl) {
        return new d(workManagerImpl);
    }

    public static a c(@n0 final UUID id2, @n0 final l2.i workManagerImpl) {
        return new C0612a(workManagerImpl, id2);
    }

    public static a d(@n0 final String name, @n0 final l2.i workManagerImpl, final boolean allowReschedule) {
        return new c(workManagerImpl, name, allowReschedule);
    }

    public static a e(@n0 final String tag, @n0 final l2.i workManagerImpl) {
        return new b(workManagerImpl, tag);
    }

    public void a(l2.i workManagerImpl, String workSpecId) {
        g(workManagerImpl.M(), workSpecId);
        workManagerImpl.J().m(workSpecId);
        Iterator<l2.e> it2 = workManagerImpl.L().iterator();
        while (it2.hasNext()) {
            it2.next().d(workSpecId);
        }
    }

    public androidx.work.o f() {
        return this.f52555a;
    }

    public final void g(WorkDatabase workDatabase, String workSpecId) {
        u2.s sVarW = workDatabase.W();
        u2.b bVarN = workDatabase.N();
        LinkedList linkedList = new LinkedList();
        linkedList.add(workSpecId);
        while (!linkedList.isEmpty()) {
            String str = (String) linkedList.remove();
            WorkInfo.State stateT = sVarW.t(str);
            if (stateT != WorkInfo.State.SUCCEEDED && stateT != WorkInfo.State.FAILED) {
                sVarW.b(WorkInfo.State.CANCELLED, str);
            }
            linkedList.addAll(bVarN.a(str));
        }
    }

    public void h(l2.i workManagerImpl) {
        l2.f.b(workManagerImpl.F(), workManagerImpl.M(), workManagerImpl.L());
    }

    public abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        try {
            i();
            this.f52555a.a(androidx.work.o.f8746a);
        } catch (Throwable th2) {
            this.f52555a.a(new o.b.a(th2));
        }
    }
}
