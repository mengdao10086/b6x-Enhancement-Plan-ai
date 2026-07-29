package com.flydigi.database;

import androidx.room.RoomDatabase;
import androidx.room.h1;
import androidx.room.n0;
import androidx.room.u2;
import androidx.room.v2;
import b2.h;
import c2.d;
import c2.e;
import com.flydigi.community.ui.search.result.ResultFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w6.b;
import w6.c;
import w6.e;
import w6.f;

/* JADX INFO: loaded from: classes7.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile e f14368t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile w6.a f14369u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile c f14370v;

    public class a extends v2.a {
        public a(int version) {
            super(version);
        }

        @Override // androidx.room.v2.a
        public void a(d _db) {
            _db.C("CREATE TABLE IF NOT EXISTS `supported_game` (`id` INTEGER NOT NULL, `game_name` TEXT, `package_name` TEXT, `thumb` TEXT, `pattern` TEXT, `support_native` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            _db.C("CREATE INDEX IF NOT EXISTS `index_supported_game_package_name` ON `supported_game` (`package_name`)");
            _db.C("CREATE TABLE IF NOT EXISTS `installed_game` (`id` INTEGER NOT NULL, `title` TEXT, `local_package_name` TEXT NOT NULL, `standard_package_name` TEXT, `thumb` TEXT, `update_time` INTEGER NOT NULL, `game_mode` INTEGER NOT NULL, `support_native` INTEGER NOT NULL, PRIMARY KEY(`local_package_name`))");
            _db.C("CREATE INDEX IF NOT EXISTS `index_installed_game_local_package_name` ON `installed_game` (`local_package_name`)");
            _db.C("CREATE INDEX IF NOT EXISTS `index_installed_game_standard_package_name` ON `installed_game` (`standard_package_name`)");
            _db.C("CREATE TABLE IF NOT EXISTS `community_search_history` (`keyword` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`keyword`))");
            _db.C(u2.f7525f);
            _db.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd2bfa07c415db79d942d73ee6fed5c03')");
        }

        @Override // androidx.room.v2.a
        public void b(d _db) {
            _db.C("DROP TABLE IF EXISTS `supported_game`");
            _db.C("DROP TABLE IF EXISTS `installed_game`");
            _db.C("DROP TABLE IF EXISTS `community_search_history`");
            if (AppDatabase_Impl.this.f7265h != null) {
                int size = AppDatabase_Impl.this.f7265h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) AppDatabase_Impl.this.f7265h.get(i10)).b(_db);
                }
            }
        }

        @Override // androidx.room.v2.a
        public void c(d _db) {
            if (AppDatabase_Impl.this.f7265h != null) {
                int size = AppDatabase_Impl.this.f7265h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) AppDatabase_Impl.this.f7265h.get(i10)).a(_db);
                }
            }
        }

        @Override // androidx.room.v2.a
        public void d(d _db) {
            AppDatabase_Impl.this.f7258a = _db;
            AppDatabase_Impl.this.A(_db);
            if (AppDatabase_Impl.this.f7265h != null) {
                int size = AppDatabase_Impl.this.f7265h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((RoomDatabase.b) AppDatabase_Impl.this.f7265h.get(i10)).c(_db);
                }
            }
        }

        @Override // androidx.room.v2.a
        public void e(d _db) {
        }

        @Override // androidx.room.v2.a
        public void f(d _db) {
            b2.c.b(_db);
        }

        @Override // androidx.room.v2.a
        public v2.b g(d _db) {
            HashMap map = new HashMap(6);
            map.put("id", new h.a("id", "INTEGER", true, 1, null, 1));
            map.put("game_name", new h.a("game_name", "TEXT", false, 0, null, 1));
            map.put("package_name", new h.a("package_name", "TEXT", false, 0, null, 1));
            map.put("thumb", new h.a("thumb", "TEXT", false, 0, null, 1));
            map.put("pattern", new h.a("pattern", "TEXT", false, 0, null, 1));
            map.put("support_native", new h.a("support_native", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new h.d("index_supported_game_package_name", false, Arrays.asList("package_name"), Arrays.asList("ASC")));
            h hVar = new h("supported_game", map, hashSet, hashSet2);
            h hVarA = h.a(_db, "supported_game");
            if (!hVar.equals(hVarA)) {
                return new v2.b(false, "supported_game(com.flydigi.data.bean.SupportedGameBean).\n Expected:\n" + hVar + "\n Found:\n" + hVarA);
            }
            HashMap map2 = new HashMap(8);
            map2.put("id", new h.a("id", "INTEGER", true, 0, null, 1));
            map2.put("title", new h.a("title", "TEXT", false, 0, null, 1));
            map2.put("local_package_name", new h.a("local_package_name", "TEXT", true, 1, null, 1));
            map2.put("standard_package_name", new h.a("standard_package_name", "TEXT", false, 0, null, 1));
            map2.put("thumb", new h.a("thumb", "TEXT", false, 0, null, 1));
            map2.put("update_time", new h.a("update_time", "INTEGER", true, 0, null, 1));
            map2.put("game_mode", new h.a("game_mode", "INTEGER", true, 0, null, 1));
            map2.put("support_native", new h.a("support_native", "INTEGER", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new h.d("index_installed_game_local_package_name", false, Arrays.asList("local_package_name"), Arrays.asList("ASC")));
            hashSet4.add(new h.d("index_installed_game_standard_package_name", false, Arrays.asList("standard_package_name"), Arrays.asList("ASC")));
            h hVar2 = new h("installed_game", map2, hashSet3, hashSet4);
            h hVarA2 = h.a(_db, "installed_game");
            if (!hVar2.equals(hVarA2)) {
                return new v2.b(false, "installed_game(com.flydigi.data.bean.InstalledGameBean).\n Expected:\n" + hVar2 + "\n Found:\n" + hVarA2);
            }
            HashMap map3 = new HashMap(2);
            map3.put(ResultFragment.H8, new h.a(ResultFragment.H8, "TEXT", true, 1, null, 1));
            map3.put("timestamp", new h.a("timestamp", "INTEGER", true, 0, null, 1));
            h hVar3 = new h("community_search_history", map3, new HashSet(0), new HashSet(0));
            h hVarA3 = h.a(_db, "community_search_history");
            if (hVar3.equals(hVarA3)) {
                return new v2.b(true, null);
            }
            return new v2.b(false, "community_search_history(com.flydigi.data.bean.CommunitySearchHistoryBean).\n Expected:\n" + hVar3 + "\n Found:\n" + hVarA3);
        }
    }

    @Override // com.flydigi.database.AppDatabase
    public w6.a M() {
        w6.a aVar;
        if (this.f14369u != null) {
            return this.f14369u;
        }
        synchronized (this) {
            if (this.f14369u == null) {
                this.f14369u = new b(this);
            }
            aVar = this.f14369u;
        }
        return aVar;
    }

    @Override // com.flydigi.database.AppDatabase
    public c N() {
        c cVar;
        if (this.f14370v != null) {
            return this.f14370v;
        }
        synchronized (this) {
            if (this.f14370v == null) {
                this.f14370v = new w6.d(this);
            }
            cVar = this.f14370v;
        }
        return cVar;
    }

    @Override // com.flydigi.database.AppDatabase
    public e O() {
        e eVar;
        if (this.f14368t != null) {
            return this.f14368t;
        }
        synchronized (this) {
            if (this.f14368t == null) {
                this.f14368t = new f(this);
            }
            eVar = this.f14368t;
        }
        return eVar;
    }

    @Override // androidx.room.RoomDatabase
    public void f() {
        super.c();
        d writableDatabase = super.p().getWritableDatabase();
        try {
            super.e();
            writableDatabase.C("DELETE FROM `supported_game`");
            writableDatabase.C("DELETE FROM `installed_game`");
            writableDatabase.C("DELETE FROM `community_search_history`");
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
        return new h1(this, new HashMap(0), new HashMap(0), "supported_game", "installed_game", "community_search_history");
    }

    @Override // androidx.room.RoomDatabase
    public c2.e j(n0 configuration) {
        return configuration.f7480a.a(e.b.a(configuration.f7481b).c(configuration.f7482c).b(new v2(configuration, new a(3), "d2bfa07c415db79d942d73ee6fed5c03", "ed2d75ca9fd587c71ef0cef1b128e90d")).a());
    }

    @Override // androidx.room.RoomDatabase
    public List<z1.c> l(@g.n0 Map<Class<? extends z1.b>, z1.b> autoMigrationSpecsMap) {
        return Arrays.asList(new z1.c[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends z1.b>> r() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> s() {
        HashMap map = new HashMap();
        map.put(w6.e.class, f.j());
        map.put(w6.a.class, b.l());
        map.put(c.class, w6.d.f());
        return map;
    }
}
