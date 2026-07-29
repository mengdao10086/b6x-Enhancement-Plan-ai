package com.android.motionelf.tools;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.l0;
import com.flydigi.data.DataConstant;
import com.flydigi.remote.R;
import f0.h0;
import f0.v;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11384a = "FZ_Device_Manager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11385b = 4097;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11386c = "FZ_Wadb_Pair";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11387d = 4098;

    @k
    public static l0.a c(Context context, int i10) {
        String string;
        String packageName;
        if (i10 == 4097) {
            string = context.getString(R.string.device_manager_notification_name);
            packageName = f11384a;
        } else if (i10 != 4098) {
            packageName = context.getPackageName();
            string = "";
        } else {
            string = context.getString(R.string.floatview_wireless_adb_activate);
            packageName = f11386c;
        }
        return new l0.a(packageName, string, 4);
    }

    @k
    public static j1.b<v.n> d(final Context context, boolean z10) {
        final String string = context.getString(R.string.app_name);
        final String string2 = z10 ? context.getString(R.string.device_mapping_connected) : context.getString(R.string.device_mapping_unconnected);
        return new j1.b() { // from class: com.android.motionelf.tools.d
            @Override // com.blankj.utilcode.util.j1.b
            public final void accept(Object obj) {
                e.e(string, string2, context, (v.n) obj);
            }
        };
    }

    public static /* synthetic */ void e(String str, String str2, Context context, v.n nVar) {
        nVar.H(f11384a).t0(R.drawable.data_ic_notification_small_icon).P(str).O(str2).H0(System.currentTimeMillis()).j0(true).k0(0);
        nVar.N(PendingIntent.getActivity(context, 0, o5.f.b(context), 167772160)).D(false).h();
    }

    public static /* synthetic */ void f(Context context, String str, boolean z10, v.n nVar) {
        Intent intent = new Intent();
        intent.setAction(DataConstant.ACTION_WADB_PAIR);
        nVar.H(f11384a).t0(R.drawable.data_ic_notification_small_icon).P(context.getString(R.string.floatview_wireless_adb_activate)).O(str).H0(System.currentTimeMillis()).D(true).k0(1);
        if (!z10) {
            nVar.N(PendingIntent.getActivity(context, 0, o5.f.b(context), 167772160));
            return;
        }
        v.n nVarF0 = nVar.F0(com.blankj.utilcode.util.e.q1(0));
        int i10 = R.string.floatview_input_wadb_pair_code;
        nVarF0.b(new v.b.a(0, context.getString(i10), PendingIntent.getBroadcast(context, 1, intent, 301989888)).b(new h0.f("quick_notification_wadb_pair").h(context.getString(i10)).b()).c());
    }

    public static void g(Context context, boolean z10) {
        l0.g(4097, c(context, 4097), d(context, z10));
    }

    public static void h(final Context context, final String str, final boolean z10) {
        l0.g(4097, c(context, 4097), new j1.b() { // from class: com.android.motionelf.tools.c
            @Override // com.blankj.utilcode.util.j1.b
            public final void accept(Object obj) {
                e.f(context, str, z10, (v.n) obj);
            }
        });
    }

    public static void i(Service service, boolean z10) {
        service.startForeground(4097, l0.e(c(service, 4097), d(service, z10)));
    }
}
