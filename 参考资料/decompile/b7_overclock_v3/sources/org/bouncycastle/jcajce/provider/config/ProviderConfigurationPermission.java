package org.bouncycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class ProviderConfigurationPermission extends BasicPermission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45103a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f45104b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f45105c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f45106d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f45107e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45108f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f45109g = 63;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f45110h = "threadlocalecimplicitlyca";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f45111i = "ecimplicitlyca";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f45112j = "threadlocaldhdefaultparams";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f45113k = "dhdefaultparams";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f45114l = "acceptableeccurves";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f45115m = "additionalecparameters";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f45116n = "all";
    private final String actions;
    private final int permissionMask;

    public ProviderConfigurationPermission(String str) {
        super(str);
        this.actions = "all";
        this.permissionMask = 63;
    }

    public ProviderConfigurationPermission(String str, String str2) {
        super(str, str2);
        this.actions = str2;
        this.permissionMask = a(str2);
    }

    public final int a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.k(str), " ,");
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals(f45110h)) {
                i10 |= 1;
            } else if (strNextToken.equals(f45111i)) {
                i10 |= 2;
            } else if (strNextToken.equals(f45112j)) {
                i10 |= 4;
            } else if (strNextToken.equals(f45113k)) {
                i10 |= 8;
            } else if (strNextToken.equals(f45114l)) {
                i10 |= 16;
            } else if (strNextToken.equals(f45115m)) {
                i10 |= 32;
            } else if (strNextToken.equals("all")) {
                i10 |= 63;
            }
        }
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProviderConfigurationPermission)) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission) obj;
        return this.permissionMask == providerConfigurationPermission.permissionMask && getName().equals(providerConfigurationPermission.getName());
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.actions;
    }

    public int hashCode() {
        return getName().hashCode() + this.permissionMask;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission) || !getName().equals(permission.getName())) {
            return false;
        }
        int i10 = this.permissionMask;
        int i11 = ((ProviderConfigurationPermission) permission).permissionMask;
        return (i10 & i11) == i11;
    }
}
