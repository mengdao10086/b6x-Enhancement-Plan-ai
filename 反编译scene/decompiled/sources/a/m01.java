package a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.omarea.model.AppInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m01 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p01 f6755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f1877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AppInfo f1878a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m01(AppInfo appInfo, ImageView imageView, b62 b62Var, p01 p01Var, int i) {
        super(2, b62Var);
        this.f1878a = appInfo;
        this.f1877a = imageView;
        this.f6755a = p01Var;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        m01 m01Var = new m01(this.f1878a, this.f1877a, b62Var, this.f6755a, this.c);
        m01Var.f1876a = (wd2) obj;
        return m01Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((m01) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Drawable drawableJ = this.f6755a.f7070a.j(this.f1878a);
        if (drawableJ != null && f92.a(this.f1877a.getTag(), t62.e(this.c))) {
            this.f1877a.post(new l01(this, drawableJ));
        }
        return m42.f6769a;
    }
}
