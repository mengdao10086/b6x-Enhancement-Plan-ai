package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Beta
@GwtCompatible
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i10, boolean z10) {
        this.host = str;
        this.port = i10;
        this.hasBracketlessColons = z10;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort hostAndPortFromString = fromString(str);
        Preconditions.checkArgument(!hostAndPortFromString.hasPort(), "Host has a port: %s", str);
        return hostAndPortFromString;
    }

    public static HostAndPort fromParts(String str, int i10) {
        Preconditions.checkArgument(isValidPort(i10), "Port out of range: %s", i10);
        HostAndPort hostAndPortFromString = fromString(str);
        Preconditions.checkArgument(!hostAndPortFromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(hostAndPortFromString.host, i10, hostAndPortFromString.hasBracketlessColons);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.common.net.HostAndPort fromString(java.lang.String r6) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r6)
            java.lang.String r0 = "["
            boolean r0 = r6.startsWith(r0)
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L17
            java.lang.String[] r0 = getHostAndPortFromBracketedHost(r6)
            r4 = r0[r3]
            r0 = r0[r2]
            goto L35
        L17:
            r0 = 58
            int r4 = r6.indexOf(r0)
            if (r4 < 0) goto L30
            int r5 = r4 + 1
            int r0 = r6.indexOf(r0, r5)
            if (r0 != r1) goto L30
            java.lang.String r4 = r6.substring(r3, r4)
            java.lang.String r0 = r6.substring(r5)
            goto L35
        L30:
            if (r4 < 0) goto L33
            r3 = 1
        L33:
            r0 = 0
            r4 = r6
        L35:
            boolean r5 = com.google.common.base.Strings.isNullOrEmpty(r0)
            if (r5 != 0) goto L6c
            java.lang.String r1 = "+"
            boolean r1 = r0.startsWith(r1)
            r1 = r1 ^ r2
            java.lang.String r2 = "Unparseable port number: %s"
            com.google.common.base.Preconditions.checkArgument(r1, r2, r6)
            int r1 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L55
            boolean r0 = isValidPort(r1)
            java.lang.String r2 = "Port number out of range: %s"
            com.google.common.base.Preconditions.checkArgument(r0, r2, r6)
            goto L6c
        L55:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unparseable port number: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L6c:
            com.google.common.net.HostAndPort r6 = new com.google.common.net.HostAndPort
            r6.<init>(r4, r1, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.HostAndPort.fromString(java.lang.String):com.google.common.net.HostAndPort");
    }

    private static String[] getHostAndPortFromBracketedHost(String str) {
        Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int iIndexOf = str.indexOf(58);
        int iLastIndexOf = str.lastIndexOf(93);
        Preconditions.checkArgument(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", str);
        String strSubstring = str.substring(1, iLastIndexOf);
        int i10 = iLastIndexOf + 1;
        if (i10 == str.length()) {
            return new String[]{strSubstring, ""};
        }
        Preconditions.checkArgument(str.charAt(i10) == ':', "Only a colon may follow a close bracket: %s", str);
        int i11 = iLastIndexOf + 2;
        for (int i12 = i11; i12 < str.length(); i12++) {
            Preconditions.checkArgument(Character.isDigit(str.charAt(i12)), "Port must be numeric: %s", str);
        }
        return new String[]{strSubstring, str.substring(i11)};
    }

    private static boolean isValidPort(int i10) {
        return i10 >= 0 && i10 <= 65535;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return Objects.equal(this.host, hostAndPort.host) && this.port == hostAndPort.port;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i10) {
        return hasPort() ? this.port : i10;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb2.append('[');
            sb2.append(this.host);
            sb2.append(']');
        } else {
            sb2.append(this.host);
        }
        if (hasPort()) {
            sb2.append(':');
            sb2.append(this.port);
        }
        return sb2.toString();
    }

    public HostAndPort withDefaultPort(int i10) {
        Preconditions.checkArgument(isValidPort(i10));
        return hasPort() ? this : new HostAndPort(this.host, i10, this.hasBracketlessColons);
    }
}
