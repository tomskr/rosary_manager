package pl.tomskr.rosary_manager.service;

import pl.tomskr.rosary_manager.domain.RosarySecret;
import pl.tomskr.rosary_manager.domain.Secret;

import java.util.List;

public interface RosarySecretService {
    public List<Secret> secretList(String secret);
    public List<RosarySecret> secretOrder(List<RosarySecret> rosarySecrets);
}
