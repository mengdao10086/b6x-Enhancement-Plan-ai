package a;

import android.os.Handler;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ml1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f1946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ m92 f1947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nl1 f1948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Handler f1949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1950a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ml1(nl1 nl1Var, Handler handler, m92 m92Var, l92 l92Var, i92 i92Var, TextView textView) {
        super(0);
        this.f1948a = nl1Var;
        this.f1949a = handler;
        this.f1947a = m92Var;
        this.f1946a = l92Var;
        this.f6820a = i92Var;
        this.f1950a = textView;
    }

    public final void a() {
        this.f1949a.post(new ll1(this));
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
