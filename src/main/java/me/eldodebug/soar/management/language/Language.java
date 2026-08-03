package me.eldodebug.soar.management.language;

import me.eldodebug.soar.utils.animation.simple.SimpleAnimation;
import net.minecraft.util.ResourceLocation;

public enum Language {
	JAPANESE("ja-jp", "\u65e5\u672c\u8a9e (\u65e5\u672c)", new ResourceLocation("soar/flag/ja.png")),
	CHINESE("zh-cn", "\u4e2d\u6587 (\u4e2d\u570b)", new ResourceLocation("soar/flag/cn.png")),
	ENGLISHGB("en-gb", "English (United Kingdom)", new ResourceLocation("soar/flag/gb.png")),
	ENGLISH("en-us", "English (United States)", new ResourceLocation("soar/flag/us.png")),
	FRENCH("fr-fr", "Fran\u00e7ais (France)", new ResourceLocation("soar/flag/fr.png")),
	SPANISH("es-es", "Espa\u00f1ol (Espa\u00f1a)", new ResourceLocation("soar/flag/es.png")),
	VIETNAMESE("vi-vn", "Ti\u1ebfng Vi\u1ec7t (Vi\u1ec7t Nam)", new ResourceLocation("soar/flag/vn.png")),
	RUSSIAN("ru-ru", "\u0440\u0443\u0441\u0441\u043a\u0438\u0439 (\u0440\u043e\u0441\u0441\u0438\u044f)", new ResourceLocation("soar/flag/ru.png")),
	PORTUGESE("pt-pt", "Portugu\u00eas (Portugal)", new ResourceLocation("soar/flag/pt.png")),
	PERSIAN("fa-ir", "F\u0101rsi (Ir\u0101n)", new ResourceLocation("soar/flag/ir.png")),
	LOLCAT("lc-koc", "LOLCAT (Kinduim ov catos)", new ResourceLocation("soar/flag/koc.png"));
	
	private SimpleAnimation animation = new SimpleAnimation();
	
	private String id;
	private String nameTranslate;
	private ResourceLocation flag;
	
	private Language(String id, String nameTranslate, ResourceLocation flag) {
		this.id = id;
		this.nameTranslate = nameTranslate;
		this.flag = flag;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return nameTranslate;
	}
	
	public ResourceLocation getFlag() {
		return flag;
	}

	public SimpleAnimation getAnimation() {
		return animation;
	}

	public String getNameTranslate() {
		return nameTranslate;
	}

	public static Language getLanguageById(String id) {
		
		for(Language lang : Language.values()) {
			if(lang.getId().equals(id)) {
				return lang;
			}
		}
		
		return Language.ENGLISHGB;
	}
}
