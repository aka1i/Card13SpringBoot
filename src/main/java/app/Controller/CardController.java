package app.Controller;

import app.Card;
import app.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yjn
 * @creatTime 2019/10/4 - 0:33
 */
@Controller
@RestController
public class CardController {

    @ResponseBody
    @RequestMapping("/hello")
    public String card(@RequestBody String str){
        List<Card> cards = new ArrayList<>();
//        cards.add(new Card(1,1));
//        cards.add(new Card(2,3));
//        cards.add(new Card(3,3));
//        cards.add(new Card(4,2));
//        cards.add(new Card(5,3));
//        cards.add(new Card(6,2));
//        cards.add(new Card(7,3));
//        cards.add(new Card(8,1));
//        cards.add(new Card(9,2));
//        cards.add(new Card(10,2));
//        cards.add(new Card(11,2));
//        cards.add(new Card(12,2));
//        cards.add(new Card(13,2));
        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = (JSONObject)jsonArray.get(i);
                cards.add(new Card(object.getInt("rank"),object.getInt("type")));
            }
            Player player = new Player();
            player.change(cards);
            JSONArray result = new JSONArray();
            for (int i = 0;i < player.choice.head.size(); i++){
                Card card = player.choice.head.get(i);
                JSONObject cardJson = new JSONObject();
                cardJson.put("type",card.getType());
                cardJson.put("rank",card.getRank());
                result.put(cardJson);
            }
            for (int i = 0;i < player.choice.mid.size(); i++){
                Card card = player.choice.mid.get(i);
                JSONObject cardJson = new JSONObject();
                cardJson.put("type",card.getType());
                cardJson.put("rank",card.getRank());
                result.put(cardJson);
            }
            for (int i = 0;i < player.choice.end.size(); i++){
                Card card = player.choice.end.get(i);
                JSONObject cardJson = new JSONObject();
                cardJson.put("type",card.getType());
                cardJson.put("rank",card.getRank());
                result.put(cardJson);
            }
            return result.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
}
