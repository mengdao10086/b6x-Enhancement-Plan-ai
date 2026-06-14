package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xx1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ py1 f7928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView[] f3630a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx1(TextView[] textViewArr, py1 py1Var, n92 n92Var) {
        super(0);
        this.f3630a = textViewArr;
        this.f7928a = py1Var;
    }

    public final void a() {
        this.f7928a.b = 0;
        for (TextView textView : this.f3630a) {
            textView.setAlpha(0.3f);
        }
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
