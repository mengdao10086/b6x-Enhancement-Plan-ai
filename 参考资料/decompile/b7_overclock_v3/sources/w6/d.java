package w6;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.c3;
import androidx.room.w0;
import androidx.room.w2;
import androidx.room.z2;
import c2.i;
import com.flydigi.community.ui.search.result.ResultFragment;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import xi.j;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements w6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f53931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0<CommunitySearchHistoryBean> f53932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f53933c;

    public class a extends w0<CommunitySearchHistoryBean> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "INSERT OR REPLACE INTO `community_search_history` (`keyword`,`timestamp`) VALUES (?,?)";
        }

        @Override // androidx.room.w0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void g(i stmt, CommunitySearchHistoryBean value) {
            if (value.getKeyword() == null) {
                stmt.l1(1);
            } else {
                stmt.D(1, value.getKeyword());
            }
            stmt.s0(2, value.getTimestamp());
        }
    }

    public class b extends c3 {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.c3
        public String d() {
            return "DELETE FROM community_search_history";
        }
    }

    public class c implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommunitySearchHistoryBean[] f53936a;

        public c(final CommunitySearchHistoryBean[] val$item) {
            this.f53936a = val$item;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            d.this.f53931a.e();
            try {
                d.this.f53932b.j(this.f53936a);
                d.this.f53931a.K();
                return null;
            } finally {
                d.this.f53931a.k();
            }
        }
    }

    /* JADX INFO: renamed from: w6.d$d, reason: collision with other inner class name */
    public class CallableC0635d implements Callable<Void> {
        public CallableC0635d() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            i iVarA = d.this.f53933c.a();
            d.this.f53931a.e();
            try {
                iVarA.a0();
                d.this.f53931a.K();
                return null;
            } finally {
                d.this.f53931a.k();
                d.this.f53933c.f(iVarA);
            }
        }
    }

    public class e implements Callable<List<CommunitySearchHistoryBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f53939a;

        public e(final w2 val$_statement) {
            this.f53939a = val$_statement;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<CommunitySearchHistoryBean> call() throws Exception {
            Cursor cursorF = b2.c.f(d.this.f53931a, this.f53939a, false, null);
            try {
                int iE = b2.b.e(cursorF, ResultFragment.H8);
                int iE2 = b2.b.e(cursorF, "timestamp");
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    arrayList.add(new CommunitySearchHistoryBean(cursorF.isNull(iE) ? null : cursorF.getString(iE), cursorF.getLong(iE2)));
                }
                return arrayList;
            } finally {
                cursorF.close();
            }
        }

        public void finalize() {
            this.f53939a.m();
        }
    }

    public d(RoomDatabase __db) {
        this.f53931a = __db;
        this.f53932b = new a(__db);
        this.f53933c = new b(__db);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // w6.c
    public xi.a a(final CommunitySearchHistoryBean... item) {
        return xi.a.S(new c(item));
    }

    @Override // w6.c
    public xi.a b() {
        return xi.a.S(new CallableC0635d());
    }

    @Override // w6.c
    public j<List<CommunitySearchHistoryBean>> getAll() {
        return z2.a(this.f53931a, false, new String[]{"community_search_history"}, new e(w2.f("SELECT * FROM community_search_history ORDER BY timestamp desc", 0)));
    }
}
