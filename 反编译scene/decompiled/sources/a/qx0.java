package a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.omarea.Scene;
import com.omarea.model.ChargeStatRecord;
import com.omarea.model.ChargeStatSession;
import com.omarea.model.ChargeStatTime;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qx0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static qx0 f7248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SQLiteDatabase f2651a;

    public qx0(Context context) {
        super(context, "charge8", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static qx0 d() {
        if (f7248a == null) {
            f7248a = new qx0(Scene.f4796a);
        }
        return f7248a;
    }

    public boolean a(int i, long j, double d, int i2, double d2) {
        m();
        try {
            this.f2651a.execSQL("insert into records(time, session, current, voltage, capacity, temperature) values (?, ?, ?, ?, ?, ?)", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), Long.valueOf(j), Double.valueOf(d), Integer.valueOf(i2), Double.valueOf(d2)});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public ArrayList<ChargeStatTime> b(int i) {
        m();
        ArrayList<ChargeStatTime> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = this.f2651a.rawQuery("select capacity, time from records where session = ?", new String[]{"" + i});
            nx0 nx0Var = null;
            while (cursorRawQuery.moveToNext()) {
                nx0 nx0Var2 = new nx0(this, cursorRawQuery);
                if (nx0Var != null) {
                    if (nx0Var2.capacity == nx0Var.capacity && nx0Var2.startTime - nx0Var.endTime < 10000) {
                        nx0Var.endTime = nx0Var2.endTime;
                    }
                    arrayList.add(nx0Var);
                }
                nx0Var = nx0Var2;
            }
            if (nx0Var != null) {
                arrayList.add(nx0Var);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public boolean c() {
        m();
        try {
            this.f2651a.execSQL("delete from records", new String[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int e() {
        Cursor cursorRawQuery;
        m();
        try {
            cursorRawQuery = this.f2651a.rawQuery("select capacity from records order by time desc limit 1", new String[0]);
            try {
            } finally {
            }
        } catch (Exception unused) {
        }
        if (!cursorRawQuery.moveToNext()) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return 0;
        }
        int i = cursorRawQuery.getInt(0);
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return i;
        return 0;
    }

    public int f() {
        m();
        Cursor cursorRawQuery = this.f2651a.rawQuery("select session from records order by time desc limit 1", new String[0]);
        try {
            if (!cursorRawQuery.moveToNext()) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return 0;
            }
            int i = cursorRawQuery.getInt(0);
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public ChargeStatSession g(int i) {
        m();
        Cursor cursorRawQuery = this.f2651a.rawQuery("select min(time), max(time), (avg(current) * avg(voltage) * count(current) / 3600) from records where session = ?", new String[]{"" + i});
        try {
            if (!cursorRawQuery.moveToNext()) {
                if (cursorRawQuery == null) {
                    return null;
                }
                cursorRawQuery.close();
                return null;
            }
            px0 px0Var = new px0(this, i, cursorRawQuery);
            try {
                cursorRawQuery = this.f2651a.rawQuery("SELECT capacity FROM records WHERE \ntime = (SELECT time FROM records where session = ? ORDER BY time LIMIT 1)\nOR time = (SELECT time FROM records where session = ? ORDER BY time DESC LIMIT 1);", new String[]{"" + i, "" + i});
                try {
                    px0Var.capacityRatio = (cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0) - (cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (Exception unused) {
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return px0Var;
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.f2651a == null) {
            this.f2651a = super.getWritableDatabase();
        }
        return this.f2651a;
    }

    public ArrayList<ChargeStatSession> h() {
        m();
        ArrayList<ChargeStatSession> arrayList = new ArrayList<>();
        Cursor cursorRawQuery = this.f2651a.rawQuery("SELECT s, MIN(ts), MAX(te), MIN(capacity), MAX(capacity) FROM (    SELECT session AS s, MIN(time) AS ts, MAX(time) AS te     FROM records     GROUP BY session) AS a LEFT JOIN records AS b ON a.s = b.session AND (a.ts = b.time OR a.te = b.time) GROUP BY s", new String[0]);
        while (cursorRawQuery.moveToNext()) {
            try {
                arrayList.add(new ox0(this, cursorRawQuery));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public int i(double d, int i) {
        long j;
        long j2;
        double d2;
        double d3;
        m();
        long j3 = 0;
        try {
            Cursor cursorRawQuery = this.f2651a.rawQuery("select current, time from records where session = ?", new String[]{"" + i});
            if (cursorRawQuery.moveToNext()) {
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                while (true) {
                    try {
                        long j7 = cursorRawQuery.getLong(0);
                        long j8 = cursorRawQuery.getLong(1);
                        if (j4 != j3) {
                            double d4 = (j8 - j4) / 1000.0d;
                            if (d4 > 3.0d) {
                                d2 = j5;
                                d3 = (j6 + j7) / 2;
                            } else {
                                d2 = j5;
                                d3 = j7;
                            }
                            j5 = (long) (d2 + (d3 * d4));
                        } else {
                            j5 += 3 * j7;
                        }
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        j6 = j7;
                        j4 = j8;
                        j3 = 0;
                    } catch (Exception unused) {
                        j = j5;
                    }
                }
                j2 = j5;
            } else {
                j2 = 0;
            }
            j = (long) ((j2 * d) / 3600.0d);
            try {
                cursorRawQuery.close();
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            j = 0;
        }
        return (int) j;
    }

    public ArrayList<ChargeStatRecord> j(int i) {
        m();
        ArrayList<ChargeStatRecord> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = this.f2651a.rawQuery("select capacity, temperature, time from records where session = ?", new String[]{"" + i});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new mx0(this, cursorRawQuery));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public Long k() {
        m();
        Cursor cursorRawQuery = this.f2651a.rawQuery("select time from records order by time desc limit 1", new String[0]);
        try {
            if (!cursorRawQuery.moveToNext()) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return 0L;
            }
            Long lValueOf = Long.valueOf(cursorRawQuery.getLong(0));
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return lValueOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public int l() {
        ArrayList<ChargeStatSession> arrayListH = h();
        if (arrayListH.size() > 99) {
            n(arrayListH.get(0).session);
            int[] iArr = {5, 10, 20};
            int i = 1;
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                Iterator<ChargeStatSession> it = arrayListH.iterator();
                while (it.hasNext()) {
                    if (it.next().capacityRatio < i3) {
                        n(arrayListH.get(0).session);
                        i++;
                    }
                }
                if (i > 10) {
                    break;
                }
            }
        }
        ChargeStatSession chargeStatSession = arrayListH.isEmpty() ? null : arrayListH.get(arrayListH.size() - 1);
        if (chargeStatSession != null && chargeStatSession.endTime - chargeStatSession.beginTime < 30000 && chargeStatSession.capacityRatio < 5) {
            n(chargeStatSession.session);
        }
        if (arrayListH.isEmpty()) {
            return 1;
        }
        return 1 + chargeStatSession.session;
    }

    public void m() {
        if (this.f2651a == null) {
            this.f2651a = super.getWritableDatabase();
        }
    }

    public boolean n(int i) {
        m();
        try {
            this.f2651a.execSQL("delete from records where session = ?", new String[]{"" + i});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public ArrayList<ChargeStatRecord> o(int i) {
        m();
        ArrayList<ChargeStatRecord> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = this.f2651a.rawQuery("select capacity, current, time from records where session = ?", new String[]{"" + i});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new kx0(this, cursorRawQuery));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table records(time text primary key, session int, current INTEGER, voltage REAL,capacity INTEGER, temperature REAL)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public ArrayList<ChargeStatRecord> p(int i) {
        m();
        ArrayList<ChargeStatRecord> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = this.f2651a.rawQuery("select capacity, (current * voltage / 1000) as power, time from records where session = ?", new String[]{"" + i});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new lx0(this, cursorRawQuery));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
