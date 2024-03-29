package com.momo.hormone;

import com.momo.hormone.gui.ModGuiElementLoader;
import com.momo.hormone.init.*;
import com.momo.hormone.keys.KeyboardManager;
import com.momo.hormone.network.NetworkHandler;
import com.momo.hormone.proxy.ProxyBase;
import com.momo.hormone.recipe.ModRecipe;
import com.momo.hormone.init.ModOreDict;
import com.momo.hormone.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

//dependencies = "required-after:Forge@[14.23.5.2705,)"
@Mod(modid = MoMoFramework.MODID, name = MoMoFramework.NAME)
public class MoMoFramework {
    public static final String MODID = "hormone";
    public static final String NAME = "Hormone";
    public static final String VERSION = "1.4.5";

    public static Logger logger;

    public static final boolean SHOW_WARN = true;

    @Mod.Instance
    public static MoMoFramework instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static ProxyBase proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        if (MODID.equals("untitled"))
        {
            logger.error("Please change your mod id in the main class.");
            
        }

        if (Reference.CLIENT_PROXY_CLASS.indexOf("somebody.idlframewok.proxy.ClientProxy") > 0)
        {
            logger.warn("Have you changed your package name to author and modname?");
            
        }

        RegistryHandler.preInitRegistries(event);

    }

    @EventHandler
    public static void Init(FMLInitializationEvent event) {

        ModRecipe.init();
        ModOreDict.init();

        RegistryHandler.initRegistries(event);

        new ModGuiElementLoader();
        if (!proxy.isServer())
        {
            KeyboardManager.init();
        }
        NetworkHandler.init();

		LogWarning("%s has finished its initializations", MODID);

	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Moved Spawning registry to last since forge doesn't auto-generate sub
        // "M' biomes until late
        if (ModConfig.SPAWN_CONF.SPAWN) {
            ModSpawn.registerSpawnList();
        }

        TrashTalking();

        RegistryHandler.postInitReg();
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }


    private void TrashTalking() {
        MoMoFramework.Log("[Idealland Framework] Made with MoMoFramework.");
    }

    public static void LogWarning(String str, Object... args) {
        if (SHOW_WARN) {
            logger.warn(String.format(str, args));
        }
    }

    public static void LogWarning(String str) {
        if (SHOW_WARN) {
            logger.warn(str);
        }
    }

    public static void Log(String str) {
//        if (ModConfig.GeneralConf.LOG_ON)
//        {
        logger.info(str);
//        }
    }

    public static void Log(String str, Object... args) {
//        if (ModConfig.GeneralConf.LOG_ON)
//        {
        logger.info(String.format(str, args));
//        }
    }

}