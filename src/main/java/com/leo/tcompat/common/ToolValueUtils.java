package com.leo.tcompat.common;

import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.Tag;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;


public class ToolValueUtils {

    public static void addFloatValue(IToolStackView tool, ToolStatId id, float value) {
        if(!hasValue(tool, id, Tag.TAG_FLOAT)) {
            ToolValueUtils.uncheckedSetFloatValue(tool, id, value);
            return;
        }

        float base = ToolValueUtils.getFloatValue(tool, id);
        ToolValueUtils.uncheckedSetFloatValue(tool, id, base + value);
    }

    public static Float getFloatValue(IToolStackView tool, ToolStatId id) {
        return ((FloatTag) tool.getPersistentData().get(id)).getAsFloat();
    }

    public static boolean hasValue(IToolStackView tool, ToolStatId id, int type) {
        return tool.getPersistentData().contains(id, type);
    }

    public static boolean decreaseFloatValue(IToolStackView tool, ToolStatId id, float decrease) {
        if(!hasValue(tool, id, Tag.TAG_FLOAT)) return false;

        float base = ToolValueUtils.getFloatValue(tool, id);

        if(base < 0.05f) base = -1;
        ToolValueUtils.uncheckedSetFloatValue(tool, id, Math.max(base - decrease, 0));

        return !(base - decrease < 0);
    }

    public static void uncheckedSetFloatValue(IToolStackView tool, ToolStatId id, float value) {
        tool.getPersistentData().putFloat(id, Math.max(value, 0));
    }

    public static void addCappedFloatValue(IToolStackView tool, ToolStatId id, float value, float cap) {
        if (!ToolValueUtils.hasValue(tool, id, Tag.TAG_FLOAT)) {
            ToolValueUtils.uncheckedSetFloatValue(tool, id, Math.min(value, cap));
            return;
        }

        Float base = ToolValueUtils.getFloatValue(tool, id);
        ToolValueUtils.uncheckedSetFloatValue(tool, id, Math.min(base + value, cap));
    }
}
