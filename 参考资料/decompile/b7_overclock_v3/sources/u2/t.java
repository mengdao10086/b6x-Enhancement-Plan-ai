package u2;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.c3;
import androidx.room.w0;
import androidx.room.w2;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<r> f51868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f51869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c3 f51870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c3 f51871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c3 f51872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c3 f51873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c3 f51874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c3 f51875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c3 f51876j;

    public class a implements Callable<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f51877a;

        public a(final w2 val$_statement) {
            this.f51877a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> call() throws Exception {
            t.this.f51867a.e();
            try {
                Cursor cursorF = b2.c.f(t.this.f51867a, this.f51877a, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorF.getCount());
                    while (cursorF.moveToNext()) {
                        arrayList.add(cursorF.getString(0));
                    }
                    t.this.f51867a.K();
                    return arrayList;
                } finally {
                    cursorF.close();
                }
            } finally {
                t.this.f51867a.k();
            }
        }

        public void finalize() {
            this.f51877a.m();
        }
    }

    public class b implements Callable<List<r.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f51879a;

        public b(final w2 val$_statement) {
            this.f51879a = val$_statement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<r.c> call() throws Exception {
            t.this.f51867a.e();
            try {
                Cursor cursorF = b2.c.f(t.this.f51867a, this.f51879a, true, null);
                try {
                    int iE = b2.b.e(cursorF, "id");
                    int iE2 = b2.b.e(cursorF, "state");
                    int iE3 = b2.b.e(cursorF, "output");
                    int iE4 = b2.b.e(cursorF, "run_attempt_count");
                    androidx.collection.a aVar = new androidx.collection.a();
                    androidx.collection.a aVar2 = new androidx.collection.a();
                    while (cursorF.moveToNext()) {
                        if (!cursorF.isNull(iE)) {
                            String string = cursorF.getString(iE);
                            if (((ArrayList) aVar.get(string)) == null) {
                                aVar.put(string, new ArrayList());
                            }
                        }
                        if (!cursorF.isNull(iE)) {
                            String string2 = cursorF.getString(iE);
                            if (((ArrayList) aVar2.get(string2)) == null) {
                                aVar2.put(string2, new ArrayList());
                            }
                        }
                    }
                    cursorF.moveToPosition(-1);
                    t.this.J(aVar);
                    t.this.I(aVar2);
                    ArrayList arrayList = new ArrayList(cursorF.getCount());
                    while (cursorF.moveToNext()) {
                        ArrayList arrayList2 = !cursorF.isNull(iE) ? (ArrayList) aVar.get(cursorF.getString(iE)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !cursorF.isNull(iE) ? (ArrayList) aVar2.get(cursorF.getString(iE)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        r.c cVar = new r.c();
                        cVar.f51861a = cursorF.getString(iE);
                        cVar.f51862b = x.g(cursorF.getInt(iE2));
                        cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                        cVar.f51864d = cursorF.getInt(iE4);
                        cVar.f51865e = arrayList2;
                        cVar.f51866f = arrayList3;
                        arrayList.add(cVar);
                    }
                    t.this.f51867a.K();
                    return arrayList;
                } finally {
                    cursorF.close();
                }
            } finally {
                t.this.f51867a.k();
            }
        }

        public void finalize() {
            this.f51879a.m();
        }
    }

    public class c implements Callable<List<r.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f51881a;

        public c(final w2 val$_statement) {
            this.f51881a = val$_statement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<r.c> call() throws Exception {
            t.this.f51867a.e();
            try {
                Cursor cursorF = b2.c.f(t.this.f51867a, this.f51881a, true, null);
                try {
                    int iE = b2.b.e(cursorF, "id");
                    int iE2 = b2.b.e(cursorF, "state");
                    int iE3 = b2.b.e(cursorF, "output");
                    int iE4 = b2.b.e(cursorF, "run_attempt_count");
                    androidx.collection.a aVar = new androidx.collection.a();
                    androidx.collection.a aVar2 = new androidx.collection.a();
                    while (cursorF.moveToNext()) {
                        if (!cursorF.isNull(iE)) {
                            String string = cursorF.getString(iE);
                            if (((ArrayList) aVar.get(string)) == null) {
                                aVar.put(string, new ArrayList());
                            }
                        }
                        if (!cursorF.isNull(iE)) {
                            String string2 = cursorF.getString(iE);
                            if (((ArrayList) aVar2.get(string2)) == null) {
                                aVar2.put(string2, new ArrayList());
                            }
                        }
                    }
                    cursorF.moveToPosition(-1);
                    t.this.J(aVar);
                    t.this.I(aVar2);
                    ArrayList arrayList = new ArrayList(cursorF.getCount());
                    while (cursorF.moveToNext()) {
                        ArrayList arrayList2 = !cursorF.isNull(iE) ? (ArrayList) aVar.get(cursorF.getString(iE)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !cursorF.isNull(iE) ? (ArrayList) aVar2.get(cursorF.getString(iE)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        r.c cVar = new r.c();
                        cVar.f51861a = cursorF.getString(iE);
                        cVar.f51862b = x.g(cursorF.getInt(iE2));
                        cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                        cVar.f51864d = cursorF.getInt(iE4);
                        cVar.f51865e = arrayList2;
                        cVar.f51866f = arrayList3;
                        arrayList.add(cVar);
                    }
                    t.this.f51867a.K();
                    return arrayList;
                } finally {
                    cursorF.close();
                }
            } finally {
                t.this.f51867a.k();
            }
        }

        public void finalize() {
            this.f51881a.m();
        }
    }

    public class d implements Callable<List<r.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f51883a;

        public d(final w2 val$_statement) {
            this.f51883a = val$_statement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<r.c> call() throws Exception {
            t.this.f51867a.e();
            try {
                Cursor cursorF = b2.c.f(t.this.f51867a, this.f51883a, true, null);
                try {
                    int iE = b2.b.e(cursorF, "id");
                    int iE2 = b2.b.e(cursorF, "state");
                    int iE3 = b2.b.e(cursorF, "output");
                    int iE4 = b2.b.e(cursorF, "run_attempt_count");
                    androidx.collection.a aVar = new androidx.collection.a();
                    androidx.collection.a aVar2 = new androidx.collection.a();
                    while (cursorF.moveToNext()) {
                        if (!cursorF.isNull(iE)) {
                            String string = cursorF.getString(iE);
                            if (((ArrayList) aVar.get(string)) == null) {
                                aVar.put(string, new ArrayList());
                            }
                        }
                        if (!cursorF.isNull(iE)) {
                            String string2 = cursorF.getString(iE);
                            if (((ArrayList) aVar2.get(string2)) == null) {
                                aVar2.put(string2, new ArrayList());
                            }
                        }
                    }
                    cursorF.moveToPosition(-1);
                    t.this.J(aVar);
                    t.this.I(aVar2);
                    ArrayList arrayList = new ArrayList(cursorF.getCount());
                    while (cursorF.moveToNext()) {
                        ArrayList arrayList2 = !cursorF.isNull(iE) ? (ArrayList) aVar.get(cursorF.getString(iE)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !cursorF.isNull(iE) ? (ArrayList) aVar2.get(cursorF.getString(iE)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        r.c cVar = new r.c();
                        cVar.f51861a = cursorF.getString(iE);
                        cVar.f51862b = x.g(cursorF.getInt(iE2));
                        cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                        cVar.f51864d = cursorF.getInt(iE4);
                        cVar.f51865e = arrayList2;
                        cVar.f51866f = arrayList3;
                        arrayList.add(cVar);
                    }
                    t.this.f51867a.K();
                    return arrayList;
                } finally {
                    cursorF.close();
                }
            } finally {
                t.this.f51867a.k();
            }
        }

        public void finalize() {
            this.f51883a.m();
        }
    }

    public class e implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f51885a;

        public e(final w2 val$_statement) {
            this.f51885a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() throws Exception {
            Long lValueOf = null;
            Cursor cursorF = b2.c.f(t.this.f51867a, this.f51885a, false, null);
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
            this.f51885a.m();
        }
    }

    public class f extends w0<r> {
        public f(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(c2.i iVar, r rVar) throws Throwable {
            String str = rVar.f51841a;
            if (str == null) {
                iVar.l1(1);
            } else {
                iVar.D(1, str);
            }
            iVar.s0(2, x.j(rVar.f51842b));
            String str2 = rVar.f51843c;
            if (str2 == null) {
                iVar.l1(3);
            } else {
                iVar.D(3, str2);
            }
            String str3 = rVar.f51844d;
            if (str3 == null) {
                iVar.l1(4);
            } else {
                iVar.D(4, str3);
            }
            byte[] bArrF = androidx.work.d.F(rVar.f51845e);
            if (bArrF == null) {
                iVar.l1(5);
            } else {
                iVar.E0(5, bArrF);
            }
            byte[] bArrF2 = androidx.work.d.F(rVar.f51846f);
            if (bArrF2 == null) {
                iVar.l1(6);
            } else {
                iVar.E0(6, bArrF2);
            }
            iVar.s0(7, rVar.f51847g);
            iVar.s0(8, rVar.f51848h);
            iVar.s0(9, rVar.f51849i);
            iVar.s0(10, rVar.f51851k);
            iVar.s0(11, x.a(rVar.f51852l));
            iVar.s0(12, rVar.f51853m);
            iVar.s0(13, rVar.f51854n);
            iVar.s0(14, rVar.f51855o);
            iVar.s0(15, rVar.f51856p);
            iVar.s0(16, rVar.f51857q ? 1L : 0L);
            iVar.s0(17, x.i(rVar.f51858r));
            androidx.work.b bVar = rVar.f51850j;
            if (bVar == null) {
                iVar.l1(18);
                iVar.l1(19);
                iVar.l1(20);
                iVar.l1(21);
                iVar.l1(22);
                iVar.l1(23);
                iVar.l1(24);
                iVar.l1(25);
                return;
            }
            iVar.s0(18, x.h(bVar.b()));
            iVar.s0(19, bVar.g() ? 1L : 0L);
            iVar.s0(20, bVar.h() ? 1L : 0L);
            iVar.s0(21, bVar.f() ? 1L : 0L);
            iVar.s0(22, bVar.i() ? 1L : 0L);
            iVar.s0(23, bVar.c());
            iVar.s0(24, bVar.d());
            byte[] bArrC = x.c(bVar.a());
            if (bArrC == null) {
                iVar.l1(25);
            } else {
                iVar.E0(25, bArrC);
            }
        }
    }

    public class g extends c3 {
        public g(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class h extends c3 {
        public h(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class i extends c3 {
        public i(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class j extends c3 {
        public j(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class k extends c3 {
        public k(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class l extends c3 {
        public l(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class m extends c3 {
        public m(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class n extends c3 {
        public n(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public t(RoomDatabase __db) {
        this.f51867a = __db;
        this.f51868b = new f(__db);
        this.f51869c = new g(__db);
        this.f51870d = new h(__db);
        this.f51871e = new i(__db);
        this.f51872f = new j(__db);
        this.f51873g = new k(__db);
        this.f51874h = new l(__db);
        this.f51875i = new m(__db);
        this.f51876j = new n(__db);
    }

    @Override // u2.s
    public List<androidx.work.d> A(final String id2) {
        w2 w2VarF = w2.f("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                arrayList.add(androidx.work.d.m(cursorF.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.s
    public int B(final String id2) {
        this.f51867a.d();
        c2.i iVarA = this.f51872f.a();
        if (id2 == null) {
            iVarA.l1(1);
        } else {
            iVarA.D(1, id2);
        }
        this.f51867a.e();
        try {
            int iA0 = iVarA.a0();
            this.f51867a.K();
            return iA0;
        } finally {
            this.f51867a.k();
            this.f51872f.f(iVarA);
        }
    }

    @Override // u2.s
    public void C(final String id2, final long periodStartTime) {
        this.f51867a.d();
        c2.i iVarA = this.f51871e.a();
        iVarA.s0(1, periodStartTime);
        if (id2 == null) {
            iVarA.l1(2);
        } else {
            iVarA.D(2, id2);
        }
        this.f51867a.e();
        try {
            iVarA.a0();
            this.f51867a.K();
        } finally {
            this.f51867a.k();
            this.f51871e.f(iVarA);
        }
    }

    @Override // u2.s
    public List<r.c> D(final String name) {
        w2 w2VarF = w2.f("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, name);
        }
        this.f51867a.d();
        this.f51867a.e();
        try {
            Cursor cursorF = b2.c.f(this.f51867a, w2VarF, true, null);
            try {
                int iE = b2.b.e(cursorF, "id");
                int iE2 = b2.b.e(cursorF, "state");
                int iE3 = b2.b.e(cursorF, "output");
                int iE4 = b2.b.e(cursorF, "run_attempt_count");
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorF.moveToNext()) {
                    if (!cursorF.isNull(iE)) {
                        String string = cursorF.getString(iE);
                        if (aVar.get(string) == null) {
                            aVar.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorF.isNull(iE)) {
                        String string2 = cursorF.getString(iE);
                        if (aVar2.get(string2) == null) {
                            aVar2.put(string2, new ArrayList<>());
                        }
                    }
                }
                cursorF.moveToPosition(-1);
                J(aVar);
                I(aVar2);
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    ArrayList<String> arrayList2 = !cursorF.isNull(iE) ? aVar.get(cursorF.getString(iE)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<androidx.work.d> arrayList3 = !cursorF.isNull(iE) ? aVar2.get(cursorF.getString(iE)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    r.c cVar = new r.c();
                    cVar.f51861a = cursorF.getString(iE);
                    cVar.f51862b = x.g(cursorF.getInt(iE2));
                    cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                    cVar.f51864d = cursorF.getInt(iE4);
                    cVar.f51865e = arrayList2;
                    cVar.f51866f = arrayList3;
                    arrayList.add(cVar);
                }
                this.f51867a.K();
                return arrayList;
            } finally {
                cursorF.close();
                w2VarF.m();
            }
        } finally {
            this.f51867a.k();
        }
    }

    @Override // u2.s
    public List<r.c> E(final List<String> ids) {
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = ids.size();
        b2.g.a(sbC, size);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size + 0);
        int i10 = 1;
        for (String str : ids) {
            if (str == null) {
                w2VarF.l1(i10);
            } else {
                w2VarF.D(i10, str);
            }
            i10++;
        }
        this.f51867a.d();
        this.f51867a.e();
        try {
            Cursor cursorF = b2.c.f(this.f51867a, w2VarF, true, null);
            try {
                int iE = b2.b.e(cursorF, "id");
                int iE2 = b2.b.e(cursorF, "state");
                int iE3 = b2.b.e(cursorF, "output");
                int iE4 = b2.b.e(cursorF, "run_attempt_count");
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorF.moveToNext()) {
                    if (!cursorF.isNull(iE)) {
                        String string = cursorF.getString(iE);
                        if (aVar.get(string) == null) {
                            aVar.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorF.isNull(iE)) {
                        String string2 = cursorF.getString(iE);
                        if (aVar2.get(string2) == null) {
                            aVar2.put(string2, new ArrayList<>());
                        }
                    }
                }
                cursorF.moveToPosition(-1);
                J(aVar);
                I(aVar2);
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    ArrayList<String> arrayList2 = !cursorF.isNull(iE) ? aVar.get(cursorF.getString(iE)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<androidx.work.d> arrayList3 = !cursorF.isNull(iE) ? aVar2.get(cursorF.getString(iE)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    r.c cVar = new r.c();
                    cVar.f51861a = cursorF.getString(iE);
                    cVar.f51862b = x.g(cursorF.getInt(iE2));
                    cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                    cVar.f51864d = cursorF.getInt(iE4);
                    cVar.f51865e = arrayList2;
                    cVar.f51866f = arrayList3;
                    arrayList.add(cVar);
                }
                this.f51867a.K();
                return arrayList;
            } finally {
                cursorF.close();
                w2VarF.m();
            }
        } finally {
            this.f51867a.k();
        }
    }

    @Override // u2.s
    public List<r> F(final int maxLimit) throws Throwable {
        w2 w2Var;
        w2 w2VarF = w2.f("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        w2VarF.s0(1, maxLimit);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "required_network_type");
            int iE2 = b2.b.e(cursorF, "requires_charging");
            int iE3 = b2.b.e(cursorF, "requires_device_idle");
            int iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            int iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            int iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            int iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            int iE8 = b2.b.e(cursorF, "content_uri_triggers");
            int iE9 = b2.b.e(cursorF, "id");
            int iE10 = b2.b.e(cursorF, "state");
            int iE11 = b2.b.e(cursorF, "worker_class_name");
            int iE12 = b2.b.e(cursorF, "input_merger_class_name");
            int iE13 = b2.b.e(cursorF, "input");
            int iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
            try {
                int iE15 = b2.b.e(cursorF, "initial_delay");
                int iE16 = b2.b.e(cursorF, "interval_duration");
                int iE17 = b2.b.e(cursorF, "flex_duration");
                int iE18 = b2.b.e(cursorF, "run_attempt_count");
                int iE19 = b2.b.e(cursorF, "backoff_policy");
                int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
                int iE21 = b2.b.e(cursorF, "period_start_time");
                int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
                int iE23 = b2.b.e(cursorF, "schedule_requested_at");
                int iE24 = b2.b.e(cursorF, "run_in_foreground");
                int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
                int i10 = iE14;
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    String string = cursorF.getString(iE9);
                    int i11 = iE9;
                    String string2 = cursorF.getString(iE11);
                    int i12 = iE11;
                    androidx.work.b bVar = new androidx.work.b();
                    int i13 = iE;
                    bVar.k(x.e(cursorF.getInt(iE)));
                    bVar.m(cursorF.getInt(iE2) != 0);
                    bVar.n(cursorF.getInt(iE3) != 0);
                    bVar.l(cursorF.getInt(iE4) != 0);
                    bVar.o(cursorF.getInt(iE5) != 0);
                    int i14 = iE2;
                    int i15 = iE3;
                    bVar.p(cursorF.getLong(iE6));
                    bVar.q(cursorF.getLong(iE7));
                    bVar.j(x.b(cursorF.getBlob(iE8)));
                    r rVar = new r(string, string2);
                    rVar.f51842b = x.g(cursorF.getInt(iE10));
                    rVar.f51844d = cursorF.getString(iE12);
                    rVar.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                    int i16 = i10;
                    rVar.f51846f = androidx.work.d.m(cursorF.getBlob(i16));
                    i10 = i16;
                    int i17 = iE15;
                    rVar.f51847g = cursorF.getLong(i17);
                    int i18 = iE12;
                    int i19 = iE16;
                    rVar.f51848h = cursorF.getLong(i19);
                    int i20 = iE4;
                    int i21 = iE17;
                    rVar.f51849i = cursorF.getLong(i21);
                    int i22 = iE18;
                    rVar.f51851k = cursorF.getInt(i22);
                    int i23 = iE19;
                    rVar.f51852l = x.d(cursorF.getInt(i23));
                    iE17 = i21;
                    int i24 = iE20;
                    rVar.f51853m = cursorF.getLong(i24);
                    int i25 = iE21;
                    rVar.f51854n = cursorF.getLong(i25);
                    iE21 = i25;
                    int i26 = iE22;
                    rVar.f51855o = cursorF.getLong(i26);
                    int i27 = iE23;
                    rVar.f51856p = cursorF.getLong(i27);
                    int i28 = iE24;
                    rVar.f51857q = cursorF.getInt(i28) != 0;
                    int i29 = iE25;
                    rVar.f51858r = x.f(cursorF.getInt(i29));
                    rVar.f51850j = bVar;
                    arrayList.add(rVar);
                    iE25 = i29;
                    iE2 = i14;
                    iE12 = i18;
                    iE15 = i17;
                    iE16 = i19;
                    iE18 = i22;
                    iE23 = i27;
                    iE9 = i11;
                    iE11 = i12;
                    iE = i13;
                    iE24 = i28;
                    iE22 = i26;
                    iE3 = i15;
                    iE20 = i24;
                    iE4 = i20;
                    iE19 = i23;
                }
                cursorF.close();
                w2Var.m();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorF.close();
                w2Var.m();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // u2.s
    public List<String> G() {
        w2 w2VarF = w2.f("SELECT id FROM workspec", 0);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
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

    @Override // u2.s
    public int H() {
        this.f51867a.d();
        c2.i iVarA = this.f51875i.a();
        this.f51867a.e();
        try {
            int iA0 = iVarA.a0();
            this.f51867a.K();
            return iA0;
        } finally {
            this.f51867a.k();
            this.f51875i.f(iVarA);
        }
    }

    public final void I(final androidx.collection.a<String, ArrayList<androidx.work.d>> _map) {
        ArrayList<androidx.work.d> arrayList;
        int i10;
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            androidx.collection.a<String, ArrayList<androidx.work.d>> aVar = new androidx.collection.a<>(999);
            int size = _map.size();
            int i11 = 0;
            loop0: while (true) {
                i10 = 0;
                while (i11 < size) {
                    aVar.put(_map.k(i11), _map.o(i11));
                    i11++;
                    i10++;
                    if (i10 == 999) {
                        break;
                    }
                }
                I(aVar);
                aVar = new androidx.collection.a<>(999);
            }
            if (i10 > 0) {
                I(aVar);
                return;
            }
            return;
        }
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        b2.g.a(sbC, size2);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size2 + 0);
        int i12 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                w2VarF.l1(i12);
            } else {
                w2VarF.D(i12, str);
            }
            i12++;
        }
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iD = b2.b.d(cursorF, "work_spec_id");
            if (iD == -1) {
                return;
            }
            while (cursorF.moveToNext()) {
                if (!cursorF.isNull(iD) && (arrayList = _map.get(cursorF.getString(iD))) != null) {
                    arrayList.add(androidx.work.d.m(cursorF.getBlob(0)));
                }
            }
        } finally {
            cursorF.close();
        }
    }

    public final void J(final androidx.collection.a<String, ArrayList<String>> _map) {
        ArrayList<String> arrayList;
        int i10;
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>(999);
            int size = _map.size();
            int i11 = 0;
            loop0: while (true) {
                i10 = 0;
                while (i11 < size) {
                    aVar.put(_map.k(i11), _map.o(i11));
                    i11++;
                    i10++;
                    if (i10 == 999) {
                        break;
                    }
                }
                J(aVar);
                aVar = new androidx.collection.a<>(999);
            }
            if (i10 > 0) {
                J(aVar);
                return;
            }
            return;
        }
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        b2.g.a(sbC, size2);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size2 + 0);
        int i12 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                w2VarF.l1(i12);
            } else {
                w2VarF.D(i12, str);
            }
            i12++;
        }
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iD = b2.b.d(cursorF, "work_spec_id");
            if (iD == -1) {
                return;
            }
            while (cursorF.moveToNext()) {
                if (!cursorF.isNull(iD) && (arrayList = _map.get(cursorF.getString(iD))) != null) {
                    arrayList.add(cursorF.getString(0));
                }
            }
        } finally {
            cursorF.close();
        }
    }

    @Override // u2.s
    public void a(final String id2) {
        this.f51867a.d();
        c2.i iVarA = this.f51869c.a();
        if (id2 == null) {
            iVarA.l1(1);
        } else {
            iVarA.D(1, id2);
        }
        this.f51867a.e();
        try {
            iVarA.a0();
            this.f51867a.K();
        } finally {
            this.f51867a.k();
            this.f51869c.f(iVarA);
        }
    }

    @Override // u2.s
    public int b(final WorkInfo.State state, final String... ids) {
        this.f51867a.d();
        StringBuilder sbC = b2.g.c();
        sbC.append("UPDATE workspec SET state=");
        sbC.append("?");
        sbC.append(" WHERE id IN (");
        b2.g.a(sbC, ids.length);
        sbC.append(ee.a.f26979d);
        c2.i iVarH = this.f51867a.h(sbC.toString());
        iVarH.s0(1, x.j(state));
        int i10 = 2;
        for (String str : ids) {
            if (str == null) {
                iVarH.l1(i10);
            } else {
                iVarH.D(i10, str);
            }
            i10++;
        }
        this.f51867a.e();
        try {
            int iA0 = iVarH.a0();
            this.f51867a.K();
            return iA0;
        } finally {
            this.f51867a.k();
        }
    }

    @Override // u2.s
    public void c() {
        this.f51867a.d();
        c2.i iVarA = this.f51876j.a();
        this.f51867a.e();
        try {
            iVarA.a0();
            this.f51867a.K();
        } finally {
            this.f51867a.k();
            this.f51876j.f(iVarA);
        }
    }

    @Override // u2.s
    public int d(final String id2, final long startTime) {
        this.f51867a.d();
        c2.i iVarA = this.f51874h.a();
        iVarA.s0(1, startTime);
        if (id2 == null) {
            iVarA.l1(2);
        } else {
            iVarA.D(2, id2);
        }
        this.f51867a.e();
        try {
            int iA0 = iVarA.a0();
            this.f51867a.K();
            return iA0;
        } finally {
            this.f51867a.k();
            this.f51874h.f(iVarA);
        }
    }

    @Override // u2.s
    public List<r.b> e(final String name) {
        w2 w2VarF = w2.f("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, name);
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "id");
            int iE2 = b2.b.e(cursorF, "state");
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                r.b bVar = new r.b();
                bVar.f51859a = cursorF.getString(iE);
                bVar.f51860b = x.g(cursorF.getInt(iE2));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.s
    public List<r> f(final long startingAt) throws Throwable {
        w2 w2Var;
        w2 w2VarF = w2.f("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        w2VarF.s0(1, startingAt);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "required_network_type");
            int iE2 = b2.b.e(cursorF, "requires_charging");
            int iE3 = b2.b.e(cursorF, "requires_device_idle");
            int iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            int iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            int iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            int iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            int iE8 = b2.b.e(cursorF, "content_uri_triggers");
            int iE9 = b2.b.e(cursorF, "id");
            int iE10 = b2.b.e(cursorF, "state");
            int iE11 = b2.b.e(cursorF, "worker_class_name");
            int iE12 = b2.b.e(cursorF, "input_merger_class_name");
            int iE13 = b2.b.e(cursorF, "input");
            int iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
            try {
                int iE15 = b2.b.e(cursorF, "initial_delay");
                int iE16 = b2.b.e(cursorF, "interval_duration");
                int iE17 = b2.b.e(cursorF, "flex_duration");
                int iE18 = b2.b.e(cursorF, "run_attempt_count");
                int iE19 = b2.b.e(cursorF, "backoff_policy");
                int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
                int iE21 = b2.b.e(cursorF, "period_start_time");
                int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
                int iE23 = b2.b.e(cursorF, "schedule_requested_at");
                int iE24 = b2.b.e(cursorF, "run_in_foreground");
                int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
                int i10 = iE14;
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    String string = cursorF.getString(iE9);
                    int i11 = iE9;
                    String string2 = cursorF.getString(iE11);
                    int i12 = iE11;
                    androidx.work.b bVar = new androidx.work.b();
                    int i13 = iE;
                    bVar.k(x.e(cursorF.getInt(iE)));
                    bVar.m(cursorF.getInt(iE2) != 0);
                    bVar.n(cursorF.getInt(iE3) != 0);
                    bVar.l(cursorF.getInt(iE4) != 0);
                    bVar.o(cursorF.getInt(iE5) != 0);
                    int i14 = iE2;
                    int i15 = iE3;
                    bVar.p(cursorF.getLong(iE6));
                    bVar.q(cursorF.getLong(iE7));
                    bVar.j(x.b(cursorF.getBlob(iE8)));
                    r rVar = new r(string, string2);
                    rVar.f51842b = x.g(cursorF.getInt(iE10));
                    rVar.f51844d = cursorF.getString(iE12);
                    rVar.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                    int i16 = i10;
                    rVar.f51846f = androidx.work.d.m(cursorF.getBlob(i16));
                    int i17 = iE15;
                    i10 = i16;
                    rVar.f51847g = cursorF.getLong(i17);
                    int i18 = iE12;
                    int i19 = iE16;
                    rVar.f51848h = cursorF.getLong(i19);
                    int i20 = iE4;
                    int i21 = iE17;
                    rVar.f51849i = cursorF.getLong(i21);
                    int i22 = iE18;
                    rVar.f51851k = cursorF.getInt(i22);
                    int i23 = iE19;
                    rVar.f51852l = x.d(cursorF.getInt(i23));
                    iE17 = i21;
                    int i24 = iE20;
                    rVar.f51853m = cursorF.getLong(i24);
                    int i25 = iE21;
                    rVar.f51854n = cursorF.getLong(i25);
                    iE21 = i25;
                    int i26 = iE22;
                    rVar.f51855o = cursorF.getLong(i26);
                    int i27 = iE23;
                    rVar.f51856p = cursorF.getLong(i27);
                    int i28 = iE24;
                    rVar.f51857q = cursorF.getInt(i28) != 0;
                    int i29 = iE25;
                    rVar.f51858r = x.f(cursorF.getInt(i29));
                    rVar.f51850j = bVar;
                    arrayList.add(rVar);
                    iE2 = i14;
                    iE25 = i29;
                    iE12 = i18;
                    iE15 = i17;
                    iE16 = i19;
                    iE18 = i22;
                    iE23 = i27;
                    iE9 = i11;
                    iE11 = i12;
                    iE = i13;
                    iE24 = i28;
                    iE22 = i26;
                    iE3 = i15;
                    iE20 = i24;
                    iE4 = i20;
                    iE19 = i23;
                }
                cursorF.close();
                w2Var.m();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorF.close();
                w2Var.m();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // u2.s
    public List<r> g(final int schedulerLimit) throws Throwable {
        w2 w2Var;
        w2 w2VarF = w2.f("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        w2VarF.s0(1, schedulerLimit);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "required_network_type");
            int iE2 = b2.b.e(cursorF, "requires_charging");
            int iE3 = b2.b.e(cursorF, "requires_device_idle");
            int iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            int iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            int iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            int iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            int iE8 = b2.b.e(cursorF, "content_uri_triggers");
            int iE9 = b2.b.e(cursorF, "id");
            int iE10 = b2.b.e(cursorF, "state");
            int iE11 = b2.b.e(cursorF, "worker_class_name");
            int iE12 = b2.b.e(cursorF, "input_merger_class_name");
            int iE13 = b2.b.e(cursorF, "input");
            int iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
            try {
                int iE15 = b2.b.e(cursorF, "initial_delay");
                int iE16 = b2.b.e(cursorF, "interval_duration");
                int iE17 = b2.b.e(cursorF, "flex_duration");
                int iE18 = b2.b.e(cursorF, "run_attempt_count");
                int iE19 = b2.b.e(cursorF, "backoff_policy");
                int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
                int iE21 = b2.b.e(cursorF, "period_start_time");
                int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
                int iE23 = b2.b.e(cursorF, "schedule_requested_at");
                int iE24 = b2.b.e(cursorF, "run_in_foreground");
                int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
                int i10 = iE14;
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    String string = cursorF.getString(iE9);
                    int i11 = iE9;
                    String string2 = cursorF.getString(iE11);
                    int i12 = iE11;
                    androidx.work.b bVar = new androidx.work.b();
                    int i13 = iE;
                    bVar.k(x.e(cursorF.getInt(iE)));
                    bVar.m(cursorF.getInt(iE2) != 0);
                    bVar.n(cursorF.getInt(iE3) != 0);
                    bVar.l(cursorF.getInt(iE4) != 0);
                    bVar.o(cursorF.getInt(iE5) != 0);
                    int i14 = iE2;
                    int i15 = iE3;
                    bVar.p(cursorF.getLong(iE6));
                    bVar.q(cursorF.getLong(iE7));
                    bVar.j(x.b(cursorF.getBlob(iE8)));
                    r rVar = new r(string, string2);
                    rVar.f51842b = x.g(cursorF.getInt(iE10));
                    rVar.f51844d = cursorF.getString(iE12);
                    rVar.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                    int i16 = i10;
                    rVar.f51846f = androidx.work.d.m(cursorF.getBlob(i16));
                    i10 = i16;
                    int i17 = iE15;
                    rVar.f51847g = cursorF.getLong(i17);
                    int i18 = iE12;
                    int i19 = iE16;
                    rVar.f51848h = cursorF.getLong(i19);
                    int i20 = iE4;
                    int i21 = iE17;
                    rVar.f51849i = cursorF.getLong(i21);
                    int i22 = iE18;
                    rVar.f51851k = cursorF.getInt(i22);
                    int i23 = iE19;
                    rVar.f51852l = x.d(cursorF.getInt(i23));
                    iE17 = i21;
                    int i24 = iE20;
                    rVar.f51853m = cursorF.getLong(i24);
                    int i25 = iE21;
                    rVar.f51854n = cursorF.getLong(i25);
                    iE21 = i25;
                    int i26 = iE22;
                    rVar.f51855o = cursorF.getLong(i26);
                    int i27 = iE23;
                    rVar.f51856p = cursorF.getLong(i27);
                    int i28 = iE24;
                    rVar.f51857q = cursorF.getInt(i28) != 0;
                    int i29 = iE25;
                    rVar.f51858r = x.f(cursorF.getInt(i29));
                    rVar.f51850j = bVar;
                    arrayList.add(rVar);
                    iE25 = i29;
                    iE2 = i14;
                    iE12 = i18;
                    iE15 = i17;
                    iE16 = i19;
                    iE18 = i22;
                    iE23 = i27;
                    iE9 = i11;
                    iE11 = i12;
                    iE = i13;
                    iE24 = i28;
                    iE22 = i26;
                    iE3 = i15;
                    iE20 = i24;
                    iE4 = i20;
                    iE19 = i23;
                }
                cursorF.close();
                w2Var.m();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorF.close();
                w2Var.m();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // u2.s
    public void h(final r workSpec) {
        this.f51867a.d();
        this.f51867a.e();
        try {
            this.f51868b.i(workSpec);
            this.f51867a.K();
        } finally {
            this.f51867a.k();
        }
    }

    @Override // u2.s
    public List<r> i() throws Throwable {
        w2 w2Var;
        w2 w2VarF = w2.f("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "required_network_type");
            int iE2 = b2.b.e(cursorF, "requires_charging");
            int iE3 = b2.b.e(cursorF, "requires_device_idle");
            int iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            int iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            int iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            int iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            int iE8 = b2.b.e(cursorF, "content_uri_triggers");
            int iE9 = b2.b.e(cursorF, "id");
            int iE10 = b2.b.e(cursorF, "state");
            int iE11 = b2.b.e(cursorF, "worker_class_name");
            int iE12 = b2.b.e(cursorF, "input_merger_class_name");
            int iE13 = b2.b.e(cursorF, "input");
            int iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
            try {
                int iE15 = b2.b.e(cursorF, "initial_delay");
                int iE16 = b2.b.e(cursorF, "interval_duration");
                int iE17 = b2.b.e(cursorF, "flex_duration");
                int iE18 = b2.b.e(cursorF, "run_attempt_count");
                int iE19 = b2.b.e(cursorF, "backoff_policy");
                int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
                int iE21 = b2.b.e(cursorF, "period_start_time");
                int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
                int iE23 = b2.b.e(cursorF, "schedule_requested_at");
                int iE24 = b2.b.e(cursorF, "run_in_foreground");
                int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
                int i10 = iE14;
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    String string = cursorF.getString(iE9);
                    int i11 = iE9;
                    String string2 = cursorF.getString(iE11);
                    int i12 = iE11;
                    androidx.work.b bVar = new androidx.work.b();
                    int i13 = iE;
                    bVar.k(x.e(cursorF.getInt(iE)));
                    bVar.m(cursorF.getInt(iE2) != 0);
                    bVar.n(cursorF.getInt(iE3) != 0);
                    bVar.l(cursorF.getInt(iE4) != 0);
                    bVar.o(cursorF.getInt(iE5) != 0);
                    int i14 = iE2;
                    int i15 = iE3;
                    bVar.p(cursorF.getLong(iE6));
                    bVar.q(cursorF.getLong(iE7));
                    bVar.j(x.b(cursorF.getBlob(iE8)));
                    r rVar = new r(string, string2);
                    rVar.f51842b = x.g(cursorF.getInt(iE10));
                    rVar.f51844d = cursorF.getString(iE12);
                    rVar.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                    int i16 = i10;
                    rVar.f51846f = androidx.work.d.m(cursorF.getBlob(i16));
                    i10 = i16;
                    int i17 = iE15;
                    rVar.f51847g = cursorF.getLong(i17);
                    int i18 = iE13;
                    int i19 = iE16;
                    rVar.f51848h = cursorF.getLong(i19);
                    int i20 = iE4;
                    int i21 = iE17;
                    rVar.f51849i = cursorF.getLong(i21);
                    int i22 = iE18;
                    rVar.f51851k = cursorF.getInt(i22);
                    int i23 = iE19;
                    rVar.f51852l = x.d(cursorF.getInt(i23));
                    iE17 = i21;
                    int i24 = iE20;
                    rVar.f51853m = cursorF.getLong(i24);
                    int i25 = iE21;
                    rVar.f51854n = cursorF.getLong(i25);
                    iE21 = i25;
                    int i26 = iE22;
                    rVar.f51855o = cursorF.getLong(i26);
                    int i27 = iE23;
                    rVar.f51856p = cursorF.getLong(i27);
                    int i28 = iE24;
                    rVar.f51857q = cursorF.getInt(i28) != 0;
                    int i29 = iE25;
                    rVar.f51858r = x.f(cursorF.getInt(i29));
                    rVar.f51850j = bVar;
                    arrayList.add(rVar);
                    iE25 = i29;
                    iE2 = i14;
                    iE13 = i18;
                    iE15 = i17;
                    iE16 = i19;
                    iE18 = i22;
                    iE23 = i27;
                    iE9 = i11;
                    iE11 = i12;
                    iE = i13;
                    iE24 = i28;
                    iE22 = i26;
                    iE3 = i15;
                    iE20 = i24;
                    iE4 = i20;
                    iE19 = i23;
                }
                cursorF.close();
                w2Var.m();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorF.close();
                w2Var.m();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // u2.s
    public r[] j(final List<String> ids) throws Throwable {
        w2 w2Var;
        int iE;
        int iE2;
        int iE3;
        int iE4;
        int iE5;
        int iE6;
        int iE7;
        int iE8;
        int iE9;
        int iE10;
        int iE11;
        int iE12;
        int iE13;
        int iE14;
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT ");
        sbC.append("*");
        sbC.append(" FROM workspec WHERE id IN (");
        int size = ids.size();
        b2.g.a(sbC, size);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size + 0);
        int i10 = 1;
        for (String str : ids) {
            if (str == null) {
                w2VarF.l1(i10);
            } else {
                w2VarF.D(i10, str);
            }
            i10++;
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            iE = b2.b.e(cursorF, "required_network_type");
            iE2 = b2.b.e(cursorF, "requires_charging");
            iE3 = b2.b.e(cursorF, "requires_device_idle");
            iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            iE8 = b2.b.e(cursorF, "content_uri_triggers");
            iE9 = b2.b.e(cursorF, "id");
            iE10 = b2.b.e(cursorF, "state");
            iE11 = b2.b.e(cursorF, "worker_class_name");
            iE12 = b2.b.e(cursorF, "input_merger_class_name");
            iE13 = b2.b.e(cursorF, "input");
            iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
        } catch (Throwable th2) {
            th = th2;
            w2Var = w2VarF;
        }
        try {
            int iE15 = b2.b.e(cursorF, "initial_delay");
            int iE16 = b2.b.e(cursorF, "interval_duration");
            int iE17 = b2.b.e(cursorF, "flex_duration");
            int iE18 = b2.b.e(cursorF, "run_attempt_count");
            int iE19 = b2.b.e(cursorF, "backoff_policy");
            int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
            int iE21 = b2.b.e(cursorF, "period_start_time");
            int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
            int iE23 = b2.b.e(cursorF, "schedule_requested_at");
            int iE24 = b2.b.e(cursorF, "run_in_foreground");
            int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
            r[] rVarArr = new r[cursorF.getCount()];
            int i11 = 0;
            while (cursorF.moveToNext()) {
                r[] rVarArr2 = rVarArr;
                String string = cursorF.getString(iE9);
                int i12 = iE9;
                String string2 = cursorF.getString(iE11);
                int i13 = iE11;
                androidx.work.b bVar = new androidx.work.b();
                int i14 = iE;
                bVar.k(x.e(cursorF.getInt(iE)));
                bVar.m(cursorF.getInt(iE2) != 0);
                bVar.n(cursorF.getInt(iE3) != 0);
                bVar.l(cursorF.getInt(iE4) != 0);
                bVar.o(cursorF.getInt(iE5) != 0);
                int i15 = iE2;
                int i16 = iE3;
                bVar.p(cursorF.getLong(iE6));
                bVar.q(cursorF.getLong(iE7));
                bVar.j(x.b(cursorF.getBlob(iE8)));
                r rVar = new r(string, string2);
                rVar.f51842b = x.g(cursorF.getInt(iE10));
                rVar.f51844d = cursorF.getString(iE12);
                rVar.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                rVar.f51846f = androidx.work.d.m(cursorF.getBlob(iE14));
                int i17 = iE14;
                int i18 = iE15;
                rVar.f51847g = cursorF.getLong(i18);
                iE15 = i18;
                int i19 = iE16;
                rVar.f51848h = cursorF.getLong(i19);
                int i20 = iE12;
                int i21 = iE17;
                rVar.f51849i = cursorF.getLong(i21);
                int i22 = iE18;
                rVar.f51851k = cursorF.getInt(i22);
                int i23 = iE19;
                rVar.f51852l = x.d(cursorF.getInt(i23));
                iE17 = i21;
                int i24 = iE20;
                rVar.f51853m = cursorF.getLong(i24);
                int i25 = iE21;
                rVar.f51854n = cursorF.getLong(i25);
                iE21 = i25;
                int i26 = iE22;
                rVar.f51855o = cursorF.getLong(i26);
                iE22 = i26;
                int i27 = iE23;
                rVar.f51856p = cursorF.getLong(i27);
                int i28 = iE24;
                rVar.f51857q = cursorF.getInt(i28) != 0;
                int i29 = iE25;
                rVar.f51858r = x.f(cursorF.getInt(i29));
                rVar.f51850j = bVar;
                rVarArr2[i11] = rVar;
                i11++;
                iE25 = i29;
                iE2 = i15;
                iE23 = i27;
                rVarArr = rVarArr2;
                iE9 = i12;
                iE11 = i13;
                iE = i14;
                iE24 = i28;
                iE14 = i17;
                iE3 = i16;
                iE20 = i24;
                iE12 = i20;
                iE16 = i19;
                iE18 = i22;
                iE19 = i23;
            }
            r[] rVarArr3 = rVarArr;
            cursorF.close();
            w2Var.m();
            return rVarArr3;
        } catch (Throwable th3) {
            th = th3;
            cursorF.close();
            w2Var.m();
            throw th;
        }
    }

    @Override // u2.s
    public void k(final String id2, final androidx.work.d output) throws Throwable {
        this.f51867a.d();
        c2.i iVarA = this.f51870d.a();
        byte[] bArrF = androidx.work.d.F(output);
        if (bArrF == null) {
            iVarA.l1(1);
        } else {
            iVarA.E0(1, bArrF);
        }
        if (id2 == null) {
            iVarA.l1(2);
        } else {
            iVarA.D(2, id2);
        }
        this.f51867a.e();
        try {
            iVarA.a0();
            this.f51867a.K();
        } finally {
            this.f51867a.k();
            this.f51870d.f(iVarA);
        }
    }

    @Override // u2.s
    public LiveData<List<String>> l() {
        return this.f51867a.o().f(new String[]{"workspec"}, true, new a(w2.f("SELECT id FROM workspec", 0)));
    }

    @Override // u2.s
    public LiveData<List<r.c>> m(final String name) {
        w2 w2VarF = w2.f("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, name);
        }
        return this.f51867a.o().f(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new d(w2VarF));
    }

    @Override // u2.s
    public List<r> n() throws Throwable {
        w2 w2Var;
        w2 w2VarF = w2.f("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "required_network_type");
            int iE2 = b2.b.e(cursorF, "requires_charging");
            int iE3 = b2.b.e(cursorF, "requires_device_idle");
            int iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            int iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            int iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            int iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            int iE8 = b2.b.e(cursorF, "content_uri_triggers");
            int iE9 = b2.b.e(cursorF, "id");
            int iE10 = b2.b.e(cursorF, "state");
            int iE11 = b2.b.e(cursorF, "worker_class_name");
            int iE12 = b2.b.e(cursorF, "input_merger_class_name");
            int iE13 = b2.b.e(cursorF, "input");
            int iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
            try {
                int iE15 = b2.b.e(cursorF, "initial_delay");
                int iE16 = b2.b.e(cursorF, "interval_duration");
                int iE17 = b2.b.e(cursorF, "flex_duration");
                int iE18 = b2.b.e(cursorF, "run_attempt_count");
                int iE19 = b2.b.e(cursorF, "backoff_policy");
                int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
                int iE21 = b2.b.e(cursorF, "period_start_time");
                int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
                int iE23 = b2.b.e(cursorF, "schedule_requested_at");
                int iE24 = b2.b.e(cursorF, "run_in_foreground");
                int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
                int i10 = iE14;
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    String string = cursorF.getString(iE9);
                    int i11 = iE9;
                    String string2 = cursorF.getString(iE11);
                    int i12 = iE11;
                    androidx.work.b bVar = new androidx.work.b();
                    int i13 = iE;
                    bVar.k(x.e(cursorF.getInt(iE)));
                    bVar.m(cursorF.getInt(iE2) != 0);
                    bVar.n(cursorF.getInt(iE3) != 0);
                    bVar.l(cursorF.getInt(iE4) != 0);
                    bVar.o(cursorF.getInt(iE5) != 0);
                    int i14 = iE2;
                    int i15 = iE3;
                    bVar.p(cursorF.getLong(iE6));
                    bVar.q(cursorF.getLong(iE7));
                    bVar.j(x.b(cursorF.getBlob(iE8)));
                    r rVar = new r(string, string2);
                    rVar.f51842b = x.g(cursorF.getInt(iE10));
                    rVar.f51844d = cursorF.getString(iE12);
                    rVar.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                    int i16 = i10;
                    rVar.f51846f = androidx.work.d.m(cursorF.getBlob(i16));
                    i10 = i16;
                    int i17 = iE15;
                    rVar.f51847g = cursorF.getLong(i17);
                    int i18 = iE13;
                    int i19 = iE16;
                    rVar.f51848h = cursorF.getLong(i19);
                    int i20 = iE4;
                    int i21 = iE17;
                    rVar.f51849i = cursorF.getLong(i21);
                    int i22 = iE18;
                    rVar.f51851k = cursorF.getInt(i22);
                    int i23 = iE19;
                    rVar.f51852l = x.d(cursorF.getInt(i23));
                    iE17 = i21;
                    int i24 = iE20;
                    rVar.f51853m = cursorF.getLong(i24);
                    int i25 = iE21;
                    rVar.f51854n = cursorF.getLong(i25);
                    iE21 = i25;
                    int i26 = iE22;
                    rVar.f51855o = cursorF.getLong(i26);
                    int i27 = iE23;
                    rVar.f51856p = cursorF.getLong(i27);
                    int i28 = iE24;
                    rVar.f51857q = cursorF.getInt(i28) != 0;
                    int i29 = iE25;
                    rVar.f51858r = x.f(cursorF.getInt(i29));
                    rVar.f51850j = bVar;
                    arrayList.add(rVar);
                    iE25 = i29;
                    iE2 = i14;
                    iE13 = i18;
                    iE15 = i17;
                    iE16 = i19;
                    iE18 = i22;
                    iE23 = i27;
                    iE9 = i11;
                    iE11 = i12;
                    iE = i13;
                    iE24 = i28;
                    iE22 = i26;
                    iE3 = i15;
                    iE20 = i24;
                    iE4 = i20;
                    iE19 = i23;
                }
                cursorF.close();
                w2Var.m();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursorF.close();
                w2Var.m();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // u2.s
    public LiveData<List<r.c>> o(final String tag) {
        w2 w2VarF = w2.f("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, tag);
        }
        return this.f51867a.o().f(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new c(w2VarF));
    }

    @Override // u2.s
    public List<String> p() {
        w2 w2VarF = w2.f("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
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

    @Override // u2.s
    public boolean q() {
        boolean z10 = false;
        w2 w2VarF = w2.f("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            if (cursorF.moveToFirst()) {
                if (cursorF.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.s
    public List<String> r(final String name) {
        w2 w2VarF = w2.f("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, name);
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
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

    @Override // u2.s
    public r.c s(String str) {
        w2 w2VarF = w2.f("SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?", 1);
        if (str == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, str);
        }
        this.f51867a.d();
        this.f51867a.e();
        try {
            r.c cVar = null;
            Cursor cursorF = b2.c.f(this.f51867a, w2VarF, true, null);
            try {
                int iE = b2.b.e(cursorF, "id");
                int iE2 = b2.b.e(cursorF, "state");
                int iE3 = b2.b.e(cursorF, "output");
                int iE4 = b2.b.e(cursorF, "run_attempt_count");
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorF.moveToNext()) {
                    if (!cursorF.isNull(iE)) {
                        String string = cursorF.getString(iE);
                        if (aVar.get(string) == null) {
                            aVar.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorF.isNull(iE)) {
                        String string2 = cursorF.getString(iE);
                        if (aVar2.get(string2) == null) {
                            aVar2.put(string2, new ArrayList<>());
                        }
                    }
                }
                cursorF.moveToPosition(-1);
                J(aVar);
                I(aVar2);
                if (cursorF.moveToFirst()) {
                    ArrayList<String> arrayList = !cursorF.isNull(iE) ? aVar.get(cursorF.getString(iE)) : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    ArrayList<androidx.work.d> arrayList2 = cursorF.isNull(iE) ? null : aVar2.get(cursorF.getString(iE));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    r.c cVar2 = new r.c();
                    cVar2.f51861a = cursorF.getString(iE);
                    cVar2.f51862b = x.g(cursorF.getInt(iE2));
                    cVar2.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                    cVar2.f51864d = cursorF.getInt(iE4);
                    cVar2.f51865e = arrayList;
                    cVar2.f51866f = arrayList2;
                    cVar = cVar2;
                }
                this.f51867a.K();
                return cVar;
            } finally {
                cursorF.close();
                w2VarF.m();
            }
        } finally {
            this.f51867a.k();
        }
    }

    @Override // u2.s
    public WorkInfo.State t(final String id2) {
        w2 w2VarF = w2.f("SELECT state FROM workspec WHERE id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            return cursorF.moveToFirst() ? x.g(cursorF.getInt(0)) : null;
        } finally {
            cursorF.close();
            w2VarF.m();
        }
    }

    @Override // u2.s
    public r u(final String id2) throws Throwable {
        w2 w2Var;
        r rVar;
        w2 w2VarF = w2.f("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
        try {
            int iE = b2.b.e(cursorF, "required_network_type");
            int iE2 = b2.b.e(cursorF, "requires_charging");
            int iE3 = b2.b.e(cursorF, "requires_device_idle");
            int iE4 = b2.b.e(cursorF, "requires_battery_not_low");
            int iE5 = b2.b.e(cursorF, "requires_storage_not_low");
            int iE6 = b2.b.e(cursorF, "trigger_content_update_delay");
            int iE7 = b2.b.e(cursorF, "trigger_max_content_delay");
            int iE8 = b2.b.e(cursorF, "content_uri_triggers");
            int iE9 = b2.b.e(cursorF, "id");
            int iE10 = b2.b.e(cursorF, "state");
            int iE11 = b2.b.e(cursorF, "worker_class_name");
            int iE12 = b2.b.e(cursorF, "input_merger_class_name");
            int iE13 = b2.b.e(cursorF, "input");
            int iE14 = b2.b.e(cursorF, "output");
            w2Var = w2VarF;
            try {
                int iE15 = b2.b.e(cursorF, "initial_delay");
                int iE16 = b2.b.e(cursorF, "interval_duration");
                int iE17 = b2.b.e(cursorF, "flex_duration");
                int iE18 = b2.b.e(cursorF, "run_attempt_count");
                int iE19 = b2.b.e(cursorF, "backoff_policy");
                int iE20 = b2.b.e(cursorF, "backoff_delay_duration");
                int iE21 = b2.b.e(cursorF, "period_start_time");
                int iE22 = b2.b.e(cursorF, "minimum_retention_duration");
                int iE23 = b2.b.e(cursorF, "schedule_requested_at");
                int iE24 = b2.b.e(cursorF, "run_in_foreground");
                int iE25 = b2.b.e(cursorF, "out_of_quota_policy");
                if (cursorF.moveToFirst()) {
                    String string = cursorF.getString(iE9);
                    String string2 = cursorF.getString(iE11);
                    androidx.work.b bVar = new androidx.work.b();
                    bVar.k(x.e(cursorF.getInt(iE)));
                    bVar.m(cursorF.getInt(iE2) != 0);
                    bVar.n(cursorF.getInt(iE3) != 0);
                    bVar.l(cursorF.getInt(iE4) != 0);
                    bVar.o(cursorF.getInt(iE5) != 0);
                    bVar.p(cursorF.getLong(iE6));
                    bVar.q(cursorF.getLong(iE7));
                    bVar.j(x.b(cursorF.getBlob(iE8)));
                    r rVar2 = new r(string, string2);
                    rVar2.f51842b = x.g(cursorF.getInt(iE10));
                    rVar2.f51844d = cursorF.getString(iE12);
                    rVar2.f51845e = androidx.work.d.m(cursorF.getBlob(iE13));
                    rVar2.f51846f = androidx.work.d.m(cursorF.getBlob(iE14));
                    rVar2.f51847g = cursorF.getLong(iE15);
                    rVar2.f51848h = cursorF.getLong(iE16);
                    rVar2.f51849i = cursorF.getLong(iE17);
                    rVar2.f51851k = cursorF.getInt(iE18);
                    rVar2.f51852l = x.d(cursorF.getInt(iE19));
                    rVar2.f51853m = cursorF.getLong(iE20);
                    rVar2.f51854n = cursorF.getLong(iE21);
                    rVar2.f51855o = cursorF.getLong(iE22);
                    rVar2.f51856p = cursorF.getLong(iE23);
                    rVar2.f51857q = cursorF.getInt(iE24) != 0;
                    rVar2.f51858r = x.f(cursorF.getInt(iE25));
                    rVar2.f51850j = bVar;
                    rVar = rVar2;
                } else {
                    rVar = null;
                }
                cursorF.close();
                w2Var.m();
                return rVar;
            } catch (Throwable th2) {
                th = th2;
                cursorF.close();
                w2Var.m();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            w2Var = w2VarF;
        }
    }

    @Override // u2.s
    public int v(final String id2) {
        this.f51867a.d();
        c2.i iVarA = this.f51873g.a();
        if (id2 == null) {
            iVarA.l1(1);
        } else {
            iVarA.D(1, id2);
        }
        this.f51867a.e();
        try {
            int iA0 = iVarA.a0();
            this.f51867a.K();
            return iA0;
        } finally {
            this.f51867a.k();
            this.f51873g.f(iVarA);
        }
    }

    @Override // u2.s
    public List<r.c> w(final String tag) {
        w2 w2VarF = w2.f("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, tag);
        }
        this.f51867a.d();
        this.f51867a.e();
        try {
            Cursor cursorF = b2.c.f(this.f51867a, w2VarF, true, null);
            try {
                int iE = b2.b.e(cursorF, "id");
                int iE2 = b2.b.e(cursorF, "state");
                int iE3 = b2.b.e(cursorF, "output");
                int iE4 = b2.b.e(cursorF, "run_attempt_count");
                androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
                androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
                while (cursorF.moveToNext()) {
                    if (!cursorF.isNull(iE)) {
                        String string = cursorF.getString(iE);
                        if (aVar.get(string) == null) {
                            aVar.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorF.isNull(iE)) {
                        String string2 = cursorF.getString(iE);
                        if (aVar2.get(string2) == null) {
                            aVar2.put(string2, new ArrayList<>());
                        }
                    }
                }
                cursorF.moveToPosition(-1);
                J(aVar);
                I(aVar2);
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    ArrayList<String> arrayList2 = !cursorF.isNull(iE) ? aVar.get(cursorF.getString(iE)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<androidx.work.d> arrayList3 = !cursorF.isNull(iE) ? aVar2.get(cursorF.getString(iE)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    r.c cVar = new r.c();
                    cVar.f51861a = cursorF.getString(iE);
                    cVar.f51862b = x.g(cursorF.getInt(iE2));
                    cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iE3));
                    cVar.f51864d = cursorF.getInt(iE4);
                    cVar.f51865e = arrayList2;
                    cVar.f51866f = arrayList3;
                    arrayList.add(cVar);
                }
                this.f51867a.K();
                return arrayList;
            } finally {
                cursorF.close();
                w2VarF.m();
            }
        } finally {
            this.f51867a.k();
        }
    }

    @Override // u2.s
    public LiveData<Long> x(final String id2) {
        w2 w2VarF = w2.f("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (id2 == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, id2);
        }
        return this.f51867a.o().f(new String[]{"workspec"}, false, new e(w2VarF));
    }

    @Override // u2.s
    public LiveData<List<r.c>> y(final List<String> ids) {
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = ids.size();
        b2.g.a(sbC, size);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size + 0);
        int i10 = 1;
        for (String str : ids) {
            if (str == null) {
                w2VarF.l1(i10);
            } else {
                w2VarF.D(i10, str);
            }
            i10++;
        }
        return this.f51867a.o().f(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new b(w2VarF));
    }

    @Override // u2.s
    public List<String> z(final String tag) {
        w2 w2VarF = w2.f("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag == null) {
            w2VarF.l1(1);
        } else {
            w2VarF.D(1, tag);
        }
        this.f51867a.d();
        Cursor cursorF = b2.c.f(this.f51867a, w2VarF, false, null);
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
