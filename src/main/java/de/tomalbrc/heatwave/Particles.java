package de.tomalbrc.heatwave;

import de.tomalbrc.heatwave.io.Json;
import de.tomalbrc.heatwave.io.ParticleEffectFile;
import de.tomalbrc.heatwave.util.ParticleModels;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Particles {
    public static final List<ParticleEffectFile> ALL = new ObjectArrayList<>();

    static {
        try {
            loadEffect("/particle/rainbow.json");
            loadEffect("/particle/bounce.json");
            loadEffect("/particle/snow.json");
            loadEffect("/particle/loading.json");
            loadEffect("/particle/trail.json");
            loadEffect("/particle/smoke.json");
            loadEffect("/particle/magic.json");

            loadEffect("/particle/rift.json");
            loadEffect("/particle/confetti.json");
            loadEffect("/particle/flame.json");
            loadEffect("/particle/combocurve.json");
            loadEffect("/particle/rain.json");
            loadEffect("/particle/event.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadEffect(String path) throws IOException {
        InputStream stream = Heatwave.class.getResourceAsStream(path);
        if (stream != null) {
            ParticleEffectFile effectFile = Json.GSON.fromJson(new InputStreamReader(stream), ParticleEffectFile.class);

            try {
                ParticleModels.addFrom(effectFile);
            } catch (MolangRuntimeException e) {
                throw new RuntimeException(e);
            }

            ALL.add(effectFile);
            return;
            //return effectFile;
        }
        throw new RuntimeException(String.format("Could not load particle file %s", path));
    }

    public static void init() {}
}
