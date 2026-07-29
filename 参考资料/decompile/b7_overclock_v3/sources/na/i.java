package na;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class i extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f42009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DecimalFormat f42011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f42012d;

    public i() {
        this.f42009a = new String[]{"", "k", m0.k.f40564b, "b", "t"};
        this.f42010b = 5;
        this.f42012d = "";
        this.f42011c = new DecimalFormat("###E00");
    }

    @Override // na.l
    public String h(float f10) {
        return m(f10) + this.f42012d;
    }

    public int l() {
        return 0;
    }

    public final String m(double d10) {
        String str = this.f42011c.format(d10);
        int numericValue = Character.getNumericValue(str.charAt(str.length() - 1));
        String strReplaceAll = str.replaceAll("E[0-9][0-9]", this.f42009a[Integer.valueOf(Character.getNumericValue(str.charAt(str.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (strReplaceAll.length() <= this.f42010b && !strReplaceAll.matches("[0-9]+\\.[a-z]")) {
                return strReplaceAll;
            }
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 2) + strReplaceAll.substring(strReplaceAll.length() - 1);
        }
    }

    public void n(String str) {
        this.f42012d = str;
    }

    public void o(int i10) {
        this.f42010b = i10;
    }

    public void p(String[] strArr) {
        this.f42009a = strArr;
    }

    public i(String str) {
        this();
        this.f42012d = str;
    }
}
