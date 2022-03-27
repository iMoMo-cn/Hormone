package com.momo.hormone.util.sound;

import com.momo.hormone.MoMoFramework;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModSoundHandler {
    //To add a sound, remember assets.mmf.sounds.json
    public static final List<ModSoundEvent> SOUNDS = new ArrayList<>();

//    public static SoundEvent SOUND_NAME = new ModSoundEvent("entity.moroon.ambient");

    public static void soundRegister()
    {
        ForgeRegistries.SOUND_EVENTS.registerAll(ModSoundHandler.SOUNDS.toArray(new SoundEvent[0]));
        MoMoFramework.Log("Registered %s sounds.", SOUNDS.size());
    }

}
