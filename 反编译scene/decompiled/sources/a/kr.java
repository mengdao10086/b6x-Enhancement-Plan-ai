package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kr extends bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mr f6632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f1681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1682a;
    public final /* synthetic */ Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1683b;
    public final /* synthetic */ Object c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1684c;

    public kr(mr mrVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f6632a = mrVar;
        this.f1681a = obj;
        this.f1682a = arrayList;
        this.b = obj2;
        this.f1683b = arrayList2;
        this.c = obj3;
        this.f1684c = arrayList3;
    }

    @Override // a.bs, a.zr
    public void c(as asVar) {
        Object obj = this.f1681a;
        if (obj != null) {
            this.f6632a.q(obj, this.f1682a, null);
        }
        Object obj2 = this.b;
        if (obj2 != null) {
            this.f6632a.q(obj2, this.f1683b, null);
        }
        Object obj3 = this.c;
        if (obj3 != null) {
            this.f6632a.q(obj3, this.f1684c, null);
        }
    }

    @Override // a.zr
    public void e(as asVar) {
        asVar.P(this);
    }
}
