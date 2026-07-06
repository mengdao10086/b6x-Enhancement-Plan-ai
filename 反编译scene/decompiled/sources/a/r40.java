package a;

import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$socketSend$r$1", f = "Daemon.kt", l = {1459}, m = "invokeSuspend")
public final class r40 extends d72 implements k82<wd2, b62<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2709a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2710b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f2711b;
    public final /* synthetic */ Object c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ String f2712c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r40(n92 n92Var, String str, Object obj, String str2, String str3, b62 b62Var) {
        super(2, b62Var);
        this.f7269a = n92Var;
        this.f2709a = str;
        this.c = obj;
        this.f2711b = str2;
        this.f2712c = str3;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        r40 r40Var = new r40(this.f7269a, this.f2709a, this.c, this.f2711b, this.f2712c, b62Var);
        r40Var.f2707a = (wd2) obj;
        return r40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super String> b62Var) {
        return ((r40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [T, a.tc2, a.uc2] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            this.f2708a = this.f2707a;
            this.f2710b = this;
            this.b = 1;
            ?? uc2Var = new uc2(q62.b(this), 1);
            uc2Var.B();
            this.f7269a.f6891a = uc2Var;
            e50.z(e50.f677a).put(this.f2709a, new q40(uc2Var));
            Object obj2 = this.c;
            if (obj2 instanceof v50) {
                e50 e50Var = e50.f677a;
                e50Var.n1((v50) obj2, e50Var.k1(this.f2709a, this.f2711b, this.f2712c));
            } else {
                e50 e50Var2 = e50.f677a;
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.nio.channels.SocketChannel");
                }
                e50Var2.o1((SocketChannel) obj2, e50Var2.k1(this.f2709a, this.f2711b, this.f2712c));
            }
            obj = uc2Var.z();
            if (obj == r62.c()) {
                z62.c(this);
            }
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return obj;
    }
}
