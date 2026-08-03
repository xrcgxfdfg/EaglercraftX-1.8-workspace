package me.eldodebug.soar.gui.modmenu.category.impl;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URL;

import me.eldodebug.soar.Glide;
import me.eldodebug.soar.gui.modmenu.GuiModMenu;
import me.eldodebug.soar.gui.modmenu.category.Category;
import me.eldodebug.soar.management.color.AccentColor;
import me.eldodebug.soar.management.color.ColorManager;
import me.eldodebug.soar.management.color.palette.ColorPalette;
import me.eldodebug.soar.management.color.palette.ColorType;
import me.eldodebug.soar.management.language.TranslateText;
import me.eldodebug.soar.management.nanovg.NanoVGManager;
import me.eldodebug.soar.management.nanovg.font.Fonts;
import me.eldodebug.soar.management.nanovg.font.LegacyIcon;
import me.eldodebug.soar.utils.mouse.MouseUtils;
import me.eldodebug.soar.utils.mouse.Scroll;

public class HomeCategory extends Category {

	public HomeCategory(GuiModMenu parent) {
		super(parent, TranslateText.HOME, LegacyIcon.HOME, false, false);
	}
	private Scroll changelogScroll = new Scroll();
	private Scroll newsScroll = new Scroll();

	@Override
	public void initGui() {
		changelogScroll.resetAll();
		newsScroll.resetAll();
	}

	Color onlineColour = new Color(85, 155, 89, 255);
	Color noColour = new Color(0, 0, 0, 0);

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		Glide instance = Glide.getInstance();
		NanoVGManager nvg = instance.getNanoVGManager();
		ColorManager colorManager = instance.getColorManager();
		ColorPalette palette = colorManager.getPalette();
		AccentColor currentColor = colorManager.getCurrentColor();
		int standardPadding = 8;
		int outerPadding = 15;

		// news
		int offsetNewsY = 0;
		nvg.drawRoundedRect(this.getX() + outerPadding, this.getY() + outerPadding, 200, 250, 8, palette.getBackgroundColor(ColorType.DARK));
		nvg.drawText(TranslateText.NEWS.getText(), this.getX() + outerPadding + 8, this.getY() + 15 + 8, palette.getFontColor(ColorType.DARK), 11F, Fonts.SEMIBOLD);

		nvg.save();
		nvg.scissor(this.getX() + outerPadding, this.getY() + outerPadding + 20, 200, 230);
		nvg.translate(0, newsScroll.getValue());

		String placeholder = TranslateText.NEWS.getText();
		float titleSize = nvg.getTextBoxHeight(placeholder, 10, Fonts.SEMIBOLD, 180);
		nvg.drawTextBox(placeholder, this.getX() + outerPadding + 8, this.getY() + 43F + offsetNewsY, 180, palette.getFontColor(ColorType.DARK), 10, Fonts.SEMIBOLD);
		offsetNewsY += (int) (titleSize + 9);
		nvg.restore();

		if(MouseUtils.isInside(mouseX, mouseY,this.getX() + outerPadding, this.getY() + outerPadding, 200, 250)) {newsScroll.onScroll();}
		newsScroll.onAnimation();
		newsScroll.setMaxScroll(Math.max(offsetNewsY - 225, 0));

		// shadow
		nvg.drawVerticalGradientRect(this.getX() + outerPadding + 8, this.getY() + outerPadding + 20, 200 - 16, 8, palette.getBackgroundColor(ColorType.DARK), noColour);
		nvg.drawVerticalGradientRect(this.getX() + outerPadding + 8, this.getY() + outerPadding +  250 - 8, 200 - 16, 8, noColour, palette.getBackgroundColor(ColorType.DARK));


		// Changelog

		int offsetChangelogY = 0;

		nvg.drawRoundedRect(this.getX() + 230, this.getY() + outerPadding, 174, 151, 8, palette.getBackgroundColor(ColorType.DARK));
		nvg.drawText(TranslateText.CHANGELOG.getText(), this.getX() + 230 + 8, this.getY() + 15 + 8, palette.getFontColor(ColorType.DARK), 11F, Fonts.SEMIBOLD);

		nvg.save();
		nvg.scissor(this.getX() + 230, this.getY() + outerPadding + 20, 174, 131);
		nvg.translate(0, changelogScroll.getValue());

		String changelogText = TranslateText.CHANGELOG.getText();
		float tbSize = nvg.getTextBoxHeight(changelogText, 8, Fonts.MEDIUM, 174 - 33);
		nvg.drawTextBox(changelogText, this.getX() + 230 + 25, this.getY() + 43F + offsetChangelogY, 174 - 33, palette.getFontColor(ColorType.DARK), 8, Fonts.MEDIUM);
		offsetChangelogY+= (int) (tbSize + 9);
		nvg.restore();
		if(offsetChangelogY > 130 && MouseUtils.isInside(mouseX, mouseY,this.getX() + 230, this.getY() + outerPadding, 174, 151)) {changelogScroll.onScroll();}
		changelogScroll.onAnimation();
		changelogScroll.setMaxScroll(Math.max(offsetChangelogY - 120, 0));

		nvg.drawVerticalGradientRect(this.getX() + 230 + 8, this.getY() + outerPadding + 20, 174 - 16, 8, palette.getBackgroundColor(ColorType.DARK), noColour);
		nvg.drawVerticalGradientRect(this.getX() + 230 + 8, this.getY() + outerPadding +  151 - 8, 174 - 16, 8, noColour, palette.getBackgroundColor(ColorType.DARK));


		// Discord
		int discordStartX = this.getX() + 230;
		int discordStartY = this.getY() + 179;
		int discordWidth = 174;
		//bg
		nvg.drawRoundedRect(discordStartX, discordStartY, discordWidth, 86, 8, palette.getBackgroundColor(ColorType.DARK));
		// Discord branding
		nvg.drawRoundedRectVarying(discordStartX + discordWidth - 22, discordStartY, 22, 22, 0, 8, 8, 0, new Color(114, 137, 214));
		nvg.drawCenteredText(LegacyIcon.DISCORD, discordStartX  + discordWidth - 11, discordStartY + 4, Color.WHITE, 14F, Fonts.LEGACYICON);
		// txt
		nvg.drawText(TranslateText.JOIN_OUR_DISCORD_SERVER.getText(), discordStartX + standardPadding, discordStartY + standardPadding, palette.getFontColor(ColorType.DARK), 11F, Fonts.SEMIBOLD);
		nvg.drawTextBox(TranslateText.DISCORD_DESCRIPTION.getText(), discordStartX + standardPadding, discordStartY + 26, discordWidth - 16, palette.getFontColor(ColorType.DARK), 8, Fonts.REGULAR);
		// stats
		nvg.drawRoundedRect(discordStartX + 10, discordStartY + 66, 6, 6, 3, onlineColour);
		nvg.drawRoundedGlow(discordStartX + 10, discordStartY + 66, 6, 6, 3, onlineColour, 7);
		nvg.drawTextGlowing("0 Members", discordStartX + 20, discordStartY + 62, onlineColour, 4, 8, Fonts.REGULAR);
		nvg.drawTextGlowing("0 Online", discordStartX + 20, discordStartY + 70, onlineColour, 4, 8, Fonts.REGULAR);
		// join button
		nvg.drawRoundedRect(discordStartX + discordWidth - 60, discordStartY + 60, 52, 18, 9,  new Color(114, 137, 214));
		nvg.drawCenteredText(TranslateText.JOIN.getText() + " >", discordStartX + discordWidth - 60 + (52 / 2), discordStartY + 66,  Color.WHITE, 7, Fonts.REGULAR);

	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		int discordStartX = this.getX() + 230;
		int discordStartY = this.getY() + 179;
			if(MouseUtils.isInside(mouseX, mouseY, discordStartX + 174 - 60, discordStartY + 60, 52, 18)) {
				try {
					Desktop.getDesktop().browse(new URL("https://glideclient.github.io/discord").toURI());
				} catch (Exception e) {}}
	}
}
