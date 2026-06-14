package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f7387a = new byte[1792];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public char f2878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f2880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2881a;
    public int b;

    static {
        for (int i = 0; i < 1792; i++) {
            f7387a[i] = Character.getDirectionality(i);
        }
    }

    public se(CharSequence charSequence, boolean z) {
        this.f2880a = charSequence;
        this.f2881a = z;
        this.f2879a = charSequence.length();
    }

    public static byte c(char c) {
        return c < 1792 ? f7387a[c] : Character.getDirectionality(c);
    }

    public byte a() {
        char cCharAt = this.f2880a.charAt(this.b - 1);
        this.f2878a = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(this.f2880a, this.b);
            this.b -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.b--;
        byte bC = c(this.f2878a);
        if (!this.f2881a) {
            return bC;
        }
        char c = this.f2878a;
        return c == '>' ? h() : c == ';' ? f() : bC;
    }

    public byte b() {
        char cCharAt = this.f2880a.charAt(this.b);
        this.f2878a = cCharAt;
        if (Character.isHighSurrogate(cCharAt)) {
            int iCodePointAt = Character.codePointAt(this.f2880a, this.b);
            this.b += Character.charCount(iCodePointAt);
            return Character.getDirectionality(iCodePointAt);
        }
        this.b++;
        byte bC = c(this.f2878a);
        if (!this.f2881a) {
            return bC;
        }
        char c = this.f2878a;
        return c == '<' ? i() : c == '&' ? g() : bC;
    }

    public int d() {
        this.b = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (this.b < this.f2879a && i == 0) {
            byte b = b();
            if (b != 0) {
                if (b == 1 || b == 2) {
                    if (i3 == 0) {
                        return 1;
                    }
                } else if (b != 9) {
                    switch (b) {
                        case 14:
                        case 15:
                            i3++;
                            i2 = -1;
                            continue;
                        case 16:
                        case 17:
                            i3++;
                            i2 = 1;
                            continue;
                        case 18:
                            i3--;
                            i2 = 0;
                            continue;
                    }
                }
            } else if (i3 == 0) {
                return -1;
            }
            i = i3;
        }
        if (i == 0) {
            return 0;
        }
        if (i2 != 0) {
            return i2;
        }
        while (this.b > 0) {
            switch (a()) {
                case 14:
                case 15:
                    if (i == i3) {
                        return -1;
                    }
                    break;
                case 16:
                case 17:
                    if (i == i3) {
                        return 1;
                    }
                    break;
                case 18:
                    i3++;
                    continue;
            }
            i3--;
        }
        return 0;
    }

    public int e() {
        this.b = this.f2879a;
        int i = 0;
        while (true) {
            int i2 = i;
            while (this.b > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i == 0) {
                        return -1;
                    }
                    if (i2 == 0) {
                        break;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        break;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    public final byte f() {
        char cCharAt;
        int i = this.b;
        do {
            int i2 = this.b;
            if (i2 <= 0) {
                break;
            }
            CharSequence charSequence = this.f2880a;
            int i3 = i2 - 1;
            this.b = i3;
            cCharAt = charSequence.charAt(i3);
            this.f2878a = cCharAt;
            if (cCharAt == '&') {
                return (byte) 12;
            }
        } while (cCharAt != ';');
        this.b = i;
        this.f2878a = ';';
        return (byte) 13;
    }

    public final byte g() {
        char cCharAt;
        do {
            int i = this.b;
            if (i >= this.f2879a) {
                return (byte) 12;
            }
            CharSequence charSequence = this.f2880a;
            this.b = i + 1;
            cCharAt = charSequence.charAt(i);
            this.f2878a = cCharAt;
        } while (cCharAt != ';');
        return (byte) 12;
    }

    public final byte h() {
        char cCharAt;
        int i = this.b;
        while (true) {
            int i2 = this.b;
            if (i2 <= 0) {
                break;
            }
            CharSequence charSequence = this.f2880a;
            int i3 = i2 - 1;
            this.b = i3;
            char cCharAt2 = charSequence.charAt(i3);
            this.f2878a = cCharAt2;
            if (cCharAt2 == '<') {
                return (byte) 12;
            }
            if (cCharAt2 == '>') {
                break;
            }
            if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                char c = this.f2878a;
                do {
                    int i4 = this.b;
                    if (i4 > 0) {
                        CharSequence charSequence2 = this.f2880a;
                        int i5 = i4 - 1;
                        this.b = i5;
                        cCharAt = charSequence2.charAt(i5);
                        this.f2878a = cCharAt;
                    }
                } while (cCharAt != c);
            }
        }
        this.b = i;
        this.f2878a = '>';
        return (byte) 13;
    }

    public final byte i() {
        char cCharAt;
        int i = this.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= this.f2879a) {
                this.b = i;
                this.f2878a = '<';
                return (byte) 13;
            }
            CharSequence charSequence = this.f2880a;
            this.b = i2 + 1;
            char cCharAt2 = charSequence.charAt(i2);
            this.f2878a = cCharAt2;
            if (cCharAt2 == '>') {
                return (byte) 12;
            }
            if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                char c = this.f2878a;
                do {
                    int i3 = this.b;
                    if (i3 < this.f2879a) {
                        CharSequence charSequence2 = this.f2880a;
                        this.b = i3 + 1;
                        cCharAt = charSequence2.charAt(i3);
                        this.f2878a = cCharAt;
                    }
                } while (cCharAt != c);
            }
        }
    }
}
