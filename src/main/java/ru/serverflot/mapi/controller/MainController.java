package ru.serverflot.mapi.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import ru.serverflot.mapi.JsonReader;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    PaperRepository paperRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Paper> papers = paperRepository.findAll();
        model.addAttribute("papers", papers);
        return "home";
    }

    @GetMapping("/sort={sortOrder}")
    public String homeOrdered(@PathVariable String sortOrder, Model model) {
        Iterable<Paper> papers = paperRepository.findAll(Sort.by(Sort.Direction.ASC, sortOrder));
        model.addAttribute("papers", papers);
        return "home";
    }
    @GetMapping("/date={dateFilter}")
    public String homeFiltered(@PathVariable String dateFilter, Model model) {
        Iterable<Paper> papers = paperRepository.findAllBytradedate(dateFilter);
        model.addAttribute("papers", papers);
        return "home";
    }

    @GetMapping("/help")
    public String help(Model model) {
        model.addAttribute("title", "Help");
        return "help";
    }

    @GetMapping("/securities/{date}")
    public String getSecurities(@PathVariable String date, Model model) throws IOException, JSONException {
        JsonReader jsonReader = new JsonReader();
        JSONArray json = jsonReader.readJsonFromUrl("http://iss.moex.com/iss/history/engines/stock/markets/shares/boards/tqbr/securities.json?date=" + date + "&iss.meta=off&lang=RU&history.columns=SECID,SHORTNAME,TRADEDATE,NUMTRADES,OPEN,CLOSE&iss.json=extended");
        JSONObject json2 = json.getJSONObject(1);
        JSONArray json3 = json2.getJSONArray("history");

        for (int i = 0; i < json3.length(); i++)
        {
            try {
                JSONObject json4 = json3.getJSONObject(i);
                Paper paper = new Paper(json4.getString("SECID"),
                        json4.getString("SHORTNAME"),
                        json4.getString("SHORTNAME"),
                        json4.getString("TRADEDATE"),
                        json4.getInt("NUMTRADES"),
                        json4.getDouble("OPEN"),
                        json4.getDouble("CLOSE"));
                paperRepository.save(paper);
            } catch (Exception e) { System.out.println(e.getMessage()); };
        }

        return "redirect:/";
    }
}
