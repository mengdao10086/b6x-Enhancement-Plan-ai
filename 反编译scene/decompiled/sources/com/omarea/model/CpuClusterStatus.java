package com.omarea.model;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CpuClusterStatus implements Serializable {
    public String min_freq = "";
    public String max_freq = "";
    public String governor = "";
    public HashMap<String, String> governor_params = null;
}
