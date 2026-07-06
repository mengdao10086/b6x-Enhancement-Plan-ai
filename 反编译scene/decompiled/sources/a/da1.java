package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class da1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl f524a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da1(TextView textView, b62 b62Var, ActivityCpuControl activityCpuControl) {
        super(2, b62Var);
        this.f523a = textView;
        this.f524a = activityCpuControl;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        da1 da1Var = new da1(this.f523a, b62Var, this.f524a);
        da1Var.f5878a = (wd2) obj;
        return da1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((da1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (y60.f7952a.c("/dev/stune")) {
            this.f523a.setOnClickListener(new ca1(this));
        } else {
            this.f523a.setVisibility(8);
        }
        return m42.f6769a;
    }
}
