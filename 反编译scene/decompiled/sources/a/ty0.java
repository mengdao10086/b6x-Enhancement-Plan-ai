package a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ty0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f7545a;

    public ty0(Context context) {
        super(context, "power_bench", (SQLiteDatabase.CursorFactory) null, 4);
        this.f7545a = a42.a(new sy0(this));
    }

    public final void a(long j, qy0 qy0Var) {
        f92.d(qy0Var, "record");
        ContentValues contentValues = new ContentValues();
        contentValues.put("session", Long.valueOf(j));
        contentValues.put("pass", Boolean.valueOf(qy0Var.d()));
        contentValues.put("frequencies", i52.H(qy0Var.c(), ",", null, null, 0, null, null, 62, null));
        contentValues.put("cycles", i52.H(qy0Var.a(), ",", null, null, 0, null, null, 62, null));
        contentValues.put("power_total", Integer.valueOf(qy0Var.f()));
        contentValues.put("power_dynamic", Integer.valueOf(qy0Var.b()));
        contentValues.put("temperature_avg", Integer.valueOf(qy0Var.h()));
        contentValues.put("temperature_max", Integer.valueOf(qy0Var.h()));
        contentValues.put("total_score", Integer.valueOf(qy0Var.g()));
        contentValues.put("scores", Integer.valueOf(qy0Var.g()));
        contentValues.put("perf_stat", qy0Var.e());
        e().insert("records", "", contentValues);
    }

    public final long b(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, boolean[] zArr, int i8, boolean z, int i9) {
        f92.d(str, "method");
        f92.d(zArr, "cpus");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("method", str);
            contentValues.put("thread_count", Integer.valueOf(i));
            contentValues.put("target_load", Integer.valueOf(i2));
            contentValues.put("load_period_ms", Integer.valueOf(i3));
            contentValues.put("step_duration", Integer.valueOf(i7));
            ArrayList arrayList = new ArrayList(zArr.length);
            for (boolean z2 : zArr) {
                arrayList.add(z2 ? "1" : "0");
            }
            contentValues.put("cpus", i52.H(arrayList, ",", null, null, 0, null, null, 62, null));
            contentValues.put("cpu_min_freq", Integer.valueOf(i4));
            contentValues.put("cpu_max_freq", Integer.valueOf(i5));
            contentValues.put("ddr_min_freq", Integer.valueOf(i6));
            contentValues.put("idle_power", Integer.valueOf(i8));
            contentValues.put("charging", Integer.valueOf(z ? 1 : 0));
            return e().insert("session", "", contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final void c(long j) {
        e().delete("session", "id = ?", new String[]{String.valueOf(j)});
        e().delete("records", "session = ?", new String[]{String.valueOf(j)});
    }

    public final String d(ArrayList<qy0> arrayList, boolean[] zArr, int i) throws Throwable {
        Throwable th;
        double d;
        f92.d(arrayList, "records");
        f92.d(zArr, "targetCPU");
        StringBuilder sb = new StringBuilder();
        int size = ((qy0) i52.A(arrayList)).c().size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append("CPU" + i2 + "(M Cycles),");
        }
        sb.append("CPU(℃),Power(mW),-#I(mW),Efficiency by cycles(%),Efficiency by score(%)");
        ArrayList arrayList2 = new ArrayList(zArr.length);
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            th = null;
            Integer numValueOf = null;
            if (i3 >= length) {
                break;
            }
            int i5 = i4 + 1;
            if (zArr[i3]) {
                numValueOf = Integer.valueOf(i4);
            }
            arrayList2.add(numValueOf);
            i3++;
            i4 = i5;
        }
        List listX = i52.x(arrayList2);
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (qy0 qy0Var : arrayList) {
            ArrayList<Integer> arrayListA = qy0Var.a();
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            for (Object obj : arrayListA) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    y42.l();
                    throw th;
                }
                ((Number) obj).intValue();
                if (listX.contains(Integer.valueOf(i6))) {
                    arrayList3.add(obj);
                }
                i6 = i7;
            }
            int iT = i52.T(arrayList3);
            int iF = qy0Var.f() - i;
            if (iF > 0) {
                double d4 = iT;
                double d5 = iF;
                double d6 = d4 / d5;
                double d7 = d3;
                double dG = ((double) qy0Var.g()) / d5;
                if (d6 > d2) {
                    d2 = d6;
                }
                d3 = dG > d7 ? dG : d7;
            }
            th = null;
        }
        double d8 = d3;
        for (qy0 qy0Var2 : arrayList) {
            sb.append("\n");
            for (Integer num : qy0Var2.a()) {
                f92.c(num, "cpu");
                sb.append(num.intValue());
                sb.append(",");
            }
            sb.append(qy0Var2.h());
            sb.append(",");
            sb.append(qy0Var2.f());
            sb.append(",");
            sb.append(qy0Var2.f() - i);
            sb.append(",");
            ArrayList<Integer> arrayListA2 = qy0Var2.a();
            ArrayList arrayList4 = new ArrayList();
            int i8 = 0;
            for (Object obj2 : arrayListA2) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    y42.l();
                    throw null;
                }
                ((Number) obj2).intValue();
                if (listX.contains(Integer.valueOf(i8))) {
                    arrayList4.add(obj2);
                }
                i8 = i9;
            }
            int iT2 = i52.T(arrayList4);
            int iF2 = qy0Var2.f() - i;
            if (iF2 > 0) {
                double d9 = iF2;
                double d10 = 100;
                d = d2;
                double dG2 = ((((double) qy0Var2.g()) / d9) * d10) / d8;
                sb.append((int) (((((double) iT2) / d9) * d10) / d2));
                sb.append(",");
                sb.append((int) dG2);
            } else {
                d = d2;
                sb.append(",");
            }
            d2 = d;
        }
        String string = sb.toString();
        f92.c(string, "builder.toString()");
        return string;
    }

    public final SQLiteDatabase e() {
        return (SQLiteDatabase) this.f7545a.getValue();
    }

    public final ry0 f() {
        Cursor cursorRawQuery = e().rawQuery("select * from session order by time desc limit 1", new String[0]);
        try {
            if (!cursorRawQuery.moveToNext()) {
                m42 m42Var = m42.f6769a;
                k72.a(cursorRawQuery, null);
                return null;
            }
            f92.c(cursorRawQuery, "cursor");
            ry0 ry0VarK = k(cursorRawQuery);
            k72.a(cursorRawQuery, null);
            return ry0VarK;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                k72.a(cursorRawQuery, th);
                throw th2;
            }
        }
    }

    public final d42<ry0, ArrayList<qy0>> g() {
        ry0 ry0VarF = f();
        if (ry0VarF != null) {
            return j42.a(ry0VarF, h(ry0VarF.f()));
        }
        return null;
    }

    public final ArrayList<qy0> h(long j) {
        ArrayList<qy0> arrayList = new ArrayList<>();
        Cursor cursorQuery = e().query("records", null, "session=?", new String[]{String.valueOf(j)}, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                f92.c(cursorQuery, "cursor");
                boolean z = ux0.a(cursorQuery, "pass") == 1;
                List listD0 = ec2.d0(ux0.c(cursorQuery, "frequencies"), new String[]{","}, false, 0, 6, null);
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                Iterator it = listD0.iterator();
                while (it.hasNext()) {
                    Integer numJ = ac2.j((String) it.next());
                    if (numJ != null) {
                        arrayList2.add(numJ);
                    }
                }
                List listD02 = ec2.d0(ux0.c(cursorQuery, "cycles"), new String[]{","}, false, 0, 6, null);
                ArrayList<Integer> arrayList3 = new ArrayList<>();
                Iterator it2 = listD02.iterator();
                while (it2.hasNext()) {
                    Integer numJ2 = ac2.j((String) it2.next());
                    if (numJ2 != null) {
                        arrayList3.add(numJ2);
                    }
                }
                qy0 qy0Var = new qy0();
                qy0Var.k(arrayList2);
                qy0Var.i(arrayList3);
                qy0Var.n(ux0.a(cursorQuery, "power_total"));
                qy0Var.j(ux0.a(cursorQuery, "power_dynamic"));
                qy0Var.p(ux0.a(cursorQuery, "temperature_avg"));
                qy0Var.o(ux0.a(cursorQuery, "total_score"));
                qy0Var.l(z);
                qy0Var.m(ux0.c(cursorQuery, "perf_stat"));
                m42 m42Var = m42.f6769a;
                arrayList.add(qy0Var);
            } finally {
            }
        }
        m42 m42Var2 = m42.f6769a;
        k72.a(cursorQuery, null);
        return arrayList;
    }

    public final ry0 i(long j) {
        Cursor cursorRawQuery = e().rawQuery("select * from session where id = ?", new String[]{String.valueOf(j)});
        try {
            if (!cursorRawQuery.moveToNext()) {
                m42 m42Var = m42.f6769a;
                k72.a(cursorRawQuery, null);
                return null;
            }
            f92.c(cursorRawQuery, "cursor");
            ry0 ry0VarK = k(cursorRawQuery);
            k72.a(cursorRawQuery, null);
            return ry0VarK;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                k72.a(cursorRawQuery, th);
                throw th2;
            }
        }
    }

    public final ArrayList<ry0> j() {
        ArrayList<ry0> arrayList = new ArrayList<>();
        Cursor cursorQuery = e().query("session", null, null, null, null, null, "time desc");
        while (cursorQuery.moveToNext()) {
            try {
                f92.c(cursorQuery, "cursor");
                arrayList.add(k(cursorQuery));
            } finally {
            }
        }
        m42 m42Var = m42.f6769a;
        k72.a(cursorQuery, null);
        return arrayList;
    }

    public final ry0 k(Cursor cursor) {
        ry0 ry0Var = new ry0();
        ry0Var.q(ux0.b(cursor, "id"));
        ry0Var.t(ux0.a(cursor, "thread_count"));
        ry0Var.s(ux0.a(cursor, "target_load"));
        ry0Var.o(ux0.a(cursor, "load_period_ms"));
        ry0Var.r(ux0.a(cursor, "step_duration"));
        List listD0 = ec2.d0(ux0.c(cursor, "cpus"), new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(z42.m(listD0, 10));
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(f92.a((String) it.next(), "1")));
        }
        ry0Var.l(i52.W(arrayList));
        ry0Var.k(ux0.a(cursor, "cpu_max_freq"));
        ry0Var.j(ux0.a(cursor, "cpu_max_freq"));
        ry0Var.m(ux0.a(cursor, "ddr_min_freq"));
        ry0Var.p(ux0.c(cursor, "method"));
        ry0Var.n(ux0.a(cursor, "idle_power"));
        ry0Var.i(ux0.a(cursor, "charging") == 1);
        return ry0Var;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f92.d(sQLiteDatabase, "db");
        try {
            sQLiteDatabase.execSQL("create table session(id INTEGER primary key, cloud_id text,time long,method varchar(10),thread_count INTEGER,target_load integer,load_period_ms integer,step_duration integer,cpus varchar(32),cpu_min_freq integer,cpu_max_freq integer,ddr_min_freq integer,idle_power integer,charging real,ram_access integer,remark text)");
            sQLiteDatabase.execSQL("create table records(id INTEGER primary key AUTOINCREMENT,session INTEGER,pass real,frequencies text,cycles string,power_total integer,power_dynamic integer,temperature_avg integer,temperature_max integer,total_score integer,perf_stat text,scores text)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f92.d(sQLiteDatabase, "db");
        if (i < 2) {
            sQLiteDatabase.execSQL("alter table session add column ram_access integer default 10", new Object[0]);
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("alter table records add column perf_stat text default null", new Object[0]);
        }
    }
}
