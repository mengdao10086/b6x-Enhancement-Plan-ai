package a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class en0 extends g92 implements v72<String[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fn0 f6023a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en0(fn0 fn0Var) {
        super(0);
        this.f6023a = fn0Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String[] i() {
        List<String> listK = this.f6023a.k();
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : listK) {
            if (ec2.C((String) obj, "zram", false, 2, null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        for (String str : arrayList) {
            int iS = ec2.S(str, "/", 0, false, 6, null);
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(iS);
            f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
            arrayList2.add((String) i52.A(ec2.d0((CharSequence) i52.A(new nb2(" +").h(strSubstring, 0)), new String[]{"\\"}, false, 0, 6, null)));
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
