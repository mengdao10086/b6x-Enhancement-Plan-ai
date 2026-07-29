package rx_activity_result2;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import g.p0;

/* JADX INFO: loaded from: classes6.dex */
public class e extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntentSender f49236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Intent f49237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f49238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f49239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f49240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bundle f49241i;

    public e(IntentSender intentSender, @p0 Intent intent, int i10, int i11, int i12, @p0 Bundle bundle) {
        super(null);
        this.f49236d = intentSender;
        this.f49237e = intent;
        this.f49238f = i10;
        this.f49239g = i11;
        this.f49240h = i12;
        this.f49241i = bundle;
    }

    @Override // rx_activity_result2.d
    @p0
    public /* bridge */ /* synthetic */ Intent a() {
        return super.a();
    }

    @Override // rx_activity_result2.d
    public /* bridge */ /* synthetic */ OnResult c() {
        return super.c();
    }

    @Override // rx_activity_result2.d
    public /* bridge */ /* synthetic */ void e(OnResult onResult) {
        super.e(onResult);
    }

    public int f() {
        return this.f49240h;
    }

    public Intent g() {
        return this.f49237e;
    }

    public int h() {
        return this.f49238f;
    }

    public int i() {
        return this.f49239g;
    }

    public IntentSender j() {
        return this.f49236d;
    }

    public Bundle k() {
        return this.f49241i;
    }
}
