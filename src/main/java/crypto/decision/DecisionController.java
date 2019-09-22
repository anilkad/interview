package crypto.decision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecisionController {

    @Autowired
    DecisionService decisionService;


    @RequestMapping("/decide")
    public String decideWhatAssetToTrade() {
        return decisionService.decide();
    }
}
