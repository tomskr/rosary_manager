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
        int count;
        for(int x =0 ;x<=11;x++){
            count = (index +x +12)%20;
            if(count>=0&&count<5) {
                templateList.add(new Secret(template.get(count), "c-red"));
            }else if(count>=5&&count<10) {
                templateList.add(new Secret(template.get(count),"c-blue"));
            }else if(count>=10&&count<15) {
                templateList.add(new Secret(template.get(count)));
            }else if(count>=15&&count<20) {
                templateList.add(new Secret(template.get(count),"c-green"));
            }
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
