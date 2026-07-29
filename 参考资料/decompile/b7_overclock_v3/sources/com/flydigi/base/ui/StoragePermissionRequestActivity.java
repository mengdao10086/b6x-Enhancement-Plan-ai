package com.flydigi.base.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.g;
import com.blankj.utilcode.util.PermissionUtils;
import com.flydigi.base.R;
import com.flydigi.base.ui.StoragePermissionRequestActivity;
import com.flydigi.base.widget.FZDialog;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import w3.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class StoragePermissionRequestActivity extends g {

    @k
    public static final String K0 = "extra_permission_for";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @k
    public static final a f13377k0 = new a(null);

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f13378k1 = 0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f13379v1 = 1;
    public int C;
    public boolean D;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ Intent b(a aVar, Context context, Integer num, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                num = 0;
            }
            return aVar.a(context, num);
        }

        @m
        @k
        public final Intent a(@k Context Context, @l Integer num) {
            f0.p(Context, "Context");
            Intent intent = new Intent(Context, (Class<?>) StoragePermissionRequestActivity.class);
            intent.putExtra(StoragePermissionRequestActivity.K0, num);
            return intent;
        }
    }

    public static final class b implements PermissionUtils.e {
        public b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.e
        public void a() {
            StoragePermissionRequestActivity.this.setResult(-1);
            StoragePermissionRequestActivity.this.finish();
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.e
        public void b() {
            StoragePermissionRequestActivity.this.setResult(0);
            StoragePermissionRequestActivity.this.finish();
        }
    }

    @m
    @k
    public static final Intent J3(@k Context context, @l Integer num) {
        return f13377k0.a(context, num);
    }

    public static final void O3(StoragePermissionRequestActivity this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    public static final void P3(StoragePermissionRequestActivity this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(dialogFragment, "dialogFragment");
        dialogFragment.H5();
        this$0.L3();
    }

    public final int K3() {
        return this.C;
    }

    public final void L3() {
        PermissionUtils.F(c.f53853i).r(new b()).I();
    }

    public final void M3(int i10) {
        this.C = i10;
    }

    public final void N3() {
        if (PermissionUtils.z(c.f53853i) || n3().s0("showStoragePermissionRequestDialog") != null || this.D) {
            return;
        }
        new FZDialog.a().t(getString(R.string.base_storage_permission_title)).j(getString(this.C == 1 ? R.string.base_storage_permission_content_driver : R.string.base_storage_permission_content)).d(getString(R.string.refuse)).c(new FZDialog.c() { // from class: n5.a
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                StoragePermissionRequestActivity.O3(this.f41880a, dialogFragment);
            }
        }).g(getString(R.string.base_storage_permission_to_grant_permission)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: n5.b
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                StoragePermissionRequestActivity.P3(this.f41881a, dialogFragment);
            }
        }).a().Z5(n3(), "showStoragePermissionRequestDialog");
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        this.C = getIntent().getIntExtra(K0, 0);
        N3();
    }
}
