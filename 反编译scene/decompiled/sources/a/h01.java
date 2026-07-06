package a;

import a.f01;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.omarea.model.AppInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h01 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f01.a f6259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f01 f1080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f1082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AppInfo f1083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1085a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h01(ImageView imageView, b62 b62Var, f01 f01Var, AppInfo appInfo, String str, f01.a aVar) {
        super(2, b62Var);
        this.f1082a = imageView;
        this.f1080a = f01Var;
        this.f1083a = appInfo;
        this.f1085a = str;
        this.f6259a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        h01 h01Var = new h01(this.f1082a, b62Var, this.f1080a, this.f1083a, this.f1085a, this.f6259a);
        h01Var.f1081a = (wd2) obj;
        return h01Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((h01) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1081a;
            fe2<Drawable> fe2VarL = this.f1080a.f827a.l(this.f1083a.getPackageName());
            this.f1084a = wd2Var;
            this.b = 1;
            obj = fe2VarL.s(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        Drawable drawableH = (Drawable) obj;
        if (drawableH == null) {
            drawableH = this.f1080a.f828a.h(this.f1085a);
        }
        if (drawableH == null) {
            drawableH = this.f1080a.f830a;
        }
        if (f92.a(this.f6259a.P(), this.f1085a)) {
            this.f1082a.post(new g01(this, drawableH));
        }
        return m42.f6769a;
    }
}
