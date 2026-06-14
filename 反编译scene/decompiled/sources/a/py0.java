package a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.omarea.model.FpsWatchSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class py0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f7159a;

    public py0(Context context) {
        super(context, "perf_monitor", (SQLiteDatabase.CursorFactory) null, 4);
        this.f7159a = a42.a(new gy0(this));
    }

    public final ArrayList<ArrayList<Float>> A(long j) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select cpu_loads from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(0);
                f92.c(string, "cursor.getString(0)");
                arrayList.add(q(string));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final float B(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select avg(cpu_temperature) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return f;
    }

    public final ArrayList<Double> C(long j) {
        ArrayList<Double> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select cpu_temperature from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Double.valueOf(cursorRawQuery.getDouble(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final float D(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select max(cpu_temperature) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return f;
    }

    public final float E(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select min(cpu_temperature) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return f;
    }

    public final int F(long j) {
        int i = 0;
        try {
            Cursor cursorRawQuery = k().rawQuery("select avg(bat_current) from fps_record where session = ?", new String[]{"" + j});
            int i2 = 0;
            while (cursorRawQuery.moveToNext()) {
                try {
                    i2 = cursorRawQuery.getInt(0);
                } catch (Exception unused) {
                    i = i2;
                    return i;
                }
            }
            cursorRawQuery.close();
            return i2;
        } catch (Exception unused2) {
        }
    }

    public final int G(long j) {
        int i = 0;
        try {
            Cursor cursorRawQuery = k().rawQuery("select max(bat_current) from fps_record where session = ?", new String[]{"" + j});
            int i2 = 0;
            while (cursorRawQuery.moveToNext()) {
                try {
                    i2 = cursorRawQuery.getInt(0);
                } catch (Exception unused) {
                    i = i2;
                    return i;
                }
            }
            cursorRawQuery.close();
            return i2;
        } catch (Exception unused2) {
        }
    }

    public final int H(long j) {
        int i = 0;
        try {
            Cursor cursorRawQuery = k().rawQuery("select min(bat_current) from fps_record where session = ?", new String[]{"" + j});
            int i2 = 0;
            while (cursorRawQuery.moveToNext()) {
                try {
                    i2 = cursorRawQuery.getInt(0);
                } catch (Exception unused) {
                    i = i2;
                    return i;
                }
            }
            cursorRawQuery.close();
            return i2;
        } catch (Exception unused2) {
        }
    }

    public final ArrayList<Integer> I(long j) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select ddr_freq from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<Double> J(long j) {
        ArrayList<Double> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select max_ftime from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Double.valueOf(cursorRawQuery.getDouble(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final int K(long j) {
        int i = 0;
        try {
            Cursor cursorRawQuery = k().rawQuery("select max(max_ftime) from fps_record where session = ?", new String[]{"" + j});
            int i2 = 0;
            while (cursorRawQuery.moveToNext()) {
                try {
                    i2 = cursorRawQuery.getInt(0);
                } catch (Exception unused) {
                    i = i2;
                    return i;
                }
            }
            cursorRawQuery.close();
            return i2;
        } catch (Exception unused2) {
        }
    }

    public final float L(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select avg(fps) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return f;
    }

    public final ArrayList<Float> M(long j) {
        ArrayList<Float> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select fps from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Float.valueOf(cursorRawQuery.getFloat(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final double N(long j) {
        try {
            int iZ = Z(j);
            int iB = u92.b(iZ * 0.05f);
            if (iZ > 100) {
                Cursor cursorRawQuery = k().rawQuery("select avg(fps) from (select * from (select fps from fps_record where session = ?) order by fps asc LIMIT ?)", new String[]{"" + j, "" + iB});
                d = cursorRawQuery.moveToNext() ? cursorRawQuery.getDouble(0) : 0.0d;
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return d;
    }

    public final float O(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select max(fps) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception e) {
            Log.e("@Scene", "sessionMaxFps " + e.getMessage());
        }
        return f;
    }

    public final float P(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select min(fps) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return f;
    }

    public final double Q(long j) {
        Object[] array = M(j).toArray(new Float[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return new xj0().a((Float[]) array);
    }

    public final ArrayList<Integer> R(long j) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select gpu_frequency from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<Float> S(long j) {
        ArrayList<Float> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select gpu_load from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Float.valueOf(cursorRawQuery.getFloat(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final int T(long j) {
        int i = 0;
        try {
            Cursor cursorRawQuery = k().rawQuery("select sum(jank) from fps_record where session = ?", new String[]{"" + j});
            int i2 = 0;
            while (cursorRawQuery.moveToNext()) {
                try {
                    i2 = cursorRawQuery.getInt(0);
                } catch (Exception unused) {
                    i = i2;
                    return i;
                }
            }
            cursorRawQuery.close();
            return i2;
        } catch (Exception unused2) {
        }
    }

    public final ArrayList<Integer> U(long j) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select jank from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final double V(long j) {
        double d = 0.0d;
        try {
            Cursor cursorRawQuery = k().rawQuery("select avg(bat_current * voltage) / 1000 from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                d = cursorRawQuery.getDouble(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return d;
    }

    public final ArrayList<Double> W(long j) {
        ArrayList<Double> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select bat_current * voltage / 1000 from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Double.valueOf(cursorRawQuery.getDouble(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final double X(long j) {
        double d = 0.0d;
        try {
            Cursor cursorRawQuery = k().rawQuery("select max(bat_current * voltage) / 1000 from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                d = cursorRawQuery.getDouble(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return d;
    }

    public final double Y(long j) {
        double d = 0.0d;
        try {
            Cursor cursorRawQuery = k().rawQuery("select min(bat_current * voltage) / 1000 from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                d = cursorRawQuery.getDouble(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return d;
    }

    public final int Z(long j) {
        try {
            Cursor cursorRawQuery = k().rawQuery("select count(fps) from fps_record where session = ?", new String[]{"" + j});
            i = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0;
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return i;
    }

    public final long a(long j, double d, int i, int i2, int i3, double d2, Double[] dArr, Integer[] numArr, double d3, double d4, int i4, int i5, int i6, double d5, long j2, double d6, ArrayList<Integer> arrayList, List<in0> list) {
        f92.d(dArr, "cpuLoads");
        f92.d(numArr, "cpuFrequencies");
        f92.d(list, "threads");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("session", Long.valueOf(j));
            contentValues.put("fps", Double.valueOf(d));
            contentValues.put("jank", Integer.valueOf(i));
            contentValues.put("big_jank", Integer.valueOf(i2));
            contentValues.put("max_ftime", Integer.valueOf(i3));
            contentValues.put("cpu_load", Double.valueOf(d2));
            contentValues.put("cpu_loads", i(dArr));
            contentValues.put("cpu_frequencies", h(numArr));
            contentValues.put("cpu_temperature", Double.valueOf(d3));
            contentValues.put("gpu_load", Double.valueOf(d4));
            contentValues.put("gpu_frequency", Integer.valueOf(i4));
            contentValues.put("ddr_freq", Integer.valueOf(i5));
            contentValues.put("capacity", Integer.valueOf(i6));
            contentValues.put("temperature", Double.valueOf(d5));
            contentValues.put("bat_current", Long.valueOf(j2));
            contentValues.put("voltage", Double.valueOf(d6));
            long jInsert = k().insert("fps_record", "", contentValues);
            d30 d30Var = new d30();
            if (arrayList != null) {
                for (Integer num : arrayList) {
                    f92.c(num, "cycle");
                    d30Var.j(num.intValue());
                }
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", Long.valueOf(jInsert));
            contentValues2.put("session", Long.valueOf(j));
            contentValues2.put("cycles", d30Var.toString());
            k().insert("perf_event", "", contentValues2);
            for (in0 in0Var : list) {
                k().execSQL("insert into threads(rid, session, tid, duration, load, comm, cpus) values (?, ?, ?, ?, ?, ?, ?)", new Object[]{Long.valueOf(jInsert), Long.valueOf(j), Integer.valueOf(in0Var.e()), Long.valueOf(in0Var.c()), Double.valueOf(in0Var.d()), in0Var.a(), in0Var.b()});
            }
            return jInsert;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final ArrayList<Float> a0(long j) {
        ArrayList<Float> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select temperature from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Float.valueOf(cursorRawQuery.getFloat(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final d42<ArrayList<Long>, ArrayList<String>> b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Cursor cursorRawQuery = k().rawQuery("select id, cloud_id from session", new String[0]);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(cursorRawQuery.getLong(0)));
                boolean z = true;
                String string = cursorRawQuery.getString(1);
                if (string != null && string.length() != 0) {
                    z = false;
                }
                if (!z) {
                    arrayList2.add(string);
                }
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        try {
            SQLiteDatabase sQLiteDatabaseK = k();
            sQLiteDatabaseK.execSQL("delete from session", new String[0]);
            sQLiteDatabaseK.execSQL("delete from fps_record", new String[0]);
            sQLiteDatabaseK.execSQL("delete from perf_event", new String[0]);
            sQLiteDatabaseK.execSQL("delete from threads", new String[0]);
        } catch (Exception unused2) {
        }
        return j42.a(arrayList, arrayList2);
    }

    public final ArrayList<FpsWatchSession> b0() {
        ArrayList<FpsWatchSession> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select id, time, package_name, remark, duration, fps, power, mode, cloud_id from session join (select session, count(session) as duration, count(session) as duration, avg (fps) as fps, avg(bat_current * voltage / 1000) as power from fps_record group by session) on id == session order by id desc", new String[0]);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new oy0(cursorRawQuery));
            }
            cursorRawQuery.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final long c(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        f92.d(str, "packageName");
        f92.d(str2, "appName");
        f92.d(str3, "version");
        f92.d(str4, "platform");
        f92.d(str5, "machine");
        f92.d(str6, "scheme");
        f92.d(str7, "model");
        f92.d(str9, "mode");
        f92.d(str10, "workingMode");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("app_name", str2);
            contentValues.put("package_name", str);
            contentValues.put("version", str3);
            contentValues.put("sdk_int", Integer.valueOf(i));
            contentValues.put("manufacturer", Build.MANUFACTURER);
            contentValues.put("platform", str4);
            contentValues.put("machine", str5);
            contentValues.put("scheme", str6);
            contentValues.put("model", str7);
            contentValues.put("market_model", str8);
            contentValues.put("mode", str9);
            contentValues.put("working_mode", str10);
            return k().insert("session", "", contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final void c0(long j, String str) {
        f92.d(str, "cloudID");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("cloud_id", str);
            k().update("session", contentValues, "id = ?", new String[]{"" + j});
        } catch (Exception unused) {
        }
    }

    public final void d(long j) {
        try {
            SQLiteDatabase sQLiteDatabaseK = k();
            Object[] objArr = {Long.valueOf(j)};
            sQLiteDatabaseK.execSQL("delete from session where id = ?", objArr);
            sQLiteDatabaseK.execSQL("delete from fps_record where session = ?", objArr);
            sQLiteDatabaseK.execSQL("delete from perf_event where session = ?", objArr);
            sQLiteDatabaseK.execSQL("delete from threads where session = ?", objArr);
        } catch (Exception unused) {
        }
    }

    public final void d0(long j, String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("remark", str);
            k().update("session", contentValues, "id = ?", new String[]{"" + j});
        } catch (Exception unused) {
        }
    }

    public final d42<List<Long>, List<String>> e(String str) {
        f92.d(str, "packageName");
        ArrayList<Long> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Cursor cursorRawQuery = k().rawQuery("select id, cloud_id from session where package_name = ?", new String[]{str});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(cursorRawQuery.getLong(0)));
                String string = cursorRawQuery.getString(1);
                if (!(string == null || string.length() == 0)) {
                    arrayList2.add(string);
                }
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        for (Long l : arrayList) {
            f92.c(l, "session");
            d(l.longValue());
        }
        return j42.a(arrayList, arrayList2);
    }

    public final void e0(long j, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("surface_view", str);
            contentValues.put("view_size", str2);
            k().update("session", contentValues, "id = ?", new String[]{"" + j});
        } catch (Exception unused) {
        }
    }

    public final String f(long j) {
        int i;
        String str;
        String strB;
        py0 py0Var = this;
        String str2 = "%.1f";
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = 0;
            Cursor cursorRawQuery = k().rawQuery("select a.fps, a.jank, a.big_jank, a.max_ftime, a.cpu_loads, a.cpu_frequencies, b.cycles, a.cpu_temperature, a.ddr_freq, a.gpu_load, a.gpu_frequency, a.capacity, a.temperature, a.bat_current, a.voltage, a.id from fps_record as a left join perf_event as b on a.id = b.id where a.session = ?", new String[]{"" + j});
            List<jn0> listN = n(j);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                i = 5;
                if (i3 >= 5 || i3 >= listN.size()) {
                    break;
                }
                arrayList.add(py0Var.m(j, listN.get(i3).f(), listN.get(i3).a()));
                i3++;
            }
            boolean zA = f92.a(e50.f677a.y0(), "root");
            boolean z = true;
            int i4 = 0;
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(4);
                f92.c(string, "cursor.getString(4)");
                ArrayList<Float> arrayListQ = py0Var.q(string);
                String string2 = cursorRawQuery.getString(i);
                f92.c(string2, "cursor.getString(5)");
                ArrayList<Integer> arrayListP = py0Var.p(string2);
                String string3 = cursorRawQuery.getString(6);
                f92.c(string3, "cursor.getString(6)");
                ArrayList<Integer> arrayListP2 = py0Var.p(string3);
                if (z) {
                    sb.append("FPS,JANK,BigJANK,Max FrameTime(ms),CPU(%),");
                    int size = arrayListQ.size();
                    while (i2 < size) {
                        sb.append("CPU");
                        sb.append(i2);
                        sb.append("(%),");
                        i4++;
                        i2++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        sb.append("CPU");
                        sb.append(i5);
                        sb.append("(MHz),");
                    }
                    if (zA) {
                        for (int i6 = 0; i6 < i4; i6++) {
                            sb.append("CPU");
                            sb.append(i6);
                            sb.append("(M Cycles),");
                        }
                    }
                    sb.append("CPU(℃),DDR(Mbps),GPU(%),GPU(MHz),Battery(%),Battery(℃),Current(mA),Battery(volt),Power(mW)");
                    int size2 = arrayList.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        sb.append(",");
                        sb.append(listN.get(i7).a());
                        sb.append("(%)");
                        sb.append(",");
                        sb.append(listN.get(i7).a());
                        sb.append("(cpus)");
                    }
                }
                sb.append("\n");
                sb.append(cursorRawQuery.getString(0));
                sb.append(",");
                sb.append(cursorRawQuery.getInt(1));
                sb.append(",");
                sb.append(cursorRawQuery.getInt(2));
                sb.append(",");
                q92 q92Var = q92.f7191a;
                String str3 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(cursorRawQuery.getDouble(3))}, 1));
                f92.c(str3, "java.lang.String.format(format, *args)");
                sb.append(str3);
                sb.append(",");
                q92 q92Var2 = q92.f7191a;
                Object[] objArr = new Object[1];
                double dFloatValue = 0.0d;
                Iterator<T> it = arrayListQ.iterator();
                while (it.hasNext()) {
                    dFloatValue += (double) ((Number) it.next()).floatValue();
                    cursorRawQuery = cursorRawQuery;
                    listN = listN;
                }
                Cursor cursor = cursorRawQuery;
                List<jn0> list = listN;
                objArr[0] = Double.valueOf(dFloatValue / ((double) i4));
                String str4 = String.format(str2, Arrays.copyOf(objArr, 1));
                f92.c(str4, "java.lang.String.format(format, *args)");
                sb.append(str4);
                sb.append(",");
                for (int i8 = 0; i8 < i4; i8++) {
                    q92 q92Var3 = q92.f7191a;
                    String str5 = String.format(str2, Arrays.copyOf(new Object[]{arrayListQ.get(i8)}, 1));
                    f92.c(str5, "java.lang.String.format(format, *args)");
                    sb.append(str5);
                    sb.append(",");
                }
                for (int i9 = 0; i9 < i4; i9++) {
                    Integer num = arrayListP.get(i9);
                    f92.c(num, "cpuFrequencies[c]");
                    sb.append(num.intValue());
                    sb.append(",");
                }
                if (zA) {
                    for (int i10 = 0; i10 < i4; i10++) {
                        Integer num2 = arrayListP2.get(i10);
                        f92.c(num2, "cpuCycles[c]");
                        sb.append(Math.max(num2.intValue(), 0));
                        sb.append(",");
                    }
                }
                q92 q92Var4 = q92.f7191a;
                String str6 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(cursor.getFloat(7))}, 1));
                f92.c(str6, "java.lang.String.format(format, *args)");
                sb.append(str6);
                sb.append(",");
                sb.append(cursor.getInt(8));
                sb.append(",");
                q92 q92Var5 = q92.f7191a;
                String str7 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(cursor.getFloat(9))}, 1));
                f92.c(str7, "java.lang.String.format(format, *args)");
                sb.append(str7);
                sb.append(",");
                sb.append(cursor.getInt(10));
                sb.append(",");
                sb.append(cursor.getInt(11));
                sb.append(",");
                q92 q92Var6 = q92.f7191a;
                boolean z2 = true;
                int i11 = 0;
                String str8 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(cursor.getFloat(12))}, 1));
                f92.c(str8, "java.lang.String.format(format, *args)");
                sb.append(str8);
                sb.append(",");
                int i12 = cursor.getInt(13);
                float f = cursor.getFloat(14);
                sb.append(i12);
                sb.append(",");
                sb.append(f);
                sb.append(",");
                sb.append((int) (f * i12));
                long j2 = cursor.getLong(15);
                int size3 = arrayList.size();
                int i13 = 0;
                while (i13 < size3) {
                    List list2 = (List) arrayList.get(i13);
                    in0 in0Var = null;
                    int size4 = list2.size();
                    while (true) {
                        if (i11 >= size4) {
                            break;
                        }
                        long jF = ((in0) list2.get(i11)).f();
                        if (jF == j2) {
                            in0Var = (in0) list2.get(i11);
                            break;
                        }
                        if (jF > j2) {
                            break;
                        }
                        i11++;
                    }
                    if (in0Var != null) {
                        sb.append(",");
                        str = str2;
                        sb.append(in0Var.d());
                        sb.append(",");
                        strB = in0Var.b();
                    } else {
                        str = str2;
                        strB = ",0,";
                    }
                    sb.append(strB);
                    i13++;
                    str2 = str;
                    z2 = true;
                    i11 = 0;
                }
                cursorRawQuery = cursor;
                listN = list;
                z = false;
                i2 = 0;
                i = 5;
                py0Var = this;
            }
            cursorRawQuery.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string4 = sb.toString();
        f92.c(string4, "builder.toString()");
        return string4;
    }

    public final String g(long j) {
        Cursor cursorRawQuery = k().rawQuery("select a.id, a.fps, a.jank, a.big_jank, a.max_ftime, a.cpu_loads, a.cpu_frequencies, b.cycles, a.cpu_temperature, a.ddr_freq, a.gpu_load, a.gpu_frequency, a.capacity, a.temperature, a.bat_current, a.voltage from fps_record as a left join perf_event as b on a.id = b.id where a.session = ?", new String[]{"" + j});
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"id", "fps", "jank", "big_jank", "max_ftime", "cpu_loads", "cpu_frequencies", "cycles", "cpu_temperature", "ddr_freq", "gpu_load", "gpu_frequency", "capacity", "temperature", "bat_current", "voltage"};
        d30 d30Var = new d30();
        while (cursorRawQuery.moveToNext()) {
            long j2 = cursorRawQuery.getLong(0);
            String string = cursorRawQuery.getString(5);
            f92.c(string, "cursor.getString(5)");
            String string2 = cursorRawQuery.getString(6);
            f92.c(string2, "cursor.getString(6)");
            String string3 = cursorRawQuery.getString(7);
            f92.c(string3, "cursor.getString(7)");
            m30 m30Var = new m30(Long.valueOf(j2), Integer.valueOf(cursorRawQuery.getInt(1)), Integer.valueOf(cursorRawQuery.getInt(2)), Integer.valueOf(cursorRawQuery.getInt(3)), Integer.valueOf(cursorRawQuery.getInt(4)), string, string2, string3, Float.valueOf(cursorRawQuery.getFloat(8)), Integer.valueOf(cursorRawQuery.getInt(9)), Float.valueOf(cursorRawQuery.getFloat(10)), Integer.valueOf(cursorRawQuery.getInt(11)), Integer.valueOf(cursorRawQuery.getInt(12)), Float.valueOf(cursorRawQuery.getFloat(13)), Integer.valueOf(cursorRawQuery.getInt(14)), Float.valueOf(cursorRawQuery.getFloat(15)));
            arrayList.add(Long.valueOf(j2));
            d30Var.k(m30Var);
        }
        cursorRawQuery.close();
        ey0 ey0VarL = l(j);
        FpsWatchSession fpsWatchSessionR = r(j);
        List<jn0> listN = n(j);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 5 && i < listN.size(); i++) {
            arrayList2.add(m(j, listN.get(i).f(), listN.get(i).a()));
        }
        String string4 = new l30(new ly0(this, j, fpsWatchSessionR, ey0VarL, d30Var, strArr, arrayList2, listN, arrayList)).toString();
        f92.c(string4, "json() {\n            \"se…   }\n        }.toString()");
        return string4;
    }

    public final String h(Integer[] numArr) {
        d30 d30Var = new d30();
        for (Integer num : numArr) {
            d30Var.j(num.intValue());
        }
        String string = d30Var.toString();
        f92.c(string, "jsonObject.toString()");
        return string;
    }

    public final String i(Double[] dArr) throws e30 {
        d30 d30Var = new d30();
        for (Double d : dArr) {
            d30Var.i(d.doubleValue());
        }
        String string = d30Var.toString();
        f92.c(string, "jsonObject.toString()");
        return string;
    }

    @SuppressLint({"HardwareIds"})
    public final String j(Context context) {
        f92.d(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        f92.c(string, "Settings.Secure.getStrin…cure.ANDROID_ID\n        )");
        return string;
    }

    public final SQLiteDatabase k() {
        return (SQLiteDatabase) this.f7159a.getValue();
    }

    public final ey0 l(long j) {
        ey0 ey0Var = new ey0();
        try {
            Cursor cursorRawQuery = k().rawQuery("select sdk_int, platform, machine, manufacturer, model, market_model, mode, working_mode, version, cloud_id from session where id = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                ey0Var.r(cursorRawQuery.getInt(0));
                String string = cursorRawQuery.getString(1);
                f92.c(string, "cursor.getString(1)");
                ey0Var.q(string);
                String string2 = cursorRawQuery.getString(2);
                f92.c(string2, "cursor.getString(2)");
                ey0Var.l(string2);
                String string3 = cursorRawQuery.getString(3);
                f92.c(string3, "cursor.getString(3)");
                ey0Var.m(string3);
                String string4 = cursorRawQuery.getString(4);
                f92.c(string4, "cursor.getString(4)");
                ey0Var.p(string4);
                ey0Var.n(cursorRawQuery.getString(5));
                String string5 = cursorRawQuery.getString(6);
                f92.c(string5, "cursor.getString(6)");
                ey0Var.o(string5);
                String string6 = cursorRawQuery.getString(7);
                f92.c(string6, "cursor.getString(7)");
                ey0Var.t(string6);
                String string7 = cursorRawQuery.getString(8);
                f92.c(string7, "cursor.getString(8)");
                ey0Var.s(string7);
                String string8 = cursorRawQuery.getString(9);
                f92.c(string8, "cursor.getString(9)");
                ey0Var.k(string8);
            }
            cursorRawQuery.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return ey0Var;
    }

    public final List<in0> m(long j, int i, String str) {
        f92.d(str, "comm");
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = k().rawQuery("select id, rid, tid, duration, load, cpus from threads where session = ? and tid = ? and comm = ?", new String[]{"" + j, "" + i, str});
            while (cursorRawQuery.moveToNext()) {
                in0 in0Var = new in0();
                in0Var.k(cursorRawQuery.getLong(0));
                in0Var.n(cursorRawQuery.getLong(1));
                in0Var.m(cursorRawQuery.getInt(2));
                in0Var.j(cursorRawQuery.getLong(3));
                in0Var.l(cursorRawQuery.getDouble(4));
                in0Var.h(str);
                String string = cursorRawQuery.getString(5);
                f92.c(string, "cursor.getString(5)");
                in0Var.i(string);
                arrayList.add(in0Var);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final List<jn0> n(long j) {
        ArrayList arrayList = new ArrayList();
        fy0 fy0VarO = o(j);
        fy0VarO.b();
        fy0VarO.a();
        long j2 = 2;
        try {
            Cursor cursorRawQuery = k().rawQuery("select tid, sum(duration), sum(load), max(load), comm, min(rid), max(rid) from threads where session = ? group by tid, comm", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                jn0 jn0Var = new jn0();
                jn0Var.l(cursorRawQuery.getInt(0));
                jn0Var.h(cursorRawQuery.getLong(1));
                jn0Var.k(cursorRawQuery.getDouble(2));
                jn0Var.j(cursorRawQuery.getDouble(3));
                String string = cursorRawQuery.getString(4);
                f92.c(string, "cursor.getString(4)");
                jn0Var.g(string);
                jn0Var.i(jn0Var.e() / ((cursorRawQuery.getLong(6) - cursorRawQuery.getLong(5)) + j2));
                arrayList.add(jn0Var);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            jn0 jn0Var2 = (jn0) obj;
            if (jn0Var2.c() >= 0.1d && jn0Var2.d() >= ((double) 1)) {
                arrayList2.add(obj);
            }
        }
        List<jn0> listA0 = i52.a0(arrayList2);
        if (Build.VERSION.SDK_INT >= 24 && listA0.size() > 1) {
            c52.n(listA0, new my0());
        }
        return listA0;
    }

    public final fy0 o(long j) {
        fy0 fy0Var = new fy0();
        try {
            Cursor cursorRawQuery = k().rawQuery("select min(id), max(id) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                fy0Var.c(cursorRawQuery.getLong(0));
                fy0Var.d(cursorRawQuery.getLong(1));
            }
            cursorRawQuery.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return fy0Var;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f92.d(sQLiteDatabase, "db");
        try {
            sQLiteDatabase.execSQL("create table session(id INTEGER primary key, cloud_id text,time long,app_name text,package_name text,version text,sdk_int INTEGER,manufacturer text,platform text,machine text,scheme text,model text,market_model text,mode text,surface_view text,view_size text,remark text,working_mode text)");
            sQLiteDatabase.execSQL("create table fps_record(id INTEGER primary key AUTOINCREMENT,session INTEGER,fps REAL,jank REAL,big_jank REAL,max_ftime REAL,cpu_load REAL,cpu_loads text,cpu_frequencies text,cpu_temperature REAL,gpu_load REAL,gpu_frequency INTEGER,ddr_freq INTEGER,capacity INTEGER,temperature REAL,bat_current INTEGER, voltage REAL default(3.85),power_mode text)");
            sQLiteDatabase.execSQL("create table perf_event(id INTEGER primary key AUTOINCREMENT,session INTEGER,cycles text,ddr_freq INTEGER default(0),mem_available INTEGER default(0))");
            sQLiteDatabase.execSQL("create table threads(id INTEGER primary key AUTOINCREMENT,rid INTEGER,session INTEGER,tid INTEGER,duration long default(0),load REAL default(0),comm text,cpus text)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f92.d(sQLiteDatabase, "db");
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE session ADD COLUMN manufacturer TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE session ADD COLUMN machine TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE session ADD COLUMN working_mode TEXT DEFAULT ''");
            String strA = jm0.f6525a.a();
            String strB = jm0.f6525a.b();
            sQLiteDatabase.execSQL("UPDATE session SET manufacturer = ? where machine = ?", new String[]{Build.MANUFACTURER, strA});
            sQLiteDatabase.execSQL("UPDATE session SET machine = ? where platform = ?", new String[]{strA, strA});
            sQLiteDatabase.execSQL("UPDATE session SET platform = ? where machine = ?", new String[]{strB, strA});
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("ALTER TABLE session ADD COLUMN market_model TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("UPDATE session SET market_model = ? where model = ?", new String[]{new lh0().a(), Build.MODEL});
            sQLiteDatabase.execSQL("UPDATE session SET cloud_id = ''");
        }
    }

    public final ArrayList<Integer> p(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            d30 d30Var = new d30(str);
            int iG = d30Var.g();
            for (int i = 0; i < iG; i++) {
                arrayList.add(Integer.valueOf(d30Var.c(i) / 1000));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<Float> q(String str) {
        ArrayList<Float> arrayList = new ArrayList<>();
        try {
            d30 d30Var = new d30(str);
            int iG = d30Var.g();
            for (int i = 0; i < iG; i++) {
                arrayList.add(Float.valueOf((float) d30Var.b(i)));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final FpsWatchSession r(long j) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = k().rawQuery("select id, cloud_id, time, app_name, package_name, version, view_size, remark from session where id = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new ny0(cursorRawQuery));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        if (arrayList.size() > 0) {
            return (FpsWatchSession) arrayList.get(0);
        }
        return null;
    }

    public final float s(long j) {
        float f = 0.0f;
        try {
            Cursor cursorRawQuery = k().rawQuery("select max(temperature) from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                f = cursorRawQuery.getFloat(0);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return f;
    }

    public final ArrayList<Long> t(long j) {
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select bat_current from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(cursorRawQuery.getLong(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final int u(long j) {
        int i = 0;
        try {
            Cursor cursorRawQuery = k().rawQuery("select sum(big_jank) from fps_record where session = ?", new String[]{"" + j});
            int i2 = 0;
            while (cursorRawQuery.moveToNext()) {
                try {
                    i2 = cursorRawQuery.getInt(0);
                } catch (Exception unused) {
                    i = i2;
                    return i;
                }
            }
            cursorRawQuery.close();
            return i2;
        } catch (Exception unused2) {
        }
    }

    public final ArrayList<Integer> v(long j) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select big_jank from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<Float> w(long j) {
        ArrayList<Float> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select capacity from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Float.valueOf(cursorRawQuery.getFloat(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<ArrayList<Integer>> x(long j) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select cycles from perf_event where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                d30 d30Var = new d30(cursorRawQuery.getString(0));
                int iG = d30Var.g();
                for (int i = 0; i < iG; i++) {
                    arrayList2.add(Integer.valueOf(d30Var.c(i) / 1000));
                }
                arrayList.add(arrayList2);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<ArrayList<Integer>> y(long j) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select cpu_frequencies from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(0);
                f92.c(string, "cursor.getString(0)");
                arrayList.add(p(string));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final ArrayList<Double> z(long j) {
        ArrayList<Double> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = k().rawQuery("select cpu_load from fps_record where session = ?", new String[]{"" + j});
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Double.valueOf(cursorRawQuery.getDouble(0)));
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
