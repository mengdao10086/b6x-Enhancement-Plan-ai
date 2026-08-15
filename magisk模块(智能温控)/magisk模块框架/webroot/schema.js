/* ============================================================
 * B6X 智能温控 WebUI — 参数定义 (schema)
 * 键范围以 tempctrl.c 的 clamp() 为准；说明摘自 profile.conf 注释
 * 注意：改 profile.conf 加/改参数时，必须同步更新本文件
 * ============================================================ */
window.B6X_SCHEMA = {
  moduleId: "b6x-Enhancement-Plan",
  configPath: "/data/adb/modules/b6x-Enhancement-Plan/profile.conf",
  statusB6: "/data/local/tmp/tempctrl_b6x.status",
  statusB7: "/data/local/tmp/tempctrl_b7x.status",
  gearFile: "/data/local/tmp/tempctrl.gear",
  dataFile: "/data/local/tmp/tempctrl_webui.data",  // C 每 1s 写入的曲线数据文件
  chartWindowOptions: [120, 180, 240, 360, 480, 720],

  groups: [
    // [0] 日志 & 调试（置顶，调试便捷）
    {
      id: "g1", title: "[0] 日志 & 调试", master: "DEBUG_ENABLED",
      headerSwitch: "DEBUG_ENABLED",
      keys: [],
      subKeys: ["DEBUG_SENSOR", "DEBUG_EMERG", "DEBUG_BATT", "DEBUG_EXEC",
                "DEBUG_CONN", "DEBUG_CONFIG", "DEBUG_MAIN", "DEBUG_PID", "DEBUG_LAUNCH", "DEBUG_FAN"]
    },
    // [1] 总开关：组头开关 PERF_ENABLED + 通用参数子面板（复用开关+子面板机制）
    {
      id: "g0", title: "[1] 总开关", master: "PERF_ENABLED",
      headerSwitch: "PERF_ENABLED",
      keys: [],
      subKeys: ["RATE_LIMIT_FAN_UP", "RATE_LIMIT_FAN_DOWN",
                "RATE_LIMIT_COLD", "RATE_LIMIT_TEMP", "BATT_BASELINE",
                "COLD_MAP", "HOT_MAP", "RPM_SMOOTH_ALPHA", "FAN_RPM",
                "BATT_SKIP_MAX", "HOT_DERATE"]
    },
    // [2] 控制模式：PID 与 Gear 同一窗口。组头开关 CTRL_MODE 仅切换模式（1=PID / 0=Gear），
    // 不控制折叠；展开/折叠由 PERF_ENABLED 总开关驱动（master）。组内按模式切换显示参数面板
    {
      id: "g4", title: "[2] 控制模式", master: "PERF_ENABLED",
      headerSwitch: "CTRL_MODE",
      keys: [],
      modePanels: [
        { when: "1", title: "PID 模式控制",
          keys: ["PID_KP", "PID_KI", "PID_KI_MEM", "PID_KI_VAR", "PID_KD", "PID_KD_MEM",
                 "PID_KD_NEAR",
                 "PID_INPUT_FILTER", "PID_ALPHA",
                 "PID_CPU_COMP", "PID_OUT_FILTER", "PID_COLD"] },
        { when: "0", title: "Gear 模式控制",
          keys: ["BATT_BOUNDARY", "BATT_COOLDOWN_CYCLES", "GEAR_PREDICT_WEIGHT",
                 "GEAR_PREDICT_WIN", "GEAR_PREDICT_RISE", "GEAR_PREDICT_ALPHA",
                 "CURRENT_GEAR_MODE",
                 "CURRENT_GEAR_MULT", "CURRENT_GEAR_SMOOTH_ALPHA", "CURRENT_GEAR_MIN",
                 "REV_COMP", "REV_COMP_T", "REV_COMP_COOLDOWN", "TREND_RESET_THRESHOLD",
                 "EMERG_CPU_ENABLED", "CPU_EMERG", "CPU_FILTER_ALPHA", "EMERG_MODE",
                 "EMERG_FORCED", "EMERG_EXIT_CAP_OFFSET", "EMERG_STEP",
                 "EMERG_EXIT_BATT_THRESHOLD", "EMERG_RECOVERY_MULT",
                 "EMERG_RECOVERY_PHASE_CYCLES",
                 "GEAR_CONFIG_ENABLED", "GEAR_AUTO_FAN"],
          gearTables: ["GEAR_B6X_", "GEAR_B7X_"] }
      ]
    },
    // [3] sysfs 路径与缩放：独立大类（SYSFS_ENABLED 开关控制加载）
    {
      id: "g2", title: "[3] sysfs 路径与缩放", headerSwitch: "SYSFS_ENABLED",
      keys: [],
      subKeys: ["BATT_TEMP_PATH", "BATT_TEMP_DIVISOR", "BATT_CURRENT_PATH",
                "BATT_CURRENT_DIVISOR", "CPU_TEMP_PATH_FMT", "CPU_TEMP_DIVISOR",
                "CPU_ZONE", "CPU_ZONE_RESCAN", "LOG_FILE", "LOG_MAX"]
    },
    // [4] 自动拉起散热器 app：独立分组，开关常显在组头；组内含可编辑参数 APP_WATCHDOG（可折叠/展开）
    {
      id: "g3", title: "[4] 自动拉起散热器 app", headerSwitch: "APP_LAUNCH_ENABLED",
      keys: ["APP_WATCHDOG"]
    }
  ],

  keys: {
    // ---- [0] ----
    PERF_ENABLED: { type: "switch", label: "性能参数总开关", desc: "" },

    // ---- [1] ----
    DEBUG_ENABLED: { type: "switch", label: "调试日志总开关", desc: "" },
    DEBUG_SENSOR: { type: "switch", label: "传感器读数", desc: "电池/CPU/电流读数调试日志" },
    DEBUG_EMERG: { type: "switch", label: "紧急干预", desc: "紧急等级计算调试日志" },
    DEBUG_BATT: { type: "switch", label: "电池温度控制", desc: "电池温度调档/恢复期/反补调试日志" },
    DEBUG_EXEC: { type: "switch", label: "执行下发", desc: "速率限制与广播下发调试日志" },
    DEBUG_CONN: { type: "switch", label: "连接状态", desc: "App 存活/BLE/重连调试日志" },
    DEBUG_CONFIG: { type: "switch", label: "配置加载", desc: "配置文件解析过程调试日志" },
    DEBUG_MAIN: { type: "switch", label: "主循环", desc: "主循环流程跟踪调试日志" },
    DEBUG_PID: { type: "switch", label: "PID", desc: "PID 模式调试日志（需开 DEBUG_ENABLED）" },
    DEBUG_LAUNCH: { type: "switch", label: "自动拉起", value: "0",
      desc: "自动拉起散热器 app 的决策过程（目标选择/回退/跳过），拉起成功/失败始终输出" },
    DEBUG_FAN: { type: "switch", label: "风扇", value: "0",
      desc: "风扇转速计算/限速/下发调试日志" },

    // ---- [7] 路径与缩放 ----
    SYSFS_ENABLED: { type: "switch", label: "sysfs 路径与缩放开关", desc: "" },
    BATT_TEMP_PATH: { type: "path", label: "电池温度 sysfs",
      desc: "不同机型位置可能不同，可自行修改" },
    BATT_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "电池温度缩放系数",
      desc: "原始值 ÷ 缩放系数 → 0.1°C" },
    BATT_CURRENT_PATH: { type: "path", label: "电池电流 sysfs",
      desc: "不同机型位置可能不同，可自行修改" },
    BATT_CURRENT_DIVISOR: { type: "int", min: 1, max: 100000, label: "电池电流缩放系数",
      desc: "原始值 ÷ 缩放系数 → µA" },
    CPU_TEMP_PATH_FMT: { type: "path", label: "CPU 温度 sysfs 模板",
      desc: "%d 会替换为目标 thermal_zone 编号" },
    CPU_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "CPU 温度缩放系数",
      desc: "原始值 ÷ 缩放系数 → 0.1°C" },
    CPU_ZONE: { type: "multi", fields: [{ label: "最小 zone", min: 0, max: 99 }, { label: "最大 zone", min: 0, max: 99 }],
      label: "CPU thermal_zone 扫描范围", desc: "首次扫描范围（0~99），K60 推荐 30~40" },
    LOG_FILE: { type: "path", label: "日志文件路径",
      desc: "空则自动根据二进制名在 /cache/ 生成" },
    LOG_MAX: { type: "int", min: 0, max: 1048576, label: "日志上限（字节）",
      desc: "0=关闭日志；默认 7936。超限时 ftruncate 截断保留尾部（从完整行首起）" },
    CPU_ZONE_RESCAN: { type: "int", min: 5, max: 3600, label: "CPU zone 全量重扫间隔（秒）",
      desc: "默认 60。按此间隔重新全量扫描，更新保留的最高温 zone 列表" },

    // ---- [2] 通用 ----
    RATE_LIMIT_FAN_UP: { type: "multi", fields: [{ label: "升速基础值", min: 50, max: 2000 }, { label: "升速倍率", min: 1, max: 200 }],
      label: "风扇升速限制", desc: "值 = 基础值 + d(0.1°C) × 倍率 / 10" },
    RATE_LIMIT_FAN_DOWN: { type: "multi", fields: [{ label: "每周期最大降速量", min: 50, max: 2000 }, { label: "降速防抖阈值", min: 0, max: 2000 }],
      label: "风扇降速限制 + 防抖阈值",
      desc: "每周期最大降速量；防抖阈值 0=不限制，距最低转速 < 阈值×1.5 时防抖失效" },
    RATE_LIMIT_COLD: { type: "multi", fields: [{ label: "基础值", min: 1, max: 194 }, { label: "倍率", min: 1, max: 100 }, { label: "上升死区", min: 1, max: 50 }],
      label: "制冷强度限速 + 上升死区",
      desc: "升速=base+dev×mult/10，降速=base-dev×mult/10；负值→0=禁止该方向；上升死区：制冷上升且变化量≤此值不下发" },
    RATE_LIMIT_TEMP: { type: "int", min: 1, max: 30, label: "目标温度限速（°C）",
      desc: "目标温度每周期最大变化量（智能温控模式）" },
    APP_LAUNCH_ENABLED: { type: "switch", label: "自动拉起散热器 app",
      desc: "无散热器 app 存活时自动拉起上次使用的 app" },
    APP_WATCHDOG: { type: "int", min: 0, max: 120, label: "锁死自动重启（次数）",
      desc: "实际制冷停滞（=上周期实际）且未达目标（≠上周期下发）连续 N 次下发时，kill 散热器 app 并重新拉起（散热器重启无效，需重建 App 进程）；0=关闭" },
    BATT_SKIP_MAX: { type: "int", min: 1, max: 60, label: "温度未变强制处理周期",
      desc: "温度值连续未变达 N 周期时强制进入一次计算，防止温度文件卡死控制停摆" },
    CTRL_MODE: { type: "switch", label: "控制模式", desc: "" },
    BATT_BASELINE: { type: "int", min: 300, max: 500, label: "基准温度（0.1°C）",
      desc: "电池温度与此值计算偏差，PID 和 Gear 共用" },
    COLD_MAP: { type: "multi", fields: [{ label: "起始强度", min: 0, max: 194 }, { label: "指数", min: 50, max: 500 }],
      label: "制冷映射（起始强度 + 指数）",
      desc: "起始强度：低于此值时线性外推下限；指数：n^exp（÷100，150=1.50），>1 低冷慢转" },
    HOT_MAP: { type: "multi", fields: [{ label: "最低温度", min: 200, max: 500 }, { label: "最高温度", min: 200, max: 500 }],
      label: "热端线性映射范围（0.1°C）",
      desc: "热端在此区间线性映射到风扇转速，超出取边界" },
    RPM_SMOOTH_ALPHA: { type: "int", min: 1, max: 99, label: "冷/热端→RPM 平滑系数（%）",
      desc: "冷端与热端共用，值越大越跟随原始值，越小越平滑" },
    FAN_RPM: { type: "multi", fields: [{ label: "最低转速", min: 1000, max: 6000 }, { label: "最高转速(B6X)", min: 1000, max: 6000 }, { label: "最高转速(B7X)", min: 2000, max: 6000 }],
      label: "风扇转速范围", desc: "最低转速 B6X最高转速 B7X最高转速" },
    HOT_DERATE: { type: "multi", fields: [{ label: "阈值(0.1°C)", min: 350, max: 700 }, { label: "倍率=恢复值", min: 1, max: 20 }, { label: "冷却周期数", min: 0, max: 20 }],
      label: "热端过温制冷上限削减",
      desc: "热端>阈值→每次削减上限(热端-阈值)×倍率；≤阈值→恢复倍率值；削减/恢复冷却独立，Gear 与 PID 共用" },

    // ---- [3] PID ----
    PID_KP: { type: "int", min: 1, max: 1000, label: "KP 比例增益(×1000)",
      desc: "P 项线性斜率，300=偏差3°满幅；无分段" },
    PID_KI: { type: "multi", fields: [{ label: "高基准基础增益", min: 0, max: 1000 }, { label: "高基准每°C增益", min: 0, max: 1000 }, { label: "低基准基础增益", min: 0, max: 1000 }, { label: "低基准每°C增益", min: 0, max: 1000 }],
      label: "KI 增益（V形：高基准基础/斜率 + 低基准基础/斜率）",
      desc: "高于基准累积制冷记忆（基础20+每°C20×error）；低于基准释放制冷记忆（基础50+每°C50×|error|）；建立慢、释放快，高基准受门控、低基准无条件" },
    PID_KI_MEM: { type: "multi", fields: [{ label: "下降惩罚", min: 0, max: 1000 }, { label: "固定衰减", min: 0, max: 1000 }, { label: "积分上限", min: 0, max: 1000 }],
      label: "KI 记忆（下降惩罚 + 固定衰减 + 上限）",
      desc: "下降惩罚：降温时每降1°C直接扣累计值；固定衰减：每周期向0收敛0.03始终生效；上限：I项最大输出防饱和，min(1-P-D, 此值)" },
    PID_KI_VAR: { type: "multi", fields: [{ label: "方差阈值", min: 0, max: 200 }, { label: "采样数", min: 2, max: 20 }, { label: "积分死区(0.1°C)", min: 0, max: 100 }],
      label: "KI 门控（方差阈值 + 采样数 + 死区）",
      desc: "阈值：温度方差低于此值则 I 项全段启用，0=退回仅死区模式；采样数：越多越滤波但响应越慢；死区：|偏差|<此值则启用 I 项" },
    PID_KD: { type: "multi", fields: [{ label: "上升倍率", min: 0, max: 1000 }, { label: "下降倍率", min: 0, max: 1000 }],
      label: "KD 微分（上升 + 下降倍率）",
      desc: "温度升高(de>0)用上升倍率、温度降低(de<0)用下降倍率；每周期每度每KD为0.001归一化输出" },
    PID_KD_MEM: { type: "multi", fields: [{ label: "记忆衰减(×1000)", min: 1, max: 1000 }, { label: "记忆幅值基础(×1000)", min: 1, max: 1000 }, { label: "幅值斜率(×1000/°C)", min: 1, max: 1000 }],
      label: "KD 记忆（衰减 + 幅值基础 + 斜率）",
      desc: "衰减：D记忆每周期向0收敛固定量（默认0.03）；幅值基础：D记忆对称钳位基准值；斜率：距基准温度每°C上限增加量；实际上限=基础+距基准°C×斜率" },
    PID_KD_NEAR: { type: "multi", fields: [{ label: "近区阈值(0.1°C)", min: 0, max: 100 }, { label: "近区倍率(×1000)", min: 1, max: 1000 }],
      label: "KD 近区降敏（阈值 + 倍率）",
      desc: "|de|<阈值视为近区（微抖），D项变化量×倍率降敏；默认2 333=0.2°C / 1/3，抑制微抖被微分放大导致制冷掉档" },
    PID_INPUT_FILTER: { type: "multi", fields: [{ label: "开启", min: 0, max: 1 }, { label: "自动关闭阈值", min: 5, max: 100 }, { label: "自动恢复阈值", min: 5, max: 100 }],
      label: "PID 输入滤波（开启 + 自动开关阈值）",
      desc: "默认开；温度更新间隔大于关闭阈值时自动关滤波，小于恢复阈值时自动恢复，×0.1 周期" },
    PID_ALPHA: { type: "multi", fields: [{ label: "更新间隔滤波强度(%)", min: 1, max: 100 }, { label: "电池温度滤波强度(%)", min: 1, max: 100 }],
      label: "滤波强度", desc: "更新间隔 / 电池温度两段滤波强度（预测滤波已迁到 Gear）" },
    PID_CPU_COMP: { type: "multi", fields: [{ label: "滤波系数(%)", min: 1, max: 100 }, { label: "除数", min: 5, max: 200 }, { label: "偏移量(0.1°C)", min: 0, max: 500 }],
      label: "CPU 补偿（滤波系数 + 除数 + 偏移量）",
      desc: "comp = clamp(cpu滤波−batt−偏移, 0)÷除数，按滤波系数 EMA 平滑；PID 与 Gear 共用、始终生效；偏移默认100=10°C" },
    PID_OUT_FILTER: { type: "multi", fields: [{ label: "开启", min: 0, max: 1 }, { label: "下限α(‰)", min: 1, max: 1000 }, { label: "温差增益(‰/0.1°)", min: 0, max: 1000 }, { label: "偏差增益(‰/0.1°)", min: 0, max: 500 }, { label: "下降倍率(×0.1)", min: 10, max: 100 }],
      label: "PID 输出端自适应滤波（开启 + 下限α + 温差增益 + 偏差增益 + 下降倍率）",
      desc: "α=温差×增益+偏差×增益，下限钳制到 base（最低0.1，先于下降倍率）；下降方向（目标<上次输出）α×下降倍率（×0.1，默认20=×2）回落更快；温差大快速跟随、稳态强滤波压抖；每周期推进，输出受制冷上升死区控制；默认 100 100 10 20" },
    PID_COLD: { type: "multi", fields: [{ label: "下限", min: 0, max: 194 }, { label: "上限(B6X)", min: 0, max: 194 }, { label: "上限(B7X)", min: 1, max: 190 }],
      label: "制冷强度范围", desc: "下限 B6X上限 B7X上限" },

    // ---- [4] Gear 电池 ----
    BATT_BOUNDARY: { type: "multi", fields: [{ label: "死区", min: 1, max: 100 }, { label: "±1档边界", min: 1, max: 100 }, { label: "±2档边界", min: 1, max: 100 }],
      label: "三区间阈值（0.1°C）", desc: "死区与 ±1/±2 档边界" },
    GEAR_PREDICT_WEIGHT: { type: "multi", fields: [{ label: "升温权重", min: 0, max: 10 }, { label: "降温权重", min: 0, max: 10 }, { label: "抑制系数(%)", min: 0, max: 100 }],
      label: "预测方向权重 + 抑制系数",
      desc: "升温默认10(全效)，降温默认5(半效)；抑制系数默认50=×0.5，0=完全抑制=停止；预测温度替代实际电池温度调档" },
    GEAR_PREDICT_WIN: { type: "multi", fields: [{ label: "缓冲区大小", min: 3, max: 32 }, { label: "最大计算窗口", min: 3, max: 10 }, { label: "最小计算窗口", min: 2, max: 5 }],
      label: "预测窗口", desc: "3~32 / 3~10 / 2~5" },
    GEAR_PREDICT_RISE: { type: "multi", fields: [{ label: "最大温升(0.1°C)", min: 10, max: 100 }, { label: "Ramp-up 周期数", min: 0, max: 10 }, { label: "最小起始delta(0.1°C/周期)", min: 1, max: 10 }],
      label: "预测上升限制", desc: "最大温升限制，最小启动周期，启动阈值（0.1°C）" },
    GEAR_PREDICT_ALPHA: { type: "int", min: 1, max: 100, label: "预测平滑系数(%)",
      desc: "预测温度 EMA 平滑，越大越跟随原始预测值" },
    BATT_COOLDOWN_CYCLES: { type: "int", min: 0, max: 20, label: "档位变动冷却周期",
      desc: "每次档位变动后冻结 N 周期 ×5 秒，紧急不受限" },
    CURRENT_GEAR_MODE: { type: "multi", fields: [{ label: "充电", min: 0, max: 1 }, { label: "放电", min: 0, max: 1 }],
      label: "电流-挡位映射开关", desc: "0=仅普通电池温度，1=电流映射推荐挡位" },
    CURRENT_GEAR_MULT: { type: "multi", fields: [{ label: "充电倍率", min: 1, max: 50 }, { label: "放电倍率", min: 1, max: 50 }],
      label: "电流映射倍率", desc: "推荐档位 = 滤波电流(0.01A) × 倍率 ÷ 100" },
    CURRENT_GEAR_SMOOTH_ALPHA: { type: "int", min: 1, max: 100, label: "电流滤波强度（%）",
      desc: "电流 EMA 平滑强度，越大越跟随原始值" },
    CURRENT_GEAR_MIN: { type: "int", min: 1, max: 12, label: "电流映射最低档位",
      desc: "推荐档位低于此值时回退到基准（电池温度）模式" },
    REV_COMP: { type: "multi", fields: [{ label: "反补", min: 0, max: 1 }, { label: "趋势豁免", min: 0, max: 1 }],
      label: "反补 + 趋势豁免开关", desc: "=0 禁用对应功能" },
    REV_COMP_T: { type: "multi", fields: [{ label: "阈值1", min: 1, max: 50 }, { label: "阈值2", min: 1, max: 50 }, { label: "阈值3", min: 1, max: 50 }],
      label: "反补三级阈值",
      desc: "默认 2 3 4 = 0.2°C/0.3°C/0.4°C 每周期" },
    REV_COMP_COOLDOWN: { type: "int", min: 0, max: 10, label: "反补冷却周期数",
      desc: "反补生效后冻结 N 周期" },
    TREND_RESET_THRESHOLD: { type: "int", min: 0, max: 20, label: "趋势豁免锚点复位阈值",
      desc: "以区间中值为偏移量计算复位阈值，越过则复位豁免计数器" },

    // ---- [5] Gear 紧急 ----
    EMERG_CPU_ENABLED: { type: "switch", label: "CPU 温度紧急开关", desc: "=0 禁用" },
    CPU_EMERG: { type: "multi", fields: [{ label: "退出紧急", min: 300, max: 700 }, { label: "进入1级", min: 400, max: 800 }, { label: "进入2级", min: 500, max: 900 }, { label: "进入3级", min: 600, max: 1000 }],
      label: "CPU 紧急阈值（0.1°C）",
      desc: "> 值1/2/3 → 进入紧急 1/2/3，< 值0/1/2 → 恢复到 0/1/2" },
    CPU_FILTER_ALPHA: { type: "int", min: 1, max: 100, label: "CPU 温度滤波强度（%）",
      desc: "越大越跟原始值，越小越滤波" },
    EMERG_MODE: { type: "multi", fields: [{ label: "进入(升档)", min: 0, max: 1 }, { label: "退出(降档)", min: 0, max: 1 }],
      label: "紧急干预模式", desc: "0=表查，1=步进" },
    EMERG_FORCED: { type: "multi", fields: [{ label: "等级1", min: 0, max: 12 }, { label: "等级2", min: 0, max: 12 }, { label: "等级3", min: 0, max: 12 }, { label: "等级4", min: 0, max: 12 }],
      label: "强制最低档位", desc: "各等级强制最低档位（1~4 级）" },
    EMERG_EXIT_CAP_OFFSET: { type: "int", min: 0, max: 5, label: "退出钳制偏移量",
      desc: "cap = 高一级最低档 + 此值，仅降档模式=0 生效" },
    EMERG_STEP: { type: "int", min: 1, max: 12, label: "升/降档步数", desc: "模式=1 时生效" },
    EMERG_EXIT_BATT_THRESHOLD: { type: "int", min: 5, max: 50, label: "紧急退出电池阈值",
      desc: "低于基准+此值 → 全效退出，×2 → 半效退出" },
    EMERG_RECOVERY_MULT: { type: "multi", fields: [{ label: "阶段1", min: 1, max: 20 }, { label: "阶段2", min: 1, max: 20 }, { label: "阶段3", min: 1, max: 20 }],
      label: "紧急退出恢复期倍率",
      desc: "退出紧急后调档阈值逐步恢复：×P1→×P2→×P3→1" },
    EMERG_RECOVERY_PHASE_CYCLES: { type: "int", min: 1, max: 50, label: "恢复阶段周期数",
      desc: "每阶段持续 N 周期" },

    // ---- [6] 档位表 ----
    GEAR_CONFIG_ENABLED: { type: "switch", label: "自定义档位表开关",
      desc: "=1 使用下方 GEAR_N，=0 使用代码默认表" },
    GEAR_AUTO_FAN: { type: "switch", label: "档位表自动风扇转速",
      desc: "=1 用冷端强度+热端温度双映射计算风扇转速，挡位表风扇转速变为截断上限；=0 直接使用配置风扇转速" }
  },

  // 档位表行格式：模式,目标温度(°C),风扇RPM,制冷强度
  gearRow: {
    fields: [
      { key: "mode", label: "模式", min: 0, max: 1, type: "int" },
      { key: "target", label: "目标°C", min: 5, max: 35, type: "int" },
      { key: "rpm", label: "风扇RPM", min: 2000, max: 6000, type: "int" },
      { key: "cold", label: "制冷", min: 1, max: 190, type: "int" }
    ],
    maxN: 32,
    defaultValue: "1,0,2000,5"
  }
};
