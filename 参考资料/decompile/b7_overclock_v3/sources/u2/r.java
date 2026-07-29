package u2;

import androidx.annotation.RestrictTo;
import androidx.room.Index;
import androidx.room.j0;
import androidx.room.m1;
import androidx.room.n2;
import androidx.room.t0;
import androidx.room.u0;
import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import g.f0;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@u0(indices = {@Index({"schedule_requested_at"}), @Index({"period_start_time"})})
public final class r {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f51839t = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m1
    @j0(name = "id")
    @n0
    public String f51841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j0(name = "state")
    @n0
    public WorkInfo.State f51842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @j0(name = "worker_class_name")
    @n0
    public String f51843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @j0(name = "input_merger_class_name")
    public String f51844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @j0(name = "input")
    @n0
    public androidx.work.d f51845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @j0(name = "output")
    @n0
    public androidx.work.d f51846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @j0(name = "initial_delay")
    public long f51847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @j0(name = "interval_duration")
    public long f51848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @j0(name = "flex_duration")
    public long f51849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @t0
    @n0
    public androidx.work.b f51850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @j0(name = "run_attempt_count")
    @f0(from = 0)
    public int f51851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @j0(name = "backoff_policy")
    @n0
    public BackoffPolicy f51852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @j0(name = "backoff_delay_duration")
    public long f51853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @j0(name = "period_start_time")
    public long f51854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @j0(name = "minimum_retention_duration")
    public long f51855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @j0(name = "schedule_requested_at")
    public long f51856p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @j0(name = "run_in_foreground")
    public boolean f51857q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @j0(name = "out_of_quota_policy")
    @n0
    public OutOfQuotaPolicy f51858r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f51838s = androidx.work.l.f("WorkSpec");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final p.a<List<c>, List<WorkInfo>> f51840u = new a();

    public class a implements p.a<List<c>, List<WorkInfo>> {
        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<WorkInfo> apply(List<c> input) {
            if (input == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(input.size());
            Iterator<c> it2 = input.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().a());
            }
            return arrayList;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @j0(name = "id")
        public String f51859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @j0(name = "state")
        public WorkInfo.State f51860b;

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (!(o10 instanceof b)) {
                return false;
            }
            b bVar = (b) o10;
            if (this.f51860b != bVar.f51860b) {
                return false;
            }
            return this.f51859a.equals(bVar.f51859a);
        }

        public int hashCode() {
            return (this.f51859a.hashCode() * 31) + this.f51860b.hashCode();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @j0(name = "id")
        public String f51861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @j0(name = "state")
        public WorkInfo.State f51862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @j0(name = "output")
        public androidx.work.d f51863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @j0(name = "run_attempt_count")
        public int f51864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @n2(entity = u.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {CommonNetImpl.TAG})
        public List<String> f51865e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @n2(entity = o.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        public List<androidx.work.d> f51866f;

        @n0
        public WorkInfo a() {
            List<androidx.work.d> list = this.f51866f;
            return new WorkInfo(UUID.fromString(this.f51861a), this.f51862b, this.f51863c, this.f51865e, (list == null || list.isEmpty()) ? androidx.work.d.f8360c : this.f51866f.get(0), this.f51864d);
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (!(o10 instanceof c)) {
                return false;
            }
            c cVar = (c) o10;
            if (this.f51864d != cVar.f51864d) {
                return false;
            }
            String str = this.f51861a;
            if (str == null ? cVar.f51861a != null : !str.equals(cVar.f51861a)) {
                return false;
            }
            if (this.f51862b != cVar.f51862b) {
                return false;
            }
            androidx.work.d dVar = this.f51863c;
            if (dVar == null ? cVar.f51863c != null : !dVar.equals(cVar.f51863c)) {
                return false;
            }
            List<String> list = this.f51865e;
            if (list == null ? cVar.f51865e != null : !list.equals(cVar.f51865e)) {
                return false;
            }
            List<androidx.work.d> list2 = this.f51866f;
            List<androidx.work.d> list3 = cVar.f51866f;
            return list2 != null ? list2.equals(list3) : list3 == null;
        }

        public int hashCode() {
            String str = this.f51861a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            WorkInfo.State state = this.f51862b;
            int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
            androidx.work.d dVar = this.f51863c;
            int iHashCode3 = (((iHashCode2 + (dVar != null ? dVar.hashCode() : 0)) * 31) + this.f51864d) * 31;
            List<String> list = this.f51865e;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<androidx.work.d> list2 = this.f51866f;
            return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
        }
    }

    public r(@n0 String id2, @n0 String workerClassName) {
        this.f51842b = WorkInfo.State.ENQUEUED;
        androidx.work.d dVar = androidx.work.d.f8360c;
        this.f51845e = dVar;
        this.f51846f = dVar;
        this.f51850j = androidx.work.b.f8339i;
        this.f51852l = BackoffPolicy.EXPONENTIAL;
        this.f51853m = 30000L;
        this.f51856p = -1L;
        this.f51858r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f51841a = id2;
        this.f51843c = workerClassName;
    }

    public long a() {
        if (c()) {
            return this.f51854n + Math.min(androidx.work.x.f8760e, this.f51852l == BackoffPolicy.LINEAR ? this.f51853m * ((long) this.f51851k) : (long) Math.scalb(this.f51853m, this.f51851k - 1));
        }
        if (!d()) {
            long jCurrentTimeMillis = this.f51854n;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.f51847g;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j10 = this.f51854n;
        long j11 = j10 == 0 ? jCurrentTimeMillis2 + this.f51847g : j10;
        long j12 = this.f51849i;
        long j13 = this.f51848h;
        if (j12 != j13) {
            return j11 + j13 + (j10 == 0 ? j12 * (-1) : 0L);
        }
        return j11 + (j10 != 0 ? j13 : 0L);
    }

    public boolean b() {
        return !androidx.work.b.f8339i.equals(this.f51850j);
    }

    public boolean c() {
        return this.f51842b == WorkInfo.State.ENQUEUED && this.f51851k > 0;
    }

    public boolean d() {
        return this.f51848h != 0;
    }

    public void e(long backoffDelayDuration) {
        if (backoffDelayDuration > androidx.work.x.f8760e) {
            androidx.work.l.c().h(f51838s, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            backoffDelayDuration = 18000000;
        }
        if (backoffDelayDuration < 10000) {
            androidx.work.l.c().h(f51838s, "Backoff delay duration less than minimum value", new Throwable[0]);
            backoffDelayDuration = 10000;
        }
        this.f51853m = backoffDelayDuration;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || r.class != o10.getClass()) {
            return false;
        }
        r rVar = (r) o10;
        if (this.f51847g != rVar.f51847g || this.f51848h != rVar.f51848h || this.f51849i != rVar.f51849i || this.f51851k != rVar.f51851k || this.f51853m != rVar.f51853m || this.f51854n != rVar.f51854n || this.f51855o != rVar.f51855o || this.f51856p != rVar.f51856p || this.f51857q != rVar.f51857q || !this.f51841a.equals(rVar.f51841a) || this.f51842b != rVar.f51842b || !this.f51843c.equals(rVar.f51843c)) {
            return false;
        }
        String str = this.f51844d;
        if (str == null ? rVar.f51844d == null : str.equals(rVar.f51844d)) {
            return this.f51845e.equals(rVar.f51845e) && this.f51846f.equals(rVar.f51846f) && this.f51850j.equals(rVar.f51850j) && this.f51852l == rVar.f51852l && this.f51858r == rVar.f51858r;
        }
        return false;
    }

    public void f(long intervalDuration) {
        if (intervalDuration < androidx.work.p.f8749g) {
            androidx.work.l.c().h(f51838s, String.format("Interval duration lesser than minimum allowed value; Changed to %s", Long.valueOf(androidx.work.p.f8749g)), new Throwable[0]);
            intervalDuration = 900000;
        }
        g(intervalDuration, intervalDuration);
    }

    public void g(long intervalDuration, long flexDuration) {
        if (intervalDuration < androidx.work.p.f8749g) {
            androidx.work.l.c().h(f51838s, String.format("Interval duration lesser than minimum allowed value; Changed to %s", Long.valueOf(androidx.work.p.f8749g)), new Throwable[0]);
            intervalDuration = 900000;
        }
        if (flexDuration < 300000) {
            androidx.work.l.c().h(f51838s, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
            flexDuration = 300000;
        }
        if (flexDuration > intervalDuration) {
            androidx.work.l.c().h(f51838s, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(intervalDuration)), new Throwable[0]);
            flexDuration = intervalDuration;
        }
        this.f51848h = intervalDuration;
        this.f51849i = flexDuration;
    }

    public int hashCode() {
        int iHashCode = ((((this.f51841a.hashCode() * 31) + this.f51842b.hashCode()) * 31) + this.f51843c.hashCode()) * 31;
        String str = this.f51844d;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f51845e.hashCode()) * 31) + this.f51846f.hashCode()) * 31;
        long j10 = this.f51847g;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f51848h;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f51849i;
        int iHashCode3 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f51850j.hashCode()) * 31) + this.f51851k) * 31) + this.f51852l.hashCode()) * 31;
        long j13 = this.f51853m;
        int i12 = (iHashCode3 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f51854n;
        int i13 = (i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f51855o;
        int i14 = (i13 + ((int) (j15 ^ (j15 >>> 32)))) * 31;
        long j16 = this.f51856p;
        return ((((i14 + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.f51857q ? 1 : 0)) * 31) + this.f51858r.hashCode();
    }

    @n0
    public String toString() {
        return "{WorkSpec: " + this.f51841a + zc.a.f58317e;
    }

    public r(@n0 r other) {
        this.f51842b = WorkInfo.State.ENQUEUED;
        androidx.work.d dVar = androidx.work.d.f8360c;
        this.f51845e = dVar;
        this.f51846f = dVar;
        this.f51850j = androidx.work.b.f8339i;
        this.f51852l = BackoffPolicy.EXPONENTIAL;
        this.f51853m = 30000L;
        this.f51856p = -1L;
        this.f51858r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f51841a = other.f51841a;
        this.f51843c = other.f51843c;
        this.f51842b = other.f51842b;
        this.f51844d = other.f51844d;
        this.f51845e = new androidx.work.d(other.f51845e);
        this.f51846f = new androidx.work.d(other.f51846f);
        this.f51847g = other.f51847g;
        this.f51848h = other.f51848h;
        this.f51849i = other.f51849i;
        this.f51850j = new androidx.work.b(other.f51850j);
        this.f51851k = other.f51851k;
        this.f51852l = other.f51852l;
        this.f51853m = other.f51853m;
        this.f51854n = other.f51854n;
        this.f51855o = other.f51855o;
        this.f51856p = other.f51856p;
        this.f51857q = other.f51857q;
        this.f51858r = other.f51858r;
    }
}
