package github.CiLuQwQ.playtime.client.mixin;

import java.time.Duration;
import java.time.LocalDateTime;

import github.CiLuQwQ.playtime.client.PlaytimeClient;
import net.minecraft.client.gui.DrawContext;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Mixin (GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {

    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("TAIL"), method = "render")
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {

        LocalDateTime current_time = LocalDateTime.now();
        Duration diff = Duration.between(PlaytimeClient.date_started,current_time);

        String draw = DurationFormatUtils.formatDuration(diff.toMillis(), "HH:mm:ss", true);
        context.drawTextWithShadow(this.textRenderer, draw, 8, 8, 16777215);
    }

}