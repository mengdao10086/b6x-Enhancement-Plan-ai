package yn;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f57444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuffer f57445d;

    public f(String str) {
        this(str, ',');
    }

    public f(String str, char c10) {
        this.f57445d = new StringBuffer();
        this.f57442a = str;
        this.f57443b = -1;
        this.f57444c = c10;
    }

    public boolean a() {
        return this.f57443b != this.f57442a.length();
    }

    public String b() {
        if (this.f57443b == this.f57442a.length()) {
            return null;
        }
        int i10 = this.f57443b + 1;
        this.f57445d.setLength(0);
        boolean z10 = false;
        boolean z11 = false;
        while (i10 != this.f57442a.length()) {
            char cCharAt = this.f57442a.charAt(i10);
            if (cCharAt != '\"') {
                if (!z10 && !z11) {
                    if (cCharAt == '\\') {
                        this.f57445d.append(cCharAt);
                        z10 = true;
                    } else {
                        if (cCharAt == this.f57444c) {
                            break;
                        }
                        this.f57445d.append(cCharAt);
                    }
                }
                i10++;
            } else if (!z10) {
                z11 = !z11;
            }
            this.f57445d.append(cCharAt);
            z10 = false;
            i10++;
        }
        this.f57443b = i10;
        return this.f57445d.toString();
    }
}
