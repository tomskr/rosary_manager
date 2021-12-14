package pl.tomskr.rosary_manager.service;

import org.springframework.stereotype.Service;
import pl.tomskr.rosary_manager.domain.RosarySecret;
import pl.tomskr.rosary_manager.domain.Secret;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RosarySecretServiceImpl implements RosarySecretService{
    final List<String> template = Arrays.asList("I R","II R","III R","IV R","V R",
            "I S","II S","III S","IV S","V S",
            "I B","II B","III B","IV B","V B",
            "I CH","II CH","III CH","IV CH","V CH");
    @Override
    public List<Secret> secretList(String secret) {
        List<Secret> templateList = new LinkedList<>();
        int index =((Character.getNumericValue(secret.charAt(2))-1)*5)+Character.getNumericValue(secret.charAt(5))-1;

        for(int x =0 ;x<=11;x++){
        templateList.add(new Secret(template.get((index+x+12)%20)));
            System.out.println((index+x));
        }

        return templateList;
    }

    @Override
    public List<RosarySecret> secretOrder(List<RosarySecret> rosarySecrets) {
        int count = 0;
        List<RosarySecret> rosarySecretList = new LinkedList<>();
        for(int x = 0;x<=19;x++) {
            for (RosarySecret secret : rosarySecrets) {
                int index = template.indexOf(secret.getSecretCalendar().get(0).getName());
                if(index==x)
                rosarySecretList.add(index,secret);
            }
        }
        return rosarySecretList;
    }
}
