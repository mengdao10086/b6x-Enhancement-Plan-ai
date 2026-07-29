package org.bouncycastle.its;

import gm.t;
import java.util.Date;
import xr.j2;
import xr.o;

/* JADX INFO: loaded from: classes5.dex */
public class ITSValidityPeriod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Unit f44857c;

    public enum Unit {
        microseconds(0),
        milliseconds(1),
        seconds(2),
        minutes(3),
        hours(4),
        sixtyHours(5),
        years(6);

        private final int unitTag;

        Unit(int i10) {
            this.unitTag = i10;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44858a;

        public a(Date date) {
            this.f44858a = date.getTime();
        }

        public ITSValidityPeriod a(int i10) {
            return new ITSValidityPeriod(this.f44858a, i10, Unit.sixtyHours);
        }

        public ITSValidityPeriod b(int i10) {
            return new ITSValidityPeriod(this.f44858a, i10, Unit.years);
        }
    }

    public ITSValidityPeriod(long j10, int i10, Unit unit) {
        this.f44855a = j10;
        this.f44856b = i10;
        this.f44857c = unit;
    }

    public ITSValidityPeriod(j2 j2Var) {
        this.f44855a = j2Var.A().T();
        o oVarY = j2Var.y();
        this.f44856b = oVarY.z();
        this.f44857c = Unit.values()[oVarY.y()];
    }

    public static a a(Date date) {
        return new a(date);
    }

    public Date b() {
        return new Date(this.f44855a);
    }

    public j2 c() {
        return j2.x().c(new t(this.f44855a / 1000)).b(new o(this.f44856b, this.f44857c.unitTag)).a();
    }
}
