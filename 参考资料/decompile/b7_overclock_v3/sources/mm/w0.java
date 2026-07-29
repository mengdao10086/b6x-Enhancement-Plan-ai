package mm;

import gm.o2;
import gm.z1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes5.dex */
public class w0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.c0 f41427a;

    public w0(gm.c0 c0Var) {
        if (!(c0Var instanceof gm.q0) && !(c0Var instanceof gm.o)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.f41427a = c0Var;
    }

    public w0(Date date) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i10 = Integer.parseInt(str.substring(0, 4));
        this.f41427a = (i10 < 1950 || i10 > 2049) ? new z1(str) : new o2(str.substring(2));
    }

    public w0(Date date, Locale locale) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", locale);
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i10 = Integer.parseInt(str.substring(0, 4));
        this.f41427a = (i10 < 1950 || i10 > 2049) ? new z1(str) : new o2(str.substring(2));
    }

    public static w0 y(gm.n0 n0Var, boolean z10) {
        return z(n0Var.U());
    }

    public static w0 z(Object obj) {
        if (obj == null || (obj instanceof w0)) {
            return (w0) obj;
        }
        if (obj instanceof gm.q0) {
            return new w0((gm.q0) obj);
        }
        if (obj instanceof gm.o) {
            return new w0((gm.o) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public String A() {
        gm.c0 c0Var = this.f41427a;
        return c0Var instanceof gm.q0 ? ((gm.q0) c0Var).I() : ((gm.o) c0Var).N();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f41427a;
    }

    public Date x() {
        try {
            gm.c0 c0Var = this.f41427a;
            return c0Var instanceof gm.q0 ? ((gm.q0) c0Var).H() : ((gm.o) c0Var).K();
        } catch (ParseException e10) {
            throw new IllegalStateException("invalid date string: " + e10.getMessage());
        }
    }
}
