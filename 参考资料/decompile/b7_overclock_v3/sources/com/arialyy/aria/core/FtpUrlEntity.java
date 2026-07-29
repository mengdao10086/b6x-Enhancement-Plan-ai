package com.arialyy.aria.core;

import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class FtpUrlEntity implements Cloneable {
    public String account;
    public String hostName;
    public IdEntity idEntity;
    public String password;
    public String port;
    public String remotePath;
    public String scheme;
    public String url;
    public String user;
    public InetAddress validAddr;
    public boolean isFtps = false;
    public boolean needLogin = false;
    public String protocol = "TLS";
    public boolean isImplicit = true;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FtpUrlEntity m0clone() {
        try {
            return (FtpUrlEntity) super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
