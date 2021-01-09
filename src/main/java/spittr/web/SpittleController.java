package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private SpittleRepository spittleRepository;

  @Autowired
  public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

  @RequestMapping(method=RequestMethod.GET)
  public String spittles(Model model){
    model.addAttribute("spittleList", spittleRepository.findSpittles(4,2));
    return "spittles";
  }
  @RequestMapping(value ="/find",method=RequestMethod.GET)
  public String spittles(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count,Model model) {
      model.addAttribute("spittleList",spittleRepository.findSpittles(max, count));
    return "spittles";
  }

  @RequestMapping(value ="/show",method=RequestMethod.GET)
  public String showSplittle(
          @RequestParam(value="spittleID") long spittleID,
        Model model) {
    //model.addAttribute("spittle",spittleRepository.findOne(spittleID));
    model.addAttribute(spittleRepository.findOne(spittleID));
    return "spittle";
  }
//
//  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
//  public String spittle(
//      @PathVariable("spittleId") long spittleId,
//      Model model) {
//    model.addAttribute(spittleRepository.findOne(spittleId));
//    return "spittle";
//  }

//  @RequestMapping(method=RequestMethod.POST)
//  public String saveSpittle(SpittleForm form, Model model) throws Exception {
//    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
//        form.getLongitude(), form.getLatitude()));
//    return "redirect:/spittles";
//  }

}
