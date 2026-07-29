package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.l;
import androidx.work.m;
import androidx.work.v;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8477a = l.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(@n0 Context context, @p0 Intent intent) {
        if (intent == null) {
            return;
        }
        l.c().a(f8477a, "Requesting diagnostics", new Throwable[0]);
        try {
            v.p(context).j(m.e(DiagnosticsWorker.class));
        } catch (IllegalStateException e10) {
            l.c().b(f8477a, "WorkManager is not initialized", e10);
        }
    }
}
