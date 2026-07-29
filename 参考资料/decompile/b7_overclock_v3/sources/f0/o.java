package f0;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class o extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f27553h = "JobIntentService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f27554i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f27555j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap<ComponentName, h> f27556k = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f27557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f27558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f27559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f27560d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f27561e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f27562f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<d> f27563g;

    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e eVarA = o.this.a();
                if (eVarA == null) {
                    return null;
                }
                o.this.h(eVarA.getIntent());
                eVarA.a();
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            o.this.j();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            o.this.j();
        }
    }

    public interface b {
        IBinder a();

        e b();
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f27565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f27566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final PowerManager.WakeLock f27567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f27568g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f27569h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f27565d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f27566e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f27567f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // f0.o.h
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f27582a);
            if (this.f27565d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f27568g) {
                        this.f27568g = true;
                        if (!this.f27569h) {
                            this.f27566e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // f0.o.h
        public void c() {
            synchronized (this) {
                if (this.f27569h) {
                    if (this.f27568g) {
                        this.f27566e.acquire(60000L);
                    }
                    this.f27569h = false;
                    this.f27567f.release();
                }
            }
        }

        @Override // f0.o.h
        public void d() {
            synchronized (this) {
                if (!this.f27569h) {
                    this.f27569h = true;
                    this.f27567f.acquire(androidx.work.impl.background.systemalarm.a.f8433m);
                    this.f27566e.release();
                }
            }
        }

        @Override // f0.o.h
        public void e() {
            synchronized (this) {
                this.f27568g = false;
            }
        }
    }

    public final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f27570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f27571b;

        public d(Intent intent, int i10) {
            this.f27570a = intent;
            this.f27571b = i10;
        }

        @Override // f0.o.e
        public void a() {
            o.this.stopSelf(this.f27571b);
        }

        @Override // f0.o.e
        public Intent getIntent() {
            return this.f27570a;
        }
    }

    public interface e {
        void a();

        Intent getIntent();
    }

    @v0(26)
    public static final class f extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f27573d = "JobServiceEngineImpl";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final boolean f27574e = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f27575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f27576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f27577c;

        public final class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f27578a;

            public a(JobWorkItem jobWorkItem) {
                this.f27578a = jobWorkItem;
            }

            @Override // f0.o.e
            public void a() {
                synchronized (f.this.f27576b) {
                    JobParameters jobParameters = f.this.f27577c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f27578a);
                    }
                }
            }

            @Override // f0.o.e
            public Intent getIntent() {
                return this.f27578a.getIntent();
            }
        }

        public f(o oVar) {
            super(oVar);
            this.f27576b = new Object();
            this.f27575a = oVar;
        }

        @Override // f0.o.b
        public IBinder a() {
            return getBinder();
        }

        @Override // f0.o.b
        public e b() {
            synchronized (this.f27576b) {
                JobParameters jobParameters = this.f27577c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f27575a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f27577c = jobParameters;
            this.f27575a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f27575a.b();
            synchronized (this.f27576b) {
                this.f27577c = null;
            }
            return zB;
        }
    }

    @v0(26)
    public static final class g extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JobInfo f27580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobScheduler f27581e;

        public g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f27580d = new JobInfo.Builder(i10, this.f27582a).setOverrideDeadline(0L).build();
            this.f27581e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // f0.o.h
        public void a(Intent intent) {
            this.f27581e.enqueue(this.f27580d, new JobWorkItem(intent));
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f27582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f27583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f27584c;

        public h(ComponentName componentName) {
            this.f27582a = componentName;
        }

        public abstract void a(Intent intent);

        public void b(int i10) {
            if (!this.f27583b) {
                this.f27583b = true;
                this.f27584c = i10;
            } else {
                if (this.f27584c == i10) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f27584c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public o() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f27563g = null;
        } else {
            this.f27563g = new ArrayList<>();
        }
    }

    public static void c(@n0 Context context, @n0 ComponentName componentName, int i10, @n0 Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f27555j) {
            h hVarF = f(context, componentName, true, i10);
            hVarF.b(i10);
            hVarF.a(intent);
        }
    }

    public static void d(@n0 Context context, @n0 Class<?> cls, int i10, @n0 Intent intent) {
        c(context, new ComponentName(context, cls), i10, intent);
    }

    public static h f(Context context, ComponentName componentName, boolean z10, int i10) {
        h cVar;
        HashMap<ComponentName, h> map = f27556k;
        h hVar = map.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z10) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i10);
        }
        h hVar2 = cVar;
        map.put(componentName, hVar2);
        return hVar2;
    }

    public e a() {
        b bVar = this.f27557a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f27563g) {
            if (this.f27563g.size() <= 0) {
                return null;
            }
            return this.f27563g.remove(0);
        }
    }

    public boolean b() {
        a aVar = this.f27559c;
        if (aVar != null) {
            aVar.cancel(this.f27560d);
        }
        this.f27561e = true;
        return i();
    }

    public void e(boolean z10) {
        if (this.f27559c == null) {
            this.f27559c = new a();
            h hVar = this.f27558b;
            if (hVar != null && z10) {
                hVar.d();
            }
            this.f27559c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean g() {
        return this.f27561e;
    }

    public abstract void h(@n0 Intent intent);

    public boolean i() {
        return true;
    }

    public void j() {
        ArrayList<d> arrayList = this.f27563g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f27559c = null;
                ArrayList<d> arrayList2 = this.f27563g;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    e(false);
                } else if (!this.f27562f) {
                    this.f27558b.c();
                }
            }
        }
    }

    public void k(boolean z10) {
        this.f27560d = z10;
    }

    @Override // android.app.Service
    public IBinder onBind(@n0 Intent intent) {
        b bVar = this.f27557a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f27557a = new f(this);
            this.f27558b = null;
        } else {
            this.f27557a = null;
            this.f27558b = f(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f27563g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f27562f = true;
                this.f27558b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@p0 Intent intent, int i10, int i11) {
        if (this.f27563g == null) {
            return 2;
        }
        this.f27558b.e();
        synchronized (this.f27563g) {
            ArrayList<d> arrayList = this.f27563g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i11));
            e(true);
        }
        return 3;
    }
}
