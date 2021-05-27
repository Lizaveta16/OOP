package org.labs.paint;

import org.labs.paint.factory.ParentShapeFactory;
import org.labs.paint.shapes.ParentShape;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PluginLoader {

    public List<ParentShapeFactory> getAllFactories() {
        Path pluginsDir = Paths.get("core\\plugins");
        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        return ParentShapeFactory.getServices(layer);
    }

    public List<ParentShape> getAllShapes() {
        Path pluginsDir = Paths.get("core\\plugins");
        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        return ParentShape.getServices(layer);
    }
}
