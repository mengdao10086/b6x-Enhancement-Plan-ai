package a;

import a.d70;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i70 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d70.a f6381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d70 f1330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f1332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1334a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1335b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i70(ImageView imageView, b62 b62Var, d70 d70Var, d70.a aVar, String str) {
        super(2, b62Var);
        this.f1332a = imageView;
        this.f1330a = d70Var;
        this.f6381a = aVar;
        this.f1334a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        i70 i70Var = new i70(this.f1332a, b62Var, this.f1330a, this.f6381a, this.f1334a);
        i70Var.f1331a = (wd2) obj;
        return i70Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((i70) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.graphics.drawable.Drawable] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1331a;
            n92 n92Var = new n92();
            ?? H = this.f1330a.h(this.f6381a);
            n92Var.f6891a = H;
            if (((Drawable) H) != null && f92.a(this.f1332a.getTag(), this.f1334a)) {
                fg2 fg2VarC = qe2.c();
                h70 h70Var = new h70(this, n92Var, null);
                this.f1333a = wd2Var;
                this.f1335b = n92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, h70Var, this) == objC) {
                    return objC;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}
