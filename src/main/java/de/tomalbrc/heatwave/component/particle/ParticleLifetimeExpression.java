package de.tomalbrc.heatwave.component.particle;

import com.google.gson.annotations.SerializedName;
import de.tomalbrc.heatwave.component.ParticleComponent;
import gg.moonflower.molangcompiler.api.MolangExpression;

public class ParticleLifetimeExpression implements ParticleComponent<ParticleLifetimeExpression> {
    @SerializedName("expiration_expression")
    public MolangExpression expirationExpression = MolangExpression.ZERO;
    @SerializedName("max_lifetime")
    public MolangExpression maxLifetime = MolangExpression.ZERO;
}
