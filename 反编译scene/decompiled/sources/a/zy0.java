package a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.omarea.Scene;
import com.omarea.model.BatteryStatus;
import com.omarea.model.PowerStatAVG;
import com.omarea.model.PowerStatRecord;
import com.omarea.model.PowerStatSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zy0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static zy0 f8108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SQLiteDatabase f3904a;

    public zy0(Context context) {
        super(context, "power8", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static zy0 e() {
        if (f8108a == null) {
            f8108a = new zy0(Scene.f4796a);
        }
        return f8108a;
    }

    public boolean a() {
        try {
            getWritableDatabase().delete("records", " 1 = 1", new String[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public ArrayList<PowerStatAVG> b(int i) {
        n();
        try {
            Cursor cursorRawQuery = this.f3904a.rawQuery("select * from (select avg(current) AS current, avg(current * voltage) AS power, avg(temperature) as avg, min(temperature) as min, max(temperature) as max, package, mode, count(current) from records where session = ? and status in (?, ?) and screen_on = 1 and package != '' group by package, mode) r order by current", new String[]{"" + i, "3", "4"});
            ArrayList<PowerStatAVG> arrayList = new ArrayList<>();
            while (cursorRawQuery.moveToNext()) {
                PowerStatAVG powerStatAVG = new PowerStatAVG();
                powerStatAVG.current = cursorRawQuery.getInt(0);
                powerStatAVG.power = cursorRawQuery.getDouble(1);
                powerStatAVG.avgTemperature = cursorRawQuery.getInt(2);
                powerStatAVG.minTemperature = cursorRawQuery.getInt(3);
                powerStatAVG.maxTemperature = cursorRawQuery.getInt(4);
                powerStatAVG.packageName = cursorRawQuery.getString(5);
                powerStatAVG.mode = cursorRawQuery.getString(6);
                powerStatAVG.count = cursorRawQuery.getInt(7);
                arrayList.add(powerStatAVG);
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    public double c(int i) {
        Cursor cursorRawQuery = getWritableDatabase().rawQuery("select avg(current * voltage) AS power from records where session = ? and status in (?, ?) and screen_on = 1", new String[]{"" + i, "3", "4"});
        try {
            int i2 = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0;
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return i2;
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

    public ArrayList<PowerStatRecord> d(int i) {
        n();
        ArrayList<PowerStatRecord> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = this.f3904a.rawQuery("select time, capacity, screen_on, status, package from records where session = ?", new String[]{"" + i});
            wy0 wy0Var = null;
            while (cursorRawQuery.moveToNext()) {
                wy0 wy0Var2 = new wy0(this, cursorRawQuery);
                if (wy0Var != null) {
                    if (Objects.equals(wy0Var2.packageName, wy0Var.packageName) && wy0Var2.charging == wy0Var.charging && wy0Var2.capacity == wy0Var.capacity && wy0Var2.screenOn == wy0Var.screenOn && wy0Var2.startTime - wy0Var.endTime < 10000) {
                        wy0Var.endTime = wy0Var2.endTime;
                    }
                    if (wy0Var2.startTime - wy0Var.endTime > 10000) {
                        wy0Var2.fuzzy = true;
                    }
                    arrayList.add(wy0Var);
                }
                wy0Var = wy0Var2;
            }
            if (wy0Var != null) {
                arrayList.add(wy0Var);
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public int f() {
        n();
        Cursor cursorRawQuery = this.f3904a.rawQuery("select capacity from records order by time desc", new String[0]);
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

    public long g() {
        n();
        Cursor cursorRawQuery = this.f3904a.rawQuery("select max(time) AS current from records", new String[0]);
        try {
            if (cursorRawQuery.moveToNext()) {
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
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

    public int h() {
        n();
        Cursor cursorRawQuery = this.f3904a.rawQuery("select session from records order by time desc limit 1", new String[0]);
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

    public int i(int i) {
        n();
        Cursor cursorRawQuery = this.f3904a.rawQuery("select count(current) AS count from records where session = ? and screen_on = 1 and status in (?, ?)", new String[]{"" + i, "3", "4"});
        try {
            int i2 = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0;
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return i2;
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

    public PowerStatSession j(int i) {
        n();
        Cursor cursorRawQuery = this.f3904a.rawQuery("select a.*, b.p, b.used from (select session as s, min(time), max(time) from records where session = ? group by session) as a left join (select session as s, avg(current * voltage) as p, count(1) as used from records where session = ? and screen_on = 1 and status in (?, ?) group by session) as b on a.s = b.s", new String[]{"" + i, "" + i, "3", "4"});
        try {
            if (cursorRawQuery.moveToNext()) {
                yy0 yy0Var = new yy0(this, cursorRawQuery);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return yy0Var;
            }
            if (cursorRawQuery == null) {
                return null;
            }
            cursorRawQuery.close();
            return null;
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

    public ArrayList<PowerStatSession> k() {
        n();
        ArrayList<PowerStatSession> arrayList = new ArrayList<>();
        Cursor cursorRawQuery = this.f3904a.rawQuery("select a.*, b.p, b.used from (select session as s, min(time), max(time) from records group by session) as a left join (select session as s, avg(current * voltage) as p, count(1) as used from records where screen_on = 1 and status in (?, ?) group by session) as b on a.s = b.s", new String[]{"3", "4"});
        while (cursorRawQuery.moveToNext()) {
            try {
                arrayList.add(new xy0(this, cursorRawQuery));
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

    public boolean l(BatteryStatus batteryStatus) {
        n();
        try {
            SQLiteDatabase sQLiteDatabase = this.f3904a;
            Object[] objArr = new Object[10];
            objArr[0] = "" + batteryStatus.time;
            objArr[1] = Integer.valueOf(batteryStatus.session);
            objArr[2] = Double.valueOf(batteryStatus.temperature);
            objArr[3] = Integer.valueOf(batteryStatus.status);
            objArr[4] = batteryStatus.mode;
            objArr[5] = Integer.valueOf(batteryStatus.current);
            objArr[6] = Double.valueOf(batteryStatus.voltage);
            objArr[7] = batteryStatus.packageName;
            objArr[8] = Integer.valueOf(batteryStatus.screenOn ? 1 : 0);
            objArr[9] = Integer.valueOf(batteryStatus.capacity);
            sQLiteDatabase.execSQL("insert into records(time, session, temperature, status, mode, current, voltage, package, screen_on, capacity) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", objArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int m() {
        PowerStatSession powerStatSessionJ;
        ArrayList<PowerStatSession> arrayListK = k();
        if (arrayListK.size() > 99) {
            o(arrayListK.get(0).session);
            int[] iArr = {100, 300, 600};
            int i = 1;
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                Iterator<PowerStatSession> it = arrayListK.iterator();
                while (it.hasNext()) {
                    if (it.next().used < i3) {
                        o(arrayListK.get(0).session);
                        i++;
                    }
                }
                if (i > 10) {
                    break;
                }
            }
        }
        PowerStatSession powerStatSession = arrayListK.isEmpty() ? null : arrayListK.get(arrayListK.size() - 1);
        if (powerStatSession != null && (powerStatSessionJ = j(powerStatSession.session)) != null && (((long) powerStatSessionJ.used) * 3000) / 60000 < 3) {
            o(powerStatSessionJ.session);
        }
        if (arrayListK.isEmpty()) {
            return 0;
        }
        return arrayListK.get(arrayListK.size() - 1).session + 1;
    }

    public void n() {
        if (this.f3904a == null) {
            this.f3904a = getWritableDatabase();
        }
    }

    public boolean o(int i) {
        n();
        try {
            this.f3904a.delete("records", " session = ?", new String[]{"" + i});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table records(time text primary key, session int, temperature REAL default(-1), status int default(-1),mode text,current int default(-1),voltage int,package text,screen_on INTEGER,capacity INTEGER)");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
