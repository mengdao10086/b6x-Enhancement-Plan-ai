package s2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class c<T> extends d<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f49422h = l.f("BrdcstRcvrCnstrntTrckr");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BroadcastReceiver f49423g;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.h(context, intent);
            }
        }
    }

    public c(@n0 Context context, @n0 w2.a taskExecutor) {
        super(context, taskExecutor);
        this.f49423g = new a();
    }

    @Override // s2.d
    public void e() {
        l.c().a(f49422h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f49427b.registerReceiver(this.f49423g, g());
    }

    @Override // s2.d
    public void f() {
        l.c().a(f49422h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f49427b.unregisterReceiver(this.f49423g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, @n0 Intent intent);
}
