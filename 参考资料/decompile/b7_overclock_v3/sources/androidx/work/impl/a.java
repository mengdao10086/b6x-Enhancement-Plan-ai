package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8381a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8382b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8383c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8384d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8385e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8386f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8387g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8388h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8389i = 9;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8390j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8391k = 11;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8392l = 12;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8393m = "CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8394n = "INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8395o = "UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f8396p = "DROP TABLE IF EXISTS alarmInfo";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8397q = "ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f8398r = "ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f8399s = "CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f8400t = "CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f8401u = "ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f8402v = "INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f8403w = "CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f8404x = "ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @n0
    public static z1.c f8405y = new C0081a(1, 2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @n0
    public static z1.c f8406z = new b(3, 4);

    @n0
    public static z1.c A = new c(4, 5);

    @n0
    public static z1.c B = new d(6, 7);

    @n0
    public static z1.c C = new e(7, 8);

    @n0
    public static z1.c D = new f(8, 9);

    @n0
    public static z1.c E = new g(11, 12);

    /* JADX INFO: renamed from: androidx.work.impl.a$a, reason: collision with other inner class name */
    public class C0081a extends z1.c {
        public C0081a(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8393m);
            database.C(a.f8394n);
            database.C(a.f8396p);
            database.C("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    public class b extends z1.c {
        public b(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            if (Build.VERSION.SDK_INT >= 23) {
                database.C(a.f8395o);
            }
        }
    }

    public class c extends z1.c {
        public c(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8397q);
            database.C(a.f8398r);
        }
    }

    public class d extends z1.c {
        public d(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8399s);
        }
    }

    public class e extends z1.c {
        public e(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8400t);
        }
    }

    public class f extends z1.c {
        public f(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8401u);
        }
    }

    public class g extends z1.c {
        public g(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8404x);
        }
    }

    public static class h extends z1.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f8407c;

        public h(@n0 Context context, int startVersion, int endVersion) {
            super(startVersion, endVersion);
            this.f8407c = context;
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            if (this.f57675b >= 10) {
                database.y0(a.f8402v, new Object[]{v2.f.f52582d, 1});
            } else {
                this.f8407c.getSharedPreferences(v2.f.f52580b, 0).edit().putBoolean(v2.f.f52582d, true).apply();
            }
        }
    }

    public static class i extends z1.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f8408c;

        public i(@n0 Context context) {
            super(9, 10);
            this.f8408c = context;
        }

        @Override // z1.c
        public void a(@n0 c2.d database) {
            database.C(a.f8403w);
            v2.f.d(this.f8408c, database);
            v2.c.a(this.f8408c, database);
        }
    }
}
