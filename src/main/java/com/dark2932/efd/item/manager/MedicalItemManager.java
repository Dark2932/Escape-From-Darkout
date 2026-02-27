package com.dark2932.efd.item.manager;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class MedicalItemManager {

    private int consumeThirst;
    private int useDuration = 32;
    private SoundEvent useSound = SoundEvents.PLAYER_BREATH;

    public int getConsumeThirst() {
        return consumeThirst;
    }

    public int getUseDuration() {
        return useDuration;
    }

    public SoundEvent getUseSound() {
        return useSound;
    }

    public MedicalItemManager consumeThirst(int thirst) {
        this.consumeThirst = thirst;
        return this;
    }

    public MedicalItemManager useDuration(int tick) {
        this.useDuration = tick;
        return this;
    }

    public MedicalItemManager useSound(SoundEvent sound) {
        this.useSound = sound;
        return this;
    }

}
