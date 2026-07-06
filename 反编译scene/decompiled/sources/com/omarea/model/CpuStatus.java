package com.omarea.model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CpuStatus implements Serializable {
    public ArrayList<CpuClusterStatus> clusters = new ArrayList<>();
    public ArrayList<Boolean> coreOnline = null;
    public String gpuMinFreq = "";
    public String gpuMaxFreq = "";
    public String adrenoGovernor = "";
    public String cpusetBg = "";
    public String cpusetSysBg = "";
    public String cpusetFg = "";
    public String cpusetTop = "";
    public String cpusetRestricted = "";
}
