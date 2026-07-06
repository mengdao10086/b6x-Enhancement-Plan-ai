package com.omarea.model;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ProcessInfo {
    public int PPid;
    public String cGroup;
    public float cpu;
    public String cpuSet;
    public String cpusAllowed;
    public String ctxtSwitches;
    public long mem;
    public String name;
    public String oomAdj;
    public String oomScore;
    public String oomScoreAdj;
    public int pid;
    public long res;
    public long rss;
    public long shr;
    public long swap;
    public String user;
    public String state = "";
    public String command = "";
    public String cmdline = "";
    public String friendlyName = "";

    public float getCpu() {
        return this.cpu;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getState() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.model.ProcessInfo.getState():java.lang.String");
    }
}
