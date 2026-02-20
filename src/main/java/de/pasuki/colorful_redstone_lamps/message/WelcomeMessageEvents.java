package de.pasuki.colorful_redstone_lamps.message;


import de.pasuki.colorful_redstone_lamps.ColorfulRedstoneLamps;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = ColorfulRedstoneLamps.MOD_ID)
public final class WelcomeMessageEvents {

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        ServerLevel overworld = player.server.overworld();
        WelcomeMessageData data = WelcomeMessageData.get(overworld);

        if (!data.wasShown()) {
            player.sendSystemMessage(
                    Component.translatable("colorful_redstone_lamps.welcome.title")
                            .withStyle(ChatFormatting.GOLD)
            );

            player.sendSystemMessage(
                    Component.translatable("colorful_redstone_lamps.welcome.body1")
                            .withStyle(ChatFormatting.GRAY)
            );

            player.sendSystemMessage(
                    Component.translatable("colorful_redstone_lamps.welcome.body2")
                            .withStyle(ChatFormatting.GRAY)
            );

            player.sendSystemMessage(
                    Component.translatable("colorful_redstone_lamps.welcome.body3")
                            .withStyle(style -> style
                                    .withColor(ChatFormatting.AQUA)
                                    .withUnderlined(true)
                                    .withClickEvent(new ClickEvent(
                                            ClickEvent.Action.OPEN_URL,
                                            "https://www.curseforge.com/minecraft/mc-mods/colorful-redstone-lamps/comments"
                                    ))
                            )
            );

            data.setShown();
        }
    }
}