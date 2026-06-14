package a;

import android.content.Context;
import com.omarea.ui.charge.ChargeTempView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h41 extends g92 implements v72<w21> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChargeTempView f6274a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h41(ChargeTempView chargeTempView) {
        super(0);
        this.f6274a = chargeTempView;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final w21 i() {
        Context context = this.f6274a.getContext();
        f92.c(context, "this.context");
        return new w21(context);
    }
}
