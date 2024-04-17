package com.concordia.recordStore.controller;

import com.concordia.recordStore.service.RecordService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.concordia.recordStore.entity.Record;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/records")
public class RecordController {

//    private RecordService recordService;
//    public RecordController(RecordService theRecordService){
//        recordService = theRecordService;
//    }


    private List<Record> theRecords;

    @PostConstruct
    private void loadData() {

        // create records
        Record emp1 = new Record(1, "London Calling", "The Clash", "https://upload.wikimedia.org/wikipedia/en/thumb/0/00/TheClashLondonCallingalbumcover.jpg/220px-TheClashLondonCallingalbumcover.jpg", 20.00);
        Record emp2 = new Record(2, "Hits", "Pylon", "https://lastfm.freetls.fastly.net/i/u/ar0/f1b3a4d2241b4d4e9392126384ec41bd.jpg", 25.00);
        Record emp3 = new Record(3, "Loveless", "My Bloody Valentine", "https://upload.wikimedia.org/wikipedia/en/4/4b/My_Bloody_Valentine_-_Loveless.png", 18.00);
        Record emp4 = new Record(4, "Bleach", "Nirvana", "https://upload.wikimedia.org/wikipedia/en/thumb/a/a1/Nirvana-Bleach.jpg/220px-Nirvana-Bleach.jpg", 22.00);
        Record emp5 = new Record(5, "Unknown Pleasures", "Joy Division", "https://upload.wikimedia.org/wikipedia/en/5/5a/UnknownPleasuresVinyl.jpg", 24.00);
        Record emp6 = new Record(6, "Enter the Wu-Tang (36 Chambers)", "Wu-Tang Clan", "https://upload.wikimedia.org/wikipedia/en/5/53/Wu-TangClanEntertheWu-Tangalbumcover.jpg", 28.00);
        Record emp7 = new Record(7, "The Queen Is Dead", "The Smiths", "https://upload.wikimedia.org/wikipedia/en/e/ed/The-Queen-is-Dead-cover.png", 26.00);
        Record emp8 = new Record(8, "Rumours", "Fleetwood Mac", "https://upload.wikimedia.org/wikipedia/en/f/fb/FMacRumours.PNG", 30.00);
        Record emp9 = new Record(9, "The Velvet Underground and Nico", "Velvet Underground", "https://upload.wikimedia.org/wikipedia/en/0/0c/Velvet_Underground_and_Nico.jpg", 32.00);
        Record emp10 = new Record(10, "The Dark Side of the Moon", "Pink Floyd", "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png", 35.00);
        Record emp11 = new Record(11, "Stooges", "The Stooges", "https://upload.wikimedia.org/wikipedia/en/e/e6/StoogesStooges.jpg", 35.00);
        Record emp12 = new Record(12, "The Wall", "Pink Floyd", "https://upload.wikimedia.org/wikipedia/en/1/13/PinkFloydWallCoverOriginalNoText.jpg", 29.00);
        Record emp13 = new Record(13, "Abbey Road", "The Beatles", "https://upload.wikimedia.org/wikipedia/en/4/42/Beatles_-_Abbey_Road.jpg", 26.00);
        Record emp14 = new Record(14, "Led Zeppelin IV", "Led Zeppelin", "https://upload.wikimedia.org/wikipedia/en/2/26/Led_Zeppelin_-_Led_Zeppelin_IV.jpg", 31.00);
        Record emp15 = new Record(15, "Thriller", "Michael Jackson", "https://upload.wikimedia.org/wikipedia/en/5/55/Michael_Jackson_-_Thriller.png", 33.00);
        Record emp16 = new Record(15, "Ramones", "Ramones", "https://upload.wikimedia.org/wikipedia/en/b/bb/Ramones_-_Ramones_cover.jpg", 33.00);




        // create the list
        theRecords = new ArrayList<>();

        // add to the list
        theRecords.add(emp1);
        theRecords.add(emp2);
        theRecords.add(emp3);
        theRecords.add(emp4);
        theRecords.add(emp5);
        theRecords.add(emp6);
        theRecords.add(emp7);
        theRecords.add(emp8);
        theRecords.add(emp9);
        theRecords.add(emp10);
        theRecords.add(emp11);
        theRecords.add(emp12);
        theRecords.add(emp13);
        theRecords.add(emp14);
        theRecords.add(emp15);
        theRecords.add(emp16);



    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listRecords(Model theModel) {

        //get record from db
      //  List<Record> theRecords = recordService.findAll();


        // add to the spring model
        theModel.addAttribute("records", theRecords);

        return "list-records";
    }

    @GetMapping("/main")
    public String indexRecords(Model theModel) {

        //get record from db
       // List<Record> theRecords = recordService.findAll();


        // add to the spring model
        theModel.addAttribute("records", theRecords);

        return "main";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel){
        //create model attribute to bind form data
        Record theRecord = new Record();

        theModel.addAttribute("record", theRecord);

        return "record-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("recordId") int theId){

       // recordService.deleteById(theId);
        theRecords.removeIf(record -> record.getId() == theId);

        return "redirect:/records/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("recordId") int theId,
                                    Model theModel){

        // get the record from the service
     //   Record theRecord = recordService.findById(theId);
        Record theRecord = theRecords.stream()
                .filter(record -> record.getId() == theId)
                .findFirst()
                .orElse(null);

        // set record as a model attribute to pre-populate the form
        //theModel.addAttribute("record", theRecord);

        if (theRecord != null) {
            // Set the record as a model attribute to pre-populate the form
            theModel.addAttribute("record", theRecord);
        } else {
            // If the record with the given ID is not found, handle the error or redirect to an error page
            // For example: return "error-page";
        }

        // send over to our form
        return "record-form";
    }

    @PostMapping("/save")
    public String saveRecord(@ModelAttribute("record") Record theRecord) {
      //  recordService.save(theRecord);
        theRecords.add(theRecord);
        return "redirect:/records/list";
    }

    @PostMapping("/update")
    public String updateRecord(@ModelAttribute("record") Record updatedRecord) {
        for (int i = 0; i < theRecords.size(); i++) {
            if (theRecords.get(i).getId() == updatedRecord.getId()) {
                theRecords.set(i, updatedRecord); // Replace the existing record with the updated record
                break;
            }
        }
        return "redirect:/records/list";
    }


}