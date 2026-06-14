package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class yb2 extends xb2 {
    public static final StringBuilder g(StringBuilder sb, Object... objArr) {
        f92.d(sb, "$this$append");
        f92.d(objArr, "value");
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }

    public static final StringBuilder h(StringBuilder sb, String... strArr) {
        f92.d(sb, "$this$append");
        f92.d(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }
}
