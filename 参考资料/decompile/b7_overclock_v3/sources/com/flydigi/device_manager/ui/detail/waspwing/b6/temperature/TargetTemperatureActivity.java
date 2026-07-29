package com.flydigi.device_manager.ui.detail.waspwing.b6.temperature;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import c7.f;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import eu.davidea.flexibleadapter.b;
import hk.m;
import i9.a;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nTargetTemperatureActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TargetTemperatureActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b6/temperature/TargetTemperatureActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1864#2,3:92\n*S KotlinDebug\n*F\n+ 1 TargetTemperatureActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b6/temperature/TargetTemperatureActivity\n*L\n66#1:92,3\n*E\n"})
@Route(path = a.d.f31962r)
public final class TargetTemperatureActivity extends p implements b.z {

    @k
    public static final a I7 = new a(null);

    @k
    public static final String J7 = "key_overclock_able";

    @k
    public static final String K7 = "key_current_temperature";
    public b<TargetTemperatureItem> E7;
    public boolean G7;
    public f K2;

    @k
    public List<TargetTemperatureItem> F7 = CollectionsKt__CollectionsKt.E();
    public int H7 = Integer.MAX_VALUE;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final Intent a(@k Context context, boolean z10, int i10) {
            f0.p(context, "context");
            Intent intentPutExtra = new Intent(context, (Class<?>) TargetTemperatureActivity.class).putExtra(TargetTemperatureActivity.J7, z10).putExtra(TargetTemperatureActivity.K7, i10);
            f0.o(intentPutExtra, "Intent(context, TargetTe…currentTargetTemperature)");
            return intentPutExtra;
        }
    }

    @m
    @k
    public static final Intent j4(@k Context context, boolean z10, int i10) {
        return I7.a(context, z10, i10);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@l View view, int i10) {
        if (i10 == -1) {
            return false;
        }
        b<TargetTemperatureItem> bVar = this.E7;
        if (bVar == null) {
            f0.S("mAdapter");
            bVar = null;
        }
        bVar.M(i10);
        Intent intent = new Intent();
        Integer numZ = this.F7.get(i10).z();
        f0.o(numZ, "targetTemperatureItems[position].data");
        setResult(-1, intent.putExtra("key_result_data", numZ.intValue()));
        return true;
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_target_temperature;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        int i10 = 0;
        this.G7 = getIntent().getBooleanExtra(J7, false);
        this.H7 = getIntent().getIntExtra(K7, Integer.MAX_VALUE);
        this.F7 = CollectionsKt__CollectionsKt.L(new TargetTemperatureItem(18, false, this.G7), new TargetTemperatureItem(16, false, this.G7), new TargetTemperatureItem(14, false, this.G7), new TargetTemperatureItem(12, false, this.G7), new TargetTemperatureItem(10, true, this.G7), new TargetTemperatureItem(8, true, this.G7), new TargetTemperatureItem(6, true, this.G7));
        b<TargetTemperatureItem> bVar = new b<>(this.F7, this);
        bVar.J(1);
        this.E7 = bVar;
        f fVar = this.K2;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        fVar.f9998b.f36143b.setAdapter(bVar);
        f fVar2 = this.K2;
        if (fVar2 == null) {
            f0.S("viewBinding");
            fVar2 = null;
        }
        fVar2.f9998b.f36143b.setLayoutManager(new LinearLayoutManager(this));
        f fVar3 = this.K2;
        if (fVar3 == null) {
            f0.S("viewBinding");
            fVar3 = null;
        }
        fVar3.f9998b.f36143b.n(new xd.a(this, 1));
        f fVar4 = this.K2;
        if (fVar4 == null) {
            f0.S("viewBinding");
            fVar4 = null;
        }
        fVar4.f9998b.f36144c.C(false);
        f fVar5 = this.K2;
        if (fVar5 == null) {
            f0.S("viewBinding");
            fVar5 = null;
        }
        fVar5.f9998b.f36144c.n0(false);
        for (Object obj : this.F7) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            Integer numZ = ((TargetTemperatureItem) obj).z();
            int i12 = this.H7;
            if (numZ != null && numZ.intValue() == i12) {
                b<TargetTemperatureItem> bVar2 = this.E7;
                if (bVar2 == null) {
                    f0.S("mAdapter");
                    bVar2 = null;
                }
                bVar2.m(i10);
            }
            i10 = i11;
        }
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        f fVarC = f.c(getLayoutInflater());
        f0.o(fVarC, "inflate(layoutInflater)");
        this.K2 = fVarC;
        if (fVarC == null) {
            f0.S("viewBinding");
            fVarC = null;
        }
        setContentView(fVarC.getRoot());
    }
}
