package a;

import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$socketReplyDecode$1", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class o40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i50 f6980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2197a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o40(ArrayList arrayList, i50 i50Var, b62 b62Var) {
        super(2, b62Var);
        this.f2197a = arrayList;
        this.f6980a = i50Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        o40 o40Var = new o40(this.f2197a, this.f6980a, b62Var);
        o40Var.f2196a = (wd2) obj;
        return o40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((o40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        StringBuilder sb;
        String str;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        for (String str2 : this.f2197a) {
            try {
                g30 g30Var = new g30(str2);
                String strI = g30Var.i("tag");
                String strI2 = g30Var.i("type");
                String strI3 = g30Var.i("body");
                if (strI != null) {
                    int iHashCode = strI.hashCode();
                    if (iHashCode != 69) {
                        if (iHashCode != 77) {
                            if (iHashCode == 81 && strI.equals("Q")) {
                                int i = -1;
                                try {
                                    f92.c(strI3, "body");
                                    i = Integer.parseInt(strI3);
                                } catch (Exception unused) {
                                    Log.e("Scene", "Daemon-Shell ExitCode " + strI3);
                                }
                                this.f6980a.f(i);
                            }
                        } else if (strI.equals("M")) {
                            try {
                                i50 i50Var = this.f6980a;
                                f92.c(strI2, "type");
                                f92.c(strI3, "body");
                                i50Var.e(strI2, strI3);
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder();
                                str = "Daemon-Shell onMessageOutput ";
                                sb.append(str);
                                sb.append(e.getMessage());
                                Log.e("Scene", sb.toString());
                            }
                        }
                    } else if (strI.equals("E")) {
                        try {
                            i50 i50Var2 = this.f6980a;
                            f92.c(strI2, "type");
                            f92.c(strI3, "body");
                            i50Var2.b(strI2, strI3);
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            str = "Daemon-Shell onErrorOutput ";
                            sb.append(str);
                            sb.append(e.getMessage());
                            Log.e("Scene", sb.toString());
                        }
                    }
                }
            } catch (Exception unused2) {
                Log.e("@Scene", "[SocketReplyDecode] " + str2);
            }
        }
        return m42.f6769a;
    }
}
