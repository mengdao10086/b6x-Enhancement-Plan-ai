package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: loaded from: classes5.dex */
public class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24238a = z.b().b(z.f23806l);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f24239b = "key_umeng_sp_oaid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f24240c = "key_umeng_sp_oaid_required_time";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f24241d = "oaid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f24242e;

    public h(Context context) {
        super(f24241d);
        this.f24242e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f24242e.getSharedPreferences(f24238a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f24239b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
