package a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.omarea.model.AppInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o21 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p21 f6974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f2190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AppInfo f2191a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o21(ImageView imageView, b62 b62Var, p21 p21Var, View view, AppInfo appInfo, int i) {
        super(2, b62Var);
        this.f2190a = imageView;
        this.f6974a = p21Var;
        this.f2189a = view;
        this.f2191a = appInfo;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        o21 o21Var = new o21(this.f2190a, b62Var, this.f6974a, this.f2189a, this.f2191a, this.c);
        o21Var.f2188a = (wd2) obj;
        return o21Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((o21) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Drawable drawableJ = this.f6974a.f7077a.j(this.f2191a);
        if (drawableJ != null && f92.a(this.f2190a.getTag(), t62.e(this.c))) {
            this.f2190a.post(new n21(this, drawableJ));
        }
        return m42.f6769a;
    }
}
