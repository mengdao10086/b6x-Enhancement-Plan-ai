package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.room.h1;
import androidx.room.n0;
import androidx.room.u2;
import androidx.room.v2;
import b2.c;
import b2.h;
import c2.d;
import c2.e;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import u2.b;
import u2.e;
import u2.f;
import u2.g;
import u2.j;
import u2.k;
import u2.m;
import u2.n;
import u2.p;
import u2.q;
import u2.s;
import u2.t;
import u2.v;
import u2.w;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    public volatile g A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile s f8373t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile b f8374u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile v f8375v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile j f8376w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile m f8377x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile p f8378y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile e f8379z;

    public class a extends v2.a {
        public a(int version) {
            super(version);
        }

        @Override // androidx.room.v2.a
        public void a(d _db) {
            _db.C("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            _db.C("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            _db.C("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            _db.C("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            _db.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            _db.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            _db.C("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            _db.C("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            _db.C(androidx.work.impl.a.f8393m);
            _db.C("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            _db.C("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            _db.C(androidx.work.impl.a.f8399s);
            _db.C(androidx.work.impl.a.f8403w);
            _db.C(u2.f7525f);
            _db.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // androidx.room.v2.a
        public void b(d _db) {
            _db.C("DROP TABLE IF EXISTS `Dependency`");
            _db.C("DROP TABLE IF EXISTS `WorkSpec`");
            _db.C("DROP TABLE IF EXISTS `WorkTag`");
            _db.C("DROP TABLE IF EXISTS `SystemIdInfo`");
            _db.C("DROP TABLE IF EXISTS `WorkName`");
            _db.C("DROP TABLE IF EXISTS `WorkProgress`");
            _db.C("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.this.f7265h != null) {
                int size = WorkDatabase_Impl.this.f7265h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f7265h.get(i10)).b(_db);
                }
            }
        }

        @Override // androidx.room.v2.a
        public void c(d _db) {
            if (WorkDatabase_Impl.this.f7265h != null) {
                int size = WorkDatabase_Impl.this.f7265h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f7265h.get(i10)).a(_db);
                }
            }
        }

        @Override // androidx.room.v2.a
        public void d(d _db) {
            WorkDatabase_Impl.this.f7258a = _db;
            _db.C("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.A(_db);
            if (WorkDatabase_Impl.this.f7265h != null) {
                int size = WorkDatabase_Impl.this.f7265h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) WorkDatabase_Impl.this.f7265h.get(i10)).c(_db);
                }
            }
        }

        @Override // androidx.room.v2.a
        public void e(d _db) {
        }

        @Override // androidx.room.v2.a
        public void f(d _db) {
            c.b(_db);
        }

        @Override // androidx.room.v2.a
        public v2.b g(d _db) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new h.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new h.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new h.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new h.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new h.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new h.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            h hVar = new h("Dependency", map, hashSet, hashSet2);
            h hVarA = h.a(_db, "Dependency");
            if (!hVar.equals(hVarA)) {
                return new v2.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + hVar + "\n Found:\n" + hVarA);
            }
            HashMap map2 = new HashMap(25);
            map2.put("id", new h.a("id", "TEXT", true, 1, null, 1));
            map2.put("state", new h.a("state", "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new h.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new h.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            map2.put("input", new h.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new h.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new h.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new h.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new h.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new h.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new h.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new h.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("period_start_time", new h.a("period_start_time", "INTEGER", true, 0, null, 1));
            map2.put("minimum_retention_duration", new h.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new h.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new h.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new h.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("required_network_type", new h.a("required_network_type", "INTEGER", false, 0, null, 1));
            map2.put("requires_charging", new h.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new h.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new h.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new h.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new h.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new h.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new h.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new h.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new h.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            h hVar2 = new h("WorkSpec", map2, hashSet3, hashSet4);
            h hVarA2 = h.a(_db, "WorkSpec");
            if (!hVar2.equals(hVarA2)) {
                return new v2.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + hVar2 + "\n Found:\n" + hVarA2);
            }
            HashMap map3 = new HashMap(2);
            map3.put(CommonNetImpl.TAG, new h.a(CommonNetImpl.TAG, "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new h.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new h.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new h.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            h hVar3 = new h("WorkTag", map3, hashSet5, hashSet6);
            h hVarA3 = h.a(_db, "WorkTag");
            if (!hVar3.equals(hVarA3)) {
                return new v2.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + hVar3 + "\n Found:\n" + hVarA3);
            }
            HashMap map4 = new HashMap(2);
            map4.put("work_spec_id", new h.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("system_id", new h.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new h.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            h hVar4 = new h("SystemIdInfo", map4, hashSet7, new HashSet(0));
            h hVarA4 = h.a(_db, "SystemIdInfo");
            if (!hVar4.equals(hVarA4)) {
                return new v2.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + hVar4 + "\n Found:\n" + hVarA4);
            }
            HashMap map5 = new HashMap(2);
            map5.put("name", new h.a("name", "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new h.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new h.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new h.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            h hVar5 = new h("WorkName", map5, hashSet8, hashSet9);
            h hVarA5 = h.a(_db, "WorkName");
            if (!hVar5.equals(hVarA5)) {
                return new v2.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + hVar5 + "\n Found:\n" + hVarA5);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new h.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put("progress", new h.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new h.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            h hVar6 = new h("WorkProgress", map6, hashSet10, new HashSet(0));
            h hVarA6 = h.a(_db, "WorkProgress");
            if (!hVar6.equals(hVarA6)) {
                return new v2.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + hVar6 + "\n Found:\n" + hVarA6);
            }
            HashMap map7 = new HashMap(2);
            map7.put("key", new h.a("key", "TEXT", true, 1, null, 1));
            map7.put("long_value", new h.a("long_value", "INTEGER", false, 0, null, 1));
            h hVar7 = new h("Preference", map7, new HashSet(0), new HashSet(0));
            h hVarA7 = h.a(_db, "Preference");
            if (hVar7.equals(hVarA7)) {
                return new v2.b(true, null);
            }
            return new v2.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + hVar7 + "\n Found:\n" + hVarA7);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public b N() {
        b bVar;
        if (this.f8374u != null) {
            return this.f8374u;
        }
        synchronized (this) {
            if (this.f8374u == null) {
                this.f8374u = new u2.c(this);
            }
            bVar = this.f8374u;
        }
        return bVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public e R() {
        e eVar;
        if (this.f8379z != null) {
            return this.f8379z;
        }
        synchronized (this) {
            if (this.f8379z == null) {
                this.f8379z = new f(this);
            }
            eVar = this.f8379z;
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public g S() {
        g gVar;
        if (this.A != null) {
            return this.A;
        }
        synchronized (this) {
            if (this.A == null) {
                this.A = new u2.h(this);
            }
            gVar = this.A;
        }
        return gVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public j T() {
        j jVar;
        if (this.f8376w != null) {
            return this.f8376w;
        }
        synchronized (this) {
            if (this.f8376w == null) {
                this.f8376w = new k(this);
            }
            jVar = this.f8376w;
        }
        return jVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public m U() {
        m mVar;
        if (this.f8377x != null) {
            return this.f8377x;
        }
        synchronized (this) {
            if (this.f8377x == null) {
                this.f8377x = new n(this);
            }
            mVar = this.f8377x;
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public p V() {
        p pVar;
        if (this.f8378y != null) {
            return this.f8378y;
        }
        synchronized (this) {
            if (this.f8378y == null) {
                this.f8378y = new q(this);
            }
            pVar = this.f8378y;
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public s W() {
        s sVar;
        if (this.f8373t != null) {
            return this.f8373t;
        }
        synchronized (this) {
            if (this.f8373t == null) {
                this.f8373t = new t(this);
            }
            sVar = this.f8373t;
        }
        return sVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public v X() {
        v vVar;
        if (this.f8375v != null) {
            return this.f8375v;
        }
        synchronized (this) {
            if (this.f8375v == null) {
                this.f8375v = new w(this);
            }
            vVar = this.f8375v;
        }
        return vVar;
    }

    @Override // androidx.room.RoomDatabase
    public void f() {
        super.c();
        d writableDatabase = super.p().getWritableDatabase();
        try {
            super.e();
            writableDatabase.C("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.C("DELETE FROM `Dependency`");
            writableDatabase.C("DELETE FROM `WorkSpec`");
            writableDatabase.C("DELETE FROM `WorkTag`");
            writableDatabase.C("DELETE FROM `SystemIdInfo`");
            writableDatabase.C("DELETE FROM `WorkName`");
            writableDatabase.C("DELETE FROM `WorkProgress`");
            writableDatabase.C("DELETE FROM `Preference`");
            super.K();
        } finally {
            super.k();
            writableDatabase.L0("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.x1()) {
                writableDatabase.C("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public h1 i() {
        return new h1(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public c2.e j(n0 configuration) {
        return configuration.f7480a.a(e.b.a(configuration.f7481b).c(configuration.f7482c).b(new v2(configuration, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }
}
