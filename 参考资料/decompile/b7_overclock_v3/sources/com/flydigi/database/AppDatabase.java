package com.flydigi.database;

import androidx.room.RoomDatabase;
import androidx.room.m0;
import c2.d;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.SupportedGameBean;
import hk.e;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@m0(entities = {SupportedGameBean.class, InstalledGameBean.class, CommunitySearchHistoryBean.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @k
    public static final c f14365q = new c(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @e
    @k
    public static final z1.c f14366r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @e
    @k
    public static final z1.c f14367s = new b();

    public static final class a extends z1.c {
        public a() {
            super(1, 2);
        }

        @Override // z1.c
        public void a(@k d database) {
            f0.p(database, "database");
            database.C("ALTER TABLE installed_game ADD COLUMN game_mode INTEGER NOT NULL DEFAULT 0");
            database.C("ALTER TABLE installed_game ADD COLUMN support_native INTEGER NOT NULL DEFAULT 0");
            database.C("ALTER TABLE supported_game ADD COLUMN support_native INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static final class b extends z1.c {
        public b() {
            super(2, 3);
        }

        @Override // z1.c
        public void a(@k d database) {
            f0.p(database, "database");
            database.C("CREATE TABLE community_search_history (keyword TEXT PRIMARY KEY NOT NULL,timestamp INTEGER NOT NULL DEFAULT null)");
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(u uVar) {
            this();
        }
    }

    @k
    public abstract w6.a M();

    @k
    public abstract w6.c N();

    @k
    public abstract w6.e O();
}
