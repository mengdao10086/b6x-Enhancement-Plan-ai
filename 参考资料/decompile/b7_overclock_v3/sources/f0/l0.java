package f0;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements Iterable<Intent> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27520c = "TaskStackBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f27521a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f27522b;

    @v0(16)
    public static class a {
        @g.u
        public static PendingIntent a(Context context, int i10, Intent[] intentArr, int i11, Bundle bundle) {
            return PendingIntent.getActivities(context, i10, intentArr, i11, bundle);
        }
    }

    public interface b {
        @p0
        Intent D0();
    }

    public l0(Context context) {
        this.f27522b = context;
    }

    @n0
    public static l0 g(@n0 Context context) {
        return new l0(context);
    }

    @Deprecated
    public static l0 j(Context context) {
        return g(context);
    }

    @n0
    public l0 a(@n0 Intent intent) {
        this.f27521a.add(intent);
        return this;
    }

    @n0
    public l0 b(@n0 Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f27522b.getPackageManager());
        }
        if (component != null) {
            e(component);
        }
        a(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public l0 d(@n0 Activity activity) {
        Intent intentD0 = activity instanceof b ? ((b) activity).D0() : null;
        if (intentD0 == null) {
            intentD0 = r.a(activity);
        }
        if (intentD0 != null) {
            ComponentName component = intentD0.getComponent();
            if (component == null) {
                component = intentD0.resolveActivity(this.f27522b.getPackageManager());
            }
            e(component);
            a(intentD0);
        }
        return this;
    }

    @n0
    public l0 e(@n0 ComponentName componentName) {
        int size = this.f27521a.size();
        try {
            Intent intentB = r.b(this.f27522b, componentName);
            while (intentB != null) {
                this.f27521a.add(size, intentB);
                intentB = r.b(this.f27522b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @n0
    public l0 f(@n0 Class<?> cls) {
        return e(new ComponentName(this.f27522b, cls));
    }

    @p0
    public Intent i(int i10) {
        return this.f27521a.get(i10);
    }

    @Override // java.lang.Iterable
    @n0
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f27521a.iterator();
    }

    @Deprecated
    public Intent l(int i10) {
        return i(i10);
    }

    public int m() {
        return this.f27521a.size();
    }

    @n0
    public Intent[] o() {
        int size = this.f27521a.size();
        Intent[] intentArr = new Intent[size];
        if (size == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.f27521a.get(0)).addFlags(268484608);
        for (int i10 = 1; i10 < size; i10++) {
            intentArr[i10] = new Intent(this.f27521a.get(i10));
        }
        return intentArr;
    }

    @p0
    public PendingIntent p(int i10, int i11) {
        return q(i10, i11, null);
    }

    @p0
    public PendingIntent q(int i10, int i11, @p0 Bundle bundle) {
        if (this.f27521a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.f27521a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return a.a(this.f27522b, i10, intentArr, i11, bundle);
    }

    public void r() {
        s(null);
    }

    public void s(@p0 Bundle bundle) {
        if (this.f27521a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f27521a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (h0.d.v(this.f27522b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f27522b.startActivity(intent);
    }
}
