package com.flydigi.device_manager;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public final class BaseGamepadFragment$onViewCreated$1 extends Lambda implements ik.l<Boolean, z1> {
    public final /* synthetic */ BaseGamepadFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseGamepadFragment$onViewCreated$1(BaseGamepadFragment baseGamepadFragment) {
        super(1);
        this.this$0 = baseGamepadFragment;
    }

    public static final void f(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public final void d(Boolean it2) {
        f0.o(it2, "it");
        if (it2.booleanValue()) {
            o5.m.l(DataConstant.SP_FLOAT, 2).B(DataConstant.SP_FLOAT_KEY_DRIVER_VERSION_RELEASED, v5.c.f() ? v5.c.f52709a : v5.c.f52710b);
            n5.c cVar = n5.c.f41882a;
            Context contextR4 = this.this$0.R4();
            f0.o(contextR4, "requireContext()");
            if (cVar.a(contextR4)) {
                return;
            }
            new FZDialog.a().t(this.this$0.c3(R.string.notice)).j(this.this$0.c3(R.string.device_storage_permission_grant_failed_with_no_saf_exited)).q(this.this$0.c3(R.string.device_just_know)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.m
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    BaseGamepadFragment$onViewCreated$1.f(dialogFragment);
                }
            }).u(this.this$0.U1(), "saf_not_supported");
        }
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(Boolean bool) {
        d(bool);
        return z1.f38230a;
    }
}
